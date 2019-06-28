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
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterPFMatematica;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mPfMatematica;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPFMatematica extends Fragment {

    View rootview;

    private GridView gridView;
    ArrayList<mPfMatematica> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;

    String acceso;

    String gradoasiste;

    String gradonombre;


    public fragmentPFMatematica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_pfmatematica, container, false);

        gradonombre=ShareDataRead.obtenerValor(getContext(), "GradoNombre");


        tx_temas= rootview.findViewById(R.id.tx_tomfisica);
        img_temas= rootview.findViewById(R.id.img_backfisica);
        gridView= rootview.findViewById(R.id.ma_listfisica);


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");


        }

        adapterPFMatematica.instantiate(acceso);
        adapterPFMatematica.gradoasiste(gradoasiste);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(gradoasiste==null)
                {
                    gradoasiste= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
                }



                if(gradoasiste.equalsIgnoreCase("Regular") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE"))

                {
                    Fragment fragment2 = new InitialFragment();
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

                if(gradoasiste.equalsIgnoreCase("UNI")|| gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE"))
                {

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


        Lista= new ArrayList<mPfMatematica>();

        Lista.add(new mPfMatematica(R.drawable.bimestremf_1,R.drawable.ic_file_download_black_24dp));
        Lista.add(new mPfMatematica(R.drawable.bimestremf_2,R.drawable.ic_file_download_black_24dp));
        Lista.add(new mPfMatematica(R.drawable.bimestremf_3,R.drawable.ic_file_download_black_24dp));
        Lista.add(new mPfMatematica(R.drawable.bimestremf_4,R.drawable.ic_file_download_black_24dp));


        final adapterPFMatematica adapter= new adapterPFMatematica(getContext(), Lista);

        gridView.setAdapter(adapter);

        return rootview;
    }

}
