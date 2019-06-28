package pe.sacooliveros.apptablet.Secundaria;


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
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_PResueltos;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proresueltosciencias;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proresueltosletras;
import pe.sacooliveros.apptablet.Secundaria.Model.mPResueltos;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoDiapo;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentResueltos extends Fragment {

    View rootview;
    private GridView gridView;
    ArrayList<mPResueltos> Lista;
    TextView tx_temas;
    ImageView img_temas;

    String descrip, grado;

    String acceso;


    public fragmentResueltos() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview= inflater.inflate(R.layout.fragment_resueltos, container, false);

        tx_temas= rootview.findViewById(R.id.tx_titlePropuesto);
        img_temas= rootview.findViewById(R.id.img_backResueltos);
        gridView= rootview.findViewById(R.id.ma_gridResueltos);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
        }


        Lista= new ArrayList<mPResueltos>();

        Lista.add(new mPResueltos(R.drawable.mes_1));
        Lista.add(new mPResueltos(R.drawable.mes_2));
        Lista.add(new mPResueltos(R.drawable.mes_3));
        Lista.add(new mPResueltos(R.drawable.mes_4));
        Lista.add(new mPResueltos(R.drawable.mes_5));
        Lista.add(new mPResueltos(R.drawable.mes_6));
        Lista.add(new mPResueltos(R.drawable.mes_7));
        Lista.add(new mPResueltos(R.drawable.mes_8));
        Lista.add(new mPResueltos(R.drawable.mes_9));
        Lista.add(new mPResueltos(R.drawable.mes_10));


        final adapter_PResueltos adapter= new adapter_PResueltos( getContext(), Lista);

        gridView.setAdapter(adapter);


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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                mTomoDiapo mtomo = (mTomoDiapo) adapter.getItem(position);


                switch (position) {


                    case 0:

                        adapter_proresueltosciencias.mescienciasresueltos("MES0");
                        adapter_proresueltosletras.mesletrasresueltos("MES0");



                        Fragment fragment0 = new MesResueltosFragment();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {



                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc", "MES 1");
                            args.putString("ACCESO", acceso);

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

                        adapter_proresueltosciencias.mescienciasresueltos("MES1");
                            adapter_proresueltosletras.mesletrasresueltos("MES1");

                        Fragment fragment1 = new MesResueltosFragment();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {


                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc", "MES 2");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES2");
                        adapter_proresueltosletras.mesletrasresueltos("MES2");


                        Fragment fragment2 = new MesResueltosFragment();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString( "tomodesc","MES 3");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES3");
                        adapter_proresueltosletras.mesletrasresueltos("MES3");


                        Fragment fragment3 = new MesResueltosFragment();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString( "tomodesc","MES 4");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES4");
                        adapter_proresueltosletras.mesletrasresueltos("MES4");



                        Fragment fragment4 = new MesResueltosFragment();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc","MES 5");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES5");
                        adapter_proresueltosletras.mesletrasresueltos("MES5");


                        Fragment fragment5 = new MesResueltosFragment();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc", "MES 6");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES6");
                        adapter_proresueltosletras.mesletrasresueltos("MES6");


                        Fragment fragment6 = new MesResueltosFragment();
                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                        if (fmanager6 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc","MES 7");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES7");
                        adapter_proresueltosletras.mesletrasresueltos("MES7");



                        Fragment fragment7 = new MesResueltosFragment();
                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                        if (fmanager7 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("tomodesc", "MES 8");
                            args.putString("ACCESO", acceso);
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


                        adapter_proresueltosciencias.mescienciasresueltos("MES8");
                        adapter_proresueltosletras.mesletrasresueltos("MES8");

                        Fragment fragment8 = new MesResueltosFragment();
                        FragmentManager fmanager8 = getActivity().getSupportFragmentManager();
                        if (fmanager8 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("tomodesc", "MES9");
                            args.putString("ACCESO", acceso);
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

                        adapter_proresueltosciencias.mescienciasresueltos("MES9");
                        adapter_proresueltosletras.mesletrasresueltos("MES9");

                        Fragment fragment9 = new MesResueltosFragment();
                        FragmentManager fmanager9 = getActivity().getSupportFragmentManager();
                        if (fmanager9 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("tomodesc", "MES 10");
                            args.putString("ACCESO", acceso);
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
