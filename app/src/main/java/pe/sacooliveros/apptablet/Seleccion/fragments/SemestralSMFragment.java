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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterSemestralSM;
import pe.sacooliveros.apptablet.Seleccion.Model.MSemestralSM;
import pe.sacooliveros.apptablet.Seleccion.Model.MSemestralSM;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemestralSMFragment extends Fragment {

    private GridView gridView;
    ArrayList<MSemestralSM> Lista;
    TextView tx_temas;
    View rootview;
    String servidor_ruta;

    public SemestralSMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_semestral_sm, container, false);


        tx_temas = rootview.findViewById(R.id.tx_exsemestralsm);
        gridView = rootview.findViewById(R.id.grid_exsemestralsm);

        Lista = new ArrayList<MSemestralSM>();

        Lista.add(new MSemestralSM(R.drawable.tomo5));
        Lista.add(new MSemestralSM(R.drawable.tomo6));
        Lista.add(new MSemestralSM(R.drawable.tomo7));
        Lista.add(new MSemestralSM(R.drawable.tomo8));


        final adapterSemestralSM adapter = new adapterSemestralSM(getContext(), Lista);

        gridView.setAdapter(adapter);

        servidor_ruta = getContext().getString(R.string.servidor_ruta);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:

                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_SANMARCOS/SMSELECCION_TOMO1.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 1 - SEMESTRAL SAN MARCOS");
                        getContext().startActivity(intent);

                        break;
                    }



                    case 1:
                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_SANMARCOS/SMSELECCION_TOMO2.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 2 - SEMESTRAL SAN MARCOS");
                        getContext().startActivity(intent);

                        break;
                    }


                    case 2:
                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_SANMARCOS/SMSELECCION_TOMO3.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 3 - SEMESTRAL SAN MARCOS");
                        getContext().startActivity(intent);

                        break;
                    }


                    case 3:
                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_SANMARCOS/SMSELECCION_TOMO4.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 4 - SEMESTRAL UNI");
                        getContext().startActivity(intent);

                        break;
                    }

                }

            }
        });


        return rootview;
    }

}
