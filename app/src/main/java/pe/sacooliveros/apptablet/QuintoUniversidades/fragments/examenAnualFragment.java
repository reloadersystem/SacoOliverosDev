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
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre1_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre2_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre3_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre4_Fragment;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

/**
 * A simple {@link Fragment} subclass.
 */
public class examenAnualFragment extends Fragment {

    View rootview;

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private Bimestre1_AnualFragment bimestre1_fragment;
    private Bimestre2_AnualFragment bimestre2_fragment;
    private Bimestre3_AnualFragment bimestre3_fragment;
    private Bimestre4_AnualFragment bimestre4_fragment;




    public examenAnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_examen_anual, container, false);

        mMainFrame= rootview.findViewById(R.id.main_examenanual);
        mMainNav=rootview.findViewById(R.id.main_navexamenanual);

        bimestre1_fragment = new Bimestre1_AnualFragment();
        bimestre2_fragment=  new Bimestre2_AnualFragment();
        bimestre3_fragment=  new Bimestre3_AnualFragment();
        bimestre4_fragment=  new Bimestre4_AnualFragment();




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

        return  rootview;
    }


    private void setFragment(Fragment fragment) {


        FragmentTransaction fragmentTransaction= getActivity().getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.main_examenanual, fragment);

        fragmentTransaction.commit();



    }

}
