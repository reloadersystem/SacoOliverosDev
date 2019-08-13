package pe.sacooliveros.apptablet.Secundaria;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.tasks.OnSuccessListener;
import com.google.android.play.core.tasks.Task;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.math.BigDecimal;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.sacooliveros.apptablet.Authenticacion.firebaseAuth;
import pe.sacooliveros.apptablet.Balotario.BalotarioMenuActivity;
import pe.sacooliveros.apptablet.ConfigFragment;
import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.DescargasFragment;
import pe.sacooliveros.apptablet.DescargasHistorial.checkDescargasFragment;
import pe.sacooliveros.apptablet.DirectoryCreateUtil;
import pe.sacooliveros.apptablet.DirectoryUtilCatolica;
import pe.sacooliveros.apptablet.DirectoryUtilPRE;
import pe.sacooliveros.apptablet.DirectoryUtilSM;
import pe.sacooliveros.apptablet.DirectoryUtilUNI;
import pe.sacooliveros.apptablet.Primaria.fragments.ajedrezFragment;
import pe.sacooliveros.apptablet.QuintoCatolica.Fragment.fragment_TCatolica_Seminario;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.CapitulosAdmisionfragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.SimulacrosUNIFragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.examenAnualFragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.VideoMotivadoresFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.contentFisicaFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentComputacion;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentEnglish;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentHDiapositivas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentMotivadores;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPFMatematica;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPropuestos;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentResueltosProblemas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentTVSeminario;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentVSeminario;
import pe.sacooliveros.apptablet.ServiceVersion.SConsultVersion;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.Utils.ValidateCopyright;
import pe.sacooliveros.apptablet.ViewTomo3Activity;
import pe.sacooliveros.apptablet.comunicador;

import static android.os.Environment.getExternalStorageDirectory;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, comunicador {

    static String PREFS_KEY = "autenticacionOff";

    InitialFragment initialFragment;
    String emailogin = "";
    String emailjson = "";
    String urlphoto = "";
    String viewType = "";
    String emailserver;
    String sedeserver;
    String usuarioserver;
    String servernivel;
    String matricularserver;
    String gradoasiste;
    int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1;
    int MY_PERMISSIONS_REQUEST_TELEPHONE = 2;
    int MY_PERMISSIONS_REQUEST_UBICACION = 3;
    String sharedata;
    mainFragmentUni mainFragmentuni;
    String appName;
    String packageName;
    String box;
    static String updateapk;
    ConnectionDetector cd;
    static String nivelacceso;

    //String FLURRY_API_KEY = "P6MNPWQCTST6XZJ5KN9Y";

    String gradonombre;
    String apellidopaterno, apellidomaterno;
    GoogleApiClient mGoogleApiClient;
    DrawerLayout drawer;
    String versionapkbase;
    String urlfotoalumno;
    BigDecimal updateapkcode;

    //autoUpdate
    private static final int REQ_CODE_VERSION_UPDATE = 530;
    private AppUpdateManager appUpdateManager;
    private InstallStateUpdatedListener installStateUpdatedListener;
    private static final String TAG = "VERIFY_UPDATE";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        // android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }

    public static void apkversion(String updateversionapk) {

        updateapk = updateversionapk;
    }


    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        checkForAppUpdate();

        final ValidateCopyright validateCopyright = new ValidateCopyright(getApplicationContext());
        validateCopyright.isvalidate();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = this.getIntent().getExtras();
            emailogin = bundle.getString("UsuarioMail");
            emailjson = bundle.getString("UsuarioJson");
            urlphoto = bundle.getString("PerfilFoto");
            viewType = bundle.getString("ViewType");
            emailserver = bundle.getString("EMail");
            usuarioserver = bundle.getString("NombreUsuario");
            sedeserver = bundle.getString("SedeUsuario");
            servernivel = bundle.getString("ServerGradoNivel"); //2 Secundaria
            matricularserver = bundle.getString("MatriculaServer");
            gradoasiste = bundle.getString("TipoGradoAsiste");
            apellidopaterno = bundle.getString("ApellidoPaterno");
            apellidomaterno = bundle.getString("ApellidoMaterno");
        }

        cd = new ConnectionDetector(getApplicationContext());
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        urlfotoalumno = ShareDataRead.obtenerValor(getApplicationContext(), "URLPhoto");
        String codigoAuth = ShareDataRead.obtenerValor(getApplicationContext(), "codigo_autenticacion");

        //todo servicio que envia  codigo autenticacion y  versiontablet

        String validacionAutenticacion = ShareDataRead.obtenerValor(getApplicationContext(), "EstadoAuthentication");

        //CheckOutService

