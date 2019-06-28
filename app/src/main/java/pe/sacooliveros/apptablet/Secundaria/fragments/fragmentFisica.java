package pe.sacooliveros.apptablet.Secundaria.fragments;


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
public class fragmentFisica extends Fragment {


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    Bimestre1_Fragment bimestre1_fragment;
    Bimestre2_Fragment bimestre2_fragment;
    Bimestre3_Fragment bimestre3_fragment;
    Bimestre4_Fragment bimestre4_fragment;

    View rootview;


    public fragmentFisica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_fragment_fisica, container, false);

        mMainFrame = rootview.findViewById(R.id.main_frame);
        mMainNav = rootview.findViewById(R.id.main_nav);


        bimestre1_fragment = new Bimestre1_Fragment();
        bimestre2_fragment = new Bimestre2_Fragment();
        bimestre3_fragment = new Bimestre3_Fragment();
        bimestre4_fragment = new Bimestre4_Fragment();

        setFragment(bimestre1_fragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:


                        setFragment(bimestre1_fragment);
                        return true;


                    case R.id.nav_notif:

                        setFragment(bimestre2_fragment);

                        return true;


                    case R.id.nav_account:
                        setFragment(bimestre3_fragment);

                        return true;

                    case R.id.nav_home2:

                        // mMainNav.setItemBackgroundResource(R.color.colorPrimaryDark);
                        setFragment(bimestre4_fragment);

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

        fragmentTransaction.replace(R.id.main_frame, fragment);

        fragmentTransaction.commit();


    }

}