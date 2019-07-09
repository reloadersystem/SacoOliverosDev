package pe.sacooliveros.apptablet.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;

import static android.content.Context.MODE_PRIVATE;

public class DownloadListWrite {

    static int count= 0;

    public static void WriteDownloads(Context context, String  ruta, String ssdDescarga, String rutaUrldata, String estadoPdf) {

        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(context, "administracion", null,1 );
        SQLiteDatabase BasedeDatos= admin.getWritableDatabase();

        String dato1= obtenerValor(context, "contadorDB");

        count= Integer.parseInt(dato1)+ 1;

        String codigo= String.valueOf(count);
        String nombrepdf= ruta;
        String ssdruta= ssdDescarga;

        guardarValor(context,"contadorDB", codigo);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        String urldataweb=rutaUrldata;

        String estadopdfdata= estadoPdf;

        ContentValues registro= new ContentValues();
        registro.put("codigo",codigo);
        registro.put("nombre",nombrepdf);
        registro.put("ruta",ssdruta);
        registro.put("fecha",date);
        registro.put("urlwebdata", urldataweb);
        registro.put("estadopdf", estadopdfdata);

        BasedeDatos.insert("descargas", null, registro);

        BasedeDatos.close();
    }

    private static String PREFS_KEY = "autenticacionOff";

    public static void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();
    }

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return  preferences.getString(keyPref, "");
    }

}


//uso :   DownloadListWrite.WriteDownloads(context, ruta, urlADescargar);