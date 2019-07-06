package pe.sacooliveros.apptablet.Balotario;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Secundaria.fragments.Primer_BalFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Segundo_BalFragment;

public class BalotarioOpcionesActivity extends AppCompatActivity {

    TextView txt_primermensual, txt_primerbimestral;
    TextView txt_segundomensual, txt_segundobimestral;
    TextView txt_tercermensual, txt_tercerbimestral;
    TextView txt_cuartomensual, txt_cuartobimestral;

    CollapsingToolbarLayout collapsingToolbarLayout;

    AppBarLayout appBarLayout;
    Typeface futuralbold;
    Typeface futuraheavy;

    MenuInflater inflater;

    MenuItem shareItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balotario_opciones);

        txt_primermensual = findViewById(R.id.txt_mensualbalotario1);
        txt_primerbimestral = findViewById(R.id.txt_bimestralbalotario1);
        txt_segundobimestral = findViewById(R.id.txt_bimestralbalotario2);
        txt_segundomensual = findViewById(R.id.txt_mensualbalotario2);
        txt_tercerbimestral = findViewById(R.id.txt_bimestralbalotario3);
        txt_tercermensual = findViewById(R.id.txt_mensualbalotario3);
        txt_cuartomensual = findViewById(R.id.txt_mensualbalotario4);
        txt_cuartobimestral = findViewById(R.id.txt_bimestralbalotario4);


        File balotariospdf = new File(Environment.getExternalStorageDirectory(), "/SacoOliveros");
        if (!balotariospdf.exists()) {
            balotariospdf.mkdir();
        }

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


        txt_primermensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //1erSolucMensual
                Primer_BalFragment.instantiate("1erMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("1erSolucMensual", "MENSUAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Primer Balotario Mensual");
                startActivity(intent);
            }
        });


        txt_primerbimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Primer_BalFragment.instantiate("1erBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("1erSolucBimestral", "BIMESTRAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Primer Balotario Bimestral");
                startActivity(intent);

            }
        });


        txt_segundobimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("2doBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("2doSolucBimestral", "BIMESTRAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Segundo Balotario Bimestral");
                startActivity(intent);

            }
        });


        txt_segundomensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("2doMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("2doSolucMensual", "MENSUAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Segundo Balotario Mensual");
                startActivity(intent);
            }
        });


        txt_tercerbimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("3erBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("3erSolucBimestral", "BIMESTRAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Tercer Balotario Bimestral");
                startActivity(intent);
            }
        });

        txt_tercermensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("3erMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("3erSolucMensual", "MENSUAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Tercer Balotario Mensual");
                startActivity(intent);

            }
        });


        txt_cuartomensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("4toMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("4toSolucMensual", "MENSUAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Cuarto Balotario Mensual");
                startActivity(intent);
            }
        });

        txt_cuartobimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("4toBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("4toSolucBimestral", "BIMESTRAL");

                Intent intent = new Intent(BalotarioOpcionesActivity.this, BalotariosPeriodosActivity.class);
                intent.putExtra("descripcion_balotario", "Cuarto Balotario Bimestral");
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menupdf, menu);
//        return true;

        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hometoolbar, menu);
        shareItem = menu.findItem(R.id.action_home);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_home) {
            Intent intent = new Intent(BalotarioOpcionesActivity.this, NavActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
