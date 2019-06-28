package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentBalotariosFragment extends Fragment {

    View rootview;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Primer_BalFragment balotario1_fragment;
    private Segundo_BalFragment balotario2_fragment;

    String tipoBalotario;

    String titleoption1, titleoption2;


    public ContentBalotariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_balotarios, container, false);

        mMainFrame = rootview.findViewById(R.id.main_framebottom);
        mMainNav = rootview.findViewById(R.id.main_bottomlecturas);

        balotario1_fragment = new Primer_BalFragment();
        balotario2_fragment = new Segundo_BalFragment();


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tipoBalotario = bundle.getString("descripcion_balotario");
        }

        BottomNavigationView navigationView = rootview.findViewById(R.id.main_bottomlecturas);
        Menu nav_Menu = navigationView.getMenu();

        if (tipoBalotario.equalsIgnoreCase("PrimerBimestral")) {
            titleoption1 = "1er-Balotario Bimestral";
            titleoption2 = "1er-Solucionario Bimestral";
        } else if (tipoBalotario.equalsIgnoreCase("PrimerMensual")) {
            titleoption1 = "1er-Balotario Mensual";
            titleoption2 = "1er-Solucionario Mensual";
        } else if (tipoBalotario.equalsIgnoreCase("SegundoMensual")) {
            titleoption1 = "2do-Balotario Mensual";
            titleoption2 = "2do-Solucionario Mensual";
        } else if (tipoBalotario.equalsIgnoreCase("SegundoBimestral")) {
            titleoption1 = "2do-Balotario Bimestral";
            titleoption2 = "2do-Solucionario Bimestral";
        } else if (tipoBalotario.equalsIgnoreCase("TercerMensual")) {
            titleoption1 = "3er-Balotario Mensual";
            titleoption2 = "3er-Solucionario Mensual";
        } else if (tipoBalotario.equalsIgnoreCase("TercerBimestral")) {
            titleoption1 = "3er-Balotario Bimestral";
            titleoption2 = "3er-Solucionario Bimestral";
        }

        nav_Menu.findItem(R.id.nav_balotario).setTitle(titleoption1);
        nav_Menu.findItem(R.id.nav_solucionario).setTitle(titleoption2);

        setFragment(balotario1_fragment);
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_balotario:

                        setFragment(balotario1_fragment);
                        return true;


                    case R.id.nav_solucionario:

                        setFragment(balotario2_fragment);

                        return true;

                    default:

                        return false;

                }
            }
        });


        return rootview;
    }


    private void setFragment(Fragment fragment) {


        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_framebottom, fragment);

        fragmentTransaction.commit();


    }

}
