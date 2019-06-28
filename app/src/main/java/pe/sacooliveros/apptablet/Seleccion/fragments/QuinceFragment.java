package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterQuince;
import pe.sacooliveros.apptablet.Seleccion.Model.MQuince;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuinceFragment extends Fragment {

    private GridView gridView;
    ArrayList<MQuince> Lista;
    TextView tx_temas;
    View rootview;
    String servidor_ruta;


    public QuinceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_quince, container, false);

        tx_temas = rootview.findViewById(R.id.tx_exquince);
        gridView = rootview.findViewById(R.id.grid_exquince);

        Lista = new ArrayList<MQuince>();

        Lista.add(new MQuince(R.drawable.solucionario_22));
        Lista.add(new MQuince(R.drawable.solucionario_23));
        Lista.add(new MQuince(R.drawable.solucionario_24));
        Lista.add(new MQuince(R.drawable.solucionario_25));
        Lista.add(new MQuince(R.drawable.solucionario_26));
        Lista.add(new MQuince(R.drawable.solucionario_27));

        final adapterQuince adapter = new adapterQuince(getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                servidor_ruta = getContext().getString(R.string.servidor_ruta);

                switch (position) {
                    case 0:

                        String URL = servidor_ruta + "/APP/7/5/EXADM_ANUAL/UNI/UNI2015_II.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO UNI2015_II");
                        getContext().startActivity(intent);

                        break;


                    case 1:

                        String URL1 = servidor_ruta + "/APP/7/5/EXADM_ANUAL/UNI/UNI2015_I.pdf";

                        Intent intent1 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent1.putExtra("ViewType", "internet");
                        intent1.putExtra("URL", URL1);
                        intent1.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO UNI2015_I");
                        getContext().startActivity(intent1);

                        break;


                    case 2:

                        String URL2 = servidor_ruta + "/APP/7/5/EXADM_ANUAL/SAN_MARCOS/SM2015_II.pdf";

                        Intent intent2 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent2.putExtra("ViewType", "internet");
                        intent2.putExtra("URL", URL2);
                        intent2.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2015_II.pdf");
                        getContext().startActivity(intent2);

                        break;


                    case 3:

                        String URL3 = servidor_ruta + "/APP/7/5/EXADM_ANUAL/SAN_MARCOS/SM2015_I.pdf";

                        Intent intent3 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent3.putExtra("ViewType", "internet");
                        intent3.putExtra("URL", URL3);
                        intent3.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2015_I.pdf");
                        getContext().startActivity(intent3);

                        break;


                    case 4:

                        String URL4 = servidor_ruta + "/APP/7/5/EXADM_ANUAL/U_CALLAO/UCALLAO2015_I.pdf";

                        Intent intent4 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent4.putExtra("ViewType", "internet");
                        intent4.putExtra("URL", URL4);
                        intent4.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2015_I.pdf");
                        getContext().startActivity(intent4);

                        break;

                    case 5:

                        String URL5 = servidor_ruta + "/APP/7/5/EXADM_ANUAL/U_CALLAO/UCALLAO2015_II.pdf";

                        Intent intent5 = new Intent(getContext(), ViewTomo3Activity.class);
                        intent5.putExtra("ViewType", "internet");
                        intent5.putExtra("URL", URL5);
                        intent5.putExtra("Materia", "EXÁMEN Y SOLUCIONARIO SM2015_II.pdf");
                        getContext().startActivity(intent5);

                        break;


                }

            }
        });

        return rootview;
    }

}
