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
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterEFisica;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mEfisica;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre3_Fragment extends Fragment {


    View rootview;

    private GridView gridView;
    ArrayList<mEfisica> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;


    String gradoasiste;

    String gradonombre;

    public Bimestre3_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_bimestre3_, container, false);
        tx_temas= rootview.findViewById(R.id.tx_tomfisica);
        img_temas= rootview.findViewById(R.id.img_backfisica);
        gridView= rootview.findViewById(R.id.ma_listfisica);

        gradoasiste= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        gradonombre=ShareDataRead.obtenerValor(getContext(), "GradoNombre");

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
//                if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE"))
//
//                {
//                    Fragment fragment2 = new InitialFragment();
//                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                    if (fmanager2 != null) {
//                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                        if (ftransaction != null) {
//                            ftransaction.replace(R.id.contenedorFragments, fragment2);
//                            ftransaction.addToBackStack("");
//                            ftransaction.commit();
//                        }
//                    }
//
//                }
//
//                if(gradoasiste.equalsIgnoreCase("Uni")|| gradoasiste.equalsIgnoreCase("SAN MARCOS")|| gradoasiste.equalsIgnoreCase("CATOLICA") || gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE"))
//                {
//
//                    Fragment fragment2 = new mainFragmentUni();
//                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                    if (fmanager2 != null) {
//                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                        if (ftransaction != null) {
//                            ftransaction.replace(R.id.contenedorFragments, fragment2);
//                            ftransaction.addToBackStack("");
//                            ftransaction.commit();
//                        }
//                    }
//                }

                getActivity().getSupportFragmentManager().popBackStack();



            }
        });


        Lista= new ArrayList<mEfisica>();

        Lista.add(new mEfisica(R.drawable.edufisicaini_1));
        Lista.add(new mEfisica(R.drawable.edufisicaini_2));
        Lista.add(new mEfisica(R.drawable.edufisicaini_3));
        Lista.add(new mEfisica(R.drawable.edufisicaini_4));
        Lista.add(new mEfisica(R.drawable.edufisicaini_5));

        final adapterEFisica adapter= new adapterEFisica(getContext(), Lista);

        gridView.setAdapter(adapter);


        return rootview;
    }

}
