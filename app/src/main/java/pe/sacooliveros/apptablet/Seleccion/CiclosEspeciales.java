package pe.sacooliveros.apptablet.Seleccion;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
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
import com.google.android.play.core.tasks.Task;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.math.BigDecimal;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.sacooliveros.apptablet.Authenticacion.firebaseAuth;
import pe.sacooliveros.apptablet.ConfigFragment;
import pe.sacooliveros.apptablet.DBDescargas.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.DirectoryCreateUtil;
import pe.sacooliveros.apptablet.DirectoryUtilSeleccion;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentEnglish;
import pe.sacooliveros.apptablet.Seleccion.fragments.AcademiaFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.SeleccionFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.contentAnualFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.contentOlimpiadasFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.contentSemestralFragment;
import pe.sacooliveros.apptablet.ServiceVersion.SConsultVersion;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.Utils.ValidateCopyright;

public class CiclosEspeciales extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    SeleccionFragment seleccionFragment;

    String gradoasiste;
    String emailogin = "";
    String emailjson = "";
    String urlphoto = "";
    String viewType = "";
    String emailserver;
    String fotoserver;
    String sedeserver;
    String usuarioserver;
    String servernivel;
    String matricularserver;
    static String nivelacceso;

    int MY_PERMISSIONS_REQUEST_WRITE_STORAGE = 1;
    int MY_PERMISSIONS_REQUEST_TELEPHONE = 2;
    int MY_PERMISSIONS_REQUEST_UBICACION = 3;

    String appName;
    String packageName;
    String box;

    static String updateapk;

    ConnectionDetector cd;
    GoogleApiClient mGoogleApiClient;
    static String PREFS_KEY = "autenticacionOff";

    String apellidopaterno, apellidomaterno;

    String versionapkbase;

    BigDecimal updateapkcode;

    //autoUpdate
    private static final int REQ_CODE_VERSION_UPDATE = 530;
    private AppUpdateManager appUpdateManager;
    private InstallStateUpdatedListener installStateUpdatedListener;
    private static final String TAG = "VERIFY_UPDATE";

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
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciclos_especiales);
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


            fotoserver = bundle.getString("URLPhoto");
            emailserver = bundle.getString("EMail");
            usuarioserver = bundle.getString("NombreUsuario");
            sedeserver = bundle.getString("SedeUsuario");
            servernivel = bundle.getString("ServerGradoNivel"); //2 Secundaria
            matricularserver = bundle.getString("MatriculaServer");
            gradoasiste = bundle.getString("TipoGradoAsiste");

            apellidopaterno = bundle.getString("ApellidoPaterno");
            apellidomaterno = bundle.getString("ApellidoMaterno");

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        versionapkbase = getVersionName(getApplicationContext());

        String codigoAuth = ShareDataRead.obtenerValor(getApplicationContext(), "codigo_autenticacion");

        cd = new ConnectionDetector(getApplicationContext());

        if (cd.isConnected()) {

            String consultarServicio = ShareDataRead.obtenerValor(getApplicationContext(), "CheckOutService");

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

        if (cd.isConnected() && updateapk != null) {

            BigDecimal versionapk = new BigDecimal(getVersionName(getApplicationContext()));
            updateapkcode = new BigDecimal(updateapk);

            if (updateapkcode.compareTo(versionapk) > 0) {

                AlertDialog.Builder builder = new AlertDialog.Builder(CiclosEspeciales.this);
                builder.setTitle("Nueva Versión Disponible");
                builder.setMessage("Versión " + updateapkcode + "  está disponible en Google Play Store ¿Deseas Actualizar Ahora?");
                builder.setPositiveButton("Actualizar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
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
        }

        int verificarPermisoWrite = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int verificarPermisoPhone = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);
        int verificarPermisoUbicacion = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if (verificarPermisoWrite != PackageManager.PERMISSION_GRANTED) {
            if (shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                solicitarPermiso();
            } else
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

            if (gradoasiste.equalsIgnoreCase("SELECCION")) {

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilSeleccion directoryUtilSeleccion = new DirectoryUtilSeleccion();
                directoryUtilSeleccion.verResourceString(this);
                directoryUtilSeleccion.verGradoSec("5");
                directoryUtilSeleccion.createCarpetas(getFilesDir() + "/APP");
            }

        } else {
            String sesiondata = ShareDataRead.obtenerValor(getApplicationContext(), "CerrarSesion");

            if (sesiondata.equalsIgnoreCase("True")) {

                File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/file_loader");
                deleteRecursive(filecache);

                File file = new File(getFilesDir() + "/APP");
                deleteRecursive(file); // validar  que no haya  carpetas creadas

                DirectoryUtilSeleccion directoryUtilSeleccion = new DirectoryUtilSeleccion();
                directoryUtilSeleccion.verResourceString(this);
                directoryUtilSeleccion.verGradoSec("5");
                directoryUtilSeleccion.createCarpetas(getFilesDir() + "/APP");

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

        boolean isAppInstalled2 = isPackageInstalled("com.adobe.reader", this.getPackageManager());

        if (!isAppInstalled2) {

            AlertDialog alertDialog = new AlertDialog.Builder(CiclosEspeciales.this).create();
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

                            //dialog.dismiss();
                        }
                    });
            alertDialog.show();

        }


        boolean isAppInstalled = isPackageInstalled("com.ispringsolutions.mplayer", this.getPackageManager());


        if (!isAppInstalled) {

            AlertDialog alertDialog = new AlertDialog.Builder(CiclosEspeciales.this).create();
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


        seleccionFragment = new SeleccionFragment();

        FragmentManager fmanager = getSupportFragmentManager();
        FragmentTransaction ftransaction = fmanager.beginTransaction();
        ftransaction.add(R.id.contenUniFragments, seleccionFragment);
        ftransaction.commit();


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final CircleImageView imageView = navigationView.getHeaderView(0).findViewById(R.id.imageNavigator);
        //Picasso.get().load(fotoserver).into(imageView);


        // txtEmail.setText(emailserver);

//        String datamail = ShareDataRead.obtenerValor(getApplicationContext(), "EMail").substring(0, 1);
//
//        if (datamail.equalsIgnoreCase("e") || datamail.equalsIgnoreCase("a")) {
//            Menu nav_Menu = navigationView.getMenu();
//            nav_Menu.findItem(R.id.nav_cerrarsesionsel).setVisible(false);
//        }

//        if(datamail.equalsIgnoreCase("e") || datamail.equalsIgnoreCase("a"))
//        {
//            Menu nav_Menu = navigationView.getMenu();
//            nav_Menu.findItem(R.id.nav_cerrarsesionsel).setVisible(false);
//        }


        ConnectionDetector cd = new ConnectionDetector(this);

        if (cd.isConnected()) {

            Picasso.get().load(fotoserver).into(imageView);
        }

//        } else {
//            File imageFile = new File("/data/user/0/pe.sacooliveros.apptablet/app_imagen/googleimg.jpg");
//
//            if (imageFile.exists()) {
//
//                imageView.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));
//
//            }
//        }

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
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
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
                    CiclosEspeciales.REQ_CODE_VERSION_UPDATE);
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
                    CiclosEspeciales.REQ_CODE_VERSION_UPDATE);
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
                .addOnSuccessListener(
                        appUpdateInfo -> {
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
                        });

    }

    private void unregisterInstallStateUpdListener() {
        if (appUpdateManager != null && installStateUpdatedListener != null)
            appUpdateManager.unregisterListener(installStateUpdatedListener);
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
        getMenuInflater().inflate(R.menu.ciclos_especiales, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_home) {

            Fragment fragment = new SeleccionFragment();
            FragmentManager fmanager3 = this.getSupportFragmentManager();
            if (fmanager3 != null) {

                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenUniFragments, fragment);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }

        }
        if (id == R.id.action_settings) {

            Fragment fragment = new ConfigFragment();
            FragmentManager fmanager3 = this.getSupportFragmentManager();
            if (fmanager3 != null) {

                Bundle args = new Bundle();

                args.putString("PerfilFoto", fotoserver);
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

                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenUniFragments, fragment);
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

        if (id == R.id.nav_ingles) {

            Fragment fragment = new fragmentEnglish();
            FragmentManager fmanager3 = this.getSupportFragmentManager();
            if (fmanager3 != null) {

                Bundle args = new Bundle();

                args.putString("ACCESO", nivelacceso);
                fragment.setArguments(args);

                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenUniFragments, fragment);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }
            // Handle the camera action


        } else if (id == R.id.nav_libroacademia) {

            String sharedata = ShareDataRead.obtenerValor(this, "ServerGradoNivel");


            if (sharedata.equalsIgnoreCase("601 Secundaria") || sharedata.equalsIgnoreCase("601 Primaria")) {
                Fragment fragment = new AcademiaFragment();
                FragmentManager fmanager3 = this.getSupportFragmentManager();
                if (fmanager3 != null) {

                    Bundle args = new Bundle();

                    args.putString("ACCESO", nivelacceso);
                    fragment.setArguments(args);

                    FragmentTransaction ftransaction = fmanager3.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenUniFragments, fragment);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            } else if (sharedata.equalsIgnoreCase("701 Secundaria")) {

                Fragment fragment2 = new contentSemestralFragment();
                FragmentManager fmanager2 = this.getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenUniFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }

        } else if (id == R.id.nav_olimpiada) {

            Fragment fragment2 = new contentOlimpiadasFragment();
            FragmentManager fmanager2 = this.getSupportFragmentManager();
            if (fmanager2 != null) {

                Bundle args = new Bundle();
                fragment2.setArguments(args);

                FragmentTransaction ftransaction = fmanager2.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenUniFragments, fragment2);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }

        } else if (id == R.id.nav_eanual) {

            Fragment fragment2 = new contentAnualFragment();
            FragmentManager fmanager2 = this.getSupportFragmentManager();
            if (fmanager2 != null) {

                Bundle args = new Bundle();
                fragment2.setArguments(args);

                FragmentTransaction ftransaction = fmanager2.beginTransaction();
                if (ftransaction != null) {
                    ftransaction.replace(R.id.contenUniFragments, fragment2);
                    ftransaction.addToBackStack("");
                    ftransaction.commit();
                }
            }

        } else if (id == R.id.nav_salir) {

            Intent salida = new Intent(Intent.ACTION_MAIN);
            finish();
            System.exit(0);

        } else if (id == R.id.nav_cerrarsesionsel) {

//            String datamail = ShareDataRead.obtenerValor(getApplicationContext(), "EMail").substring(0, 1);
//
//
//            if (datamail.equalsIgnoreCase("e") || datamail.equalsIgnoreCase("a")) {
//                Toast.makeText(this, "Acceso solo para administradores", Toast.LENGTH_SHORT).show();
//
//            } else {

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
            // }


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void solicitarPermiso() {


        new AlertDialog.Builder(this)
                .setTitle("Autorización")
                .setMessage("Necesito permiso para Almacenar Archivos")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_WRITE_STORAGE);

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

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

    private void deleteDescarga() {


        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(), "administracion", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        int cantidad = BaseDeDatos.delete("descargas", null, null);

        BaseDeDatos.close();

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
