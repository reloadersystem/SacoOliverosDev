package pe.sacooliveros.apptablet.QuintoSanMarcos;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoSanMarcos.Adapter.adapterMainSM;
import pe.sacooliveros.apptablet.QuintoSanMarcos.Model.mMainSM;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterMainU;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mMainU;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragmentSM extends Fragment {


    View  rootview;

    private GridView gridView;
    ArrayList<mMainSM> Lista;

    String grado;

    ConnectionDetector cd;

    PopupMenu popup;

    static String nivel;
    static String nivelacceso;

    static String gradoasiste;

    String ruta;

    String urlADescargar;

    String  ruta_storage;


    public mainFragmentSM() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_main_sm, container, false);
        
        gridView= rootview.findViewById(R.id.ma_mainSM);

        cd = new ConnectionDetector(getContext());

        if(nivel == null)
        {
            String dato1= obtenerValor(getContext(), "ServerGradoNivel");
            gradoasiste= obtenerValor(getContext(), "TipoGradoAsiste");

            nivelacceso=String.valueOf(dato1.charAt(0));

        }else
        {
            nivelacceso= String.valueOf(nivel.charAt(0));
            gradoasiste= obtenerValor(getContext(), "TipoGradoAsiste");
        }

        Lista= new ArrayList<mMainSM>();

        Lista.add(new mMainSM(R.drawable.secundariamain_1));
        Lista.add(new mMainSM(R.drawable.secundariamain_2));
        Lista.add(new mMainSM(R.drawable.secundariamain_3));
        Lista.add(new mMainSM(R.drawable.secundariamain_7));
        Lista.add(new mMainSM(R.drawable.secundariamain_4));
        Lista.add(new mMainSM(R.drawable.secundariamain_5));
        Lista.add(new mMainSM(R.drawable.secundariamain_9));
        Lista.add(new mMainSM(R.drawable.secundariamain_6));
        Lista.add(new mMainSM(R.drawable.secundariamain_14));




        final adapterMainSM adapter= new adapterMainSM(getContext(), Lista);

        gridView.setAdapter(adapter);


        return  rootview;
    }


    static String  PREFS_KEY= "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return  preferences.getString(keyPref, "");

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


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                ///data/user/0/pe.sacooliveros.apptablet/files/APP/3/5/LECTURAS_MOTIVADORAS

                String rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/3/5/LECTURAS_MOTIVADORAS/" + ruta;

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


        }
    }


}
