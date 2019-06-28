package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterDiecinueve;
import pe.sacooliveros.apptablet.Seleccion.Model.mConcurso;
import pe.sacooliveros.apptablet.Seleccion.Model.mDiecinueve;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiecinueveFragment extends Fragment {

    private GridView gridView;
    ArrayList<mDiecinueve> Lista;
    TextView tx_temas;
    View rootview;
    String servidor_ruta;


    public DiecinueveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_diecinueve, container, false);


        tx_temas = rootview.findViewById(R.id.tx_exdiecinueve);
        gridView = rootview.findViewById(R.id.grid_exdiecinueve);

        Lista = new ArrayList<mDiecinueve>();

        Lista.add(new mDiecinueve(R.drawable.solucionario_1));
        Lista.add(new mDiecinueve(R.drawable.solucionario_3));
        Lista.add(new mDiecinueve(R.drawable.solucionario_2));



        final adapterDiecinueve adapter = new adapterDiecinueve(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                servidor_ruta = getContext().getString(R.string.servidor_ruta);

                switch(position)
                {
                    case    0:

                    String URL = servidor_ruta+"/APP/7/5/EXADM_ANUAL/UNI/UNI2019_I.pdf";

                    Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO UNI2019_I");
                    getContext().startActivity(intent);


                    break;


                    case  1:


                      String URL1= servidor_ruta+"/APP/7/5/EXADM_ANUAL/SAN_MARCOS/SM2019_I.pdf";

                        Intent intent1 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent1.putExtra("ViewType", "internet");
                        intent1.putExtra("URL", URL1);
                        intent1.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2019_II");
                        getContext().startActivity(intent1);

                    break;


                    case 2:

                        String URL2= servidor_ruta+"/APP/7/5/EXADM_ANUAL/SAN_MARCOS/SM2019_II.pdf";

                        Intent intent2 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent2.putExtra("ViewType", "internet");
                        intent2.putExtra("URL", URL2);
                        intent2.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2019_I");
                        getContext().startActivity(intent2);


                        break;



                }





            }
        });

        return rootview;
    }

}
