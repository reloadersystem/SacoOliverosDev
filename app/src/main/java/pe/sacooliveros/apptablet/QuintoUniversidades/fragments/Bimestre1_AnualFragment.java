package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

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
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAnualExamen;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterLecturaBimestre;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mAnualExamen;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre1_AnualFragment extends Fragment {

    View rootview;
    ArrayList<mAnualExamen> Lista;

    ImageView img_temas;
    private GridView gridView;
    ConnectionDetector cd;
    String servidor_ruta;
    String ruta;
    String urlADescargar;
    String ruta_storage;
    String tipogrado;
    String ciclo;

    public Bimestre1_AnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_bimestre1__anual, container, false);

        img_temas = rootview.findViewById(R.id.img_backanual);
        gridView = rootview.findViewById(R.id.ma_listanual);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
//                Fragment fragment2 = new mainFragmentUni();
//                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                if (fmanager2 != null) {
//                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                    if (ftransaction != null) {
//                        ftransaction.replace(R.id.contenedorFragments, fragment2);
//                        ftransaction.addToBackStack("");
//                        ftransaction.commit();
//                    }
//                }

                getActivity().getSupportFragmentManager().popBackStack();
            }

        });


        Lista = new ArrayList<mAnualExamen>();

        tipogrado = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        if (tipogrado.equalsIgnoreCase("UNI")) {
            ciclo = "3";
            Lista.add(new mAnualExamen(R.drawable.admisionanual_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionanual_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionanual_3, R.drawable.ic_file_download_black_24dp));
        } else if (tipogrado.equalsIgnoreCase("SAN MARCOS")) {
            ciclo = "4";
            Lista.add(new mAnualExamen(R.drawable.admisionsm_01, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionsm_02, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionsm_03, R.drawable.ic_file_download_black_24dp));

        } else if (tipogrado.equalsIgnoreCase("CATOLICA")) {
            ciclo = "5";
            Lista.add(new mAnualExamen(R.drawable.admisioncatolica_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisioncatolica_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisioncatolica_3, R.drawable.ic_file_download_black_24dp));

        } else if (tipogrado.equalsIgnoreCase("PRE")) {
            ciclo = "6";
            Lista.add(new mAnualExamen(R.drawable.admisionpre_2, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionpre_1, R.drawable.ic_file_download_black_24dp));
            Lista.add(new mAnualExamen(R.drawable.admisionpre_3, R.drawable.ic_file_download_black_24dp));

        }

        servidor_ruta = getContext().getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(getContext());


        final adapterAnualExamen adapter = new adapterAnualExamen(getContext(), Lista);

        gridView.setAdapter(adapter);

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


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                String rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + ciclo + "/5/EXADM_ANUAL/BIMESTRE1/" + ruta;

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
