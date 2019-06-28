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
import android.widget.Toast;

import java.util.ArrayList;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapterExamenCap;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapter_AdmisionCiencias;
import pe.sacooliveros.apptablet.QuintoUniversidades.Adapter.adapter_AdmisionLetras;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mExamenCapitulos;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomo;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class examenCapitulosFragment extends Fragment {

    View rootview;
    private GridView gridView;
    ArrayList<mExamenCapitulos> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;
    
    String gradoasiste;

    String sharedata;


    public examenCapitulosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_examen_capitulos, container, false);

        tx_temas= rootview.findViewById(R.id.tx_temas);
        img_temas= rootview.findViewById(R.id.img_backExamCap);
        gridView= rootview.findViewById(R.id.ma_gridExamCap);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");

        }

        if (gradoasiste==null)
        {
            sharedata= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        }

        Lista= new ArrayList<mExamenCapitulos>();

        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_1));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_2));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_3));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_4));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_5));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_6));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_7));
        Lista.add(new mExamenCapitulos(R.drawable.secundariatomovm_8));

        final adapterExamenCap adapter= new adapterExamenCap(getContext(), Lista);

        gridView.setAdapter(adapter);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Fragment fragment2 = new mainFragmentUni();
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


                mTomo mtomo = (mTomo) adapter.getItem(position);


                switch (position) {

                    case 0:

//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO1");
//
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO1");
//
//
//                        Fragment fragment0 = new PreguntasTomoFragment();
//
//                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
//                        if (fmanager0 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
//                            args.putString("tomodesc", "TOMO 1");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//
//
//                            fragment0.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment0);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }

                        Toast.makeText(getContext(), "prueba", Toast.LENGTH_SHORT).show();


                        break;


                    case 1:

                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO2");
                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO2");



                        Fragment fragment1 = new PreguntasTomoFragment();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("tomodesc", "TOMO 2");
                            args.putString("ACCESO", acceso);
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
//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO3");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO3");
//
//                        Fragment fragment2 = new PreguntasTomoFragment();
//                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
//                        if (fmanager != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString( "description",descrip);
//                            args.putString( "grado",grado);
//                            args.putString( "tomodesc","TOMO 3");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment2.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment2);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }



                        break;


                    case 3:
//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO4");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO4");
//
//                        Fragment fragment3 = new PreguntasTomoFragment();
//                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
//                        if (fmanager3 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString( "description",descrip);
//                            args.putString( "grado",grado);
//                            args.putString( "tomodesc","TOMO 4");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment3.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager3.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment3);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }





                        break;


                    case 4:
//
//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO5");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO5");
//
//                        Fragment fragment4 = new PreguntasTomoFragment();
//                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
//                        if (fmanager4 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
//                            args.putString("tomodesc", "TOMO 5");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment4.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager4.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment4);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }



                        break;


                    case 5:
//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO6");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO6");
//
//                        Fragment fragment5 = new PreguntasTomoFragment();
//                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
//                        if (fmanager5 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
//                            args.putString("tomodesc", "TOMO 6");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment5.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager5.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment5);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }






                        break;


                    case 6:
//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO7");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO7");
//
//                        Fragment fragment6 = new PreguntasTomoFragment();
//                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
//                        if (fmanager6 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
//                            args.putString("tomodesc", "TOMO 7");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment6.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager6.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment6);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }





                        break;

                    case 7:

//                        adapter_AdmisionCiencias.tomoAdmisionCiencias("TOMO8");
//                        adapter_AdmisionLetras.tomoAdmisionLetras("TOMO8");
//
//                        Fragment fragment7 = new PreguntasTomoFragment();
//                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
//                        if (fmanager7 != null) {
//
//                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
//                            args.putString("tomodesc", "TOMO 8");
//                            args.putString("ACCESO", acceso);
//                            args.putString("TipoGradoAsiste", gradoasiste);
//                            fragment7.setArguments(args);
//
//                            FragmentTransaction ftransaction = fmanager7.beginTransaction();
//                            if (ftransaction != null) {
//                                ftransaction.replace(R.id.contenedorFragments, fragment7);
//                                ftransaction.addToBackStack("");
//                                ftransaction.commit();
//                            }
//
//                        }

                        break;

                }

            }
        });
        
        
        






        return rootview;
    }

}
