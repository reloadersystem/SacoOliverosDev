package pe.sacooliveros.apptablet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewWebUrlFrag extends Fragment {

    View rootview;

    WebView webview;

    String urldescription;

    ProgressBar progress_viewweburl;

    public ViewWebUrlFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_view_web_url, container, false);

        webview= rootview.findViewById(R.id.id_webweburl);

        progress_viewweburl= rootview.findViewById(R.id.progress_viewweburl);



        CookieManager.getInstance().setAcceptCookie(true);

        Bundle bundle = this.getArguments();

        if (bundle != null) {

            urldescription = bundle.getString("UrlDescription");

        }

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webview.loadUrl(urldescription);
        progress_viewweburl.setVisibility(View.GONE);


        return rootview;
    }



}
