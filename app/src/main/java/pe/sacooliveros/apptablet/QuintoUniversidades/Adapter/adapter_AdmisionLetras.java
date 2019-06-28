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
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAdmisionLetras;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;
import static java.lang.Thread.sleep;

public class adapter_AdmisionLetras extends BaseAdapter {


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
    private ArrayList<mAdmisionLetras> arrayList;

    public adapter_AdmisionLetras(Context context, ArrayList<mAdmisionLetras> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void tomoAdmisionLetras(String tomowrite)
    {
        tomo= tomowrite;
        tomonumero= (String.valueOf(tomo.charAt(4))); //TOMO1

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

            convertView = LayoutInflater.from(context).inflate(R.layout.item_lstadmisionletras, null);

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

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LENGUAJE/LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LENGUAJE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LENGUAJE/LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LENGUAJE/" + ruta);


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

                        //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/LITERATURA/LITERATURA"+ cicloespecial +"_T1.pdf

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LITERATURA/LITERATURA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LITERATURA");
                            context.startActivity(intent);

                        } else {

                            //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/LITERATURA/LITERATURA"+ cicloespecial +"_T1.pdf


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LITERATURA/LITERATURA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "LITERATURA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LITERATURA/" + ruta);


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


                        //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL"+ cicloespecial +"_T1.pdf


                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "RAZONAMIENTO_VERBAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/RAZONAMIENTO_VERBAL/" + ruta);


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


                            //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU"+ cicloespecial +"_T1.pdf

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA DEL PERÚ");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU"+ cicloespecial +"_T"+tomonumero+".pdf";


                            ruta = "HISTORIA_DEL_PERU"+ cicloespecial +"_T"+tomonumero+".pdf";



                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_DEL_PERU/" + ruta);

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
                        //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/GEOGRAFIA/GEOGRAFIA"+ cicloespecial +"_T1.pdf

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOGRAFIA/GEOGRAFIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOGRAFIA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOGRAFIA/GEOGRAFIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "GEOGRAFIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOGRAFIA/" + ruta);

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

                            //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL"+ cicloespecial +"_T1.pdf
                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA UNIVERSAL");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "HISTORIA_UNIVERSAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_UNIVERSAL/" + ruta);

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


                            //hhttp://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/ECONOMIA/ECONOMIA"+ cicloespecial +"_T1.pdf


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ECONOMIA/ECONOMIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ECONOMÍA");
                            context.startActivity(intent);

                        } else {


                            //String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/"+accesodato+"/LIBROS/"+tomo+"/MATEMATICA/CALCULO_MENTAL/Calculo_MentalT"+tomonumero+".pdf";
                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ECONOMIA/ECONOMIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "ECONOMIA"+ cicloespecial +"_T"+tomonumero+".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ECONOMIA/" + ruta);


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

                            //http://192.169.218.177/APP/3/5/PEADM_CAP/TOMO1/PSICOLOGIA/PSICOLOGIA"+ cicloespecial +"_T1.pdf

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/PSICOLOGIA/PSICOLOGIA"+ cicloespecial +"_T"+tomonumero+".pdf";



                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PSICOLOGIA");
                            context.startActivity(intent);

                        } else {



                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/PSICOLOGIA/PSICOLOGIA"+ cicloespecial +"_T"+tomonumero+".pdf";



                            ruta = "PSICOLOGIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/PSICOLOGIA/" + ruta);



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


                }
            }


        });


        imgfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {

                    case 0:


                        if (cd.isConnected()) {

                            //servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LENGUAJE/LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LENGUAJE/LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            ruta = "LENGUAJE"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "LENGUAJE/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                              DownloadListWrite.WriteDownloads(context, ruta, urlADescargar," ", " ");


                                Log.e("DATOPDF", file0.toString());
                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;



                    case 1:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/LITERATURA/LITERATURA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "LITERATURA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "LITERATURA/";
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




                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL"+ cicloespecial +"_T"+tomonumero+".pdf";


                            ruta = "RAZONAMIENTO_VERBAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "RAZONAMIENTO_VERBAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {


                                descargarPDF(urlADescargar);

                              DownloadListWrite.WriteDownloads(context, ruta, urlADescargar, " ",  " " );


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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "HISTORIA_DEL_PERU"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "HISTORIA_DEL_PERU/";
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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/GEOGRAFIA/GEOGRAFIA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "GEOGRAFIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "GEOGRAFIA/";
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


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "HISTORIA_UNIVERSAL"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "HISTORIA_UNIVERSAL/";
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

                    case 6:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/ECONOMIA/ECONOMIA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "ECONOMIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "ECONOMIA/";
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




                    case 7:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta+"/APP/"+cicloespecial+"/"+nivel+"/PEADM_CAP/"+tomo+"/PSICOLOGIA/PSICOLOGIA"+ cicloespecial +"_T"+tomonumero+".pdf";
                            ruta = "PSICOLOGIA"+ cicloespecial +"_T"+tomonumero+".pdf";

                            materiadownload= "PSICOLOGIA/";
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
