package pe.sacooliveros.apptablet.Balotario;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.Primer_BalFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Segundo_BalFragment;

public class BalotarioOpcionesActivity extends AppCompatActivity {

    TextView txt_primermensual, txt_primerbimestral;
    TextView txt_segundomensual, txt_segundobimestral;
    TextView txt_tercermensual, txt_tercerbimestral;
    TextView txt_cuartomensual, txt_cuartobimestral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balotario_opciones);

        txt_primermensual = findViewById(R.id.txt_balotar1mensual);
        txt_primerbimestral = findViewById(R.id.txt_balotar1bimestral);
        txt_segundobimestral = findViewById(R.id.txt_balotar2bimestral);
        txt_segundomensual = findViewById(R.id.txt_balotar2mensual);
        txt_tercerbimestral = findViewById(R.id.txt_balotar3bimestral);
        txt_tercermensual = findViewById(R.id.txt_balotar3mensual);
        txt_cuartomensual = findViewById(R.id.txt_balotar4mensual);
        txt_cuartobimestral = findViewById(R.id.txt_balotar4bimestral);


        File balotariospdf = new File(Environment.getExternalStorageDirectory(), "/SacoOliveros");
        if (!balotariospdf.exists()) {
            balotariospdf.mkdir();
        }

        final Toolbar toolbar=findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

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


                Toast.makeText(BalotarioOpcionesActivity.this, "Material no Disponible", Toast.LENGTH_SHORT).show();

            }
        });

        txt_tercermensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BalotarioOpcionesActivity.this, "Material no Disponible", Toast.LENGTH_SHORT).show();

            }
        });


        txt_cuartomensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BalotarioOpcionesActivity.this, "Material no Disponible", Toast.LENGTH_SHORT).show();
            }
        });

        txt_cuartobimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(BalotarioOpcionesActivity.this, "Material no Disponible", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
