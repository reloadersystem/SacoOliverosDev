package pe.sacooliveros.apptablet.Utils;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

public class GeneralFileManager {

    String ruta_base_servidor;
    String ruta_base_ssd;
    Context context;
    ConnectionDetector connectionDetector;


    public GeneralFileManager(Context context) {
        this.context = context;
        this.ruta_base_servidor = context.getString(R.string.servidor_ruta);
        this.ruta_base_ssd = context.getString(R.string.ruta_raiz);
    }

    public void manageFileView(String file_route, String file_title) {
        connectionDetector = new ConnectionDetector(context);
        File file = new File(ruta_base_ssd + file_route);

        if (connectionDetector.isConnected()) {

            Intent intent = new Intent(context, ViewTomo3Activity.class);
            intent.putExtra("ViewType", "internet");
            intent.putExtra("URL", ruta_base_servidor + file_route);
            intent.putExtra("Materia", file_title);
            context.startActivity(intent);
        } else {
            if (file.exists()) {
                Intent intent = new Intent(context, ViewTomo3Activity.class);
                intent.putExtra("ViewType", "storage");
                intent.putExtra("SSDFILE", ruta_base_ssd + file_route);
                intent.putExtra("Materia", file_title);
                intent.putExtra("EstadoConexion", "SinConexion");
                context.startActivity(intent);
                Toast.makeText(context, "Visualizando archivo descargado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "El archivo no se encuentra descargado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void downloadFileView(String file_route, String pdfusername) {
        connectionDetector = new ConnectionDetector(context);
        DownloadsSave downloadsSave = new DownloadsSave();

        File file = new File(ruta_base_ssd + file_route);

        if (connectionDetector.isConnected()) {
            if (file.exists()) {
                Toast.makeText(context, "Archivo Existente", Toast.LENGTH_SHORT).show();

            } else

            {
                downloadsSave.descargarPDF(ruta_base_servidor + file_route, ruta_base_ssd + file_route, context, pdfusername);

              //  DownloadListWrite.WriteDownloads(context, pdfusername, ruta_base_ssd + file_route, ruta_base_servidor + file_route, "true");
            }
        }

        else
        {
            Toast.makeText(context, " Sin Conexión", Toast.LENGTH_SHORT).show();
        }
    }
}

