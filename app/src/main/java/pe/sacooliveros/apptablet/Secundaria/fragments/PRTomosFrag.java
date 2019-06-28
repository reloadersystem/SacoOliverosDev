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

import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterTomoDiapo;
import pe.sacooliveros.apptablet.Secundaria.Model.mNumTomoDiapo;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PRTomosFrag extends Fragment {

 View rootview;

    private GridView gridView;
    ArrayList<mNumTomoDiapo> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;




    public PRTomosFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview= inflater.inflate(R.layout.fragment_diap_tomos, container, false);


        tx_temas= rootview.findViewById(R.id.tx_tomoDiap);
        img_temas= rootview.findViewById(R.id.img_tomoDiap);
        gridView= rootview.findViewById(R.id.ma_materiasDiap);



        Bundle bundle = this.getArguments();
        if (bundle != null) {

            descrip = bundle.getString("tomodesc");
            grado = bundle.getString("description");

        }

        tx_temas.setText(descrip);




        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentPropuestos();
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


        Lista= new ArrayList<mNumTomoDiapo>();

        Lista.add(new mNumTomoDiapo("Detalle","Ciencias",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));
        Lista.add(new mNumTomoDiapo("Detalle","Letras",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));
        Lista.add(new mNumTomoDiapo("Detalle","Plan Lector",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));
        Lista.add(new mNumTomoDiapo("Detalle","Educaciòn Física",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));
        Lista.add(new mNumTomoDiapo("Detalle","Computación",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));
        Lista.add(new mNumTomoDiapo("Detalle","Ajedrez",R.drawable.habitos_estudio_2,R.drawable.ic_cloud_download_black_24dp));


        final adapterTomoDiapo adapter= new adapterTomoDiapo( getContext(), Lista);

        gridView.setAdapter(adapter);





        return rootview;
    }

}
