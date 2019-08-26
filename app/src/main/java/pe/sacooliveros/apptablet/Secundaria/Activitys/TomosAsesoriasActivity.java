package pe.sacooliveros.apptablet.Secundaria.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import pe.sacooliveros.apptablet.Balotario.BalotarioOpcionesActivity;
import pe.sacooliveros.apptablet.Balotario.BalotariosPeriodosActivity;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap1_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap2_Fragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.AsesoriaCap3_Fragment;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

public class TomosAsesoriasActivity extends AppCompatActivity {

    String tomoSelected;
    private ViewPager viewPager;
    private BottomNavigationView mMainNav;

    AsesoriaCap1_Fragment asesoriaCap1_fragment;
    AsesoriaCap2_Fragment asesoriaCap2_fragment;
    AsesoriaCap3_Fragment asesoriaCap3_fragment;

    MenuItem prevMenuItem;
    MenuInflater inflater;
    MenuItem shareItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomos_asesorias);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tomoSelected = String.valueOf(bundle.getInt("tomo"));
        }

        viewPager = findViewById(R.id.pagerAsesorias);
        mMainNav = findViewById(R.id.main_bottomasesorias);


        final Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });


        BottomNavigationView navigationView = findViewById(R.id.main_bottomasesorias);
        Menu nav_Menu = navigationView.getMenu();

        if (tomoSelected.equalsIgnoreCase("1")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 1");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 2");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 3");

        } else if (tomoSelected.equalsIgnoreCase("2")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 4");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 5");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 6");

        } else if (tomoSelected.equalsIgnoreCase("3")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 7");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 8");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 9");

        } else if (tomoSelected.equalsIgnoreCase("4")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 10");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 11");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 12");

        } else if (tomoSelected.equalsIgnoreCase("5")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 13");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 14");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 15");

        } else if (tomoSelected.equalsIgnoreCase("6")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 16");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 17");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 18");

        } else if (tomoSelected.equalsIgnoreCase("7")) {
            nav_Menu.findItem(R.id.nav_homeseminario).setTitle("Capitulo 19");
            nav_Menu.findItem(R.id.nav_notifseminario).setTitle("Capitulo 20");
            nav_Menu.findItem(R.id.nav_accountseminario).setTitle("Capitulo 21");

        } else if (tomoSelected.equalsIgnoreCase("8")) {
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
    }

    private void setupViewPager(ViewPager viewPager) {

        //ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        asesoriaCap1_fragment = new AsesoriaCap1_Fragment();
        asesoriaCap2_fragment = new AsesoriaCap2_Fragment();
        asesoriaCap3_fragment = new AsesoriaCap3_Fragment();

        adapter.addFragment(asesoriaCap1_fragment);
        adapter.addFragment(asesoriaCap2_fragment);
        adapter.addFragment(asesoriaCap3_fragment);

        viewPager.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menupdf, menu);
//        return true;

        inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hometoolbar, menu);
        shareItem = menu.findItem(R.id.action_home);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_home) {
            Intent intent = new Intent(TomosAsesoriasActivity.this, NavActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
