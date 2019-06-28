package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.content.Intent;
import android.net.Uri;
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
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterInternacionales;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterNacionales;
import pe.sacooliveros.apptablet.Seleccion.Model.mConcurso;
import pe.sacooliveros.apptablet.Seleccion.Model.mInternacionales;
import pe.sacooliveros.apptablet.Seleccion.Model.mNacionales;

/**
 * A simple {@link Fragment} subclass.
 */
public class OlimpiadasFragment extends Fragment {

    private GridView gridView;
    private GridView gridView2;

    ArrayList<mNacionales> Lista;
    ArrayList<mInternacionales> Lista2;


    View rootview;


    public OlimpiadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.olimpiadas_fragment, container, false);

        gridView = rootview.findViewById(R.id.grid_nacionales);
        gridView2 = rootview.findViewById(R.id.grid_internacionales);


        Lista = new ArrayList<mNacionales>();

        Lista.add(new mNacionales(R.drawable.nacionales_1));
        Lista.add(new mNacionales(R.drawable.nacionales_2));
        Lista.add(new mNacionales(R.drawable.nacionales_3));
        Lista.add(new mNacionales(R.drawable.nacionales_4));



        final adapterNacionales adapter = new adapterNacionales(getContext(), Lista);

        gridView.setAdapter(adapter);


        Lista2 = new ArrayList<mInternacionales>();

        Lista2.add(new mInternacionales(R.drawable.internacionales_1));
        Lista2.add(new mInternacionales(R.drawable.internacionales_2));
        Lista2.add(new mInternacionales(R.drawable.internacionales_3));
        Lista2.add(new mInternacionales(R.drawable.internacionales_4));
        Lista2.add(new mInternacionales(R.drawable.internacionales_5));
        Lista2.add(new mInternacionales(R.drawable.internacionales_6));
        Lista2.add(new mInternacionales(R.drawable.internacionales_7));
        Lista2.add(new mInternacionales(R.drawable.internacionales_8));
        Lista2.add(new mInternacionales(R.drawable.internacionales_9));
        Lista2.add(new mInternacionales(R.drawable.internacionales_10));

        final adapterInternacionales adapter2 = new adapterInternacionales(getContext(), Lista2);

        gridView2.setAdapter(adapter2);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:
                    {
                        Uri uri = Uri.parse("https://onemperu.wordpress.com/onem-2/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);
                    }


                        break;

                    case 1:

                    {

                        Uri uri2 = Uri.parse("http://olimpiada.pucp.edu.pe/quimica/ediciones-anteriores/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    } break;

                    case 2:
                    {

                        Uri uri2 = Uri.parse("http://v-beta.urp.edu.pe/pregrado/facultad-de-ciencias-biologicas/xii-olimpiada-peruana-de-biologia/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }break;


                    case 3:
                    {
                        Uri uri2 = Uri.parse("http://soperfi.org/opf/old/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                        break;

                }

            }
        });


        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position)
                {
                    case 0:
                    {
                        Uri uri = Uri.parse("http://www.canguromat.org.es/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);
                    }


                    break;

                    case 1:

                    {

                        Uri uri2 = Uri.parse("http://www.oma.org.ar/internacional/omr.htm");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    } break;

                    case 2:
                    {

                        Uri uri2 = Uri.parse("http://www.oma.org.ar/internacional/cono.htm");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }break;


                    case 3:
                    {
                        Uri uri2 = Uri.parse("https://www.oei.es/historico/oim/index.html");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;


                    case 4:
                    {
                        Uri uri2 = Uri.parse("https://www.imo-official.org/?langu");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;

                    case 5:
                    {
                        Uri uri2 = Uri.parse("http://www.apmo-official.org/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;

                    case 6:
                    {
                        Uri uri2 = Uri.parse("http://rmms.lbi.ro/rmm2019/index.php?id=home");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;
                    case 7:
                    {
                        Uri uri2 = Uri.parse("https://www.egmo.org/");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;

                    case 8:
                    {
                        Uri uri2 = Uri.parse("https://www.iuventa.sk/en/Subpages/ICHO/Past-Preparatory-Problems.alej");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;

                    case 9:
                    {
                        Uri uri2 = Uri.parse("https://www.iuventa.sk/en/Subpages/ICHO/Past-Preparatory-Problems.alej");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, uri2);
                        getContext().startActivity(intent2);
                    }

                    break;

                }

            }
        });


        return  rootview;
    }

}
