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
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosLetras;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

import static java.lang.Thread.sleep;

public class adapter_proletras extends BaseAdapter {

    private Context context;

    private ArrayList<mPropuestosLetras> arrayList;


    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    String ruta;
    static String mes;
    static String mesnumero;
    static String nivel;
    String grado;

    String servidor_ruta;


    public adapter_proletras(Context context, ArrayList<mPropuestosLetras> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }


    public static void mesletras(String meswrite) {
//        mes= meswrite;
//        mesnumero= (String.valueOf(mes.charAt(3)));

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


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_listletras, null);

        }


        ImageView imgfoto = convertView.findViewById(R.id.img_proletrasitem);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_proletraspdf);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getImagen_logo2());


        servidor_ruta = context.getString(R.string.servidor_ruta);


        cd = new ConnectionDetector(context);

        String gradopre = ShareDataRead.obtenerValor(context, "TipoGradoAsiste");
        String nivelpre = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);
        grado = ShareDataRead.obtenerValor(context, "ServerGradoNivel");

        if (nivel == null) {
            nivel = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);
        }

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:

                        if (cd.isConnected()) {

                            //1 es Primer Grado

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LENGUAJE");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LENGUAJE/" + ruta);


                            if (file0.exists()) {

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


                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/PROBLEMAS_PROPUESTOS/MES1/LITERATURA/LITERATURA2"+nivel+"_PPM1.pdf

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LITERATURA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LITERATURA/" + ruta);


                            if (file0.exists()) {

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

                        if (cd.isConnected()) {

                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/PROBLEMAS_PROPUESTOS/MES1/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2"+nivel+"_PPM1.pdf


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/" + ruta);

                            if (file0.exists()) {

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

                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA DEL PERÚ");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";


                            ruta = "HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/" + ruta);

                            if (file0.exists()) {

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

                            //http://app8.sacooliveros.edu.pe/APP/2/2/PROBLEMAS_PROPUESTOS/MES1/GEOGRAFIA/GEOGRAFIA22_PPM1.pdf


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            Intent intent = new Intent(context, ViewTomo3Activity.class);
                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOGRAFIA");
                            context.startActivity(intent);

                        } else {


                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOGRAFIA/" + ruta);


                            if (file0.exists()) {


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

                        if (grado.equalsIgnoreCase("1 Secundaria") || grado.equalsIgnoreCase("2 Secundaria") || grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {
                            if (cd.isConnected()) {

                                String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "INGLES");
                                context.startActivity(intent);

                            } else {

                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";

                                ruta = "INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/INGLES/" + ruta);

                                if (file0.exists()) {
                                    Intent intent = new Intent(context, ViewTomo3Activity.class);
                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "INGLES");
                                    intent.putExtra("EstadoConexion", "SinConexion");
                                    context.startActivity(intent);

                                    Toast.makeText(context, " Vista Sin Conexion", Toast.LENGTH_SHORT).show();
                                    break;

                                } else {
                                    Toast.makeText(context, "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                                    break;

                                }
                            }
                        } else {
                            if (cd.isConnected()) {

                                String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "HISTORIA UNIVERSAL");
                                context.startActivity(intent);

                            } else {


                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                ruta = "HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/" + ruta);

                                if (file0.exists()) {


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

                        }

                        break;


                    case 6:

                        if (grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {

                            if (cd.isConnected()) {

                                String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "HISTORIA UNIVERSAL");
                                context.startActivity(intent);

                            } else {


                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                ruta = "HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/" + ruta);

                                if (file0.exists()) {


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

                        } else {
                            if (cd.isConnected()) {
                                String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "ECONOMIA");
                                context.startActivity(intent);

                            } else {

                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                ruta = "ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/" + ruta);


                                if (file0.exists()) {

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);
                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "ECONOMIA");
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


                    case 7:
                        if (grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {

                            {
                                if (cd.isConnected()) {

                                    String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);
                                    intent.putExtra("ViewType", "internet");
                                    intent.putExtra("URL", URL);
                                    intent.putExtra("Materia", "ECONOMIA");
                                    context.startActivity(intent);

                                } else {

                                    String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    ruta = "ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/" + ruta);

                                    if (file0.exists()) {


                                        Intent intent = new Intent(context, ViewTomo3Activity.class);
                                        intent.putExtra("ViewType", "storage");
                                        intent.putExtra("SSDFILE", ssdFile);
                                        intent.putExtra("Materia", "ECONOMIA");
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

                        } else {
                            if (cd.isConnected()) {

                                String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "PSICOLOGIA");
                                context.startActivity(intent);

                            } else {

                                String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/" + ruta);
                                if (file0.exists()) {
                                    Intent intent = new Intent(context, ViewTomo3Activity.class);
                                    intent.putExtra("ViewType", "storage");
                                    intent.putExtra("SSDFILE", ssdFile);
                                    intent.putExtra("Materia", "PSICOLOGIA");
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


                    case 8:

                        if (cd.isConnected()) {


                            String URL = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PSICOLOGIA");
                            context.startActivity(intent);

                        } else {

                            String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/" + ruta);

                            if (file0.exists()) {
                                Intent intent = new Intent(context, ViewTomo3Activity.class);
                                intent.putExtra("ViewType", "storage");
                                intent.putExtra("SSDFILE", ssdFile);
                                intent.putExtra("Materia", "PSICOLOGIA");
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

                            //http://app8.sacooliveros.edu.pe/APP/2/"+nivel+"/PROBLEMAS_PROPUESTOS/MES"+mesnumero+"/LENGUAJE/LENGUAJE22_PPM"+mesnumero+".pdf";

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "LENGUAJE/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {

                                descargarPDF(urlADescargar);
                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - LENGUAJE";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 1:

                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "LITERATURA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {
                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - LITERATURA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 2:

                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                            ruta = "RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "RAZONAMIENTO_VERBAL/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - RAZONAMIENTO VERBAL";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 3:

                        if (cd.isConnected()) {
                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "HISTORIA_DEL_PERU/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {
                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - HISTORIA DEL PERU ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 4:

                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "GEOGRAFIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {


                                descargarPDF(urlADescargar);

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - GEOGRAFIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;

                    case 5:

                        if (cd.isConnected()) {

                            if (grado.equalsIgnoreCase("1 Secundaria") || grado.equalsIgnoreCase("2 Secundaria") || grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {

                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "INGLES/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                                } else {
                                    descargarPDF(urlADescargar);
                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - INGLES";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                                }

                            } else {

                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "HISTORIA_UNIVERSAL/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                                } else {
                                    descargarPDF(urlADescargar);

                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - HISTORIA UNIVERSAL";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                                }

                            }

                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 6:

                        if (cd.isConnected()) {

                            if (grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {

                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "HISTORIA_UNIVERSAL/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                                } else {
                                    descargarPDF(urlADescargar);
                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - HISTORIA UNIVERSAL";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                                }
                            } else {
                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "ECONOMIA/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                                } else {

                                    descargarPDF(urlADescargar);

                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - ECONOMIA";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                                }
                            }
                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 7:
                        if (cd.isConnected()) {

                            if (grado.equalsIgnoreCase("3 Secundaria") || grado.equalsIgnoreCase("4 Secundaria")) {

                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "ECONOMIA/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                                } else {
                                    descargarPDF(urlADescargar);

                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - ECONOMIA";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                                }
                            } else {
                                urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                ruta = "PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                                materiadownload = "PSICOLOGIA/";
                                File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);

                                if (file0.exists()) {
                                    Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();
                                } else {
                                    descargarPDF(urlADescargar);

                                    String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - PSICOLOGIA";
                                    String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                    DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");
                                }
                            }

                        } else {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 8: {
                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                            ruta = "PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";

                            materiadownload = "PSICOLOGIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/" + materiadownload + ruta);


                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();


                            } else {

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "Problemas Propuestos - MES " + mesnumero + " - PSICOLOGIA";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_PROPUESTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PPM" + mesnumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, urlADescargar, "true");

                            }
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


