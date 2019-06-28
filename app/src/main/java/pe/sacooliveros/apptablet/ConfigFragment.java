package pe.sacooliveros.apptablet;


import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfigFragment extends Fragment {

    View rootview;

    TextView modelconfig, serialconfig, timeconfig, storagesize, email_config;

    String emailjson, emailogin;

    String urlphoto = "https://i.imgur.com/E9TLAUs.jpg";

    ImageView img_config;

    TextView tvnombre;

    String usuarioservidor;

    String sedeserver;

    TextView txv_sede;

    String servernivel;

    TextView txv_gradonivel;

    String matricularserver;

    TextView txt_matricula;

    String gradoasiste;

    TextView textView22;

    TextView txt_numversion;

    String apellidopaterno, apellidomaterno;


    public ConfigFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_config, container, false);


        final ConnectionDetector cd = new ConnectionDetector(getContext());

        modelconfig = rootview.findViewById(R.id.modelconfig);
        serialconfig = rootview.findViewById(R.id.serialconfig);
        timeconfig = rootview.findViewById(R.id.timeconfig);
        storagesize = rootview.findViewById(R.id.storagesize);
        img_config = rootview.findViewById(R.id.img_config);
        email_config = rootview.findViewById(R.id.email_config);
        tvnombre = rootview.findViewById(R.id.textView5);
        txv_sede = rootview.findViewById(R.id.textView18);
        txv_gradonivel = rootview.findViewById(R.id.textView16);
        txt_matricula = rootview.findViewById(R.id.txt_matricula);
        txt_numversion = rootview.findViewById(R.id.txt_numversion);

        String versionapkbase = getVersionName(getContext());

        txt_numversion.setText(versionapkbase);


        String myDeviceModel = android.os.Build.MODEL;


        String mySerial = Build.SERIAL;

        // String Baseband= Build.VERSION.RELEASE;   //version de  android 7.0

        // Id String Baseband= Build.ID;   //MRK58 Número de Compilación

        //String Baseband= Build.DISPLAY;    //MRK58 test-keys Número de Compilación

        String Baseband = Build.getRadioVersion();  // version de la banda base

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            emailjson = bundle.getString("UsuarioJson");
            urlphoto = bundle.getString("PerfilFoto");
            emailogin = bundle.getString("UsuarioMail");
            usuarioservidor = bundle.getString("NombreUsuario");
            sedeserver = bundle.getString("SedeUsuario");
            servernivel = bundle.getString("ServerGradoNivel");
            matricularserver = bundle.getString("MatriculaServer");
            gradoasiste = bundle.getString("TipoGradoAsiste");
            apellidopaterno = bundle.getString("ApellidoPaterno");
            apellidomaterno = bundle.getString("ApellidoMaterno");
        }


        ActivityManager actManager = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        //decimal format %,%
        long totalMemory = memInfo.totalMem;


        modelconfig.setText(myDeviceModel);
        serialconfig.setText(mySerial);
        timeconfig.setText(Baseband);
        storagesize.setText(getTotalRAM());




        // Picasso.get().load(urlphoto).into(img_config);

        String sharedata = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        String sharedata2 = ShareDataRead.obtenerValor(getContext(), "GradoNombre");
        String sharedata3 = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");
        String sharedata4 = ShareDataRead.obtenerValor(getContext(), "MatriculaServer");
        String sedealumno = ShareDataRead.obtenerValor(getContext(), "SedeUsuario");
        String emailalumno = ShareDataRead.obtenerValor(getContext(), "EMail");
        String urlfotoalumno = ShareDataRead.obtenerValor(getContext(), "URLPhoto");

        if (cd.isConnected()) {

            Picasso.get().load(urlfotoalumno).into(img_config);

        } else {
            File imageFile = new File("/data/user/0/pe.sacooliveros.apptablet/app_imagen/googleimg.png");

            if (imageFile.exists()) {

                img_config.setImageBitmap(BitmapFactory.decodeFile(imageFile.getAbsolutePath()));

            }
        }



        if (sharedata4.equalsIgnoreCase("false")) {
            txt_matricula.setText(" HABILITADO");
        }
        //email_config.setText("  "+ emailjson);
        {
            email_config.setText("  " + emailalumno);
        }

        String sharematerno = ShareDataRead.obtenerValor(getContext(), "ApellidoMaterno");
        String sharepaterno = ShareDataRead.obtenerValor(getContext(), "ApellidoPaterno");
        String nombreusuariodata = ShareDataRead.obtenerValor(getContext(), "NombreUsuario");


        if(usuarioservidor==null)
        {
            usuarioservidor=nombreusuariodata;
        }

        String[] parts = usuarioservidor.split(" ");//

        String part1 = parts[0];


        tvnombre.setText(" " + part1 + " " + sharepaterno + " " + sharematerno);

        txv_sede.setText("  " + sedealumno);

        if (sharedata.equalsIgnoreCase("UNI")) {
            txv_gradonivel.setText(" QUINTO" + " " + sharedata);

        } else if (sharedata.equalsIgnoreCase("SAN MARCOS")) {
            txv_gradonivel.setText(" QUINTO" + " " + sharedata);

        } else if (sharedata3.equalsIgnoreCase("5 Primaria")) {
            txv_gradonivel.setText(" QUINTO DE PRIMARIA");

        } else if (sharedata3.equalsIgnoreCase("6 Primaria")) {
            txv_gradonivel.setText(" SEXTO DE PRIMARIA");

        } else if (sharedata.equalsIgnoreCase("CATOLICA")) {
            txv_gradonivel.setText(" QUINTO" + " " + sharedata);

        } else if (sharedata.equalsIgnoreCase("PRE") && sharedata2.equalsIgnoreCase("Quinto Año")) {
            txv_gradonivel.setText(" QUINTO" + " " + sharedata);

        } else if (sharedata.equalsIgnoreCase("PRE") && sharedata2.equalsIgnoreCase("Cuarto Año")) {
            txv_gradonivel.setText(" CUARTO" + " " + sharedata);

        } else if (sharedata.equalsIgnoreCase("SELECCION")) {
            txv_gradonivel.setText(" SELECCIÓN - " + sharedata2);

        } else if (sharedata.equalsIgnoreCase("REGULAR") && sharedata3.equalsIgnoreCase("5 Secundaria")) {
            txv_gradonivel.setText(" QUINTO DE SECUNDARIA");

        } else if (sharedata.equalsIgnoreCase("REGULAR") && sharedata3.equalsIgnoreCase("4 Secundaria")) {
            txv_gradonivel.setText(" CUARTO DE SECUNDARIA");

        } else if (sharedata.equalsIgnoreCase("REGULAR") && sharedata3.equalsIgnoreCase("3 Secundaria")) {
            txv_gradonivel.setText(" TERCERO DE SECUNDARIA");

        } else if (sharedata.equalsIgnoreCase("REGULAR") && sharedata3.equalsIgnoreCase("2 Secundaria")) {
            txv_gradonivel.setText(" SEGUNDO DE SECUNDARIA");

        } else if (sharedata.equalsIgnoreCase("REGULAR") && sharedata3.equalsIgnoreCase("1 Secundaria")) {
            txv_gradonivel.setText(" PRIMERO DE SECUNDARIA");

        } else if (sharedata2.equalsIgnoreCase("1° Y 2° GRADO")) {
            txv_gradonivel.setText(" CIRCULO SEGUNDO DE SECUNDARIA");

        } else if (sharedata2.equalsIgnoreCase("2° Y 3° GRADO")) {
            txv_gradonivel.setText(" CIRCULO TERCERO DE SECUNDARIA");

        } else if (sharedata2.equalsIgnoreCase("3° Y 4° GRADO")) {
            txv_gradonivel.setText(" CIRCULO CUARTO DE SECUNDARIA");

        } else if (sharedata2.equalsIgnoreCase("4° Y 5° GRADO")) {
            txv_gradonivel.setText(" CIRCULO QUINTO DE SECUNDARIA");

        } else if (sharedata.equalsIgnoreCase("CIRCULO")) {
            txv_gradonivel.setText(" CIRCULO");
        }

        return rootview;
    }


    public String getVersionName(Context ctx) {
        try {
            //return ctx.getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            return ctx.getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }


    public String getTotalRAM() {

        RandomAccessFile reader = null;
        String load = null;
        DecimalFormat twoDecimalForm = new DecimalFormat("#.##");
        double totRam = 0;
        String lastValue = "";
        try {
            reader = new RandomAccessFile("/proc/meminfo", "r");
            load = reader.readLine();

            // Get the Number value from the string
            Pattern p = Pattern.compile("(\\d+)");
            Matcher m = p.matcher(load);
            String value = "";
            while (m.find()) {
                value = m.group(1);
                // System.out.println("Ram : " + value);
            }
            reader.close();

            totRam = Double.parseDouble(value);
            // totRam = totRam / 1024;

            double mb = totRam / 1024.0;
            double gb = totRam / 1048576.0;
            double tb = totRam / 1073741824.0;

            if (tb > 1) {
                lastValue = twoDecimalForm.format(tb).concat(" TB");
            } else if (gb > 1) {
                lastValue = twoDecimalForm.format(gb).concat(" GB");
            } else if (mb > 1) {
                lastValue = twoDecimalForm.format(mb).concat(" MB");
            } else {
                lastValue = twoDecimalForm.format(totRam).concat(" KB");
            }


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Streams.close(reader);
        }

        return lastValue;
    }


}
