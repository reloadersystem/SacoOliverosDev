package pe.sacooliveros.apptablet.QuintoUniversidades.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre1_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre2_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre3_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Bimestre4_Fragment;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class contentEAnualFragment extends Fragment {


    View rootview;

    private BottomNavigationView mMainNav;


    private Bimestre1_AnualFragment bimestre1_fragment;
    private Bimestre2_AnualFragment bimestre2_fragment;
    private Bimestre3_AnualFragment bimestre3_fragment;
    private Bimestre4_AnualFragment bimestre4_fragment;

    MenuItem prevMenuItem;
    private ViewPager viewPager;

    public contentEAnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_eanual, container, false);

        viewPager = rootview.findViewById(R.id.viewpagerexamen);
        mMainNav = rootview.findViewById(R.id.main_bottoexamenmanual);

        bimestre1_fragment = new Bimestre1_AnualFragment();
        bimestre2_fragment = new Bimestre2_AnualFragment();
        bimestre3_fragment = new Bimestre3_AnualFragment();
        bimestre4_fragment = new Bimestre4_AnualFragment();

        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home:

                        viewPager.setCurrentItem(0);


                        break;


                    case R.id.nav_notif:

                        viewPager.setCurrentItem(1);

                        break;


                    case R.id.nav_account:

                        viewPager.setCurrentItem(2);

                        break;


                    case R.id.nav_home2:

                        viewPager.setCurrentItem(3);

                        break;

                }

                return false;

            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    mMainNav.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                mMainNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = mMainNav.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);

        return rootview;
    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        bimestre1_fragment = new Bimestre1_AnualFragment();
        bimestre2_fragment = new Bimestre2_AnualFragment();
        bimestre3_fragment = new Bimestre3_AnualFragment();
        bimestre4_fragment = new Bimestre4_AnualFragment();

        adapter.addFragment(bimestre1_fragment);
        adapter.addFragment(bimestre2_fragment);
        adapter.addFragment(bimestre3_fragment);
        adapter.addFragment(bimestre4_fragment);

        viewPager.setAdapter(adapter);
    }


}
