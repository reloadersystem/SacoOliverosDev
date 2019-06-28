package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class diccionarioFragment extends Fragment {


    View rootview;

    FrameLayout fr_diccionario, fr_diccionario1;

    String appName;

    String packageName;

    String box;


    ImageView img_diccionario1;

    String acceso;


    public diccionarioFragment() {



        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview= inflater.inflate(R.layout.fragment_diccionario, container, false);

        fr_diccionario= rootview.findViewById(R.id.fr_diccionario);
        fr_diccionario1= rootview.findViewById(R.id.fr_diccionario1);
        img_diccionario1=rootview.findViewById(R.id.img_diccionario1);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            acceso = bundle.getString("ACCESO");
        }

        String sharedata= ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0,1);

        if(acceso==null)

        {
            acceso= sharedata;
        }


        if(acceso.equalsIgnoreCase("5"))
        {
           img_diccionario1.setImageResource(R.drawable.happycamper5);


        }else if (acceso.equalsIgnoreCase("6"))
        {
            img_diccionario1.setImageResource(R.drawable.happycampers6);

        }




        fr_diccionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appName = "Gmail";
                packageName = "com.google.android.apps.translate";

                box= "com.google.android.apps.translate";

                openApp( getContext(), appName, packageName);



            }
        });

        fr_diccionario1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(acceso.equalsIgnoreCase("5"))
                {
                    appName = "Gmail";
                    packageName = "com.macmillan.happycampers5";

                    box= "com.macmillan.happycampers5";

                    openApp( getContext(), appName, packageName);

                }
                if (acceso.equalsIgnoreCase("6"))
                {
                    appName = "Gmail";
                    packageName = "com.macmillan.happycampers6";

                    box= "com.macmillan.happycampers6";

                    openApp( getContext(), appName, packageName);

                }




            }
        });

        return  rootview;
    }


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getContext(),box);


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
