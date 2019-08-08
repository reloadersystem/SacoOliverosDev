package pe.sacooliveros.apptablet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.VideoView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Seleccion.CiclosEspeciales;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.WebServiceFechaServer.SacoWSFecha;
import pe.sacooliveros.apptablet.WebServiceFechaServer.WebServiceFecha;

public class SplashActivity extends AppCompatActivity {

    String myDeviceModel;
    String Baseband;
    VideoView videoView;
    ConnectionDetector cd;
    static String fechaservidor;
    String actualfecha;
    String box;
    String nombregrado;

    @Override
    protected void onStart() {

        super.onStart();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

//        String dato= obtenerValor(getApplicationContext(), "TipoGradoAsiste");
//
//        if (!dato.equalsIgnoreCase(""))    {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        } else
//        {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }
    }


    public static void fechaserver(String fechaserver) {
        fechaservidor = fechaserver;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        String servidor_ruta = getString(R.string.servidor_ruta);
        String urlcode = servidor_ruta + ":8080/FacturacionElectronicaSIIAA/api/v1/estudiante/consultarFecha";

        cd = new ConnectionDetector(this);

        nombregrado = obtenerValor(getApplicationContext(), "GradoNombre");


        if (!cd.isConnected()) {
            Toast.makeText(this, "Sin Conexión", Toast.LENGTH_LONG).show();
        }


        if (cd.isConnected()) {

            WebServiceFecha.urlvisor(urlcode);
            SacoWSFecha consult = new SacoWSFecha();
            consult.setCurrentContext(this);
            //consult.setCurrentLayout(lnLayout);
            consult.execute("");
        }

        //TODO GUARDAR  ULTIMA FECHA  ACTUALIZADA Y VALIDAR EL INGRESO A LA TABLET CON ESA  FECHA EN CASO QUE NO HAYA  CONEXIÓN

        //String fechaservidor = obtenerValor(getApplicationContext(), fechaservidor);

        Baseband = Build.getRadioVersion(); //versionbase
        myDeviceModel = android.os.Build.MODEL;
        String mySerial = Build.SERIAL;

        String model_device = getString(R.string.modelo_tablet);
        String versionbase_device = getString(R.string.version_base);

        if ((!myDeviceModel.equalsIgnoreCase(model_device)) && (!Baseband.equalsIgnoreCase(versionbase_device))) {
            videoView = findViewById(R.id.video_view);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.video;

            videoView.requestFocus();
            videoView.setVideoURI(Uri.parse(path));
            videoView.animate().alpha(1);
            videoView.seekTo(50);

            videoView.start();
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    Intent intent = new Intent(SplashActivity.this, PresentacionActivity.class);
                    startActivity(intent);
                    finish();
                }
            });

        } else if ((myDeviceModel.equalsIgnoreCase(model_device) && Baseband.equalsIgnoreCase(versionbase_device))) {
            videoView = findViewById(R.id.video_view);
            String path = "android.resource://" + getPackageName() + "/" + R.raw.video;

            videoView.requestFocus();
            videoView.setVideoURI(Uri.parse(path));
            videoView.animate().alpha(1);
            videoView.seekTo(50);

            videoView.start();

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {


                    SharedPreferences sharpref = getSharedPreferences("autenticacionOff", MODE_PRIVATE);

                    if (sharpref.contains("fechainicio_clase")) {

                        //String actualfecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // fecha  actual

                        //fechaservidor
                        actualfecha = fechaservidor;

                        if (fechaservidor == null) {
                            fechaservidor = obtenerValor(getApplicationContext(), "fechaserver");

                            Toast.makeText(SplashActivity.this, "Conexión Off Line - Última Fecha de Ingreso Registrada: " + fechaservidor, Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(SplashActivity.this, fechaservidor, Toast.LENGTH_SHORT).show();
                        }

                        String dato8 = obtenerValor(getApplicationContext(), "fechainicio_clase");
                        String dato9 = obtenerValor(getApplicationContext(), "fechafin_clase");

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                        Date date1 = null;
                        Date date2 = null;
                        Date fechadato = null;

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        Date date = new Date();

                        String fecha = dateFormat.format(date);

                        try {
                            date1 = sdf.parse(dato8);
                            date2 = sdf.parse(dato9);

                            if (actualfecha == null) {
                                actualfecha = obtenerValor(getApplicationContext(), "fechaserver");
                            }

                            fechadato = sdf.parse(actualfecha);

                            Boolean periodoinicio = fechadato.before(date1); // 18/03/2019 < 06/03/2019 false
                            Boolean periodofin = fechadato.after(date2); //18/03/2019 > 31/12/2019 false

                            if (periodoinicio) {
                                Intent intent = new Intent(SplashActivity.this, ScreenPeriodo.class);
                                startActivity(intent);
                            } else if (periodofin) {
                                Intent intent = new Intent(SplashActivity.this, ScreenPeriodo.class);
                                startActivity(intent);
                            } else {
                                String dato = obtenerValor(getApplicationContext(), "EMail");
                                String dato1 = obtenerValor(getApplicationContext(), "ServerGradoNivel");
                                String dato2 = obtenerValor(getApplicationContext(), "SedeUsuario");
                                String dato3 = obtenerValor(getApplicationContext(), "URLPhoto");
                                String dato4 = obtenerValor(getApplicationContext(), "MatriculaServer");
                                String dato5 = obtenerValor(getApplicationContext(), "NombreUsuario");
                                String dato6 = obtenerValor(getApplicationContext(), "Acceso");
                                String dato7 = obtenerValor(getApplicationContext(), "TipoGradoAsiste");


                                SharedPreferences shared = getSharedPreferences("autenticacionOff", MODE_PRIVATE);
                                //if(shared.contains("EMail") && shared.contains("Acceso")){//

                                if (shared.contains("Acceso")) {

                                    if (dato6.equalsIgnoreCase("Primaria") && (dato7.equalsIgnoreCase("REGULAR"))) {
                                        Intent intent = new Intent(getApplicationContext(), NavigatorPrimaria.class);

                                        intent.putExtra("EMail", dato);
                                        intent.putExtra("ServerGradoNivel", dato1);
                                        intent.putExtra("SedeUsuario", dato2);
                                        intent.putExtra("URLPhoto", dato3);
                                        intent.putExtra("MatriculaServer", dato4);
                                        intent.putExtra("NombreUsuario", dato5);

                                        startActivity(intent);

                                        finish();
                                    } else if (dato6.equalsIgnoreCase("Secundaria")
                                            || dato6.equalsIgnoreCase("Secundaria") && dato7.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Cuarto Año")
                                            || dato6.equalsIgnoreCase("Secundaria") && dato7.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")

                                    ) {

                                        Intent intent = new Intent(getApplicationContext(), NavActivity.class);

                                        intent.putExtra("EMail", dato);
                                        intent.putExtra("ServerGradoNivel", dato1);
                                        intent.putExtra("SedeUsuario", dato2);
                                        intent.putExtra("URLPhoto", dato3);
                                        intent.putExtra("MatriculaServer", dato4);
                                        intent.putExtra("NombreUsuario", dato5);
                                        intent.putExtra("TipoGradoAsiste", dato7);

                                        startActivity(intent);
                                        finish();
                                    } else if (dato1.equalsIgnoreCase("601 Secundaria") || dato1.equalsIgnoreCase("701 Secundaria") || dato1.equalsIgnoreCase("601 Primaria")) {

                                        Intent intent = new Intent(getApplicationContext(), CiclosEspeciales.class);

                                        intent.putExtra("EMail", dato);
                                        intent.putExtra("ServerGradoNivel", dato1);
                                        intent.putExtra("SedeUsuario", dato2);
                                        intent.putExtra("URLPhoto", dato3);
                                        intent.putExtra("MatriculaServer", dato4);
                                        intent.putExtra("NombreUsuario", dato5);
                                        intent.putExtra("TipoGradoAsiste", dato7);

                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        String dato = obtenerValor(getApplicationContext(), "EMail");
                        String dato1 = obtenerValor(getApplicationContext(), "ServerGradoNivel");
                        String dato2 = obtenerValor(getApplicationContext(), "SedeUsuario");
                        String dato3 = obtenerValor(getApplicationContext(), "URLPhoto");
                        String dato4 = obtenerValor(getApplicationContext(), "MatriculaServer");
                        String dato5 = obtenerValor(getApplicationContext(), "NombreUsuario");
                        String dato6 = obtenerValor(getApplicationContext(), "Acceso");
                        String dato7 = obtenerValor(getApplicationContext(), "TipoGradoAsiste");

                        SharedPreferences shared = getSharedPreferences("autenticacionOff", MODE_PRIVATE);
                        //if(shared.contains("EMail") && shared.contains("Acceso")){//


                        if (shared.contains("Acceso")) {

                            if (dato6.equalsIgnoreCase("Primaria") || dato7.equalsIgnoreCase("REGULAR")) {
                                Intent intent = new Intent(getApplicationContext(), NavigatorPrimaria.class);

                                intent.putExtra("EMail", dato);
                                intent.putExtra("ServerGradoNivel", dato1);
                                intent.putExtra("SedeUsuario", dato2);
                                intent.putExtra("URLPhoto", dato3);
                                intent.putExtra("MatriculaServer", dato4);
                                intent.putExtra("NombreUsuario", dato5);

                                startActivity(intent);

                                finish();
                            } else if (dato6.equalsIgnoreCase("Secundaria")
                                    || dato6.equalsIgnoreCase("Secundaria") && dato7.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Cuarto Año")
                                    || dato6.equalsIgnoreCase("Secundaria") && dato7.equalsIgnoreCase("PRE") && nombregrado.equalsIgnoreCase("Quinto Año")
                            ) {

                                Intent intent = new Intent(getApplicationContext(), NavActivity.class);

                                intent.putExtra("EMail", dato);
                                intent.putExtra("ServerGradoNivel", dato1);
                                intent.putExtra("SedeUsuario", dato2);
                                intent.putExtra("URLPhoto", dato3);
                                intent.putExtra("MatriculaServer", dato4);
                                intent.putExtra("NombreUsuario", dato5);
                                intent.putExtra("TipoGradoAsiste", dato7);

                                startActivity(intent);

                                finish();
                            }

                        } else {

                            Intent intent = new Intent(SplashActivity.this, Publicidad.class);
                            startActivity(intent);
                            finish();

                        }
                    }

                }
            });

        }


    }


    static String PREFS_KEY = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getApplicationContext(), box);

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
