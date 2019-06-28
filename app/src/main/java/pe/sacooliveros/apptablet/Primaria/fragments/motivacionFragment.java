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
import pe.sacooliveros.apptablet.Primaria.Adapter.adapterMotivacion;
import pe.sacooliveros.apptablet.Primaria.Model.mMotivacion;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class motivacionFragment extends Fragment {


    View rootview;
    private GridView gridView;

    String drawable;

    ArrayList<mMotivacion> Lista;

    ConnectionDetector cd;

    String sharedata;


    public motivacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_motivacion, container, false);

        gridView = rootview.findViewById(R.id.ma_motivacion);


        Lista = new ArrayList<mMotivacion>();

        Lista.add(new mMotivacion(R.drawable.motivacion1));
        Lista.add(new mMotivacion(R.drawable.motivacion2));
        Lista.add(new mMotivacion(R.drawable.motivacion3));
        Lista.add(new mMotivacion(R.drawable.motivacion4));
        Lista.add(new mMotivacion(R.drawable.motivacion5));
        Lista.add(new mMotivacion(R.drawable.motivacion6));
        Lista.add(new mMotivacion(R.drawable.motivacion7));
        Lista.add(new mMotivacion(R.drawable.motivacion8));

        final adapterMotivacion adapter = new adapterMotivacion(getContext(), Lista);

        gridView.setAdapter(adapter);


        cd = new ConnectionDetector(getContext());

        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

        final String accesogrado = sharedata.substring(0, 1);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                mMotivacion mMotivacion = (mMotivacion) adapter.getItem(position);


                switch (position) {

                    case 0: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_1/DIAPOSITIVAS_HM1" + accesogrado + "U1/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 1 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }


                    case 1: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_2/DIAPOSITIVAS_HM1" + accesogrado + "U2/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 2 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 2:

                    {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_3/DIAPOSITIVAS_HM1" + accesogrado + "U3/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 3 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 3:

                    {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_4/DIAPOSITIVAS_HM1" + accesogrado + "U4/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 4 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 4:

                    {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_5/DIAPOSITIVAS_HM1" + accesogrado + "U5/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 5 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 5:

                    {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_6/DIAPOSITIVAS_HM1" + accesogrado + "U6/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 6 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 6: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_7/DIAPOSITIVAS_HM1" + accesogrado + "U7/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 7 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 7:

                    {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION/UNIDAD_8/DIAPOSITIVAS_HM1" + accesogrado + "U8/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "UNIDAD 8 - Helico Motivación");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                }
            }
        });


        return rootview;

    }

}

