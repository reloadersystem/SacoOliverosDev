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

import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_CompendioCiencias;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_CompendioLetras;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proletras;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mCompendioCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mCompendioLetras;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompendiosTomosFrag extends Fragment {

    View rootview;
    private GridView gridView, gridView2;
    ArrayList<mCompendioCiencias> Lista;
    ArrayList<mCompendioLetras> Lista2;

    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;
    String gradoasiste;
    String sharedata;

    public CompendiosTomosFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_compendios_tomos, container, false);

        tx_temas= rootview.findViewById(R.id.tx_temasDiapositivas);
        img_temas= rootview.findViewById(R.id.img_temasCompendio);
        gridView= rootview.findViewById(R.id.ma_tomoDiapositivas);
        gridView2= rootview.findViewById(R.id.ma_tomoCompendio2);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            //descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");

        }


        if(gradoasiste==null)
        {
            sharedata= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
            gradoasiste=sharedata;

        }



        adapter_CompendioCiencias.instantiate(acceso);
        adapter_CompendioCiencias.gradoasiste(gradoasiste);

        adapter_CompendioLetras.instantiate(acceso);
        adapter_CompendioLetras.gradoasiste(gradoasiste);


        Lista= new ArrayList<mCompendioCiencias>();

        Lista.add(new mCompendioCiencias(R.drawable.ciencias_1,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_2,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_3,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_4,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_5,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_6,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_7,R.drawable.download_circle));
        Lista.add(new mCompendioCiencias(R.drawable.ciencias_8,R.drawable.download_circle));


        final adapter_CompendioCiencias adapter= new adapter_CompendioCiencias( getContext(), Lista);

        gridView.setAdapter(adapter);


        Lista2= new ArrayList<mCompendioLetras>();

        Lista2.add(new mCompendioLetras(R.drawable.letras_1,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_2,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_3,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_4,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_5,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_6,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_7,R.drawable.download_circle));
        Lista2.add(new mCompendioLetras(R.drawable.letras_8,R.drawable.download_circle));

        final adapter_CompendioLetras adapter2= new adapter_CompendioLetras( getContext(), Lista2);

        gridView2.setAdapter(adapter2);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Fragment fragment2 = new fragmentCompendios();
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

        return rootview;
    }

}
