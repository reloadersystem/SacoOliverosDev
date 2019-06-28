package pe.sacooliveros.apptablet.NewsPaper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Model.M_ListNoticia;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapter_meditacion;
import pe.sacooliveros.apptablet.Seleccion.Model.M_ListMeditacion;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

public class SConsultNoticia extends AsyncTask<String, Integer, ArrayList> {

    private final ArrayList<JSONObject> dataResult = new ArrayList<>();

    ListView lvNoticia;

    private RelativeLayout currentLayout;
    private Context currentContext;

    private static final String TAG = "MEDITALOG";
    //logt  te sale  un tag

    String appName;

    String box;

    String packageName;


    String primerpaginajson;


    public RelativeLayout getCurrentLayout() {
        return currentLayout;
    }

    public void setCurrentLayout(RelativeLayout currentLayout) {
        this.currentLayout = currentLayout;
    }

    public Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }

    @Override
    protected ArrayList doInBackground(String... strings) {

        ServiceNoticia wstools = new ServiceNoticia();
        String rString = ServiceNoticia.requestFromWebService("http://172.16.2.53", 8080, "", strings);
        Log.e("RESPONSE SACO", rString);

        ArrayList<JSONObject> resValues = new ArrayList<>();


        if (ServiceNoticia.isValidResponse(rString)) {
            try {
                Log.e("RESOBJ_RSTRING", rString);
                JSONArray resArraydata2 = new JSONArray(rString);
                //Log.e("dataobtenida",resArraydata2.toString());


                for (int idx = 0; idx < resArraydata2.length(); idx++) {
                    JSONObject arrayItem = resArraydata2.getJSONObject(idx);
//                    Log.e("RESOBJ_TITULO", arrayItem.getString("titulo"));
//                    Log.e("RESOBJ_DESCRIPCION", arrayItem.getString("descripcion"));
//                    Log.e("RESOBJ_URL", arrayItem.getString("url"));

                    JSONObject valNoticia = new JSONObject();
                    valNoticia.put("titulo", arrayItem.getString("titulo"));
                    valNoticia.put("descripcion", arrayItem.getString("descripcion"));
                    valNoticia.put("url", arrayItem.getString("url"));
                    resValues.add(valNoticia);
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
    //protected void onPostExecute(String rString) {
    public void onPostExecute(ArrayList resValues) {
        super.onPostExecute(resValues);


        String sharedata = ShareDataRead.obtenerValor(getCurrentContext(), "ServerGradoNivel");

        if (sharedata.equalsIgnoreCase("601 Secundaria") ||sharedata.equalsIgnoreCase("701 Secundaria") ||sharedata.equalsIgnoreCase("601 Primaria") ) {

            ArrayList<M_ListMeditacion> lst_medita = new ArrayList<>();

            for (int idmed = 0; idmed < resValues.size(); idmed++) {
                M_ListMeditacion mlistmedita = new M_ListMeditacion();
                JSONObject idxItem = (JSONObject) resValues.get(idmed);
                try {
                    mlistmedita.setTitulo(idxItem.getString("titulo"));
                    mlistmedita.setDescripcion(idxItem.getString("descripcion"));
                    mlistmedita.setUrl(idxItem.getString("url"));
                    lst_medita.add(mlistmedita);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            adapter_meditacion adapter = new adapter_meditacion(currentContext, R.layout.item_listmedita, lst_medita);
            createCustomDialog(getCurrentContext(), getCurrentLayout(), adapter);

        }

        if (sharedata.equalsIgnoreCase("5 Primaria") || sharedata.equalsIgnoreCase("6 Primaria"))

        {
            lvNoticia = currentLayout.findViewById(R.id.lvNoticia);

            ArrayList<M_ListNoticia> elements = new ArrayList<>();

            for (int idx = 0; idx < resValues.size(); idx++) {
                M_ListNoticia mlistnoticia = new M_ListNoticia();
                JSONObject idxItem = (JSONObject) resValues.get(idx);
                try {
                    mlistnoticia.setTitulo(idxItem.getString("titulo"));
                    mlistnoticia.setDescripcion(idxItem.getString("descripcion"));
                    mlistnoticia.setUrl(idxItem.getString("url"));
                    elements.add(mlistnoticia);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            Adapter_Noticia iadapter = new Adapter_Noticia(currentContext, R.layout.item_noticia, elements);
            lvNoticia.setAdapter(iadapter);
            iadapter.notifyDataSetChanged();

        }


    }

    @Override
    protected void onCancelled(ArrayList resValues) {
        super.onCancelled(resValues);
    }


    public void createCustomDialog(final Context context, RelativeLayout relativeLayout, final ArrayAdapter arrayAdapter) {
        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.meditacionpopup, null);

        final GridView lvView = view.findViewById(R.id.grid_medita);
        final Button btn_cerrar = view.findViewById(R.id.btn_cerrar);
        final ImageView img_medita = view.findViewById(R.id.img_meditaapp);

        //img_meditaapp


        if (lvView != null) {
            lvView.setAdapter(arrayAdapter);
        }

        builder.setView(view);
        alertDialog = builder.create();
        alertDialog.show();


        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        img_medita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appName = "Gmail";
                packageName = "org.simo.medita";
                box = "org.simo.medita";

                openApp(getCurrentContext(), appName, packageName);
            }
        });

        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                M_ListMeditacion meditacion = (M_ListMeditacion) adapterView.getItemAtPosition(position);

                int totalitems = adapterView.getCount(); //12 cuantos  items tiene mi lista

                for (int ax = 0; ax <= adapterView.getCount(); ax++) {

                    if (position == ax) {
                        String urldata = meditacion.getUrl();
                        Uri uri = Uri.parse(urldata);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getCurrentContext().startActivity(intent);
                    }
                }
            }
        });
    }


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getCurrentContext(), box);


        //else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
    }

    private void startNewActivity(Context context, String packageName) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
            // We found the activity now start the activity
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
            // Bring user to the market or let them choose an app?
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            context.startActivity(intent);
        }

    }

    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return false;
    }

    private static boolean isAppEnabled(Context context, String packageName) {
        boolean appStatus = false;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(packageName, 0);
            if (ai != null) {
                appStatus = ai.enabled;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appStatus;
    }
}
