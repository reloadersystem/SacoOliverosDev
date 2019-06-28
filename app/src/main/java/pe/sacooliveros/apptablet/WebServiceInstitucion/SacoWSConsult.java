package pe.sacooliveros.apptablet.WebServiceInstitucion;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import pe.sacooliveros.apptablet.DirectoryCreateUtil;
import pe.sacooliveros.apptablet.EnviarGrado;
import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.ScreenPeriodo;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Thread.sleep;


public class SacoWSConsult extends AsyncTask<String, Integer, String> {


    private RelativeLayout currentLayout;
    private final ArrayList<JSONObject> dataResult = new ArrayList<>();
    private Context currentContext;
    private ProgressBar progressBar;

    String emailalumno;

    String gradonombre;


    String gradonumero;

    String nombreserver;

    String gradoasiste;

    String sedeserver;

    String matriculaserver;

    String ruta;
    String ruta_storage;

    String codigoautenticacion;

    String dnialumno;

    String apellidopaterno;

    String apellidomaterno;


    static String fechaservidor;

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

    public static void fechaserver(String fechaserver) {
        fechaservidor = fechaserver;

    }


    @Override
    protected String doInBackground(String... strings) {

        //urldata("http://pruebasiiaa.sacooliveros.edu.pe:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/obtenerDatos/rcorrea.ti@sacooliveros.edu.pe");

        WebServiceTools wstools = new WebServiceTools();

        String rString = WebServiceTools.requestFromWebService("http://pruebasiiaa.sacooliveros.edu.pe/", 8080, "", strings);


        Log.d("RESPONSE SACO", rString);

        String datoserver = "{\"estado\":true,\"data\":[]}";

//        String [] parts= rString.split(",");
//        String part1 = parts[0]; // 123
//        String part2 = parts[1]; // 654321

//        String datoserver = part2;


        return rString;

    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }

