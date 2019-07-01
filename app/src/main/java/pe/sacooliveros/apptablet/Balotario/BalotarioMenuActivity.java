package pe.sacooliveros.apptablet.Balotario;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.ActivityAulaVirtual;

public class BalotarioMenuActivity extends AppCompatActivity {

    ImageView aulavirtual, balotariovirtual;

    CollapsingToolbarLayout collapsingToolbarLayout;

    AppBarLayout appBarLayout;

    Typeface futuralbold;
    Typeface futuraheavy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balotario_menu);

        aulavirtual = findViewById(R.id.img_aulavirtual);
        balotariovirtual = findViewById(R.id.img_balotariovirtual);

        final Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        String fuente1 = "fuentes/futurabold.ttf";
        this.futuralbold = Typeface.createFromAsset(getAssets(), fuente1);

        String fuente2 = "fuentes/futuraheavy.ttf";
        this.futuraheavy = Typeface.createFromAsset(getAssets(), fuente2);

        collapsingToolbarLayout.setCollapsedTitleTypeface(futuralbold);
        collapsingToolbarLayout.setExpandedTitleTypeface(futuraheavy);


        balotariovirtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BalotarioMenuActivity.this, BalotarioOpcionesActivity.class);
                startActivity(intent);
                // overridePendingTransition(R.anim.fade_in,R.anim.fade_out);

            }
        });

        aulavirtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BalotarioMenuActivity.this, ActivityAulaVirtual.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {

//            Toast.makeText(getApplicationContext(), "Orientacion horizontal", Toast.LENGTH_SHORT).show();
        }
    }


}
