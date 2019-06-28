package pe.sacooliveros.apptablet.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class ShareDataRead {

    static String  PREFS_KEY= "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return  preferences.getString(keyPref, "");

    }

    //  sharedata= ShareDataRead.obtenerValor(context, "TipoGradoAsiste");  para llamar la función
}
