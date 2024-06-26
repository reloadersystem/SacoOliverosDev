package pe.sacooliveros.apptablet.YouTube;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

public class YouTubeViewer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener, AdapterView.OnItemClickListener  {

    private static final String TAG = "COUNT_LISTYOUTUBE";
    YouTubePlayerView youTubePlayerView;
    String claveyoutube= "AIzaSyBBoMapePV_AthrQPLWevncKB-RVw6QXtw";
    RelativeLayout logo_sombreado;
    ImageView home_primaria;
    String listChanel;
    ListView listView;
    String videoselect;
    String API_KEY= "AIzaSyD9GZLfzFIdowg9dIJyb6jfgac3P6mRp1U";
    ArrayList<VideoDetails> videoDetailsArrayList;
    MyCustomAdapter myCustomAdapter;
    //String url="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLq_MGynXklvnlaed3VruS0dp1a7Qgpg4i&key=AIzaSyD9GZLfzFIdowg9dIJyb6jfgac3P6mRp1U";
    //String url="https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=PLq_MGynXklvnlaed3VruS0dp1a7Qgpg4i&key="+API_KEY;
    String url;
    YouTubePlayer.PlayerStyle style;
    TextView play_time;
    ImageButton play_video, pause_video;
    SeekBar video_seekbar;
    private Handler mHandler = null;
    private YouTubePlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_viewer);

        youTubePlayerView= findViewById(R.id.youtube_view);
        logo_sombreado= findViewById(R.id.logo_sombreado);
        home_primaria=findViewById(R.id.home_primaria);

        play_video = findViewById(R.id.play_movie);
        pause_video = findViewById(R.id.pause_movie);
        video_seekbar = findViewById(R.id.movie_seekbar);
        play_time = findViewById(R.id.txt_movie_time);

        style = YouTubePlayer.PlayerStyle.MINIMAL;
        video_seekbar.setOnSeekBarChangeListener(mVideoSeekBarChangeListener);
        youTubePlayerView.initialize(claveyoutube, this);

        //style = YouTubePlayer.PlayerStyle.CHROMELESS; //sin Botones, sin play
        //style = YouTubePlayer.PlayerStyle.DEFAULT; //visor igual a youtube

        mHandler = new Handler();
        Bundle datos = this.getIntent().getExtras();

        listChanel= datos.getString("lista_canal");
        //url= "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+listChanel+"+&key="+API_KEY;
        //url= "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=12&playlistId="+listChanel+"+&key="+API_KEY; //  //todo maximo num de resultados youtube 12
        url= "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId="+listChanel+"+&key="+API_KEY;


        //url= "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLgGlu7X3dcFgabqPrSzdNeyYy15riYwCD&key="+API_KEY;
        //PLgGlu7X3dcFgabqPrSzdNeyYy15riYwCD
        //https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLsKQe03h-kOi86OZJqby0i2o1Y2WnwvJf


        listView=findViewById(R.id.listView);
        videoDetailsArrayList=new ArrayList<>();
        myCustomAdapter=  new MyCustomAdapter(YouTubeViewer.this, videoDetailsArrayList);
        displayVideos();
        listView.setOnItemClickListener(this);


        home_primaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dato = obtenerValor(getApplicationContext(), "EMail");
                String dato1 = obtenerValor(getApplicationContext(), "ServerGradoNivel");
                String dato2 = obtenerValor(getApplicationContext(), "SedeUsuario");
                String dato3 = obtenerValor(getApplicationContext(), "URLPhoto");
                String dato4 = obtenerValor(getApplicationContext(), "MatriculaServer");
                String dato5 = obtenerValor(getApplicationContext(), "NombreUsuario");
                String dato6 = obtenerValor(getApplicationContext(), "Acceso");
                if (dato1.equalsIgnoreCase("6 Primaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavigatorPrimaria.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("5 Primaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavigatorPrimaria.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("1 Secundaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavActivity.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("2 Secundaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavActivity.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("3 Secundaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavActivity.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("4 Secundaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavActivity.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }
                if (dato1.equalsIgnoreCase("5 Secundaria")) {
                    Intent intent = new Intent(YouTubeViewer.this, NavActivity.class);
                    intent.putExtra("EMail", dato);
                    intent.putExtra("ServerGradoNivel", dato1);
                    intent.putExtra("SedeUsuario", dato2);
                    intent.putExtra("URLPhoto", dato3);
                    intent.putExtra("MatriculaServer", dato4);
                    intent.putExtra("NombreUsuario", dato5);
                    startActivity(intent);
                }


            }
        });


        play_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (null != mPlayer && !mPlayer.isPlaying()) {
                    mPlayer.play();
                }

            }
        });

        pause_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mPlayer && mPlayer.isPlaying()) {
                    mPlayer.pause();
                }

            }
        });

    }

    private void displayVideos() {

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest= new StringRequest(Request.Method.GET, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {

                try {
                    JSONObject jsonObject= new JSONObject((response));
                    JSONArray jsonArray= jsonObject.getJSONArray("items");
                    int totalitems= jsonArray.length();


                    for(int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject jsonObject1= jsonArray.getJSONObject(i);
                        JSONObject jsonObjectSnippet=jsonObject1.getJSONObject("snippet");
                        JSONObject jsonObjectDefault= jsonObjectSnippet.getJSONObject("resourceId");
                        JSONObject thumbnails= jsonObjectSnippet.getJSONObject("thumbnails");
                        JSONObject medium= thumbnails.getJSONObject("medium");
                        String datourl= medium.getString("url");

                        String video_id= jsonObjectDefault.getString("videoId");
                        String title= jsonObjectSnippet.getString("title");
                        String description=jsonObjectSnippet.getString("description");

                        VideoDetails vd= new VideoDetails();
                        vd.setVideoId(video_id);
                        vd.setTitle(title);
                        vd.setDescription(description);
                        vd.setUrl(datourl);
                        videoDetailsArrayList.add(vd);
                    }

                    listView.setAdapter(myCustomAdapter);
                    myCustomAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(YouTubeViewer.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        );

        requestQueue.add(stringRequest);
    }




    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        mPlayer = youTubePlayer;

        youTubePlayer.setPlayerStateChangeListener(mPlayerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(mPlaybackEventListener);

        if(!fueRestaurado)
        {


            youTubePlayer.setPlayerStyle(style);
            youTubePlayer.setShowFullscreenButton(false);



            //youTubePlayer.cueVideo("RHcUU085kZc");
            // youTubePlayer.loadVideo("RHcUU085kZc");
            //youTubePlayer.loadVideo("2OiSO1NaJoI");

            //Usa una lista de videos de  youtube x el id
//            List<String> videoList= new ArrayList<>();
//            videoList.add("RHcUU085kZc");
//            videoList.add("AK-BL5g6ETk");
//            videoList.add("x5fAvIsN1UA");
//            youTubePlayer.loadVideos(videoList);


            //youTubePlayer.loadPlaylist("PLlEW_8OcYYBQBg5gqGlKcb4Ztp1QvUG_t");
            youTubePlayer.loadPlaylist(listChanel);

        }
    }

    YouTubePlayer.PlayerStateChangeListener mPlayerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
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
            displayCurrentTime();

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    YouTubePlayer.PlaybackEventListener mPlaybackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

            mHandler.postDelayed(runnable, 100);
            displayCurrentTime();

        }

        @Override
        public void onPaused() {
            mHandler.removeCallbacks(runnable);

        }

        @Override
        public void onStopped() {
            mHandler.removeCallbacks(runnable);

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int arg0) {
            mHandler.postDelayed(runnable, 100);

        }
    };

    SeekBar.OnSeekBarChangeListener mVideoSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            long lengthPlayed = (mPlayer.getDurationMillis() * progress) / 100;
            mPlayer.seekToMillis((int) lengthPlayed);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError())
        {
            youTubeInitializationResult.getErrorDialog(this,1).show();

        }else
        {
            String  error="Error al  iniciar Youtube"+youTubeInitializationResult.toString() ;

            Toast.makeText(getApplicationContext(), error,Toast.LENGTH_LONG).show();
        }

    }

    // @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==1)
            getYoutubePlayerProvider().initialize(claveyoutube, this);

        {

        }

    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider()
    {
        return youTubePlayerView;
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

//            logo_sombreado.setVisibility(View.GONE);
//            txt_educativo.setVisibility(View.GONE);
//            home_primaria.setVisibility(View.GONE);
//            listView.setVisibility(View.GONE);

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            logo_sombreado.setVisibility(View.VISIBLE);
            home_primaria.setVisibility(View.VISIBLE);
            listView.setVisibility(View.VISIBLE);

        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        int  cantidadItemList= myCustomAdapter.getCount(); // cantidad de items de la lista de Youtube

        VideoDetails videoDetails= (VideoDetails)myCustomAdapter.getItem(position);

        //reconoce cuantos  items  tiene y también lo que selecciono el usuario
        for (int a = 0; a <= cantidadItemList; a++) {

            if (position == a) {
                videoselect= videoDetails.getVideoId();
                Intent intent= new Intent(this, ViewYouTubeScreen.class);
                intent.putExtra("video_itemselec", videoselect);
                intent.putExtra("lista_canal", listChanel);
                startActivity(intent);
                this.finish();
            }
        }

        //todo numero de items playlist youtube

//        switch (position)
//        {
//
//            case 0:
//
//                videoselect= videoDetails.getVideoId();
//
//                //listChanel= datos.getString("lista_canal");
//
//                Intent intent= new Intent(this, ViewYouTubeScreen.class);
//                intent.putExtra("video_itemselec", videoselect);
//                intent.putExtra("lista_canal", listChanel);
//
//
//                startActivity(intent);
//
//                this.finish();
//
//
//                //Toast.makeText(YouTubeViewer.this,position+" ID: " + videoDetails.getVideoId(),  Toast.LENGTH_SHORT).show();
//
//
//                break;
//
//            case 1:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent2= new Intent(this, ViewYouTubeScreen.class);
//                intent2.putExtra("video_itemselec", videoselect);
//                intent2.putExtra("lista_canal", listChanel);
//
//                startActivity(intent2);
//                this.finish();
//
//                break;
//
//
//
//            case 2:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent3= new Intent(this, ViewYouTubeScreen.class);
//                intent3.putExtra("video_itemselec", videoselect);
//                intent3.putExtra("lista_canal", listChanel);
//                startActivity(intent3);
//                this.finish();
//
//                break;
//
//
//            case 3:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent4= new Intent(this, ViewYouTubeScreen.class);
//                intent4.putExtra("video_itemselec", videoselect);
//                intent4.putExtra("lista_canal", listChanel);
//                startActivity(intent4);
//
//                this.finish();
//
//                break;
//
//
//
//            case 4:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent5= new Intent(this, ViewYouTubeScreen.class);
//                intent5.putExtra("video_itemselec", videoselect);
//                intent5.putExtra("lista_canal", listChanel);
//                startActivity(intent5);
//
//                this.finish();
//
//                break;
//
//
//            case 5:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent6= new Intent(this, ViewYouTubeScreen.class);
//                intent6.putExtra("video_itemselec", videoselect);
//                intent6.putExtra("lista_canal", listChanel);
//                startActivity(intent6);
//                this.finish();
//                break;
//
//
//            case 6:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent7= new Intent(this, ViewYouTubeScreen.class);
//                intent7.putExtra("video_itemselec", videoselect);
//                intent7.putExtra("lista_canal", listChanel);
//                startActivity(intent7);
//
//                this.finish();
//
//                break;
//
//            case 7:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent8= new Intent(this, ViewYouTubeScreen.class);
//                intent8.putExtra("video_itemselec", videoselect);
//                intent8.putExtra("lista_canal", listChanel);
//                startActivity(intent8);
//
//                this.finish();
//
//                break;
//
//
//            case 8:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent9= new Intent(this, ViewYouTubeScreen.class);
//                intent9.putExtra("video_itemselec", videoselect);
//                intent9.putExtra("lista_canal", listChanel);
//                startActivity(intent9);
//
//                this.finish();
//
//                break;
//
//            case 9:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent10= new Intent(this, ViewYouTubeScreen.class);
//                intent10.putExtra("video_itemselec", videoselect);
//                intent10.putExtra("lista_canal", listChanel);
//                startActivity(intent10);
//
//                this.finish();
//
//                break;
//
//
//            case 10:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent11= new Intent(this, ViewYouTubeScreen.class);
//                intent11.putExtra("video_itemselec", videoselect);
//                intent11.putExtra("lista_canal", listChanel);
//                startActivity(intent11);
//
//                this.finish();
//
//                break;
//
//
//            case 11:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent12= new Intent(this, ViewYouTubeScreen.class);
//                intent12.putExtra("video_itemselec", videoselect);
//                intent12.putExtra("lista_canal", listChanel);
//                startActivity(intent12);
//
//                this.finish();
//
//                break;
//
//            case 12:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent13= new Intent(this, ViewYouTubeScreen.class);
//                intent13.putExtra("video_itemselec", videoselect);
//                intent13.putExtra("lista_canal", listChanel);
//                startActivity(intent13);
//
//                this.finish();
//
//                break;
//
//
//            case 13:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent14= new Intent(this, ViewYouTubeScreen.class);
//                intent14.putExtra("video_itemselec", videoselect);
//                intent14.putExtra("lista_canal", listChanel);
//                startActivity(intent14);
//                this.finish();
//                break;
//
//            case 14:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent15= new Intent(this, ViewYouTubeScreen.class);
//                intent15.putExtra("video_itemselec", videoselect);
//                intent15.putExtra("lista_canal", listChanel);
//                startActivity(intent15);
//
//                this.finish();
//
//                break;
//
//
//
//            case 15:
//
//                videoselect= videoDetails.getVideoId();
//
//                Intent intent16= new Intent(this, ViewYouTubeScreen.class);
//                intent16.putExtra("video_itemselec", videoselect);
//                intent16.putExtra("lista_canal", listChanel);
//                startActivity(intent16);
//
//                this.finish();
//
//                break;
//
//
//
//
//        }
    }


    static String PREFS_KEY = "autenticacionOff";
    public static String obtenerValor(Context context, String keyPref) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }

    private void displayCurrentTime() {
        if (null == mPlayer) return;
        String formattedTime = formatTime(mPlayer.getDurationMillis() - mPlayer.getCurrentTimeMillis());
        play_time.setText(formattedTime);
    }

    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;


        //return  String.format("%02d:%02d", minutes % 60, seconds % 60);
        return (hours == 0 ? "--:" : hours + ":") + String.format("%02d:%02d", minutes % 60, seconds % 60);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            displayCurrentTime();
            mHandler.postDelayed(this, 100);
        }
    };
}