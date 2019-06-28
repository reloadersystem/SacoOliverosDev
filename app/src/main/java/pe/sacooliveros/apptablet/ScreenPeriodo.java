package pe.sacooliveros.apptablet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pe.sacooliveros.apptablet.Primaria.NavigatorPrimaria;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;

public class ScreenPeriodo extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_periodo);


        String actualfecha = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // fecha  actual

        String dato8= obtenerValor(getApplicationContext(), "fechainicio_clase");
        String dato9= obtenerValor(getApplicationContext(), "fechafin_clase");

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        Date date1= null;
        Date date2= null;
        Date fechadato= null;


        try {
            date1 = sdf.parse(dato8);
            date2=sdf.parse(dato9);

            fechadato= sdf.parse(actualfecha);

            Boolean periodoinicio=fechadato.before(date1);
            Boolean periodofin=fechadato.before(date2);


//            if (periodofin)
//            {
//                Intent intent= new Intent(ScreenPeriodo.this, SplashActivity.class);
//                startActivity(intent);
//
//            }

//            if (periodoinicio) {
//                                Intent intent = new Intent(ScreenPeriodo.this, SplashActivity.class);
//                                startActivity(intent);
//                            }

            //si es 05-03-2018 pasa  a mensaje fecha  diferente  al inicio tablet


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    static String  PREFS_KEY= "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return  preferences.getString(keyPref, "");

    }
}
