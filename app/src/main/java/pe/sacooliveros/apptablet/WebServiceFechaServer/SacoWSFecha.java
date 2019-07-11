package pe.sacooliveros.apptablet.WebServiceFechaServer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;
import pe.sacooliveros.apptablet.SplashActivity;
import pe.sacooliveros.apptablet.WebServiceInstitucion.SacoWSConsult;

import static android.content.Context.MODE_PRIVATE;

public class SacoWSFecha extends AsyncTask<String, Integer, ArrayList> {


    private final ArrayList<JSONObject> dataResult = new ArrayList<>();

    private Context currentContext;

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }


    @Override
    protected ArrayList doInBackground(String... strings) {
        WebServiceFecha wstools = new WebServiceFecha();
        String rString = WebServiceFecha.requestFromWebService("http://172.16.2.53", 8080, "", strings);
        Log.e("RESPONSE SACO", rString);

        ArrayList<JSONObject> resValues = new ArrayList<>();

        if (WebServiceFecha.isValidResponse(rString)) {
            try {
                Log.e("RESOBJ_RSTRING", rString);
                JSONObject resObject = new JSONObject(rString);

                if (resObject.has("data")) {
                    JSONObject objectItem = new JSONObject(String.valueOf(resObject.getJSONObject("data")));

                    String fechaserver = objectItem.get("fecha").toString();

                    //String apkversionserver = String.valueOf(objectItem.getDouble("version_actual"));
                    String apkversionserver = objectItem.get("version_actual").toString();

                    SplashActivity.fechaserver(fechaserver);

                    NavActivity.apkversion(apkversionserver);
                    CiclosEspeciales.apkversion(apkversionserver);
                    NavigatorPrimaria.apkversion(apkversionserver);

                    SacoWSConsult.fechaserver(fechaserver);
                    guardarValor(currentContext, "fechaserver", fechaserver);

                    // Log.e("FECHA SERVER", fechaserver);
                }

            } catch (Exception errString) {
                errString.printStackTrace();
            }
        }

        return resValues;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    public void onPostExecute(ArrayList resValues) {
        super.onPostExecute(resValues);

    }

    @Override
    protected void onCancelled(ArrayList resValues) {
        super.onCancelled(resValues);
    }


    private static String PREFS_KEY = "autenticacionOff";

    public static void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();
    }
}

