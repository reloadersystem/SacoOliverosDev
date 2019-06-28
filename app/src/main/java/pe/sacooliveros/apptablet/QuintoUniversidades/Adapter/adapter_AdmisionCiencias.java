package pe.sacooliveros.apptablet.QuintoUniversidades.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAdmisionCiencias;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAdmisionLetras;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mCompendioCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapter_AdmisionCiencias extends BaseAdapter {


    private Context context;
    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    String  ruta;
    String servidor_ruta;
    static String tomo;
    static String tomonumero;
    static String nivel;
    static String cicloespecial;
    private ArrayList<mAdmisionCiencias> arrayList;


    public adapter_AdmisionCiencias(Context context, ArrayList<mAdmisionCiencias> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void tomoAdmisionCiencias(String tomowrite)
    {
        tomo= tomowrite;
        tomonumero= (String.valueOf(tomo.charAt(4)));

    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static void gradoasiste(String grado)
    {
        cicloespecial= grado;

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

        cicloespecial= ShareDataRead.obtenerValor(context, "TipoGradoAsiste");

        if(cicloespecial.equalsIgnoreCase("UNI"))
        {
            cicloespecial="3";
        }
        else if(cicloespecial.equalsIgnoreCase("Regular"))
        {
            cicloespecial = "2";
        }

        else if(cicloespecial.equalsIgnoreCase("SAN MARCOS"))
        {
            cicloespecial = "4";
        }

        mPropuestosCiencias item= (mPropuestosCiencias) getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_lstadmisionciencias, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_procienciapdf);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_downloadcienciapdf);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);


        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/FISICA/FISICA"+ cicloespecial +"_T1.pdf

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/FISICA/FISICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "FÍSICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/FISICA/FISICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "FISICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/FISICA/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "FISICA");
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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/QUIMICA/QUIMICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "QUIMICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/QUIMICA/QUIMICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "QUIMICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/QUIMICA/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "QUIMICA");
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


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ARITMETICA/ARITMETICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ARITMÉTICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ARITMETICA/ARITMETICA"+ cicloespecial +"_T"+tomonumero+".pdf";


                            ruta = "ARITMETICA"+ cicloespecial +"_T"+tomonumero+".pdf";



                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ARITMETICA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ARITMÉTICA");
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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ALGEBRA/ALGEBRA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ALGEBRA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ALGEBRA/ALGEBRA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "ALGEBRA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ALGEBRA/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ALGEBRA");
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


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOMETRIA/GEOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOMETRIA/GEOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "GEOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOMETRIA/" + ruta);

                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "GEOMETRÍA");
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



                    case 5:
                        if (cd.isConnected()) {


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TRIGONOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";


                            ruta = "TRIGONOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/TRIGONOMETRIA/" + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TRIGONOMETRÍA");
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

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/FISICA/FISICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "FISICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "FISICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/QUIMICA/QUIMICA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "QUIMICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "QUIMICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ARITMETICA/ARITMETICA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "ARITMETICA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);





                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ALGEBRA/ALGEBRA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "ALGEBRA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOMETRIA/GEOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "GEOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }





                        break;


                    case 5:

                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "TRIGONOMETRIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ", " ");


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
            ///data/user/0/pe.sacooliveros.apptablet/files

            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                String rutaficheroGuardado = ruta_storage+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/"+materiadownload + ruta;


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
