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

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.RecyclerViewAdapter;
import pe.sacooliveros.apptablet.Secundaria.Model.Model;

/**
 * A simple {@link Fragment} subclass.
 */
public class Capitulo3_Fragment extends Fragment {


    View rootview;
    RecyclerView recyclerViewCursos;
    ArrayList<Model> listacursos;
    AdminSQLiteOpenHelper conn;
    static String tomolistener;
    String capitulo;

    public Capitulo3_Fragment() {
        // Required empty public constructor
    }

    public static void tomolistener(String tomoinfo) {
        tomolistener = tomoinfo;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_capitulo3, container, false);


        recyclerViewCursos = rootview.findViewById(R.id.recycler_viewc3);

        conn = new AdminSQLiteOpenHelper(rootview.getContext(), "bdseminarios", null, 1);

        listacursos = new ArrayList<>();

//        listacursos.clear();
//        notifyDataSetChanged();

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

        if (tomolistener.equalsIgnoreCase("Tomo1")) {
            capitulo = "3";
        } else if (tomolistener.equalsIgnoreCase("Tomo2")) {
            capitulo = "6";
        } else if (tomolistener.equalsIgnoreCase("Tomo3")) {
            capitulo = "9";
        } else if (tomolistener.equalsIgnoreCase("Tomo4")) {
            capitulo = "12";
        } else if (tomolistener.equalsIgnoreCase("Tomo5")) {
            capitulo = "15";
        } else if (tomolistener.equalsIgnoreCase("Tomo6")) {
            capitulo = "18";
        } else if (tomolistener.equalsIgnoreCase("Tomo7")) {
            capitulo = "21";
        } else if (tomolistener.equalsIgnoreCase("Tomo8")) {
            capitulo = "24";
        }


        String[] params = new String[2];
        params[0] = tomolistener;
        params[1] = capitulo;

        //Cursor cursor = db.rawQuery("Select  * from videoseminario where tomopdf= ? and capitulo='1'",params);
        Cursor cursor = db.rawQuery("Select  * from videoseminario where tomopdf= ? and capitulo= ?", params);

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
