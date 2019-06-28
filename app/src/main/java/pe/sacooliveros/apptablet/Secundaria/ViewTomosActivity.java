package pe.sacooliveros.apptablet.Secundaria;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.shockwave.pdfium.PdfDocument;

import java.util.List;

import pe.sacooliveros.apptablet.R;

public class ViewTomosActivity extends AppCompatActivity implements Validator.ValidationListener, View.OnClickListener, OnPageChangeListener, OnLoadCompleteListener, OnPageErrorListener {

    //String SAMPLE_FILE;
    private static final String TAG = "PDFDatos";
    String titulo, tema,assetpdf;
    TextView tv_viewtomo;
    PDFView pdfView;




    FrameLayout frminiatura;
    String pdfFileName;
    Integer pageNumber = 0;
    Integer pagecontador = 0;

    Context contexto;

    @NotEmpty
    EditText edtbuscar;

    ImageView img_buscar, img_fullscreen, img_prev, img_next, zoomout, zoomin, index, miniature, img_goback;

    Validator validator;

    ProgressBar progresbar;

    PDFView pdfViewminiatura;

    int habilitar = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tomo2);

        tv_viewtomo = findViewById(R.id.tv_tomoletraspdft3);

        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            titulo = bundle.getString("Tomo");
            tema = bundle.getString("Materia");
            assetpdf=bundle.getString("AssetPDF");
            tv_viewtomo.setText(titulo + " " + tema);

        }

        //SAMPLE_FILE = assetpdf;


        pdfView = findViewById(R.id.pdfViewletraspdft1);

        pdfViewminiatura = findViewById(R.id.pdfViewminiaturat1);

        frminiatura = findViewById(R.id.fr_vminiaturat1);

        edtbuscar = findViewById(R.id.edt_buscarletraspdft1);
        img_buscar = findViewById(R.id.img_buscarletraspdft3);
        img_fullscreen = findViewById(R.id.img_fullscreenletraspdft1);
        img_prev = findViewById(R.id.img_prevletraspdft1);
        img_next = findViewById(R.id.img_nextletraspdft1);
        index = findViewById(R.id.img_indicepdft1);

        miniature = findViewById(R.id.img_miniaturet1);

        img_goback = findViewById(R.id.img_gobackt3);


        zoomin = findViewById(R.id.img_zoominletraspdft1);
        zoomout = findViewById(R.id.img_zoomoutletraspdft1);

        progresbar = findViewById(R.id.progresbart1);


        //displayFromAsset(SAMPLE_FILE);

        displayFromAsset(assetpdf);


        img_buscar.setOnClickListener(this);
        img_prev.setOnClickListener(this);
        img_next.setOnClickListener(this);
        zoomin.setOnClickListener(this);
        zoomout.setOnClickListener(this);
        index.setOnClickListener(this);
        miniature.setOnClickListener(this);
        img_goback.setOnClickListener(this);


        img_fullscreen.setOnClickListener(this);

        validator = new Validator(this);
        validator.setValidationListener(this);



    }

    private void displayFromAsset(String assetFileName) {






        pdfFileName = assetFileName;
        pdfView.fromAsset(assetpdf)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableDoubletap(true)
                .swipeHorizontal(true)
                .enableAnnotationRendering(true)
//                .onRender(new OnRenderListener() {   // visualizar  3 , 4 paginas en miniatura landscape
//                    @Override
//                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
//                        pdfView.fitToWidth(pdfView.getCurrentPage());
//                    }
//                })
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(0)
                .onPageError(this)
                .enableAntialiasing(true) // mejora  calidad de  imagen
                .password(null)
                .enableAnnotationRendering(true)
                .load();
    }

    @Override
    public void onValidationSucceeded() {



        int dato = Integer.parseInt(edtbuscar.getText().toString());


        int numpag = pdfView.getPageCount(); // # de paginas en total

        if (dato <= numpag) {


            //pdfView.fromAsset(SAMPLE_FILE)
            pdfView.fromAsset(assetpdf)
                    .defaultPage(dato - 1)
                    .swipeHorizontal(true)
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {

                            int currentpage = pdfView.getCurrentPage();
                            setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));

                        }
                    })
                    .load();


        } else {
            Toast.makeText(getApplicationContext(), "Ingrese  un valor Existente", Toast.LENGTH_SHORT).show();


        }

    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError("ingrese un valor");
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            /*pdfView.fitToWidth(pdfView.getCurrentPage());

            .onRender(new OnRenderListener() {   // visualizar  3 , 4 paginas en miniatura landscape
                @Override
                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                    pdfView.fitToWidth(pdfView.getCurrentPage());
                }
            })*/
            Toast.makeText(getApplicationContext(), "Orientacion horizontal", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.img_buscarletraspdft3:
                validator.validate();
                break;


            case R.id.img_prevletraspdft1:

                int prevpage = pdfView.getCurrentPage();

                //pdfView.fromAsset(SAMPLE_FILE)
                pdfView.fromAsset(assetpdf)
                        .defaultPage(prevpage - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));
                            }
                        })
                        .load();


                break;

            case R.id.img_nextletraspdft1:

                int nextpage = pdfView.getCurrentPage();

                //pdfView.fromAsset(SAMPLE_FILE)
                pdfView.fromAsset(assetpdf)
                        .defaultPage(nextpage + 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));
                            }
                        })
                        .load();

                break;


            case R.id.img_zoominletraspdft1:


                float max= pdfView.getMaxZoom();
                pdfView.zoomWithAnimation(max);


                break;

            case R.id.img_zoomoutletraspdft1:

                float min= pdfView.getMinZoom();
                pdfView.zoomWithAnimation(min);


                break;


            case R.id.img_fullscreenletraspdft1:


                createCustomDialog().show();

                break;


            case R.id.img_indicepdft1:


                createIndexDialog().show();

                break;


            case R.id.img_gobackt3:

                Toast.makeText(getApplicationContext(), "go back", Toast.LENGTH_SHORT).show();




                break;


            case R.id.img_miniaturet1:


                if (habilitar == 0) {
                    frminiatura.setVisibility(view.VISIBLE);

                    //pdfViewminiatura.fromAsset(SAMPLE_FILE)
                    pdfViewminiatura.fromAsset(assetpdf)
                            .defaultPage(0)
                            .swipeHorizontal(false)
                            .load();

                    pdfViewminiatura.zoomWithAnimation((float) 0.8);

                    habilitar = habilitar + 1;


                    pdfViewminiatura.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {


                            int miniaturapage = pdfViewminiatura.getCurrentPage();


                            pdfView.fromAsset(assetpdf)
                            //pdfView.fromAsset(SAMPLE_FILE)

                                    .defaultPage(miniaturapage)
                                    .swipeHorizontal(true)
                                    .onPageChange(new OnPageChangeListener() {
                                        @Override
                                        public void onPageChanged(int page, int pageCount) {

                                            int currentpage = pdfView.getCurrentPage();
                                            setTitle(String.format("%s / %s", tema + "- Page " + (currentpage + 1), pagecontador));


                                        }
                                    })

                                    .load();


                        }
                    });


                } else {
                    if (habilitar == 1) {
                        frminiatura.setVisibility(view.GONE);
                        habilitar = habilitar - 1;

                    }

                }


                break;


        }


    }

    @Override
    public void onPageChanged(int page, int pageCount) {

        pageNumber = page;
        pagecontador = pageCount;
        //setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pagecontador));
        setTitle(String.format("%s / %s", tema + " - Page " + page, pagecontador));

    }

    @Override
    public void loadComplete(int nbPages) {


        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        Log.e(TAG, "title = " + meta.getTitle());
        Log.e(TAG, "author = " + meta.getAuthor());
        Log.e(TAG, "subject = " + meta.getSubject());
        Log.e(TAG, "keywords = " + meta.getKeywords());
        Log.e(TAG, "creator = " + meta.getCreator());
        Log.e(TAG, "producer = " + meta.getProducer());
        Log.e(TAG, "creationDate = " + meta.getCreationDate());
        Log.e(TAG, "modDate = " + meta.getModDate());

        printBookmarksTree(pdfView.getTableOfContents(), "-");

        progresbar.setVisibility(View.GONE);

    }

    private void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {

        for (PdfDocument.Bookmark b : tree) {

            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));

            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }


    }


    @Override
    public void onPageError(int page, Throwable t) {

        Log.e(TAG, "Cannot load page " + page);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menupdf, menu);
        //getMenuInflater().inflate(R.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


       /* if (id == R.id.action_opcionBpdf) {

            Toast.makeText(this,"zoom in",Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_opcionCpdf) {
            Toast.makeText(this,"zoom out",Toast.LENGTH_SHORT).show();
            return true;
        }*/


        if (id == R.id.action_opcionDpdf) {

            Intent intent= new Intent(ViewTomosActivity.this,NavActivity.class );
            startActivity(intent);



            return true;
        }





        return super.onOptionsItemSelected(item);
    }


    public AlertDialog createCustomDialog() {

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.dialogfullscreen, null);


        PDFView pdfViewfull = v.findViewById(R.id.pdfViewfull);


        int currentpage = pdfView.getCurrentPage();


        //pdfViewfull.fromAsset(SAMPLE_FILE)
        pdfViewfull.fromAsset(assetpdf)
                .swipeHorizontal(true)
                .defaultPage(currentpage)
                .load();


        builder.setView(v);
        alertDialog = builder.create();

        alertDialog.dismiss();


        return alertDialog;

    }

    public AlertDialog createIndexDialog() {

        AlertDialog alertDialog = null;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_index_pdf, null);

        RelativeLayout opcion1 = v.findViewById(R.id.pag_op1);
        RelativeLayout opcion2 = v.findViewById(R.id.pag_op2);
        RelativeLayout opcion3 = v.findViewById(R.id.pag_op3);
        RelativeLayout opcion4 = v.findViewById(R.id.pag_op4);
        RelativeLayout opcion5 = v.findViewById(R.id.pag_op5);
        RelativeLayout opcion6 = v.findViewById(R.id.pag_op6);
        RelativeLayout opcion7 = v.findViewById(R.id.pag_op7);


        builder.setView(v);
        alertDialog = builder.create();

        //Dialog dialog= builder.create();
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams wmlp2 = alertDialog.getWindow().getAttributes();
        wmlp2.gravity = Gravity.TOP | Gravity.LEFT;
        wmlp2.x = 1;
        //255
        wmlp2.y = 300;


        final AlertDialog finalAlertDialog = alertDialog;


        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 7;


                //pdfView.fromAsset(SAMPLE_FILE)
                pdfView.fromAsset(assetpdf)
                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 19;

                //pdfView.fromAsset(SAMPLE_FILE)

                pdfView.fromAsset(assetpdf)
                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 30;

                //pdfView.fromAsset(SAMPLE_FILE)

                pdfView.fromAsset(assetpdf)
                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 45;

               // pdfView.fromAsset(SAMPLE_FILE)

                pdfView.fromAsset(assetpdf)

                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 56;

                //pdfView.fromAsset(SAMPLE_FILE)
                pdfView.fromAsset(assetpdf)

                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s", tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 68;

                //pdfView.fromAsset(SAMPLE_FILE)
                pdfView.fromAsset(assetpdf)
                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s",  tema + " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        opcion7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int pag = 83;

                //pdfView.fromAsset(SAMPLE_FILE)

                pdfView.fromAsset(assetpdf)
                        .defaultPage(pag - 1)
                        .swipeHorizontal(true)
                        .onPageChange(new OnPageChangeListener() {
                            @Override
                            public void onPageChanged(int page, int pageCount) {

                                int currentpage = pdfView.getCurrentPage();
                                setTitle(String.format("%s / %s",tema +  " - Page " + (currentpage + 1), pagecontador));


                            }
                        })
                        .load();

                finalAlertDialog.dismiss();


            }
        });


        return alertDialog;


    }



}

