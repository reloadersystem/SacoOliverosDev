package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.content.Intent;
import android.net.Uri;
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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterConcursos;
import pe.sacooliveros.apptablet.Seleccion.Model.mConcurso;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConcursoFragment extends Fragment {

    private GridView gridView;
    ArrayList<mConcurso> Lista;
    TextView tx_temas;
    ImageView img_temas;
    View rootview;



    public ConcursoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.concurso_fragment, container, false);


        tx_temas = rootview.findViewById(R.id.tx_concurso);
        img_temas = rootview.findViewById(R.id.img_concurso);
        gridView = rootview.findViewById(R.id.grid_concurso);

        Lista = new ArrayList<mConcurso>();

        Lista.add(new mConcurso(R.drawable.concurso_1));
        Lista.add(new mConcurso(R.drawable.concurso_2));


        final adapterConcursos adapter = new adapterConcursos(getContext(), Lista);

        gridView.setAdapter(adapter);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new SeleccionFragment();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {
                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenUniFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }

        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:

                        Uri uri = Uri.parse("http://www.conamat.edu.pe/web/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);

                        break;

                    case 1:

                        Uri uri2 = Uri.parse("https://ebinaria.com/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);

                        break;



                }

            }
        });





        return rootview;
    }

}
