package pe.sacooliveros.apptablet.Secundaria;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

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

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

public class ActivityAulaVirtual extends AppCompatActivity {

    String url = "http://aulavirtualsacooliveros.edu.pe";
    ProgressBar progressBar;

    MenuInflater inflater;

    MenuItem shareItem;

    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula_virtual);

        cd = new ConnectionDetector(this);

        setTitle("Aula Virtual - Saco Oliveros");
//
//        WebView myWebView = findViewById(R.id.webView);
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.loadUrl(url);


        WebView wv = (WebView) findViewById(R.id.webView);
        progressBar= (ProgressBar) findViewById(R.id.progress_circular);
        // wv.setWebViewClient(new MyBrowser());


        wv.setWebViewClient(new myWebClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);
        wv.loadUrl(url);

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menupdf, menu);
//        return true;


        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_balotario, menu);
        shareItem = menu.findItem(R.id.action_reload);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        int id = item.getItemId();


//            cibergrafiaPanelDialog().show();

        if (id == R.id.action_reload) {


            if (cd.isConnected()) {

                WebView wv =  findViewById(R.id.webView);
                progressBar=  findViewById(R.id.progress_circular);
                wv.setWebViewClient(new myWebClient());
                wv.getSettings().setJavaScriptEnabled(true);
                wv.getSettings().setBuiltInZoomControls(true);
                wv.getSettings().setDisplayZoomControls(false);
                wv.loadUrl(url);

            }
            else
            {
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
                Intent intent = new Intent(ActivityAulaVirtual.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Primaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavigatorPrimaria.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("1 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("2 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("3 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("4 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }
            if (dato1.equalsIgnoreCase("5 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, NavActivity.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);
            }

            if (dato1.equalsIgnoreCase("601 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, CiclosEspeciales.class);
                intent.putExtra("EMail", dato);
                intent.putExtra("ServerGradoNivel", dato1);
                intent.putExtra("SedeUsuario", dato2);
                intent.putExtra("URLPhoto", dato3);
                intent.putExtra("MatriculaServer", dato4);
                intent.putExtra("NombreUsuario", dato5);
                startActivity(intent);

            }

            if (dato1.equalsIgnoreCase("701 Secundaria")) {
                Intent intent = new Intent(ActivityAulaVirtual.this, CiclosEspeciales.class);
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


    static String PREFS_KEY = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }


    public  class myWebClient extends WebViewClient{

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
        }

    }
}
