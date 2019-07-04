package pe.sacooliveros.apptablet.Seleccion.fragments;


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

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class contentSemestralFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    private SemestralSMFragment semestralSMFragment;
    private SemestralUniFragment semestralUniFragment;

    MenuItem prevMenuItem;

    private ViewPager viewPager;


    View rootview;


    public contentSemestralFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_semestral, container, false);

        viewPager = rootview.findViewById(R.id.pagersemestrales);
        mMainNav = rootview.findViewById(R.id.main_bottomsemestrales);


        semestralSMFragment = new SemestralSMFragment();
        semestralUniFragment = new SemestralUniFragment();

        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_seuni:

                        viewPager.setCurrentItem(0);

                        break;


                    case R.id.nav_sesm:

                        viewPager.setCurrentItem(1);

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
        semestralSMFragment = new SemestralSMFragment();
        semestralUniFragment = new SemestralUniFragment();


        adapter.addFragment(semestralSMFragment);
        adapter.addFragment(semestralUniFragment);


        viewPager.setAdapter(adapter);
    }

}
