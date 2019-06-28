package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.PptViewer;
import pe.sacooliveros.apptablet.Primaria.Adapter.adapterAsesoria;
import pe.sacooliveros.apptablet.Primaria.Model.mAsesoria;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class asesoriaFragment extends Fragment {

    View rootview;

    private GridView gridView;

    ArrayList<mAsesoria> Lista;

    ConnectionDetector cd;

    String servidor_ruta;

    String sharedata;


    public asesoriaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_asesoria, container, false);

        gridView = rootview.findViewById(R.id.ma_asesoria);

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(getContext());

        Lista = new ArrayList<mAsesoria>();

        Lista.add(new mAsesoria(R.drawable.unidad1));
        Lista.add(new mAsesoria(R.drawable.unidad2));
        Lista.add(new mAsesoria(R.drawable.unidad3));
        Lista.add(new mAsesoria(R.drawable.unidad4));
        Lista.add(new mAsesoria(R.drawable.unidad5));
        Lista.add(new mAsesoria(R.drawable.unidad6));
        Lista.add(new mAsesoria(R.drawable.unidad7));
        Lista.add(new mAsesoria(R.drawable.unidad8));


        final adapterAsesoria adapter = new adapterAsesoria(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                mAsesoria mAsesoria = (mAsesoria) adapter.getItem(position);

                sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);

                switch (position) {

                    case 0: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";

                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 1");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 1: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";


                            //intent.putExtra("ViewType", "internet");


                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 2");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;

                    case 2:

                    {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";

                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 3");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }


                    break;


                    case 3:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";

                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 4");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 4:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 5");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;


                    case 5:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 6");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 6:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";

                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 7");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 7:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/ASESORIAS_VIRTUALES/UNIDAD_" + (position + 1) + "/";

                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 8");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;

                }

            }
        });


        return rootview;
    }

}
