package pe.sacooliveros.apptablet.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;

import pe.sacooliveros.apptablet.FinallyActivity;
import pe.sacooliveros.apptablet.R;

public class ValidateCopyright {

    String myDeviceModel;
    String Baseband;
    String model_device;
    String versionbase_device;

    Context context;

    public ValidateCopyright(Context context) {
        this.context = context;
        this.model_device = context.getString(R.string.modelo_tablet);
        this.versionbase_device = context.getString(R.string.version_base);
    }

    public void isvalidate() {

        Baseband = Build.getRadioVersion();
        myDeviceModel = android.os.Build.MODEL;
        String mySerial = Build.SERIAL;

        if ((!myDeviceModel.equalsIgnoreCase(model_device)) && (!Baseband.equalsIgnoreCase(versionbase_device))) {

//
//            AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
//            builder1.setMessage("Software Ilegal");
//            builder1.setCancelable(true);
//
//            builder1.setPositiveButton(
//                    "Yes",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.cancel();
//                        }
//                    });
//
//            builder1.setNegativeButton(
//                    "No",
//                    new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int id) {
//                            dialog.cancel();
//                        }
//                    });
//
//            AlertDialog alert11 = builder1.create();
//            alert11.show();

            final int Sleep_Item = 10000;
            final int Sleep_finally = 20000;


            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Toast.makeText(context, myDeviceModel + " Dispositivo no Autorizado - Copyright SACO OLIVEROS - registrando datos del Usuario....", Toast.LENGTH_LONG).show();
                }
            }, Sleep_Item);

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Toast.makeText(context, myDeviceModel + " Cerrando Sistema....", Toast.LENGTH_LONG).show();
                    SharedPreferences settings = context.getSharedPreferences("autenticacionOff", Context.MODE_PRIVATE);
                    settings.edit().clear().commit();

                    Intent intent = new Intent(context, FinallyActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            }, Sleep_finally);
        }
    }
}
