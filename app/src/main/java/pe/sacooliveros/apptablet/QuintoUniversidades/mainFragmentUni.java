package pe.sacooliveros.apptablet.QuintoUniversidades;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.fragments.ajedrezFragment;
import pe.sacooliveros.apptablet.QuintoCatolica.Fragment.fragment_TCatolica_Seminario;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterMainU;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mMainU;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.CapitulosAdmisionfragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.ContentLecturasFragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.SimulacrosUNIFragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.examenAnualFragment;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.VideoMotivadoresFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentEnglish;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentFisica;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentHDiapositivas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentMotivadores;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPFMatematica;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentVSeminario;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.PopupCustomDialog;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.content.Context.MODE_PRIVATE;
import static java.lang.Thread.sleep;

/**
 * A simple {@link Fragment} subclass.
 */
public class mainFragmentUni extends Fragment {

    static String nivel;
    static String nivelacceso;
    static String gradoasiste;
    static String PREFS_KEY = "autenticacionOff";
    View rootview;
    ArrayList<mMainU> Lista;
    String grado;
    ConnectionDetector cd;
    String ruta;
    String ruta_storage;
    String rutaficheroGuardado;
    String universidad;
    private GridView gridView;

    String gradonombre;

    public mainFragmentUni() {
        // Required empty public constructor
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_main_fragment_uni, container, false);
        gridView = rootview.findViewById(R.id.ma_mainU);

        cd = new ConnectionDetector(getContext());

        gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");

        if (nivel == null) {
            String dato1 = obtenerValor(getContext(), "ServerGradoNivel");
            gradoasiste = obtenerValor(getContext(), "TipoGradoAsiste");

            nivelacceso = String.valueOf(dato1.charAt(0));

        } else {
            nivelacceso = String.valueOf(nivel.charAt(0));
            gradoasiste = obtenerValor(getContext(), "TipoGradoAsiste");
        }

        Lista = new ArrayList<mMainU>();

