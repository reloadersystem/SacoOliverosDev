package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.NewsPaper.SConsultNoticia;
import pe.sacooliveros.apptablet.NewsPaper.ServiceNoticia;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterAdmisionCiencia;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterCapitulosLetra;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterSimulacroUni;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.CapitulosAdmisionfragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.SimulacrosUNIFragment;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentEnglish;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterSeleccion;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mSeleccionMain;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.PopupCustomDialog;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeleccionFragment extends Fragment {

    private GridView gridView;
    ArrayList<mSeleccionMain> Lista;
    TextView tx_temas;
    View rootview;
    RelativeLayout lnLayout;
    ConnectionDetector cd;
    String servidor_ruta;


    public SeleccionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_seleccion, container, false);

        gridView = rootview.findViewById(R.id.grid_SeleccionMain);

        lnLayout = rootview.findViewById(R.id.relative_meditacion);

        Lista = new ArrayList<mSeleccionMain>();

        Lista.add(new mSeleccionMain(R.drawable.seleccion_7));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_8));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_5));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_6));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_4));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_2));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_3));
        Lista.add(new mSeleccionMain(R.drawable.seleccion_1));

        cd = new ConnectionDetector(getContext());

        servidor_ruta = getContext().getString(R.string.servidor_ruta);


        final adapterSeleccion adapter = new adapterSeleccion(getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                switch (position) {
                    case 0:

                        Fragment fragment = new fragmentEnglish();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            fragment.setArguments(args);

                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenUniFragments, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;

                    case 1:

                        if (cd.isConnected()) {

                            String urldata = servidor_ruta + "/APP/MEDITACION_GENERAL.json";

                            ServiceNoticia.urljson(urldata);
                            SConsultNoticia consult = new SConsultNoticia();
                            consult.setCurrentContext(getContext());
                            consult.setCurrentLayout(lnLayout);
                            consult.execute("");

                            break;

                        } else

                            Toast.makeText(getContext(), "Necesitás Conexión a Internet", Toast.LENGTH_SHORT).show();

                        break;


                    case 2:


                        String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");


                        if (sharedata.equalsIgnoreCase("601 Secundaria") || sharedata.equalsIgnoreCase("601 Primaria"))

                        {
                            Fragment fragment2 = new AcademiaFragment();
                            FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                            if (fmanager2 != null) {

                                Bundle args = new Bundle();
                                fragment2.setArguments(args);

                                FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }
                            break;

                        } else if (sharedata.equalsIgnoreCase("701 Secundaria")) {
                            Fragment fragment2 = new SemestralesFragment();
                            FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                            if (fmanager2 != null) {

                                Bundle args = new Bundle();
                                fragment2.setArguments(args);

                                FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                if (ftransaction != null) {
                                    ftransaction.replace(R.id.contenUniFragments, fragment2);
                                    ftransaction.addToBackStack("");
                                    ftransaction.commit();
                                }
                            }

                            break;
                        }


                    case 3:

                        Fragment fragment3 = new OlimpiadasConcursosFragment();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            fragment3.setArguments(args);

                            FragmentTransaction ftransaction = fmanager3.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenUniFragments, fragment3);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;


                    case 4:

                        Fragment fragment4 = new SeleccionExamenAdFragment();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            fragment4.setArguments(args);

                            FragmentTransaction ftransaction = fmanager4.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenUniFragments, fragment4);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }
                        }

                        break;

                    case 5:

                        final AlertDialog alertDialog;
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View view2 = inflater.inflate(R.layout.popupcapitulos, null);

                        CardView crd_capitulos1;
                        CardView crd_capitulos2;
                        CardView crd_capitulos3;


                        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
                        crd_capitulos1 = view2.findViewById(R.id.crd_capitulos_1);
                        crd_capitulos2 = view2.findViewById(R.id.crd_capitulos_2);
                        crd_capitulos3 = view2.findViewById(R.id.crd_capitulos_3);

                        builder.setView(view2);
                        alertDialog = builder.create();
                        alertDialog.show();

                        crd_capitulos1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                //CapitulosAdmisionfragment

                                adapterAdmisionCiencia.seleccionciencias("UNI");
                                adapterCapitulosLetra.seleccionletras("UNI");
                                CapitulosAdmisionfragment.nombreseleccion("UNI");


                                Fragment fragment4 = new CapitulosAdmisionfragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog.dismiss();

                            }

                        });

                        crd_capitulos2.setOnClickListener((new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                adapterAdmisionCiencia.seleccionciencias("SAN MARCOS");
                                adapterCapitulosLetra.seleccionletras("SAN MARCOS");
                                CapitulosAdmisionfragment.nombreseleccion("SAN MARCOS");


                                Fragment fragment4 = new CapitulosAdmisionfragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog.dismiss();


                            }
                        }));

                        crd_capitulos3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                adapterAdmisionCiencia.seleccionciencias("CATOLICA");
                                adapterCapitulosLetra.seleccionletras("CATOLICA");
                                CapitulosAdmisionfragment.nombreseleccion("CATÓLICA");


                                Fragment fragment4 = new CapitulosAdmisionfragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog.dismiss();

                            }
                        });

                        btn_cerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });


                        break;


                    case 6:


                        final AlertDialog alertDialog2;
                        final AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater2 = LayoutInflater.from(getContext());

                        View view3 = inflater2.inflate(R.layout.popupsimulacros, null);

                        CardView crd_simulacros1;
                        CardView crd_simulacros2;
                        CardView crd_simulacros3;


                        Button btn_cerrar2 = view3.findViewById(R.id.btn_cerrar);
                        crd_simulacros1 = view3.findViewById(R.id.crd_simulacro_1);
                        crd_simulacros2 = view3.findViewById(R.id.crd_simulacro_2);
                        crd_simulacros3 = view3.findViewById(R.id.crd_simulacro_3);

                        builder2.setView(view3);
                        alertDialog2 = builder2.create();
                        alertDialog2.show();

                        crd_simulacros1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                adapterSimulacroUni.nombreseleccion("UNI");
                                SimulacrosUNIFragment.nombreseleccion("UNI");

                                Fragment fragment4 = new SimulacrosUNIFragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog2.dismiss();

                            }

                        });

                        crd_simulacros2.setOnClickListener((new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                adapterSimulacroUni.nombreseleccion("SAN MARCOS");
                                SimulacrosUNIFragment.nombreseleccion("SAN MARCOS");

                                Fragment fragment4 = new SimulacrosUNIFragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog2.dismiss();

                            }
                        }));

                        crd_simulacros3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                adapterSimulacroUni.nombreseleccion("CATOLICA");
                                SimulacrosUNIFragment.nombreseleccion("CATOLICA");


                                Fragment fragment4 = new SimulacrosUNIFragment();
                                FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                                if (fmanager4 != null) {

                                    Bundle args = new Bundle();
                                    fragment4.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager4.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenUniFragments, fragment4);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                alertDialog2.dismiss();

                            }
                        });

                        btn_cerrar2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog2.dismiss();
                            }
                        });


                        break;

                    case 7:

                        ArrayList<mPruebas> mListPruebas;
                        mListPruebas = new ArrayList<mPruebas>();
                        PopupCustomDialog popupCustomDialog = new PopupCustomDialog();

                        mListPruebas.add(new mPruebas("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
                        mListPruebas.add(new mPruebas("BATMAN ONE YEAR", "https://vercomics.com/batman-ano-uno-1/"));
                        mListPruebas.add(new mPruebas("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
                        mListPruebas.add(new mPruebas("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));

                        popupCustomDialog.customDialog(getContext(), "LECTURAS MOTIVADORAS", mListPruebas);

                        break;


                }

            }
        });


        return rootview;
    }


}
