package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mPfMatematica;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterPFMatematica extends BaseAdapter {

    private Context context;
    private ArrayList<mPfMatematica> arrayList;

    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    String ruta;
    static String tomo;
    static String bimestre;
    static String nivel;
    static String gradoasiste;

    static String cicloespecial;

   String nombregrado;

    String servidor_ruta;

    public adapterPFMatematica(Context context, ArrayList<mPfMatematica> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static void gradoasiste(String grado) {
        cicloespecial = grado;
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

        nombregrado = ShareDataRead.obtenerValor(context, "GradoNombre");

        if (cicloespecial == null) {
            cicloespecial = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");

        }


        if (cicloespecial.equalsIgnoreCase("UNI")) {
            cicloespecial = "3";
        } else if (cicloespecial.equalsIgnoreCase("Regular") || cicloespecial.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Cuarto Año")) {
            cicloespecial = "2";
        } else if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
            cicloespecial = "4";
        } else if (cicloespecial.equalsIgnoreCase("CATOLICA")) {
            cicloespecial = "5";
        } else if (cicloespecial.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")) {
            cicloespecial = "6";
        } else if (cicloespecial.equalsIgnoreCase("CIRCULO")) {
            cicloespecial = "2";
        }

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_pfmatematica, null);
        }

        ImageView imgfoto = convertView.findViewById(R.id.img_pfmatematica);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_pfmatematicadown);


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

                            //http://app8.sacooliveros.edu.pe/APP/3/5/PRINCIPIOS_FMATEMATICA/BIMESTRE1/PRINCIPIOS_FMATEMATICA25_B1.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PRIMER BIMESTRE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";

                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/" + ruta);

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

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "SEGUNDO BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";

                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/" + ruta);


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

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TERCER BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";

                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/" + ruta);


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

                            //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/PRINCIPIOS_FMATEMATICA/BIMESTRE4/PRINCIPIOS_FMATEMATICA2"+nivel+"_B4.pdf

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "CUARTO BIMESTRE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";

                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";

//
//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/" + ruta);

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

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";
                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Principios F.de la Matemática - BIMESTRE 1";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE1/PRINCIPIOS_FMATEMATICA2" + nivel + "_B1.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");}

                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {

                            bimestre = "BIMESTRE2";

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";
                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                    String nombrepdfusuario = "Principios F.de la Matemática - BIMESTRE 2";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE2/PRINCIPIOS_FMATEMATICA2" + nivel + "_B2.pdf";
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
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";
                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                    String nombrepdfusuario = "Principios F.de la Matemática - BIMESTRE 3";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE3/PRINCIPIOS_FMATEMATICA2" + nivel + "_B3.pdf";
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
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";
                            ruta = "PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                    String nombrepdfusuario = "Principios F.de la Matemática - BIMESTRE 4";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/BIMESTRE4/PRINCIPIOS_FMATEMATICA2" + nivel + "_B4.pdf";
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


                String rutaficheroGuardado = ruta_storage + "/APP/" + cicloespecial + "/" + nivel + "/PRINCIPIOS_FMATEMATICA/" + bimestre + "/" + ruta;

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
