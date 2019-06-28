package pe.sacooliveros.apptablet.Secundaria;


import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.DBDescargas.AdapterRecyclerDescarga;
import pe.sacooliveros.apptablet.Primaria.fragments.divertiAprendoFragment;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterUnidadesBottom;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.RecyclerViewAdapter;
import pe.sacooliveros.apptablet.Secundaria.Model.mUnidadesBottom;

/**
 * A simple {@link Fragment} subclass.
 */
public class bottomsheetFragment extends BottomSheetDialogFragment  {

    View rootview;

    RecyclerView recyclerView;

    ArrayList<mUnidadesBottom> mUnidades;

    TextView txt_titulo;

    int habilitar = 0;



    public bottomsheetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_bottomsheet, container, false);

        recyclerView= rootview.findViewById(R.id.recycler_unidades);

        txt_titulo= rootview.findViewById(R.id.txt_titulo);

        txt_titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(habilitar==0)
                {
                    habilitar = habilitar + 1;
                    recyclerView.setVisibility(View.VISIBLE);
                } else if(habilitar==1)
                {
                    recyclerView.setVisibility(View.GONE);
                    habilitar = habilitar - 1;
                }
            }
        });

        mUnidades= new ArrayList<>();

        mUnidades.add(new mUnidadesBottom("UNIDAD 1", R.drawable.ic_adjust24dp));
        mUnidades.add(new mUnidadesBottom("UNIDAD 2", R.drawable.ic_book));
        mUnidades.add(new mUnidadesBottom("UNIDAD 3", R.drawable.ic_public));
        mUnidades.add(new mUnidadesBottom("UNIDAD 4", R.drawable.ic_adjust24dp));
        mUnidades.add(new mUnidadesBottom("UNIDAD 5", R.drawable.ic_adjust24dp));
        mUnidades.add(new mUnidadesBottom("UNIDAD 6", R.drawable.ic_adjust24dp));
        mUnidades.add(new mUnidadesBottom("UNIDAD 7", R.drawable.ic_adjust24dp));
        mUnidades.add(new mUnidadesBottom("UNIDAD 8", R.drawable.ic_adjust24dp));

        adapterUnidadesBottom myAdapter= new adapterUnidadesBottom(getContext(), mUnidades);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        recyclerView.setAdapter(myAdapter);


        myAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre= mUnidades.get(recyclerView.getChildAdapterPosition(view)).getDescripcion();

                divertiAprendoFragment.instantiate(getContext(), nombre);

                recyclerView.setVisibility(View.GONE);

                //divertiAprendoFragment.unidadSelected(nombre);

                //new bottomsheetFragment().onBackPressed(getChildFragmentManager(), "dialog");





            }
        });

        return rootview;
    }




}
