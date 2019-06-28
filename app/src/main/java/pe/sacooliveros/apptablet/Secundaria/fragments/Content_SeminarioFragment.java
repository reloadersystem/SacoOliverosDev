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
import android.widget.RelativeLayout;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content_SeminarioFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    Capitulo1_Fragment capitulo1_fragment;
    Capitulo2_Fragment capitulo2_fragment;
    Capitulo3_Fragment capitulo3_fragment;

    RelativeLayout relativeLayout;


    View rootview;

    String tomo;


    public Content_SeminarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_contentgroup__seminario, container, false);

        mMainFrame = rootview.findViewById(R.id.main_frameseminario);
        mMainNav = rootview.findViewById(R.id.main_navseminario);
        relativeLayout = rootview.findViewById(R.id.frgcontentseminario);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tomo = bundle.getString("Tomo");
        }

        capitulo1_fragment = new Capitulo1_Fragment();
        capitulo2_fragment = new Capitulo2_Fragment();
        capitulo3_fragment = new Capitulo3_Fragment();

        BottomNavigationView navigationView = rootview.findViewById(R.id.main_navseminario);
        Menu nav_Menu = navigationView.getMenu();


        if (tomo.equalsIgnoreCase("Tomo 1")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 1");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 2");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 3");

        } else if (tomo.equalsIgnoreCase("Tomo 2")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 4");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 5");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 6");

        } else if (tomo.equalsIgnoreCase("Tomo 3")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 7");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 8");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 9");

        } else if (tomo.equalsIgnoreCase("Tomo 4")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 10");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 11");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 12");

        } else if (tomo.equalsIgnoreCase("Tomo 5")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 13");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 14");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 15");

        } else if (tomo.equalsIgnoreCase("Tomo 6")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 16");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 17");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 18");

        } else if (tomo.equalsIgnoreCase("Tomo 7")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 19");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 20");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 21");

        } else if (tomo.equalsIgnoreCase("Tomo 8")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 22");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 23");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 24");
        }


        setFragment(capitulo1_fragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_homeseminario:
                        setFragment(capitulo1_fragment);


                        return true;

                    case R.id.nav_notifseminario:
                        setFragment(capitulo2_fragment);
                        return true;


                    case R.id.nav_accountseminario:

                        setFragment(capitulo3_fragment);
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

        fragmentTransaction.replace(R.id.main_frameseminario, fragment);

        fragmentTransaction.commit();


    }

}
