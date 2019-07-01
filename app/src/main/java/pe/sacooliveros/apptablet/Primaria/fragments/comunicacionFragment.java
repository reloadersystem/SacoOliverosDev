package pe.sacooliveros.apptablet.Primaria.fragments;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Primaria.EnviarTomo;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class comunicacionFragment extends Fragment implements View.OnClickListener {


    View rootview;


    CardView fr_comunicacionapp,fr_comunicacionapp3,fr_comunicacionapp2;

    ImageView cir_download1,cir_download2,cir_download3;


    ConnectionDetector cd;

    String ruta;

    String urlADescargar;

    TextView txt_materiaone, txt_materiaone1, txt_materiaone2, txt_ciencia;

    String ruta_storage;

    String materiadownload;

    static String tomo;

    String  tomoNum;

    String datorecep;

    String tomonumero;

    String nivelacceso;

    String  servidor_ruta;
    



    public static void tomodato(String tomowrite)
    {
        tomo= tomowrite;
    }



    public comunicacionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_comunicacion, container, false);


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tomoNum = bundle.getString("tomodato");
            nivelacceso = bundle.getString("ACCESO");
        }

        txt_ciencia= rootview.findViewById(R.id.txt_ciencia);

        fr_comunicacionapp=rootview.findViewById(R.id.frcomun1);

        fr_comunicacionapp2=rootview.findViewById(R.id.frcomun2);

        fr_comunicacionapp3=rootview.findViewById(R.id.frcomun3);


        cir_download1= rootview.findViewById(R.id.cir_download);
        cir_download2= rootview.findViewById(R.id.cir_download2);
        cir_download3= rootview.findViewById(R.id.cir_download3);



        cir_download1.setOnClickListener(this);
        cir_download2.setOnClickListener(this);
        cir_download3.setOnClickListener(this);





        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        tomo= tomoNum;

        tomonumero= String.valueOf(tomo.charAt(4));

        txt_ciencia.setText(tomo + " COMUNICACION");

        if(nivelacceso==null)
        {
            nivelacceso=ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0,1);
        }




        fr_comunicacionapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if (cd.isConnected()) {

                    ruta_storage= getContext().getString(R.string.servidor_ruta);

                    //String accesofinal=String.valueOf(acceso.charAt(4));

                    String URL = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+ tomo+"/COMUNICACION/GRAMATICA/Gramatica_T"+tomonumero+".pdf";



                    Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "GRAMÁTICA");
                    startActivity(intent);

                } else {

                    String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/GRAMATICA/Gramatica_T"+tomonumero+".pdf";

                    ruta = "Gramatica_T"+tomonumero+".pdf";


                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/GRAMATICA/" + ruta);


                    if (file0.exists())

                    {

                       // String desc = descripcion.getText().toString();


                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "storage");
                        intent.putExtra("SSDFILE", ssdFile);
                        intent.putExtra("Materia", "GRAMATICA");
                        intent.putExtra("EstadoConexion", "SinConexion");
                        startActivity(intent);

                        Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                    }

                }



            }
        });


        fr_comunicacionapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cd.isConnected()) {


                    String URL = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+ tomo+"/COMUNICACION/NORMATIVA/Normativa_T"+tomonumero+".pdf";

                    Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                   intent.putExtra("Materia","NORMATIVA");
                    startActivity(intent);

                } else {




                    String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/NORMATIVA/Normativa_T"+tomonumero+".pdf";

                    ruta = "Normativa_T"+tomonumero+".pdf";


                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/NORMATIVA/" + ruta);

                    if (file0.exists())

                    {

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "storage");
                        intent.putExtra("SSDFILE", ssdFile);
                        intent.putExtra("Materia", "NORMATIVA");
                        intent.putExtra("EstadoConexion", "SinConexion");
                        startActivity(intent);

                        Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                    }

                }



            }



        });



        fr_comunicacionapp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cd.isConnected()) {


                    String URL = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/Literatura_T"+tomonumero+".pdf";

                     Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                   intent.putExtra("Materia",  "LITERATURA");
                    startActivity(intent);

                } else {


                    String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/Literatura_T"+tomonumero+".pdf";

                    ruta = "Literatura_T"+tomonumero+".pdf";


                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/" + ruta);


                    if (file0.exists())

                    {

                        // String desc = descripcion.getText().toString();


                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "storage");
                        intent.putExtra("SSDFILE", ssdFile);
                        //intent.putExtra("Materia", desc);
                        intent.putExtra("EstadoConexion", "SinConexion");
                        startActivity(intent);

                        Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                    } else {
                        Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                    }

                }

            }
        });






        return rootview;
    }


    public void actualizarVista(String mensaje)
    {


      datorecep= mensaje;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.cir_download:


            {
                if (cd.isConnected()) {

                    urlADescargar = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+ tomo+"/COMUNICACION/GRAMATICA/Gramatica_T"+tomonumero+".pdf";
                    ruta = "Gramatica_T"+tomonumero+".pdf";

//                    File file0 = new File(Environment.getExternalStorageDirectory()
//                            + File.separator + "SacoOliveros" + File.separator + ruta);

                    materiadownload= "/GRAMATICA/";

                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION"+materiadownload + ruta);

                    if (file0.exists()) {
                        Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();

                    } else {


                        descargarPDF(urlADescargar);

                        //DBwritedownloas();

                        String nombrepdfusuario = "LIBROS - "+ tomo + " - COMUNICACIÓN";
                        String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+ tomo+"/COMUNICACION/GRAMATICA/Gramatica_T"+tomonumero+".pdf";
                        String rutaurldata = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+ tomo+"/COMUNICACION/GRAMATICA/Gramatica_T"+tomonumero+".pdf";
                        DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, rutaurldata, "true");

                    }
                } else

                {


                    Toast.makeText(getContext(), " Sin Conexión", Toast.LENGTH_SHORT).show();
                }

                break;
            }






            case R.id.cir_download2:


            {
                if (cd.isConnected()) {

                    urlADescargar = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/NORMATIVA/Normativa_T"+tomonumero+".pdf";
                    ruta = "Normativa_T"+tomonumero+".pdf";

                    materiadownload= "/NORMATIVA/";

                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION"+ materiadownload + ruta);

                    if (file0.exists()) {
                        Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();



                    } else {


                        descargarPDF(urlADescargar);

                       // DBwritedownloas();

                        String nombrepdfusuario = "LIBROS - "+ tomo + " - NORMATIVA";
                        String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/NORMATIVA/Normativa_T"+tomonumero+".pdf";
                        String rutaurldata = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/NORMATIVA/Normativa_T"+tomonumero+".pdf";
                        DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, rutaurldata, "true");

                    }
                } else

                {


                    Toast.makeText(getContext(), " Sin Conexión", Toast.LENGTH_SHORT).show();
                }

                break;
            }



            case R.id.cir_download3:


            {
                if (cd.isConnected()) {

                    urlADescargar = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/Literatura_T"+tomonumero+".pdf";
                    ruta = "Literatura_T"+tomonumero+".pdf";

                    materiadownload= "/LITERATURA/";

                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION"+materiadownload + ruta);

                    if (file0.exists()) {
                        Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();



                    } else {


                        descargarPDF(urlADescargar);

                        //DBwritedownloas();

                        String nombrepdfusuario = "LIBROS - "+ tomo + " - LITERATURA";
                        String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/Literatura_T"+tomonumero+".pdf";
                        String rutaurldata = servidor_ruta+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION/LITERATURA/Literatura_T"+tomonumero+".pdf";
                        DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, rutaurldata, "true");

                    }
                } else

                {
                    Toast.makeText(getContext(), " Sin Conexión", Toast.LENGTH_SHORT).show();
                }

                break;
            }

        }

    }

    private void DBwritedownloas() {


        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(getContext(), "administracion", null,1 );

        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String codigo="9988";
        String file= ruta;
        String ruta= urlADescargar;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());




        ContentValues registro= new ContentValues();
        registro.put("codigo",codigo);
        registro.put("nombre",file);
        registro.put("ruta",ruta);
        registro.put("fecha",date);

        //int cantidad = BasedeDatos.update("descargas", registro, "codigo=" + codigo, null);

        BasedeDatos.insert("descargas", null, registro);

        BasedeDatos.close();


        }

    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Descargando PDF...");

        new DescargarPDFAsynTask(progressDialog).execute(urlADescargar);
    }







    private class DescargarPDFAsynTask extends AsyncTask<String, Integer, String> {

        ProgressDialog progressDialog;

        public DescargarPDFAsynTask(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... urlPDF) {

            HttpURLConnection conexion = null;
            InputStream input = null;
            OutputStream output = null;

            ruta_storage = getContext().getString(R.string.ruta_raiz);


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();





                String rutaficheroGuardado = ruta_storage+"/APP/1/"+nivelacceso+"/LIBROS/"+tomo+"/COMUNICACION"+ materiadownload + ruta;
                //todo materialdownload vacio

                output = new FileOutputStream((rutaficheroGuardado));

                int tamanoFichero = conexion.getContentLength();

                byte[] data = new byte[3072];
                int count;
                int total = 0;


                while ((count = input.read(data)) != -1) {

                    sleep(1);
                    output.write(data, 0, count);

                    total += count;
                    publishProgress((int) (total * 100 / tamanoFichero));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Sin Conexion";
            }
            //cerrando la carpeta una vez que termino
            catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (input != null) input.close();
                    //cerrando conexion progress
                    if (output != null) output.close();
                    if (conexion != null) conexion.disconnect();

                    progressDialog.dismiss();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return "Se realizo Correctamente";
        }





        @Override
        protected void onProgressUpdate(Integer... values) {
            //%de descarga
            super.onProgressUpdate(values);

            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);


            Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

            //Tiempo estimado
        }



    }

}
