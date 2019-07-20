package pe.sacooliveros.apptablet.Secundaria.ServiceWSeminario;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.DBVersionSeminario.AdminSQLVersionSeminario;
import pe.sacooliveros.apptablet.Secundaria.DBVersionSeminario.UtilVersion;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.RecyclerViewAdapter;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.Utilidades;
import pe.sacooliveros.apptablet.Secundaria.Model.Model;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

public class SConsultSeminario extends AsyncTask<String, Integer, ArrayList> {


    private final ArrayList<JSONObject> dataResult = new ArrayList<>();

    private RelativeLayout currentLayout;
    private Context currentContext;
    private ProgressDialog progressDialog;

    ArrayList<Model> listacursos;

    static View vistaVideo;

    ArrayList<JSONObject> resValues;


    RecyclerView recyclerViewvideo;

    private static Context datavideocontext;

    AdminSQLiteOpenHelper conn;

    String versionjson;

    String urlcontent;

    String tomoversion;

    String url;

    String tomoversionconsult;

    Float versiondbconsult;

    Dialog dialog;
    int countgrado = 0;

    public SConsultSeminario() {

    }

    public SConsultSeminario(final String URL) {
        this.url = URL;
    }

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


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getCurrentContext(), "bdseminarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        // int cantidad = BaseDeDatos.delete("videoseminario", null, null); //  eliminar  base e datos  luego ingresar nuevos datos...

        AdminSQLVersionSeminario versiondata = new AdminSQLVersionSeminario(getCurrentContext(), "bdversion", null, 1);
        SQLiteDatabase BDVersion = versiondata.getWritableDatabase();


        //  Boolean data= checkEmpty(); //BD esta vacia?
//        if(!data)
//        {      }

        WebServiceSeminarioData wstools = new WebServiceSeminarioData();
        String rString = wstools.requestFromWebService(url, 8080, "", strings);
        Log.e("RESPONSE SACO", rString);

        resValues = new ArrayList<>();

        Log.e("RESOBJ_RSTRING", rString);
        JSONObject resObject = null;

