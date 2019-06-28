package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAnualExamen2;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAnualExamen3;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAnualExamen3B;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAnualExamen3B;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre3_AnualFragment extends Fragment {

    View rootview;
    ArrayList<mAnualExamen3B> Lista;

    ImageView img_temas;
    PopupMenu popup;
    private GridView gridView;
    ConnectionDetector cd;
    String servidor_ruta;
    String ruta;
    String urlADescargar;
    String ruta_storage;
    String tipogrado;
    String ciclo;

    public Bimestre3_AnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_bimestre3__anual, container, false);

        img_temas = rootview.findViewById(R.id.img_backanual2);
        gridView = rootview.findViewById(R.id.ma_listanual2);



        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new mainFragmentUni();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {
                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }

        });


        Lista = new ArrayList<mAnualExamen3B>();

        tipogrado= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        if (tipogrado.equalsIgnoreCase("UNI"))
        {
            ciclo="3";
            Lista.add(new mAnualExamen3B(R.drawable.admisionanual_7,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionanual_8,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionanual_9,R.drawable.ic_file_download_black_24dp));

        } else if(tipogrado.equalsIgnoreCase("SAN MARCOS"))
        {
            ciclo="4";
            Lista.add(new mAnualExamen3B(R.drawable.admisionsm_07,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionsm_08,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionsm_09,R.drawable.ic_file_download_black_24dp));
        }

        else if (tipogrado.equalsIgnoreCase("CATOLICA"))
        {
            ciclo="5";
            Lista.add(new mAnualExamen3B(R.drawable.admisioncatolica_7,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisioncatolica_8,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisioncatolica_9,R.drawable.ic_file_download_black_24dp));

        }
        else if (tipogrado.equalsIgnoreCase("PRE"))
        {
            ciclo="6";
            Lista.add(new mAnualExamen3B(R.drawable.admisionpre_7,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionpre_8,R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen3B(R.drawable.admisionpre_9,R.drawable.ic_file_download_black_24dp));

        }

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(getContext());


        final adapterAnualExamen3 adapter = new adapterAnualExamen3(getContext(), Lista);

        gridView.setAdapter(adapter);       


        return rootview;
    }


   



}
