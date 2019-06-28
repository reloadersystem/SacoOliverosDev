package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.app.AlertDialog;
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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterPruebas;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterRecursos;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mRecursos;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecursosAcademicosFragment extends Fragment {

    private GridView gridView;
    ArrayList<mRecursos> Lista;
    TextView tx_temas;
    ImageView img_temas;
    View rootview;

    ArrayList<mPruebas> mListPruebas;


    public RecursosAcademicosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_recursos_academicos, container, false);

        tx_temas = rootview.findViewById(R.id.tx_recurs);
        img_temas = rootview.findViewById(R.id.img_recurs);
        gridView = rootview.findViewById(R.id.grid_recurso);

        Lista = new ArrayList<mRecursos>();

        Lista.add(new mRecursos(R.drawable.recursos_1));
        Lista.add(new mRecursos(R.drawable.recursos_2));


        final adapterRecursos adapter = new adapterRecursos(getContext(), Lista);

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

                switch (position) {
                    case 0:

                        final AlertDialog alertDialog;
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View view2 = inflater.inflate(R.layout.pruebaspopup, null);

                        GridView lvView = view2.findViewById(R.id.grid_pruebas);
                        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);

                        builder.setView(view2);
                        alertDialog = builder.create();

                        alertDialog.show();
//
                        mListPruebas = new ArrayList<mPruebas>();

                        mListPruebas.add(new mPruebas("CONAMAT", "http://www.conamat.edu.pe/web/fragmentAulaVirtual"));
                        mListPruebas.add(new mPruebas("CANGURO MATEMÁTICO", "http://www.canguromat.org.es/"));
                        mListPruebas.add(new mPruebas("CONCURSO PRIMAVERA DE MATEMÁTICA ", "https://www.concursoprimavera.es/#concurso"));
                        mListPruebas.add(new mPruebas("ONEM", "https://onemperu.wordpress.com/pruebas/"));
                        mListPruebas.add(new mPruebas("OLIMPIADA MEXICANA DE MATEMÁTICA", "http://www.ommenlinea.org/publicaciones/folletos-introductorios/"));
                        mListPruebas.add(new mPruebas("OLIMPIADA PARAGUAYA DE MATEMÁTICA", "http://www.omapa.org/entrenamiento/"));
                        mListPruebas.add(new mPruebas("OLIMPIADA BOLIVARIANA DE MATEMÁTICA", "http://www.acm.ciens.ucv.ve/entrenamiento.php"));
                        mListPruebas.add(new mPruebas("OLIMPIADA BRASILEÑA DE MATEMÁTICA", "http://www.obmep.org.br/"));


                        final adapterPruebas adapter2 = new adapterPruebas(getContext(), mListPruebas);
                        lvView.setAdapter(adapter2);


                        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                                switch(position)
                                {
                                    case 0:

                                    {
                                        Uri uri = Uri.parse("http://www.conamat.edu.pe/web/fragmentAulaVirtual");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                        break;


                                    case 1:

                                    {
                                        Uri uri = Uri.parse("http://www.canguromat.org.es/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;


                                    case 2:

                                    {
                                        Uri uri = Uri.parse("https://www.concursoprimavera.es/#concurso");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;


                                    case 3:

                                    {
                                        Uri uri = Uri.parse("https://onemperu.wordpress.com/pruebas/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;


                                    case 4:

                                    {
                                        Uri uri = Uri.parse("http://www.ommenlinea.org/publicaciones/folletos-introductorios/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;


                                    case 5:

                                    {
                                        Uri uri = Uri.parse("http://www.omapa.org/entrenamiento/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;

                                    case 6:

                                    {
                                        Uri uri = Uri.parse("http://www.acm.ciens.ucv.ve/entrenamiento.php");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;

                                    case 7:

                                    {
                                        Uri uri = Uri.parse("http://www.obmep.org.br/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);

                                    }
                                    break;

                                }


                            }
                        });


                        btn_cerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });


                        break;

                    case 1: {
                        Uri uri3 = Uri.parse("https://www.youtube.com/watch?time_continue=14239&amp=&v=KP4EDhow6p8");
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, uri3);
                        getContext().startActivity(intent3);
                    }
                    break;


                }

            }
        });

        return rootview;
    }

}
