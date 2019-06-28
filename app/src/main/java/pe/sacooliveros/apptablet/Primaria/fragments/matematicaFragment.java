package pe.sacooliveros.apptablet.Primaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Adapter.adapterMatematica;
import pe.sacooliveros.apptablet.Primaria.Model.mMatematica;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class matematicaFragment extends Fragment {

    View rootview;

    private GridView gridView;
    ArrayList<mMatematica> Lista;
    TextView tx_temas;
    ImageView img_temas;
    ConnectionDetector cd;
    String asignatura;

    int position;





    public matematicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_matematica, container, false);

        gridView= rootview.findViewById(R.id.gridlist);

        //ma_matematica

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            asignatura = bundle.getString("tomolibro");


        }


        Lista= new ArrayList<mMatematica>();

        Lista.add(new mMatematica("VER DETALLE","ARITMÉTICA",R.drawable.munidad_1, R.drawable.download_ico));
        Lista.add(new mMatematica("VER DETALLE","ÁLGEBRA",R.drawable.munidad_1, R.drawable.download_ico));
        Lista.add(new mMatematica("VER DETALLE","GEOMETRÍA",R.drawable.munidad_1, R.drawable.download_ico));
        Lista.add(new mMatematica("VER DETALLE","TRIGONOMETRÍA",R.drawable.munidad_1, R.drawable.download_ico));
        Lista.add(new mMatematica("VER DETALLE","CÁLCULO MENTAL",R.drawable.munidad_1, R.drawable.download_ico));


        final adapterMatematica adapter= new adapterMatematica( getContext(), Lista);

        gridView.setAdapter(adapter);


        return rootview;
    }



}
