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
public class contentOlimpiadasFragment extends Fragment {

    private BottomNavigationView mMainNav;

    private ConcursoFragment concursoFragment;
    private OlimpiadasFragment geLibroFragment;
    private RecursosAcademicosFragment recursosAcademicosFragment;

    View rootview;

    MenuItem prevMenuItem;

    private ViewPager viewPager;


    public contentOlimpiadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_olimpiadas, container, false);

        viewPager = rootview.findViewById(R.id.pagerolimpiadas);
        mMainNav = rootview.findViewById(R.id.main_bottomolimpiadas);

        concursoFragment = new ConcursoFragment();
        geLibroFragment = new OlimpiadasFragment();
        recursosAcademicosFragment = new RecursosAcademicosFragment();


        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_spa:

                        viewPager.setCurrentItem(0);


                        break;


                    case R.id.nav_ge:

                        viewPager.setCurrentItem(1);

                        break;


                    case R.id.nav_olimpiadasconcursos:

                        viewPager.setCurrentItem(2);

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
        concursoFragment = new ConcursoFragment();
        geLibroFragment = new OlimpiadasFragment();
        recursosAcademicosFragment = new RecursosAcademicosFragment();


        adapter.addFragment(concursoFragment);
        adapter.addFragment(geLibroFragment);
        adapter.addFragment(recursosAcademicosFragment);


        viewPager.setAdapter(adapter);
    }
}
