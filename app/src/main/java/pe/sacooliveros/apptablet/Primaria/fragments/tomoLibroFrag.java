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
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Adapter.adapterTomoLibro;
import pe.sacooliveros.apptablet.Primaria.Model.mTomoLibro;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class tomoLibroFrag extends Fragment {

    View rootview;
    private GridView gridView;
    String tomolibro, tomonum;
    ArrayList<mTomoLibro> Lista;
    TextView tx_tomoLibro;
    ConnectionDetector cd;
    String tomonumero;
    String ruta;
    String nivelacceso;

    String servidor_ruta;

    String sharedata;

    public tomoLibroFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tomo_libro, container, false);

        gridView = rootview.findViewById(R.id.ma_tomoLibro);

        tx_tomoLibro = rootview.findViewById(R.id.tx_tomoLibro);

        Lista = new ArrayList<mTomoLibro>();

//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.matematica_f, R.drawable.ic_invisible));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.comunicacion_f, R.drawable.ic_invisible));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.cienciambiente_f, R.drawable.ic_invisible));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.personalsocial_f, R.drawable.ic_file_download_black_24dp));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.multimedia_9, R.drawable.ic_file_download_black_24dp));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.multimedia_10, R.drawable.ic_file_download_black_24dp));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.valoresliderazgo_f, R.drawable.ic_file_download_black_24dp));
//        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.ajedreztomo_f, R.drawable.ic_file_download_black_24dp));


        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_7, R.drawable.ic_invisible));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_6, R.drawable.ic_invisible));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_2, R.drawable.ic_invisible));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_1, R.drawable.ic_file_download_red_24dp));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_3, R.drawable.ic_file_download_red_24dp));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_4, R.drawable.ic_file_download_red_24dp));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_5, R.drawable.ic_file_download_red_24dp));
        Lista.add(new mTomoLibro("VER DETALLE", R.drawable.caratulapri_8, R.drawable.ic_file_download_red_24dp));

        cd = new ConnectionDetector(getContext());


        final adapterTomoLibro adapter = new adapterTomoLibro(getContext(), Lista);


        //tomolibro

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            nivelacceso = bundle.getString("ACCESO");
            tomolibro = bundle.getString("tomolibro"); // TOMO 2
            tomonum = bundle.getString("tomodato");  // TOMO2
        }

        adapter.tomo(tomolibro);


        tx_tomoLibro.setText(tomolibro);

        //nivelacceso

        if (nivelacceso == null) {
            nivelacceso = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);
        }


        gridView.setAdapter(adapter);

        adapterTomoLibro.accesofinal(nivelacceso);

        tomonumero = String.valueOf(tomonum.charAt(4)); //2


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mTomoLibro mLibros = (mTomoLibro) adapter.getItem(position);


                switch (position) {

                    case 0: {

                        Fragment fragment0 = new mateRFragment();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            args.putString("tomodato", tomonum);
                            args.putString("tomodesc", "Matemática");
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }

                    break;


                    case 1:

                    {
                        Fragment fragment0 = new comunicacionFragment();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            args.putString("tomodato", tomonum);
                            args.putString("tomodesc", "Comunicación");
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }

                    break;


                    case 2:

                    {
                        Fragment fragment0 = new cienciaFragment();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            args.putString("tomodato", tomonum);
                            args.putString("tomodesc", "Ciencia y Ambiente");
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                    }

                    break;


                    case 3:

                    {
                        if (cd.isConnected()) {

                            //http://tablet.sacooliveros.edu.pe/APP/1/5/LIBROS/TOMO1/PERSONAL_SOCIAL/personal_social5_T1.pdf


                            String URL = servidor_ruta + "/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";


                            //  String desc = descripcion.getText().toString();


                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);


                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Personal Social");
                            startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";

                            ruta = "personal_social5_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/PERSONAL_SOCIAL/" + ruta);


                            if (file0.exists())

                            {
                                // String desc = descripcion.getText().toString();

                                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PERSONAL SOCIAL");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                startActivity(intent);

                                Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                            }

                        }

                    }


                    break;


                    case 4: {
                        if (cd.isConnected()) {

                            String URL = servidor_ruta + "/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_VERBAL/razonamiento_verbal5_T" + tomonumero + ".pdf";

                            //  String desc = descripcion.getText().toString();


                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_VERBAL/razonamiento_verbal5_T" + tomonumero + ".pdf";

                            ruta = "razonamiento_verbal5_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_VERBAL/" + ruta);


                            if (file0.exists())

                            {
                                // String desc = descripcion.getText().toString();

                                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                startActivity(intent);

                                Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                            }

                        }

                    }


                    break;


                    case 5: {
                        if (cd.isConnected()) {

                            String URL = servidor_ruta + "/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_MATEMATICO/razonamiento_matematico5_T" + tomonumero + ".pdf";


                            //  String desc = descripcion.getText().toString();


                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                            startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_MATEMATICO/razonamiento_matematico5_T" + tomonumero + ".pdf";

                            ruta = "razonamiento_matematico5_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/RAZONAMIENTO_MATEMATICO/" + ruta);


                            if (file0.exists())

                            {

                                // String desc = descripcion.getText().toString();


                                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                startActivity(intent);

                                Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                            }

                        }

                    }


                    break;


                    case 6: {


                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/VALORES_LIDERAZGO/valores_liderazgo5_T" + tomonumero + ".pdf";

                            //  String desc = descripcion.getText().toString();


                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "VALORES Y LIDERAZGO");
                            startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/VALORES_LIDERAZGO/valores_liderazgo5_T" + tomonumero + ".pdf";

                            ruta = "valores_liderazgo5_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/VALORES_LIDERAZGO/" + ruta);


                            if (file0.exists())

                            {

                                // String desc = descripcion.getText().toString();


                                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "VALORES Y LIDERAZGO");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                startActivity(intent);

                                Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                            }


                        }


                    }


                    break;


                    case 7: {

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/AJEDREZ/ajedrez5_T" + tomonumero + ".pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "AJEDREZ");
                            startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/AJEDREZ/ajedrez5_T" + tomonumero + ".pdf";

                            ruta = "ajedrez5_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + nivelacceso + "/LIBROS/" + tomonum + "/AJEDREZ/" + ruta);


                            if (file0.exists())

                            {

                                // String desc = descripcion.getText().toString();


                                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "AJEDREZ");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                startActivity(intent);

                                Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                            } else {
                                Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                            }

                        }

                    }
                    break;

                }

            }
        });

        return rootview;


    }


}



