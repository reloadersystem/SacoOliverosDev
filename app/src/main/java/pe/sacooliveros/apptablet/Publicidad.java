package pe.sacooliveros.apptablet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import pe.sacooliveros.apptablet.Authenticacion.firebaseAuth;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.WebServiceFechaServer.SacoWSFecha;
import pe.sacooliveros.apptablet.WebServiceFechaServer.WebServiceFecha;

public class Publicidad extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    YouTubePlayerView youTubePlayerView;
    String claveyoutube = "AIzaSyBBoMapePV_AthrQPLWevncKB-RVw6QXtw";
    YouTubePlayer.PlayerStyle style;

    @Override
    protected void onStart() {
        super.onStart();


        String dato = obtenerValor(getApplicationContext(), "EMail");

        if (!dato.equalsIgnoreCase("")) {

            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            Intent intent = new Intent().setClass(Publicidad.this, SplashActivity.class);
            startActivity(intent);
            finish();
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

            youTubePlayerView = findViewById(R.id.youtube_view);
            style = YouTubePlayer.PlayerStyle.CHROMELESS;
            youTubePlayerView.initialize(claveyoutube, this);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicidad);

        //style = YouTubePlayer.PlayerStyle.MINIMAL;
    }


    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.setPlayerStyle(style);
        youTubePlayer.setShowFullscreenButton(false);

        //youTubePlayer.loadVideo ("Hn7u1pE_AtM");
        //TODO VIDEO INSTITUCIONAL
        //youTubePlayer.loadVideo("jqA0MwZ52nE"); //video saco
        youTubePlayer.loadVideo("eNKJYtm9OxY"); //video saco

      //youTubePlayer.loadVideo("CijHemhHQ9A");


      // youTubePlayer.loadVideo("yxRmOifEZJY");


        youTubePlayer.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {

            }

            @Override
            public void onLoaded(String s) {

            }

            @Override
            public void onAdStarted() {

            }

            @Override
            public void onVideoStarted() {

            }

            @Override
            public void onVideoEnded() {

//                Intent intent = new Intent().setClass(Publicidad.this, SplashActivity.class);
//
//                //guardarValorPubli(getApplicationContext(), "publicount", "1");
//
//                startActivity(intent);
//                finish();

                //codigo_autenticacion
                //versiontablet






                String urlcode = "http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/consultarFecha";


                WebServiceFecha.urlvisor(urlcode);
                SacoWSFecha consult = new SacoWSFecha();
                consult.setCurrentContext(getApplicationContext());
                //consult.setCurrentLayout(lnLayout);
                consult.execute("");


                Intent intent = new Intent().setClass(Publicidad.this, firebaseAuth.class);
                startActivity(intent);
                finish();


            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        });


    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, 1).show(); // para pedir  que descargue  youtube

            String error = "Descarga YouTube para iniciar  la Aplicación";

            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();

        } else {
            String error = "Error al  iniciar Youtube" + youTubeInitializationResult.toString();

            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onPlaying() {

    }

    @Override
    public void onPaused() {

    }

    @Override
    public void onStopped() {

    }

    @Override
    public void onBuffering(boolean b) {

    }

    @Override
    public void onSeekTo(int i) {

    }

    //private static String PREFS_KEY = "publicidadTurn";

//    public static void guardarValorPubli(Context context, String keyPref, String valor) {
//        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
//        SharedPreferences.Editor editor;
//        editor = settings.edit();
//        editor.putString(keyPref, valor);
//        editor.commit();
//    }


    static String PREFS_KEY1 = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY1, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }
}
