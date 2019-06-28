package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentEnglish extends Fragment {

    View rootview;

    CardView crv_englishapp, crv_englishapp2, crv_englishapp3, crv_englishapp4;

    String appName;

    String box;

    String packageName;


    public fragmentEnglish() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_helico_english, container, false);

        crv_englishapp = rootview.findViewById(R.id.crv_englishapp);
        crv_englishapp2 = rootview.findViewById(R.id.crv_englishapp2);
        crv_englishapp3 = rootview.findViewById(R.id.crv_englishapp3);
        crv_englishapp4 = rootview.findViewById(R.id.crv_englishapp4);



        crv_englishapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                appName = "Gmail";
                packageName = "dictadv.english.britishmacmillan";

                box = "dictadv.english.britishmacmillan";

                openApp(getContext(), appName, packageName);



            }
        });


        crv_englishapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                appName = "Gmail";
                packageName = "com.macmillan.app.soundsfree";

                box = "com.macmillan.app.soundsfree";

                openApp(getContext(), appName, packageName);

            }
        });

        crv_englishapp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Uri uri = Uri.parse("https://www.macmillaneducationeverywhere.com/es/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                getContext().startActivity(intent);

            }
        });


        crv_englishapp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                appName = "Gmail";
                packageName = "com.macmillan.mee2&hl=es_419";

                box = "com.macmillan.mee2&hl=es_419";

                openApp(getContext(), appName, packageName);


            }
        });



        return rootview;
    }

    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getContext(), box);


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

