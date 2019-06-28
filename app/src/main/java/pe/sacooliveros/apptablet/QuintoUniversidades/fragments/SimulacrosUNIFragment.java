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
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterSimulacroUni;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mSimulacrosUni;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.fragments.SeleccionExamenAdFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.SeleccionFragment;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimulacrosUNIFragment extends Fragment {

    View rootview;
    ArrayList<mSimulacrosUni> Lista;
    TextView tx_temas;
    ImageView img_temas;
    private GridView gridView;

    static String seleccionname;

    String cicloespecial;

    public SimulacrosUNIFragment() {
        // Required empty public constructor
    }

    //nombreseleccion


    public static void nombreseleccion(String nombre) {

        seleccionname = nombre;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_simulacros_uni, container, false);
        tx_temas = rootview.findViewById(R.id.tx_tomfisica);
        img_temas = rootview.findViewById(R.id.img_backSUni);
        gridView = rootview.findViewById(R.id.ma_listSUni);



        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String  tipoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");  //UNIç

                if (tipoasiste.equalsIgnoreCase("SELECCION"))
                {

                    Fragment fragment3 = new SeleccionFragment();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {
                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenUniFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }

                } else if(cicloespecial.equalsIgnoreCase("UNI")|| cicloespecial.equalsIgnoreCase("SAN MARCOS")|| cicloespecial.equalsIgnoreCase("CATOLICA") || cicloespecial.equalsIgnoreCase("PRE")){

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
            }
        });

        Lista = new ArrayList<mSimulacrosUni>();

        cicloespecial = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");  //UNIç

        if (cicloespecial.equalsIgnoreCase("SELECCION")) {
            cicloespecial = seleccionname;
        }


        if (cicloespecial.equalsIgnoreCase("UNI")) {
            Lista.add(new mSimulacrosUni(R.drawable.simulacrouni_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrouni_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrouni_3, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrouni_4, R.drawable.ic_file_download_black_24dp));

        } else if (cicloespecial.equalsIgnoreCase("Regular")) {
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_3, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_4, R.drawable.ic_file_download_black_24dp));

        } else if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
            Lista.add(new mSimulacrosUni(R.drawable.simulacro_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacro_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacro_3, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacro_4, R.drawable.ic_file_download_black_24dp));

        } else if (cicloespecial.equalsIgnoreCase("CATOLICA")) {
            Lista.add(new mSimulacrosUni(R.drawable.simulacrocatolica_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrocatolica_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrocatolica_3, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacrocatolica_4, R.drawable.ic_file_download_black_24dp));

        } else if (cicloespecial.equalsIgnoreCase("PRE")) {
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_3, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mSimulacrosUni(R.drawable.simulacropre_4, R.drawable.ic_file_download_black_24dp));

        }

        final adapterSimulacroUni adapter = new adapterSimulacroUni(getContext(), Lista);
        gridView.setAdapter(adapter);
        return rootview;
    }

}