//        if (validacionAutenticacion.equalsIgnoreCase("true")) {
//
//


        String consultarServicio = ShareDataRead.obtenerValor(getApplicationContext(), "CheckOutService");

        versionapkbase = getVersionName(getApplicationContext());

        if (cd.isConnected()) {

            if (consultarServicio.equalsIgnoreCase("Inicio Servicio")) {

                SConsultVersion consultversion = new SConsultVersion("http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/validarVersionAplicativo/" + codigoAuth + "/" + versionapkbase);
                consultversion.setCurrentContext(this);
                consultversion.setCurrentLayout(drawer);
                consultversion.execute();

            } else if (consultarServicio.equalsIgnoreCase("Servicio Finalizado")) {
                guardarValor(getApplicationContext(), "CheckOutService", "");
                SConsultVersion consultversion = new SConsultVersion("http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/validarVersionAplicativo/" + codigoAuth + "/" + versionapkbase);
                consultversion.setCurrentContext(this);
                consultversion.setCurrentLayout(drawer);
                consultversion.execute();
            }
        }

//        if (cd.isConnected()) {
//            if (codigoAuth.equalsIgnoreCase("null") || codigoAuth.equalsIgnoreCase("")) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(NavActivity.this);
//                builder.setTitle("Codigo de Authenticación");
//                builder.setMessage("Ingresa tu Código de Autenticación - que está al reverso de tu Tablet");
//                builder.setIcon(R.drawable.icono_saco);
//                final EditText input = new EditText(this);
//                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
//                builder.setView(input);
//
//                builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//
//                        String m_Text = input.getText().toString();
//
//                        //http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/consultarCorreo/"+txtDni+"/"+txtCodigo
//                        String dnialumno = ShareDataRead.obtenerValor(getApplicationContext(), "dniusuario");
//
//                        SConsultAuthenticacion consultAuth = new SConsultAuthenticacion("http://172.16.2.40:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/consultarCorreo/" + dnialumno + "/" + m_Text);
//                        consultAuth.setCurrentContext(getApplicationContext());
//                        consultAuth.setCurrentLayout(drawer);
//                        consultAuth.execute();
//
////                    http://192.169.218.177:8080/FacturacionElectronicaSIIAA/api/v1/estudiante/consultarCorreo/"+txtDni+"/"+txtCodigo
//                    }
//                });
//                builder.setNegativeButton("Después", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.dismiss();
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();
//            }
//        }


        //guardarValor(getApplicationContext(), "CerrarSesion", "False");   //todo prueba cerrar sesion

        gradonombre = ShareDataRead.obtenerValor(getApplicationContext(), "GradoNombre");

        if (servernivel == null) {
            servernivel = ShareDataRead.obtenerValor(getApplicationContext(), "ServerGradoNivel");
        }

        nivelacceso = String.valueOf(servernivel.charAt(0));//2

        String niveltexto = servernivel.substring(2, 12);

        boolean isAppInstalled2 = isPackageInstalled("com.adobe.reader", this.getPackageManager());

//        if (updateapk == null) {
//            updateapk = Double.valueOf("2.1440");
//        }