        if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("REGULAR"))

        {
            Lista.add(new mMainU(R.drawable.secundariamain_1));
            Lista.add(new mMainU(R.drawable.secundariamain_2));
            Lista.add(new mMainU(R.drawable.secundariamain_3));
            Lista.add(new mMainU(R.drawable.secundariamain_7));
            // Lista.add(new mMainU(R.drawable.secundariamain_4));
            Lista.add(new mMainU(R.drawable.secundariamain_5));
            Lista.add(new mMainU(R.drawable.secundariamain_9));
            Lista.add(new mMainU(R.drawable.secundariamain_6));
            Lista.add(new mMainU(R.drawable.secundariamain_14));

        }

        if (gradoasiste.equalsIgnoreCase("uni")) {
            universidad = "3";
            Lista.add(new mMainU(R.drawable.uniexamenanual));
            Lista.add(new mMainU(R.drawable.capitulosuni));
            Lista.add(new mMainU(R.drawable.simulacroscatolica));
            Lista.add(new mMainU(R.drawable.lecturascatolica));

        } else if (gradoasiste.equalsIgnoreCase("SAN MARCOS")) {
            universidad = "4";
            Lista.add(new mMainU(R.drawable.anualexamensm));
            Lista.add(new mMainU(R.drawable.sanmarcoscapitulos));
            Lista.add(new mMainU(R.drawable.simulacroscatolica));
            Lista.add(new mMainU(R.drawable.lecturascatolica));

        } else if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
            universidad = "5";
            Lista.add(new mMainU(R.drawable.secundariamain_1));
            Lista.add(new mMainU(R.drawable.secundariamain_3));
            Lista.add(new mMainU(R.drawable.secundariamain_7));
            Lista.add(new mMainU(R.drawable.secundariamain_5));
            Lista.add(new mMainU(R.drawable.secundariamain_9));
            Lista.add(new mMainU(R.drawable.secundariamain_6));
            Lista.add(new mMainU(R.drawable.secundariamain_14));
            Lista.add(new mMainU(R.drawable.examenanualcatolica));
            Lista.add(new mMainU(R.drawable.simulacroscatolica));
            Lista.add(new mMainU(R.drawable.capituloscatolica));
            Lista.add(new mMainU(R.drawable.lecturascatolica));

        } else if (gradoasiste.equalsIgnoreCase("PRE")) {
            universidad = "5";
            Lista.add(new mMainU(R.drawable.secundariamain_1));
            Lista.add(new mMainU(R.drawable.secundariamain_2));
            Lista.add(new mMainU(R.drawable.secundariamain_3));
            Lista.add(new mMainU(R.drawable.secundariamain_7));
            // Lista.add(new mMainU(R.drawable.secundariamain_4));
            Lista.add(new mMainU(R.drawable.secundariamain_5));
            Lista.add(new mMainU(R.drawable.secundariamain_9));
            Lista.add(new mMainU(R.drawable.secundariamain_6));
            Lista.add(new mMainU(R.drawable.secundariamain_14));
            Lista.add(new mMainU(R.drawable.anualexamensm));
            Lista.add(new mMainU(R.drawable.sanmarcoscapitulos));
            Lista.add(new mMainU(R.drawable.simulacroscatolica));
            Lista.add(new mMainU(R.drawable.lecturascatolica));
        }


        final adapterMainU adapter = new adapterMainU(getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch ((position)) {

                    case 0:

                        Fragment fragment = new VideoMotivadoresFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "VIDEO HELICO MOTIVADORES");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment.setArguments(args);

                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment);
                                ftransaction.addToBackStack("");

                                ftransaction.commit();
                            }
                        }

                        break;

                    case 1:

                        //gradoasiste = obtenerValor(getContext(), "TipoGradoAsiste");

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment2 = new fragmentHDiapositivas();
                            FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                            if (fmanager2 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "HELICO DIAPOSITIVAS");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment2.setArguments(args);

                                FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }

                        Fragment fragment1 = new fragmentMotivadores();
                        //TODO  COMPENDIOS
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "COMPENDIOS");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment1.setArguments(args);

                            FragmentTransaction ftransaction = fmanager1.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment1);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 2:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment3 = new fragmentEnglish();
                            FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                            if (fmanager3 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "HELICO ENGLISH");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment3.setArguments(args);

                                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment3);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }

                        Fragment fragment2 = new fragmentHDiapositivas();
                        FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                        if (fmanager2 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "HELICO DIAPOSITIVAS");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment2.setArguments(args);

                            FragmentTransaction ftransaction = fmanager2.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment2);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 3:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment9 = new fragment_TCatolica_Seminario();
                            FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                            if (fmanager9 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "Video Helico Seminario");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment9.setArguments(args);


                                FragmentTransaction ftransaction = fmanager9.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment9);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        }


                        Fragment fragment3 = new fragmentEnglish();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "HELICO ENGLISH");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment3.setArguments(args);

                            FragmentTransaction ftransaction = fmanager3.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment3);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }


                        break;


                    case 4:


                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment6 = new fragmentFisica();
                            FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                            if (fmanager6 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "EDUCACIÓN FÍSICA");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment6.setArguments(args);

                                FragmentTransaction ftransaction = fmanager6.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment6);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;

                        }


