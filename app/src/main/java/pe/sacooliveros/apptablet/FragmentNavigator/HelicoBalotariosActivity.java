package pe.sacooliveros.apptablet.FragmentNavigator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;

public class HelicoBalotariosActivity extends AppCompatActivity {


    ProgressBar progressBar;
    WebView webview;


    String url="http://aulavirtualsacooliveros.edu.pe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helico_balotarios);

        webview= (WebView) findViewById(R.id.wv_main);
        progressBar=findViewById(R.id.prg);

        CookieManager.getInstance().setAcceptCookie(true);
        //permite que  si  ingresan contraseña y usuario habilita las cookies para pasar a las demas paginas web


        new MyAsynTask().execute();



    }

    private class MyAsynTask extends AsyncTask<Void, Void, Document> {

        @Override
        protected Document doInBackground(Void... voids) {
            Document document = null;
            try {
                document= Jsoup.connect(url).get();

//                document.getElementsByClass("camera_wrap camera_emboss").remove();
//
//
//                document.getElementsByClass(" cameraContent cameracurrent").remove();
//                document.getElementsByClass("span8").remove();
//                document.getElementsByClass("block_navigation  block").remove();
//                document.getElementsByClass("footerlinks").remove();
//                document.getElementsByClass("navbar-inner").remove();
//                document.getElementsByClass("span9").remove();
//
//               document.getElementsByClass("socials row-fluid").remove();
//               document.getElementsByClass("commit-tease").remove();



            } catch (IOException e) {
                e.printStackTrace();
                //return "Error: " + e.getMessage();

                // TODO validar  Perdio Conexion

            }
            return document;
        }



    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);



        if (document!= null)
        {
            webview.loadDataWithBaseURL(url,document.toString(),"text/html","utf-8","");
            webview.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );

            webview.getSettings().setSupportZoom(true);
            webview.getSettings().setBuiltInZoomControls(true);
            webview.getSettings().setDisplayZoomControls(false);

            webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webview.setScrollbarFadingEnabled(true);
            webview.setWebViewClient(new WebViewClient(){

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    //Users will be notified in case there's an error (i.e. no internet connection)
                    Toast.makeText(HelicoBalotariosActivity.this, "Sin Conexion" + description, Toast.LENGTH_SHORT).show();
                }


                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar.setVisibility(View.VISIBLE);
                    setTitle("Loading...");
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                    setDesktopMode(webview, true);
                    view.loadUrl(url);
                    return super.shouldOverrideUrlLoading(view, request);
                }


                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressBar.setVisibility(View.GONE);
                    setTitle(view.getTitle());

                }
            });
        }

        else

        {
            Toast.makeText(HelicoBalotariosActivity.this, "Sin Conexión" , Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
            Intent intent= new Intent(HelicoBalotariosActivity.this,NavActivity.class );
            startActivity(intent);

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



    }

    @Override
    public void onBackPressed()

    {
        if (webview.canGoBack())
        {
            webview.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //getMenuInflater().inflate(R.menu.menupdf, menu);
        getMenuInflater().inflate(R.menu.menu_balotario, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_reload) {

            new MyAsynTask().execute();
        }




        if (id == R.id.action_opcionDpdf) {

            Intent intent= new Intent(HelicoBalotariosActivity.this,NavActivity.class );
            startActivity(intent);

            return true;
        }



        return super.onOptionsItemSelected(item);
    }










}
