package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAdmisionCiencia;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterBimestreCatolica;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterCapitulosAdmision;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterCapitulosLetra;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mCapitulosAdmision;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Seleccion.fragments.SeleccionFragment;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class CapitulosAdmisionfragment extends Fragment {


    private GridView gridView;
    ArrayList<mCapitulosAdmision> Lista;

    ImageView img_temas;

    String descrip, grado;


    String acceso;

    View rootview;

    String gradoasiste;

    String datoshare;

    String tipogradoasiste;

    TextView tx_tipouniversidad;

    static String nombreselect;


    public CapitulosAdmisionfragment() {
        // Required empty public constructor
    }

    public static void nombreseleccion(String seleccion) {
        nombreselect = seleccion;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_capitulos_admisionfragment, container, false);

        datoshare = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");


        img_temas = rootview.findViewById(R.id.img_capitulosadmision);
        gridView = rootview.findViewById(R.id.grid_capitulosadmision);
        tx_tipouniversidad = rootview.findViewById(R.id.tx_titulovhs);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        if (datoshare.equalsIgnoreCase("SELECCION")) {
            tx_tipouniversidad.setText(nombreselect);
        }

        if (datoshare.equalsIgnoreCase("UNI")) {
            tx_tipouniversidad.setText("UNI");
        }

        if (datoshare.equalsIgnoreCase("SAN MARCOS")) {
            tx_tipouniversidad.setText("SAN MARCOS");
        }

        if (datoshare.equalsIgnoreCase("CATOLICA")) {
            tx_tipouniversidad.setText("CATÓLICA");
        }

        if (datoshare.equalsIgnoreCase("PRE")) {
            tx_tipouniversidad.setText("PRE");
        }


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tipogradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");


                if (tipogradoasiste.equalsIgnoreCase("REGULAR")) {
                    Fragment fragment2 = new InitialFragment();
                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                    if (fmanager2 != null) {


                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("UNI") || tipogradoasiste.equalsIgnoreCase("PRE")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }

                } else if (tipogradoasiste.equalsIgnoreCase("SELECCION")) {

                    Fragment fragment3 = new SeleccionFragment();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenUniFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }

                } else if (tipogradoasiste.equalsIgnoreCase("SAN MARCOS")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("CATOLICA")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                }

            }

        });


        Lista = new ArrayList<mCapitulosAdmision>();

        if (datoshare.equalsIgnoreCase("CATOLICA")) {
            Lista.add(new mCapitulosAdmision(R.drawable.diapcatolica_1, "Tomo 1"));
            Lista.add(new mCapitulosAdmision(R.drawable.diapcatolica_2, "Tomo 2"));
            Lista.add(new mCapitulosAdmision(R.drawable.diapcatolica_3, "Tomo 3"));
            Lista.add(new mCapitulosAdmision(R.drawable.diapcatolica_4, "Tomo 4"));
        } else

        {
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_1, "Tomo 1"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_2, "Tomo 2"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_3, "Tomo 3"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_4, "Tomo 4"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_5, "Tomo 5"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_6, "Tomo 6"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_7, "Tomo 7"));
            Lista.add(new mCapitulosAdmision(R.drawable.secundariatomovm_8, "Tomo 8"));
        }


        final adapterCapitulosAdmision adapter = new adapterCapitulosAdmision(getContext(), Lista);

        gridView.setAdapter(adapter);


        if (gradoasiste == null) {
            gradoasiste = datoshare;
        }


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {

                    case 0:

                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO1");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO1");

                            Fragment fragment0 = new tomoCapitulosFragment();
                            FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                            if (fmanager0 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 1");
                                fragment0.setArguments(args);

                                FragmentTransaction ftransaction = fmanager0.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment0);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;

                        } else if (datoshare.equalsIgnoreCase("CATOLICA")) {

                            adapterBimestreCatolica.bimestreCatolica("BIMESTRE 1");

                            Fragment fragment0 = new prcapituloCatolicaFragment();
                            FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                            if (fmanager0 != null) {

                                Bundle args = new Bundle();

                                args.putString("bimestredesc", "BIMESTRE 1");
                                fragment0.setArguments(args);

                                FragmentTransaction ftransaction = fmanager0.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment0);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;
                        }


                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO1");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO1");

                        Fragment fragment0 = new tomoCapitulosFragment();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 1");
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 1:


                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        //la diferencia  es el contenedor

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO2");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO2");

                            Fragment fragment1 = new tomoCapitulosFragment();
                            FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                            if (fmanager1 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 2");
                                fragment1.setArguments(args);

                                FragmentTransaction ftransaction = fmanager1.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment1);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        } else if (datoshare.equalsIgnoreCase("CATOLICA"))

                        {

                            adapterBimestreCatolica.bimestreCatolica("BIMESTRE 2");
                            Fragment fragment1 = new prcapituloCatolicaFragment();
                            FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                            if (fmanager1 != null) {

                                Bundle args = new Bundle();
                                args.putString("bimestredesc", "BIMESTRE 2");
                                fragment1.setArguments(args);

                                FragmentTransaction ftransaction = fmanager1.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment1);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        }


                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO2");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO2");

                        Fragment fragment1 = new tomoCapitulosFragment();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 2");
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


                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO3");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO3");

                            Fragment fragment2 = new tomoCapitulosFragment();
                            FragmentManager fmanager = getActivity().getSupportFragmentManager();
                            if (fmanager != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 3");
                                fragment2.setArguments(args);

                                FragmentTransaction ftransaction = fmanager.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        } else if (datoshare.equalsIgnoreCase("CATOLICA"))

                        {
                            adapterBimestreCatolica.bimestreCatolica("BIMESTRE 3");

                            Fragment fragment2 = new prcapituloCatolicaFragment();
                            FragmentManager fmanager = getActivity().getSupportFragmentManager();
                            if (fmanager != null) {

                                Bundle args = new Bundle();

                                args.putString("bimestredesc", "BIMESTRE 3");
                                fragment2.setArguments(args);

                                FragmentTransaction ftransaction = fmanager.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenedorFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        }

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO3");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO3");

                        Fragment fragment2 = new tomoCapitulosFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 3");
                            fragment2.setArguments(args);

                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment2);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                        break;


                    case 3:

                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO4");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO4");

                            Fragment fragment3 = new tomoCapitulosFragment();
                            FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                            if (fmanager3 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 4");
                                fragment3.setArguments(args);

                                FragmentTransaction ftransaction = fmanager3.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment3);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;

                        } else if (datoshare.equalsIgnoreCase("CATOLICA"))

                        {

                            adapterBimestreCatolica.bimestreCatolica("BIMESTRE 4");
                            Fragment fragment3 = new prcapituloCatolicaFragment();
                            FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                            if (fmanager3 != null) {

                                Bundle args = new Bundle();

                                args.putString("bimestredesc", "BIMESTRE 4");
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

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO4");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO4");

                        Fragment fragment3 = new tomoCapitulosFragment();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 4");
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

                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO5");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO5");

                            Fragment fragment4 = new tomoCapitulosFragment();
                            FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                            if (fmanager4 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 5");
                                fragment4.setArguments(args);

                                FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment4);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }
                            break;

                        }

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO5");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO5");

                        Fragment fragment4 = new tomoCapitulosFragment();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 5");
                            fragment4.setArguments(args);

                            FragmentTransaction ftransaction = fmanager4.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment4);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                        break;


                    case 5:


                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO6");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO6");

                            Fragment fragment5 = new tomoCapitulosFragment();
                            FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                            if (fmanager5 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 6");
                                fragment5.setArguments(args);

                                FragmentTransaction ftransaction = fmanager5.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment5);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;
                        }

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO6");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO6");

                        Fragment fragment5 = new tomoCapitulosFragment();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 6");
                            fragment5.setArguments(args);

                            FragmentTransaction ftransaction = fmanager5.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment5);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                        break;


                    case 6:


                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO7");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO7");

                            Fragment fragment6 = new tomoCapitulosFragment();
                            FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                            if (fmanager6 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 7");
                                fragment6.setArguments(args);

                                FragmentTransaction ftransaction = fmanager6.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment6);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;
                        }

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO7");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO7");

                        Fragment fragment6 = new tomoCapitulosFragment();
                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                        if (fmanager6 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 7");
                            fragment6.setArguments(args);

                            FragmentTransaction ftransaction = fmanager6.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment6);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                        break;

                    case 7:

                        if (datoshare.equalsIgnoreCase("SELECCION"))

                        {
                            adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO8");
                            adapterCapitulosLetra.tomoCapitulosLetras("TOMO8");

                            Fragment fragment7 = new tomoCapitulosFragment();
                            FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                            if (fmanager7 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);
                                args.putString("tomodesc", "TOMO 8");
                                fragment7.setArguments(args);

                                FragmentTransaction ftransaction = fmanager7.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment7);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }

                            }

                            break;
                        }

                        adapterAdmisionCiencia.tomoCapitulosCiencia("TOMO8");
                        adapterCapitulosLetra.tomoCapitulosLetras("TOMO8");

                        Fragment fragment7 = new tomoCapitulosFragment();
                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                        if (fmanager7 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "TOMO 8");
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

            }
        });


        return rootview;
    }

}
