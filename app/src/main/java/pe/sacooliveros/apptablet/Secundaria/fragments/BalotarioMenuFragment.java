package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BalotarioMenuFragment extends Fragment {

    View rootview;

    TextView txt_primermensual, txt_primerbimestral;
    TextView txt_segundomensual, txt_segundobimestral;
    TextView txt_tercermensual, txt_tercerbimestral;
    TextView txt_cuartomensual, txt_cuartobimestral;

    public BalotarioMenuFragment() {
          }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_balotario_menu, container, false);

        txt_primermensual = rootview.findViewById(R.id.txt_balotar1mensual);
        txt_primerbimestral = rootview.findViewById(R.id.txt_balotar1bimestral);
        txt_segundobimestral = rootview.findViewById(R.id.txt_balotar2bimestral);
        txt_segundomensual = rootview.findViewById(R.id.txt_balotar2mensual);
        txt_tercerbimestral = rootview.findViewById(R.id.txt_balotar3bimestral);
        txt_tercermensual = rootview.findViewById(R.id.txt_balotar3mensual);
        txt_cuartomensual = rootview.findViewById(R.id.txt_balotar4mensual);
        txt_cuartobimestral = rootview.findViewById(R.id.txt_balotar4bimestral);


        File balotariospdf = new File(Environment.getExternalStorageDirectory(), "/SacoOliveros");
        if (!balotariospdf.exists()) {
            balotariospdf.mkdir();
        }

        txt_primermensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Primer_BalFragment.instantiate("1erMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("1erSolucMensual", "MENSUAL");
                Fragment fragment2 = new ContentBalotariosFragment();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    args.putString("descripcion_balotario", "PrimerMensual");
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }
        });

        txt_primerbimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Primer_BalFragment.instantiate("1erBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("1erSolucBimestral", "BIMESTRAL");

                Fragment fragment2 = new ContentBalotariosFragment();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    args.putString("descripcion_balotario", "PrimerBimestral");
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }
        });

        txt_segundobimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("2doBimestral", "BIMESTRAL");
                Segundo_BalFragment.instantiate("2doSolucBimestral", "BIMESTRAL");

                Fragment fragment2 = new ContentBalotariosFragment();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    args.putString("descripcion_balotario", "SegundoBimestral");
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }
        });

        txt_segundomensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Primer_BalFragment.instantiate("2doMensual", "MENSUAL");
                Segundo_BalFragment.instantiate("2doSolucMensual", "MENSUAL");

                Fragment fragment2 = new ContentBalotariosFragment();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {

                    Bundle args = new Bundle();
                    args.putString("descripcion_balotario", "SegundoMensual");
                    fragment2.setArguments(args);

                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }

            }
        });


        txt_tercerbimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Primer_BalFragment.instantiate("3erBimestral", "BIMESTRAL");
//                Segundo_BalFragment.instantiate("3erSolucBimestral", "BIMESTRAL");
//
//                Fragment fragment2 = new ContentBalotariosFragment();
//                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                if (fmanager2 != null) {
//
//                    Bundle args = new Bundle();
//                    args.putString("descripcion_balotario", "TercerBimestral");
//                    fragment2.setArguments(args);
//
//                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                    if (ftransaction != null) {
//                        ftransaction.replace(R.id.contenedorFragments, fragment2);
//                        ftransaction.addToBackStack("");
//                        ftransaction.commit();
//                    }
//                }

                Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

            }
        });

        txt_tercermensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Primer_BalFragment.instantiate("3erMensual", "MENSUAL");
//                Segundo_BalFragment.instantiate("3erSolucMensual", "MENSUAL");
//
//                Fragment fragment2 = new ContentBalotariosFragment();
//                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                if (fmanager2 != null) {
//
//                    Bundle args = new Bundle();
//                    args.putString("descripcion_balotario", "TercerMensual");
//                    fragment2.setArguments(args);
//
//                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                    if (ftransaction != null) {
//                        ftransaction.replace(R.id.contenedorFragments, fragment2);
//                        ftransaction.addToBackStack("");
//                        ftransaction.commit();
//                    }
//                }

                Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

            }
        });

        txt_cuartomensual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
            }
        });

        txt_cuartobimestral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
            }
        });

        return rootview;
    }

}
