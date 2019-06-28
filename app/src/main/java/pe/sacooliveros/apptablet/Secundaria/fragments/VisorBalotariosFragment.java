package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VisorBalotariosFragment extends Fragment {

    View rootview;


    public VisorBalotariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_visor_balotarios, container, false);

        WebView wv = (WebView) rootview.findViewById(R.id.webView);
        wv.setWebViewClient(new myWebClient());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.createPrintDocumentAdapter("fisica");
        wv.getSettings().setBuiltInZoomControls(true);
        wv.getSettings().setDisplayZoomControls(false);
        wv.loadUrl("https://docs.google.com/gview?url=http://192.169.218.177/APP/D/BALOTARIOS/1/BIMESTRAL/BIMESTRE2/FISICA/FISICADB1_BM2.pdf");

        //wv.loadUrl("https://drive.google.com/file/d/1ZpYyhbjZwWKp_UESg3tGAFQz4j3tX_EO/view"); // carga de google drive pero sin impresión
        //wv.loadUrl("https://drive.google.com/file/d/1ZpYyhbjZwWKp_UESg3tGAFQz4j3tX_EO/view"); // carga de google drive pero sin impresión

//        String pdf = "http://www2.dgeo.udec.cl/juaninzunza/docencia/fisica/cap1.pdf";
//        wv.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);

        return rootview;

        //
    }

    public class myWebClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            //progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);

            // progressBar.setVisibility(View.GONE);
        }

    }



}