//                        if (cd.isConnected())
//
//                        {
//                            Intent intent = new Intent(getContext(), ActivityAulaVirtual.class);
//                            startActivity(intent);
//                            break;
//                        } else {
//                            Toast.makeText(getContext(), "Necesitas Conexión para Visualizar  el Contenido", Toast.LENGTH_SHORT).show();
//                        }


                        if (gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {
                            Fragment fragment9 = new fragmentVSeminario();
                            FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                            if (fmanager9 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "Video Helico Seminario");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment9.setArguments(args);


                                FragmentTransaction ftransaction = fmanager9.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment9);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        }


                        Fragment fragment5 = new fragmentVSeminario();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "VIDEO HELICO SEMINARIO");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", " ");

                            fragment5.setArguments(args);

                            FragmentTransaction ftransaction = fmanager5.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment5);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 5:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment7 = new fragmentPFMatematica();
                            FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                            if (fmanager7 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "FUNDAMENTO DE LA MATEMÁTICA");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment7.setArguments(args);

                                FragmentTransaction ftransaction = fmanager7.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment7);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;

                        }

                        Fragment fragment6 = new fragmentFisica();
                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                        if (fmanager6 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "EDUCACIÓN FÍSICA");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment6.setArguments(args);

                            FragmentTransaction ftransaction = fmanager6.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment6);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 6:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment8 = new ajedrezFragment();
                            FragmentManager fmanager8 = getActivity().getSupportFragmentManager();
                            if (fmanager8 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "AJEDREZ");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment8.setArguments(args);

                                FragmentTransaction ftransaction = fmanager8.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment8);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;

                        }

                        Fragment fragment7 = new fragmentPFMatematica();
                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                        if (fmanager7 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "FUNDAMENTO DE LA MATEMÁTICA");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment7.setArguments(args);

                            FragmentTransaction ftransaction = fmanager7.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment7);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 7:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment9 = new examenAnualFragment();
                            FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                            if (fmanager9 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "EXÁMENES DE ADMISIÓN");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment9.setArguments(args);

                                FragmentTransaction ftransaction = fmanager9.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment9);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }

                        Fragment fragment8 = new ajedrezFragment();
                        FragmentManager fmanager8 = getActivity().getSupportFragmentManager();
                        if (fmanager8 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "AJEDREZ");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment8.setArguments(args);

                            FragmentTransaction ftransaction = fmanager8.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment8);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 8:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment11 = new SimulacrosUNIFragment();
                            FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                            if (fmanager11 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "SIMULACROS EXÁMEN DE ADMISIÓN");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment11.setArguments(args);

                                FragmentTransaction ftransaction = fmanager11.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment11);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }

                        Fragment fragment9 = new examenAnualFragment();
                        FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                        if (fmanager9 != null) {
                            Bundle args = new Bundle();
                            args.putString("description", "EXÁMENES DE ADMISIÓN");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment9.setArguments(args);

                            FragmentTransaction ftransaction = fmanager9.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment9);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 9:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment10 = new CapitulosAdmisionfragment();
                            FragmentManager fmanager10 = getActivity().getSupportFragmentManager();
                            if (fmanager10 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "HELICO DIAPOSITIVAS");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment10.setArguments(args);

                                FragmentTransaction ftransaction = fmanager10.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment10);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }

                        Fragment fragment10 = new CapitulosAdmisionfragment();
                        FragmentManager fmanager10 = getActivity().getSupportFragmentManager();
                        if (fmanager10 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "HELICO DIAPOSITIVAS");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment10.setArguments(args);

                            FragmentTransaction ftransaction = fmanager10.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment10);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 10:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            lecturamotivadoraDialog();

                            break;
                        } else

                        {
                            Fragment fragment11 = new SimulacrosUNIFragment();
                            FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                            if (fmanager11 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "SIMULACROS EXÁMEN DE ADMISIÓN");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment11.setArguments(args);

                                FragmentTransaction ftransaction = fmanager11.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment11);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;

                        }


                    case 11:

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                            Fragment fragment11 = new SimulacrosUNIFragment();
                            FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                            if (fmanager11 != null) {
                                Bundle args = new Bundle();
                                args.putString("description", "SIMULACROS EXÁMEN DE ADMISIÓN");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment11.setArguments(args);

                                FragmentTransaction ftransaction = fmanager11.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment11);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;

                        } else {

                            ArrayList<mPruebas> mListPruebas;
                            mListPruebas = new ArrayList<mPruebas>();
                            PopupCustomDialog popupCustomDialog = new PopupCustomDialog();

                            mListPruebas.add(new mPruebas("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
                            mListPruebas.add(new mPruebas("BATMAN ONE YEAR", "https://vercomics.com/batman-ano-uno-1/"));
                            mListPruebas.add(new mPruebas("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
                            mListPruebas.add(new mPruebas("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));

                            popupCustomDialog.customDialog(getContext(), " LECTURAS MOTIVADORAS", mListPruebas);

                            break;
                        }


                    case 12:

                        ArrayList<mPruebas> mListPruebas;
                        mListPruebas = new ArrayList<mPruebas>();
                        PopupCustomDialog popupCustomDialog = new PopupCustomDialog();

                        mListPruebas.add(new mPruebas("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
                        mListPruebas.add(new mPruebas("BATMAN ONE YEAR", "https://vercomics.com/batman-ano-uno-1/"));
                        mListPruebas.add(new mPruebas("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
                        mListPruebas.add(new mPruebas("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));

                        popupCustomDialog.customDialog(getContext(), " LECTURAS MOTIVADORAS", mListPruebas);

                        break;
                }

            }
        });


        return rootview;

    }

    private void descargarPDF(String urlADescargar) {

        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setIndeterminate(true);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage("Descargando PDF...");

        new DescargarPDFAsynTask(progressDialog).execute(urlADescargar);
    }


    private class DescargarPDFAsynTask extends AsyncTask<String, Integer, String> {

        ProgressDialog progressDialog;

        public DescargarPDFAsynTask(ProgressDialog progressDialog) {
            this.progressDialog = progressDialog;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... urlPDF) {

            HttpURLConnection conexion = null;
            InputStream input = null;
            OutputStream output = null;

            ruta_storage = getContext().getString(R.string.ruta_raiz);


            String urlADescargar = urlPDF[0];

            try {
                URL url = new URL(urlADescargar);
                conexion = (HttpURLConnection) url.openConnection();
                conexion.connect();

                if (conexion.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Conexion no realizada correctamente";
                }

                input = conexion.getInputStream();

                rutaficheroGuardado = "/data/user/0/pe.sacooliveros.apptablet/files/APP/" + universidad + "/5/LECTURAS_MOTIVADORAS/" + ruta;


                output = new FileOutputStream((rutaficheroGuardado));

                int tamanoFichero = conexion.getContentLength();

                byte[] data = new byte[3072];
                int count;
                int total = 0;


                while ((count = input.read(data)) != -1) {

                    sleep(1);
                    output.write(data, 0, count);

                    total += count;
                    publishProgress((int) (total * 100 / tamanoFichero));

                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Error: " + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Sin Conexion";
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (input != null) input.close();
                    if (output != null) output.close();
                    if (conexion != null) conexion.disconnect();

                    progressDialog.dismiss();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return "Se realizo Correctamente";
        }


        @Override
        protected void onProgressUpdate(Integer... values) {

            super.onProgressUpdate(values);

            progressDialog.setIndeterminate(false);
            progressDialog.setMax(100);
            progressDialog.setProgress(values[0]);

        }

        @Override
        protected void onPostExecute(String mensaje) {
            super.onPostExecute(mensaje);


            Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }
    }


    public void lecturamotivadoraDialog() {


        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        String tipogrado = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        LayoutInflater inflater = LayoutInflater.from(getContext());

        View view2 = inflater.inflate(R.layout.popuplecturas, null);

        GridView lvView = view2.findViewById(R.id.grid_pruebas);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        ImageButton imgmedita = view2.findViewById(R.id.img_meditapp);

        //img_meditapp

        if(tipogrado.equalsIgnoreCase("CATOLICA"))
        {
            imgmedita.setVisibility(View.GONE);
        }


        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        ArrayList<mPruebas> mListPruebas;

        mListPruebas = new ArrayList<mPruebas>();


        mListPruebas.add(new mPruebas("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
        mListPruebas.add(new mPruebas("BATMAN ONE YEAR", "https://vercomics.com/batman-ano-uno-1/"));
        mListPruebas.add(new mPruebas("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
        mListPruebas.add(new mPruebas("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));

        final adapterPruebas adapter2 = new adapterPruebas(getContext(), mListPruebas);
        lvView.setAdapter(adapter2);

        if (tipogrado.equalsIgnoreCase("CATOLICA")) {

            Button btn_materiales = view2.findViewById(R.id.btn_materiales);

            btn_materiales.setVisibility(View.VISIBLE);

            btn_materiales.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fragment fragment11 = new ContentLecturasFragment();
                    FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                    if (fmanager11 != null) {
                        Bundle args = new Bundle();
                        args.putString("description", "SIMULACROS EXÁMEN DE ADMISIÓN");
                        args.putString("grado", grado);
                        args.putString("ACCESO", nivelacceso);
                        args.putString("TipoGradoAsiste", gradoasiste);
                        fragment11.setArguments(args);

                        FragmentTransaction ftransaction = fmanager11.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment11);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }


                    alertDialog.dismiss();

                }
            });
        }


        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:

                    {
                        Uri uri = Uri.parse("http://docs.google.com/gview?embedded=true&url=http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);

                    }
                    break;


                    case 1:

                    {
                        Uri uri = Uri.parse("https://vercomics.com/batman-ano-uno-1/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);

                    }
                    break;


                    case 2:

                    {
                        Uri uri = Uri.parse("https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);

                    }
                    break;


                    case 3:

                    {
                        Uri uri = Uri.parse("https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        getContext().startActivity(intent);
                    }
                    break;
                }
            }
        });


        btn_cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }


}
