package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import pe.sacooliveros.apptablet.PptViewer;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class unidadMotFrag extends Fragment {

    View rootview;

    FrameLayout fr_unidadMulti, fr_unidadMulti2;

    String ruta;

    TextView tx_titlemotivacion;


    ConnectionDetector cd;

    String titulo;

    static String unidadselected;

    String sharedata;


    public unidadMotFrag() {
        // Required empty public constructor
    }

    public static void UnidadSel(String unidadcode) {
        unidadselected = unidadcode;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview = inflater.inflate(R.layout.fragment_unidad_mot, container, false);

        fr_unidadMulti = rootview.findViewById(R.id.fr_unidadMulti);


        fr_unidadMulti2 = rootview.findViewById(R.id.fr_unidadMulti2);

        tx_titlemotivacion = rootview.findViewById(R.id.tx_titlemotivacion);

        cd = new ConnectionDetector(getContext());

        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

        final String accesogrado = sharedata.substring(0, 1);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            titulo = bundle.getString("tituloMotivacion");
        }

        tx_titlemotivacion.setText(titulo + " - HELICO MOTIVACIÓN");


        fr_unidadMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                {

                    if (cd.isConnected()) {


                        String URL = "http://192.169.218.177/APP/1/5/HELICO_MOTIVACION/UNIDAD_1/HELICOM_15U1.pdf";


                        //  String desc = descripcion.getText().toString();


                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "Hélico Motivación");
                        startActivity(intent);

                    } else {


                        String ssdFile = "/storage/emulated/0/SacoOliveros/HELICOM_15U1.pdf";

                        ruta = "HELICOM_15U1.pdf";


                        File file0 = new File(Environment.getExternalStorageDirectory()
                                + File.separator + "SacoOliveros" + File.separator + ruta);


                        if (file0.exists())

                        {

                            // String desc = descripcion.getText().toString();


                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "storage");
                            intent.putExtra("SSDFILE", ssdFile);
                            //intent.putExtra("Materia", desc);
                            intent.putExtra("EstadoConexion", "SinConexion");
                            startActivity(intent);

                            Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                        }

                    }


                }


            }


        });


        fr_unidadMulti2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String unidadnum = unidadselected.substring(7);


                if (cd.isConnected()) {
                    Intent intent = new Intent(getContext(), PptViewer.class);


                    //UNIDAD_1

                    String url = "http://tablet.sacooliveros.edu.pe/APP/1/" + accesogrado + "/HELICO_MOTIVACION" + "/" + unidadselected + "/" + "DIAPOSITIVAS_HM1" + accesogrado + "U" + unidadnum + "/";

                    //http://tablet.sacooliveros.edu.pe/APP/1/5/HELICO_MOTIVACION/UNIDAD_1/DIAPOSITIVAS_HM15U1/
                    //http://tablet.sacooliveros.edu.pe/APP/1/5/HELICO_MOTIVACION/UNIDAD_2/DIAPOSITIVAS_HM15U2/


                    //intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", url);
                    intent.putExtra("Materia", "Hélico Motivación");
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootview;

    }

}
