package pe.sacooliveros.apptablet;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.DBDescargas.AdapterRecyclerDescarga;
import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.DBDescargas.Descargas;
import pe.sacooliveros.apptablet.DBDescargas.Utilidades;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescargasFragment extends Fragment {

    View rootview;

    ArrayList<Descargas> listaDescargas;

    RecyclerView recyclerViewUp;

    AdminSQLiteOpenHelper conn;

    ImageView img_deletedescarga;



    public DescargasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview= inflater.inflate(R.layout.fragment_descargas, container, false);
        conn= new AdminSQLiteOpenHelper(getContext(), "administracion", null,1);
        listaDescargas= new ArrayList<>();

        recyclerViewUp=rootview.findViewById(R.id.recycler_Lista);
        img_deletedescarga= rootview.findViewById(R.id.img_deletedescarga);

        recyclerViewUp.setLayoutManager(new LinearLayoutManager(getContext()));

        consultarListaDescarga();

        final AdapterRecyclerDescarga adapter= new AdapterRecyclerDescarga(listaDescargas, getContext());


        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre= listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getNombre();
                String ruta= listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getRuta();
                String fecha= listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getFecha();
                String urldata= listaDescargas.get(recyclerViewUp.getChildAdapterPosition(view)).getUrlwebdata();

//todo recibe  la ruta ssd desde la base de datos

//                Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
//
//                intent.putExtra("ViewType", "internet");
//                intent.putExtra("URL", ruta);
//                intent.putExtra("Materia", nombre);
//                getContext().startActivity(intent);

           // todo abre  tipo  internet


//                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/ajedrezrepaso.pdf";
                ///data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/AJEDREZ/ajedrez5_T1.pdf

//

                //nombrepdf = "ajedrezrepaso.pdf";

                //File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + nombrepdf);
                File file0 = new File(ruta);

                if (file0.exists())

                {

                    Intent intent2 = new Intent(getContext(), ViewTomo3Activity.class);

                    intent2.putExtra("ViewType", "storage");
                    intent2.putExtra("SSDFILE", ruta);
                    intent2.putExtra("Materia", nombre);
                    intent2.putExtra("EstadoConexion", "SinConexion");
                    intent2.putExtra("URL", urldata);
                    startActivity(intent2);

                    Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                } else {
                    Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                }



                //Toast.makeText(getContext(), ruta,Toast.LENGTH_SHORT).show();

            }
        });

//        adapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                //adapter.eliminardescarga();
//            }
//        });

        img_deletedescarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int contador = adapter.getItemCount();

                if(contador>0)

                {
                    //Toast.makeText(getContext(), contador+" ", Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Desea Eliminar historial?");
                    builder.setTitle("Eliminar Historial");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            deleteDescarga();

                            adapter.eliminardescarga();


//                            File file = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/5/PROBLEMAS_PROPUESTOS/MES1/FISICA/FISICA25_PPM1.pdf");
//                            file.delete(); // elimina un archivo unico

                            EliminarArchivos(new File("/data/user/0/pe.sacooliveros.apptablet/files/APP") );

                        }
                    });

                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    Dialog dialog= builder.create();
                    dialog.show();

                }

              }




        });


        recyclerViewUp.setAdapter(adapter);

        return  rootview;
    }

    void EliminarArchivos(File ArchivoDirectorio) { /* Parametro File (Ruta) */
        if (ArchivoDirectorio.isDirectory()) /* Si es Directorio */
        {
            /* Recorremos sus Hijos y los ELiminamos */
            for (File hijo : ArchivoDirectorio.listFiles())
                EliminarArchivos(hijo); /*Recursividad Para Saber si no hay Subcarpetas */
        }
        else
            ArchivoDirectorio.delete(); /* Si no, se trata de un File ,solo lo Eliminamos*/
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
            descargas.setEstadopdf(cursor.getString(5));

            listaDescargas.add(descargas);
        }

    }


    private void deleteDescarga() {

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getContext(), "administracion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        int cantidad= BaseDeDatos.delete("descargas", null, null);

        BaseDeDatos.close();
    }

}
