package pe.sacooliveros.apptablet.QuintoCatolica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupMenu;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoCatolica.Adapter.adapterMainCatolica;
import pe.sacooliveros.apptablet.QuintoCatolica.Model.mMainCatolica;
import pe.sacooliveros.apptablet.QuintoSanMarcos.Adapter.adapterMainSM;
import pe.sacooliveros.apptablet.QuintoSanMarcos.Model.mMainSM;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragmentCatolica extends Fragment {

    View  rootview;

    private GridView gridView;
    ArrayList<mMainCatolica> Lista;

    String grado;

    ConnectionDetector cd;

    PopupMenu popup;

    static String nivel;
    static String nivelacceso;

    static String gradoasiste;

    String ruta;

    String urlADescargar;

    String  ruta_storage;


    public mainFragmentCatolica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_mainfragment_catolica, container, false);
        
        gridView= rootview.findViewById(R.id.ma_mainCatolica);

        cd = new ConnectionDetector(getContext());

        Lista= new ArrayList<mMainCatolica>();

        Lista.add(new mMainCatolica(R.drawable.secundariamain_1));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_2));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_3));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_7));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_4));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_5));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_9));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_6));
        Lista.add(new mMainCatolica(R.drawable.secundariamain_14));


        final adapterMainCatolica adapter= new adapterMainCatolica(getContext(), Lista);

        gridView.setAdapter(adapter);
        
        
        return rootview;
    }

}
