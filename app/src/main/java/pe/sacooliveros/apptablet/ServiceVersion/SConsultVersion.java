package pe.sacooliveros.apptablet.ServiceVersion;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class SConsultVersion extends AsyncTask<String, Integer, ArrayList> {


    private final ArrayList<JSONObject> dataResult = new ArrayList<>();

    String url;

    private Context currentContext;

    private DrawerLayout currentLayout;

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    public SConsultVersion(final String URL) {
        this.url = URL;
    }


    public void setCurrentLayout(DrawerLayout currentLayout) {
        this.currentLayout = currentLayout;
    }


    @Override
    protected ArrayList doInBackground(String... strings) {
        VersionService wstools = new VersionService();
        String rString = wstools.requestFromWebService(url, 8080, "", strings);
        //Log.e("RESPONSE SACO", rString);

        ArrayList<JSONObject> resValues = new ArrayList<>();

        if (VersionService.isValidResponse(rString)) {
            try {
                Log.e("RESOBJ_VERSION", rString);
                JSONObject resObject = new JSONObject(rString);

//                if (resObject.has("data")) {
//                    JSONObject objectItem = new JSONObject(String.valueOf(resObject.getJSONObject("data")));
//
////                    String fechaserver = objectItem.get("fecha").toString();
////
////                    String apkversionserver = objectItem.get("numero_version").toString();
//
//
//                    guardarValor(currentContext, "EstadoAuthentication", "Exitoso");
//                }


                    String estadoenviado = resObject.getString("status");
                    String message = resObject.getString("message");

                    //guardarValor(currentContext, "EstadoAuthentication", estadoenviado);


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

        guardarValor(currentContext, "CheckOutService", "Servicio Finalizado");



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

