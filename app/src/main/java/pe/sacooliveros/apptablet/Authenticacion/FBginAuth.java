package pe.sacooliveros.apptablet.Authenticacion;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import pe.sacooliveros.apptablet.EnviarGrado;
import pe.sacooliveros.apptablet.EnviarGradoCurso;
import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.SplashActivity;
import pe.sacooliveros.apptablet.WebServiceInstitucion.SacoWSConsult;

//import com.google.android.gms.common.internal.IGoogleCertificatesApi;


public class FBginAuth extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener, EnviarGradoCurso, EnviarGrado {

    private CircleImageView photoImagenView;

    private TextView nameTextView;

    private TextView emailView;

    private TextView idTexView;

    private Button btn_salir;
    private Button btn_relogear;
    private Button btn_ingresar;

    private Button btn_Secundaria;

    Bitmap imagen;

    Button btn_datos;

    String urlphoto = "";
    String email = "";

    private GoogleApiClient googleApiClient;

    TextView datosserver;

    RelativeLayout lnLayout;

    public String grado = "";

    public String gradoencurso = "";

    TextView tv_urphoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fbgin_auth);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        photoImagenView = findViewById(R.id.photoImageView);
        nameTextView = findViewById(R.id.nameTextView);
        emailView = findViewById(R.id.emailTextView);
        idTexView = findViewById(R.id.idTextView);
        btn_relogear = findViewById(R.id.btnRelogear);
        btn_salir = findViewById(R.id.btnSalir);
        btn_ingresar = findViewById(R.id.btnIngresar);
        btn_datos = findViewById(R.id.btn_datos);
        //datosserver = findViewById(R.id.tx_datos_server);
        tv_urphoto = findViewById(R.id.tv_urphoto);


        lnLayout = findViewById(R.id.lnMainActivity);
        btn_datos.setOnClickListener(this);


        btn_Secundaria = findViewById(R.id.btnIngresarSecundaria);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .requestIdToken(getString(R.string.default_web_client_id))
                .build();

        Log.d("tokenGSO", String.valueOf(gso.isIdTokenRequested()));

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

                        if (status.isSuccess()) {
                            goLogInScreen();
                        } else {
                            Toast.makeText(getApplicationContext(), "no se pudo iniciar sesion", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });


        btn_relogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

                        if (status.isSuccess()) {
                            goLogInScreen();

                        } else {
                            Toast.makeText(getApplicationContext(), "No se  pudo revocar acceso", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(getApplicationContext(), NavigatorPrimaria.class);

                //String url= "https://lh3.googleusercontent.com/a-/AN66SAwjKVieCwkQJXcPkh13vG3l6_l8R8qBX-OH59k";
                intent.putExtra("URLPhoto", urlphoto);
                intent.putExtra("EMail", email);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

        btn_Secundaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NavActivity.class);
                intent.putExtra("URLPhoto", urlphoto);
                intent.putExtra("EMail", email);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });

    }


    private void goLogInScreen() {


//        Intent intent = new Intent(this, firebaseAuth.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);

        //TODO  abrir  la  actividad  segun  sea el acceso

    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onStart() {
        super.onStart();

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);

        if (opr.isDone()) {
            GoogleSignInResult result = opr.get();
            handleSingInResult(result);


        } else {
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSingInResult(googleSignInResult);

                }
            });
        }

    }

    private void handleSingInResult(GoogleSignInResult result) {

        if (result.isSuccess()) {

            GoogleSignInAccount account = result.getSignInAccount();


            if (!account.getEmail().contains("@sacooliveros.edu.pe")) {

                Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

                        if (status.isSuccess()) {
                            Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                            Toast.makeText(FBginAuth.this, "Ingresa un mail válido, ejemplo: d1234567890@sacooliveros.edu.pe, ingresa a http://tablet.sacooliveros.edu.pe/  con tu dni y el código de autenticación de la tablet presiona consultar y tendrás los datos de acceso", Toast.LENGTH_LONG).show();
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "No se pudo cerrar sesión", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

            nameTextView.setText(account.getDisplayName());
            emailView.setText(account.getEmail());


            //emailresponse= emailView.getText().toString();


            Log.d("datoa", account.getFamilyName());
            Log.d("datob", account.getGivenName());
            Log.d("datoc", account.getId());
            // Log.d("datod", account.getObfuscatedIdentifier());
            Log.d("datoe", String.valueOf(account.getGrantedScopes()));
            // Log.d("datof", String.valueOf(account.getExpirationTimeSecs()));
            Log.d("datog", account.getDisplayName());
            Log.d("datoh", account.getEmail());
            Log.d("IDTOKEN", account.getIdToken());


            //idTexView.setText(account.getId());

            Glide.with(this).load(account.getPhotoUrl()).into(photoImagenView);

            urlphoto = account.getPhotoUrl().toString();
            email = account.getEmail();

            tv_urphoto.setText(urlphoto);


            SacoWSConsult consult = new SacoWSConsult();
            consult.setCurrentContext(this);
            consult.setCurrentLayout(lnLayout);
            consult.execute(email);

            //String  descargafoto = "";  // descarga foto desde  google account
            // CargaImagenes nuevaTarea = new CargaImagenes();
//        nuevaTarea.execute(descargafoto);
            //  nuevaTarea.execute(urlphoto);

            //TODO  Descargar Foto para Off-Line


        } else {
            goLogInScreen();

        }


    }


    public void onClick(View view) {

//        SacoWSConsult consult = new SacoWSConsult();
//        consult.setCurrentContext(this);
//        consult.setCurrentLayout(lnLayout);
//        consult.execute();
    }


    @Override
    public void enviarnivel(String nivel) {

        gradoencurso = nivel;


    }

    @Override
    public void enviargrado(String mensaje) {

        grado = mensaje;

    }

    private class CargaImagenes extends AsyncTask<String, Void, Bitmap> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {

            super.onPreExecute();

            pDialog = new ProgressDialog(FBginAuth.this);
            pDialog.setMessage("Guardando Datos de Perfil");
            pDialog.setCancelable(true);
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();

        }

        @Override
        protected Bitmap doInBackground(String... params) {

            android.util.Log.i("doInBackground", params.toString());
            String url = params[0];
            imagen = descargarImagen(url);
            return imagen;
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            super.onPostExecute(result);

            //imgImagen.setImageBitmap(result);
            pDialog.dismiss();
            //  guardarImagen(getApplicationContext(), "imagen", imagen);
        }

    }


    private Bitmap descargarImagen(String imageHttpAddress) {
        //URL
        java.net.URL imageUrl = null;
        Bitmap imagen = null;
        try {
            imageUrl = new URL(imageHttpAddress);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return imagen;
    }


    private String guardarImagen(Context context, String nombre, Bitmap imagen) {
        ContextWrapper cw = new ContextWrapper(context);
        File dirImages = cw.getDir(nombre, Context.MODE_PRIVATE);
        File myPath = new File(dirImages, "googleimg" + ".jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myPath);
            imagen.compress(Bitmap.CompressFormat.JPEG, 10, fos);
            fos.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return myPath.getAbsolutePath();

    }


}