package pe.sacooliveros.apptablet.Secundaria;


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
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proresueltosciencias;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_proresueltosletras;
import pe.sacooliveros.apptablet.Secundaria.Model.mPresueltosCiencias;
import pe.sacooliveros.apptablet.Secundaria.Model.mPresueltostosLetras;
import pe.sacooliveros.apptablet.Secundaria.fragmentResueltos;

/**
 * A simple {@link Fragment} subclass.
 */
public class MesResueltosFragment extends Fragment {

    View rootview ;

    private GridView gridView, gridView2;
    ArrayList<mPresueltosCiencias> Lista;
    ArrayList<mPresueltostosLetras> listaLetras;

    TextView tx_tomo2;
    ImageView tomo_back2;
    String tomodesc, temadesc;
    String acceso;


    public MesResueltosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_mes_resueltos, container, false);

        gridView= rootview.findViewById(R.id.ma_cienciasresultados);
        gridView2= rootview.findViewById(R.id.ma_letrasresultados);



        tomo_back2= rootview.findViewById(R.id.img_backpresueltos);
        tx_tomo2=rootview.findViewById(R.id.tx_tomo2);


        //tomodesc

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tomodesc = bundle.getString("tomodesc");
            acceso = bundle.getString("ACCESO");


        }

        tx_tomo2.setText(tomodesc);

        adapter_proresueltosciencias.instantiate(acceso);
        adapter_proresueltosletras.instantiate(acceso);

        tomo_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fragment fragment2 = new fragmentResueltos();
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



        Lista= new ArrayList<mPresueltosCiencias>();


        Lista.add(new mPresueltosCiencias(R.drawable.ciencias_1,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_2,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_3,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_4,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_5,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_6,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_7,R.drawable.download_circle));
        Lista.add(new mPresueltosCiencias( R.drawable.ciencias_8,R.drawable.download_circle));


        final adapter_proresueltosciencias adapter= new adapter_proresueltosciencias( getContext(), Lista);

        gridView.setAdapter(adapter);


        listaLetras= new ArrayList<mPresueltostosLetras>();


        listaLetras.add(new mPresueltostosLetras(R.drawable.letras_1,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_2,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_3,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_4,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_5,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_6,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_7,R.drawable.download_circle));
        listaLetras.add(new mPresueltostosLetras( R.drawable.letras_8,R.drawable.download_circle));


        final adapter_proresueltosletras adapter2= new adapter_proresueltosletras( getContext(), listaLetras);

        gridView2.setAdapter(adapter2);
        
        
        
        return rootview;
    }

}
