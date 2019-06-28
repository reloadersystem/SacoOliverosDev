package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.content.Intent;
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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterAnualSeleccion;
import pe.sacooliveros.apptablet.Seleccion.Model.mAnuaSeleccion;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AcademiaFragment extends Fragment {

    private GridView gridView;
    ArrayList<mAnuaSeleccion> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;
    View rootview;
    String gradoasiste;
    String datoshare;

    String servidor_ruta;

    ConnectionDetector cd;

    String ruta;


    public AcademiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.academia_fragment, container, false);

        gridView = rootview.findViewById(R.id.grid_anualseleccion);
        img_temas = rootview.findViewById(R.id.img_anualseleccion);



        Lista = new ArrayList<mAnuaSeleccion>();

        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_1));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_2));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_3));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_4));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_5));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_6));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_7));
        Lista.add(new mAnuaSeleccion(R.drawable.secundariatomovm_8));

        final adapterAnualSeleccion adapter = new adapterAnualSeleccion(getContext(), Lista);

        gridView.setAdapter(adapter);

        cd = new ConnectionDetector(getContext());

        servidor_ruta = getContext().getString(R.string.servidor_ruta);


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


                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO1.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 1 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;


                    case 1:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO2.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 2 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;



                    case 2:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO3.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 3 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;


                    case 3:

                        if (cd.isConnected()) {

                        String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO4.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 4 - LIBRO ACADEMIA");
                        getContext().startActivity(intent);

                    }

                        break;


                    case 4:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO5.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 5 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }


                        break;



                    case 5:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO6.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 6 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;


                    case 6:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO7.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 7 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;



                    case 7:

                        if (cd.isConnected()) {

                            String URL=  servidor_ruta+"/APP/7/5/LIBRO_ACADEMIA/SELECCION75_TOMO8.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 8 - LIBRO ACADEMIA");
                            getContext().startActivity(intent);

                        }

                        break;


                }

            }
        });

        return rootview;
    }

}
