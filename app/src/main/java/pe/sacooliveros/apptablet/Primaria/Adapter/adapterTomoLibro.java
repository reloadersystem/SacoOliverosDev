package pe.sacooliveros.apptablet.Primaria.Adapter;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
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
import pe.sacooliveros.apptablet.Primaria.Model.mTomoLibro;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadListWrite;

import static java.lang.Thread.sleep;

public class adapterTomoLibro extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoLibro> arrayList;
    ConnectionDetector cd;
    String urlADescargar;
    String ruta;
    String materiadownload;
    String ruta_storage;
    String tomodato;
    String tomonumero;
    String tomolibro;
    static String accesoroot;
    String servidor_ruta;

    public adapterTomoLibro(Context context, ArrayList<mTomoLibro> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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

    public void tomo(String dato) {
        tomodato = dato;
    }

    public static void accesofinal(String acceso) {
        accesoroot = acceso;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_tomolibro, null);

        }

        final int indice = position;

        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);
        tomolibro = tomodato.replace(" ", "");
        tomonumero = String.valueOf(tomolibro.charAt(4));

        ImageView imgfoto = convertView.findViewById(R.id.img_tomolibro);
        ImageView imgfoto2 = convertView.findViewById(R.id.img_tomolibrodown);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        imgfoto2.setImageResource(arrayList.get(position).getDownload());

        imgfoto2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (indice) {
                    case 0:

                        break;

                    case 1:


                        break;

                    case 2:


                        break;

                    case 3:

                        if (cd.isConnected()) {

                            urlADescargar = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";
                            ruta = "personal_social5_T" + tomonumero + ".pdf";
                            materiadownload = "/PERSONAL_SOCIAL/";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/PERSONAL_SOCIAL/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

//                                DBwritedownloas();

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - PERSONAL SOCIAL";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, rutaurldata, "true");

                            }
                        } else

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 4:


                        if (cd.isConnected())

                        {
                            urlADescargar = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_VERBAL/razonamiento_verbal5_T" + tomonumero + ".pdf";
                            ruta = "razonamiento_verbal5_T" + tomonumero + ".pdf";
                            materiadownload = "/RAZONAMIENTO_VERBAL/";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_VERBAL/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - PERSONAL SOCIAL";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/PERSONAL_SOCIAL/personal_social5_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_VERBAL/razonamiento_verbal5_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, rutaurldata, "true");

                            }
                        } else if (!cd.isConnected())

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 5:


                        if (cd.isConnected())

                        {


                            urlADescargar = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_MATEMATICO/razonamiento_matematico5_T" + tomonumero + ".pdf";
                            ruta = "razonamiento_matematico5_T" + tomonumero + ".pdf";
                            materiadownload = "/RAZONAMIENTO_MATEMATICO/";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_MATEMATICO/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

                                //DBwritedownloas();


                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - RAZONAMIENTO MATEMÁTICO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_MATEMATICO/razonamiento_matematico5_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/RAZONAMIENTO_MATEMATICO/razonamiento_matematico5_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, rutaurldata, "true");

                            }
                        } else if (!cd.isConnected())

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }


                        break;


                    case 6:


                        if (cd.isConnected())

                        {

                            urlADescargar = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/VALORES_LIDERAZGO/valores_liderazgo5_T" + tomonumero + ".pdf";
                            ruta = "valores_liderazgo5_T" + tomonumero + ".pdf";
                            materiadownload = "/VALORES_LIDERAZGO/";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/VALORES_LIDERAZGO/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

//                                DBwritedownloas();

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - VALORES LIDERAZGO";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/VALORES_LIDERAZGO/valores_liderazgo5_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/VALORES_LIDERAZGO/valores_liderazgo5_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, rutaurldata, "true");

                            }
                        } else if (!cd.isConnected())

                        {
                            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
                        }

                        break;


                    case 7:


                        if (cd.isConnected())

                        {

                            urlADescargar = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/AJEDREZ/ajedrez5_T" + tomonumero + ".pdf";
                            ruta = "ajedrez5_T" + tomonumero + ".pdf";
                            materiadownload = "/AJEDREZ/";


                            File file0 = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/AJEDREZ/" + ruta);

                            if (file0.exists()) {
                                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

                            } else {

                                descargarPDF(urlADescargar);

                                // DBwritedownloas();

                                String nombrepdfusuario = "LIBROS - TOMO " + tomonumero + " - AJEDREZ";
                                String rutasdd = "/data/user/0/pe.sacooliveros.apptablet/files/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/AJEDREZ/ajedrez5_T" + tomonumero + ".pdf";
                                String rutaurldata = servidor_ruta + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + "/AJEDREZ/ajedrez5_T" + tomonumero + ".pdf";
                                DownloadListWrite.WriteDownloads(context, nombrepdfusuario, rutasdd, rutaurldata, "true");


                            }
                        } else if (!cd.isConnected())

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

                String rutaficheroGuardado = ruta_storage + "/APP/1/" + accesoroot + "/LIBROS/" + tomolibro + materiadownload + ruta;


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

        }
    }

}
