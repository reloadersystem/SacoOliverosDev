package pe.sacooliveros.apptablet.Balotario;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.RecyclerBalotariosAdapter;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.os.Environment.getExternalStorageDirectory;
import static java.lang.Thread.sleep;

public class contentVisorActivity extends AppCompatActivity {

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
    ProgressBar progresbar;
    String rutafile;
    String estadoconec;
    RelativeLayout lnLayout;
    static String paginainicio;
    String ruta_storage;
    MenuInflater inflater;
    MenuItem shareItem;
    String ssdtablet;
    ConstraintLayout cl_popupmessage;

    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };
    private View mControlsView;
    private final Runnable mShowPart2Runnable = new Runnable() {
        @Override
        public void run() {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.show();
            }
        }
    };
    private boolean mVisible;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            show();
        }
    };

    private final View.OnTouchListener mDelayHideTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS);
            }
            return false;
        }
    };

    public static String obtenerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_visor);

        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tema = bundle.getString("Materia");
            urlcode = bundle.getString("URL");
            viewType = bundle.getString("ViewType");
            rutafile = bundle.getString("SSDFILE");
            estadoconec = bundle.getString("EstadoConexion");
            ssdtablet = bundle.getString("ssdtablet");
        }

        mVisible = true;
        mContentView = findViewById(R.id.fullscreen_content);
        pdfView = findViewById(R.id.fullscreen_content);

        progresbar = findViewById(R.id.progresbart3);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        cd = new ConnectionDetector(this);

        ruta_storage = getApplicationContext().getString(R.string.ruta_raiz);

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


        cl_popupmessage= findViewById(R.id.cl_popupmessage);

        final Animation myAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_transition_animation);

        cl_popupmessage.setAnimation(myAnim);

        cl_popupmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cl_popupmessage.setVisibility(View.INVISIBLE);
            }
        });

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
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
        });*/


        final FloatingActionsMenu floatingActionsMenu = findViewById(R.id.menu_flbBalotarios);

        FloatingActionButton floatingImprimir = findViewById(R.id.flb_imprimir);
        floatingImprimir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PrintManager printManager = (PrintManager) getSystemService(Context.PRINT_SERVICE);
                {
                    String printpdf = Environment.getExternalStorageDirectory() + "/PDFiles/" + ssdtablet;
                    PrintDocumentAdapter printAdapter = new PdfDocumentAdapter(getApplicationContext(), printpdf);
                    printManager.print(ssdtablet, printAdapter, new PrintAttributes.Builder().build());
                }
                floatingActionsMenu.collapse();
            }
        });

        FloatingActionButton floatingDescargar = findViewById(R.id.flb_descargar);
        floatingDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String urlADescargar = urlcode;
                descargarPDF(urlADescargar);

                floatingActionsMenu.collapse();
            }
        });

        FloatingActionButton floatingRecargar = findViewById(R.id.flb_recargar);
        floatingRecargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cd.isConnected()) {

                    File filecachepdf = new File(getExternalStorageDirectory() + "/PDFiles/" + ssdtablet);
                    boolean deleted = filecachepdf.delete();
                    shareItem.setVisible(false);

                    progresbar.setVisibility(View.VISIBLE);
                    FileLoader.with(getApplicationContext())
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
                                                    Toast.makeText(contentVisorActivity.this, "error" + page, Toast.LENGTH_SHORT).show();
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
                                    Toast.makeText(contentVisorActivity.this, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();

                                    progresbar.setVisibility(View.GONE);
                                    shareItem.setVisible(true);
                                }
                            });


                } else {
                    Toast.makeText(getApplicationContext(), "Estas sin conexión", Toast.LENGTH_SHORT).show();
                }
                floatingActionsMenu.collapse();
            }
        });


        mContentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggle();
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        delayedHide(100);
    }

    private void toggle() {
        if (mVisible) {
            hide();
        } else {
            show();
        }
    }

    private void hide() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        mVisible = false;
        mHideHandler.removeCallbacks(mShowPart2Runnable);
        mHideHandler.postDelayed(mHidePart2Runnable, UI_ANIMATION_DELAY);
    }

    @SuppressLint("InlinedApi")
    private void show() {
        mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        mVisible = true;
        mHideHandler.removeCallbacks(mHidePart2Runnable);
        mHideHandler.postDelayed(mShowPart2Runnable, UI_ANIMATION_DELAY);
    }

    private void delayedHide(int delayMillis) {
        mHideHandler.removeCallbacks(mHideRunnable);
        mHideHandler.postDelayed(mHideRunnable, delayMillis);
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
                                        Toast.makeText(contentVisorActivity.this, "error" + page, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(contentVisorActivity.this, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();
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

        if (id == R.id.action_share) {
            Uri uri = Uri.fromFile(new
                    File(getExternalStorageDirectory() + "/PDFiles/" + ssdtablet));

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("application/pdf");

            String printemailname = ShareDataRead.obtenerValor(getApplicationContext(), "EMail");

            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{printemailname});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Saco Oliveros");
            intent.putExtra(Intent.EXTRA_TEXT, "Plataforma Virtual - " + ssdtablet);
            intent.putExtra(Intent.EXTRA_STREAM, uri);
            startActivity(Intent.createChooser(intent, "Enviar e-mail mediante:"));
        }


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
                                                Toast.makeText(contentVisorActivity.this, "error" + page, Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(contentVisorActivity.this, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();

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
                Intent intent = new Intent(contentVisorActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("2 Secundaria")) {
                Intent intent = new Intent(contentVisorActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("3 Secundaria")) {
                Intent intent = new Intent(contentVisorActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("4 Secundaria")) {
                Intent intent = new Intent(contentVisorActivity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Secundaria")) {
                Intent intent = new Intent(contentVisorActivity.this, NavActivity.class);
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


    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Descargando PDF...");

        new DescargarPDFAsynTask(progressDialog).execute(urlADescargar);
    }

    private class DescargarPDFAsynTask extends AsyncTask<String, Integer, String> {

       // ProgressDialog progressDialog;

        public DescargarPDFAsynTask(ProgressDialog progressDialog) {
          //  this.progressDialog = progressDialog;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

           // progressDialog.show();
        }

        @Override
        protected String doInBackground(String... urlPDF) {

            HttpURLConnection conexion = null;
            InputStream input = null;
            OutputStream output = null;

            //ruta_storage = context.getString(R.string.ruta_raiz);
            ///data/user/0/pe.sacooliveros.apptablet/files

            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexión no realizada correctamente";
                }

                input = conexion.getInputStream();


                //todo  falta nombre...

                String rutaficheroGuardado = Environment.getExternalStorageDirectory() + "/SacoOliveros/" + tema + ".pdf";

                output = new FileOutputStream(rutaficheroGuardado);

                int tamanoFichero = conexion.getContentLength();

                byte[] data = new byte[3072];
                int count;
                int total = 0;


                while ((count = input.read(data)) != -1) {

                    sleep(1);
                    output.write(data, 0, count);

                    total += count;
                    publishProgress((int) (total * 100 / tamanoFichero));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                //return "Error: " + e.getMessage();
                return "Error: " + "Intente otra vez";
            } catch (IOException e) {
                e.printStackTrace();
                return "Sin Conexión";
            }
            //cerrando la carpeta una vez que termino
            catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (input != null) input.close();
                    //cerrando conexion progress
                    if (output != null) output.close();
                    if (conexion != null) conexion.disconnect();

                   // progressDialog.dismiss();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return "Se realizó Correctamente";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            //%de descarga
            super.onProgressUpdate(values);

//            progressDialog.setIndeterminate(false);
//            progressDialog.setMax(100);
//            progressDialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);

            Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
          //  progressDialog.dismiss();
            //Tiempo estimado
        }
    }
}
