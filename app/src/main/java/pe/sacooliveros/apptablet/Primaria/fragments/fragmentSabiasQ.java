package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.NewsPaper.Adapter_Noticia;
import pe.sacooliveros.apptablet.NewsPaper.SConsultNoticia;
import pe.sacooliveros.apptablet.NewsPaper.ServiceNoticia;
import pe.sacooliveros.apptablet.Primaria.Model.M_ListNoticia;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentSabiasQ extends Fragment {

    View rootview;

    RelativeLayout lnLayout;

    ConnectionDetector cd;

    ListView lvNoticia;

    Adapter_Noticia adapter_noticia;

    public fragmentSabiasQ() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_sabiasq, container, false);
        //lvNoticia= rootview.findViewById(R.id.lvNoticia);

        lnLayout = rootview.findViewById(R.id.relative_noticia);

        cd = new ConnectionDetector(getContext());

        String urlcode = "http://tablet.sacooliveros.edu.pe/APP/1/5/EXPLORADOR_CREATIVO_MISCELANEA/SABIAS_QUE/SABIASQUE_NOTICIASP5.json";

        if (cd.isConnected()) {

            ServiceNoticia.urljson(urlcode);
            SConsultNoticia consult = new SConsultNoticia();
            consult.setCurrentContext(getContext());
            consult.setCurrentLayout(lnLayout);
            consult.execute("");

            final ListView lvView = rootview.findViewById(R.id.lvNoticia);

            ArrayList<M_ListNoticia> elements = new ArrayList<>();

            adapter_noticia = new Adapter_Noticia(getContext(), R.layout.item_noticia, elements);
            lvView.setAdapter(adapter_noticia);

            lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    M_ListNoticia mlistnoticia = (M_ListNoticia) adapterView.getItemAtPosition(position);

                    String urldata = mlistnoticia.getUrl();

                    Uri uri = Uri.parse(urldata);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    getContext().startActivity(intent);
                }
            });
        } else {
            Toast.makeText(getContext(), "Estas  sin Conexión", Toast.LENGTH_SHORT).show();
        }

        return rootview;
    }

}