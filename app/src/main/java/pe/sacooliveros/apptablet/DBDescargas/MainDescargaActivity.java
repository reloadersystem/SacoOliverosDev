package pe.sacooliveros.apptablet.DBDescargas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;

public class MainDescargaActivity extends AppCompatActivity {

    ArrayList<Descargas> listaDescargas;

    RecyclerView recyclerViewUp;

    AdminSQLiteOpenHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_descarga);

        conn= new AdminSQLiteOpenHelper(getApplicationContext(), "administracion", null,1);
        listaDescargas= new ArrayList<>();

        recyclerViewUp=findViewById(R.id.recycler_Lista);
        recyclerViewUp.setLayoutManager(new LinearLayoutManager(this));

        consultarListaDescarga();

        AdapterRecyclerDescarga adapter= new AdapterRecyclerDescarga(listaDescargas,getApplicationContext());
        recyclerViewUp.setAdapter(adapter);



    }

    private void consultarListaDescarga() {

        SQLiteDatabase db= conn.getReadableDatabase();

        Descargas descargas= null;

        Cursor cursor= db.rawQuery("SELECT * FROM " + Utilidades.TABLA_DESCARGAS ,null);


        while (cursor.moveToNext())
        {

            descargas= new Descargas();

            descargas.setCodigo(cursor.getString(0));
            descargas.setNombre(cursor.getString(1));
            descargas.setRuta(cursor.getString(2));
            descargas.setFecha(cursor.getString(3));
            descargas.setUrlwebdata(cursor.getString(4));

            listaDescargas.add(descargas);
        }



    }
}
