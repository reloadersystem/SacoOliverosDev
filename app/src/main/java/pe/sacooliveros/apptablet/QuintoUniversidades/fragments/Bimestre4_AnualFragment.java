package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAnualExamen4;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAnualExamen4B;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre4_AnualFragment extends Fragment {

    View rootview;
    ArrayList<mAnualExamen4B> Lista;

    ImageView img_temas;
    PopupMenu popup;
    private GridView gridView;
    ConnectionDetector cd;


    String servidor_ruta;


    String ruta;

    String urlADescargar;

    String ruta_storage;

    String tipogrado;

    String ciclo;


    public Bimestre4_AnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_bimestre4__anual, container, false);

        img_temas = rootview.findViewById(R.id.img_backanual2);
        gridView = rootview.findViewById(R.id.ma_listanual2);




        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new mainFragmentUni();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {
                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }

        });


        Lista = new ArrayList<mAnualExamen4B>();

        tipogrado = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        if (tipogrado.equalsIgnoreCase("UNI")) {
            ciclo = "3";
            Lista.add(new mAnualExamen4B(R.drawable.admisionanual_10, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionanual_11, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionanual_12, R.drawable.ic_file_download_black_24dp));
        } else if (tipogrado.equalsIgnoreCase("SAN MARCOS")) {
            ciclo = "4";
            Lista.add(new mAnualExamen4B(R.drawable.admisionsm_10, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionsm_11, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionsm_12, R.drawable.ic_file_download_black_24dp));

        } else if (tipogrado.equalsIgnoreCase("CATOLICA")) {
            ciclo = "5";
            Lista.add(new mAnualExamen4B(R.drawable.admisioncatolica_10, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisioncatolica_11, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisioncatolica_12, R.drawable.ic_file_download_black_24dp));

        } else if (tipogrado.equalsIgnoreCase("PRE")) {
            ciclo = "6";
            Lista.add(new mAnualExamen4B(R.drawable.admisionpre_10, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionpre_11, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen4B(R.drawable.admisionpre_12, R.drawable.ic_file_download_black_24dp));

        }

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(getContext());

        final adapterAnualExamen4 adapter = new adapterAnualExamen4(getContext(), Lista);

        gridView.setAdapter(adapter);


        return rootview;
    }


}
