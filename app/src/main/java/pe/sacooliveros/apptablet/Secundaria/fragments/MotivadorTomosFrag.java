package pe.sacooliveros.apptablet.Secundaria.fragments;


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

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_letras;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_materiales;
import pe.sacooliveros.apptablet.Secundaria.Model.mLetras;
import pe.sacooliveros.apptablet.Secundaria.Model.mMateriasOne;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class MotivadorTomosFrag extends Fragment {

    View rootview;
    private GridView gridView, gridView2;
    ArrayList<mMateriasOne> Lista;
    ArrayList<mLetras> listaLetras;
    TextView tx_tomo2;
    ImageView tomo_back2;
    String tomodesc, temadesc;
    String acceso;
    String gradoasiste;
    String sharedata;


    public MotivadorTomosFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_tomo2_menu, container, false);
        gridView = rootview.findViewById(R.id.ma_cienciasresultados);
        gridView2 = rootview.findViewById(R.id.ma_letras);
        tomo_back2 = rootview.findViewById(R.id.img_tomoback2);
        tx_tomo2 = rootview.findViewById(R.id.tx_tomo2);

        gridView.setScrollContainer(false);
        gridView2.setScrollContainer(false);


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tomodesc = bundle.getString("tomodesc");
            temadesc = bundle.getString("description");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");

        }

        tx_tomo2.setText(tomodesc);

        if (gradoasiste == null) {
            sharedata = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
            gradoasiste = sharedata;
        }

        adapter_materiales.instantiate(acceso);
        adapter_materiales.gradoasiste(gradoasiste);

        adapter_letras.instantiate(acceso);
        adapter_letras.gradoasiste(gradoasiste);

        tomo_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentMotivadores();
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

        //TODO COMPENDIOS

        Lista = new ArrayList<mMateriasOne>();


        String gradonombrepre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");
        String gradonivel = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");


        if (gradoasiste.equalsIgnoreCase("UNI")) {
            Lista.add(new mMateriasOne(R.drawable.ciencias_1, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_2, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_4, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_5, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_6, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_7, R.drawable.download_circle));

        } else if (gradoasiste.equalsIgnoreCase("PRE") && gradonombrepre.equalsIgnoreCase("Quinto Año")) {
            Lista.add(new mMateriasOne(R.drawable.ciencias_1, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_2, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_3, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_4, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_5, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_6, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_7, R.drawable.download_circle));
        } else {
            Lista.add(new mMateriasOne(R.drawable.ciencias_1, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_2, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_3, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_4, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_5, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_6, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_7, R.drawable.download_circle));
            Lista.add(new mMateriasOne(R.drawable.ciencias_8, R.drawable.download_circle));
        }

        final adapter_materiales adapter = new adapter_materiales(getContext(), Lista);

        gridView.setAdapter(adapter);

        listaLetras = new ArrayList<mLetras>();

        listaLetras.add(new mLetras(R.drawable.letras_1, R.drawable.download_circle));
        listaLetras.add(new mLetras(R.drawable.letras_2, R.drawable.download_circle));
        listaLetras.add(new mLetras(R.drawable.letras_3, R.drawable.download_circle));
        listaLetras.add(new mLetras(R.drawable.letras_4, R.drawable.download_circle));
        listaLetras.add(new mLetras(R.drawable.letras_5, R.drawable.download_circle));

        if (gradonivel.equalsIgnoreCase("3 Secundaria") || gradonivel.equalsIgnoreCase("4 Secundaria") || gradonivel.equalsIgnoreCase("5 Secundaria")) {
            listaLetras.add(new mLetras(R.drawable.letras_6, R.drawable.download_circle));
            listaLetras.add(new mLetras(R.drawable.letras_7, R.drawable.download_circle));
            listaLetras.add(new mLetras(R.drawable.letras_8, R.drawable.download_circle));
        }

        final adapter_letras adapter2 = new adapter_letras(getContext(), listaLetras);

        gridView2.setAdapter(adapter2);
        return rootview;
    }
}
