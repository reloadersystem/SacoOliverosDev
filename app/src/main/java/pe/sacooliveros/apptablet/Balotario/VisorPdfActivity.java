package pe.sacooliveros.apptablet.Balotario;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Cybergrafia;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

public class VisorPdfActivity extends AppCompatActivity {

    private static final String TAG = "PDFDatos";
    static String PREFS_KEY = "autenticacionOff";

    String urlcode;
    String viewType;
    TextView tv_tomoletraspdft3;
    String password = "Reloader";
    String tema;
    PDFView pdfView;
    ConnectionDetector cd;
    Integer pageNumber = 0;
    Integer pagecontador = 0;
    @NotEmpty

    ImageView img_fullscreen, img_prev, img_next, zoomout, zoomin, index, miniature, btn_cibergafia;
    ProgressBar progresbar;
    PDFView pdfViewfull;

    InputStream inputStream;
    String rutafile;
    String estadoconec;

    RelativeLayout lnLayout;
    int selectitem;

    String numeropagina;


    static String paginainicio;

    String ruta_storage;

    MenuInflater inflater;

    MenuItem shareItem;




    public static String obtenerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_pdf);
        setTitle("");

        lnLayout = findViewById(R.id.lnSerIndiceMainActivity);
        tv_tomoletraspdft3 = findViewById(R.id.tv_tomoletraspdft3);
        pdfView = findViewById(R.id.pdfViewletraspdft3);

        progresbar = findViewById(R.id.progresbart3);

        cd = new ConnectionDetector(this);

        ruta_storage = getApplicationContext().getString(R.string.ruta_raiz);

        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tema = bundle.getString("Materia");
            urlcode = bundle.getString("URL");
            viewType = bundle.getString("ViewType");
            rutafile = bundle.getString("SSDFILE");
            estadoconec = bundle.getString("EstadoConexion");
        }

        {
            switch (viewType) {
                case "storage":
                    File file = new File(rutafile);
                    Integer pageNumber = 0;
                    pdfView.fromFile(file).defaultPage(pageNumber)
                            .password(password)
                            .swipeHorizontal(true)
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {
                                    int contadorpag = pdfView.getPageCount();
                                    int currentpage = pdfView.getCurrentPage();
                                    // setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), contadorpag));
                                    setTitle(tema);
                                }
                            })
                            .enableAntialiasing(true)
                            .load();
                    progresbar.setVisibility(View.GONE);
                    break;
                case "internet":
                    EjecucionInternet();
                    break;
                case "asset":
                    Toast.makeText(getApplicationContext(), "asset", Toast.LENGTH_SHORT).show();
                    break;
            }
        }


    }


    private void EjecucionInternet() {

        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                .load(urlcode)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                .password(password)
                                .defaultPage(pageNumber)
                                .enableDoubletap(true)
                                .swipeHorizontal(true)
                                .spacing(0)
                                .onRender(new OnRenderListener() {   // visualizar  3 , 4 paginas en miniatura landscape
                                    @Override
                                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                        pdfView.fitToWidth(pdfView.getCurrentPage());
                                    }
                                })
                                .onDraw(new OnDrawListener() {
                                    @Override
                                    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    }
                                })
                                .onPageError(new OnPageErrorListener() {
                                    @Override
                                    public void onPageError(int page, Throwable t) {
                                        Toast.makeText(VisorPdfActivity.this, "error" + page, Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        pageNumber = page;
                                        pagecontador = pageCount;
                                        setTitle(tema);
                                    }
                                })
                                .onTap(new OnTapListener() {
                                    @Override
                                    public boolean onTap(MotionEvent e) {
                                        return true;
                                    }
                                })
                                .onRender(new OnRenderListener() {
                                    @Override
                                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                        pdfView.fitToWidth();
                                    }
                                })
                                .enableAntialiasing(true)
                                .invalidPageColor(Color.WHITE)
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        //Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(VisorPdfActivity.this, "Conexión baja intente mas  tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }


    private void fullScreenInternet() {
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                .load(urlcode)
                .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfViewfull.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(true)
                                .defaultPage(pdfView.getCurrentPage())
                                .enableAntialiasing(true)
                                .load();
                        pdfViewfull.zoomWithAnimation((float) 0.9);

                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        //Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(VisorPdfActivity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menupdf, menu);
//        return true;


        inflater = getMenuInflater();
        inflater.inflate(R.menu.menupdf, menu);

        shareItem = menu.findItem(R.id.action_reload);


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();


//            cibergrafiaPanelDialog().show();

        if (id == R.id.action_reload) {


            if (cd.isConnected()) {

                File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                deleteRecursive(filecache);
                shareItem.setVisible(false);

//                EjecucionInternet();

                progresbar.setVisibility(View.VISIBLE);
                FileLoader.with(this)
                        .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                        .load(urlcode)
                        .asFile(new FileRequestListener<File>() {
                            @Override
                            public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                                progresbar.setVisibility(View.GONE);
                                File pdfFile = fileResponse.getBody();
                                pdfView.fromFile(pdfFile)
                                        .password(password)
                                        .defaultPage(pageNumber)
                                        .enableDoubletap(true)
                                        .swipeHorizontal(true)
                                        .spacing(0)
                                        .onRender(new OnRenderListener() {   // visualizar  3 , 4 paginas en miniatura landscape
                                            @Override
                                            public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                                pdfView.fitToWidth(pdfView.getCurrentPage());
                                            }
                                        })
                                        .onDraw(new OnDrawListener() {
                                            @Override
                                            public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                            }
                                        })
                                        .onPageError(new OnPageErrorListener() {
                                            @Override
                                            public void onPageError(int page, Throwable t) {
                                                Toast.makeText(VisorPdfActivity.this, "error" + page, Toast.LENGTH_SHORT).show();
                                            }
                                        })
                                        .onPageChange(new OnPageChangeListener() {
                                            @Override
                                            public void onPageChanged(int page, int pageCount) {
                                                pageNumber = page;
                                                pagecontador = pageCount;
                                                setTitle(tema);
                                            }
                                        })
                                        .onTap(new OnTapListener() {
                                            @Override
                                            public boolean onTap(MotionEvent e) {
                                                return true;
                                            }
                                        })
                                        .onRender(new OnRenderListener() {
                                            @Override
                                            public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                                pdfView.fitToWidth();
                                            }
                                        })
                                        .enableAntialiasing(true)
                                        .invalidPageColor(Color.WHITE)
                                        .onLoad(new OnLoadCompleteListener() {
                                            @Override
                                            public void loadComplete(int nbPages) {

                                                shareItem.setVisible(true);
                                            }
                                        })
                                        .load();
                            }

                            @Override
                            public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                                //Toast.makeText(ViewTomo3Activity.this, "Pruebe mas  tarde" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                Toast.makeText(VisorPdfActivity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();

                                progresbar.setVisibility(View.GONE);
                                shareItem.setVisible(true);
                            }
                        });


            } else {
                Toast.makeText(this, "Estas sin conexión", Toast.LENGTH_SHORT).show();
            }

        }


        if (id == R.id.action_opcionDpdf) {
            String dato = obtenerValor(getApplicationContext(), "EMail");
            String dato1 = obtenerValor(getApplicationContext(), "ServerGradoNivel");
            String dato2 = obtenerValor(getApplicationContext(), "SedeUsuario");
            String dato3 = obtenerValor(getApplicationContext(), "URLPhoto");
            String dato4 = obtenerValor(getApplicationContext(), "MatriculaServer");
            String dato5 = obtenerValor(getApplicationContext(), "NombreUsuario");
            String dato6 = obtenerValor(getApplicationContext(), "Acceso");

            if (dato1.equalsIgnoreCase("6 Primaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Primaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("1 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("2 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("3 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("4 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }

            if (dato1.equalsIgnoreCase("601 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, CiclosEspeciales.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);

            }

            if (dato1.equalsIgnoreCase("701 Secundaria")) {
                Intent intent = new Intent(VisorPdfActivity.this, CiclosEspeciales.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);

            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    private class onGo implements TextView.OnEditorActionListener {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_GO) {
                Toast.makeText(getApplicationContext(), "datos", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        }
    }

    class RetrievePDFStreamFull extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (UnknownHostException e) {
                Log.e("ConexionError", e.toString());
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfViewfull.fromStream(inputStream)
                    .password(password)
                    .swipeHorizontal(true)
                    .defaultPage(pdfView.getCurrentPage())
                    .enableAntialiasing(true)
                    .load();

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


    public AlertDialog cibergrafiaPanelDialog() {
        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogcibergrafia, null);


        ArrayList<M_Cybergrafia> elements = new ArrayList<>();

//        Lista= new ArrayList<M_Cybergrafia>();
//        final adapter_Cibergrafia adapter= new adapter_Cibergrafia(getApplicationContext(),elements);
//        gridcibergrafia.setAdapter(adapter);
//        adapter.notifyDataSetChanged();

        //builder.setView(v);
        alertDialog = builder.create();
        alertDialog.dismiss();
        return alertDialog;
    }


    public static void instantiate(String servernivel) {
        paginainicio = servernivel; //2 "primaria
    }

    private static String PREF_URL = "urlOnOffline";

    public static void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREF_URL, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();
    }


    static String PREF_URLGET = "autenticacionOff";

    public static String obtenerValorURL(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREF_URLGET, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }


    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }


}