        if (WebServiceSeminarioData.isValidResponse(rString)) {
            try {
                resObject = new JSONObject(rString);

                versionjson = resObject.get("version").toString();
                tomoversion = resObject.get("nombretomo").toString();

                urlcontent = url;

                JSONArray resArray2 = resObject.getJSONArray("listavideo"); //

                for (int idxItem = 0; idxItem < resArray2.length(); idxItem++) {

                    JSONObject arrayItem = resArray2.getJSONObject(idxItem);

                    ContentValues registro = new ContentValues();
                    registro.put(Utilidades.CAMPO_CODIGO, arrayItem.getString("codigo"));
                    registro.put(Utilidades.CAMPO_ASIGNATURA, arrayItem.getString("asignatura"));
                    registro.put(Utilidades.CAMPO_HABILITAR, arrayItem.getString("habilitar"));
                    registro.put(Utilidades.CAMPO_CAPITULO, arrayItem.getString("capitulo"));
                    registro.put(Utilidades.CAMPO_URLPDF, arrayItem.getString("urlpdf"));
                    registro.put(Utilidades.CAMPO_SSDPDF, arrayItem.getString("ssdpdf"));
                    registro.put(Utilidades.CAMPO_TOMOPDF, arrayItem.getString("tomopdf"));
                    registro.put(Utilidades.CAMPO_GRADOPDF, arrayItem.getString("gradopdf"));
                    registro.put(Utilidades.CAMPO_LISTYOUTUBE, arrayItem.getString("listyoutube"));

                    BaseDeDatos.insert("videoseminario", null, registro);

                    JSONObject vListVideo = new JSONObject();

                    vListVideo.put("codigo", arrayItem.getString("codigo"));
                    vListVideo.put("asignatura", arrayItem.getString("asignatura"));
                    vListVideo.put("habilitar", arrayItem.getString("habilitar"));
                    vListVideo.put("capitulo", arrayItem.getString("capitulo"));
                    vListVideo.put("urlpdf", arrayItem.getString("urlpdf"));
                    vListVideo.put("ssdpdf", arrayItem.getString("ssdpdf"));
                    vListVideo.put("tomopdf", arrayItem.getString("tomopdf"));
                    vListVideo.put("gradopdf", arrayItem.getString("gradopdf"));
                    vListVideo.put("listyoutube", arrayItem.getString("listyoutube"));
                    resValues.add(vListVideo);
                }

                BaseDeDatos.close();

                ContentValues versionregistro = new ContentValues();

                versionregistro.put("codigo", "G0001");
                versionregistro.put("version", versionjson);
                versionregistro.put("urltomo", urlcontent);
                versionregistro.put("nombretomo", tomoversion);

                BDVersion.insert("tablaversiondb", null, versionregistro);
                BDVersion.close();


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return resValues;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


//        progressDialog = new ProgressDialog(currentContext, R.style.progressDialogTheme);
//        TextView tvTitle = new TextView(currentContext);
//        tvTitle.setGravity(Gravity.CENTER);
//        tvTitle.setText(currentContext.getResources().getString(R.string.textProgresDialog));
//        progressDialog.setIndeterminate(true);
//        progressDialog.setCustomTitle(tvTitle);
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progressDialog.setMessage("Descargando Recursos...");
//        progressDialog.show();

//
        dialog = new Dialog(currentContext, R.style.progressDialogTheme);
        dialog.setContentView(R.layout.customdialog_carga);
        ImageView imageView = dialog.findViewById(R.id.imageView);
        AnimationDrawable animationDrawable;
        animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();

        dialog.show();


    }

    @Override
    //protected void onPostExecute(String rString) {
    public void onPostExecute(ArrayList resValues) {
        super.onPostExecute(resValues);


        if (resValues.isEmpty() == false) {

            ArrayList<Model> elements = new ArrayList<>();

            String sharedata = ShareDataRead.obtenerValor(currentContext, "ServerGradoNivel");

            if (sharedata.equalsIgnoreCase("1 Secundaria") || sharedata.equalsIgnoreCase("2 Secundaria")) {
                countgrado = 12;
            } else {
                countgrado = 15;
            }

            for (int idx = 0; idx < countgrado; idx++) {
                Model model = new Model();

                JSONObject idxItem = (JSONObject) resValues.get(idx);
                {
                    try {
                        model.setCodigo(idxItem.getString("codigo"));
                        model.setAsignatura(idxItem.getString("asignatura"));
                        model.setHabilitar(idxItem.getBoolean("habilitar"));
                        model.setCapitulo(idxItem.getString("capitulo"));
                        model.setUrlpdf(idxItem.getString("urlpdf"));
                        model.setSsdpdf(idxItem.getString("ssdpdf"));
                        model.setTomopdf(idxItem.getString("tomopdf"));
                        model.setGradopdf(idxItem.getString("gradopdf"));
                        model.setListyoutube(idxItem.getString("listyoutube"));
                        elements.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }


            recyclerViewvideo = vistaVideo.findViewById(R.id.recycler_viewseminarios);

            final RecyclerViewAdapter adapter = new RecyclerViewAdapter(vistaVideo.getContext(), elements);
            GridLayoutManager manager = new GridLayoutManager(vistaVideo.getContext(), 3);
            recyclerViewvideo.setHasFixedSize(true);
            recyclerViewvideo.setLayoutManager(manager);
            recyclerViewvideo.setAdapter(adapter);


            //  progressDialog.dismiss();

            dialog.dismiss();


            //   Buscar(); todo si contiene datos
        }


        // final RecyclerViewAdapter adapter = new RecyclerViewAdapter(datavideocontext, data);

//        recyclerViewvideo.setAdapter(adapter);

        //consultarlistaAsignaturas();


    }

    @Override
    protected void onCancelled(ArrayList resValues) {
        super.onCancelled(resValues);
    }


    public static void setContextVideo(Context context, View rootview) {
        datavideocontext = context;
        vistaVideo = rootview;
    }

    private void Buscar() {

        // Base de Datos Contiene Datos

        AdminSQLVersionSeminario admin = new AdminSQLVersionSeminario(currentContext, "bdversion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();


        String versiondatos = "TOMO 1";


        if (!versiondatos.isEmpty()) {

//            Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM  " + UtilVersion.TABLA_VERSIONSEMINARIO + " WHERE " + UtilVersion.CAMPO_VERSION + "='" + 1.0 + "'", null);

            //Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM  " + UtilVersion.TABLA_VERSIONSEMINARIO + " WHERE " + UtilVersion.CAMPO_NOMBRETOMO + "='" + "TOMO 1" + "'", null);
            Cursor cursor = BaseDeDatos.rawQuery("SELECT * FROM  " + UtilVersion.TABLA_VERSIONSEMINARIO + " WHERE " + UtilVersion.CAMPO_NOMBRETOMO + "='" + tomoversion + "'", null);

            if (cursor.moveToFirst()) {

                tomoversionconsult = cursor.getString(3);
                versiondbconsult = Float.valueOf(cursor.getString(1));

                //Toast.makeText(currentContext, tomoversion + " " + versiondb, Toast.LENGTH_SHORT).show();

                BaseDeDatos.close();
            }
        }
    }


    private void eliminarTomo() {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(currentContext, "bdseminarios", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //Delete from videoseminario where asignatura="Algebra"


        int cantidad = BaseDeDatos.delete("videoseminario", "tomopdf=" + tomoversion, null);
        BaseDeDatos.close();


    }


    private void actualizarVersion() {

        AdminSQLVersionSeminario admin = new AdminSQLVersionSeminario(currentContext, "bdversion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        ContentValues registro = new ContentValues();

        registro.put("codigo", "T0001");
        registro.put("version", versionjson);
        registro.put("urltomo", url);
        registro.put("nombretomo", tomoversion);

        int cantidad = bd.update("tablaversiondb", registro, "tomopdf=" + tomoversion, null);

        bd.close();


    }

    public String checkEmpty() {

        int count = 0;

        AdminSQLiteOpenHelper mDbHelper = new AdminSQLiteOpenHelper(currentContext, "bdseminarios", null, 1);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT count(*) FROM " + Utilidades.TABLA_VIDEOSEMINARIO, null);


        try {
            if (cursor != null)
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    count = cursor.getInt(0);
                }
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        if (count > 0)
            return "Contiene Datos";
        else
            return "No Contiene Datos";


    }

    /*

     if (versioninfo > versiondbconsult) // si la version cambio

    {
        //Borrar  Tomo Seleccionado  y despues  insertar


        eliminarTomo();  //Paso 1  //  ELIMINA TODOS  LOS  REGISTROS  QUE  DICEN TOMO 2


        JSONArray resArray2 = resObject.getJSONArray("listavideo"); // paso 2 LLENA LOS  NUEVOS  DATOS

        for (int idxItem = 0; idxItem < resArray2.length(); idxItem++) {

            JSONObject arrayItem = resArray2.getJSONObject(idxItem);

            ContentValues registro = new ContentValues();
            registro.put(Utilidades.CAMPO_CODIGO, arrayItem.getString("codigo"));
            registro.put(Utilidades.CAMPO_ASIGNATURA, arrayItem.getString("asignatura"));
            registro.put(Utilidades.CAMPO_HABILITAR, arrayItem.getString("habilitar"));
            registro.put(Utilidades.CAMPO_CAPITULO, arrayItem.getString("capitulo"));
            registro.put(Utilidades.CAMPO_URLPDF, arrayItem.getString("urlpdf"));
            registro.put(Utilidades.CAMPO_SSDPDF, arrayItem.getString("ssdpdf"));
            registro.put(Utilidades.CAMPO_TOMOPDF, arrayItem.getString("tomopdf"));
            registro.put(Utilidades.CAMPO_GRADOPDF, arrayItem.getString("gradopdf"));
            registro.put(Utilidades.CAMPO_LISTYOUTUBE, arrayItem.getString("listyoutube"));

            BaseDeDatos.insert("videoseminario", null, registro);

            // resValues = new ArrayList<>();

            JSONObject vListVideo = new JSONObject();

            vListVideo.put("codigo", arrayItem.getString("codigo"));
            vListVideo.put("asignatura", arrayItem.getString("asignatura"));
            vListVideo.put("habilitar", arrayItem.getString("habilitar"));
            vListVideo.put("capitulo", arrayItem.getString("capitulo"));
            vListVideo.put("urlpdf", arrayItem.getString("urlpdf"));
            vListVideo.put("ssdpdf", arrayItem.getString("ssdpdf"));
            vListVideo.put("tomopdf", arrayItem.getString("tomopdf"));
            vListVideo.put("gradopdf", arrayItem.getString("gradopdf"));
            vListVideo.put("listyoutube", arrayItem.getString("listyoutube"));
            resValues.add(vListVideo);
        }

        BaseDeDatos.close();

//     a           ContentValues versionregistro = new ContentValues();
//a
//    a            versionregistro.put("codigo", "G0001");
//    a            versionregistro.put("version", versionjson);
//    a            versionregistro.put("urltomo", urlcontent);
//    a            versionregistro.put("nombretomo", tomoversion);
//
//   a             BDVersion.insert("tablaversiondb", null, versionregistro);
//   a             BDVersion.close();

        actualizarVersion();   //paso 3      // ACTUALIZA  LA VERSION

    } else if(versioninfo == versiondbconsult)
    {
        // SI la version es  igual  tomar  la ssd

    } else  if (estadobd.equalsIgnoreCase("No Contiene Datos"))  //

    {
        JSONArray resArray2 = resObject.getJSONArray("listavideo"); //

        for (int idxItem = 0; idxItem < resArray2.length(); idxItem++) {

            JSONObject arrayItem = resArray2.getJSONObject(idxItem);

            ContentValues registro = new ContentValues();
            registro.put(Utilidades.CAMPO_CODIGO, arrayItem.getString("codigo"));
            registro.put(Utilidades.CAMPO_ASIGNATURA, arrayItem.getString("asignatura"));
            registro.put(Utilidades.CAMPO_HABILITAR, arrayItem.getString("habilitar"));
            registro.put(Utilidades.CAMPO_CAPITULO, arrayItem.getString("capitulo"));
            registro.put(Utilidades.CAMPO_URLPDF, arrayItem.getString("urlpdf"));
            registro.put(Utilidades.CAMPO_SSDPDF, arrayItem.getString("ssdpdf"));
            registro.put(Utilidades.CAMPO_TOMOPDF, arrayItem.getString("tomopdf"));
            registro.put(Utilidades.CAMPO_GRADOPDF, arrayItem.getString("gradopdf"));
            registro.put(Utilidades.CAMPO_LISTYOUTUBE, arrayItem.getString("listyoutube"));

            BaseDeDatos.insert("videoseminario", null, registro);

            // resValues = new ArrayList<>();

            JSONObject vListVideo = new JSONObject();

            vListVideo.put("codigo", arrayItem.getString("codigo"));
            vListVideo.put("asignatura", arrayItem.getString("asignatura"));
            vListVideo.put("habilitar", arrayItem.getString("habilitar"));
            vListVideo.put("capitulo", arrayItem.getString("capitulo"));
            vListVideo.put("urlpdf", arrayItem.getString("urlpdf"));
            vListVideo.put("ssdpdf", arrayItem.getString("ssdpdf"));
            vListVideo.put("tomopdf", arrayItem.getString("tomopdf"));
            vListVideo.put("gradopdf", arrayItem.getString("gradopdf"));
            vListVideo.put("listyoutube", arrayItem.getString("listyoutube"));
            resValues.add(vListVideo);
        }

        BaseDeDatos.close();

        ContentValues versionregistro = new ContentValues();

        versionregistro.put("codigo", "G0001");
        versionregistro.put("version", versionjson);
        versionregistro.put("urltomo", urlcontent);
        versionregistro.put("nombretomo", tomoversion);

        BDVersion.insert("tablaversiondb", null, versionregistro);
        BDVersion.close();

    }



}*/


}