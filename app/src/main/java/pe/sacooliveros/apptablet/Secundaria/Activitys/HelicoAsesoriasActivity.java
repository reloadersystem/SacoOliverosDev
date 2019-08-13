package pe.sacooliveros.apptablet.Secundaria.Activitys;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterRecyclerAsesoria;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomosHelicoAsesoria;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap1_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap2_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap3_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.contentAsesoriasFragment;

public class HelicoAsesoriasActivity extends AppCompatActivity {

    ArrayList<mTomosHelicoAsesoria> mTomosAsesoriasList;
    public RecyclerView recyclerViewCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helico_asesorias);

        recyclerViewCursos = findViewById(R.id.rec_helicoAsesoria);

        mTomosAsesoriasList = new ArrayList<>();

        final AsesoriaCap1_Fragment asesoriaCap1_fragment= new AsesoriaCap1_Fragment();
        final AsesoriaCap2_Fragment asesoriaCap2_fragment= new AsesoriaCap2_Fragment();
        final AsesoriaCap3_Fragment asesoriaCap3_fragment= new AsesoriaCap3_Fragment();

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

        adapter.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position= recyclerViewCursos.getChildAdapterPosition(view);

                for (int a = 0; a < 9; a++) {

                    if (position == a) {

                        Intent intent= new Intent(HelicoAsesoriasActivity.this, TomosAsesoriasActivity.class);

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
