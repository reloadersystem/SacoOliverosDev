package pe.sacooliveros.apptablet.Secundaria;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import pe.sacooliveros.apptablet.Balotario.BalotarioMenuActivity;
import pe.sacooliveros.apptablet.Primaria.fragments.ajedrezFragment;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterInit;
import pe.sacooliveros.apptablet.Secundaria.Model.mInit;
import pe.sacooliveros.apptablet.Secundaria.fragments.TomoAsesoriasFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.VideoMotivadoresFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.contentFisicaFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentComputacion;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentEnglish;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentHDiapositivas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentMotivadores;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPFMatematica;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPlanLector;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentPropuestos;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentResueltosProblemas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentTVSeminario;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.PopupAlertManager;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class InitialFragment extends Fragment {

    View rootview;
    private GridView gridView;
    ArrayList<mInit> Lista;
    String grado;
    ConnectionDetector cd;
    String box;
    static String nivel;
    static String nivelacceso;
    static String gradoasiste;
    String gradonombrepre;
    String servergradonivel;

    public InitialFragment() {
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_initial, container, false);
        gridView = rootview.findViewById(R.id.ma_init);

        gradonombrepre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");
        servergradonivel = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

        if (nivel == null) {
            String dato1 = obtenerValor(getContext(), "ServerGradoNivel");
            gradoasiste = obtenerValor(getContext(), "TipoGradoAsiste");
            nivelacceso = String.valueOf(dato1.charAt(0));

        } else {
            nivelacceso = String.valueOf(nivel.charAt(0));
            gradoasiste = obtenerValor(getContext(), "TipoGradoAsiste");
        }

        cd = new ConnectionDetector(getContext());

        Lista = new ArrayList<mInit>();

        if (gradoasiste.equalsIgnoreCase("PRE") && gradonombrepre.equalsIgnoreCase("Cuarto Año") || gradoasiste.equalsIgnoreCase("REGULAR") && servergradonivel.equalsIgnoreCase("5 Secundaria")
                || gradoasiste.equalsIgnoreCase("CIRCULO") && servergradonivel.equalsIgnoreCase("5 Secundaria")) {

            Lista.add(new mInit(R.drawable.secundariamain_1));
            Lista.add(new mInit(R.drawable.secundariamain_2));
            Lista.add(new mInit(R.drawable.secundariamain_10));
            Lista.add(new mInit(R.drawable.secundariamain_11));
            Lista.add(new mInit(R.drawable.secundariamain_15));
            Lista.add(new mInit(R.drawable.secundariamain_3));
            Lista.add(new mInit(R.drawable.secundariamain_4));
            Lista.add(new mInit(R.drawable.secundariamain_5));
            Lista.add(new mInit(R.drawable.secundariamain_9));
            Lista.add(new mInit(R.drawable.secundariamain_6));
            Lista.add(new mInit(R.drawable.secundariamain_14));
            Lista.add(new mInit(R.drawable.secundariamain_7));
            Lista.add(new mInit(R.drawable.secundariamain_13));
        } else {
            Lista.add(new mInit(R.drawable.secundariamain_1));
            Lista.add(new mInit(R.drawable.secundariamain_2));
            Lista.add(new mInit(R.drawable.secundariamain_10));
            Lista.add(new mInit(R.drawable.secundariamain_11));
            Lista.add(new mInit(R.drawable.secundariamain_15));
            Lista.add(new mInit(R.drawable.secundariamain_3));
            Lista.add(new mInit(R.drawable.secundariamain_8));
            Lista.add(new mInit(R.drawable.secundariamain_4));
            Lista.add(new mInit(R.drawable.secundariamain_12));
            Lista.add(new mInit(R.drawable.secundariamain_5));
            Lista.add(new mInit(R.drawable.secundariamain_9));
            Lista.add(new mInit(R.drawable.secundariamain_6));
            Lista.add(new mInit(R.drawable.secundariamain_14));
            Lista.add(new mInit(R.drawable.secundariamain_7));
            Lista.add(new mInit(R.drawable.secundariamain_13));
        }

        final adapterInit adapter = new adapterInit(getContext(), Lista);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mInit minit = (mInit) adapter.getItem(position);

                switch (position) {

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

                        Fragment fragment4 = new fragmentMotivadores();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "COMPENDIOS");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment4.setArguments(args);

                            FragmentTransaction ftransaction = fmanager4.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment4);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 2:

                        Fragment fragment2 = new fragmentPropuestos();
                        FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                        if (fmanager2 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "PROBLEMAS RESUELTOS");
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

                    {
                        Fragment fragment13 = new fragmentResueltosProblemas();
                        FragmentManager fmanager13 = getActivity().getSupportFragmentManager();
                        if (fmanager13 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "Problemas Resueltos");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment13.setArguments(args);


                            FragmentTransaction ftransaction = fmanager13.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment13);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;
                    }


                    case 4: {

                        Fragment fragment15 = new TomoAsesoriasFragment();
                        FragmentManager fmanager15 = getActivity().getSupportFragmentManager();
                        if (fmanager15 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "Helico Asesorias");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment15.setArguments(args);

                            FragmentTransaction ftransaction = fmanager15.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment15);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;
                    }

                    case 5: {
                        Fragment fragment5 = new fragmentHDiapositivas();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", "HELICO DIAPOSITIVAS");
                            args.putString("grado", grado);
                            args.putString("ACCESO", nivelacceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            fragment5.setArguments(args);

                            FragmentTransaction ftransaction = fmanager5.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment5);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;
                    }


                    case 6: {

                        if (nivelacceso.equalsIgnoreCase("1") || nivelacceso.equalsIgnoreCase("2") || nivelacceso.equalsIgnoreCase("3") || nivelacceso.equalsIgnoreCase("4")) {

                            Fragment fragment6 = new fragmentPlanLector();
                            FragmentManager fmanager6 = getActivity().getSupportFragmentManager();

                            if (fmanager6 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "PLAN LECTOR");
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

                        } else if (nivelacceso.equalsIgnoreCase("5")) {

                            Intent intent = new Intent(getActivity(), BalotarioMenuActivity.class);
                            getActivity().startActivity(intent);
                        }

                        break;

                    }

                    case 7: {

                        if (nivelacceso.equalsIgnoreCase("5")) {

                            Fragment fragment9 = new fragmentTVSeminario();
                            FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                            if (fmanager9 != null) {

                                Bundle args = new Bundle();
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", " ");

                                fragment9.setArguments(args);

                                FragmentTransaction ftransaction = fmanager9.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment9);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;

                        } else {
                            Intent intent = new Intent(getActivity(), BalotarioMenuActivity.class);
                            getActivity().startActivity(intent);
                            break;
                        }

                    }

                    case 8:

                        if (nivelacceso.equalsIgnoreCase("4") | nivelacceso.equalsIgnoreCase("3") | nivelacceso.equalsIgnoreCase("2") | nivelacceso.equalsIgnoreCase("1"))

                        {
                            Fragment fragment8 = new fragmentComputacion();
                            FragmentManager fmanager8 = getActivity().getSupportFragmentManager();
                            if (fmanager8 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "COMPUTACION");
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

                        } else if (nivelacceso.equalsIgnoreCase("5")) {

                            Fragment fragment10 = new contentFisicaFragment();
                            FragmentManager fmanager10 = getActivity().getSupportFragmentManager();
                            if (fmanager10 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "Educación Física");
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

                    case 9:

                        if (nivelacceso.equalsIgnoreCase("5")) {
                            Fragment fragment11 = new fragmentPFMatematica();
                            FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                            if (fmanager11 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "P.F - Matemática");
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


                            Fragment fragment9 = new fragmentTVSeminario();
                            FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                            if (fmanager9 != null) {

                                Bundle args = new Bundle();
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", " ");

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

                    case 10:

                        if (nivelacceso.equalsIgnoreCase("5")) {

                            Fragment fragment12 = new ajedrezFragment();
                            FragmentManager fmanager12 = getActivity().getSupportFragmentManager();
                            if (fmanager12 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "AJEDREZ");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment12.setArguments(args);


                                FragmentTransaction ftransaction = fmanager12.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment12);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;

                        } else {
//                            Fragment fragment10 = new fragmentFisica();
                            Fragment fragment10 = new contentFisicaFragment();

                            FragmentManager fmanager10 = getActivity().getSupportFragmentManager();
                            if (fmanager10 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "Educación Física");
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

                    case 11:

                        if (nivelacceso.equalsIgnoreCase("5")) {
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

                        } else {
                            Fragment fragment11 = new fragmentPFMatematica();
                            FragmentManager fmanager11 = getActivity().getSupportFragmentManager();
                            if (fmanager11 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "P.F - Matemática");
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

                    case 12:

                        if (nivelacceso.equalsIgnoreCase("5")) {

                            ArrayList<mPruebas> mListPruebas;
                            mListPruebas = new ArrayList<mPruebas>();
                            PopupAlertManager popupAlertManager = new PopupAlertManager();

                            mListPruebas.add(new mPruebas("Relajación para niños: la nube", "https://www.youtube.com/watch?v=XXy7C6PftVA"));
                            mListPruebas.add(new mPruebas("Meditación para niños: Viaje a las estrellas", "https://www.youtube.com/watch?v=GomoeckdmgY"));
                            mListPruebas.add(new mPruebas("Meditación y Musicoterapia para niños Liberando Corajes", "https://www.youtube.com/watch?v=FhPeHeEpEm0"));
                            mListPruebas.add(new mPruebas("Relajación para niños: La respiración", "https://www.youtube.com/watch?v=G-HX3vvbDDI"));
                            mListPruebas.add(new mPruebas("Mindfulness para niños:", "https://www.youtube.com/watch?v=OHqG-O1g5Nc"));
                            mListPruebas.add(new mPruebas("Meditación y Risoterapia para niños Aprendiendo a Respirar:", "https://www.youtube.com/watch?v=ZJzzdQUn2do"));
                            mListPruebas.add(new mPruebas("YOGA para niños | El saludo al Sol y Yoga con animales:", "https://www.youtube.com/watch?v=Dwt0qeBj85I"));
                            mListPruebas.add(new mPruebas("YOGIC / Yoga para Niños - TUTORIAL Canción del León:", "https://www.youtube.com/watch?v=Q0AdEHmXIgk"));
                            mListPruebas.add(new mPruebas("Respiración de la Abeja con Minipadmini::", "https://www.youtube.com/watch?v=eSBjHB4ezGs"));
                            mListPruebas.add(new mPruebas("Pequeñas relajaciones: respiración", "https://www.youtube.com/watch?v=_sEa9_EdaOc"));
                            mListPruebas.add(new mPruebas("Yoga para Niños OMMMMMMMMM!!!!!!!!!", "https://www.youtube.com/watch?v=SP5p1gLUOHI"));
                            mListPruebas.add(new mPruebas("Respira - video cuento", "https://www.youtube.com/watch?v=ibJFHBTWBDA&amp=&t=33s"));

                            popupAlertManager.customDialog(getContext(), " MEDITACIÓN", mListPruebas);

                            break;

                        } else {
                            Fragment fragment12 = new ajedrezFragment();
                            FragmentManager fmanager12 = getActivity().getSupportFragmentManager();
                            if (fmanager12 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", "AJEDREZ");
                                args.putString("grado", grado);
                                args.putString("ACCESO", nivelacceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                fragment12.setArguments(args);

                                FragmentTransaction ftransaction = fmanager12.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment12);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;
                        }

                    case 13:

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

                    case 14:

                        ArrayList<mPruebas> mListPruebas;
                        mListPruebas = new ArrayList<mPruebas>();
                        PopupAlertManager popupAlertManager = new PopupAlertManager();

                        mListPruebas.add(new mPruebas("Relajación para niños: la nube", "https://www.youtube.com/watch?v=XXy7C6PftVA"));
                        mListPruebas.add(new mPruebas("Meditación para niños: Viaje a las estrellas", "https://www.youtube.com/watch?v=GomoeckdmgY"));
                        mListPruebas.add(new mPruebas("Meditación y Musicoterapia para niños Liberando Corajes", "https://www.youtube.com/watch?v=FhPeHeEpEm0"));
                        mListPruebas.add(new mPruebas("Relajación para niños: La respiración", "https://www.youtube.com/watch?v=G-HX3vvbDDI"));
                        mListPruebas.add(new mPruebas("Mindfulness para niños:", "https://www.youtube.com/watch?v=OHqG-O1g5Nc"));
                        mListPruebas.add(new mPruebas("Meditación y Risoterapia para niños Aprendiendo a Respirar:", "https://www.youtube.com/watch?v=ZJzzdQUn2do"));
                        mListPruebas.add(new mPruebas("YOGA para niños | El saludo al Sol y Yoga con animales:", "https://www.youtube.com/watch?v=Dwt0qeBj85I"));
                        mListPruebas.add(new mPruebas("YOGIC / Yoga para Niños - TUTORIAL Canción del León:", "https://www.youtube.com/watch?v=Q0AdEHmXIgk"));
                        mListPruebas.add(new mPruebas("Respiración de la Abeja con Minipadmini::", "https://www.youtube.com/watch?v=eSBjHB4ezGs"));
                        mListPruebas.add(new mPruebas("Pequeñas relajaciones: respiración", "https://www.youtube.com/watch?v=_sEa9_EdaOc"));
                        mListPruebas.add(new mPruebas("Yoga para Niños OMMMMMMMMM!!!!!!!!!", "https://www.youtube.com/watch?v=SP5p1gLUOHI"));
                        mListPruebas.add(new mPruebas("Respira - video cuento", "https://www.youtube.com/watch?v=ibJFHBTWBDA&amp=&t=33s"));

                        popupAlertManager.customDialog(getContext(), " MEDITACIÓN", mListPruebas);

                        break;
                }
            }
        });
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else
                Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();
        startNewActivity(getContext(), box);
    }

    private void startNewActivity(Context context, String packageName) {

        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
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

    static String PREFS_KEY = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");
    }
}