/*   todo Desactivando la funcionalidad de actualizar desde el servidor o firebase linea 332-365

        if (cd.isConnected() && updateapk != null) {

            BigDecimal versionapk = new BigDecimal(getVersionName(getApplicationContext()));
            updateapkcode = new BigDecimal(updateapk);

            if (updateapkcode.compareTo(versionapk) > 0) {

                AlertDialog.Builder builder = new AlertDialog.Builder(NavActivity.this);
                builder.setTitle("Nueva Versión Disponible");
                builder.setMessage("Versión " + updateapkcode.toString() + "  está disponible en Google Play Store ¿Deseas Actualizar Ahora?");
                builder.setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        final String appPackageName = getPackageName();
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });

                builder.setNegativeButton("Después", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }*/

        if (!isAppInstalled2) {

            AlertDialog alertDialog = new AlertDialog.Builder(NavActivity.this).create();
            alertDialog.setTitle("Adobe Acrobat Reader");
            alertDialog.setIcon(R.drawable.logoadobe);
            alertDialog.setMessage("¿Permitir a Saco Oliveros - Plataforma Virtual pueda instalar Adobe Acrobat Reader a tu dispositivo?");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            appName = "Gmail";
                            packageName = "com.adobe.reader";
                            box = "com.adobe.reader";

                            openApp(getApplicationContext(), appName, packageName);

                            PackageManager manager = NavActivity.this.getPackageManager();
                            PackageInfo info = null;
                            try {
                                info = manager.getPackageInfo(packageName, 0);
                                Toast.makeText(NavActivity.this,
                                        "PackageName = " + info.packageName + "\nVersionCode = "
                                                + info.versionCode + "\nVersionName = "
                                                + info.versionName + "\nPermissions = " + info.permissions, Toast.LENGTH_SHORT).show();
                            } catch (PackageManager.NameNotFoundException e) {
                                e.printStackTrace();
                            }


                            //dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }

        int verificarPermisoWrite = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int verificarPermisoPhone = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int verificarPermisoUbicacion = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (verificarPermisoWrite != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                solicitarPermiso(); // sino  ha aceptado los  permisos
            } else
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

            if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("Regular") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file);// validar  que no haya  carpetas creadas

                //Environment.getExternalStorageDirectory() + "/SacoOliveros/" + namedescarga + ".pdf"

                //File balotariospdf = new File( Environment.getExternalStorageDirectory()+"/download/", "Balotarios-Saco-Oliveros");

                DirectoryCreateUtil directoryCreate = new DirectoryCreateUtil();

                directoryCreate.verResourceString(this);

                String data = String.valueOf(getFilesDir());

                Log.d("RUTA_APP", data);

                if (gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
                    servernivel = "5 Secundaria";
                }

                directoryCreate.verGradoSec(servernivel);

                directoryCreate.createCarpetas(getFilesDir() + "/APP");


            } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("UNI")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilUNI directoryUtilUNI = new DirectoryUtilUNI();
                directoryUtilUNI.verResourceString(this);
                String data2 = String.valueOf(getFilesDir());
                Log.d("RUTA_APP", data2);
                directoryUtilUNI.verGradoSec(servernivel);
                directoryUtilUNI.createCarpetas(getFilesDir() + "/APP");

            } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("SAN MARCOS")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilSM directoryUtilSM = new DirectoryUtilSM();
                directoryUtilSM.verResourceString(this);
                String data2 = String.valueOf(getFilesDir());
                Log.d("RUTA_APP", data2);
                directoryUtilSM.verGradoSec(servernivel);
                directoryUtilSM.createCarpetas(getFilesDir() + "/APP");

            } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CATOLICA")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilCatolica directoryUtilCatolica = new DirectoryUtilCatolica();
                directoryUtilCatolica.verResourceString(this);
                String data2 = String.valueOf(getFilesDir());
                Log.d("RUTA_APP", data2);

                directoryUtilCatolica.verGradoSec(servernivel);
                directoryUtilCatolica.createCarpetas(getFilesDir() + "/APP");

            } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilPRE directoryutilpre = new DirectoryUtilPRE();
                directoryutilpre.verResourceString(this);
                String data2 = String.valueOf(getFilesDir());
                Log.d("RUTA_APP", data2);
                directoryutilpre.verGradoSec(servernivel);
                directoryutilpre.createCarpetas(getFilesDir() + "/APP");
            }

            if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CIRCULO")) {
                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas


                DirectoryCreateUtil directoryCreate = new DirectoryCreateUtil();

                directoryCreate.verResourceString(this);

                String data = String.valueOf(getFilesDir());

                Log.d("RUTA_APP", data);

                directoryCreate.verGradoSec(servernivel);
                directoryCreate.createCarpetas(getFilesDir() + "/APP");
            }

        } else {

            String sesiondata = ShareDataRead.obtenerValor(getApplicationContext(), "CerrarSesion");

            if (sesiondata.equalsIgnoreCase("True")) {


                //todo si cierra sesion eliminar  estadoversion o ponerlo a  false

                guardarValor(getApplicationContext(), "CerrarSesion", "False");


                if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CATOLICA")) {

                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas


                    DirectoryUtilCatolica directoryUtilCatolica = new DirectoryUtilCatolica();
                    directoryUtilCatolica.verResourceString(this);
                    directoryUtilCatolica.verGradoSec(servernivel);
                    directoryUtilCatolica.createCarpetas(getFilesDir() + "/APP");
                }

                if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("Regular") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE")) {

                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File filecachepdf = new File(getExternalStorageDirectory() + "/PDFiles/");
                    deleteRecursive(filecachepdf);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas

                    //File balotariospdf = new File( Environment.getExternalStorageDirectory()+"/download/", "Balotarios-Saco-Oliveros");

                    File filesaco = new File(Environment.getExternalStorageDirectory() + "/SacoOliveros/");
                    deleteRecursive(filesaco);
//                    filesaco.mkdir();


                    DirectoryCreateUtil directoryCreate = new DirectoryCreateUtil();

                    directoryCreate.verResourceString(this);

                    String data = String.valueOf(getFilesDir());

                    Log.d("RUTA_APP", data);

                    directoryCreate.verGradoSec(servernivel);

                    directoryCreate.createCarpetas(getFilesDir() + "/APP");


                } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("UNI")) {


                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas


                    DirectoryUtilUNI directoryUtilUNI = new DirectoryUtilUNI();
                    directoryUtilUNI.verResourceString(this);
                    directoryUtilUNI.verGradoSec(servernivel);
                    directoryUtilUNI.createCarpetas(getFilesDir() + "/APP");

                } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("SAN MARCOS")) {

                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas


                    DirectoryUtilSM directoryUtilSM = new DirectoryUtilSM();
                    directoryUtilSM.verResourceString(this);
                    directoryUtilSM.verGradoSec(servernivel);
                    directoryUtilSM.createCarpetas(getFilesDir() + "/APP");


                } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {

                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas


                    DirectoryUtilPRE directoryutilpre = new DirectoryUtilPRE();
                    directoryutilpre.verResourceString(this);
                    directoryutilpre.verGradoSec(servernivel);
                    directoryutilpre.createCarpetas(getFilesDir() + "/APP");

                } else if (niveltexto.equalsIgnoreCase("Secundaria") && gradoasiste.equalsIgnoreCase("CIRCULO")) {

                    File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                    deleteRecursive(filecache);

                    File file = new File(getFilesDir() + "/APP");
                    deleteRecursive(file); // validar  que no haya  carpetas creadas

                    DirectoryCreateUtil directoryCreate = new DirectoryCreateUtil();

                    directoryCreate.verResourceString(this);

                    String data = String.valueOf(getFilesDir());

                    Log.d("RUTA_APP", data);

                    directoryCreate.verGradoSec(servernivel);

                    directoryCreate.createCarpetas(getFilesDir() + "/APP");
                }
            }
        }


        if (verificarPermisoPhone != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_PHONE_STATE)) {
                solicitarPermisoPhone();
            } else
                requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_TELEPHONE);
        }


        if (verificarPermisoUbicacion != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                solicitarPermisoUbicacion();
            } else
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_UBICACION);
        }

        boolean isAppInstalled = isPackageInstalled("com.ispringsolutions.mplayer", this.getPackageManager());


        if (!isAppInstalled) {

            AlertDialog alertDialog = new AlertDialog.Builder(NavActivity.this).create();
            alertDialog.setTitle("iSpring Play");
            alertDialog.setIcon(R.drawable.unnamed);
            alertDialog.setMessage("¿Permitir a Saco Oliveros - Plataforma Virtual pueda instalar iSpring Play a tu dispositivo?");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            appName = "Gmail";
                            packageName = "com.ispringsolutions.mplayer";

                            box = "com.ispringsolutions.mplayer";


                            openApp(getApplicationContext(), appName, packageName);

                            //dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }


        InitialFragment.instantiate(servernivel);

        if (gradoasiste == null) {
            sharedata = ShareDataRead.obtenerValor(getApplicationContext(), "TipoGradoAsiste");
            gradoasiste = sharedata;
        }

//        FragmentManager fragmentManager= getSupportFragmentManager();
//
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//        FragmentA fragmentA= new FragmentA();
//        transaction.add(R.id.frame, fragmentA);
//        transaction.addToBackStack("fragmentA");
//        transaction.commit();

        if (gradoasiste.equalsIgnoreCase("UNI")) {

            mainFragmentuni = new mainFragmentUni();

            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction ftransaction = fmanager.beginTransaction();
            ftransaction.add(R.id.contenedorFragments, mainFragmentuni);
            ftransaction.commit();


        } else if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
            initialFragment = new InitialFragment();

            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction ftransaction = fmanager.beginTransaction();
            ftransaction.add(R.id.contenedorFragments, initialFragment);
            ftransaction.commit();

        } else if (gradoasiste.equalsIgnoreCase("SAN MARCOS")) {

            mainFragmentuni = new mainFragmentUni();
            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction ftransaction = fmanager.beginTransaction();
            ftransaction.add(R.id.contenedorFragments, mainFragmentuni);
            ftransaction.commit();

        } else if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

