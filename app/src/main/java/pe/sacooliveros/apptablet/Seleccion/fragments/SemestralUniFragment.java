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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterSemestralUni;
import pe.sacooliveros.apptablet.Seleccion.Model.MSemestralUni;
import pe.sacooliveros.apptablet.Seleccion.Model.MSemestralUni;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemestralUniFragment extends Fragment {

    private GridView gridView;
    ArrayList<MSemestralUni> Lista;
    TextView tx_temas;
    View rootview;
    String servidor_ruta;


    public SemestralUniFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview=inflater.inflate(R.layout.fragment_semestral_uni, container, false);


        tx_temas = rootview.findViewById(R.id.tx_semestraluni);
        gridView = rootview.findViewById(R.id.grid_semestraluni);

        Lista = new ArrayList<MSemestralUni>();

        Lista.add(new MSemestralUni(R.drawable.tomo1));
        Lista.add(new MSemestralUni(R.drawable.tomo2));
        Lista.add(new MSemestralUni(R.drawable.tomo3));
        Lista.add(new MSemestralUni(R.drawable.tomo4));


        final adapterSemestralUni adapter = new adapterSemestralUni(getContext(), Lista);

        gridView.setAdapter(adapter);

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:

                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_UNI/UNISELECCION_TOMO1.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 1 - SEMESTRAL UNI");
                        getContext().startActivity(intent);

                        break;
                    }



                        case 1:
                        {
                            String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_UNI/UNISELECCION_TOMO2.pdf";

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 1 - SEMESTRAL UNI");
                            getContext().startActivity(intent);

                            break;
                        }


                    case 2:
                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_UNI/UNISELECCION_TOMO3.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 1 - SEMESTRAL UNI");
                        getContext().startActivity(intent);

                        break;
                    }


                    case 3:
                    {
                        String URL=  servidor_ruta+"/APP/8/5/LIBRO_ACADEMIA/SEMESTRAL_UNI/UNISELECCION_TOMO4.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "TOMO 1 - SEMESTRAL UNI");
                        getContext().startActivity(intent);

                        break;
                    }

                }

            }
        });
        
        return  rootview;
    }

}
