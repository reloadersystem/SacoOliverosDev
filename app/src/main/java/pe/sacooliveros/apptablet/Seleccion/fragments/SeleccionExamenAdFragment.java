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
public class SeleccionExamenAdFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    private DiecinueveFragment diecinueveFragment;
    private DieciochoFragment dieciochoFragment;
    private DiecisieteFragment diecisieteFragment;
    private DieciseisFragment dieciseisFragment;
    private QuinceFragment quinceFragment;

    View rootview;


    public SeleccionExamenAdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview =  inflater.inflate(R.layout.fragment_seleccion_adexamen, container, false);

        mMainFrame = rootview.findViewById(R.id.main_frameexamen);
        mMainNav = rootview.findViewById(R.id.main_navexamen);

        diecinueveFragment= new DiecinueveFragment();
        dieciochoFragment= new DieciochoFragment();
        diecisieteFragment= new DiecisieteFragment();
        dieciseisFragment= new DieciseisFragment();
        quinceFragment= new QuinceFragment();

        setFragment(diecinueveFragment);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.nav_examendiecinueve:

                        setFragment(diecinueveFragment);
                        return true;


                    case R.id.nav_examendieciocho:

                        setFragment(dieciochoFragment);

                        return true;

                    case R.id.nav_examendiecisiete:

                        setFragment(diecisieteFragment);

                        return true;

                    case R.id.nav_examendieciseis:

                        setFragment(dieciseisFragment);

                        return true;


                    case R.id.nav_examenquince:

                        setFragment(quinceFragment);

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

        fragmentTransaction.replace(R.id.main_frameexamen, fragment);

        fragmentTransaction.commit();


    }

}
