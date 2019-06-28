package pe.sacooliveros.apptablet.QuintoCatolica.Adapter;

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

import pe.sacooliveros.apptablet.QuintoCatolica.Model.mTomoCatolica;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterTomoCatolica extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoCatolica> arrayList;
    String servidor_ruta;
    ConnectionDetector cd;

    String ruta;

    String urlADescargar;

    String materiadownload;

    String  ruta_storage;

    static String tomonumero;
     static String  tomo;



    public adapterTomoCatolica(Context context, ArrayList<mTomoCatolica> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void tomoCatolica(String tomowrite)
    {
        tomo= tomowrite;
        tomonumero= (String.valueOf(tomowrite.charAt(4)));
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

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_tomocatolica,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.img_tomocatolica);
        ImageView imgfoto2= convertView.findViewById(R.id.img_downloadcatolica);



        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch(position)
                {
                    case 0:
                        if (cd.isConnected()) {


                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "NÚMEROS OPERACIONES");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf";

                            ruta = "NUMERO_OPERACIONE55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/" + ruta);

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

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf


                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ANÁLISIS y ABSTRACCIÓN");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf";

                            ruta = "ANALISIS_ABSTRACCION55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ANÁLISIS y ABSTRACCIÓN");
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

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf


                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PLANIMETRÍA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf";

                            ruta = "PLANIMETRIA55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PLANIMETRIA");
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

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf

                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ESTADÍSTICA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf";

                            ruta = "ESTADISTICA55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ESTADÍSTICA");
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

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf

                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PROGRAMACIÓN LINEAL");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf";

                            ruta = "PROGRAMACION_LINEAL55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PROGRAMACIÓN LINEAL");
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

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf

                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "REDACCIÓN USO DEL LENGUAJE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf";

                            ruta = "REDACCION_DELENGUAJE55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "REDACCIÓN USO DEL LENGUAJE");
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


                        case 6:
                            if (cd.isConnected()) {

                                //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf

                                String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "LECTURA CRÍTICA");
                                context.startActivity(intent);

                            } else {

                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf";

                                ruta = "LECTURA_CRITICA55_VHS.pdf";


                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/" + ruta);

                                if (file0.exists())

                                {

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);

                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "LECTURA CRÍTICA");
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


                    case 7:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf

                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "COMPRENSIÓN LECTORA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf";

                            ruta = "COMPRENSION_LECTORA55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "COMPRENSIÓN LECTORA");
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


                    case 8:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf

                            String URL = servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ILATIVOS USOS DEL LENGUAJE");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf";

                            ruta = "ILATIVOS_DELENGUAJE55_VHS.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ILATIVOS USOS DEL LENGUAJE");
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


                    //servidor_ruta+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf

                    urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf";

                    ruta = "NUMERO_OPERACIONE55_VHS.pdf";

                    materiadownload= "NUMERO_OPERACIONES/";

                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/"+ materiadownload + ruta);


                    if (file0.exists()) {
                        Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                    } else {


                        descargarPDF(urlADescargar);

                        String nombrepdfusuario = "H.Diap - NUMEROS Y OPERACIONES " +tomo;
                        String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf";
                        DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                    }
                } else

                {


                    Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                }


                break;


                    case 1:



                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf";

                            ruta = "ANALISIS_ABSTRACCION55_VHS.pdf";

                            materiadownload= "ANALISIS_ABSTRACCION/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - ANALISIS Y ABSTRACCION " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf";

                            ruta = "PLANIMETRIA55_VHS.pdf";

                            materiadownload= "PLANIMETRIA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - PLANIMETRIA " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:


                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf";

                            ruta = "ESTADISTICA55_VHS.pdf";

                            materiadownload= "ESTADISTICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - ESTADISTICA " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 4:

                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf";

                            ruta = "PROGRAMACION_LINEAL55_VHS.pdf";

                            materiadownload= "PROGRAMACION_LINEAL/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/PROGRAMACION_LINEAL/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - PROGRAMACION LINEAL " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;




                    case 5:

                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf";

                            ruta = "REDACCION_DELENGUAJE55_VHS.pdf";

                            materiadownload= "REDACCION_DELENGUAJE/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/REDACCION_DELENGUAJE/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - REDACCION USOS DEL LENGUAJE " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 6:

                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf";

                            ruta = "LECTURA_CRITICA55_VHS.pdf";

                            materiadownload= "LECTURA_CRITICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/LECTURA_CRITICA/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - LECTURA CRITICA " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 7:

                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf";

                            ruta = "COMPRENSION_LECTORA55_VHS.pdf";

                            materiadownload= "COMPRENSION_LECTORA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/COMPRENSION_LECTORA/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - COMPRENSION LECTORA " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 8:

                        if (cd.isConnected()) {


                            //http://192.169.218.177/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/

                            urlADescargar = servidor_ruta+ "/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf";

                            ruta = "ILATIVOS_DELENGUAJE55_VHS.pdf";

                            materiadownload= "ILATIVOS_DELENGUAJE/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/ILATIVOS_DELENGUAJE/"+tomo+"/"+ materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "H.Diap - ILATIVOS DE USOS DEL LENGUAJE " +tomo;
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf";
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

                 String rutaficheroGuardado = ruta_storage+"/APP/5/5/HELICO_DIAPOSITIVAS/"+tomo+"/"+ materiadownload + ruta;


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
