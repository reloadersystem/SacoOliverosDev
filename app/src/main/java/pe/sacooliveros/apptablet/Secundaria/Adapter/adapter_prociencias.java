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
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapter_prociencias extends BaseAdapter {

    private Context context;
    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;

    String ruta;

    static String mes;

    static String mesnumero;

    static String nivel;

    String servidor_ruta;

    private ArrayList<mPropuestosCiencias> arrayList;

    public adapter_prociencias(Context context, ArrayList<mPropuestosCiencias> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    public static void instantiate(String servernivel) {


        nivel = servernivel; //2 "primaria
    }

    public static void mes(String meswrite) {
        mes = meswrite;
        int num = Integer.parseInt(mes.substring(3, 4));
        mesnumero = String.valueOf(num + 1);

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

        mPropuestosCiencias item = (mPropuestosCiencias) getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_listciencias, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_procienciapdf);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_downloadcienciapdf);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);

        String gradopre= ShareDataRead.obtenerValor(context, "TipoGradoAsiste");
        String nivelpre= ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0,1);


        if(nivel==null)
        {
            nivel= ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0,1);
        }

        imgfoto.setOnClickListener(new View.OnClickListener() {

            // TipoGradoAsiste

            @Override
            public void onClick(View view) {

                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "FÍSICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/FISICA/" + ruta);


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


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "QUIMICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/QUIMICA/" + ruta);


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


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

//                          String URL = servidor_ruta+"/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/GEOMETRIA/Geometria_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "BIOLOGÍA");
                            context.startActivity(intent);

                        } else {


                            // String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/GEOMETRIA/Geometria_T"+tomonumero+".pdf";
                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            //ruta = "Geometria_T"+tomonumero+".pdf";
                            ruta = "BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            // File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/GEOMETRIA/" + ruta);
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/BIOLOGIA/" + ruta);

                            if (file0.exists())

                            {

//                                String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "BIOLOGÍA");
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


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ARITMÉTICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            ruta = "ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ARITMETICA/" + ruta);

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


                    case 4:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ALGEBRA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ALGEBRA/" + ruta);


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


                    case 5:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOMETRIA/" + ruta);

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


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TRIGONOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            ruta = "TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/TRIGONOMETRIA/" + ruta);


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

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";

//                       

                            ruta = "RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/" + ruta);


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


                        break;

                }
            }


        });


        imgfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nivel == null) {

                    nivel = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);

                }

                switch (position) {


                    case 0:


                        if (cd.isConnected()) {

                            //http://http://app8.sacooliveros.edu.pe/APP/2/5/PROBLEMAS_PROPUESTOS/MES10/FISICA/FISICA25_PPM10.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "FISICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - FISICA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "QUIMICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - QUIMICA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PPM" + mesnumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            ruta = "BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "BIOLOGIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - BIOLOGIA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            materiadownload = "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - ARITMETICA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PPM" + mesnumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - ALGEBRA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PPM" + mesnumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - GEOMETRIA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";
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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - TRIGONOMETRIA ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 7:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "RAZONAMIENTO_MATEMATICO/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - RAZONAMIENTO\n MATEMATICO ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PPM" + mesnumero + ".pdf";
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

                String rutaficheroGuardado = ruta_storage + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta;

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


