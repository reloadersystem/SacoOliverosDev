package pe.sacooliveros.apptablet.DescargasHistorial;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.DBDescargas.AdapterRecyclerDescarga;
import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.DBDescargas.Descargas;
import pe.sacooliveros.apptablet.DBDescargas.Utilidades;
import pe.sacooliveros.apptablet.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class checkDescargasFragment extends Fragment {

    View rootview;

    ArrayList<Descargas> listaDescargas;

    RecyclerView recyclerViewUp;

    AdminSQLiteOpenHelper conn;

    ImageView img_deletedescarga;


    public checkDescargasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_check_descargas, container, false);
        conn = new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);
        listaDescargas = new ArrayList<>();

        recyclerViewUp = rootview.findViewById(R.id.recycler_Lista);
        img_deletedescarga = rootview.findViewById(R.id.img_deletedescarga);

        recyclerViewUp.setLayoutManager(new LinearLayoutManager(getContext()));

        consultarListaDescarga();

        final AdapterRecyclerDescarga adapter = new AdapterRecyclerDescarga(listaDescargas, getContext());

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre = listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getNombre();
                String ruta = listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getRuta();
                String urldata = listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getUrlwebdata();

                int position = recyclerViewUp.getChildAdapterPosition(view);

                Toast.makeText(getContext(),position+" "+ nombre, Toast.LENGTH_SHORT).show();

            }
        });

        recyclerViewUp.setAdapter(adapter);


        return rootview;
    }

    private void consultarListaDescarga() {

        SQLiteDatabase db = conn.getReadableDatabase();

        Descargas descargas = null;

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_DESCARGAS, null);

        while (cursor.moveToNext()) {

            descargas = new Descargas();

            descargas.setCodigo(cursor.getString(0));
            descargas.setNombre(cursor.getString(1));
            descargas.setRuta(cursor.getString(2));
            descargas.setFecha(cursor.getString(3));
            descargas.setUrlwebdata(cursor.getString(4));
            descargas.setEstadopdf(cursor.getString(5));

            listaDescargas.add(descargas);
        }
    }
}
