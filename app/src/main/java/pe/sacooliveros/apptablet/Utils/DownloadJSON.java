package pe.sacooliveros.apptablet.Utils;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;

import java.io.File;

import pe.sacooliveros.apptablet.ViewTomo3Activity;

public class DownloadJSON {

    static DownloadManager  downloadManager;


     static public  void  descargar(String ulrDescargar, Context context, String rutaficheroGuardado, String ruta)
    {
        String urldato=  ulrDescargar;

        String rutaguardado= rutaficheroGuardado;

        String  rutadata= ruta;


        int forjsonurl= urldato.length();

        String urlconstructor= urldato.substring(0,forjsonurl-4);

        String urljsonfinal= urlconstructor+".json";



        int rutanom= rutadata.length();

        String urlconstructor2= rutadata.substring(0,rutanom-4);

        String urljsonfinal2= urlconstructor2+".json";


        downloadManager= (DownloadManager) context.getSystemService(context.DOWNLOAD_SERVICE);

        Uri uri= Uri.parse(urljsonfinal);

        DownloadManager.Request request= new DownloadManager.Request(uri);
        request.setDestinationInExternalFilesDir(context, rutaguardado,urljsonfinal2);

        Long reference = downloadManager.enqueue((request));


    }


}
