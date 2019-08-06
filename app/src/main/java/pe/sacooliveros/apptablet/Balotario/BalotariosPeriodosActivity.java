package pe.sacooliveros.apptablet.Balotario;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.NavActivity;
import pe.sacooliveros.apptablet.Secundaria.fragments.Primer_BalFragment;
import pe.sacooliveros.apptablet.Secundaria.fragments.Segundo_BalFragment;
import pe.sacooliveros.apptablet.Utils.ViewPagerAdapter;

public class BalotariosPeriodosActivity extends AppCompatActivity {

    String tipoBalotario;
    private BottomNavigationView mMainNav;
    private ViewPager viewPager;

    private Primer_BalFragment balotario1_fragment;


    private Segundo_BalFragment balotario2_fragment;

    MenuItem prevMenuItem;

    CollapsingToolbarLayout collapsingToolbarLayout;

    AppBarLayout appBarLayout;

    MenuInflater inflater;

    MenuItem shareItem;

    Typeface futuralbold;
    Typeface futuraheavy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balotarios_periodos);

        viewPager = findViewById(R.id.pager);
        mMainNav = findViewById(R.id.main_bottomlecturas);

        final Toolbar toolbar = findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        balotario1_fragment = new Primer_BalFragment();

        balotario2_fragment = new Segundo_BalFragment();

        if (getIntent() != null) {
            Bundle bundle = this.getIntent().getExtras();
            tipoBalotario = bundle.getString("descripcion_balotario");
        }


        BottomNavigationView navigationView = findViewById(R.id.main_bottomlecturas);
        Menu nav_Menu = navigationView.getMenu();

//        final Typeface tf = getResources().getFont(R.font.rajdhanibold);
        //final Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/rajdhanibold.ttf");


        nav_Menu.findItem(R.id.nav_balotario).setTitle("Balotario");
        nav_Menu.findItem(R.id.nav_solucionario).setTitle("Solucionario");


        viewPager.setCurrentItem(0);
        setupViewPager(viewPager);


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        String fuente1 = "fuentes/futurabold.ttf";
        this.futuralbold = Typeface.createFromAsset(getAssets(), fuente1);

        String fuente2 = "fuentes/futuraheavy.ttf";
        this.futuraheavy = Typeface.createFromAsset(getAssets(), fuente2);

        collapsingToolbarLayout.setCollapsedTitleTypeface(futuralbold);
        collapsingToolbarLayout.setExpandedTitleTypeface(futuraheavy);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(tipoBalotario);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(tipoBalotario);
                    isShow = false;
                }
            }
        });

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_balotario:

                        // mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        // setFragment(homeFragment);

                        viewPager.setCurrentItem(0);

                        break;


                    case R.id.nav_solucionario:

                        // mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        // setFragment(notificationFragment);

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
            Intent intent = new Intent(BalotariosPeriodosActivity.this, NavActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        balotario1_fragment = new Primer_BalFragment();
        balotario2_fragment = new Segundo_BalFragment();
        adapter.addFragment(balotario1_fragment);
        adapter.addFragment(balotario2_fragment);

        viewPager.setAdapter(adapter);
    }


}
