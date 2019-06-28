package pe.sacooliveros.apptablet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
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

import pe.sacooliveros.apptablet.DownloadPDF.adapter;
import pe.sacooliveros.apptablet.DownloadPDF.mPdf;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;

import static android.os.Environment.DIRECTORY_DOWNLOADS;
import static java.lang.Thread.sleep;

public class ActualizarPDFActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int PICK_PDF_CODE = 1000;
    ImageView image_descarga;
    Button btn_open_storage;
    Button btn_open_from_internet;
    ArrayList<mPdf> Lista;
    String ruta;

    //String urlADescargar;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_pdf);

        image_descarga = findViewById(R.id.image_descarga);
        btn_open_storage = findViewById(R.id.btn_open_storage);
        btn_open_from_internet = findViewById(R.id.btn_open_from_internet);

        gridView = findViewById(R.id.ma_lista);
        Lista = new ArrayList<mPdf>();


        Lista.add(new mPdf("balotarios/mensual/solucionario/5to_solucionario/algebra.pdf", R.drawable.ic_cloud_download_black_24dp, "NEW"));
        Lista.add(new mPdf("users/witchel/371M/lectures/17-fragments.pdf", R.drawable.ic_cloud_download_black_24dp, "ON"));
        Lista.add(new mPdf("balotarios/mensual/04/5to/solucionario/algebra.pdf", R.drawable.ic_cloud_download_black_24dp, "NEW"));
        Lista.add(new mPdf("balotarios/mensual/solucionario/5to_solucionario/aritmetica.pdf", R.drawable.ic_cloud_download_black_24dp, "ON"));
        Lista.add(new mPdf("balotarios/mensual/solucionario/5to_solucionario/economia.pdf", R.drawable.ic_cloud_download_black_24dp, "ON"));
        Lista.add(new mPdf("Helico Diapositivas Tomo 4 Computación.pdf", R.drawable.ic_cloud_download_black_24dp, "NEW"));
        Lista.add(new mPdf("Helico Materiales Academicos Tomo 3 Ciencias.pdf", R.drawable.ic_cloud_download_black_24dp, "ON"));
        Lista.add(new mPdf("Helico Diapositvas Educacion Fisica.pdf", R.drawable.ic_cloud_download_black_24dp, "NEW"));
        Lista.add(new mPdf("Helico Materiales Academicos Tomo 4 Letras.pdf", R.drawable.ic_cloud_download_black_24dp, "NEW"));


        final adapter adapter = new adapter(getApplicationContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                try {
                    mPdf mPdf = (mPdf) adapter.getItem(position);
                    //Toast.makeText(getBaseContext(), mPdf.getDescripcion() + "(index"+position+")", Toast.LENGTH_SHORT).show();

                    switch (position) {
                        case 0:
                            //VIsualizar  un PDF desde internet
//                          String URL0= "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/SOLUCIONARIO/5TO_SOLUCIONARIO/ALGEBRA.pdf";
//
//
//                          Intent intent= new Intent(ActualizarPDFActivity.this, ViewActivity.class);
//                          intent.putExtra("ViewType","internet");
//
//                          intent.putExtra("URL", URL0);
//                          startActivity(intent);


//                           Toast.makeText(getBaseContext(), mPdf.getDescripcion() + "(index"+position+")", Toast.LENGTH_SHORT).show();


                            //String urlADescargar= "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/SOLUCIONARIO/5TO_SOLUCIONARIO/ALGEBRA.pdf";


                            String urlADescargar = "http://app1.sacooliveros.edu.pe/javascript.pdf";
                            ruta = "fileSaco.pdf";

                            File file1 = new File(Environment.getExternalStorageDirectory()
                                    + File.separator + "SacoOliveros" + File.separator + ruta);

                            if (file1.exists()) {
                                Toast.makeText(ActualizarPDFActivity.this, "Archivo Existente", Toast.LENGTH_SHORT).show();



                            } else {
                                descargarPDF(urlADescargar);


                                Log.e("DATOPDF", file1.toString());
                            }

                            break;


                        case 1:

                            String URL1 = "https://www.cs.utexas.edu/users/witchel/371M/lectures/17-fragments.pdf";

                            Intent intent1 = new Intent(ActualizarPDFActivity.this, ViewActivity.class);
                            intent1.putExtra("ViewType", "internet");

                            intent1.putExtra("URL", URL1);
                            startActivity(intent1);

                            break;


                        case 2:


                            String urlADescargar1 = "http://app1.sacooliveros.edu.pe/CIENCIAS_3SEC_2018.pdf";
                            //String urlADescargar1 = "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/04/5TO/SOLUCIONARIO/ALGEBRA.pdf";
                            ruta = "CIENCIAS_3SEC_2018.pdf";

                            File file2 = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + ruta);


                            if (file2.exists()) {
                                Toast.makeText(ActualizarPDFActivity.this, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {
                                descargarPDF(urlADescargar1);

                            }


                            break;


                        case 3:


                            String URL2 = "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/SOLUCIONARIO/5TO_SOLUCIONARIO/ARITMETICA.pdf";

                            Intent intent2 = new Intent(ActualizarPDFActivity.this, ViewActivity.class);
                            intent2.putExtra("ViewType", "internet");

                            intent2.putExtra("URL", URL2);
                            startActivity(intent2);

                            break;


                        case 4:

                            String urlADescargar2 = "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/SOLUCIONARIO/5TO_SOLUCIONARIO/ECONOMIA.pdf";
                            ruta = "BalotarioEconomia05.pdf";

                            File file3 = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_DOWNLOADS) + "/" + ruta);

                            if (file3.exists()) {
                                Toast.makeText(ActualizarPDFActivity.this, "Archivo Existente", Toast.LENGTH_SHORT).show();
                            } else {
                                descargarPDF(urlADescargar2);

                            }



                        case 5:




                            break;


                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }


        });


        image_descarga.setOnClickListener(this);
        btn_open_storage.setOnClickListener(this);
        btn_open_from_internet.setOnClickListener(this);
    }







    @Override
    public void onClick(View view) {

        //modificar

        switch (view.getId()) {
            case R.id.image_descarga:

                String urlADescargar = "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/SOLUCIONARIO/5TO_SOLUCIONARIO/ARITMETICA.pdf";
                descargarPDF(urlADescargar);
                break;


            case R.id.btn_open_storage:

                Intent browserPdf = new Intent(Intent.ACTION_GET_CONTENT);
                browserPdf.setType("application/pdf");
                browserPdf.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(Intent.createChooser(browserPdf, "Select PDF"), PICK_PDF_CODE);

                break;


            case R.id.btn_open_from_internet:


                String URLbase = "http://www.aulavirtualsacooliveros.edu.pe/contenido/2018/SECUNDARIA/BALOTARIOS/MENSUAL/04/5TO/SOLUCIONARIO/ALGEBRA.pdf";
                Intent intent1 = new Intent(ActualizarPDFActivity.this, ViewActivity.class);
                intent1.putExtra("ViewType", "internet");

                intent1.putExtra("URL", URLbase);
                startActivity(intent1);

                break;

        }


    }

    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Descargando PDF...");

        new DescargarPDFAsynTask(progressDialog).execute(urlADescargar);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_PDF_CODE && resultCode == RESULT_OK && data != null) {
            Uri selectPDF = data.getData();
            Intent intent = new Intent(ActualizarPDFActivity.this, ViewActivity.class);
            intent.putExtra("ViewType", "storage");
            intent.putExtra("FileUri", selectPDF.toString());
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menupdf, menu);
        //getMenuInflater().inflate(R.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


       /* if (id == R.id.action_opcionBpdf) {

            Toast.makeText(this,"zoom in",Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.action_opcionCpdf) {
            Toast.makeText(this,"zoom out",Toast.LENGTH_SHORT).show();
            return true;
        }*/


        if (id == R.id.action_opcionDpdf) {

            Intent intent = new Intent(ActualizarPDFActivity.this, NavActivity.class);
            startActivity(intent);


            return true;
        }




        return super.onOptionsItemSelected(item);
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


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                String rutaficheroGuardado =
                Environment.getExternalStorageDirectory()
                        + File.separator + "SacoOliveros"+ File.separator +  ruta;

                output = new FileOutputStream((rutaficheroGuardado));

                int tamanoFichero = conexion.getContentLength();

                byte[] data = new byte[1024];
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

            progressDialog.dismiss();

            Toast.makeText(ActualizarPDFActivity.this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }
}

