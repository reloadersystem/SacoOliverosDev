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
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasCiencia;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasLetras;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoCienciasDiap;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoLetrasDiap;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiapositivasTomosFrag extends Fragment {

    View rootview;

    private GridView gridView, gridView2;
    ArrayList<mTomoCienciasDiap> Lista;
    String descrip, grado;
    TextView tx_temas;
    ImageView img_temas;
    String gradoasiste;
    ArrayList<mTomoLetrasDiap> Lista2;
    String acceso;


    public DiapositivasTomosFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_diapositvastomo, container, false);


        tx_temas = rootview.findViewById(R.id.tx_tomfisica);
        img_temas = rootview.findViewById(R.id.img_tomoSeminario);
        gridView = rootview.findViewById(R.id.gb_topgrid);
        gridView2 = rootview.findViewById(R.id.gb_bottomgrid);

        gridView2.setScrollContainer(false);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            descrip = bundle.getString("tomodesc");
            grado = bundle.getString("description");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        adapterDiapositivasCiencia.instantiate(acceso);
        adapterDiapositivasCiencia.gradoasiste(gradoasiste);

        adapterDiapositivasLetras.instantiate(acceso);
        adapterDiapositivasLetras.gradoasiste(gradoasiste);

        tx_temas.setText(descrip.toUpperCase());

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentHDiapositivas();
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

        Lista = new ArrayList<mTomoCienciasDiap>();

        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_1, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_2, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_3, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_4, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_5, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_6, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_7, R.drawable.download_circle));
        Lista.add(new mTomoCienciasDiap(R.drawable.ciencias_8, R.drawable.download_circle));

        final adapterDiapositivasCiencia adapter = new adapterDiapositivasCiencia(getContext(), Lista);
        gridView.setAdapter(adapter);

        Lista2 = new ArrayList<mTomoLetrasDiap>();

        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_1, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_2, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_3, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_4, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_5, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_6, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_7, R.drawable.download_circle));
        Lista2.add(new mTomoLetrasDiap(R.drawable.letras_8, R.drawable.download_circle));

        //TipoGradoAsiste

        String grado = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");
        String tipogrado = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");



        if (tipogrado.equalsIgnoreCase("SAN MARCOS") || tipogrado.equalsIgnoreCase("UNI") ) {

        }else
        {
            Lista2.add(new mTomoLetrasDiap(R.drawable.letras_9, R.drawable.download_circle));
        }

        if (grado.equalsIgnoreCase("1 Secundaria") || grado.equalsIgnoreCase("2 Secundaria")) {
            Lista2.add(new mTomoLetrasDiap(R.drawable.letras_10, R.drawable.download_circle));
            Lista2.add(new mTomoLetrasDiap(R.drawable.letras_11, R.drawable.download_circle));
        }

        final adapterDiapositivasLetras adapter2 = new adapterDiapositivasLetras(getContext(), Lista2);
        gridView2.setAdapter(adapter2);

        return rootview;
    }
}
