package pe.sacooliveros.apptablet.Secundaria.DataBaseHelper;

import android.app.Fragment;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import pe.sacooliveros.apptablet.Secundaria.DBVersionSeminario.UtilVersion;
import pe.sacooliveros.apptablet.Secundaria.Model.Model;
import pe.sacooliveros.apptablet.Secundaria.fragments.Capitulo1_Fragment;

public class VideoSeminarioWSConsult extends AsyncTask<String, Integer, String> {

    private Fragment currentLayout;
    private Context currentContext;
    private final ArrayList<JSONObject> dataResult = new ArrayList<>();
    private ProgressBar progressBar;
    RecyclerView recyclerView;

    JSONArray arrayItem;

    Capitulo1_Fragment  capitulo1_fragment;


    //SETTER AND GETTER
    private Fragment getCurrentLayout() {
        return currentLayout;
    }

    public void setCurrentLayout(Fragment currentLayout) {
        this.currentLayout = currentLayout;
    }

    private Context getCurrentContext() {
        return currentContext;
    }

    public void setCurrentContext(Context currentContext) {
        this.currentContext = currentContext;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
//        progressBar = getCurrentLayout().findViewById(R.id.progressBar);
//        if (progressBar != null) {
//            progressBar.setVisibility(View.VISIBLE);
//        }
    }

    @Override
    protected void onCancelled(String arrayList) {
        super.onCancelled(arrayList);
//        if (progressBar != null) {
//            progressBar.setVisibility(View.GONE);
//        }
    }

    protected String doInBackground(String... strings) {

        WebServiceSeminarioTools wstools = new WebServiceSeminarioTools();

        String rString = WebServiceSeminarioTools.requestFromWebService("http://tablet.sacooliveros.edu.pe/", 8080, "", strings);

        Log.d("RESPONSE Servidor Saco", rString);


        ArrayList<JSONObject> resValues = new ArrayList<>();


        JSONObject resObject = null;
        try {
            resObject = new JSONObject(rString);

            if (resObject.has("version")) {
                String versiondata = resObject.getString("version");
                // Toast.makeText(currentContext, versiondata, Toast.LENGTH_SHORT).show();

                if (versiondata.equalsIgnoreCase("1.0")) {


                    arrayItem = resObject.getJSONArray("listavideo");

//
//                    arrayItem = new JSONArray();
//                    for (int idx = 0; idx < resArray.length(); idx++) {
//                        JSONObject item = resArray.getJSONObject(idx);
//                        arrayItem.put(item);
//
//                        valVMotivadores = new JSONObject();
//                        valVMotivadores.put("codigo", item.getString("codigo"));
//                        valVMotivadores.put("asignatura", item.getString("asignatura"));
//                        valVMotivadores.put("habilitar", item.getString("habilitar"));
//                        valVMotivadores.put("capitulo", item.getString("capitulo"));
//                        valVMotivadores.put("urlpdf", item.getString("urlpdf"));
//                        valVMotivadores.put("ssdpdf", item.getString("ssdpdf"));
//                        valVMotivadores.put("tomopdf", item.getString("tomopdf"));
//                        valVMotivadores.put("gradopdf", item.getString("gradopdf"));
//                        valVMotivadores.put("listyoutube", item.getString("listyoutube"));
//
//                        resValues.add(valVMotivadores);
//                    }

                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rString;
    }

    @Override
    protected void onPostExecute(String rString) {
        super.onPostExecute(rString);

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getCurrentContext(), "bdseminarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        AdminSQLiteOpenHelper versiondb = new AdminSQLiteOpenHelper(getCurrentContext(), "bdversionseminario", null, 1);
        SQLiteDatabase versionBaseDeDatos = admin.getWritableDatabase();

        final String MNU_CODIGO = "codigo";
        final String MNU_ASIGNATURA = "asignatura";
        final String MNU_HABILITAR = "habilitar";
        final String MNU_CAPITULO = "capitulo";
        final String MNU_URLPDF = "urlpdf";
        final String MNU_SSDPDF = "ssdpdf";
        final String MNU_TOMOPDF = "tomopdf";
        final String MNU_GRADOPDF = "gradopdf";
        final String MNU_LISTYOUTUBE = "listyoutube";

        ArrayList<Model> elements = new ArrayList<>();


        try {


//            JSONObject resObject = new JSONObject(rString);
//
//            JSONArray resArray = resObject.getJSONArray("listavideo");
            //JSONArray menuItemsJsonArray = new JSONArray(resArray);


            if (arrayItem != null) {
                for (int i = 0; i < arrayItem.length(); ++i) {

                    Model model = new Model();


                    String codigo;
                    String asignatura;
                    String habilitar;
                    String capitulo;
                    String urlpdf;
                    String ssdpdf;
                    String tomopdf;
                    String gradopdf;
                    String listyoutube;

                    JSONObject menuItemObject = arrayItem.getJSONObject(i);

                    model.setCodigo(menuItemObject.getString(MNU_CODIGO));
                    model.setCodigo(menuItemObject.getString(MNU_ASIGNATURA));
                    model.setCodigo(menuItemObject.getString(MNU_HABILITAR));
                    model.setCodigo(menuItemObject.getString(MNU_CAPITULO));
                    model.setCodigo(menuItemObject.getString(MNU_URLPDF));
                    model.setCodigo(menuItemObject.getString(MNU_SSDPDF));
                    model.setCodigo(menuItemObject.getString(MNU_TOMOPDF));
                    model.setCodigo(menuItemObject.getString(MNU_GRADOPDF));
                    model.setCodigo(menuItemObject.getString(MNU_LISTYOUTUBE));


                    codigo = menuItemObject.getString(MNU_CODIGO);
                    asignatura = menuItemObject.getString(MNU_ASIGNATURA);
                    habilitar = menuItemObject.getString(MNU_HABILITAR);
                    capitulo = menuItemObject.getString(MNU_CAPITULO);
                    urlpdf = menuItemObject.getString(MNU_URLPDF);
                    ssdpdf = menuItemObject.getString(MNU_SSDPDF);
                    tomopdf = menuItemObject.getString(MNU_TOMOPDF);
                    gradopdf = menuItemObject.getString(MNU_GRADOPDF);
                    listyoutube = menuItemObject.getString(MNU_LISTYOUTUBE);
                    elements.add(model);

                    ContentValues registro = new ContentValues();
                    registro.put(Utilidades.CAMPO_CODIGO, codigo);
                    registro.put(Utilidades.CAMPO_ASIGNATURA, asignatura);
                    registro.put(Utilidades.CAMPO_HABILITAR, habilitar);
                    registro.put(Utilidades.CAMPO_CAPITULO, capitulo);
                    registro.put(Utilidades.CAMPO_URLPDF, urlpdf);
                    registro.put(Utilidades.CAMPO_SSDPDF, ssdpdf);
                    registro.put(Utilidades.CAMPO_TOMOPDF, tomopdf);
                    registro.put(Utilidades.CAMPO_GRADOPDF, gradopdf);
                    registro.put(Utilidades.CAMPO_LISTYOUTUBE, listyoutube);

                    BaseDeDatos.insert("videoseminario", null, registro);


                }

                BaseDeDatos.close();
                versionBaseDeDatos.close();

                capitulo1_fragment = new Capitulo1_Fragment();


                RecyclerViewAdapter adapter = new RecyclerViewAdapter(currentContext, elements);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
