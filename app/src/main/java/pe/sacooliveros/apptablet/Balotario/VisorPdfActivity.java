package pe.sacooliveros.apptablet.Balotario;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

import static android.os.Environment.getExternalStorageDirectory;

public class VisorPdfActivity extends AppCompatActivity {

    private static final String TAG = "PDFDatos";
    static String PREFS_KEY = "autenticacionOff";

    String urlcode;
    String viewType;
    String password = "Reloader";
    String tema;
    PDFView pdfView;
    ConnectionDetector cd;
    Integer pageNumber = 0;
    Integer pagecontador = 0;
    ProgressBar progresbar;
    String rutafile;
    String estadoconec;
    static String paginainicio;
    String ruta_storage;
    MenuInflater inflater;
    MenuItem shareItem;
    String ssdtablet;

    private FirebaseAnalytics mFirebaseAnalytics;

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

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        if (cd.isConnected()) {
            Bundle params = new Bundle();
            params.putInt("ID_VisorActivity", R.id.cl_visorpdfactivity);
            mFirebaseAnalytics.logEvent("ActVisorBalotarios", params);
        }


        pdfView = findViewById(R.id.pdfViewletraspdft3);
        progresbar = findViewById(R.id.progresbart3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cd = new ConnectionDetector(this);

        ruta_storage = getApplicationContext().getString(R.string.ruta_raiz);

        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tema = bundle.getString("Materia");
            urlcode = bundle.getString("URL");
            viewType = bundle.getString("ViewType");
            rutafile = bundle.getString("SSDFILE");
            estadoconec = bundle.getString("EstadoConexion");
            ssdtablet = bundle.getString("ssdtablet");
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


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Configure su impresora para previsualizar", Snackbar.LENGTH_LONG)
//                        .setAction("Impresión", null).show();

                PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
                {
                    String printpdf = Environment.getExternalStorageDirectory() + "/PDFiles/" + ssdtablet;
                    PrintDocumentAdapter printAdapter = new PdfDocumentAdapter(getApplicationContext(), printpdf);
                    printManager.print(ssdtablet, printAdapter, new PrintAttributes.Builder().build());
                }


            }
        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
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
                        Toast.makeText(VisorPdfActivity.this, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menupdf, menu);
//        return true;


        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_printbalotario, menu);

        shareItem = menu.findItem(R.id.action_reload);


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_reload) {

            if (cd.isConnected()) {

                File filecachepdf = new File(getExternalStorageDirectory() + "/PDFiles/" + ssdtablet);
                boolean deleted = filecachepdf.delete();
                shareItem.setVisible(false);

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
                                Toast.makeText(VisorPdfActivity.this, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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