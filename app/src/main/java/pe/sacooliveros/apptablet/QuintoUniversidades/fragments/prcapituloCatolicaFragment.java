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

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterBimestreCatolica;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mBimestreCatolica;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class prcapituloCatolicaFragment extends Fragment {

    View rootview;

    private GridView gridView;
    ArrayList<mBimestreCatolica> Lista;

    TextView textView;

    ImageView img_temas;

    String bimestredesc;


    public prcapituloCatolicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_prcapitulo_catolica, container, false);

        textView = rootview.findViewById(R.id.tx_tituloCatolica);
        img_temas = rootview.findViewById(R.id.img_backCatolica);
        gridView = rootview.findViewById(R.id.grid_capituloCatolica);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            bimestredesc = bundle.getString("bimestredesc");
        }

        textView.setText(bimestredesc);

        Lista = new ArrayList<mBimestreCatolica>();

        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_1, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_2, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_3, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_4, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_5, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.catolicatomo_6, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_7, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_8, R.drawable.descarga));
        Lista.add(new mBimestreCatolica(R.drawable.imagecatolica_9, R.drawable.descarga));

        adapterBimestreCatolica adapter = new adapterBimestreCatolica(getContext(), Lista);

        gridView.setAdapter(adapter);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new CapitulosAdmisionfragment();
                FragmentManager fmanager = getActivity().getSupportFragmentManager();
                if (fmanager != null) {

                    FragmentTransaction ftransaction = fmanager.beginTransaction();
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

