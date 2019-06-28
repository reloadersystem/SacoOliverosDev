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

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAdmisionCiencia;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterCapitulosLetra;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mCapitulosAdmisionCiencia;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mCapitulosAdmisionLetras;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class tomoCapitulosFragment extends Fragment {


    View rootview;

    private GridView gridView, gridView2;

    ArrayList<mCapitulosAdmisionCiencia> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;

    String gradoasiste;

    ArrayList<mCapitulosAdmisionLetras> Lista2;

    String acceso;


    public tomoCapitulosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tomo_capitulos, container, false);

        tx_temas = rootview.findViewById(R.id.tx_tomoCapitulos);
        img_temas = rootview.findViewById(R.id.img_tomoback2);
        gridView = rootview.findViewById(R.id.ma_cienciasresultados);
        gridView2 = rootview.findViewById(R.id.grid_letrascapitulos);

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

                String sharedata= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

                if(sharedata.equalsIgnoreCase("SELECCION"))

                {
                    Fragment fragment3 = new CapitulosAdmisionfragment();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenUniFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }

                }
                else
                {
                    Fragment fragment3 = new CapitulosAdmisionfragment();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                }


            }
        });

        adapterAdmisionCiencia.instantiate(acceso);
        adapterCapitulosLetra.instantiate(acceso);


        adapterCapitulosLetra.gradoasiste(gradoasiste);
        adapterAdmisionCiencia.gradoasiste(gradoasiste);


        Lista = new ArrayList<mCapitulosAdmisionCiencia>();

        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_1, R.drawable.download_circle));
        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_2, R.drawable.download_circle));
        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_4, R.drawable.download_circle));
        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_5, R.drawable.download_circle));
        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_6, R.drawable.download_circle));
        Lista.add(new mCapitulosAdmisionCiencia(R.drawable.ciencias_7, R.drawable.download_circle));


        final adapterAdmisionCiencia adapter = new adapterAdmisionCiencia(getContext(), Lista);

        gridView.setAdapter(adapter);


        Lista2 = new ArrayList<mCapitulosAdmisionLetras>();

        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_1, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_2, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_3, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_4, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_5, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_6, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_7, R.drawable.download_circle));
        Lista2.add(new mCapitulosAdmisionLetras(R.drawable.letras_8, R.drawable.download_circle));


        final adapterCapitulosLetra adapter2 = new adapterCapitulosLetra(getContext(), Lista2);

        gridView2.setAdapter(adapter2);

        return rootview;
    }

}
