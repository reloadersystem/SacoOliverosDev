package pe.sacooliveros.apptablet.Primaria.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class divertiAprendoFragment extends Fragment {

    View rootview;


    static String sharedata;

    ConnectionDetector cd;

    TextView tx_aprendo, tx_titulo;


    public divertiAprendoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_divertiaprendo, container, false);

        tx_aprendo = rootview.findViewById(R.id.tx_aprendo);
        tx_titulo = rootview.findViewById(R.id.tx_title);


        //new bottomsheetFragment().show(getChildFragmentManager(), "dialog");


        return rootview;
    }


}
