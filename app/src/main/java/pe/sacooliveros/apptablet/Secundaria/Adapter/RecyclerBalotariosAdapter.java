package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import pe.sacooliveros.apptablet.Balotario.VisorPdfActivity;
import pe.sacooliveros.apptablet.Balotario.contentVisorActivity;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mBalotarios;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.os.Environment.getExternalStorageDirectory;
import static java.lang.Thread.sleep;

public class RecyclerBalotariosAdapter extends RecyclerView.Adapter<RecyclerBalotariosAdapter.MyViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<mBalotarios> mBalotariosList;
    private View.OnClickListener listener;

    String materia;
    String title;
    String servidor_ruta;
    String namedescarga;
    String numgrado;
    String complementurl;

    ConnectionDetector cd;

    public RecyclerBalotariosAdapter(Context mContext, List<mBalotarios> mBalotariosList) {
        this.mContext = mContext;
        this.mBalotariosList = mBalotariosList;
    }

    @NonNull
    @Override
    public RecyclerBalotariosAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        // view = mInflater.inflate(R.layout.item_balotarios, parent, false);
        view = mInflater.inflate(R.layout.item_iconpublicaciones, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerBalotariosAdapter.MyViewHolder holder, final int position) {

        holder.imgbalotario.setImageResource(mBalotariosList.get(position).getImagen_logo());
        holder.imgdownload.setImageResource(mBalotariosList.get(position).getImage_download());
        holder.txtmateria.setText(mBalotariosList.get(position).getMateria());

        cd = new ConnectionDetector(mContext);

        servidor_ruta = mContext.getString(R.string.servidor_ruta);

        numgrado = ShareDataRead.obtenerValor(mContext, "ServerGradoNivel").substring(0, 1);


        holder.imgdownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cd.isConnected()) {
                    materia = mBalotariosList.get(position).getMateria();
                    title = mBalotariosList.get(position).getTitle();
                    namedescarga = mBalotariosList.get(position).getNamedownload();
                    complementurl = mBalotariosList.get(position).getUrlcomplement();

                    String urlADescargar = servidor_ruta + "/APP/2/" + numgrado + "/BALOTARIOS/" + complementurl + namedescarga + ".pdf";
                    descargarPDF(urlADescargar);
                } else {
                    Toast.makeText(mContext, "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.imgbalotario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                materia = mBalotariosList.get(position).getMateria();
                title = mBalotariosList.get(position).getTitle();
                namedescarga = mBalotariosList.get(position).getNamedownload();
                complementurl = mBalotariosList.get(position).getUrlcomplement();

                File filecachepdf = new File(getExternalStorageDirectory() + "/PDFiles/" + namedescarga + ".pdf");


                if (!cd.isConnected()) {
                    if (!filecachepdf.exists()) {
                        Toast.makeText(mContext, "El archivo no existe, estas  sin Conexión", Toast.LENGTH_SHORT).show();
                    } else {
                        String URL = servidor_ruta + "/APP/2/" + numgrado + "/BALOTARIOS/" + complementurl + namedescarga + ".pdf";

                        Intent intent = new Intent(mContext, contentVisorActivity.class);
                      // Intent intent = new Intent(mContext, VisorPdfActivity.class);
//
                        intent.putExtra("ViewType", "internet");
                        intent.putExtra("URL", URL);
                        intent.putExtra("Materia", title);
                        intent.putExtra("ssdtablet", namedescarga + ".pdf");

                        mContext.startActivity(intent);
                    }
                } else {

                    String URL = servidor_ruta + "/APP/2/" + numgrado + "/BALOTARIOS/" + complementurl + namedescarga + ".pdf";

                    Intent intent = new Intent(mContext, contentVisorActivity.class);
                   //Intent intent = new Intent(mContext, VisorPdfActivity.class);

                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", title);
                    intent.putExtra("ssdtablet", namedescarga + ".pdf");

                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mBalotariosList.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {

        if (listener != null) {
            listener.onClick(view);
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgbalotario, imgdownload;
        private TextView txtmateria;

        public MyViewHolder(View itemView) {

            super(itemView);

            //img_mainSMlist
            imgbalotario = itemView.findViewById(R.id.img_balotario);
            imgdownload = itemView.findViewById(R.id.img_downloadbalotario);
            txtmateria = itemView.findViewById(R.id.txt_materia); //iconos

        }
    }


    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(mContext);
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

            //ruta_storage = context.getString(R.string.ruta_raiz);
            ///data/user/0/pe.sacooliveros.apptablet/files

            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexión no realizada correctamente";
                }

                input = conexion.getInputStream();


                //String rutaficheroGuardado = Environment.getExternalStorageDirectory() + "/download/" + namedescarga + ".pdf";
                //String rutaficheroGuardado = Environment.getExternalStorageDirectory() + "/MyFavorite/" + namedescarga + ".pdf";
                String rutaficheroGuardado = Environment.getExternalStorageDirectory() + "/SacoOliveros/" + namedescarga + ".pdf";

                output = new FileOutputStream(rutaficheroGuardado);

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
                //return "Error: " + e.getMessage();
                return "Error: " + "Intente otra vez";
            } catch (IOException e) {
                e.printStackTrace();
                return "Sin Conexión";
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


            return "Se realizó Correctamente";
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

            Toast.makeText(mContext, mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
            //Tiempo estimado
        }
    }
}
