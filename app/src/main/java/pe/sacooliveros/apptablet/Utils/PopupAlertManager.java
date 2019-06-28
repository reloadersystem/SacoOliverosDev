package pe.sacooliveros.apptablet.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;

public class PopupAlertManager {

    public Context dataContext;
    String appName;

    String packageName;

    String box;


    String sharedata;




    public void customDialog(final Context context, String title, ArrayList arrayList) {
        dataContext = context;

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popuplecturas, null);

        GridView lvView = view2.findViewById(R.id.grid_pruebas);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        TextView txt_titulo = view2.findViewById(R.id.txt_titulo);
        ImageButton imgmedita = view2.findViewById(R.id.img_meditapp);

        txt_titulo.setText(title);

        sharedata= ShareDataRead.obtenerValor(context, "TipoGradoAsiste");

        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        final adapterPruebas adapter2 = new adapterPruebas(context, arrayList);
        lvView.setAdapter(adapter2);

        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int motivadorcount = adapterView.getCount();

                mPruebas mPruebas = (mPruebas) adapter2.getItem(position);

                for (int a = 0; a < motivadorcount; a++) {

                    if (position == a) {

                        Uri uri = Uri.parse(mPruebas.getUrldata());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);
                    }
                }
            }
        });




        imgmedita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                packageName = "org.simo.medita";
                box = "org.simo.medita";
                openApp(dataContext, appName, packageName);

            }
        });

        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(dataContext, box);


        //else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
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
