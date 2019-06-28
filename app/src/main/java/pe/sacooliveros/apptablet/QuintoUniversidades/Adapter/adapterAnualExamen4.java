package pe.sacooliveros.apptablet.QuintoUniversidades.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAnualExamen4B;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterAnualExamen4 extends BaseAdapter {

    private Context context;
    private ArrayList<mAnualExamen4B> arrayList;
    ConnectionDetector cd;
    String ciclo;
    String ruta;
    String tituloexamen;
    String urlADescargar;
    String ruta_storage;
    String tipogrado;

    public adapterAnualExamen4(Context context, ArrayList<mAnualExamen4B> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_b2anual, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_admisionanual2);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_anualdescarga2);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        tipogrado = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");

        if (tipogrado.equalsIgnoreCase("UNI")) {
            ciclo = "3";
        } else if (tipogrado.equalsIgnoreCase("SAN MARCOS")) {
            ciclo = "4";
        } else if (tipogrado.equalsIgnoreCase("CATOLICA")) {
            ciclo = "5";
        } else if (tipogrado.equalsIgnoreCase("PRE")) {
            ciclo = "6";

        }


        cd = new ConnectionDetector(context);


        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:

                        if (cd.isConnected()) {

                            String URL = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2014_IB4.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", " EXÁMEN DE ADMISIÓN 2014 - I");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2014_IB4.pdf";

                            ruta = "2014_IB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "EXÁMEN DE ADMISIÓN 2014 - I");
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

                            String URL = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IIB4.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", " EXÁMEN DE ADMISIÓN 2013 - II");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IIB4.pdf";

                            ruta = "2013_IIB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "EXÁMEN DE ADMISIÓN 2013 - II");
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

                            String URL = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IB4.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", " EXÁMEN DE ADMISIÓN 2013 - I");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IB4.pdf";

                            ruta = "2013_IB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "EXÁMEN DE ADMISIÓN 2013 - I");
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


        imgfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:

                        if (cd.isConnected()) {

                            urlADescargar = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2014_IB4.pdf";

                            ruta = "2014_IB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                               // DBwritedownloas();

                                String nombrepdfusuario = "E.Admisión por Años - Bimestre 4 - 2014 I";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2014_IB4.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 1:

                        if (cd.isConnected()) {

                            urlADescargar = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IIB4.pdf";

                            ruta = "2013_IIB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                               // DBwritedownloas();

                                String nombrepdfusuario = "E.Admisión por Años - Bimestre 4 - 2013 II";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IIB4.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:
                        if (cd.isConnected()) {

                            urlADescargar = "http://192.169.218.177/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IB4.pdf";

                            ruta = "2013_IB4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE2/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "E.Admisión por Años - Bimestre 4 - 2013 I";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/2013_IIB4.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

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

                String rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE4/" + ruta;

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


        }
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

        BasedeDatos.insert("descargas", null, registro);

        BasedeDatos.close();

    }

}
