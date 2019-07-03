package pe.sacooliveros.apptablet.Secundaria.fragments;


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
import android.widget.FrameLayout;

import pe.sacooliveros.apptablet.Balotario.ViewPagerAdapter;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class contentFisicaFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    Bimestre1_Fragment bimestre1_fragment;
    Bimestre2_Fragment bimestre2_fragment;
    Bimestre3_Fragment bimestre3_fragment;
    Bimestre4_Fragment bimestre4_fragment;

    View rootview;

    MenuItem prevMenuItem;

    private ViewPager viewPager;


    public contentFisicaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_fisica, container, Boolean.parseBoolean(null));

        viewPager = rootview.findViewById(R.id.pager);
        mMainNav = rootview.findViewById(R.id.main_bottomlecturas);


        bimestre1_fragment = new Bimestre1_Fragment();
        bimestre2_fragment = new Bimestre2_Fragment();
        bimestre3_fragment = new Bimestre3_Fragment();
        bimestre4_fragment = new Bimestre4_Fragment();

//        viewPager.notify();
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
        // ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        bimestre1_fragment = new Bimestre1_Fragment();
        bimestre2_fragment = new Bimestre2_Fragment();
        bimestre3_fragment = new Bimestre3_Fragment();
        bimestre4_fragment = new Bimestre4_Fragment();

        adapter.addFragment(bimestre1_fragment);
        adapter.addFragment(bimestre2_fragment);
        adapter.addFragment(bimestre3_fragment);
        adapter.addFragment(bimestre4_fragment);

        viewPager.setAdapter(adapter);
    }

}
