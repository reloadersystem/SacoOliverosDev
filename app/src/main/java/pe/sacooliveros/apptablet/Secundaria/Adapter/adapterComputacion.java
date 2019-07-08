package pe.sacooliveros.apptablet.Secundaria.Adapter;

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

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoComputacion;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterComputacion extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoComputacion> arrayList;
    ConnectionDetector cd;

    private FirebaseAnalytics mFirebaseAnalytics;

    String ruta;
    String urlADescargar;
    String ruta_storage;
    String positiontomo;
    static String nivel;
    String servidor_ruta;
    static String btnName;

    public adapterComputacion(Context context, ArrayList<mTomoComputacion> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_computacion, null);

        }

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);

        ImageView imgfoto = convertView.findViewById(R.id.img_initlist);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_computaciondown);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position) {

                    case 0:

                        btnName = "btnBimestre1";

                        if (cd.isConnected()) {


                            positiontomo = String.valueOf(position + 1);

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 1");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T1.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/" + ruta);

                            if (file0.exists()) {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 1");
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

                        btnName = "btnBimestre2";

                        if (cd.isConnected()) {


                            positiontomo = String.valueOf(position + 1);
                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 2");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T2.pdf";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 2");
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

                        btnName = "btnBimestre3";
                        if (cd.isConnected()) {

                            positiontomo = String.valueOf(position + 1);

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 3");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T3.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 3");
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

                        btnName = "btnBimestre4";

                        if (cd.isConnected()) {

                            positiontomo = String.valueOf(position + 1);

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";
                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 4");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 4");
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

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T1.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO 1";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T2.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO 2";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T3.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO3";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                    case 3:


                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO4";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";
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

                String rutaficheroGuardado = ruta_storage + "/APP/2/" + nivel + "/COMPUTACION/TOMO" + positiontomo + "/" + ruta;

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


}
