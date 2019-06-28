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

import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mSimulacrosUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterSimulacroUni extends BaseAdapter {

    private Context context;
    private ArrayList<mSimulacrosUni> arrayList;

    ConnectionDetector cd;
    String urlADescargar;
    String ruta_storage;
    String ruta;
    static String bimestre;
    static String nivel;
    static String cicloespecial;
    String servidor_ruta;
    String universidad;
    static String seleccionname;
    String root_ssd;

    public adapterSimulacroUni(Context context, ArrayList<mSimulacrosUni> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public static void nombreseleccion(String nombre) {

        seleccionname = nombre;

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


        cicloespecial = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");  //UNI
        nivel = String.valueOf(ShareDataRead.obtenerValor(context, "ServerGradoNivel").charAt(0)); //5

        if (cicloespecial.equalsIgnoreCase("SELECCION"))

        {
            if (seleccionname.equalsIgnoreCase("UNI")) {
                cicloespecial = "3";
                universidad = "UNI";
                nivel = "5";
            }

            if (seleccionname.equalsIgnoreCase("SAN MARCOS")) {
                cicloespecial = "4";
                universidad = "SM";
                nivel = "5";
            }

            if (seleccionname.equalsIgnoreCase("CATOLICA")) {
                cicloespecial = "5";
                universidad = "CATOLICA";
                nivel = "5";
            }
        }

        if (cicloespecial.equalsIgnoreCase("UNI")) {
            cicloespecial = "3";
            universidad = "UNI";
        } else if (cicloespecial.equalsIgnoreCase("Regular")) {
            cicloespecial = "2";
        } else if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
            cicloespecial = "4";
            universidad = "SM";
        } else if (cicloespecial.equalsIgnoreCase("CATOLICA")) {
            cicloespecial = "5";
            universidad = "CATOLICA";
        } else if (cicloespecial.equalsIgnoreCase("PRE")) {
            cicloespecial = "6";
            universidad = "PRE";
        }


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_unisimulacro, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_pfsimulacro);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_pfsimulacrodown);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);
        root_ssd = context.getString(R.string.ruta_ssd);


        cd = new ConnectionDetector(context);

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/3/5/SIMULACRO_EXADM/BIMESTRE1/"+ universidad +"_B1.pdf
                            //SM_B1.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + universidad + "_B1.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PRIMER BIMESTRE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + universidad + "_B1.pdf";

                            ruta = "" + universidad + "_B1.pdf";


                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PRIMER BIMESTRE");
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

                            //http://192.169.218.177/APP/3/5/SIMULACRO_EXADM/BIMESTRE2/"+ universidad +"_B2.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + universidad + "_B2.pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "SEGUNDO BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + universidad + "_B2.pdf";

                            ruta = "" + universidad + "_B2.pdf";


                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "SEGUNDO BIMESTRE");
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

                            //http://192.169.218.177/APP/3/5/SIMULACRO_EXADM/BIMESTRE3/"+ universidad +"_B3.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + universidad + "_B3.pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TERCER BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + universidad + "_B3.pdf";

                            ruta = "" + universidad + "_B3.pdf";

                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + ruta);


                            if (file0.exists())

                            {

                                //   String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TERCER BIMESTRE");
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

                            //http://192.169.218.177/APP/3/5/SIMULACRO_EXADM/BIMESTRE4/"+ universidad +"_B4.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + universidad + "_B4.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "CUARTO BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + universidad + "_B4.pdf";

                            ruta = "" + universidad + "_B4.pdf";

//
//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + ruta);

                            if (file0.exists())

                            {

                                //   String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "CUARTO BIMESTRE");
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


                            bimestre = "BIMESTRE1";

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + universidad + "_B1.pdf";
                            ruta = "" + universidad + "_B1.pdf";

                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Simulacro E.Adm. BIMESTRE1";
                                String rutasdd = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE1/" + universidad + "_B1.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {

                            bimestre = "BIMESTRE2";

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + universidad + "_B2.pdf";
                            ruta = "" + universidad + "_B2.pdf";

                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Simulacro E.Adm. BIMESTRE2";
                                String rutasdd = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE2/" + universidad + "_B2.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {

                            bimestre = "BIMESTRE3";
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + universidad + "_B3.pdf";
                            ruta = "" + universidad + "_B3.pdf";

                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Simulacro E.Adm. BIMESTRE3";
                                String rutasdd = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE3/" + universidad + "_B3.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                    case 3:


                        if (cd.isConnected()) {

                            bimestre = "BIMESTRE4";
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + universidad + "_B4.pdf";
                            ruta = "" + universidad + "_B4.pdf";

                            File file0 = new File(root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Simulacro E.Adm. BIMESTRE4";
                                String rutasdd = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/BIMESTRE4/" + universidad + "_B4.pdf";
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


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                //"/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/SIMULACRO_EXADM/SIMULACRO_EXADM/"+ ruta

                String rutaficheroGuardado = root_ssd + "/" + cicloespecial + "/" + nivel + "/SIMULACRO_EXADM/" + bimestre + "/" + ruta;

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
