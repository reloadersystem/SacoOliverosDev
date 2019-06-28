package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.PptViewer;
import pe.sacooliveros.apptablet.Primaria.Adapter.adapterMultiTomo;
import pe.sacooliveros.apptablet.Primaria.Model.mMultiTomo;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class tomoMultiFrag extends Fragment {

    View rootview;
    private GridView gridView;
    ArrayList<mMultiTomo> Lista;

    String tMulti;

    TextView tx_multitomo;


    String unidadnum;

    String servidor_ruta;

    String sharedata;

    ConnectionDetector cd;


    private static final String TAG = "errorconexion";


    public tomoMultiFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tomo_multi, container, false);

        cd = new ConnectionDetector(getContext());


        gridView = rootview.findViewById(R.id.ma_multitomo);

        tx_multitomo = rootview.findViewById(R.id.tx_multitomo);

        servidor_ruta = getContext().getString(R.string.servidor_ruta);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tMulti = bundle.getString("descripcionMulti"); //UNIDAD 1
        }

        unidadnum = tMulti.replace(" ", "_");

        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);


        tx_multitomo.setText(tMulti);

        Lista = new ArrayList<mMultiTomo>();

        Lista.add(new mMultiTomo(R.drawable.multimedia_1));
        Lista.add(new mMultiTomo(R.drawable.multimedia_2));
        Lista.add(new mMultiTomo(R.drawable.multimedia_3));
        Lista.add(new mMultiTomo(R.drawable.multimedia_4));
        Lista.add(new mMultiTomo(R.drawable.multimedia_5));
        Lista.add(new mMultiTomo(R.drawable.multimedia_6));
        Lista.add(new mMultiTomo(R.drawable.multimedia_7));
        Lista.add(new mMultiTomo(R.drawable.multimedia_8));
        Lista.add(new mMultiTomo(R.drawable.multimedia_9));
        Lista.add(new mMultiTomo(R.drawable.multimedia_10));
        Lista.add(new mMultiTomo(R.drawable.multimedia_11));
        Lista.add(new mMultiTomo(R.drawable.multimedia_12));


        final adapterMultiTomo adapter = new adapterMultiTomo(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mMultiTomo mMultiTomo = (mMultiTomo) adapter.getItem(position);


                switch (position) {

                    case 0: {

                        if (cd.isConnected()) {

                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/ARITMETICA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "ARITMÉTICA");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 1: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = "http://192.169.218.177/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/ALGEBRA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "ÁLGEBRA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;
                    }


                    case 2: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/GEOMETRIA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "GEOMETRÍA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }


                    case 3: {

                        if (cd.isConnected()) {

                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/TRIGONOMETRIA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "TRIGONOMETRÍA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }


                    case 4: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);
                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/BIOLOGIA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "BIOLOGÍA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;
                    }


                    case 5: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/FISICA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "FÍSICA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;
                    }


                    case 6: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/LITERATURA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "LITERATURA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }


                    case 7: {
                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/GRAMATICA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "GRAMÁTICA");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }


                    case 8: {

//                        if (cd.isConnected()) {
//                            Intent intent = new Intent(getContext(), PptViewer.class);
//
//                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/INGLES/";
//                            intent.putExtra("URL", url);
//                            intent.putExtra("Materia", "INGLÉS");
//                            startActivity(intent);
//                        } else {
//                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
//                        }
//
//                        break;

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String urlprueba ="http://tablet.sacooliveros.edu.pe/APP/1/6/CLASES_MULTIMEDIA/UNIDAD_2/RAZONAMIENTO_MATEMATICO/";

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/RAZONAMIENTO_MATEMATICO/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;
                    }


                    case 9: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/RAZONAMIENTO_VERBAL/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            startActivity(intent);

                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    }

                    case 10: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/PERSONAL_SOCIAL/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "PERSONAL SOCIAL");
                            startActivity(intent);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    }

                    //http://aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/DIAPOSITIVAS/TOMO08/4TO/PSICOLOGIA/CAPITULO24/


                    case 11: {

                        if (cd.isConnected()) {
                            Intent intent = new Intent(getContext(), PptViewer.class);

                            String url = servidor_ruta + "/APP/1/" + sharedata + "/CLASES_MULTIMEDIA/" + unidadnum + "/QUIMICA/";
                            intent.putExtra("URL", url);
                            intent.putExtra("Materia", "QUÍMICA");
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
