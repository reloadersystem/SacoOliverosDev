package pe.sacooliveros.apptablet.Seleccion.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SemestralesFragment extends Fragment {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    private SemestralSMFragment semestralSMFragment;
    private SemestralUniFragment semestralUniFragment;


    View rootview;


    public SemestralesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_semestrales, container, false);

        mMainFrame = rootview.findViewById(R.id.main_framesemestrales);
        mMainNav = rootview.findViewById(R.id.main_navsemestrales);


        semestralSMFragment = new SemestralSMFragment();
        semestralUniFragment = new SemestralUniFragment();

//
        setFragment(semestralUniFragment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.nav_seuni:

                        setFragment(semestralUniFragment);
                        return true;


                    case R.id.nav_sesm:

                        setFragment(semestralSMFragment);

                        return true;

                    default:

                        return false;

                }

            }


        });
//

        return rootview;
    }

    private void setFragment(Fragment fragment) {


        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_framesemestrales, fragment);

        fragmentTransaction.commit();


    }

}
