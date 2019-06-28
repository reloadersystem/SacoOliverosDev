package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieStore;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mCompendioCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadJSON;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapter_CompendioCiencias extends BaseAdapter {


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

    String sharedata;

    DownloadManager downloadManager;


    private ArrayList<mCompendioCiencias> arrayList;


    public adapter_CompendioCiencias(Context context, ArrayList<mCompendioCiencias> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

        public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

        public static void gradoasiste(String grado)
        {
            cicloespecial= grado;

        }


        public static void tomoCompendioCiencias(String tomowrite)
        {
            tomo= tomowrite;
            tomonumero= (String.valueOf(tomo.charAt(4)));

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


        if(cicloespecial==null)

        {
            sharedata = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");
            cicloespecial = sharedata;

            if (cicloespecial.equalsIgnoreCase("UNI")) {
                cicloespecial = "3";
            } else if (cicloespecial.equalsIgnoreCase("Regular")) {
                cicloespecial = "2";
            } else if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
                cicloespecial = "4";
            }
        }
            else

        {
            if (cicloespecial.equalsIgnoreCase("UNI")) {
                cicloespecial = "3";
            } else if (cicloespecial.equalsIgnoreCase("Regular")) {
                cicloespecial = "2";
            } else if (cicloespecial.equalsIgnoreCase("SAN MARCOS")) {
                cicloespecial = "4";
            }

        }


        
        mPropuestosCiencias item= (mPropuestosCiencias) getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_lstcompendiociencias, null);

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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/FISICA/FISICA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "FÍSICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/FISICA/FISICA2"+nivel+"_CT"+tomonumero+".pdf";

                            ruta = "FISICA2"+nivel+"_CT"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/FISICA/" + ruta);


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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/QUIMICA/QUIMICA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "QUIMICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/QUIMICA/QUIMICA2"+nivel+"_CT"+tomonumero+".pdf";

                            ruta = "QUIMICA2"+nivel+"_CT"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/QUIMICA/" + ruta);


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

                        if(cicloespecial=="3")
                        {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else
                            {
                            if (cd.isConnected()) {



                                String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/BIOLOGIA/BIOLOGIA2"+nivel+"_CT"+tomonumero+".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "BIOLOGIA");
                                context.startActivity(intent);

                            } else {


                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/BIOLOGIA/BIOLOGIA2"+nivel+"_CT"+tomonumero+".pdf";

                                ruta = "BIOLOGIA2"+nivel+"_CT"+tomonumero+".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/BIOLOGIA/" + ruta);


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

                        if (cd.isConnected()) {


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ARITMETICA/ARITMETICA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ARITMÉTICA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ARITMETICA/ARITMETICA2"+nivel+"_CT"+tomonumero+".pdf";


                            ruta = "ARITMETICA2"+nivel+"_CT"+tomonumero+".pdf";



                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ARITMETICA/" + ruta);

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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ALGEBRA/ALGEBRA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ALGEBRA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ALGEBRA/ALGEBRA2"+nivel+"_CT"+tomonumero+".pdf";

                            ruta = "ALGEBRA2"+nivel+"_CT"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ALGEBRA/" + ruta);

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


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/GEOMETRIA/GEOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/GEOMETRIA/GEOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            ruta = "GEOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/GEOMETRIA/" + ruta);

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


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TRIGONOMETRÍA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";


                            ruta = "TRIGONOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/TRIGONOMETRIA/" + ruta);


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


                        if(cicloespecial=="3" || cicloespecial=="4" )
                        {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else
                        {

                            if (cd.isConnected()) {


                                String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2"+nivel+"_CT"+tomonumero+".pdf";

//                            String URL = servidor_ruta+"/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "RAZONAMIENTO MATEMÁTICO");
                                context.startActivity(intent);

                            } else {


                                //String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";
                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2"+nivel+"_CT"+tomonumero+".pdf";

//                            ruta = "Calculo_MentalT"+tomonumero+".pdf";

                                ruta = "RAZONAMIENTO_MATEMATICO2"+nivel+"_CT"+tomonumero+".pdf";

                                //File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/" + ruta);
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/RAZONAMIENTO_MATEMATICO/" + ruta);


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

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/FISICA/FISICA2"+nivel+"_CT"+tomonumero+".pdf";

                            ruta = "FISICA2"+nivel+"_CT"+tomonumero+".pdf";

                            materiadownload= "FISICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);



                                DBwritedownloas();




                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/QUIMICA/QUIMICA2"+nivel+"_CT"+tomonumero+".pdf";
                            ruta = "QUIMICA2"+nivel+"_CT"+tomonumero+".pdf";

                            materiadownload= "QUIMICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;




                    case 2:

                        if(cicloespecial=="3")
                        {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        }
                            else
                        {
                            if (cd.isConnected()) {

                                urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/BIOLOGIA/BIOLOGIA2"+nivel+"_CT"+tomonumero+".pdf";
                                ruta = "BIOLOGIA2"+nivel+"_CT"+tomonumero+".pdf";

                                materiadownload= "BIOLOGIA/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                                } else {


                                    descargarPDF(urlADescargar);

                                    DBwritedownloas();


                                    Log.e("DATOPDF", file0.toString());
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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ARITMETICA/ARITMETICA2"+nivel+"_CT"+tomonumero+".pdf";
                            ruta = "ARITMETICA2"+nivel+"_CT"+tomonumero+".pdf";
                            materiadownload= "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);





                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/ALGEBRA/ALGEBRA2"+nivel+"_CT"+tomonumero+".pdf";
                            ruta = "ALGEBRA2"+nivel+"_CT"+tomonumero+".pdf";

                            materiadownload= "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/GEOMETRIA/GEOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";
                            ruta = "GEOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            materiadownload= "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                    case 6:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/TRIGONOMETRIA/TRIGONOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";
                            ruta = "TRIGONOMETRIA2"+nivel+"_CT"+tomonumero+".pdf";

                            materiadownload= "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);




                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                                DBwritedownloas();


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;




                    case 7:


                        if(cicloespecial=="3" || cicloespecial=="4")
                        {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();

                        } else
                        {
                            if (cd.isConnected()) {
                                // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                                urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2"+nivel+"_CT"+tomonumero+".pdf";
                                ruta = "RAZONAMIENTO_MATEMATICO2"+nivel+"_CT"+tomonumero+".pdf";

                                materiadownload= "RAZONAMIENTO_MATEMATICO/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/" + materiadownload + ruta);



                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                                } else {


                                    descargarPDF(urlADescargar);

                                    DBwritedownloas();


                                    Log.e("DATOPDF", file0.toString());
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

//    private void DownloadJSON() {
//
//        int forjsonurl= urlADescargar.length();
//
//        String urlconstructor= urlADescargar.substring(0,forjsonurl-4);
//
//        String urljsonfinal= urlconstructor+".json";
//
//        downloadManager= (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);
//
//        Uri uri= Uri.parse("http://192.169.218.177/APP/2/3/COMPENDIOS/TOMO1/ALGEBRA/ALGEBRA23_CT1.json");
//
//        DownloadManager.Request request= new DownloadManager.Request(uri);
//        request.setDestinationInExternalFilesDir(context, "/data/user/0/pe.sacooliveros.apptablet/files/APP/","ALGEBRA23_CT1.json");
//        //File AccesoTipo2 = new File(ruta_storage+"/APP/", "dato") ;
////
////                request.setDestinationUri();
//
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
//
//        Long reference = downloadManager.enqueue((request));
//
////
////                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
////                DownloadManager.Request req = new DownloadManager.Request(Uri.parse(urljsonfinal));
////                req.setDestinationUri(Uri.fromFile(AccesoTipo2));
////                req.setTitle("Some title");
//
//    }



    private void DBwritedownloas() {

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "administracion", null,1 );

        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String codigo="9988";
        String file= ruta;
        String ruta= urlADescargar;

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());


        ContentValues registro= new ContentValues();
        registro.put("codigo",codigo);
        registro.put("nombre",file);
        registro.put("ruta",ruta);
        registro.put("fecha",date);

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

                String rutaficheroGuardado = ruta_storage+"/APP/"+cicloespecial+"/"+nivel+"/COMPENDIOS/"+tomo+"/"+materiadownload + ruta;


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


