package pe.sacooliveros.apptablet.Primaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Adapter.CustomAdapter;
import pe.sacooliveros.apptablet.Primaria.Adapter.adapterLibros;
import pe.sacooliveros.apptablet.Primaria.Adapter.adapterMatematica;
import pe.sacooliveros.apptablet.Primaria.EnviarTomo;
import pe.sacooliveros.apptablet.Primaria.Model.mLibros;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class librosfragment extends Fragment {

    View rootview;
    ArrayList<mLibros> Lista;
    private GridView gridView;

    EnviarTomo dato;

    String acceso;

    public librosfragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview = inflater.inflate(R.layout.fragment_librosfragment, container, false);

        gridView = rootview.findViewById(R.id.ma_libros);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            acceso = bundle.getString("ACCESO");

        }

        Lista=new ArrayList<mLibros>();

        Lista.add(new mLibros("VER DETALLE",R.drawable.tomo1_f,"TOMO 1"));
        Lista.add(new mLibros("VER DETALLE",R.drawable.tomo2_f, "TOMO 2"));
        Lista.add(new mLibros("VER DETALLE",R.drawable.tomo3_f, "TOMO 3"));
        Lista.add(new mLibros("VER DETALLE",R.drawable.tomo4_f, "TOMO 4"));

        final adapterLibros adapter= new adapterLibros( getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final mLibros mLibros= (mLibros) adapter.getItem(position);


                switch (position) {

                    case 0:

                    {

                        String tomodato= "TOMO1";
                        CustomAdapter.tomodato(tomodato);


                        Fragment fragment = new tomoLibroFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", acceso);
                            args.putString("tomodato", tomodato);
                            args.putString("tomolibro", mLibros.getDescripcion());
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }

                    }

                    break;

                    case 1:

                    {

                        String tomodato= "TOMO2";
                        CustomAdapter.tomodato(tomodato);
                        comunicacionFragment.tomodato(tomodato);


                        Fragment fragment = new tomoLibroFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", acceso);
                            args.putString("tomodato", tomodato);
                            args.putString("tomolibro", mLibros.getDescripcion());
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }

                    }

                    break;


                    case 2:

                    {

                        String tomodato= "TOMO3";
                        CustomAdapter.tomodato(tomodato);
                        comunicacionFragment.tomodato(tomodato);

                        Fragment fragment = new tomoLibroFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", acceso);
                            args.putString("tomodato", tomodato);
                            args.putString("tomolibro", mLibros.getDescripcion());
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }


                    }

                    break;




                    case 3:

                    {


                        String tomodato= "TOMO4";
                        CustomAdapter.tomodato(tomodato);
                        comunicacionFragment.tomodato(tomodato);

                        Fragment fragment = new tomoLibroFrag();
                        FragmentManager fmanager = getActivity().getSupportFragmentManager();
                        if (fmanager != null) {


                            Bundle args = new Bundle();
                            args.putString("ACCESO", acceso);
                            args.putString("tomodato", tomodato);
                            args.putString("tomolibro", mLibros.getDescripcion());
                            fragment.setArguments(args);


                            FragmentTransaction ftransaction = fmanager.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }


                        }


                    }

                    break;




                }
            }
        });






        return  rootview;


    }
}


