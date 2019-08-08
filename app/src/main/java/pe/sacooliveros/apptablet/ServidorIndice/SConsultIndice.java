package pe.sacooliveros.apptablet.ServidorIndice;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.Adapter_Indice;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_Cibergrafia;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Cybergrafia;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Indice;
import pe.sacooliveros.apptablet.ViewTomo3Activity;

public class SConsultIndice extends AsyncTask<String, Integer, ArrayList> {


    private final ArrayList<JSONObject> dataResult = new ArrayList<>();
    String emailalumno;
    String gradonumero;
    String nombreserver;
    String sedeserver;
    String matriculaserver;
    ListView lvIndice;

    GridView gridcibergrafia;
    private RelativeLayout currentLayout;
    private Context currentContext;
    private ProgressBar progressBar;

    ArrayList<M_Cybergrafia> Lista;

    String primerpaginajson;

    ArrayList<JSONObject> resValues2;

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
        WebServiceIndice wstools = new WebServiceIndice();
        String rString = WebServiceIndice.requestFromWebService("http://172.16.2.53", 8080, "", strings);
        Log.e("RESPONSE SACO", rString);

        if(rString.equals(""))
        {
            ViewTomo3Activity.instantiate("1");
        }

        ArrayList<JSONObject> resValues = new ArrayList<>();
         resValues2 = new ArrayList<>();

        if (WebServiceIndice.isValidResponse(rString)) {
            try {
                Log.e("RESOBJ_RSTRING", rString);
                JSONObject resObject = new JSONObject(rString);
                Iterator<String> keys = resObject.keys();
//                while (keys.hasNext()) {
//                    Log.e("RESOBJ_KEYS", keys.next());
//                }
                JSONArray resArray = resObject.getJSONArray("indice");
                Log.e("RESOBJ_ARRAY", resArray.toString());
                Log.e("RESOBJ_LEN", String.valueOf(resArray.length()));

                for (int idx = 0; idx < resArray.length(); idx++) {
                    JSONObject arrayItem = resArray.getJSONObject(idx);
                   // Log.e("RESOBJ_CAPITULO", arrayItem.getString("nombre_capitulo"));
                    //Log.e("RESOBJ_PAGINA", arrayItem.getString("pagina"));
                    //Log.e("RESOBJ_PAGINA_DOC", arrayItem.getString("pagina_doc"));
                    JSONObject valIndice = new JSONObject();
                    valIndice.put("nombre_capitulo", arrayItem.getString("nombre_capitulo"));
                    valIndice.put("pagina", arrayItem.getString("pagina"));
                    valIndice.put("pagina_doc", arrayItem.getString("pagina_doc"));
                    resValues.add(valIndice);
                }

                JSONArray resArray2 = resObject.getJSONArray("cibergrafia");
                //Log.e("RESOBJ_ARRAY", resArray2.toString());
                //Log.e("RESOBJ_LEN", String.valueOf(resArray2.length()));

                for (int idx = 0; idx < resArray2.length(); idx++) {
                    JSONObject arrayItem2 = resArray2.getJSONObject(idx);
                    Log.e("DESCRIPCION_TITLE", arrayItem2.getString("descripcion"));
                    JSONObject valIndice2 = new JSONObject();

                    valIndice2.put("descripcion", arrayItem2.getString("descripcion"));
                    valIndice2.put("url", arrayItem2.getString("url"));

                    resValues2.add(valIndice2);
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

        lvIndice = currentLayout.findViewById(R.id.lvIndice);
        gridcibergrafia= currentLayout.findViewById(R.id.lv_cibergrafia);

        ArrayList<M_Indice> elements = new ArrayList<>();
        ArrayList<M_Cybergrafia> data = new ArrayList<>();


        for (int idx = 0; idx < resValues.size(); idx++) {
            M_Indice indice = new M_Indice();
            JSONObject idxItem = (JSONObject) resValues.get(idx);
            try {
                indice.setDescripcion(idxItem.getString("nombre_capitulo"));
                indice.setPagina(idxItem.getString("pagina"));
                indice.setPagina_doc(idxItem.getString("pagina_doc"));
                elements.add(indice);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        for (int idx = 0; idx < resValues2.size(); idx++) {
            M_Cybergrafia cybregrafia = new M_Cybergrafia();
            JSONObject idxItem = (JSONObject) resValues2.get(idx);
            try {
                cybregrafia.setDescripcion(idxItem.getString("descripcion"));
                cybregrafia.setUrl(idxItem.getString("url"));
                data.add(cybregrafia);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

//
        Adapter_Indice iadapter = new Adapter_Indice(currentContext, R.layout.item_indice, elements);
        lvIndice.setAdapter(iadapter);
        iadapter.notifyDataSetChanged();

        if(elements.size()==0)
            {
                ViewTomo3Activity.instantiate("1");
            }else

            {
                String paginicio = elements.get(0).getPagina_doc();//265
                ViewTomo3Activity.instantiate(paginicio);
            }


        Lista= new ArrayList<M_Cybergrafia>();
        final adapter_Cibergrafia adapter= new adapter_Cibergrafia(currentContext,data);
        gridcibergrafia.setAdapter(adapter);


        if(data.size()==0 || data.size()==1)
        {
            ViewTomo3Activity.instantiate2("noitems");
        }

    }

    @Override
    protected void onCancelled(ArrayList resValues) {
        super.onCancelled(resValues);
    }






}

