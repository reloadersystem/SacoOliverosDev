package pe.sacooliveros.apptablet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
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
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.shockwave.pdfium.PdfDocument;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.Secundaria.Adapter.Adapter_Indice;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Cybergrafia;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Indice;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;
import pe.sacooliveros.apptablet.ServidorIndice.SConsultIndice;
import pe.sacooliveros.apptablet.ServidorIndice.WebServiceIndice;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

public class ViewTomo3Activity extends AppCompatActivity implements View.OnClickListener, Validator.ValidationListener {
    private static final String TAG = "PDFDatos";
    static String PREFS_KEY = "autenticacionOff";
    static String cibergrafiadata;
    String urlcode;
    String viewType;
    TextView tv_tomoletraspdft3;
    String password = "Reloader";
    String tema;
    PDFView pdfView;
    ConnectionDetector cd;
    FrameLayout frminiatura, fr_vindice, fr_cibergrafia;
    Integer pageNumber = 0;
    Integer pagecontador = 0;
    GridView gridcibergrafia;
    @NotEmpty
    EditText edtbuscar;
    ImageView img_fullscreen, img_prev, img_next, zoomout, zoomin, index, miniature, btn_cibergafia;
    Validator validator;
    ProgressBar progresbar;
    PDFView pdfViewminiatura;
    PDFView pdfViewfull;
    int habilitar = 0;

    int cibergrafiacount = 0;
    InputStream inputStream;
    String rutafile;
    String estadoconec;
    int miniaturedato;
    RelativeLayout lnLayout;

    Adapter_Indice iadapter;

    int selectitem;

    String numeropagina;

    String notaurl;

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
        setContentView(R.layout.activity_view_tomo3);

        setTitle("");

        lnLayout = findViewById(R.id.lnSerIndiceMainActivity);
        tv_tomoletraspdft3 = findViewById(R.id.tv_tomoletraspdft3);
        pdfView = findViewById(R.id.pdfViewletraspdft3);
        pdfViewminiatura = findViewById(R.id.pdfViewminiaturat3);
        frminiatura = findViewById(R.id.fr_vminiaturat3);

        btn_cibergafia = findViewById(R.id.btn_cibergafia);

        fr_cibergrafia = findViewById(R.id.fr_cibergrafia);
        gridcibergrafia = findViewById(R.id.lv_cibergrafia);

        img_fullscreen = findViewById(R.id.img_fullscreenletraspdft3);
        img_prev = findViewById(R.id.img_prevletraspdft3);
        img_next = findViewById(R.id.img_nextletraspdft3);

        index = findViewById(R.id.img_indicepdft3);

        fr_vindice = findViewById(R.id.fr_vindice);
        miniature = findViewById(R.id.img_miniaturet3);
        zoomin = findViewById(R.id.img_zoominletraspdft3);
        zoomout = findViewById(R.id.img_zoomoutletraspdft3);
        progresbar = findViewById(R.id.progresbart3);

        cd = new ConnectionDetector(this);
        img_prev.setOnClickListener(this);
        img_next.setOnClickListener(this);
        zoomin.setOnClickListener(this);
        zoomout.setOnClickListener(this);
        index.setOnClickListener(this);
        miniature.setOnClickListener(this);
        lnLayout = findViewById(R.id.lnSerIndiceMainActivity);
        img_fullscreen.setOnClickListener(this);
        validator = new Validator(this);
        validator.setValidationListener(this);


        final EditText edittext = (EditText) findViewById(R.id.edt_buscarletraspdft3);


        edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {

                    String keyboardtext = String.valueOf(edittext.getText());

                    topagina(keyboardtext);

                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(edittext.getWindowToken(), 0);


                    return true;
                }
                return false;
            }
        });


        final ListView lvView = findViewById(R.id.lvIndice);

        ArrayList<M_Indice> elements = new ArrayList<>();

        iadapter = new Adapter_Indice(this, R.layout.item_indice, elements);
        lvView.setAdapter(iadapter);

        ruta_storage = getApplicationContext().getString(R.string.ruta_raiz);


        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tema = bundle.getString("Materia");
            urlcode = bundle.getString("URL");
            viewType = bundle.getString("ViewType");
            rutafile = bundle.getString("SSDFILE");
            estadoconec = bundle.getString("EstadoConexion");
        }

        if (cd.isConnected()) {

            if (!(urlcode == null)) {
                WebServiceIndice.urlvisor(urlcode);
            }
        }

        guardarValor(getApplicationContext(), "URLData", urlcode);


        tv_tomoletraspdft3.setText(tema);

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

        SConsultIndice consult = new SConsultIndice();
        consult.setCurrentContext(this);
        consult.setCurrentLayout(lnLayout);
        consult.execute("");

        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                selectitem = position;

                M_Indice mindice = (M_Indice) adapterView.getItemAtPosition(position);

                numeropagina = mindice.getPagina();

                movertopagina();

                fr_vindice.setVisibility(View.GONE);

                habilitar = habilitar - 1;


            }
        });

        btn_cibergafia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fr_cibergrafia.setVisibility(View.VISIBLE);

                if (cd.isConnected()) {

                    if (!(urlcode == null)) {
                        WebServiceIndice.urlvisor(urlcode);

                        SConsultIndice consult = new SConsultIndice();
                        consult.setCurrentContext(getApplicationContext());
                        consult.setCurrentLayout(lnLayout);
                        consult.execute("");
                    }
                }

                if (cibergrafiacount == 0) {
                    fr_cibergrafia.setVisibility(view.VISIBLE);
                    cibergrafiacount = cibergrafiacount + 1;
                } else {
                    if (cibergrafiacount == 1) {
                        fr_cibergrafia.setVisibility(view.GONE);
                        cibergrafiacount = cibergrafiacount - 1;
                    }
                }
            }
        });


        gridcibergrafia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                M_Cybergrafia m_cybergrafia = (M_Cybergrafia) adapterView.getItemAtPosition(position);

                notaurl = m_cybergrafia.getUrl();

                Uri uri = Uri.parse(notaurl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

                fr_cibergrafia.setVisibility(view.INVISIBLE);
                cibergrafiacount = cibergrafiacount - 1;

                //tODO Seleccionando un item de la  Cibergrafia

            }
        });
    }


    private void topagina(String keyboardtext) {

        final String data = keyboardtext;

        final int pdfcontador = pdfView.getPageCount(); //numero de  paginas de un pdf


        final int totalpag = Integer.parseInt(String.valueOf(pdfcontador)) + Integer.parseInt(paginainicio);


        if (cd.isConnected()) {
            progresbar.setVisibility(View.VISIBLE);

            FileLoader.with(this)
                    .load(urlcode)
                    .asFile(new FileRequestListener<File>() {
                        @Override
                        public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                            progresbar.setVisibility(View.GONE);

                            String num = String.valueOf(Integer.parseInt(data) - Integer.parseInt(paginainicio) + 2);

                            File pdfFile = fileResponse.getBody();
                            pdfView.fromFile(pdfFile)
                                    .password(password)
                                    .swipeHorizontal(true)
                                    .defaultPage(Integer.parseInt(num))
                                    .enableAntialiasing(true)
                                    .onPageChange(new OnPageChangeListener() {
                                        @Override
                                        public void onPageChanged(int page, int pageCount) {

                                            setTitle(String.format("%s / %s ", tema + " - Pág " + paginainicio, totalpag));

                                            //setTitle(tema);
                                        }
                                    })
                                    .load();

                        }

                        @Override
                        public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
//                            Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(ViewTomo3Activity.this, "Conexiòn baja intente mas  tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                            progresbar.setVisibility(View.GONE);
                        }
                    });
        } else

        {


            String num = String.valueOf(Integer.parseInt(data) - Integer.parseInt(paginainicio) + 2);
            File file = new File(rutafile);
            pdfView.fromFile(file).defaultPage(Integer.parseInt(num))
                    .password(password)
                    .swipeHorizontal(true)
                    .enableAntialiasing(true)
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {

                            setTitle(String.format("%s / %s ", tema + " - Pág " + paginainicio, totalpag));
                        }
                    })

                    .load();
            progresbar.setVisibility(View.GONE);
        }

    }


    private void movertopagina() {

        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                //       .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(true)
                                .defaultPage(Integer.parseInt(numeropagina) - 1)
                                .enableAntialiasing(true)
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        int currentpage = pdfView.getCurrentPage();

                                        //setTitle(String.format("%s / %s", tema + " - Page " + (numeropagina), pagecontador));
                                        setTitle(tema);
                                    }
                                })
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        //Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(ViewTomo3Activity.this, "Conexiòn baja intente mas  tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    private void EjecucionInternet() {


        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
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
                                        Toast.makeText(ViewTomo3Activity.this, "error" + page, Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(ViewTomo3Activity.this, "Conexiòn baja intente mas  tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.img_buscarpagina:
//
//                String keyboardtext = String.valueOf(Integer.parseInt(edtbuscar.getText().toString()));
//                topagina(keyboardtext);
//
//               // validator.validate();
//                break;
            case R.id.img_prevletraspdft3:
                if (cd.isConnected()) {
                    previouspagepdf();
                } else {
                    prevSinConex();
                }
                break;
            case R.id.img_nextletraspdft3:
                if (cd.isConnected()) {
                    nextinternetpdf();
                } else {
                    nextSinConex();
                }
                break;
            case R.id.img_zoominletraspdft3:
                float max = pdfView.getMaxZoom();
                pdfView.zoomWithAnimation(max);
                break;
            case R.id.img_zoomoutletraspdft3:
                float min = pdfView.getMinZoom();
                pdfView.zoomWithAnimation(min);
                break;
            case R.id.img_fullscreenletraspdft3:
                if (cd.isConnected()) {


                    createCustomDialog().show();
                } else {
                    createCustomDialogSinConec().show();
                }
                break;

            case R.id.img_indicepdft3:


                if (cd.isConnected()) {

                    if (viewType.equalsIgnoreCase("storage")) {
                        if (!(urlcode == null)) {
                            WebServiceIndice.urlvisor(urlcode);

                            SConsultIndice consult = new SConsultIndice();
                            consult.setCurrentContext(this);
                            consult.setCurrentLayout(lnLayout);
                            consult.execute("");
                        }
                    }
                }


                if (paginainicio == "1") {


                } else if (habilitar == 0) {

                    fr_vindice.setVisibility(view.VISIBLE);
                    habilitar = habilitar + 1;

                } else if (habilitar == 1) {

                    fr_vindice.setVisibility(view.GONE);
                    habilitar = habilitar - 1;
                }


                break;

            case R.id.img_gobackt3:
                Toast.makeText(getApplicationContext(), "go back", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_miniaturet3:
                if (habilitar == 0) {
                    frminiatura.setVisibility(view.VISIBLE);
                    if (cd.isConnected()) {
                        miniaturaview();
                        habilitar = habilitar + 1;
                        pdfViewminiatura.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                miniatureSelect();
                                frminiatura.setVisibility(view.GONE);
                                habilitar = habilitar - 1;
                            }
                        });
                    } else {
                        File file = new File(rutafile);
                        pdfViewminiatura.fromFile(file)
                                .defaultPage(0)
                                .password(password)
                                .swipeHorizontal(false)
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        int contadorpag = pdfView.getPageCount();
                                        int currentpage = pdfView.getCurrentPage();
                                        //setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), contadorpag));
                                        setTitle(tema);

                                    }
                                })
                                .enableAntialiasing(true)
                                .load();
                        habilitar = habilitar + 1;
                        pdfViewminiatura.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                miniaturedato = pdfViewminiatura.getCurrentPage();
                                File file = new File(rutafile);
                                pdfView.fromFile(file)
                                        .defaultPage(miniaturedato)
                                        .password(password)
                                        .swipeHorizontal(true)
                                        .onPageChange(new OnPageChangeListener() {
                                            @Override
                                            public void onPageChanged(int page, int pageCount) {
                                                int contadorpag = pdfView.getPageCount();
                                                int currentpage = pdfView.getCurrentPage();
                                                //setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), contadorpag));
                                                setTitle(tema);

                                            }
                                        })
                                        .enableAntialiasing(true)
                                        .load();
                                frminiatura.setVisibility(view.GONE);
                                habilitar = habilitar - 1;
                            }
                        });
                    }
                } else {
                    if (habilitar == 1) {
                        frminiatura.setVisibility(view.GONE);
                        habilitar = habilitar - 1;
                    }
                }
                break;
        }
    }

    private void miniatureSelect() {
        final int miniaturanumero = pdfViewminiatura.getCurrentPage();
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(true)
                                .defaultPage(miniaturanumero)
                                .enableAntialiasing(true)
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        int currentpage = pdfView.getCurrentPage();
                                        //setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));
                                        setTitle(tema);
                                    }
                                })
                                .load();


                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        // Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(ViewTomo3Activity.this, "Conexión baja intente mas  tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }


    private void previouspagepdf() {
        final int currentpage = pdfView.getCurrentPage();
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(true)
                                .defaultPage(currentpage - 1)
                                .enableAntialiasing(true)
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        int currentpage = pdfView.getCurrentPage();
                                        // setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));
                                        setTitle(tema);
                                    }
                                })
                                .load();


                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    private void nextinternetpdf() {
        final int currentpage = pdfView.getCurrentPage();
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(true)
                                .defaultPage(currentpage + 1)
                                .enableAntialiasing(true)
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        int currentpage = pdfView.getCurrentPage();
                                        //setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));
                                        setTitle(tema);
                                    }
                                })
                                .load();


                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    private void miniaturaview() {
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                //   .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfViewminiatura.fromFile(pdfFile)
                                .password(password)
                                .swipeHorizontal(false)
                                .defaultPage(pdfView.getCurrentPage())
                                .enableAntialiasing(true)
                                .load();
                        pdfViewminiatura.zoomWithAnimation((float) 1.2);


                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        // Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(ViewTomo3Activity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
                        progresbar.setVisibility(View.GONE);
                    }
                });
    }

    private AlertDialog createCustomDialogSinConec() {
        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogfullscreen, null);
        pdfViewfull = v.findViewById(R.id.pdfViewfull);
        int currentpage = pdfView.getCurrentPage();
        File file = new File(rutafile);
        pdfViewfull.fromFile(file)
                .password(password)
                .defaultPage(currentpage)
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

        builder.setView(v);
        alertDialog = builder.create();
        alertDialog.dismiss();
        return alertDialog;
    }

    private void nextSinConex() {
        int nextpage = pdfView.getCurrentPage();
        File file = new File(rutafile);
        pdfView.fromFile(file)
                .password(password)
                .defaultPage(nextpage + 1)
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


    }

    private void prevSinConex() {
        int prevpage = pdfView.getCurrentPage();
        File file = new File(rutafile);
        pdfView.fromFile(file)
                .password(password)
                .defaultPage(prevpage - 1)
                .enableAntialiasing(true)
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
                .load();


    }

    @Override
    public void onValidationSucceeded() {
//        String keyboardtext = String.valueOf(Integer.parseInt(edtbuscar.getText().toString()));
//
//        topagina(keyboardtext);
//        int dato = Integer.parseInt(edtbuscar.getText().toString());
//        int numpag = pdfView.getPageCount(); // # de paginas en total
//        if (dato <= numpag) {
//            if (cd.isConnected()) {
//                pdfdeInicio();
//            } else {
//                File file = new File(rutafile);
//                pdfView.fromFile(file)
//                        .password(password)
//                        .defaultPage(dato - 1)
//                        .swipeHorizontal(true)
//                        .enableAntialiasing(true)
//                        .onPageChange(new OnPageChangeListener() {
//                            @Override
//                            public void onPageChanged(int page, int pageCount) {
//                                int contadorpag = pdfView.getPageCount();
//                                int currentpage = pdfView.getCurrentPage();
//                               // setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), contadorpag));
//                                setTitle(tema);
//                            }
//                        })
//                        .load();
//
//
//            }
//        } else {
//            Toast.makeText(getApplicationContext(), "Ingrese  un valor Existente", Toast.LENGTH_SHORT).show();
//        }
    }


    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if (view instanceof EditText) {
                ((EditText) view).setError("ingrese un valor");
            } else {
                // Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                Toast.makeText(ViewTomo3Activity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {
            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));
            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }

    public AlertDialog createCustomDialog() {
        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogfullscreen, null);
        pdfViewfull = v.findViewById(R.id.pdfViewfull);
        fullScreenInternet();
        builder.setView(v);
        alertDialog = builder.create();
        alertDialog.dismiss();
        return alertDialog;
    }


    private void fullScreenInternet() {
        progresbar.setVisibility(View.VISIBLE);
        FileLoader.with(this)
                .load(urlcode)
                //    .fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
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
                        Toast.makeText(ViewTomo3Activity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();
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
                                                Toast.makeText(ViewTomo3Activity.this, "error" + page, Toast.LENGTH_SHORT).show();
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
                                Toast.makeText(ViewTomo3Activity.this, "Conexión baja intente mas tarde o presione Actualizar", Toast.LENGTH_SHORT).show();

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
                Intent intent = new Intent(ViewTomo3Activity.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Primaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("1 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("2 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("3 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("4 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }

            if (dato1.equalsIgnoreCase("601 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, CiclosEspeciales.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);

            }

            if (dato1.equalsIgnoreCase("701 Secundaria")) {
                Intent intent = new Intent(ViewTomo3Activity.this, CiclosEspeciales.class);
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
        gridcibergrafia = v.findViewById(R.id.lstcibergrafia);

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

    public static void instantiate2(String linksdata) {
        cibergrafiadata = linksdata; //2 "primaria
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