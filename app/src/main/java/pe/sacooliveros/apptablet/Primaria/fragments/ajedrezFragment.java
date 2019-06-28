package pe.sacooliveros.apptablet.Primaria.fragments;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.ViewTomo3Activity;
import pe.sacooliveros.apptablet.ViewWebUrlFrag;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Thread.sleep;
import static pe.sacooliveros.apptablet.Primaria.fragments.MainfragPrim.PREFS_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class ajedrezFragment extends Fragment {

    View rootview;

    CardView cardview1, cardview2, cardview3, cardview4;

    String box;

    String nombrepdf;

    ConnectionDetector cd;

    ImageView imgdown_gradorepaso, imgdown_gradochess;

    String urlADescargar;

    String ruta_storage;

    String acceso;

    SharedPreferences shared;

    String grado;

    String numacceso;

    String nivel;

    String rutaficheroGuardado;

    String modif = "";

    String rutasdd;


    String servidor_ruta;

    String sharedata;

    String nombrepdfusuario;

    String nombregrado;

    public ajedrezFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_ajedrez, container, false);

        cardview1 = rootview.findViewById(R.id.crd_repaso);
        cardview2 = rootview.findViewById(R.id.cdr_chessOk);
        cardview3 = rootview.findViewById(R.id.crd_ajedrezpdf);
        cardview4 = rootview.findViewById(R.id.crd_webchess);
        imgdown_gradorepaso = rootview.findViewById(R.id.img_downajedrez);
        imgdown_gradochess = rootview.findViewById(R.id.img_downajedrez2);


        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        sharedata = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        nombregrado = ShareDataRead.obtenerValor(getContext(), "GradoNombre");


        cd = new ConnectionDetector(getContext());

        acceso = obtenerValor(getContext(), "ServerGradoNivel");        //5 Secundaria
        nivel = obtenerValor(getContext(), "Acceso");        //Secundaria

        grado = (String.valueOf(acceso.charAt(0))); //5


        if (nivel.equalsIgnoreCase("Secundaria")) {
            numacceso = "2";

        } else if (nivel.equalsIgnoreCase("Primaria")) {
            numacceso = "1";
        }


        shared = getContext().getSharedPreferences("autenticacionOff", MODE_PRIVATE);

        imgdown_gradorepaso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cd.isConnected()) {


                    urlADescargar = servidor_ruta + "/APP/ajedrezrepaso.pdf";
                    modif = "1";
                    nombrepdf = "ajedrezrepaso.pdf";


                    File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + nombrepdf);


                    if (file0.exists()) {
                        Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();


                    } else {


                        descargarPDF(urlADescargar);
//                        descargarPDF(urlADescargar);

                        String nombrepdfusuario = "AJEDREZ - REPASO";
                        String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/ajedrezrepaso.pdf";
                        String rutaurldata = servidor_ruta + "/APP/ajedrezrepaso.pdf";
                        DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, rutaurldata, "true");
                    }
                } else

                {


                    Toast.makeText(getContext(), " Sin Conexión", Toast.LENGTH_SHORT).show();
                }


            }
        });


        imgdown_gradochess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cd.isConnected()) {

                    if (nivel.equalsIgnoreCase("Primaria")) {

                        //http://192.169.218.177/APP/1/5/AJEDREZ/Ajedrez_5.pdf
                        //http://192.169.218.177/APP/1/6/AJEDREZ/Ajedrez_5.pdf

                        urlADescargar = "http://tablet.sacooliveros.edu.pe/APP/" + numacceso + "/" + grado + "/LIBROS/TOMO1/AJEDREZ/ajedrez5_T1.pdf";

                        nombrepdf = "ajedrez5_T1.pdf";

                        modif = "2";

                        File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/" + nombrepdf);


                        if (file0.exists()) {
                            Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();

                        } else {


                            descargarPDF(urlADescargar);

                            //if (descarga == exito)

                            nombrepdf = "ajedrez5_T1.pdf";

                            if (grado.equalsIgnoreCase("5")) {
                                nombrepdfusuario = " Ajedrez 5º Grado";
                            } else if (grado.equalsIgnoreCase("6")) {
                                nombrepdfusuario = " Ajedrez 6º Grado";
                            }

                            rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/" + nombrepdf;


                            String rutaurldata = "http://tablet.sacooliveros.edu.pe/APP/" + numacceso + "/" + grado + "/LIBROS/TOMO1/AJEDREZ/ajedrez5_T1.pdf";


                            DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, rutaurldata, "true");

                        }
                    }


                    if (nivel.equalsIgnoreCase("Secundaria")) {

                        urlADescargar = servidor_ruta + "/APP/" + numacceso + "/" + grado + "/AJEDREZ/AJEDREZ" + numacceso + grado + ".pdf";
                        nombrepdf = "AJEDREZ" + numacceso + grado + ".pdf";

                        if (sharedata.equalsIgnoreCase("UNI")) {
                            numacceso = "3";
                        }

                        if (sharedata.equalsIgnoreCase("SAN MARCOS")) {
                            numacceso = "4";
                        }

                        if (sharedata.equalsIgnoreCase("CATOLICa")) {
                            numacceso = "5";
                        }

                        if (sharedata.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")) {
                            numacceso = "6";
                            nombrepdf = "AJEDREZ25.pdf";
                        }

                        modif = "2";


                        File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/" + nombrepdf);


                        if (file0.exists()) {
                            Toast.makeText(getContext(), "Archivo Existente", Toast.LENGTH_SHORT).show();


                        } else {


                            descargarPDF(urlADescargar);


                            if (sharedata.equalsIgnoreCase("UNI")) {
                                String nombrepdfusuario = "Ajedrez - POR GRADO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/3/" + grado + "/AJEDREZ/AJEDREZ25.pdf";
                                DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, urlADescargar, "true");
                            } else if (sharedata.equalsIgnoreCase("SAN MARCOS")) {
                                String nombrepdfusuario = "Ajedrez - POR GRADO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/4/" + grado + "/AJEDREZ/AJEDREZ25.pdf";
                                DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, urlADescargar, "true");
                            } else if (sharedata.equalsIgnoreCase("CATOLICA")) {
                                String nombrepdfusuario = "Ajedrez - POR GRADO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/5/" + grado + "/AJEDREZ/AJEDREZ25.pdf";
                                DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, urlADescargar, "true");
                            } else if (sharedata.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")) {
                                String nombrepdfusuario = "Ajedrez - POR GRADO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/6/" + grado + "/AJEDREZ/AJEDREZ25.pdf";
                                DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, urlADescargar, "true");
                            } else {
                                String nombrepdfusuario = "Ajedrez - POR GRADO";
                                if(nombregrado.equalsIgnoreCase("Cuarto Grado"))
                                {
                                    numacceso="2";
                                }
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/AJEDREZ" + numacceso + grado + ".pdf";
                                DownloadListWrite.WriteDownloads(getContext(), nombrepdfusuario, rutasdd, urlADescargar, "true");
                            }


                        }
                    }
                }


            }
        });


        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cd = new ConnectionDetector(getContext());

                {

                    if (cd.isConnected()) {

                        String URL = servidor_ruta + "/APP/ajedrezrepaso.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "Ajedrez Repaso");
                        startActivity(intent);

                    } else {


                        String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/ajedrezrepaso.pdf";

                        nombrepdf = "ajedrezrepaso.pdf";

                        File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + nombrepdf);


                        if (file0.exists())

                        {

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "storage");
                            intent.putExtra("SSDFILE", ssdFile);
                            intent.putExtra("Materia", "Ajedrez Repaso");
                            intent.putExtra("EstadoConexion", "SinConexion");
                            startActivity(intent);

                            Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();


                        }

                    }

                }

            }
        });


        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appName = "Gmail";
                String packageName = "com.convekta.android.chessplanet&hl=es";

                box = "com.convekta.android.chessplanet&hl=es";

                openApp(getContext(), appName, packageName);


            }
        });


        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cd = new ConnectionDetector(getContext());


                if (cd.isConnected()) {

                    if (nivel.equalsIgnoreCase("Primaria"))

                    {

                        String URL = "http://192.169.218.177/APP/1/" + grado + "/LIBROS/TOMO1/AJEDREZ/ajedrez5_T1.pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "Ajedrez");
                        startActivity(intent);

                    } else if (nivel.equalsIgnoreCase("Secundaria")) {

                        String URL = "http://192.169.218.177/APP/" + numacceso + "/" + grado + "/AJEDREZ/AJEDREZ" + numacceso + grado + ".pdf";

                        Intent intent = new Intent(getContext(), ViewTomo3Activity.class);
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", "Ajedrez");
                        startActivity(intent);

                    }

                } else

                {
                    if (nivel.equalsIgnoreCase("Primaria"))

                    {

                        String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + grado + "/AJEDREZ/ajedrez5_T1.pdf";

                        File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + grado + "/AJEDREZ/ajedrez5_T1.pdf");

                        String nombrepdf = "Ajedrez " + grado + "º Grado";


                        if (file0.exists())

                        {

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "storage");
                            intent.putExtra("SSDFILE", ssdFile);
                            intent.putExtra("Materia", nombrepdf);
                            intent.putExtra("EstadoConexion", "SinConexion");
                            startActivity(intent);

                            Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                        }
                    }

                    if (nivel.equalsIgnoreCase("Secundaria"))

                    {

                        String ssdFile = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/AJEDREZ" + numacceso + grado + ".pdf";

                        File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/AJEDREZ" + numacceso + grado + ".pdf");

                        String nombrepdf = "Ajedrez Por Grado";


                        if (file0.exists())

                        {

                            Intent intent = new Intent(getContext(), ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "storage");
                            intent.putExtra("SSDFILE", ssdFile);
                            intent.putExtra("Materia", nombrepdf);
                            intent.putExtra("EstadoConexion", "SinConexion");
                            startActivity(intent);

                            Toast.makeText(getContext(), " Vista Sin Conexion", Toast.LENGTH_SHORT).show();


                        } else {
                            Toast.makeText(getContext(), "No descargaste el archivo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

        });


        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cd = new ConnectionDetector(getContext());


                if (cd.isConnected()) {

                    String urlgame = "https://lichess.org/";

                    Fragment fragment2 = new ViewWebUrlFrag();
                    FragmentManager fmanager = getActivity().getSupportFragmentManager();
                    if (fmanager != null) {

                        Bundle args = new Bundle();
                        args.putString("UrlDescription", urlgame);

                        fragment2.setArguments(args);

                        //String dato6= obtenerValor(getContext(), "Acceso");

                        acceso = obtenerValor(getContext(), "Acceso");

                        shared = getContext().getSharedPreferences("autenticacionOff", MODE_PRIVATE);


                        if (shared.contains("Acceso")) {

                            if (acceso.equalsIgnoreCase("Primaria")) {

                                FragmentTransaction ftransaction = fmanager.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorprimaria, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }


                            }
                            if (acceso.equalsIgnoreCase("Secundaria"))

                            {
                                FragmentTransaction ftransaction = fmanager.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                        }

                    }

                } else
                    Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();


            }


        });


        return rootview;
    }


    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(getContext());
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

            ruta_storage = getContext().getString(R.string.ruta_raiz);
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


                //"/data/user/0/pe.sacooliveros.apptablet/files/APP/2/1/" + ruta);
                //"/data/user/0/pe.sacooliveros.apptablet/files/APP/"+numacceso+"/"+grado+"/"+ ruta);

                //http://192.169.218.177/APP/1/5/AJEDREZ/Ajedrez_5.pdf
                //http://192.169.218.177/APP/1/6/AJEDREZ/Ajedrez_5.pdf

                if (modif.equalsIgnoreCase("1")) {

                    rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + nombrepdf;

                } else if (modif.equalsIgnoreCase("2")) {

                    rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + numacceso + "/" + grado + "/AJEDREZ/" + nombrepdf;
                }


                //String rutaficheroGuardado =  "/data/user/0/pe.sacooliveros.apptablet/files/APP/"+numacceso+"/"+grado+"/AJEDREZ/"+ ruta;

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


            Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

            //Tiempo estimado
        }
    }


    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            // We found the activity now start the activity
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            context.startActivity(intent);
        }
    }


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getContext(), box);


        //else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
    }

    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return false;
    }

    private static boolean isAppEnabled(Context context, String packageName) {
        boolean appStatus = false;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(packageName, 0);
            if (ai != null) {
                appStatus = ai.enabled;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appStatus;
    }


    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }

}
