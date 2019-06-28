package pe.sacooliveros.apptablet.QuintoCatolica.Fragment;


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

import pe.sacooliveros.apptablet.QuintoCatolica.Adapter.adapterTomoCatolica;
import pe.sacooliveros.apptablet.QuintoCatolica.Model.mTomoCatolica;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mVSeminario;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentHDiapositivas;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentDiapositivasCatolica extends Fragment {

    private GridView gridView;
    ArrayList<mTomoCatolica> Lista;
    TextView tx_temas;
    ImageView img_temas;

    String descrip, grado;


    String datofragment;

    String acceso;

    View rootview;

    String gradoasiste;

    String datoshare;

    String tomodesc;



    public fragmentDiapositivasCatolica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_diapositivas_catolica, container, false);

        tx_temas= rootview.findViewById(R.id.tx_temaVSeminario);
        img_temas= rootview.findViewById(R.id.img_backtomocatolica);
        gridView= rootview.findViewById(R.id.grid_tomoCatolica);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
            tomodesc = bundle.getString("tomodesc");
        }

        tx_temas.setText(tomodesc);

        Lista= new ArrayList<mTomoCatolica>();

        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_1,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_2,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_3,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_4,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_5,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.catolicatomo_6,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_7,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_8,R.drawable.descarga));
        Lista.add(new mTomoCatolica(R.drawable.imagecatolica_9,R.drawable.descarga));


        final adapterTomoCatolica adapter= new adapterTomoCatolica( getContext(), Lista);

        gridView.setAdapter(adapter);

        datoshare= ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // getActivity().getSupportFragmentManager().popBackStack();



                Fragment fragment2 = new fragmentHDiapositivas();
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
        return rootview;
    }

}
