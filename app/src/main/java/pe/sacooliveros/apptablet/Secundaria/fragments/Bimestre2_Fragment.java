package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterEFisica;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mEfisica;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.PopupCustomDialog;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre2_Fragment extends Fragment {

    View rootview;

    private GridView gridView;
    ArrayList<mEfisica> Lista;

    String descrip, grado;

    TextView tx_temas;

    ImageView img_temas;

    String gradoasiste;

    String gradonombre;


    public Bimestre2_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_bimestre2_, container, false);

        tx_temas = rootview.findViewById(R.id.tx_tomfisica);
        img_temas = rootview.findViewById(R.id.img_backfisica);
        gridView = rootview.findViewById(R.id.ma_listfisica);

        gradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//
//                if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE"))
//
//                {
//                    Fragment fragment2 = new InitialFragment();
//                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                    if (fmanager2 != null) {
//                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                        if (ftransaction != null) {
//                            ftransaction.replace(R.id.contenedorFragments, fragment2);
//                            ftransaction.addToBackStack("");
//                            ftransaction.commit();
//                        }
//                    }
//
//                }
//
//                if (gradoasiste.equalsIgnoreCase("Uni") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
//
//                    Fragment fragment2 = new mainFragmentUni();
//                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                    if (fmanager2 != null) {
//                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                        if (ftransaction != null) {
//                            ftransaction.replace(R.id.contenedorFragments, fragment2);
//                            ftransaction.addToBackStack("");
//                            ftransaction.commit();
//                        }
//                    }
//                }

                getActivity().getSupportFragmentManager().popBackStack();



            }
        });


        Lista = new ArrayList<mEfisica>();

        Lista.add(new mEfisica(R.drawable.edufisicaini_1));
        Lista.add(new mEfisica(R.drawable.edufisicaini_2));
        Lista.add(new mEfisica(R.drawable.edufisicaini_3));
        Lista.add(new mEfisica(R.drawable.edufisicaini_4));
        Lista.add(new mEfisica(R.drawable.edufisicaini_5));

        final adapterEFisica adapter = new adapterEFisica(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                ArrayList<mPruebas> mListPruebas;
                mListPruebas = new ArrayList<mPruebas>();
                PopupCustomDialog popupCustomDialog = new PopupCustomDialog();


                switch (position) {

                    case 0:

                        mListPruebas.add(new mPruebas("Deportes Colectivos - 1", "https://www.youtube.com/watch?v=nBzdmNioNJo"));
                        mListPruebas.add(new mPruebas("Voley", "https://www.youtube.com/watch?v=HtGoIKCtkSo"));
                        mListPruebas.add(new mPruebas("Deportes Colectivos - 2", "https://www.youtube.com/watch?v=hpYu92kBUzI"));

                        popupCustomDialog.customDialog(getContext(), "DEPORTES COLECTIVOS", mListPruebas);

                        break;


                    case 1:

                        mListPruebas.add(new mPruebas("Conoce a los deportistas priorizados Top Perú Lima 2019", "https://www.youtube.com/watch?v=ETfQrgdBIuA"));
                        mListPruebas.add(new mPruebas("Deportes Individuales - 1", "https://www.youtube.com/watch?v=1XfMhw83p4c"));
                        mListPruebas.add(new mPruebas("Los deportistas Top Perú Lima 2019", "https://www.youtube.com/watch?v=2K3gt4noH2U"));
                        popupCustomDialog.customDialog(getContext(), "DEPORTES INDIVIDUALES", mListPruebas);

                        break;


                    case 2:

                        mListPruebas.add(new mPruebas("Higiene de la Actividad Física", "https://www.youtube.com/watch?v=n7L6JHG2f44"));
                        mListPruebas.add(new mPruebas("¿Como prevenir la Enfermedad?", "https://www.youtube.com/watch?v=Foq7Dm1Jhak"));
                        mListPruebas.add(new mPruebas("¿Sabías que el exceso de higiene es perjudicial para la salud?", "https://www.youtube.com/watch?v=Pot81r6VBnw"));
                        popupCustomDialog.customDialog(getContext(), "HIGIENE Y SALUD", mListPruebas);

                        break;


                    case 3:

                        mListPruebas.add(new mPruebas("Alimentación Saludable", "https://www.youtube.com/watch?v=GU8WFy9io4Y"));
                        mListPruebas.add(new mPruebas("Nutrición para deportistas", "https://www.youtube.com/watch?v=IoJjrc07EUI"));
                        mListPruebas.add(new mPruebas("La importancia de una alimentacion variada y equilibrada", "https://www.youtube.com/watch?v=LwEsUQJ_auA"));
                        popupCustomDialog.customDialog(getContext(), "NUTRICIÓN", mListPruebas);

                        break;


                    case 4:

                        mListPruebas.add(new mPruebas("Historia de la Educación Física en el Mundo", "https://www.youtube.com/watch?v=_X4fsQHbF80"));
                        mListPruebas.add(new mPruebas("La Importancia de la Educación Física - 1 ", "https://www.youtube.com/watch?v=tg7OEWf3_jU"));
                        mListPruebas.add(new mPruebas("La Importancia de la Educación Física - 2", "https://www.youtube.com/watch?v=ETfQrgdBIuA"));
                        popupCustomDialog.customDialog(getContext(), "LA EDUCACIÓN FÍSICA", mListPruebas);

                        break;

                }

            }
        });

        return rootview;
    }

}
