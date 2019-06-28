package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
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
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentHelicoBalotarios extends Fragment {


    ProgressBar progressBar;
    WebView webview;
    String url = "http://aulavirtualsacooliveros.edu.pe";




    View rootview;


    public fragmentHelicoBalotarios() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_helico_balotarios, container, false);

        webview = (WebView) rootview.findViewById(R.id.wv_main);

            webview.getSettings().setJavaScriptEnabled(true);
            CookieManager.getInstance().setAcceptCookie(true);
            progressBar = rootview.findViewById(R.id.prg);

            new MyAsynTask().execute();

        return rootview;
    }


    private class MyAsynTask extends AsyncTask<Void, Void, Document> {
        @Override
        protected Document doInBackground(Void... voids) {

            Document document = null;
            try {
                document = Jsoup.connect(url).get();

//                document.getElementsByClass("camera_wrap camera_emboss").remove();
//
//
//                document.getElementsByClass(" cameraContent cameracurrent").remove();
//                document.getElementsByClass("span8").remove();
//                document.getElementsByClass("block_navigation  block").remove();
//                document.getElementsByClass("footerlinks").remove();
//                document.getElementsByClass("navbar-inner").remove();
//
//
//                document.getElementsByClass("span9").remove();
//                document.getElementsByClass("socials row-fluid").remove();
                //document.getElementsByClass("commit-tease").remove();


            } catch (IOException e) {
                e.printStackTrace();


            }
            return document;
        }


        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);
            webview.loadDataWithBaseURL(url, document.toString(), "text/html", "utf-8", "");
            webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

            webview.getSettings().setSupportZoom(true);
            webview.getSettings().setBuiltInZoomControls(true);
            webview.getSettings().setDisplayZoomControls(false);
            webview.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
            webview.setScrollbarFadingEnabled(true);


            webview.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    progressBar.setVisibility(View.VISIBLE);
                    //getActivity().setTitle("Loading...");

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
                    CookieSyncManager.getInstance().sync();

                }



            });


        }

        public void setDesktopMode(WebView webview, boolean enabled) {
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


}