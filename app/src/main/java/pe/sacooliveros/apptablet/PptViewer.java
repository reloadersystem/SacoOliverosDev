package pe.sacooliveros.apptablet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;

public class PptViewer extends AppCompatActivity {

    WebView webview;
    ProgressBar progressBar;
    //String url= "http://aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/DIAPOSITIVAS/TOMO08/2DO/BIOLOGIA/CAPITULO23/";
    String url= "";

    String materia;

    TextView tx_materiappt;

    ImageView imageView;

    RelativeLayout toolbar_saco;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_springppt);

        webview= findViewById(R.id.id_webspring);

        tx_materiappt= findViewById(R.id.tx_materiappt);
        imageView=findViewById(R.id.home_primaria);
        toolbar_saco=  findViewById(R.id.toolbar_saco);


        if(getIntent()!=null && getIntent().getExtras()!=null){
            Bundle bundle= this.getIntent().getExtras();

            url=bundle.getString("URL");
            materia= bundle.getString("Materia");

        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(getApplicationContext(), NavigatorPrimaria.class);

                startActivity(intent);

            }
        });


        webview.getSettings().setJavaScriptEnabled(true);

        //tx_materiappt.setText("SEC/PPT/TOMO08/2DO/BIOLOGIA/CAPITULO23");
        tx_materiappt.setText(materia);


       webview.getSettings().setLoadWithOverviewMode(true);
       webview.getSettings().setDefaultZoom(WebSettings.ZoomDensity.FAR);
       webview.getSettings().setUseWideViewPort(true); // presenta
       webview.getSettings().getDisplayZoomControls();
       webview.getSettings().setDisplayZoomControls(true);
       webview.getSettings().setSupportZoom (true);


       webview.setInitialScale(10);
       webview.canGoBack ();
       webview.loadUrl(url);
       webview.setWebChromeClient(new WebChromeClient());
       webview.setWebViewClient(new WebViewClient()

            {



            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
//                if(url.contains("javascript:") || url.contains("aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/DIAPOSITIVAS/TOMO08/2DO/BIOLOGIA/CAPITULO23/")) {
//                    view.loadUrl(url);
//                } else {
//                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                    view.getContext().startActivity(i);
//                }
//                return true;



                if (!url.contains(url))
                {
                    setDesktopMode(webview, true);
                    view.loadUrl(url);
                }
                return false;
             }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                //setTitle("Loading...");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                view.loadUrl("javascript:var footer = document.getElementById(\"footer\"); footer.parentNode.removeChild(footer); var header = document.getElementById(\"header-full\"); header.parentNode.removeChild(header);");


            }

        });



        webview.clearHistory();
        webview.clearFormData();
        webview.clearCache(true);
        webview.loadUrl(url);




    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            //Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();

            //webview.getSettings().setUseWideViewPort(false); //
           // getSupportActionBar().hide();


            imageView.setVisibility(View.GONE);
            toolbar_saco.setVisibility(View.GONE);
            Toast.makeText(this, "deslize la imagen para visualizar  contenido", Toast.LENGTH_SHORT).show();



        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

           // webview.getSettings().setUseWideViewPort(true);
            //getSupportActionBar().hide();
            //Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();

            imageView.setVisibility(View.VISIBLE);
            toolbar_saco.setVisibility(View.VISIBLE);

        }
    }


    public void setDesktopMode(WebView webview,boolean enabled) {
        String newUserAgent = webview.getSettings().getUserAgentString();
        if (enabled) {
            try {
                String ua = webview.getSettings().getUserAgentString();
                String androidOSString = webview.getSettings().getUserAgentString().substring(ua.indexOf("("), ua.indexOf(")") + 1);
                newUserAgent = webview.getSettings().getUserAgentString().replace(androidOSString, "(X11; Linux x86_64)");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            newUserAgent = null;
        }

        webview.getSettings().setUserAgentString(newUserAgent);
        webview.getSettings().setUseWideViewPort(enabled);
        webview.getSettings().setLoadWithOverviewMode(enabled);
        webview.reload();
    }

    @Override
    public void onBackPressed()
    //la pagina web  si abris  otra  con el boton atras  vuelve a la anterior pagina y no sale dela app
    {
        if (webview.canGoBack())
        {
            webview.goBack();
           finish();
        }
        else
        {
            super.onBackPressed();
        }
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


        String dato= obtenerValor(getApplicationContext(), "EMail");
        String dato1= obtenerValor(getApplicationContext(), "ServerGradoNivel");
        String dato2= obtenerValor(getApplicationContext(), "SedeUsuario");
        String dato3= obtenerValor(getApplicationContext(), "URLPhoto");
        String dato4= obtenerValor(getApplicationContext(), "MatriculaServer");
        String dato5= obtenerValor(getApplicationContext(), "NombreUsuario");

        String dato6= obtenerValor(getApplicationContext(), "Acceso");

            if (id == R.id.action_opcionDpdf) {

                if (dato1.equalsIgnoreCase("6 Primaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavigatorPrimaria.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }

                if (dato1.equalsIgnoreCase("5 Primaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavigatorPrimaria.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }

                if (dato1.equalsIgnoreCase("1 Secundaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavActivity.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }


                if (dato1.equalsIgnoreCase("2 Secundaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavActivity.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }


                if (dato1.equalsIgnoreCase("3 Secundaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavActivity.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }

                if (dato1.equalsIgnoreCase("4 Secundaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavActivity.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }


                if (dato1.equalsIgnoreCase("5 Secundaria"))
                {
                    Intent intent= new Intent(PptViewer.this,NavActivity.class );
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);

                }

                //return true;
        }


        return super.onOptionsItemSelected(item);
    }



    static String  PREFS_KEY= "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return  preferences.getString(keyPref, "");

    }



}
