package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class contentAsesoriasFragment extends Fragment {

    View rootview;

    ConstraintLayout cl_popupmessage;

    AsesoriaCap1_Fragment asesoriaCap1_fragment;
    AsesoriaCap2_Fragment asesoriaCap2_fragment;
    AsesoriaCap3_Fragment asesoriaCap3_fragment;

    MenuItem prevMenuItem;
    private ViewPager viewPager;
    private BottomNavigationView mMainNav;

    String tomo;

    public contentAsesoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_content_asesorias, container, false);

        asesoriaCap1_fragment = new AsesoriaCap1_Fragment();
        asesoriaCap2_fragment = new AsesoriaCap2_Fragment();
        asesoriaCap3_fragment = new AsesoriaCap3_Fragment();

        cl_popupmessage= rootview.findViewById(R.id.cl_popupmessage);

        final Animation myAnim = AnimationUtils.loadAnimation(getContext(), R.anim.fade_transition_animation);

        cl_popupmessage.setAnimation(myAnim);

        cl_popupmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cl_popupmessage.setVisibility(View.INVISIBLE);
            }
        });


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tomo = bundle.getString("Tomo");
        }

        viewPager = rootview.findViewById(R.id.pagerasesorias);
        mMainNav = rootview.findViewById(R.id.main_bottomasesorias);

        BottomNavigationView navigationView = rootview.findViewById(R.id.main_bottomasesorias);
        Menu nav_Menu = navigationView.getMenu();

        if (tomo.equalsIgnoreCase("Tomo 1")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 1");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 2");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 3");

        } else if (tomo.equalsIgnoreCase("Tomo 2")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 4");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 5");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 6");

        } else if (tomo.equalsIgnoreCase("Tomo 3")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 7");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 8");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 9");

        } else if (tomo.equalsIgnoreCase("Tomo 4")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 10");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 11");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 12");

        } else if (tomo.equalsIgnoreCase("Tomo 5")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 13");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 14");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 15");

        } else if (tomo.equalsIgnoreCase("Tomo 6")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 16");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 17");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 18");

        } else if (tomo.equalsIgnoreCase("Tomo 7")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 19");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 20");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 21");

        } else if (tomo.equalsIgnoreCase("Tomo 8")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 22");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 23");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 24");
        }


        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_homeseminario:

                        viewPager.setCurrentItem(0);
                        break;

                    case R.id.nav_notifseminario:
                        viewPager.setCurrentItem(1);
                        break;

                    case R.id.nav_accountseminario:
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

        asesoriaCap1_fragment = new AsesoriaCap1_Fragment();
        asesoriaCap2_fragment = new AsesoriaCap2_Fragment();
        asesoriaCap3_fragment = new AsesoriaCap3_Fragment();

        adapter.addFragment(asesoriaCap1_fragment);
        adapter.addFragment(asesoriaCap2_fragment);
        adapter.addFragment(asesoriaCap3_fragment);

        viewPager.setAdapter(adapter);
    }
}
