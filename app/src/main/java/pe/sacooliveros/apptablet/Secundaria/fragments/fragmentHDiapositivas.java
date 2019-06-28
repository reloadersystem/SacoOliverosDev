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

import pe.sacooliveros.apptablet.QuintoCatolica.Adapter.adapterTomoCatolica;
import pe.sacooliveros.apptablet.QuintoCatolica.Fragment.fragmentDiapositivasCatolica;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasCiencia;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterDiapositivasLetras;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterHDiapositivas;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mHDiapositivas;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentHDiapositivas extends Fragment {


    private GridView gridView;
    ArrayList<mHDiapositivas> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;
    View rootview;
    String gradoasiste;
    String datoshare;


    public fragmentHDiapositivas() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_fragment_seminario, container, false);

        tx_temas = rootview.findViewById(R.id.tx_temaVSeminario);
        img_temas = rootview.findViewById(R.id.img_Seminario);
        gridView = rootview.findViewById(R.id.ma_tomoSeminario);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        datoshare = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        if (gradoasiste == null) {
            gradoasiste = datoshare;
        }

        Lista = new ArrayList<mHDiapositivas>();

        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
            Lista.add(new mHDiapositivas(R.drawable.diapcatolica_1, "Tomo 1"));
            Lista.add(new mHDiapositivas(R.drawable.diapcatolica_2, "Tomo 2"));
            Lista.add(new mHDiapositivas(R.drawable.diapcatolica_3, "Tomo 3"));
            Lista.add(new mHDiapositivas(R.drawable.diapcatolica_4, "Tomo 4"));

        } else

        {
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_1, "Tomo 1"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_2, "Tomo 2"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_3, "Tomo 3"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_4, "Tomo 4"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_5, "Tomo 5"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_6, "Tomo 6"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_7, "Tomo 7"));
            Lista.add(new mHDiapositivas(R.drawable.secundariatomovm_8, "Tomo 8"));
        }

        final adapterHDiapositivas adapter = new adapterHDiapositivas(getContext(), Lista);

        gridView.setAdapter(adapter);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // getActivity().getSupportFragmentManager().popBackStack();

                String gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");

                if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && datoshare.equalsIgnoreCase("PRE"))

                {
                    Fragment fragment2 = new InitialFragment();
                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                    if (fmanager2 != null) {
                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                            ftransaction.addToBackStack(null);




                            ftransaction.commit();
                        }
                    }
                } else if (gradoasiste.equalsIgnoreCase("Uni") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradoasiste.equalsIgnoreCase("PRE")) {

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

            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                mHDiapositivas mtomo = (mHDiapositivas) adapter.getItem(position);


                switch (position) {

                    case 0:


                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO1");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO1");
                        adapterTomoCatolica.tomoCatolica("TOMO1");


                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment0 = new fragmentDiapositivasCatolica();
                            FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                            if (fmanager0 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);

                                args.putString("tomodesc", "BIMESTRE 1");
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


                        Fragment fragment0 = new DiapositivasTomosFrag();
                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);

                            args.putString("tomodesc", mtomo.getDescripcion());
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

                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO2");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO2");
                        adapterTomoCatolica.tomoCatolica("TOMO2");

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment1 = new fragmentDiapositivasCatolica();
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
                        }

                        Fragment fragment1 = new DiapositivasTomosFrag();
                        FragmentManager fmanager1 = getActivity().getSupportFragmentManager();
                        if (fmanager1 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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
                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO3");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO3");
                        adapterTomoCatolica.tomoCatolica("TOMO3");

                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment2 = new fragmentDiapositivasCatolica();
                            FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                            if (fmanager2 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);

                                args.putString("tomodesc", "BIMESTRE 3");
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


                        Fragment fragment2 = new DiapositivasTomosFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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

                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO4");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO4");
                        adapterTomoCatolica.tomoCatolica("TOMO4");


                        if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
                            Fragment fragment3 = new fragmentDiapositivasCatolica();
                            FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                            if (fmanager3 != null) {

                                Bundle args = new Bundle();
                                args.putString("description", descrip);
                                args.putString("grado", grado);
                                args.putString("ACCESO", acceso);
                                args.putString("TipoGradoAsiste", gradoasiste);

                                args.putString("tomodesc", "BIMESTRE 4");
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


                        Fragment fragment3 = new DiapositivasTomosFrag();
                        FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                        if (fmanager3 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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

                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO5");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO5");
                        adapterTomoCatolica.tomoCatolica("TOMO5");

                        Fragment fragment4 = new DiapositivasTomosFrag();
                        FragmentManager fmanager4 = getActivity().getSupportFragmentManager();
                        if (fmanager4 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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
                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO6");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO6");
                        adapterTomoCatolica.tomoCatolica("TOMO6");

                        Fragment fragment5 = new DiapositivasTomosFrag();
                        FragmentManager fmanager5 = getActivity().getSupportFragmentManager();
                        if (fmanager5 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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
                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO7");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO7");
                        adapterTomoCatolica.tomoCatolica("TOMO7");

                        Fragment fragment6 = new DiapositivasTomosFrag();
                        FragmentManager fmanager6 = getActivity().getSupportFragmentManager();
                        if (fmanager6 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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

                        adapterDiapositivasCiencia.tomoDiapositivasCiencia("TOMO8");
                        adapterDiapositivasLetras.tomoDiapositivasLetras("TOMO8");
                        adapterTomoCatolica.tomoCatolica("TOMO8");

                        Fragment fragment7 = new DiapositivasTomosFrag();
                        FragmentManager fmanager7 = getActivity().getSupportFragmentManager();
                        if (fmanager7 != null) {

                            Bundle args = new Bundle();
                            args.putString("description", descrip);
                            args.putString("grado", grado);
                            args.putString("ACCESO", acceso);
                            args.putString("TipoGradoAsiste", gradoasiste);
                            args.putString("tomodesc", mtomo.getDescripcion());
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
