package pe.sacooliveros.apptablet.Balotario;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import pe.sacooliveros.apptablet.FragmentNavigator.HelicoBalotariosActivity;
import pe.sacooliveros.apptablet.R;

public class BalotarioMenuActivity extends AppCompatActivity {

    ImageView aulavirtual, balotariovirtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balotario_menu);

        aulavirtual = findViewById(R.id.img_aulavirtual);
        balotariovirtual = findViewById(R.id.img_balotariovirtual);

        final Toolbar toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        balotariovirtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BalotarioMenuActivity.this, BalotarioOpcionesActivity.class);
                startActivity(intent);

            }
        });

        aulavirtual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(BalotarioMenuActivity.this, HelicoBalotariosActivity.class);
                startActivity(intent);
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
