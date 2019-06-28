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
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoComputacion;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapterComputacion extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoComputacion> arrayList;
    ConnectionDetector cd;


    String ruta;

    String urlADescargar;

    String ruta_storage;


    String positiontomo;

    static String nivel;

    String servidor_ruta;


    public adapterComputacion(Context context, ArrayList<mTomoComputacion> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_computacion, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_initlist);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_computaciondown);


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


                            positiontomo = String.valueOf(position + 1);


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 1");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T1.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/" + ruta);

                            if (file0.exists())

                            {

                                // String desc = estado.getText().toString();

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 1");
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

                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            positiontomo = String.valueOf(position + 1);


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";


                            //   String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 2");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T2.pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/" + ruta);


                            if (file0.exists())

                            {

                                // String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 2");
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

                            positiontomo = String.valueOf(position + 1);

                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";


                            //  String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 3");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T3.pdf";


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/" + ruta);


                            if (file0.exists())

                            {

                                //   String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 3");
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


                            positiontomo = String.valueOf(position + 1);


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";


                            //   String desc = estado.getText().toString();


                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TOMO 4");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";

                            ruta = "COMPUTACION2" + nivel + "_T4.pdf";

//
//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/" + ruta);

                            if (file0.exists())

                            {

                                //   String desc = estado.getText().toString();


                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "TOMO 4");
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


//                    case 4:
//
//                        if (cd.isConnected()) {
//
//
//                            positiontomo = String.valueOf(position + 1);
//
//
//                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO5/COMPUTACION2" + nivel + "_T5.pdf";
//
//
//                            //  String desc = estado.getText().toString();
//
//
//                            Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                            intent.putExtra("ViewType", "internet");
//                            intent.putExtra("URL", URL);
//                            intent.putExtra("Materia", "TOMO 5");
//                            context.startActivity(intent);
//
//                        } else {
//
//
//                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO5/COMPUTACION2" + nivel + "_T5.pdf";
//
//                            ruta = "COMPUTACION2" + nivel + "_T5.pdf";
//
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO5/" + ruta);
//
//
//                            if (file0.exists())
//
//                            {
//
//                                //    String desc = estado.getText().toString();
//
//
//                                Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                                intent.putExtra("ViewType", "storage");
//                                intent.putExtra("SSDFILE", ssdFile);
//                                intent.putExtra("Materia", "TOMO 5");
//                                intent.putExtra("EstadoConexion", "SinConexion");
//                                context.startActivity(intent);
//
//                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            } else {
//                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            }
//
//                        }
//
//
//                        break;
//
//
//                    case 5:
//
//                        if (cd.isConnected()) {
//
//                            positiontomo = String.valueOf(position + 1);
//
//
//                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO6/COMPUTACION2" + nivel + "_T6.pdf";
//
//
//                            //  String desc = estado.getText().toString();
//
//
//                            Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                            intent.putExtra("ViewType", "internet");
//                            intent.putExtra("URL", URL);
//                            intent.putExtra("Materia", "TOMO 6");
//                            context.startActivity(intent);
//
//                        } else {
//
//
//                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO6/COMPUTACION2" + nivel + "_T6.pdf";
//
//                            ruta = "COMPUTACION2" + nivel + "_T6.pdf";
//
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO6/" + ruta);
//
//
//                            if (file0.exists())
//
//                            {
//
//                                //    String desc = estado.getText().toString();
//
//
//                                Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                                intent.putExtra("ViewType", "storage");
//                                intent.putExtra("SSDFILE", ssdFile);
//                                intent.putExtra("Materia", "TOMO 6");
//                                intent.putExtra("EstadoConexion", "SinConexion");
//                                context.startActivity(intent);
//
//                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            } else {
//                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            }
//
//                        }
//
//
//                        break;
//
//
//                    case 6:
//
//
//                        if (cd.isConnected()) {
//
//                            positiontomo = String.valueOf(position + 1);
//
//
//                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO7/COMPUTACION2" + nivel + "_T7.pdf";
//
//
//                            //  String desc = estado.getText().toString();
//
//
//                            Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                            intent.putExtra("ViewType", "internet");
//                            intent.putExtra("URL", URL);
//                            intent.putExtra("Materia", "TOMO 7");
//                            context.startActivity(intent);
//
//                        } else {
//
//
//                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO7/COMPUTACION2" + nivel + "_T7.pdf";
//
//                            ruta = "COMPUTACION2" + nivel + "_T7.pdf";
//
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO7/" + ruta);
//
//
//                            if (file0.exists())
//
//                            {
//
//                                //    String desc = estado.getText().toString();
//
//
//                                Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                                intent.putExtra("ViewType", "storage");
//                                intent.putExtra("SSDFILE", ssdFile);
//                                intent.putExtra("Materia", "TOMO 7");
//                                intent.putExtra("EstadoConexion", "SinConexion");
//                                context.startActivity(intent);
//
//                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            } else {
//                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            }
//
//                        }
//
//
//                        break;
//
//
//                    case 7:
//
//                        if (cd.isConnected()) {
//
//                            positiontomo = String.valueOf(position + 1);
//                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO8/COMPUTACION2"+nivel+"_T8.pdf
//
//                            String URL = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO8/COMPUTACION2" + nivel + "_T8.pdf";
//
//
//                            //  String desc = estado.getText().toString();
//
//
//                            Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                            intent.putExtra("ViewType", "internet");
//                            intent.putExtra("URL", URL);
//                            intent.putExtra("Materia", "TOMO 8");
//                            context.startActivity(intent);
//
//                        } else {
//
//
//                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO8/COMPUTACION2" + nivel + "_T8.pdf";
//
//                            ruta = "COMPUTACION2" + nivel + "_T8.pdf";
//
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO8/" + ruta);
//
//
//                            if (file0.exists())
//
//                            {
//
//                                //    String desc = estado.getText().toString();
//
//
//                                Intent intent = new Intent(context, ViewTomo3Activity.class);
//
//                                intent.putExtra("ViewType", "storage");
//                                intent.putExtra("SSDFILE", ssdFile);
//                                intent.putExtra("Materia", "TOMO 8");
//                                intent.putExtra("EstadoConexion", "SinConexion");
//                                context.startActivity(intent);
//
//                                Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            } else {
//                                Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
//                                break;
//
//                            }
//
//                        }
//
//
//                        break;
//
                }

           }
        });


        imgfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                switch (position) {
                    case 0:


                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T1.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO 1";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO1/COMPUTACION2" + nivel + "_T1.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T2.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO 2";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO2/COMPUTACION2" + nivel + "_T2.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");


                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:


                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T3.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO3";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO3/COMPUTACION2" + nivel + "_T3.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {


                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;

                    case 3:


                        if (cd.isConnected()) {


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";
                            ruta = "COMPUTACION2" + nivel + "_T4.pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/" + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                positiontomo = String.valueOf(position + 1);

                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "Computación - TOMO4";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO4/COMPUTACION2" + nivel + "_T4.pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


//                    case 4:
//
//
//                        if (cd.isConnected()) {
//
//
//                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf
//
//                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO5/COMPUTACION2" + nivel + "_T5.pdf";
//                            ruta = "COMPUTACION2" + nivel + "_T5.pdf";
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO5/" + ruta);
//
//
//                            if (file0.exists()) {
//                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
//
//
//                            } else {
//                                positiontomo = String.valueOf(position + 1);
//
//                                descargarPDF(urlADescargar);
//
//                                //DBwritedownloas();
//
//                                String nombrepdfusuario = "Computación - TOMO5";
//                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO5/COMPUTACION2" + nivel + "_T5.pdf";
//                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
//
//
//                            }
//                        } else
//
//                        {
//
//
//                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        break;
//
//
//                    case 5:
//
//
//                        if (cd.isConnected()) {
//
//
//                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO2/COMPUTACION2"+nivel+"_T2.pdf
//
//                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO6/COMPUTACION2" + nivel + "_T6.pdf";
//                            ruta = "COMPUTACION2" + nivel + "_T6.pdf";
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO6/" + ruta);
//
//
//                            if (file0.exists()) {
//                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
//
//
//                            } else {
//                                positiontomo = String.valueOf(position + 1);
//
//                                descargarPDF(urlADescargar);
//
//                                //DBwritedownloas();
//
//                                String nombrepdfusuario = "Computación - TOMO6";
//                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO6/COMPUTACION2" + nivel + "_T6.pdf";
//                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
//
//                            }
//                        } else
//
//                        {
//
//
//                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        break;
//
//
//                    case 6:
//
//
//                        if (cd.isConnected()) {
//
//
//                            http:
////app8.sacooliveros.edu.pe/APP/2/"+nivel+"/COMPUTACION/TOMO7/COMPUTACION2"+nivel+"_T7.pdf
//
//                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO7/COMPUTACION2" + nivel + "_T7.pdf";
//                            ruta = "COMPUTACION2" + nivel + "_T7.pdf";
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO7/" + ruta);
//
//
//                            if (file0.exists()) {
//                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
//
//
//                            } else {
//                                positiontomo = String.valueOf(position + 1);
//
//                                descargarPDF(urlADescargar);
//
//                                // DBwritedownloas();
//
//                                String nombrepdfusuario = "Computación - TOMO 7";
//                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO7/COMPUTACION2" + nivel + "_T7.pdf";
//                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
//
//                            }
//                        } else
//
//                        {
//
//
//                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        break;
//
//
//                    case 7:
//
//                        if (cd.isConnected()) {
//
//                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/COMPUTACION/TOMO8/COMPUTACION2" + nivel + "_T8.pdf";
//                            ruta = "COMPUTACION2" + nivel + "_T8.pdf";
//
//                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO8/" + ruta);
//
//
//                            if (file0.exists()) {
//                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
//
//
//                            } else {
//
//                                positiontomo = String.valueOf(position + 1);
//
//                                descargarPDF(urlADescargar);
//
//                                //DBwritedownloas();
//
//                                String nombrepdfusuario = "Computación - TOMO 8";
//                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/COMPUTACION/TOMO8/COMPUTACION2" + nivel + "_T8.pdf";
//                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
//
//                            }
//                        } else
//
//                        {
//
//
//                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
//                        }
//
//
//                        break;
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

                String rutaficheroGuardado = ruta_storage + "/APP/2/" + nivel + "/COMPUTACION/TOMO" + positiontomo + "/" + ruta;

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
