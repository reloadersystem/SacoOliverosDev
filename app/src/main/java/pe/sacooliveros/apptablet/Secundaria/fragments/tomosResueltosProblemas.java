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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterResueltosCiencia;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterResueltosLetras;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosLetras;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoCienciasResueltos;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoLetrasResueltos;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class tomosResueltosProblemas extends Fragment {

    View rootview;

    private GridView gridView, gridView2;
    ArrayList<mTomoCienciasResueltos> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;

    String gradoasiste;

    ArrayList<mTomoLetrasResueltos> Lista2;

    String acceso;

    LinearLayout lslist2;


    public tomosResueltosProblemas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tomos_resueltos, container, false);

        tx_temas = rootview.findViewById(R.id.tx_titleResueltos);
        img_temas = rootview.findViewById(R.id.img_tomoResueltos);
        gridView = rootview.findViewById(R.id.grid_resueltosciencias);
        gridView2 = rootview.findViewById(R.id.grid_resueltosletras);
        lslist2= rootview.findViewById(R.id.lnlist2);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            descrip = bundle.getString("tomodesc");
            grado = bundle.getString("description");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        tx_temas.setText(descrip);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentResueltosProblemas();
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

        adapterResueltosCiencia.instantiate(acceso);
        adapterResueltosLetras.instantiate(acceso);

        Lista = new ArrayList<mTomoCienciasResueltos>();

        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_1, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_2, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_3, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_4, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_5, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_6, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_7, R.drawable.download_circle));
        Lista.add(new mTomoCienciasResueltos(R.drawable.ciencias_8, R.drawable.download_circle));


        final adapterResueltosCiencia adapter = new adapterResueltosCiencia(getContext(), Lista);

        gridView.setAdapter(adapter);

        String gradousuario = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

        Lista2 = new ArrayList<mTomoLetrasResueltos>();

        Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_1, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_2, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_3, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_4, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_5, R.drawable.download_circle));


        if (gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria") || gradousuario.equalsIgnoreCase("5 Secundaria"))
        {
            Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_6, R.drawable.download_circle));
            Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_7, R.drawable.download_circle));
            Lista2.add(new mTomoLetrasResueltos(R.drawable.letras_8, R.drawable.download_circle));

        }

        final adapterResueltosLetras adapter2 = new adapterResueltosLetras(getContext(), Lista2);

        gridView2.setAdapter(adapter2);


        return rootview;
    }

}
