package pe.sacooliveros.apptablet.Primaria.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Primaria.Model.mMatematica;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterMatematica extends BaseAdapter implements View.OnClickListener {


    private Context context;
    private ArrayList<mMatematica> arrayList;

    private View.OnClickListener listener;

    ConnectionDetector cd;

    String ruta;

    String urlADescargar;

    String ruta_storage;

    String materiadownload;

    static String tomo;

    String servidor_ruta;


    public adapterMatematica(Context context, ArrayList<mMatematica> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void tomodato(String tomowrite) {
        tomo = tomowrite;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }


    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_matematicas, null);

        }


        ImageView imgfoto = convertView.findViewById(R.id.img_mat);
        ImageView cir_downmat = convertView.findViewById(R.id.cir_downmat);
        final TextView descripcion = convertView.findViewById(R.id.txt_detallemat);
        final TextView estado = convertView.findViewById(R.id.txt_mate);

        FrameLayout fr_matfrag = convertView.findViewById(R.id.fr_ciencia1);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        cir_downmat.setImageResource(arrayList.get(position).getImgdownload());
        descripcion.setText(arrayList.get(position).getDescripcion());
        estado.setText(arrayList.get(position).getDetalle());


        servidor_ruta = context.getString(R.string.servidor_ruta);


        cd = new ConnectionDetector(context);

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/ARITMETICA/Aritmetica_T1.pdf";


                            String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", desc);
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T1.pdf";

                            ruta = "Aritmetica_T1.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/" + ruta);

                            if (file0.exists())

                            {

                                String desc = estado.getText().toString();

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", desc);
                                intent.putExtra("EstadoConexion", "SinConexion");
                                context.startActivity(intent);

                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/ALGEBRA/Algebra_T1.pdf";


                            String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", desc);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T1.pdf";

                            ruta = "Algebra_T1.pdf";


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/" + ruta);


                            if (file0.exists())

                            {

                                String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", desc);
                                intent.putExtra("EstadoConexion", "SinConexion");
                                context.startActivity(intent);

                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 2:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/GEOMETRIA/Geometria_T1.pdf";


                            String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", desc);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T1.pdf";

                            ruta = "Geometria_T1.pdf";


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/" + ruta);


                            if (file0.exists())

                            {

                                String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", desc);
                                intent.putExtra("EstadoConexion", "SinConexion");
                                context.startActivity(intent);

                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 3:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/TRIGONOMETRIA/Trigometria_T1.pdf";


                            String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", desc);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T1.pdf";

                            ruta = "Trigometria_T1.pdf";

//
//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/" + ruta);

                            if (file0.exists())

                            {

                                String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", desc);
                                intent.putExtra("EstadoConexion", "SinConexion");
                                context.startActivity(intent);

                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 4:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT1.pdf";


                            String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", desc);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT1.pdf";

                            ruta = "Calculo_MentalT1.pdf";


                            File file0 = new File(Environment.getExternalStorageDirectory()
                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            if (file0.exists())

                            {

                                String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", desc);
                                intent.putExtra("EstadoConexion", "SinConexion");
                                context.startActivity(intent);

                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                }

            }
        });


        cir_downmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position) {
                    case 0:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/ARITMETICA/Aritmetica_T1.pdf";
                            ruta = "Aritmetica_T1.pdf";

                            materiadownload = "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/ALGEBRA/Algebra_T1.pdf";
                            ruta = "Algebra_T1.pdf";

                            materiadownload = "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/GEOMETRIA/Geometria_T1.pdf";


                            ruta = "Geometria_T1.pdf";

//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/TRIGONOMETRIA/Trigometria_T1.pdf";
                            ruta = "Trigometria_T1.pdf";
                            materiadownload = "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 4:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/5/LIBROS/TOMO1/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT1.pdf";
                            ruta = "Calculo_MentalT1.pdf";

                            materiadownload = "CALCULO_MENTAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                }


            }
        });


        return convertView;


    }


    private void DBwritedownloas() {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context, "administracion", null, 1);

        SQLiteDatabase BasedeDatos = admin.getWritableDatabase();

        String codigo = "9988";
        String file = ruta;
        String ruta = urlADescargar;

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


        ContentValues registro = new ContentValues();
        registro.put("codigo", codigo);
        registro.put("nombre", file);
        registro.put("ruta", ruta);
        registro.put("fecha", date);

        //int cantidad = BasedeDatos.update("descargas", registro, "codigo=" + codigo, null);

        BasedeDatos.insert("descargas", null, registro);

        BasedeDatos.close();

    }


    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(context);
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

            ruta_storage = context.getString(R.string.ruta_raiz);


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                String rutaficheroGuardado = ruta_storage + "/APP/1/5/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta;

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


            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

            //Tiempo estimado
        }
    }


    @Override
    public void onClick(View view) {

        if (listener != null) {
            listener.onClick(view);

        }
    }

}
