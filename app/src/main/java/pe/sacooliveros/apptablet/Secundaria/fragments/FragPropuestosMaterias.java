package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_prociencias;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proletras;

import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mPropuestosLetras;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragPropuestosMaterias extends Fragment {

    View rootview ;

    private GridView gridView, gridView2;
    ArrayList<mPropuestosCiencias> Lista;
    ArrayList<mPropuestosLetras> listaLetras;

    TextView tx_tomo2;
    ImageView tomo_back2;
    String tomodesc, temadesc;
    String acceso;



    public FragPropuestosMaterias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_propuestosmaterias, container, false);


        gridView= rootview.findViewById(R.id.ma_cienciasresultados);
        gridView2= rootview.findViewById(R.id.ma_proletras);


        tomo_back2= rootview.findViewById(R.id.img_backpropuestos);
        tx_tomo2=rootview.findViewById(R.id.tx_tomo2);


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tomodesc = bundle.getString("tomodesc");
            temadesc = bundle.getString("description");
            acceso = bundle.getString("ACCESO");

        }

        tx_tomo2.setText(tomodesc);

        adapter_prociencias.instantiate(acceso);
        adapter_proletras.instantiate(acceso);


        tomo_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentPropuestos();
                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                if (fmanager2 != null) {
                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                    if (ftransaction != null) {
                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                        ftransaction.addToBackStack("");
                        ftransaction.commit();
                    }
                }
            }

        });


        Lista= new ArrayList<mPropuestosCiencias>();


        Lista.add(new mPropuestosCiencias(R.drawable.ciencias_1,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_2,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_3,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_4,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_5,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_6,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_7,R.drawable.download_circle));
        Lista.add(new mPropuestosCiencias( R.drawable.ciencias_8,R.drawable.download_circle));


        final adapter_prociencias adapter= new adapter_prociencias( getContext(), Lista);

        gridView.setAdapter(adapter);


        listaLetras= new ArrayList<mPropuestosLetras>();


        listaLetras.add(new mPropuestosLetras(R.drawable.letras_1,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_2,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_3,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_4,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_5,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_6,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_7,R.drawable.download_circle));
        listaLetras.add(new mPropuestosLetras( R.drawable.letras_8,R.drawable.download_circle));


        final adapter_proletras adapter2= new adapter_proletras( getContext(), listaLetras);

        gridView2.setAdapter(adapter2);


        return rootview;
    }













}
