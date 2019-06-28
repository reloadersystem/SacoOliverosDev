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

import pe.sacooliveros.apptablet.Primaria.Adapter.adapterMultimedia;
import pe.sacooliveros.apptablet.Primaria.Model.mMultimedia;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultimediaFragment extends Fragment {

    View rootview;
    private GridView gridView;

    String drawable;

    String descripcion;

    ArrayList<mMultimedia> Lista;


    public MultimediaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview= inflater.inflate(R.layout.fragment_multimedia, container, false);

        gridView=rootview.findViewById(R.id.ma_multimedia);


//        Bundle bundle = this.getArguments();
//        if (bundle != null) {
//            drawable = bundle.getString("drawable");
//           descripcion= "unidades";
//
//        }



        Lista=new ArrayList<mMultimedia>();

        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_1,"UNIDAD 1"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_2, "UNIDAD 2"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_3, "UNIDAD 3"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_4, "UNIDAD 4"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_5, "UNIDAD 5"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_6, "UNIDAD 6"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_7, "UNIDAD 7"));
        Lista.add(new mMultimedia("VER DETALLE",R.drawable.unidad_8, "UNIDAD 8"));

        final adapterMultimedia adapter= new adapterMultimedia(getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                mMultimedia mMultimedia= (mMultimedia) adapter.getItem(position);


                switch (position) {

                    case 0:


                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }

                    }

                        break;


                    case 1:


                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                        break;



                    case 2:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;



                    case 3:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;


                    case 4:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;


                    case 5:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;


                    case 6:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;


                    case 7:




                    {
                        Fragment fragment0 = new tomoMultiFrag();

                        FragmentManager fmanager0 = getActivity().getSupportFragmentManager();
                        if (fmanager0 != null) {

                            Bundle args = new Bundle();
//                            args.putString("description", descrip);
//                            args.putString("grado", grado);
                            args.putString("descripcionMulti", mMultimedia.getDescripcion());
                            fragment0.setArguments(args);

                            FragmentTransaction ftransaction = fmanager0.beginTransaction();
                            if (ftransaction != null) {
                                ftransaction.replace(R.id.contentFragPrimaria, fragment0);
                                ftransaction.addToBackStack("");
                                ftransaction.commit();
                            }

                        }
                    }


                    break;

                }

            }
        });






        return rootview;


    }

}
