package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Adapter.adapterPrMain;
import pe.sacooliveros.apptablet.Primaria.Model.mMainPri;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainfragPrim extends Fragment {


    View rootview;
    String grado;
    ArrayList<mMainPri> Lista;
    private GridView gridView;

    String appName;

    String packageName;

    String box;
    static String nivelacceso; //5

    static String nivel;

    ConnectionDetector connectionDetector;


    public MainfragPrim() {
        // Required empty public constructor
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //5 "primaria
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview = inflater.inflate(R.layout.fragment_mainfrag_prim, container, false);

        gridView = rootview.findViewById(R.id.ma_principal);

        connectionDetector = new ConnectionDetector(getContext());


        if (nivel == null) {
            String dato1 = obtenerValor(getContext(), "ServerGradoNivel");

            nivelacceso = String.valueOf(dato1.charAt(0));

        } else {
            nivelacceso = String.valueOf(nivel.charAt(0));
        }

        Lista = new ArrayList<mMainPri>();

        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_1, "LIBROS"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_2, "CLASES MULTIMEDIA"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_3, "ASESORIAS VIRTUALES"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_4, "DICCIONARIO"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_5, "CÁLCULO MENTAL"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_6, "AJEDREZ"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_7, "HELICO MOTIVACIÓN"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.diverti, "VIDEOS"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_9, "PLAN LECTOR"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.videoseminarioimg, "VIDEO SEMINARIO"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.primaria56_10, "MEDITACIÓN"));
        Lista.add(new mMainPri("VER DETALLE", R.drawable.sabiaque, "¿SABIAS QUÉ?"));

        Lista.add(new mMainPri("VER DETALLE", R.drawable.lumosityapp, "APP LUMOSITY"));


        final adapterPrMain adapter = new adapterPrMain(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                mMainPri minit = (mMainPri) adapter.getItem(position);


                switch (position) {

                    case 0:

                    {
                        Fragment fragment = new librosfragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }

                    }


                    break;


                    case 1:

                    {


                        Fragment fragment = new MultimediaFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);

                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                    }


                    break;


                    case 2:

                    {


                        Fragment fragment = new asesoriaFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                    }


                    break;


                    case 3:

                    {


                        Fragment fragment = new diccionarioFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }


                    break;


                    case 4:

                    {


                        Fragment fragment = new appCalculoFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }


                    break;


                    case 5: {


                        Fragment fragment = new ajedrezFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }

                    break;

                    case 6:

                    {


                        Fragment fragment = new motivacionFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("ACCESO", nivelacceso);
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                    }
                    break;


                    case 7:

                    {


                        String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

//                        if (connectionDetector.isConnected()) {
//                            if (sharedata.substring(0, 1).equalsIgnoreCase("5")) {
//                                String listChanel = "PLLnivJhjddCK-PKYNbGi9JfUer_jkoA62";
//                                Intent intent = new Intent(getContext(), YouTubeViewer.class);
//                                intent.putExtra("lista_canal", listChanel);
//                                startActivity(intent);
//
//                            } else if (sharedata.substring(0, 1).equalsIgnoreCase("6"))
//
//                            {
//                                String listChanel = "PLcWdL9UMc9NpIkOM1tiW4u7qAyN7QUwST";
//                                Intent intent = new Intent(getContext(), YouTubeViewer.class);
//                                intent.putExtra("lista_canal", listChanel);
//                                startActivity(intent);
//
//                            }
//                        } else {
//                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
//                        }


                        Fragment fragment = new unidadFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("Temario", "DIVERTI APRENDO");
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }
                        // }

                        break;

                    }


                    case 8:

                    {

                        Fragment fragment = new unidadFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("Temario", "PLAN LECTOR");
                            fragment.setArguments(args);
                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }

                    }


                    break;


                    case 9:

                    {

                        Fragment fragment = new unidadFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("Temario", "VIDEO SEMINARIO");
                            fragment.setArguments(args);
                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }

                    }


                        break;


                    case 10:


                        appName = "Gmail";
                        packageName = "org.simo.medita&hl=es_419";

                        box = "org.simo.medita&hl=es_419";

                        openApp(getContext(), appName, packageName);

                        break;


                    case 11:


                        if (connectionDetector.isConnected()) {
                            Fragment fragment = new fragmentSabiasQ();
                            FragmentManager fmanager = getActivity().getSupportFragmentManager();
                            if (fmanager != null) {

                                FragmentTransaction ftransaction = fmanager.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;


                    case 12:


                        if (connectionDetector.isConnected()) {

                            appName = "Gmail";
                            packageName = "com.lumoslabs.lumosity";
                            box = "com.lumoslabs.lumosity";
                            openApp(getContext(), appName, packageName);
                        } else {
                            Toast.makeText(getContext(), "Estás sin Conexión", Toast.LENGTH_SHORT).show();
                        }
                        break;


                }

            }
        });


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
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();

        startNewActivity(getContext(), box);


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


    static String PREFS_KEY = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }


}
