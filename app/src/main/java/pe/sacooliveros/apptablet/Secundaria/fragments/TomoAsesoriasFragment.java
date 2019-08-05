package pe.sacooliveros.apptablet.Secundaria.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_VideoMotivadores;
import pe.sacooliveros.apptablet.Secundaria.Model.mVideoMotivadores;

/**
 * A simple {@link Fragment} subclass.
 */
public class TomoAsesoriasFragment extends Fragment {

    View rootview;
    private static final String TAG = "VideoMotivadoresFragmen";
    private GridView gridView;
    ArrayList<mVideoMotivadores> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;
    String gradoasiste;
    String tipogradoasiste;

    public TomoAsesoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tomo_asesorias, container, false);

        img_temas = rootview.findViewById(R.id.img_backmotivadores);
        gridView = rootview.findViewById(R.id.grid_motivadores);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });

        Lista = new ArrayList<mVideoMotivadores>();

        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_1, "Tomo 1"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_2, "Tomo 2"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_3, "Tomo 3"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_4, "Tomo 4"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_5, "Tomo 5"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_6, "Tomo 6"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_7, "Tomo 7"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_8, "Tomo 8"));

        final adapter_VideoMotivadores adapter = new adapter_VideoMotivadores(getContext(), Lista);
        gridView.setAdapter(adapter);

        final AsesoriaCap1_Fragment asesoriaCap1_fragment= new AsesoriaCap1_Fragment();
        final AsesoriaCap2_Fragment asesoriaCap2_fragment= new AsesoriaCap2_Fragment();
        final AsesoriaCap3_Fragment asesoriaCap3_fragment= new AsesoriaCap3_Fragment();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                for (int a = 0; a < 9; a++) {

                    if (position == a) {

                        int inicio = a + 1;

                        Fragment fragment = new contentAsesoriasFragment();

                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            asesoriaCap1_fragment.tomolistener("TOMO"+inicio);
                            asesoriaCap2_fragment.tomolistener("TOMO"+inicio);
                            asesoriaCap3_fragment.tomolistener("TOMO"+inicio);

                            Bundle args = new Bundle();
                            args.putString("Tomo", "Tomo " + inicio);

                            fragment.setArguments(args);

                            FragmentTransaction ftransaction = fmanager.beginTransaction();

                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }
                }

            }
        });

        return rootview;
    }
}
