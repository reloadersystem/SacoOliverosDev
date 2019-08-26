package pe.sacooliveros.apptablet.Secundaria.Activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Balotario.BalotarioOpcionesActivity;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterRecyclerAsesoria;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomosHelicoAsesoria;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap1_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap2_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap3_Fragment;

public class HelicoAsesoriasActivity extends AppCompatActivity {

    ArrayList<mTomosHelicoAsesoria> mTomosAsesoriasList;
    public RecyclerView recyclerViewCursos;
    MenuInflater inflater;
    MenuItem shareItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helico_asesorias);

        recyclerViewCursos = findViewById(R.id.rec_helicoAsesoria);

        mTomosAsesoriasList = new ArrayList<>();


        final Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        final AsesoriaCap1_Fragment asesoriaCap1_fragment = new AsesoriaCap1_Fragment();
        final AsesoriaCap2_Fragment asesoriaCap2_fragment = new AsesoriaCap2_Fragment();
        final AsesoriaCap3_Fragment asesoriaCap3_fragment = new AsesoriaCap3_Fragment();

        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 1"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 2"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 3"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 4"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 5"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 6"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 7"));
        mTomosAsesoriasList.add(new mTomosHelicoAsesoria(R.drawable.libroasesoria2, "TOMO 8"));

        adapterRecyclerAsesoria adapter = new adapterRecyclerAsesoria(HelicoAsesoriasActivity.this, mTomosAsesoriasList);
        if (getApplicationContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        } else {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        }
        recyclerViewCursos.setHasFixedSize(true);

        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = recyclerViewCursos.getChildAdapterPosition(view) + 1;

                asesoriaCap1_fragment.tomolistener("TOMO" + position);
                asesoriaCap2_fragment.tomolistener("TOMO" + position);
                asesoriaCap3_fragment.tomolistener("TOMO" + position);

                for (int a = 0; a < 9; a++) {

                    if (position == a) {

                        Intent intent = new Intent(HelicoAsesoriasActivity.this, TomosAsesoriasActivity.class);
                        intent.putExtra("tomo", position);
                        startActivity(intent);


//                        int inicio = a + 1;
//
//                        Fragment fragment = new contentAsesoriasFragment();
//
//                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
//                        if (fmanager != null) {
//
//                            asesoriaCap1_fragment.tomolistener("TOMO"+inicio);
//                            asesoriaCap2_fragment.tomolistener("TOMO"+inicio);
//                            asesoriaCap3_fragment.tomolistener("TOMO"+inicio);
//
//                            Bundle args = new Bundle();
//                            args.putString("Tomo", "Tomo " + inicio);
//
//                            fragment.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager.beginTransaction();
//
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//                        }
                    }
                }

            }
        });
        recyclerViewCursos.setAdapter(adapter);
    }

}
