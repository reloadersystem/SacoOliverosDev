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
import pe.sacooliveros.apptablet.Secundaria.Model.mMateriasOne;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

/**
 * Created by sistem03user on 14/11/2018.
 */

public class adapter_materiales extends BaseAdapter {

    private Context context;
    private ArrayList<mMateriasOne> arrayList;
    String servidor_ruta;
    ConnectionDetector cd;
    String ruta_storage;
    static String tomo;
    static String tomonumero;
    static String nivel;
    static String cicloespecial;
    String sharedata;
    String urlADescargar;
    String materiadownload;
    String nombregrado;
    String ruta;

    String materia;
    String materiagrado;


    public adapter_materiales(Context context, ArrayList<mMateriasOne> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static void gradoasiste(String grado) {
        cicloespecial = grado;

    }


    public static void tomomateriales(String tomowrite) {
        tomo = tomowrite;
        tomonumero = (String.valueOf(tomo.charAt(4)));

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

        if (nivel == null) {
            nivel = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);
        }


        if (cicloespecial == null)

        {
            sharedata = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");

            cicloespecial = sharedata;


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


        } else

        {
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


        }

        mMateriasOne Item = (mMateriasOne) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_onelist, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_onelist);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_compendiosdescarga);


        final View finalConvertView = convertView;


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

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/FISICA/FISICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "FÍSICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/FISICA/FISICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = "FISICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/FISICA/" + ruta);


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

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/QUIMICA/QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "QUIMICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/QUIMICA/QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = "QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/QUIMICA/" + ruta);


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

                        if (cicloespecial == "3") {

                            if (cd.isConnected()) {


                                //http://192.169.218.177/APP/3/5/COMPENDIOS/TOMO2/ARITMETICA/ARITMETICA25_CT2.pdf

                                String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ARITMETICA/ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "ARITMETICA");
                                context.startActivity(intent);

                            } else {


                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ARITMETICA/ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";

                                ruta = "ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ARITMETICA/" + ruta);


                                if (file0.exists())

                                {

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);

                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "ARITMETICA");
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


                        } else {
                            if (cd.isConnected()) {


                                String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/BIOLOGIA/BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "BIOLOGIA");
                                context.startActivity(intent);

                            } else {


                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/BIOLOGIA/BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";

                                ruta = "BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/BIOLOGIA/" + ruta);


                                if (file0.exists())

                                {

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);

                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "BIOLOGIA");
                                    intent.putExtra("EstadoConexion", "SinConexion");
                                    context.startActivity(intent);

                                    Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                    break;

                                } else {
                                    Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                    break;

                                }

                            }

                        }


                        break;


                    case 3:

                        if (cicloespecial == "3") {

                            materia = "ALGEBRA";
                            materiagrado = materia + "2";

                        } else {
                            materia = "ARITMETICA";
                            materiagrado = materia + "2";
                        }

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + materiagrado + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", materia);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + materiagrado + nivel + "_CT" + tomonumero + ".pdf";


                            ruta = materiagrado + nivel + "_CT" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", materia);
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

                        if (cicloespecial == "3") {

                            materia = "GEOMETRIA";
                            materiagrado = materia + "2";

                        } else {
                            materia = "ALGEBRA";
                            materiagrado = materia + "2";
                        }

                        if (cd.isConnected()) {

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + materiagrado + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", materia);
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + materiagrado + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = materiagrado + nivel + "_CT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materia + "/" + ruta);

                            if (file0.exists())

                            {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", materia);
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


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/GEOMETRIA/GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/GEOMETRIA/GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = "GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/GEOMETRIA/" + ruta);

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


                    case 6:

                        if (cd.isConnected()) {

                            //http://192.169.218.177/APP/4/5/COMPENDIOS/TOMO1/TRIGONOMETRIA/TRIGONOMETRIA25_CT1.pdf


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TRIGONOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = "TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/TRIGONOMETRIA/" + ruta);

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


                    case 7:


                        if (cicloespecial == "3" || cicloespecial == "4" || cicloespecial == "6") {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else {

                            if (cd.isConnected()) {


                                String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";

//                            String URL = servidor_ruta+"/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                                context.startActivity(intent);

                            } else {


                                //String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";
                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";

//                            ruta = "Calculo_MentalT"+tomonumero+".pdf";

                                ruta = "RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";

                                //File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/" + ruta);
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/RAZONAMIENTO_MATEMATICO/" + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                                if (file0.exists())

                                {


                                    Intent intent = new Intent(context, ViewTomo3Activity.class);

                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                                    intent.putExtra("EstadoConexion", "SinConexion");
                                    context.startActivity(intent);

                                    Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                    break;

                                } else {
                                    Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                    break;

                                }

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

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/FISICA/FISICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            ruta = "FISICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            materiadownload = "FISICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - FISICA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/FISICA/FISICA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/QUIMICA/QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";
                            ruta = "QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";

                            materiadownload = "QUIMICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - QUIMICA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/QUIMICA/QUIMICA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:

                        if (cicloespecial == "3") {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else {
                            if (cd.isConnected()) {

                                urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/BIOLOGIA/BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";
                                ruta = "BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";

                                materiadownload = "BIOLOGIA/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                                } else {


                                    descargarPDF(urlADescargar);

                                    // DBwritedownloas();

                                    String nombrepdfusuario = "Compendios - " + tomo + " - BIOLOGIA";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/BIOLOGIA/BIOLOGIA2" + nivel + "_CT" + tomonumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                                }
                            } else

                            {


                                Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                        }


                        break;


                    case 3:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ARITMETICA/ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";
                            ruta = "ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";
                            materiadownload = "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - ARITMETICA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ARITMETICA/ARITMETICA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 4:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ALGEBRA/ALGEBRA2" + nivel + "_CT" + tomonumero + ".pdf";
                            ruta = "ALGEBRA2" + nivel + "_CT" + tomonumero + ".pdf";

                            materiadownload = "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - ALGEBRA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/ALGEBRA/ALGEBRA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 5:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/GEOMETRIA/GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";
                            ruta = "GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            materiadownload = "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - GEOMETRIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/GEOMETRIA/GEOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                    case 6:

                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();

                            //http://192.169.218.177/APP/4/5/COMPENDIOS/TOMO1/TRIGONOMETRIA/TRIGONOMETRIA25_CT1.pdf


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";
                            ruta = "TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";

                            materiadownload = "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Compendios - " + tomo + " - TRIGONOMETRIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_CT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 7:


                        if (cicloespecial == "3" || cicloespecial == "4" || cicloespecial == "6") {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else {
                            if (cd.isConnected()) {
                                // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                                urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";
                                ruta = "RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";

                                materiadownload = "RAZONAMIENTO_MATEMATICO/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                                } else {


                                    descargarPDF(urlADescargar);

                                    //DBwritedownloas();

                                    String nombrepdfusuario = "Compendios - " + tomo + " - RAZONAMIENTO MATEMATICO";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_CT" + tomonumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                                }
                            } else

                            {


                                Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                            }

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

                String rutaficheroGuardado = ruta_storage + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload + ruta;

                String rutajson = ruta_storage + "/APP/" + cicloespecial + "/" + nivel + "/COMPENDIOS/" + tomo + "/" + materiadownload;

                //DownloadJSON.descargar(urlADescargar, context, rutajson, ruta);


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




