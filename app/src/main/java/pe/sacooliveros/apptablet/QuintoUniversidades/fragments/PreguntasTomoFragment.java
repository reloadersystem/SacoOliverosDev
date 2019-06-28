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

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapter_AdmisionCiencias;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapter_AdmisionLetras;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAdmisionCiencias;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAdmisionLetras;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PreguntasTomoFragment extends Fragment {

    View rootview;
    private GridView gridView, gridView2;
    ArrayList<mAdmisionCiencias> Lista;
    ArrayList<mAdmisionLetras> Lista2;
    ImageView img_temas;
    String  grado;
    String acceso;
    String gradoasiste;


    public PreguntasTomoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_preguntatomo, container, false);

        img_temas= rootview.findViewById(R.id.ma_admisionPreg);
        gridView= rootview.findViewById(R.id.ma_tomoAdmisionCiencias);
        gridView2= rootview.findViewById(R.id.ma_tomoAdmisionLetras);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new examenCapitulosFragment();
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


        adapter_AdmisionCiencias.instantiate(acceso);


        adapter_AdmisionLetras.instantiate(acceso);



        Lista= new ArrayList<mAdmisionCiencias>();

        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_1,R.drawable.download_circle));
        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_2,R.drawable.download_circle));
        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_4,R.drawable.download_circle));
        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_5,R.drawable.download_circle));
        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_6,R.drawable.download_circle));
        Lista.add(new mAdmisionCiencias(R.drawable.ciencias_7,R.drawable.download_circle));

        final adapter_AdmisionCiencias adapter= new adapter_AdmisionCiencias( getContext(), Lista);

        gridView.setAdapter(adapter);


        Lista2= new ArrayList<mAdmisionLetras>();

        Lista2.add(new mAdmisionLetras(R.drawable.letras_1,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_2,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_3,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_4,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_5,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_6,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_7,R.drawable.download_circle));
        Lista2.add(new mAdmisionLetras(R.drawable.letras_8,R.drawable.download_circle));

        final adapter_AdmisionLetras adapter2= new adapter_AdmisionLetras( getContext(), Lista2);

        gridView2.setAdapter(adapter2);

        return rootview;
    }

}
