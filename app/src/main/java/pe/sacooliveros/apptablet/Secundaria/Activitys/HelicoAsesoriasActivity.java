package pe.sacooliveros.apptablet.Secundaria.Activitys;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterRecyclerAsesoria;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomosHelicoAsesoria;

public class HelicoAsesoriasActivity extends AppCompatActivity {

    ArrayList<mTomosHelicoAsesoria> mTomosAsesoriasList;
    public RecyclerView recyclerViewCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helico_asesorias);

        recyclerViewCursos = findViewById(R.id.rec_helicoAsesoria);

        mTomosAsesoriasList = new ArrayList<>();

        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 1"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 2"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 3"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 4"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 5"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 6"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 7"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria, "TOMO 8"));

        adapterRecyclerAsesoria adapter = new adapterRecyclerAsesoria(HelicoAsesoriasActivity.this, mTomosAsesoriasList);
        if (getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        } else {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        }
        recyclerViewCursos.setHasFixedSize(true);
        recyclerViewCursos.setAdapter(adapter);
    }
}
