package pe.sacooliveros.apptablet.Primaria.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import java.util.List;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Primaria.Model.MyList;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private List<MyList> list;
    private Context mCtx;
    static String tomo;

    ConnectionDetector cd;
    String ruta;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    static String accesodato;
    static String tomonumero;

    String servidor_ruta;


    public CustomAdapter(List<MyList> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }


    public static void tomodato(String tomowrite) {
        tomo = tomowrite;
    }

    public static void accesofinal(String acceso) {
        accesodato = acceso;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CustomAdapter.ViewHolder holder, final int position) {


        if (accesodato == null) {
            accesodato = ShareDataRead.obtenerValor(mCtx, "ServerGradoNivel").substring(0, 1);
        }


        cd = new ConnectionDetector(mCtx);

        servidor_ruta = mCtx.getString(R.string.servidor_ruta);

        MyList myList = list.get(position);

        tomonumero = String.valueOf(tomo.charAt(4));

        holder.imageunidad.setImageResource(list.get(position).getImgfondo());
        holder.imgdownload.setImageResource(list.get(position).getImgmenu());


        holder.imageunidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {

                            //http://app8.sacooliveros.edu.pe/APP/1/6/LIBROS/TOMO1/MATEMATICA/ARITMETICA/Aritmetica_T1.pdf

                            String URL = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T" + tomonumero + ".pdf";

                            Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Aritmética");
                            mCtx.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T" + tomonumero + ".pdf";

                            ruta = "Aritmetica_T" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Aritmética");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                mCtx.startActivity(intent);

                                Toast.makeText(mCtx, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(mCtx, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T" + tomonumero + ".pdf";


                            //ring desc = estado.getText().toString();


                            Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Algebra");
                            mCtx.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T" + tomonumero + ".pdf";

                            ruta = "Algebra_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/" + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Algebra");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                mCtx.startActivity(intent);

                                Toast.makeText(mCtx, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(mCtx, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 2:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T" + tomonumero + ".pdf";

                            Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Geometría");
                            mCtx.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T" + tomonumero + ".pdf";

                            ruta = "Geometria_T" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/" + ruta);


                            if (file0.exists())

                            {

//                                String desc = estado.getText().toString();


                                Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Geometría");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                mCtx.startActivity(intent);

                                Toast.makeText(mCtx, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(mCtx, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 3:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T" + tomonumero + ".pdf";

                            Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Trigonometría");
                            mCtx.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T" + tomonumero + ".pdf";

                            ruta = "Trigometria_T" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Trigonometría");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                mCtx.startActivity(intent);

                                Toast.makeText(mCtx, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(mCtx, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                    case 4:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT" + tomonumero + ".pdf";

                            Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Cálculo Mental");
                            mCtx.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT" + tomonumero + ".pdf";

                            ruta = "Calculo_MentalT" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/" + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(mCtx, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Cálculo Mental");
                                intent.putExtra("EstadoConexion", "SinConexion");
                                mCtx.startActivity(intent);

                                Toast.makeText(mCtx, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                break;

                            } else {
                                Toast.makeText(mCtx, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                break;

                            }

                        }


                        break;


                }

            }


        });


        holder.imgdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:


                        if (cd.isConnected()) {

                            //urlADescargar = servidor_ruta+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/ARITMETICA/Aritmetica_T1.pdf";

                            // http://app8.sacooliveros.edu.pe/APP/1/6/LIBROS/TOMO2/MATEMATICA/ARITMETICA/Aritmetica_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T" + tomonumero + ".pdf";
                            ruta = "Aritmetica_T" + tomonumero + ".pdf";
                            materiadownload = "ARITMETICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(mCtx, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - ARITMÉTICA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ARITMETICA/Aritmetica_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(mCtx, nombrepdfusuario, rutasdd, rutaurldata, "true");


                                // DBwritedownloas();


                            }
                        } else

                        {


                            Toast.makeText(mCtx, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T" + tomonumero + ".pdf";
                            ruta = "Algebra_T" + tomonumero + ".pdf";

                            //File file0 = new File(Environment.getExternalStorageDirectory() + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            if (file0.exists()) {
                                Toast.makeText(mCtx, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - ALGEBRA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/ALGEBRA/Algebra_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(mCtx, nombrepdfusuario, rutasdd, rutaurldata, "true");

//                                DBwritedownloas();
//                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(mCtx, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T" + tomonumero + ".pdf";


                            ruta = "Geometria_T" + tomonumero + ".pdf";

//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(mCtx, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

//                                DBwritedownloas();
//                                Log.e("DATOPDF", file0.toString());

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - GEOMETRÍA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/GEOMETRIA/Geometria_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(mCtx, nombrepdfusuario, rutasdd, rutaurldata, "true");
                            }
                        } else

                        {


                            Toast.makeText(mCtx, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T" + tomonumero + ".pdf";
                            ruta = "Trigometria_T" + tomonumero + ".pdf";
                            materiadownload = "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(mCtx, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

//                                DBwritedownloas();
//                                Log.e("DATOPDF", file0.toString());

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - TRIGONOMETRÍA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/TRIGONOMETRIA/Trigometria_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(mCtx, nombrepdfusuario, rutasdd, rutaurldata, "true");

                            }
                        } else

                        {


                            Toast.makeText(mCtx, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 4:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT" + tomonumero + ".pdf";
                            ruta = "Calculo_MentalT" + tomonumero + ".pdf";
                            materiadownload = "CALCULO_MENTAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(mCtx, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

//                                DBwritedownloas();
//                                Log.e("DATOPDF", file0.toString());

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - CÁLCULO MENTAL";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(mCtx, nombrepdfusuario, rutasdd, rutaurldata, "true");
                            }
                        } else

                        {


                            Toast.makeText(mCtx, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                }


            }
        });


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageunidad;
        ImageView imgdownload;


        public ViewHolder(View itemView) {
            super(itemView);

            imageunidad = itemView.findViewById(R.id.imgViewOptions1);

            imgdownload = itemView.findViewById(R.id.imgViewOptions3);
        }
    }


    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(mCtx);
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

            ruta_storage = mCtx.getString(R.string.ruta_raiz);


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                String rutaficheroGuardado = ruta_storage + "/APP/1/" + accesodato + "/LIBROS/" + tomo + "/MATEMATICA/" + materiadownload + ruta;

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
            } catch (InterruptedException e) {
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

            super.onProgressUpdate(values);

            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);


            Toast.makeText(mCtx, mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();


        }
    }

    private void DBwritedownloas() {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(mCtx, "administracion", null, 1);

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

        BasedeDatos.insert("descargas", null, registro);

        BasedeDatos.close();

    }

}
