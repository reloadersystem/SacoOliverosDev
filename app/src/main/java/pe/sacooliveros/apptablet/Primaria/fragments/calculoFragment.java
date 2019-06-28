package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class calculoFragment extends Fragment {

    View rootview;

    FrameLayout fr_calculo1, fr_calculo2;

    String ruta;


    ConnectionDetector cd;
    
    String servidor_ruta;

    String nivelacceso;




    public calculoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_calculo, container, false);

        fr_calculo1=rootview.findViewById(R.id.fr_calculo1);

        fr_calculo2=rootview.findViewById(R.id.fr_calculo2);

        cd = new ConnectionDetector(getContext());

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

           // tomoNum = bundle.getString("tomodato");
            nivelacceso = bundle.getString("ACCESO");
        }


        fr_calculo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                {

                    if (cd.isConnected()) {

                        //http://app8.sacooliveros.edu.pe/APP/1/"+nivelacceso+"/CALCULO_MENTAL/Calculo_MentalP5.pdf


                        String URL = servidor_ruta+"/APP/1/"+nivelacceso+"/CALCULO_MENTAL/Calculo_MentalP"+nivelacceso+".pdf";


                        //  String desc = descripcion.getText().toString();


                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "Cálculo Mental");
                        startActivity(intent);

                    } else {


                        String ssdFile = "/storage/emulated/0/SacoOliveros/Calculo_MentalP5.pdf";

                        ruta = "Calculo_MentalP5.pdf";


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




        fr_calculo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Fragment fragment = new appCalculoFrag();
                FragmentManager fmanager = getActivity().getSupportFragmentManager();
                if (fmanager != null) {


                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contentFragPrimaria, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }



            }
        });








        return rootview;
    }

}
