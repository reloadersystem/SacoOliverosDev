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
import android.widget.Toast;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class appCalculoFrag extends Fragment {

    View rootview;

    FrameLayout fr_calculoapp, fr_calculoapp2;


    String appName;

    String packageName;

    String box;


    public appCalculoFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_app_calculo, container, false);

        fr_calculoapp= rootview.findViewById(R.id.fr_calculoapp);
        fr_calculoapp2= rootview.findViewById(R.id.fr_calculoapp2);


        fr_calculoapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appName = "Gmail";
                packageName = "br.net.btco.soroban";

                box= "br.net.btco.soroban";


                openApp( getContext(), appName, packageName);

            }
        });

        fr_calculoapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String appName = "Gmail";
                String packageName = "com.AvatarPucp.OraculoMatemagico";

                box= "com.AvatarPucp.OraculoMatemagico";

                openApp( getContext(), appName, packageName);

            }

        });




//        https://play.google.com/store/apps/details?id=com.AvatarPucp.OraculoMatemagico

        return rootview;
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


    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getContext(),box);


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


}
