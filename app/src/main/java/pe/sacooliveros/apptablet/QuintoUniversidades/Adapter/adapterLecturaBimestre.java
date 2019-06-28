package pe.sacooliveros.apptablet.QuintoUniversidades.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mLecturaBimestre;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterLecturaBimestre extends BaseAdapter {

    private Context context;
    private ArrayList<mLecturaBimestre> arrayList;
    ConnectionDetector cd;

    static String bimselect;

    String ruta;

    String urlADescargar;

    String ruta_storage;

    String materia;


    public adapterLecturaBimestre(Context context, ArrayList<mLecturaBimestre> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }

    public adapterLecturaBimestre() {

    }

    public void bimestreSeleccionado(String bimestre) {
        bimselect = bimestre;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_b1anual, null);

        }

        cd = new ConnectionDetector(context);

        ImageView imgfoto = convertView.findViewById(R.id.img_admisionanual);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_anualdescarga);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        final String numerobimestre = bimselect.substring(bimselect.length() - 1, bimselect.length());


        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B1.pdf

                            String URL = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "REDACCION DEL LENGUAJE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";

                            ruta = "REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LECTURAS MOTIVADORAS - REDACCION DEL LENGUAJE");
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

                        //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/LECTURA_CRITICA/LECTURA_CRITICA_B1.pdf
                        if (cd.isConnected()) {


                            String URL = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/LECTURA_CRITICA/LECTURA_CRITICA_B" + numerobimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LECTURA CRITICA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/LECTURA_CRITICA/LECTURA_CRITICA_B" + numerobimestre + ".pdf";

                            ruta = "LECTURA_CRITICA_B" + numerobimestre + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURA_CRITICA/" + bimselect + "/LECTURA_CRITICA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LECTURAS MOTIVADORAS - LECTURA CRITICA");
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
                        //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B1.pdf
                        if (cd.isConnected()) {

                            String URL = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "COMPRENSION LECTORA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";

                            ruta = "COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/COMPRENSION_LECTORA/" + bimselect + "/COMPRENSION_LECTORA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LECTURAS MOTIVADORAS - COMPRENSION LECTORA");
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

                        //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE_B1.pdf
                        if (cd.isConnected()) {

                            String URL = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ILATIVOS DEL LENGUAJE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";

                            ruta = "ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/ILATIVOS_DELENGUAJE/" + bimselect + "/ILATIVOS_DELENGUAJE/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LECTURAS MOTIVADORAS - ILATIVOS DEL LENGUAJE");
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

                            //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B1.pdf

                            urlADescargar = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";

                            ruta = "REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";

                            materia = "REDACCION_DELENGUAJE";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LECTURAS MOTIVADORAS - REDACCION DEL LENGUAJE B" + numerobimestre;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE_B" + numerobimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 1:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/LECTURA_CRITICA/LECTURA_CRITICA_B1.pdf

                            urlADescargar = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/LECTURA_CRITICA/LECTURA_CRITICA_B" + numerobimestre + ".pdf";

                            ruta = "LECTURA_CRITICA_B" + numerobimestre + ".pdf";

                            materia = "LECTURA_CRITICA";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/LECTURA_CRITICA/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LECTURAS MOTIVADORAS - LECTURA CRITICA B" + numerobimestre;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/LECTURA_CRITICA/LECTURA_CRITICA_B" + numerobimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 2:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B1.pdf

                            urlADescargar = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";

                            ruta = "COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";

                            materia = "COMPRENSION_LECTORA";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/COMPRENSION_LECTORA/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LECTURAS MOTIVADORAS - COMPRENSION LECTORA B" + numerobimestre;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA_B" + numerobimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;


                    case 3:

                        if (cd.isConnected()) {

                            urlADescargar = "http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";

                            ruta = "ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";

                            materia = "ILATIVOS_DELENGUAJE";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/ILATIVOS_DELENGUAJE/" + ruta);

                            if (file0.exists()) {

                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "LECTURAS MOTIVADORAS - ILATIVOS DEL LENGUAJE B" + numerobimestre;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE_B" + numerobimestre + ".pdf";
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

                String rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURAS_MOTIVADORAS/" + bimselect + "/" + materia + "/" + ruta;

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
}