//            FragmentManager fragmentManager= getSupportFragmentManager();
//
//            FragmentTransaction transaction = fragmentManager.beginTransaction();
//
//            FragmentA fragmentA= new FragmentA();
//            transaction.add(R.id.frame, fragmentA);
//            transaction.addToBackStack("fragmentA");
//            transaction.commit();


            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction ftransaction = fmanager.beginTransaction();
            mainFragmentuni = new mainFragmentUni();
            ftransaction.add(R.id.contenedorFragments, mainFragmentuni);
            ftransaction.addToBackStack("mainfragmentuni");
            ftransaction.commit();

        } else if (gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {

            mainFragmentuni = new mainFragmentUni();
            FragmentManager fmanager = getSupportFragmentManager();
            FragmentTransaction ftransaction = fmanager.beginTransaction();
            ftransaction.add(R.id.contenedorFragments, mainFragmentuni);
            ftransaction.commit();

        }


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView txtEmail = navigationView.getHeaderView(0).findViewById(R.id.emailNavigator);
        final CircleImageView imageView = navigationView.getHeaderView(0).findViewById(R.id.imageNavigator);
        //Picasso.get().load(fotoserver).into(imageView);


        //  String datamail = ShareDataRead.obtenerValor(getApplicationContext(), "EMail").substring(0, 1);

//        if (datamail.equalsIgnoreCase("e") || datamail.equalsIgnoreCase("a")) {
//            Menu nav_Menu = navigationView.getMenu();
//            nav_Menu.findItem(R.id.nav_cerrarsesion).setVisible(false);
//        }


        String tipogradovisible = ShareDataRead.obtenerValor(getApplicationContext(), "TipoGradoAsiste");
        String gradovisible = ShareDataRead.obtenerValor(getApplicationContext(), "GradoNombre");

        if (tipogradovisible.equalsIgnoreCase("PRE") && gradovisible.equalsIgnoreCase("Quinto Año") || tipogradovisible.equalsIgnoreCase("UNI") || tipogradovisible.equalsIgnoreCase("CATOLICA") || tipogradovisible.equalsIgnoreCase("SAN MARCOS")) {
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_ppropuestos).setVisible(false);
            nav_Menu.findItem(R.id.nav_presueltos).setVisible(false);
            nav_Menu.findItem(R.id.nav_computacion).setVisible(false);
            nav_Menu.findItem(R.id.nav_hbalotario).setVisible(false);


            nav_Menu.findItem(R.id.nav_eadanual).setVisible(true);
            nav_Menu.findItem(R.id.nav_eadcap).setVisible(true);
            nav_Menu.findItem(R.id.nav_eadsimulacro).setVisible(true);
        }

        if (tipogradovisible.equalsIgnoreCase("CATOLICA")) {
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_compendios).setVisible(false);
        }

        String servergradolvl = ShareDataRead.obtenerValor(getApplicationContext(), "ServerGradoNivel");


        if (tipogradovisible.equalsIgnoreCase("PRE") && gradovisible.equalsIgnoreCase("Cuarto Año") || tipogradovisible.equalsIgnoreCase("REGULAR") && servergradolvl.equalsIgnoreCase("5 Secundaria")) {
            Menu nav_Menu = navigationView.getMenu();
            nav_Menu.findItem(R.id.nav_computacion).setVisible(false);
        }


        // txtEmail.setText(emailserver);

        ConnectionDetector cd = new ConnectionDetector(this);


        if (cd.isConnected()) {

            Picasso.get().load(urlfotoalumno).into(imageView);

//        } else {
//            File imageFile = new File("/data/user/0/pe.sacooliveros.apptablet/app_imagen/googleimg.jpg");
//
//            if (imageFile.exists()) {
//
//                imageView.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
//
//            }
        }

        txtEmail.setText(emailserver);

    }

    private void checkForAppUpdate() {
        // Creates instance of the manager.
        appUpdateManager = AppUpdateManagerFactory.create(getApplicationContext());

        // Returns an intent object that you use to check for an update.
        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();

        // Create a listener to track request state updates.
        installStateUpdatedListener = new InstallStateUpdatedListener() {
            @Override
            public void onStateUpdate(InstallState installState) {
                // Show module progress, log state, or install the update.
                if (installState.installStatus() == InstallStatus.DOWNLOADED)
                    // After the update is downloaded, show a notification
                    // and request user confirmation to restart the app.
                    popupSnackbarForCompleteUpdateAndUnregister();
            }
        };

        // Checks that the platform will allow the specified type of update.

        appUpdateInfoTask.addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
            @Override
            public void onSuccess(AppUpdateInfo appUpdateInfo) {
                if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                    // Request the update.
                    if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {

                        // Before starting an update, register a listener for updates.
                        appUpdateManager.registerListener(installStateUpdatedListener);
                        // Start an update.
                        startAppUpdateFlexible(appUpdateInfo);
                    } else if (appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)) {
                        // Start an update.
                        startAppUpdateImmediate(appUpdateInfo);
                    }
                }
            }
        });
    }

    private void startAppUpdateImmediate(AppUpdateInfo appUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    AppUpdateType.IMMEDIATE,
                    // The curren
                    this,
                    // Include a request code to later monitor this update request.
                    NavActivity.REQ_CODE_VERSION_UPDATE);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    private void startAppUpdateFlexible(AppUpdateInfo appUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    AppUpdateType.FLEXIBLE,
                    // The current activity making the update request.
                    this,
                    // Include a request code to later monitor this update request.
                    NavActivity.REQ_CODE_VERSION_UPDATE);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
            unregisterInstallStateUpdListener();
        }
    }

    private void popupSnackbarForCompleteUpdateAndUnregister() {
        Snackbar snackbar =
                Snackbar.make(findViewById(R.id.drawer_layout), "New app is Ready", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("Install", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appUpdateManager.completeUpdate();
            }
        });
        snackbar.setActionTextColor(getResources().getColor(R.color.accent));
        snackbar.show();

        unregisterInstallStateUpdListener();
    }

    private void checkNewAppVersionState() {
        appUpdateManager
                .getAppUpdateInfo()
                .addOnSuccessListener(new OnSuccessListener<AppUpdateInfo>() {
                    @Override
                    public void onSuccess(AppUpdateInfo appUpdateInfo) {
                        //FLEXIBLE:
                        // If the update is downloaded but not installed,
                        // notify the user to complete the update.
                        if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                            popupSnackbarForCompleteUpdateAndUnregister();
                        }

                        //IMMEDIATE:
                        if (appUpdateInfo.updateAvailability()
                                == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
                            // If an in-app update is already running, resume the update.
                            startAppUpdateImmediate(appUpdateInfo);
                        }
                    }
                });
    }

    private void unregisterInstallStateUpdListener() {
        if (appUpdateManager != null && installStateUpdatedListener != null)
            appUpdateManager.unregisterListener(installStateUpdatedListener);
    }

    private void solicitarPermisoUbicacion() {

        new AlertDialog.Builder(this)
                .setTitle("Autorización")
                .setMessage("Necesito permiso de Ubicación")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_UBICACION);
                    }

                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }

    private void solicitarPermisoPhone() {

        new AlertDialog.Builder(this)
                .setTitle("Autorización")
                .setMessage("Necesito permiso para Acceso a funciones de la Tablet")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE}, MY_PERMISSIONS_REQUEST_TELEPHONE);

                    }


                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        //FlurryAgent.onEndSession(this);

    }

    private void solicitarPermiso() {


        new AlertDialog.Builder(this)
                .setTitle("Autorización")
                .setMessage("Necesito permiso para Almacenar Archivos")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

                        File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                        deleteRecursive(filecache);

                        File file = new File(getFilesDir() + "/APP");
                        deleteRecursive(file); // validar  que no haya  carpetas creadas

                        DirectoryCreateUtil directoryCreate = new DirectoryCreateUtil();

                        directoryCreate.verResourceString(getApplicationContext());

                        String data = String.valueOf(getFilesDir());

                        Log.d("RUTA_APP", data);


                        directoryCreate.createCarpetas(getFilesDir() + "/APP");


                        directoryCreate.createCarpetas(data + "/APP");

                    }


                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();


    }

    @Override
    public void onBackPressed() {


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);

        String datoshare = ShareDataRead.obtenerValor(getApplicationContext(), "TipoGradoAsiste");

        if (datoshare.equalsIgnoreCase("PRE")) {
            menu.findItem(R.id.action_simulacro).setVisible(true);
        }


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        String datoshare = ShareDataRead.obtenerValor(getApplicationContext(), "TipoGradoAsiste");


        if (id == R.id.simulacropdf) {

            //4to pre y 5to pre
            //SolucionarioSimulacroMensual


            if (gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {
                if (cd.isConnected()) {

                    String URL = "http://tablet.sacooliveros.edu.pe/APP/Simulacro4toPre.pdf ";

                    Intent intent = new Intent(getApplicationContext(), ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "Simulacro Mensual");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                }
            } else if (gradonombre.equalsIgnoreCase("Quinto Año") && datoshare.equalsIgnoreCase("PRE")) {
                if (cd.isConnected()) {

                    String URL = "http://tablet.sacooliveros.edu.pe/APP/Simulacro5toPre.pdf";

                    Intent intent = new Intent(getApplicationContext(), ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "Simulacro Mensual");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                }
            }
        }


        if (id == R.id.solucionariopdf) {

            //4to pre y 5to pre
            //SolucionarioSimulacroMensual

            if (gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {
                if (cd.isConnected()) {

                    String URL = "http://tablet.sacooliveros.edu.pe/APP/Solucionario4toPre.pdf";

                    Intent intent = new Intent(getApplicationContext(), ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "Solucionario Mensual");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                }

            } else if (gradonombre.equalsIgnoreCase("Quinto Año") && datoshare.equalsIgnoreCase("PRE")) {

                if (cd.isConnected()) {

                    String URL = "http://tablet.sacooliveros.edu.pe/APP/Solucionario5toPre.pdf";

                    Intent intent = new Intent(getApplicationContext(), ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", URL);
                    intent.putExtra("Materia", "Solucionario Mensual");
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                }

            }

        }


        if (id == R.id.action_opcionB) {


            if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {
                Fragment fragment = new InitialFragment();
                FragmentManager fmanager = this.getSupportFragmentManager();
                if (fmanager != null) {
                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {
                Fragment fragment = new mainFragmentUni();
                FragmentManager fmanager = this.getSupportFragmentManager();
                if (fmanager != null) {
                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }


        }


        if (id == R.id.descargas_tablet) {

//            Fragment fragment = new DescargasFragment();
//            FragmentManager fmanager = this.getSupportFragmentManager();
//            if (fmanager != null) {
//
//                Bundle args = new Bundle();
//                args.putString("ACCESO", nivelacceso);
//                fragment.setArguments(args);
//
//                FragmentTransaction ftransaction = fmanager.beginTransaction();
//                if (ftransaction != null) {
//                    ftransaction.replace(R.id.contenedorFragments, fragment);
//                    ftransaction.addToBackStack("");
//                    ftransaction.commit();
//                }
//            }

            Fragment fragment = new checkDescargasFragment();
            FragmentManager fmanager = this.getSupportFragmentManager();
            if (fmanager != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment.setArguments(args);

                FragmentTransaction ftransaction = fmanager.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }
        }


        if (id == R.id.identificador_tablet) {


            Fragment fragment = new ConfigFragment();
            FragmentManager fmanager = this.getSupportFragmentManager();
            if (fmanager != null) {

                Bundle args = new Bundle();
                args.putString("UsuarioJson", emailjson);
                args.putString("UsuarioMail", emailserver);
                args.putString("SedeUsuario", sedeserver);
                args.putString("NombreUsuario", usuarioserver);
                args.putString("ServerGradoNivel", servernivel);
                args.putString("MatriculaServer", matricularserver);
                args.putString("TipoGradoAsiste", gradoasiste);
                args.putString("ApellidoPaterno", apellidopaterno);
                args.putString("ApellidoMaterno", apellidomaterno);

                fragment.setArguments(args);

                FragmentTransaction ftransaction = fmanager.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }

        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String gradonombre = ShareDataRead.obtenerValor(getApplicationContext(), "GradoNombre");
        String datoshare = ShareDataRead.obtenerValor(getApplicationContext(), "TipoGradoAsiste");

        if (id == R.id.nav_home) {


            if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {

                Fragment fragment = new InitialFragment();
                FragmentManager fmanager = this.getSupportFragmentManager();
                if (fmanager != null) {
                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment.setArguments(args);
                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {
                Fragment fragment = new mainFragmentUni();
                FragmentManager fmanager = this.getSupportFragmentManager();
                if (fmanager != null) {
                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment.setArguments(args);
                    FragmentTransaction ftransaction = fmanager.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }


        } else if (id == R.id.nav_hmotivadores) {

            Fragment fragment = new VideoMotivadoresFragment();
            FragmentManager fmanager = this.getSupportFragmentManager();
            if (fmanager != null) {

                Bundle args = new Bundle();

                args.putString("ACCESO", nivelacceso);
                fragment.setArguments(args);

                FragmentTransaction ftransaction = fmanager.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment);

                    ftransaction.addToBackStack("");

                    ftransaction.commit();
                }


            }

        } else if (id == R.id.nav_ppropuestos) {

            if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {
                Fragment fragment2 = new fragmentPropuestos();
                FragmentManager fmanager2 = this.getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {
                Toast.makeText(this, "Material no Disponible", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_compendios) {

            Fragment fragment4 = new fragmentMotivadores();
            FragmentManager fmanager4 = this.getSupportFragmentManager();
            if (fmanager4 != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment4.setArguments(args);

                FragmentTransaction ftransaction = fmanager4.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment4);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }


        } else if (id == R.id.nav_henglish) {

            Fragment fragment3 = new fragmentEnglish();
            FragmentManager fmanager3 = this.getSupportFragmentManager();
            if (fmanager3 != null) {

                Bundle args = new Bundle();

                args.putString("ACCESO", nivelacceso);
                fragment3.setArguments(args);

                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment3);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }
        } else if (id == R.id.nav_computacion) {

            if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {
                Fragment fragment8 = new fragmentComputacion();
                FragmentManager fmanager8 = this.getSupportFragmentManager();
                if (fmanager8 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment8.setArguments(args);

                    FragmentTransaction ftransaction = fmanager8.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment8);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {
                Toast.makeText(this, "Material no Disponible", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_hdiapositivas) {

            Fragment fragment5 = new fragmentHDiapositivas();
            FragmentManager fmanager5 = this.getSupportFragmentManager();
            if (fmanager5 != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment5.setArguments(args);

                FragmentTransaction ftransaction = fmanager5.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment5);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }

        } else if (id == R.id.nav_hbalotario) {

            if (cd.isConnected()) {
//                Intent intent = new Intent(NavActivity.this, ActivityAulaVirtual.class);
//                startActivity(intent);

                Intent intent = new Intent(NavActivity.this, BalotarioMenuActivity.class);
                startActivity(intent);


            } else {
                Toast.makeText(this, "Estás sin Conexiòn a Internet", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_vhseminario) {

            //todo  fragmentDiapositvasCatolica

            if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                Fragment fragment7 = new fragment_TCatolica_Seminario();
                FragmentManager fmanager7 = this.getSupportFragmentManager();
                if (fmanager7 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment7.setArguments(args);


                    FragmentTransaction ftransaction = fmanager7.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment7);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
                Fragment fragment7 = new fragmentVSeminario();
                FragmentManager fmanager7 = this.getSupportFragmentManager();
                if (fmanager7 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment7.setArguments(args);


                    FragmentTransaction ftransaction = fmanager7.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment7);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (gradoasiste.equalsIgnoreCase("REGULAR") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE") || gradoasiste.equalsIgnoreCase("CIRCULO")) {
                Fragment fragment7 = new fragmentTVSeminario();
                FragmentManager fmanager7 = this.getSupportFragmentManager();
                if (fmanager7 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment7.setArguments(args);


                    FragmentTransaction ftransaction = fmanager7.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment7);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }
        } else if (id == R.id.nav_efisica) {

            Fragment fragment10 = new contentFisicaFragment();
            FragmentManager fmanager10 = this.getSupportFragmentManager();
            if (fmanager10 != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment10.setArguments(args);

                FragmentTransaction ftransaction = fmanager10.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment10);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }
        } else if (id == R.id.nav_pfmatematica) {

            Fragment fragment7 = new fragmentPFMatematica();
            FragmentManager fmanager7 = this.getSupportFragmentManager();
            if (fmanager7 != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment7.setArguments(args);

                FragmentTransaction ftransaction = fmanager7.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment7);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }


        } else if (id == R.id.nav_ajedrez) {

            Fragment fragment12 = new ajedrezFragment();
            FragmentManager fmanager12 = this.getSupportFragmentManager();
            if (fmanager12 != null) {

                Bundle args = new Bundle();
                args.putString("ACCESO", nivelacceso);
                fragment12.setArguments(args);

                FragmentTransaction ftransaction = fmanager12.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment12);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }

            }


        } else if (id == R.id.nav_presueltos) {

            if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE")) {

                Fragment fragment13 = new fragmentResueltosProblemas();
                FragmentManager fmanager13 = this.getSupportFragmentManager();
                if (fmanager13 != null) {

                    Bundle args = new Bundle();
                    args.putString("ACCESO", nivelacceso);
                    fragment13.setArguments(args);

                    FragmentTransaction ftransaction = fmanager13.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment13);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }

                }
            } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {
                Toast.makeText(this, "Material no Disponible", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.nav_salir) {

            startActivity(new Intent(getBaseContext(), NavActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            finish();


        } else if (id == R.id.nav_eadanual) {

            Fragment fragment9 = new examenAnualFragment();
            FragmentManager fmanager9 = this.getSupportFragmentManager();
            if (fmanager9 != null) {
                Bundle args = new Bundle();
                args.putString("description", "EXÁMENES DE ADMISIÓN");
                //args.putString("grado", grado);
                args.putString("ACCESO", nivelacceso);
                args.putString("TipoGradoAsiste", gradoasiste);
                fragment9.setArguments(args);

                FragmentTransaction ftransaction = fmanager9.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment9);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }


        } else if (id == R.id.nav_eadcap) {

            Fragment fragment10 = new CapitulosAdmisionfragment();
            FragmentManager fmanager10 = this.getSupportFragmentManager();
            if (fmanager10 != null) {

                Bundle args = new Bundle();
                args.putString("description", "HELICO DIAPOSITIVAS");
                //args.putString("grado", grado);
                args.putString("ACCESO", nivelacceso);
                args.putString("TipoGradoAsiste", gradoasiste);
                fragment10.setArguments(args);

                FragmentTransaction ftransaction = fmanager10.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment10);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }


        } else if (id == R.id.nav_eadsimulacro) {

            Fragment fragment11 = new SimulacrosUNIFragment();
            FragmentManager fmanager11 = this.getSupportFragmentManager();
            if (fmanager11 != null) {
                Bundle args = new Bundle();
                args.putString("description", "SIMULACROS EXÁMEN DE ADMISIÓN");
                //args.putString("grado", grado);
                args.putString("ACCESO", nivelacceso);
                args.putString("TipoGradoAsiste", gradoasiste);
                fragment11.setArguments(args);

                FragmentTransaction ftransaction = fmanager11.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenedorFragments, fragment11);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }


        } else if (id == R.id.nav_cerrarsesion) {


//            String datamail= ShareDataRead.obtenerValor(getApplicationContext(), "EMail").substring(0,1);
//
//            if(datamail.equalsIgnoreCase("e") || datamail.equalsIgnoreCase("a"))
//            {
//                Toast.makeText(this, "Acceso solo para administradores", Toast.LENGTH_SHORT).show();
//            }
//            else
//            {
            Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
                    new ResultCallback<Status>() {
                        @Override
                        public void onResult(Status status) {
                            // ...
                            Toast.makeText(getApplicationContext(), "Sesión Cerrada Satisfactoriamente", Toast.LENGTH_LONG).show();
                            guardarValor(getApplicationContext(), "CerrarSesion", "True");
                            guardarValor(getApplicationContext(), "EstadoAuthentication", "false");
                            deleteDescarga();
                            Intent i = new Intent(getApplicationContext(), firebaseAuth.class);
                            startActivity(i);
                        }
                    });

            //   }


            // borra  mi Base de Datos recordar  que  el Recycler View muestra lo que se ha descargado


            //File file = new File("/data/user/0/pe.sacooliveros.apptablet/files/APP/");
            //File file = new File( getFilesDir() + "/APP");

            // file.delete(); // elimina un archivo unico

            //deleteRecursive(file);

//            try {
//                org.apache.commons.io.FileUtils.deleteDirectory(file);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }


            //  EliminarArchivos(new File("/data/user/0/pe.sacooliveros.apptablet/files/APP") ); // Elimina los archivos SSD - descargados // fisico

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void deleteDescarga() {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "administracion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        int cantidad = BaseDeDatos.delete("descargas", null, null);

        BaseDeDatos.close();

    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }


    @Override
    public void responder(String datos) {


    }


    public static boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            return packageManager.getApplicationInfo(packageName, 0).enabled;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public void openApp(Context context, String appName, String packageName) {

        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getApplicationContext(), box);


        //else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
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

    public void startNewActivity(Context context, String packageName) {
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

    public String getVersionName(Context ctx) {
        try {
            return ctx.getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    void EliminarArchivos(File ArchivoDirectorio) { /* Parametro File (Ruta) */
        if (ArchivoDirectorio.isDirectory()) /* Si es Directorio */ {
            /* Recorremos sus Hijos y los ELiminamos */
            for (File hijo : ArchivoDirectorio.listFiles())
                EliminarArchivos(hijo); /*Recursividad Para Saber si no hay Subcarpetas */
        } else
            ArchivoDirectorio.delete(); /* Si no, se trata de un File ,solo lo Eliminamos*/
    }


    public static void guardarValor(Context context, String keyPref, String valor) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putString(keyPref, valor);
        editor.commit();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case REQ_CODE_VERSION_UPDATE:
                if (resultCode != RESULT_OK) { //RESULT_OK / RESULT_CANCELED / RESULT_IN_APP_UPDATE_FAILED
                    Log.d(TAG, "Update flow failed! Result code: " + resultCode);
                    // If the update is cancelled or fails,
                    // you can request to start the update again.
                    unregisterInstallStateUpdListener();
                }

                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        checkNewAppVersionState();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterInstallStateUpdListener();
    }
}
