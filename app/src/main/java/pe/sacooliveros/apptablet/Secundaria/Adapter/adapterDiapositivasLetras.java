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
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoLetrasDiap;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterDiapositivasLetras extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoLetrasDiap> arrayList;

    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    String ruta;
    static String tomo;
    static String tomonumero;
    static String nivel;
    static String cicloespecial;

    String servidor_ruta;

    String nombregrado;


    public adapterDiapositivasLetras(Context context, ArrayList<mTomoLetrasDiap> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void gradoasiste(String grado) {
        cicloespecial = grado;

    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static void tomoDiapositivasLetras(String tomowrite) {
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


        if (cicloespecial.equalsIgnoreCase("UNI")) {
            cicloespecial = "3";
        } else if (cicloespecial.equalsIgnoreCase("Regular") || cicloespecial.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Cuarto Año")) {
            cicloespecial = "2";
        }

        if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
            cicloespecial = "4";
        }

        if (cicloespecial.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")) {
            cicloespecial = "6";
        }

        if (cicloespecial.equalsIgnoreCase("CIRCULO")) {
            cicloespecial = "2";
        }


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tletrasdiap, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_hdiapoletras);

        final ImageView imgfoto2 = convertView.findViewById(R.id.img_downhdiapoletras);

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


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LENGUAJE/LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LENGUAJE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LENGUAJE/LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LENGUAJE/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LENGUAJE");
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


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LITERATURA/LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LITERATURA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LITERATURA/LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LITERATURA/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "LITERATURA");
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


                        //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/HELICO_DIAPOSITIVAS/TOMO1/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2"+nivel+"_HDT1.pdf


                        if (cd.isConnected()) {

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/RAZONAMIENTO_VERBAL/" + ruta);


                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
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

                            //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/HELICO_DIAPOSITIVAS/TOMO1/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2"+nivel+"_HDT1.pdf


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA DEL PERÚ");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";


                            ruta = "HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_DEL_PERU/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "HISTORIA DEL PERÚ");
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


                            //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/HELICO_DIAPOSITIVAS/TOMO1/GEOGRAFIA/GEOGRAFIA2"+nivel+"_HDT1.pdf


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOGRAFÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/GEOGRAFIA/" + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "GEOGRAFIA");
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

                            //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/HELICO_DIAPOSITIVAS/TOMO1/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2"+nivel+"_HDT1.pdf
                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA UNIVERSAL");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_UNIVERSAL/" + ruta);

                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "HISTORIA UNIVERSAL");
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


                            //http://app8.sacooliveros.edu.pe/APP/"+cicloespecial+"/"+nivel+"/HELICO_DIAPOSITIVAS/TOMO1/ECONOMIA/ECONOMIA2"+nivel+"_HDT1.pdf


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/ECONOMIA/ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ECONOMÍA");
                            context.startActivity(intent);

                        } else {


                            //String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";
                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/ECONOMIA/ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";

//                            ruta = "Calculo_MentalT"+tomonumero+".pdf";

                            ruta = "ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            //File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/" + ruta);
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/ECONOMIA/" + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "ECONOMÍA");
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

                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PSICOLOGIA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";


                            ruta = "PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/PSICOLOGIA/" + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PSICOLOGÍA");
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


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/INGLES/INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "INGLÉS");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/INGLES/INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/INGLES/" + ruta);

                            if (file0.exists())

                            {

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "INGLÉS");
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


                    case 9:


                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TEATRO y ORATORIA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";


                            ruta = "TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/" + ruta);


                            if (file0.exists())

                            {


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TEATRO y ORATORIA");
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


                    case 10:
//

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/VALORES/VLIDERAZGO2" + nivel + "_HDT" + tomonumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "Valores y Liderazgo");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/VALORES/VLIDERAZGO2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "VLIDERAZGO2" + nivel + "_HDT" + tomonumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/VALORES/" + ruta);
                            if (file0.exists()) {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "Valores y Liderazgo");
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

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LENGUAJE/LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";

                            ruta = "LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "LENGUAJE/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - LENGUAJE ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LENGUAJE/LENGUAJE2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LITERATURA/LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "LITERATURA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - LITERATURA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/LITERATURA/LITERATURA2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";


                            ruta = "RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";

//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "RAZONAMIENTO_VERBAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

//                                DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - RAZONAMIENTO VERBAL ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";
                            materiadownload = "HISTORIA_DEL_PERU/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - HISTORIA DEL PERU";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_HDT" + tomonumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "GEOGRAFIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - GEOGRAFIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_HDT" + tomonumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "HISTORIA_UNIVERSAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - HISTORIA UNIVERSAL";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_HDT" + tomonumero + ".pdf";
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

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/ECONOMIA/ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "ECONOMIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);
                                //DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - ECONOMIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/ECONOMIA/ECONOMIA2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;

                    case 7:
                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();

                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "PSICOLOGIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - PSICOLOGIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 8:
                        if (cd.isConnected()) {
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/INGLES/INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "INGLES/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {
                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - INGLES";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/INGLES/INGLES2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;


                    case 9:
                        //http://192.169.218.177/APP/2/1/HELICO_DIAPOSITIVAS/TOMO1/TEATRO/TEATRO21_HDT1.pdf

                        if (cd.isConnected()) {
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "TEATRO/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {
                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - TEATRO y ORATORIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 10:
                        // http://192.169.218.177/APP/2/1/HELICO_DIAPOSITIVAS/TOMO1/VALORES/VLIDERAZGO21_HDT1.pdf

                        if (cd.isConnected()) {
                            urlADescargar = servidor_ruta + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";
                            ruta = "TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";

                            materiadownload = "TEATRO/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {
                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Helico Diapositivas - " + tomo + " - TEATRO y ORATORIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/TEATRO/TEATRO2" + nivel + "_HDT" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else {
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

                String rutaficheroGuardado = ruta_storage + "/APP/" + cicloespecial + "/" + nivel + "/HELICO_DIAPOSITIVAS/" + tomo + "/" + materiadownload + ruta;


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


