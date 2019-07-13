package pe.sacooliveros.apptablet.YouTube;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import pe.sacooliveros.apptablet.R;

public class ViewYouTubeScreen extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, YouTubePlayer.PlaybackEventListener {

    YouTubePlayerView youTubePlayerView;

    YouTubePlayer.PlayerStyle style;

    String claveyoutube = "AIzaSyBBoMapePV_AthrQPLWevncKB-RVw6QXtw";


    String id_channel;
    String listChanel;

    TextView play_time;

    ImageButton play_video, pause_video;

    SeekBar video_seekbar;

    private Handler mHandler = null;

    private YouTubePlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_you_tube_screen);

        play_video = findViewById(R.id.play_video);
        pause_video = findViewById(R.id.pause_video);
        video_seekbar = findViewById(R.id.video_seekbar);
        play_time = findViewById(R.id.play_time);

        youTubePlayerView = findViewById(R.id.youtube_viewfullscreen);

        style = YouTubePlayer.PlayerStyle.MINIMAL;
        video_seekbar.setOnSeekBarChangeListener(mVideoSeekBarChangeListener);

        youTubePlayerView.initialize(claveyoutube, this);

        Bundle datos = this.getIntent().getExtras();

        id_channel = datos.getString("video_itemselec");
        listChanel = datos.getString("lista_canal");


        mHandler = new Handler();


//        YouTubePlayer.PlayerStyle style = YouTubePlayer.PlayerStyle.MINIMAL;

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

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean fueRestaurado) {

        mPlayer = youTubePlayer;

        youTubePlayer.setPlayerStateChangeListener(mPlayerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(mPlaybackEventListener);

        if (!fueRestaurado) {

            youTubePlayer.setPlayerStyle(style);
            youTubePlayer.setShowFullscreenButton(false);


            //youTubePlayer.cueVideo("RHcUU085kZc");
            youTubePlayer.loadVideo(id_channel);

            //Usa una lista de videos de  youtube x el id
//            List<String> videoList= new ArrayList<>();
//            videoList.add("RHcUU085kZc");
//            videoList.add("AK-BL5g6ETk");
//            videoList.add("x5fAvIsN1UA");
//            youTubePlayer.loadVideos(videoList);


            //youTubePlayer.loadPlaylist("PL6dvGWNWC1Uga4podWHHnSZQDyBFOsdhM");

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

        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        } else {
            String error = "Error al  iniciar Youtube" + youTubeInitializationResult.toString();

            Toast.makeText(getApplicationContext(), error, Toast.LENGTH_LONG).show();
        }

    }

    // @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1)
            getYoutubePlayerProvider().initialize(claveyoutube, this);
        {

        }

    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider() {
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
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, YouTubeViewer.class);
        intent.putExtra("video_itemselec", id_channel);
        intent.putExtra("lista_canal", listChanel);
        startActivity(intent);

        this.finish();


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
