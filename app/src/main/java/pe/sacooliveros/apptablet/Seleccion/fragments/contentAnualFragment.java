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

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class contentAnualFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private DiecinueveFragment diecinueveFragment;
    private DieciochoFragment dieciochoFragment;
    private DiecisieteFragment diecisieteFragment;
    private DieciseisFragment dieciseisFragment;
    private QuinceFragment quinceFragment;

    MenuItem prevMenuItem;

    private ViewPager viewPager;

    View rootview;


    public contentAnualFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_anual, container, false);

        viewPager = rootview.findViewById(R.id.pageranualselec);
        mMainNav = rootview.findViewById(R.id.main_bottomselanual);

        diecinueveFragment = new DiecinueveFragment();
        dieciochoFragment = new DieciochoFragment();
        diecisieteFragment = new DiecisieteFragment();
        dieciseisFragment = new DieciseisFragment();
        quinceFragment = new QuinceFragment();

        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_examendiecinueve:

                        viewPager.setCurrentItem(0);

                        break;


                    case R.id.nav_examendieciocho:

                        viewPager.setCurrentItem(1);

                        break;

                    case R.id.nav_examendiecisiete:

                        viewPager.setCurrentItem(2);

                        break;

                    case R.id.nav_examendieciseis:

                        viewPager.setCurrentItem(3);

                        break;

                    case R.id.nav_examenquince:

                        viewPager.setCurrentItem(4);

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
        diecinueveFragment = new DiecinueveFragment();
        dieciochoFragment = new DieciochoFragment();
        diecisieteFragment = new DiecisieteFragment();
        dieciseisFragment = new DieciseisFragment();
        quinceFragment = new QuinceFragment();

        adapter.addFragment(diecinueveFragment);
        adapter.addFragment(dieciochoFragment);
        adapter.addFragment(diecisieteFragment);
        adapter.addFragment(dieciseisFragment);
        adapter.addFragment(quinceFragment);

        viewPager.setAdapter(adapter);
    }

}
