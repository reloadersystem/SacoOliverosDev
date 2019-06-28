package pe.sacooliveros.apptablet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PresentacionActivity extends AppCompatActivity {

    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;

    private boolean animationStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);
        getSupportActionBar().hide();
        setTitle("Saco Oliveros - Plataforma Virtual");
    }
}
