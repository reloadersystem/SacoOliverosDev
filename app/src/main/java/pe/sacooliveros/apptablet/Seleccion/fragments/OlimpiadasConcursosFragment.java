package pe.sacooliveros.apptablet.Seleccion.fragments;


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
public class OlimpiadasConcursosFragment extends Fragment {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;


    private ConcursoFragment concursoFragment;
    private OlimpiadasFragment geLibroFragment;
    private RecursosAcademicosFragment recursosAcademicosFragment;


    View rootview;


    public OlimpiadasConcursosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.olimpiada_concursosfragment, container, false);

        mMainFrame = rootview.findViewById(R.id.main_frameseleccion);
        mMainNav = rootview.findViewById(R.id.main_navseleccion);


        concursoFragment = new ConcursoFragment();
        geLibroFragment = new OlimpiadasFragment();
        recursosAcademicosFragment = new RecursosAcademicosFragment();
//
        setFragment(concursoFragment);
//
        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {

                    case R.id.nav_spa:

                        setFragment(concursoFragment);
                        return true;


                    case R.id.nav_ge:

                        setFragment(geLibroFragment);

                        return true;

                    case R.id.nav_olimpiadasconcursos:

                        setFragment(recursosAcademicosFragment);

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

        fragmentTransaction.replace(R.id.main_frameseleccion, fragment);

        fragmentTransaction.commit();


    }

}

