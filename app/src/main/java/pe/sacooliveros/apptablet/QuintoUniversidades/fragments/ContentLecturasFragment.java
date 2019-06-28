package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


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
public class ContentLecturasFragment extends Fragment {

    View rootview;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Bimestre1_LecturaFragment bimestre1_fragment;
    private Bimestre2_LecturaFragment bimestre2_fragment;
    private Bimestre3_LecturaFragment bimestre3_fragment;
    private Bimestre4_LecturaFragment bimestre4_fragment;


    public ContentLecturasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_lecturas, container, false);

        mMainFrame = rootview.findViewById(R.id.main_framebottom);
        mMainNav = rootview.findViewById(R.id.main_bottomlecturas);

        bimestre1_fragment = new Bimestre1_LecturaFragment();
        bimestre2_fragment = new Bimestre2_LecturaFragment();
        bimestre3_fragment = new Bimestre3_LecturaFragment();
        bimestre4_fragment = new Bimestre4_LecturaFragment();
//
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

        fragmentTransaction.replace(R.id.main_framebottom, fragment);

        fragmentTransaction.commit();


    }

}
