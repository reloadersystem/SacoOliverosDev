package pe.sacooliveros.apptablet.Secundaria.fragments;


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

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterResueltosCiencia;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterResueltosLetras;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterResueltosProblemas;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mResueltosProblemas;
import pe.sacooliveros.apptablet.Secundaria.fragmentResueltos;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentResueltosProblemas extends Fragment {

    private GridView gridView;
    ArrayList<mResueltosProblemas> Lista;
    TextView tx_temas;
    ImageView img_temas;

    String descrip, grado;
    


    String datofragment;

    String acceso;

    View rootview;

    String gradoasiste;

    String datoshare;

    public fragmentResueltosProblemas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_resueltos_problemas, container, false);
        
        tx_temas= rootview.findViewById(R.id.tx_temaVSeminario);
        img_temas= rootview.findViewById(R.id.img_resueltosback);
        gridView= rootview.findViewById(R.id.grid_resueltospro);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

//        tx_temas.setText(descrip);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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
            }

        });


        Lista= new ArrayList<mResueltosProblemas>();

        Lista.add(new mResueltosProblemas(R.drawable.mes_1,"Mes 1"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_2,"Mes 2"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_3,"Mes 3"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_4,"Mes 4"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_5,"Mes 5"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_6,"Mes 6"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_7,"Mes 7"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_8,"Mes 8"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_9,"Mes 8"));
        Lista.add(new mResueltosProblemas(R.drawable.mes_10,"Mes 8"));


        final adapterResueltosProblemas adapter= new adapterResueltosProblemas( getContext(), Lista);

        gridView.setAdapter(adapter);

        datoshare= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


               // mHDiapositivas mtomo = (mHDiapositivas) adapter.getItem(position);


                switch (position) {

                    case 0:


                        adapterResueltosCiencia.mescienciasresueltos("TOMO1");
                        adapterResueltosLetras.mesletrasresueltos("TOMO1");



                        Fragment fragment0 = new tomosResueltosProblemas();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);

                            args.putString("tomodesc", "MES 1");
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

                       adapterResueltosCiencia.mescienciasresueltos("TOMO2");
                        adapterResueltosLetras.mesletrasresueltos("TOMO2");

                        Fragment fragment1 = new tomosResueltosProblemas();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 2");
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
                        adapterResueltosCiencia.mescienciasresueltos("TOMO3");
                        adapterResueltosLetras.mesletrasresueltos("TOMO3");

                        Fragment fragment2 = new tomosResueltosProblemas();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString( "tomodesc","MES 3");
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

                        adapterResueltosCiencia.mescienciasresueltos("TOMO4");
                       adapterResueltosLetras.mesletrasresueltos("TOMO4");


                        Fragment fragment3 = new tomosResueltosProblemas();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString( "tomodesc","MES 4");
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

                        adapterResueltosCiencia.mescienciasresueltos("TOMO5");
                        adapterResueltosLetras.mesletrasresueltos("TOMO5");

                        Fragment fragment4 = new tomosResueltosProblemas();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 5");
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
                      adapterResueltosCiencia.mescienciasresueltos("TOMO6");
                        adapterResueltosLetras.mesletrasresueltos("TOMO6");

                        Fragment fragment5 = new tomosResueltosProblemas();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 6");
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
                        adapterResueltosCiencia.mescienciasresueltos("TOMO7");
                        adapterResueltosLetras.mesletrasresueltos("TOMO7");

                        Fragment fragment6 = new tomosResueltosProblemas();
                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                        if (fmanager6 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 7");
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

                        adapterResueltosCiencia.mescienciasresueltos("TOMO8");
                        adapterResueltosLetras.mesletrasresueltos("TOMO8");

                        Fragment fragment7 = new tomosResueltosProblemas();
                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                        if (fmanager7 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 8");
                            fragment7.setArguments(args);

                            FragmentTransaction ftransaction = fmanager7.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment7);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }





                        break;


                    case 8:

                        adapterResueltosCiencia.mescienciasresueltos("TOMO8");
                        adapterResueltosLetras.mesletrasresueltos("TOMO8");

                        Fragment fragment8 = new tomosResueltosProblemas();
                        FragmentManager fmanager8 = getActivity().getSupportFragmentManager();
                        if (fmanager8 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 9");
                            fragment8.setArguments(args);

                            FragmentTransaction ftransaction = fmanager8.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contenedorFragments, fragment8);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                        break;


                    case 9:

                        adapterResueltosCiencia.mescienciasresueltos("TOMO9");
                        adapterResueltosLetras.mesletrasresueltos("TOMO9");

                        Fragment fragment9 = new tomosResueltosProblemas();
                        FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                        if (fmanager9 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "MES 10");
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

            }
        });
        
        return rootview;
    }

}