    @Override
    //protected void onPostExecute(String rString) {
    public void onPostExecute(String rString) {
        super.onPostExecute(rString);


        TextView urlview;
        TextView tvlista;


        tvlista = currentLayout.findViewById(R.id.tx_datos_server);
        urlview = currentLayout.findViewById(R.id.tv_urphoto);

        if (rString.equals("{\"estado\":true,\"data\":[]}")) {
            Toast.makeText(currentContext, "ACCESSO SOLO PARA ALUMNOS SACO OLIVEROS", Toast.LENGTH_SHORT).show();
//           Intent intent= new Intent(currentContext, SacoSecurityActivity.class);
//
//           currentContext.startActivity(intent);

        }

        try {
            JSONObject object = new JSONObject(rString);

            //if (object.has(periodo)){
            //
            //
            //fecha_inicio_de_clase, fecha_fin_de_clase
            // guardar share prefenreces  aa-mm-dd
            // }
            //else
            //{ no ingresa al sistema
            //}

            if (object.has("periodo")) {
                boolean hasperiodo = object.has("periodo"); //true
                JSONObject objectItem = new JSONObject(String.valueOf(object.getJSONObject("periodo"))); // "fecha_inicio_de_clase" -> "2019-03-06"  // "fecha_fin_de_clase" -> "2019-12-31"
                Log.e("PERIODO", objectItem.toString()); //"fecha_inicio_de_clase" -> "2019-03-06"


                String fecha_inicio = objectItem.get("fecha_inicio_de_clase").toString();
                String fechafinal = String.valueOf(objectItem.get("fecha_fin_de_clase"));

                //todo PONER LA PANTALLA DE INICIO DE  PERIODO

                String actualfecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // fecha  actual

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                Date date1 = null;
                Date date2 = null;
                Date fechadato = null;

                //persona_apellido_paterno
                //persona_apellido_materno


                try {

                    date1 = sdf.parse(fecha_inicio);
                    date2 = sdf.parse(fechafinal);
                    fechadato = sdf.parse(actualfecha);

                    Boolean periodoinicio = fechadato.before(date1); // 18/03/2019 < 06/03/2019 false
                    Boolean periodofin = fechadato.after(date2); //18/03/2019 > 31/12/2019 false

                    if (periodoinicio || periodofin) {
                        Intent intent = new Intent(currentContext, ScreenPeriodo.class);
                        currentContext.startActivity(intent);
                    } else if (object.has("data")) {

                        //codigo_de_autenticacion nuevo dato

                        JSONArray dataArray = new JSONArray(object.get("data").toString());

                        //tvlista.setText(object.get("data").toString());

                        for (int idx = 0; idx < dataArray.length(); idx++) {
                            JSONObject arrayObject = (JSONObject) dataArray.get(idx);


                            if (arrayObject.has("persona_nombre")) {

                                nombreserver = arrayObject.get("persona_nombre").toString();
                                // tvNombre.setText(arrayObject.get("persona_nombre").toString());
                            }

                            if (arrayObject.has("persona_apellido_paterno")) {
                                apellidopaterno = arrayObject.get("persona_apellido_paterno").toString();
                            }

                            if (arrayObject.has("persona_apellido_materno")) {

                                apellidomaterno = arrayObject.get("persona_apellido_materno").toString();
                            }

                            if (arrayObject.has("persona_correo_direccion")) {

                                emailalumno = arrayObject.get("persona_correo_direccion").toString();

                                // Toast.makeText(currentContext, arrayObject.get("persona_correo_direccion").toString(), Toast.LENGTH_LONG).show();
                                // Log.d("DATOSALUMNOS",arrayObject.get("persona_correo_direccion").toString());
                            }

                            if (arrayObject.has("grado_id")) {

                                final String gradoSel = String.valueOf(arrayObject.get("grado_id"));

                                EnviarGrado enviargrado = new DirectoryCreateUtil();

                                enviargrado.enviargrado(gradoSel);
                            }

                            if (arrayObject.has("grado_nombre")) {
                                gradonombre = arrayObject.get("grado_nombre").toString();
                            }


                            if (arrayObject.has("sede_nombre")) {


                                sedeserver = arrayObject.get("sede_nombre").toString();

                            }


                            if (arrayObject.has("matricula_retirado")) {


                                matriculaserver = arrayObject.get("matricula_retirado").toString();

                            }

                            if (arrayObject.has("numero_grado")) {

                                gradonumero = arrayObject.get("numero_grado").toString();   // 5  (5to  regular )  - 5 (5to Circulo)
                            }

                            if (arrayObject.has("codigo_de_autenticacion")) {
                                codigoautenticacion = arrayObject.get("codigo_de_autenticacion").toString();
                            }

                            if (arrayObject.has("documento")) {
                                dnialumno = arrayObject.get("documento").toString();
                            }


                            if (arrayObject.has("tipo_grado_asiste")) {  //REGULAR //CIRCULO

                                gradoasiste = arrayObject.get("tipo_grado_asiste").toString();
                            }


                            guardarValor(currentContext, "fechainicio_clase", fecha_inicio);
                            guardarValor(currentContext, "fechafin_clase", fechafinal);


                            if (arrayObject.has("nivel_nombre")) {

                                String gradoencurso = arrayObject.get("nivel_nombre").toString();  // Secundaria // Secundaria

                                String servernivel = gradonumero + " " + gradoencurso;

                                Toast.makeText(currentContext, "Alumno " + nombreserver + " " + gradonumero + " " + gradoencurso, Toast.LENGTH_LONG).show();


                                if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CATOLICA"))

                                {

                                    String dataurl = urlview.getText().toString();

                                    Intent intent = new Intent(currentContext, NavActivity.class);

                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);


                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Secundaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);
                                } else if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("SAN MARCOS"))

                                {
                                    String dataurl = urlview.getText().toString();

                                    Intent intent = new Intent(currentContext, NavActivity.class);

                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);

                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Secundaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");



                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);
                                } else if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("UNI"))

                                {

                                    String dataurl = urlview.getText().toString();

                                    Intent intent = new Intent(currentContext, NavActivity.class);

                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);

                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Secundaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);

                                } else if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("Regular") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE"))

                                {
                                    String dataurl;

                                    if(emailalumno.equalsIgnoreCase("rcorrea.ti@sacooliveros.edu.pe"))
                                    {
                                        dataurl="https://lh3.googleusercontent.com/-tdi_1qVRlz8/XL8ToWfBnRI/AAAAAAAAAtY/FdFeDohwhfk9o8psGp_Ud9i2SnMAhSIugCEwYBhgL/w140-h140-p/37155445.jpg";
                                    }else
                                    {
                                        dataurl = urlview.getText().toString();
                                    }


                                    Intent intent = new Intent(currentContext, NavActivity.class);
                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);

                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Secundaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);

                                } else if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CIRCULO"))

                                {
                                    String dataurl = urlview.getText().toString();

                                    Intent intent = new Intent(currentContext, NavActivity.class);
                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);


                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Secundaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);

                                } else if (gradoencurso.equalsIgnoreCase("Primaria") && gradoasiste.equalsIgnoreCase("REGULAR")) {

                                    Intent intent = new Intent(currentContext, NavigatorPrimaria.class);

                                    String dataurl = urlview.getText().toString();

                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);


                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Primaria");
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");

                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);

                                } else if (gradoasiste.equalsIgnoreCase("SELECCION")) {

                                    Intent intent = new Intent(currentContext, CiclosEspeciales.class);

                                    String dataurl = urlview.getText().toString();

                                    intent.putExtra("URLPhoto", dataurl);
                                    intent.putExtra("EMail", emailalumno);
                                    intent.putExtra("NombreUsuario", nombreserver);
                                    intent.putExtra("SedeUsuario", sedeserver);
                                    intent.putExtra("ServerGradoNivel", servernivel);
                                    intent.putExtra("MatriculaServer", matriculaserver);
                                    intent.putExtra("GradoNombre", gradonombre);
                                    intent.putExtra("TipoGradoAsiste", gradoasiste);
                                    intent.putExtra("ApellidoPaterno", apellidopaterno);
                                    intent.putExtra("ApellidoMaterno", apellidomaterno);


                                    guardarValor(currentContext, "GradoNombre", gradonombre);
                                    guardarValor(currentContext, "URLPhoto", dataurl);
                                    guardarValor(currentContext, "EMail", emailalumno);
                                    guardarValor(currentContext, "NombreUsuario", nombreserver);
                                    guardarValor(currentContext, "SedeUsuario", sedeserver);
                                    guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                    guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                    guardarValor(currentContext, "Acceso", "Primaria");
                                    guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                    guardarValor(currentContext, "fechaserver", fechaservidor);
                                    guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                    guardarValor(currentContext, "dniusuario", dnialumno);
                                    guardarValor(currentContext, "contadorDB", "1000000");
                                    guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                    guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                    guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                    currentContext.startActivity(intent);

                                } else


                                    //if (gradoencurso.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("PRE") )

                                    if (gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE"))

                                    {
                                        String dataurl = urlview.getText().toString();

                                        Intent intent = new Intent(currentContext, NavActivity.class);
                                        intent.putExtra("URLPhoto", dataurl);
                                        intent.putExtra("EMail", emailalumno);
                                        intent.putExtra("NombreUsuario", nombreserver);
                                        intent.putExtra("SedeUsuario", sedeserver);
                                        intent.putExtra("ServerGradoNivel", servernivel);
                                        intent.putExtra("MatriculaServer", matriculaserver);
                                        intent.putExtra("TipoGradoAsiste", gradoasiste);
                                        intent.putExtra("GradoNombre", gradonombre);
                                        intent.putExtra("ApellidoPaterno", apellidopaterno);
                                        intent.putExtra("ApellidoMaterno", apellidomaterno);

                                        guardarValor(currentContext, "GradoNombre", gradonombre);
                                        guardarValor(currentContext, "URLPhoto", dataurl);
                                        guardarValor(currentContext, "EMail", emailalumno);
                                        guardarValor(currentContext, "NombreUsuario", nombreserver);
                                        guardarValor(currentContext, "SedeUsuario", sedeserver);
                                        guardarValor(currentContext, "ServerGradoNivel", servernivel);
                                        guardarValor(currentContext, "MatriculaServer", matriculaserver);
                                        guardarValor(currentContext, "Acceso", "Secundaria");
                                        guardarValor(currentContext, "TipoGradoAsiste", gradoasiste);
                                        guardarValor(currentContext, "fechaserver", fechaservidor);
                                        guardarValor(currentContext, "codigo_autenticacion", codigoautenticacion);
                                        guardarValor(currentContext, "dniusuario", dnialumno);
                                        guardarValor(currentContext, "contadorDB", "1000000");
                                        guardarValor(currentContext, "ApellidoPaterno", apellidopaterno);
                                        guardarValor(currentContext, "ApellidoMaterno", apellidomaterno);
                                        guardarValor(currentContext, "CheckOutService", "Inicio Servicio");


                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        currentContext.startActivity(intent);

                                    }

                            }
                        }
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(currentContext);
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Descargando PDF...");

        new DescargarPDFAsynTask(progressDialog).execute(urlADescargar);

    }


    private class DescargarPDFAsynTask extends AsyncTask<String, Integer, String> {

        ProgressDialog progressDialog;

        public DescargarPDFAsynTask(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... urlPDF) {

            HttpURLConnection conexion = null;
            InputStream input = null;
            OutputStream output = null;

            ruta_storage = currentContext.getString(R.string.ruta_raiz);


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();


                String rutaficheroGuardado = ruta_storage + "/shared_prefs/" + ruta;

                output = new FileOutputStream((rutaficheroGuardado));

                int tamanoFichero = conexion.getContentLength();

                byte[] data = new byte[3072];
                int count;
                int total = 0;


                while ((count = input.read(data)) != -1) {

                    sleep(1);
                    output.write(data, 0, count);

                    total += count;
                    publishProgress((int) (total * 100 / tamanoFichero));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Sin Conexion";
            }
            //cerrando la carpeta una vez que termino
            catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (input != null) input.close();
                    //cerrando conexion progress
                    if (output != null) output.close();
                    if (conexion != null) conexion.disconnect();

                    progressDialog.dismiss();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return "Se realizo Correctamente";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            //%de descarga
            super.onProgressUpdate(values);

            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);


        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);


            Toast.makeText(currentContext, mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();


        }
    }


    @Override
    protected void onCancelled(String arrayList) {
        super.onCancelled(arrayList);

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