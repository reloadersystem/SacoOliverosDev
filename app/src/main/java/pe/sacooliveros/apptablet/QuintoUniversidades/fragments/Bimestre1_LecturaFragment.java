package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterLecturaBimestre;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mLecturaBimestre;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.GeneralFragmentManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre1_LecturaFragment extends Fragment {


    ArrayList<mLecturaBimestre> Lista;
    ImageView img_temas;
    private GridView gridView;
    View rootview;


    public Bimestre1_LecturaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_bimestre1__lectura, container, false);
        img_temas = rootview.findViewById(R.id.img_backanual);
        gridView = rootview.findViewById(R.id.ma_listanual);


        adapterLecturaBimestre adapterLecturaBimestre = new adapterLecturaBimestre();
        adapterLecturaBimestre.bimestreSeleccionado("BIMESTRE1");

        Lista = new ArrayList<mLecturaBimestre>();

        Lista.add(new mLecturaBimestre(R.drawable.catolicatomo_6, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mLecturaBimestre(R.drawable.imagecatolica_7, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mLecturaBimestre(R.drawable.imagecatolica_8, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mLecturaBimestre(R.drawable.imagecatolica_9, R.drawable.ic_file_download_black_24dp));


        final adapterLecturaBimestre adapter = new adapterLecturaBimestre(getContext(), Lista);

        gridView.setAdapter(adapter);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainFragmentUni mainFragmentUni = new mainFragmentUni();
                GeneralFragmentManager.setFragmentWithReplace(getActivity(), R.id.contenedorFragments, mainFragmentUni);


                // getActivity().getSupportFragmentManager().popBackStack();

                // getActivity().getSupportFragmentManager().popBackStack("mainfragmentuni",0);

            }
        });

        return rootview;
    }

}
