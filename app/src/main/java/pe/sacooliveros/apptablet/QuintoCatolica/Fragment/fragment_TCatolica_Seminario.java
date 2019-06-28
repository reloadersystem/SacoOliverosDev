package pe.sacooliveros.apptablet.QuintoCatolica.Fragment;


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

import pe.sacooliveros.apptablet.QuintoCatolica.Adapter.adapterTVideoSeminario;
import pe.sacooliveros.apptablet.QuintoCatolica.Adapter.adapterTomoCatolica;
import pe.sacooliveros.apptablet.QuintoCatolica.Model.mTomoVideoSeminario;
import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.examenCapitulosFragment;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasCiencia;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasLetras;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterVSeminario;
import pe.sacooliveros.apptablet.Secundaria.Model.mHDiapositivas;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentVSeminario;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_TCatolica_Seminario extends Fragment {

    private GridView gridView;
    ArrayList<mTomoVideoSeminario> Lista;
    TextView tx_temas;
    ImageView img_temas;

    String descrip, grado;


    String datofragment;

    String acceso;

    View rootview;

    String gradoasiste;

    String datoshare;


    public fragment_TCatolica_Seminario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_tcatolica__seminario, container, false);

        tx_temas= rootview.findViewById(R.id.tx_VSeminario);
        img_temas= rootview.findViewById(R.id.img_VSeminario);
        gridView= rootview.findViewById(R.id.grid_tomoVSeminario);


        Lista= new ArrayList<mTomoVideoSeminario>();

        Lista.add(new mTomoVideoSeminario(R.drawable.bimestrecatolica_1,"Tomo 1"));
        Lista.add(new mTomoVideoSeminario(R.drawable.bimestrecatolica_2,"Tomo 2"));
        Lista.add(new mTomoVideoSeminario(R.drawable.bimestrecatolica_3,"Tomo 3"));
        Lista.add(new mTomoVideoSeminario(R.drawable.bimestrecatolica_4,"Tomo 4"));

        final adapterTVideoSeminario adapter= new adapterTVideoSeminario( getContext(), Lista);

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


//                mHDiapositivas mtomo = (mHDiapositivas) adapter.getItem(position);


                switch (position) {

                    case 0:

                        adapterVSeminario.tomoVSeminario("TOMO1");

                        Fragment fragment0 = new fragmentVSeminario();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);

                            args.putString("tomodesc","BIMESTRE 1");
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

                        adapterVSeminario.tomoVSeminario("TOMO2");
                       

                        Fragment fragment1 = new fragmentVSeminario();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", "BIMESTRE 2");
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

                        adapterVSeminario.tomoVSeminario("TOMO3");
                      
                        Fragment fragment2 = new fragmentVSeminario();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString( "tomodesc","BIMESTRE 3");
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

                        adapterVSeminario.tomoVSeminario("TOMO4");


                        Fragment fragment3 = new fragmentVSeminario();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            args.putString( "description",descrip);
                            args.putString( "grado",grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString( "tomodesc","BIMESTRE 4");
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

            }
        });



        return rootview;
    }

}
