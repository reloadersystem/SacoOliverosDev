package pe.sacooliveros.apptablet.Utils;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class GeneralFragmentManager {

    public static void setFragmentWithReplace(Activity activity, int contenedor_id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = ((AppCompatActivity) activity).getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(contenedor_id, fragment);
        fragmentTransaction.commit();
    }
}
