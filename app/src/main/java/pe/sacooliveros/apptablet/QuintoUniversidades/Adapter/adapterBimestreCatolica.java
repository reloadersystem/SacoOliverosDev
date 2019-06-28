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

import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mBimestreCatolica;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterBimestreCatolica extends BaseAdapter {

    private Context context;
    private ArrayList<mBimestreCatolica> arrayList;
    ConnectionDetector cd;

    String servidor_ruta;

    String ruta;

    String rutassd;

    String urlADescargar;


    static String bimestrenombre;

    String ruta_storage;

    String materiadownload;

    static String bimestre;

    public adapterBimestreCatolica(Context context, ArrayList<mBimestreCatolica> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void bimestreCatolica(String bimestre) {

        bimestrenombre = bimestre;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tomocatolica, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_tomocatolica);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_downloadcatolica);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        cd = new ConnectionDetector(context);

        servidor_ruta = context.getString(R.string.servidor_ruta);
        rutassd = context.getString(R.string.ruta_ssd);

        final String numbimestre = bimestrenombre.substring(bimestrenombre.length() - 1, bimestrenombre.length());

        bimestre = bimestrenombre.replace(" ", "");


        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {

                    case 0:

                        if (cd.isConnected()) {

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "NÚMEROS OPERACIONES");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";

                            ruta = "NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "NÚMEROS OPERACIONES");
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

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB1.pdf

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ANALISIS Y ABSTRACCION");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf";

                            ruta = "NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ANALISIS Y ABSTRACCION");
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

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/PLANIMETRIA/PLANIMETRIA55_ECB1.pdf

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/PLANIMETRIA55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PLANIMETRIA");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/PLANIMETRIA55_ECB" + numbimestre + ".pdf";

                            ruta = "PLANIMETRIA55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/" + ruta);

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

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ESTADISTICA/ESTADISTICA55_ECB1.pdf

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/ESTADISTICA55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ESTADISTICA");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/ESTADISTICA55_ECB" + numbimestre + ".pdf";

                            ruta = "ESTADISTICA55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ESTADISTICA");
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

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB1.pdf

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PROGRAMACION LINEAL");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";

                            ruta = "PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PROGRAMACION LINEAL");
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

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB1.pdf

                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "REDACCION USOS DEL LENGUAJE");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            ruta = "REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "REDACCION USOS DEL LENGUAJE");
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

                        // http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/LECTURA_CRITICA/LECTURA_CRITICA55_ECB1.pdf


                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LECTURA CRITICA");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";

                            ruta = "LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LECTURA CRITICA");
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
                        //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB1.pdf


                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "COMPRENSION LECTORA");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";

                            ruta = "COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "COMPRENSION LECTORA");
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
                        //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB1.pdf
                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ILATIVOS USOS DEL LENGUAJE");
                            context.startActivity(intent);
                        } else {

                            String ssdFile = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            ruta = "ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";


                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/" + ruta);

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


                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";

                            ruta = "NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";

                            materiadownload = "NUMERO_OPERACIONES/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - NUMEROS Y OPERACIONES - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/NUMERO_OPERACIONES/NUMERO_OPERACIONES55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf";

                            ruta = "ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf";

                            materiadownload = "ANALISIS_ABSTRACCION/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - ANALISIS Y ABSTRACCION - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 2:


                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/PLANIMETRIA/PLANIMETRIA55_ECB1.pdf


                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/PLANIMETRIA55_ECB" + numbimestre + ".pdf";

                            ruta = "PLANIMETRIA55_ECB" + numbimestre + ".pdf";

                            materiadownload = "PLANIMETRIA/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/PLANIMETRIA55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - PLANIMETRIA - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PLANIMETRIA/PLANIMETRIA55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ESTADISTICA/ESTADISTICA55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/ESTADISTICA55_ECB" + numbimestre + ".pdf";

                            ruta = "ESTADISTICA55_ECB" + numbimestre + ".pdf";

                            materiadownload = "ESTADISTICA/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/ESTADISTICA55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - ESTADISTICA - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ESTADISTICA/ESTADISTICA55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 4:


                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";

                            ruta = "PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";

                            materiadownload = "PROGRAMACION_LINEAL/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - PROGRAMACION LINEAL - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 5:


                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            ruta = "REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            materiadownload = "REDACCION_DELENGUAJE/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - REDACCION DEL LENGUAJE - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }

                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 6:


                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/LECTURA_CRITICA/LECTURA_CRITICA55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";

                            ruta = "LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";

                            materiadownload = "LECTURA_CRITICA/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/LECTURA_CRITICA55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - LECTURA CRITICA - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/LECTURA_CRITICA/LECTURA_CRITICA55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }

                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 7:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";

                            ruta = "COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";

                            materiadownload = "COMPRENSION_LECTORA/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - COMPRENSION LECTORA - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_ECB" + numbimestre + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }

                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 8:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/5/5/PEADM_CAP/BIMESTRE1/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB1.pdf

                            urlADescargar = servidor_ruta + "/APP/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            ruta = "ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";

                            materiadownload = "ILATIVOS_DELENGUAJE/";

                            File file0 = new File(rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf");

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "PEAdm - ILATIVOS DEL LENGUAJE - " + bimestre;
                                String rutasdd = rutassd + "/5/5/PEADM_CAP/" + bimestre + "/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_ECB" + numbimestre + ".pdf";
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

                String rutaficheroGuardado = ruta_storage + "/APP/5/5/PEADM_CAP/" + bimestre + "/" + materiadownload + ruta;


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
