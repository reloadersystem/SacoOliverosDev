package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.RecyclerViewAdapter;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.Utilidades;
import pe.sacooliveros.apptablet.Secundaria.Model.Model;
import pe.sacooliveros.apptablet.Secundaria.ServiceWSeminario.SConsultSeminario;

/**
 * A simple {@link Fragment} subclass.
 */
public class Capitulo1_Fragment extends Fragment {


    View rootview;

    ArrayList<Model> listacursos;

    public RecyclerView recyclerViewCursos;

    AdminSQLiteOpenHelper conn;

    static String tomolistener;

    String capitulo;


    public Capitulo1_Fragment() {
        // Required empty public constructor
    }

    public static void tomolistener(String tomoinfo)
    {
        tomolistener= tomoinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_capitulo1, container, false);

        conn = new AdminSQLiteOpenHelper(rootview.getContext(), "bdseminarios", null, 1);

        SConsultSeminario.setContextVideo(getContext(), rootview);

        listacursos = new ArrayList<>();

        recyclerViewCursos = rootview.findViewById(R.id.recycler_viewseminarios);

        int spanCount = 1; // 3 columns
        int spacing = 25; // 50px
        boolean includeEdge = false;

        // recyclerViewCursos.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        //recyclerViewCursos.setLayoutManager(new LinearLayoutManager(rootview.getContext()));

        consultarlistaAsignaturas();

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(rootview.getContext(), listacursos);
        GridLayoutManager manager = new GridLayoutManager(rootview.getContext(), 3);
        recyclerViewCursos.setHasFixedSize(true);
        recyclerViewCursos.setLayoutManager(manager);
        recyclerViewCursos.setAdapter(adapter);

        return rootview;
    }

    private void consultarlistaAsignaturas() {

        SQLiteDatabase db = conn.getReadableDatabase();
        Model model = null;

        // Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_VIDEOSEMINARIO, null);

        //Cursor cursor = db.rawQuery("SELECT * FROM  " + Utilidades.TABLA_VIDEOSEMINARIO + " WHERE " + Utilidades.CAMPO_CAPITULO + "='" + 1 + "'", null);

        //Cursor cursor = db.rawQuery("Select  * from videoseminario where tomopdf= 'Tomo1' and capitulo='2'",null);

        if(tomolistener.equalsIgnoreCase("Tomo1"))
        {
            capitulo="1";
        }
        else if(tomolistener.equalsIgnoreCase("Tomo2"))
        {
            capitulo="4";
        }else if(tomolistener.equalsIgnoreCase("Tomo3"))
        {
            capitulo="7";
        }

        else if(tomolistener.equalsIgnoreCase("Tomo4"))
        {
            capitulo="10";
        }

        String[] params = new String[2];
        params[0] = tomolistener;
        params[1] = capitulo;

        //Cursor cursor = db.rawQuery("Select  * from videoseminario where tomopdf= ? and capitulo='1'",params);
        Cursor cursor = db.rawQuery("Select  * from videoseminario where tomopdf= ? and capitulo= ?",params);

        while (cursor.moveToNext()) {
            model = new Model();

            //trae  los archivos del SDD y los llena al Adapter
            model.setCodigo(cursor.getString(0));
            model.setAsignatura(cursor.getString(1));
            model.setHabilitar(Boolean.parseBoolean(cursor.getString(2)));
            model.setCapitulo(cursor.getString(3));
            model.setUrlpdf(cursor.getString(4));
            model.setSsdpdf(cursor.getString(5));
            model.setTomopdf(cursor.getString(6));
            model.setGradopdf(cursor.getString(7));
            model.setListyoutube(cursor.getString(8));

            listacursos.add(model);
        }
    }

}
