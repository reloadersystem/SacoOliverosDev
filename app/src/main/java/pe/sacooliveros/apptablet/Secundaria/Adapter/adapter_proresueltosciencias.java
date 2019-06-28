package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mPresueltosCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.GeneralFileManager;

import static java.lang.Thread.sleep;

public class adapter_proresueltosciencias extends BaseAdapter {

    private Context context;
    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;

    String ruta;

    static String mes;

    static String mesnumero;

    static String nivel;

    private ArrayList<mPresueltosCiencias> arrayList;

    String servidor_ruta;


    public adapter_proresueltosciencias(Context context, ArrayList<mPresueltosCiencias> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static void mescienciasresueltos(String meswrite) {
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
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        mPropuestosCiencias item = (mPropuestosCiencias) getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_resueltoslistciencias, null);

        }

        final GeneralFileManager fileManager = new GeneralFileManager(context);

        ImageView imgfoto = convertView.findViewById(R.id.img_presueltosciencia);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_downloadpresueltos);

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
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PRM" + mesnumero + ".pdf", "FÍSICA");
                        break;

                    case 1:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PRM" + mesnumero + ".pdf", "QUIMICA");
                        break;

                    case 2:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf", "BIOLOGÍA");
                        break;

                    case 3:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PRM" + mesnumero + ".pdf", "ARITMÉTICA");
                        break;

                    case 4:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PRM" + mesnumero + ".pdf", "ALGEBRA");
                        break;

                    case 5:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf", "GEOMETRÍA");
                        break;

                    case 6:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf", "TRIGONOMETRÍA");

                        break;
                    case 7:

                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PRM" + mesnumero + ".pdf", "RAZONAMIENTO MATEMÁTICO");

                        break;
                }
            }
        });


        imgfoto2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {

                switch (position) {

                    case 0:


                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/FISICA/FISICA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            ruta = "FISICA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "FISICA/";

                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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

                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/QUIMICA/QUIMICA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "QUIMICA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "QUIMICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

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


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/BIOLOGIA/BIOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf";


                            ruta = "BIOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf";

//                            File file0 = new File(Environment.getExternalStorageDirectory()
//                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            materiadownload = "BIOLOGIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);

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


                    case 3:


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ARITMETICA/ARITMETICA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "ARITMETICA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            materiadownload = "ARITMETICA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ALGEBRA/ALGEBRA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "ALGEBRA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "ALGEBRA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/GEOMETRIA/GEOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "GEOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "GEOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/TRIGONOMETRIA/TRIGONOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "TRIGONOMETRIA2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "TRIGONOMETRIA/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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


                        if (cd.isConnected()) {
                            // Toast.makeText(context,"Connected", Toast.LENGTH_SHORT).show();


                            urlADescargar = servidor_ruta + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO2" + nivel + "_PRM" + mesnumero + ".pdf";
                            ruta = "RAZONAMIENTO_MATEMATICO2" + nivel + "_PRM" + mesnumero + ".pdf";

                            materiadownload = "RAZONAMIENTO_MATEMATICO/";
                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta);


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

                String rutaficheroGuardado = ruta_storage + "/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/" + materiadownload + ruta;


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


