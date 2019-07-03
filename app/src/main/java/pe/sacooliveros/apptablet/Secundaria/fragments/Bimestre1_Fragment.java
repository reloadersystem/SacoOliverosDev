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
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterEFisica;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mEfisica;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.PopupAlertManager;
import pe.sacooliveros.apptablet.Utils.PopupCustomDialog;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bimestre1_Fragment extends Fragment {

    View rootview;
    ArrayList<mEfisica> Lista;
    String descrip, grado;
    TextView tx_temas;
    ImageView img_temas;
    PopupMenu popup;
    private GridView gridView;
    String gradoasiste;
    String gradonombre;


    public Bimestre1_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_bimestre1_, container, false);

        tx_temas = rootview.findViewById(R.id.tx_tomfisica);
        img_temas = rootview.findViewById(R.id.img_backfisica);
        gridView = rootview.findViewById(R.id.ma_listfisica);

        gradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().popBackStack();


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
//                } else if (gradoasiste.equalsIgnoreCase("Uni") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("CATOLICA") || gradonombre.equalsIgnoreCase("Quinto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
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

                        mListPruebas.add(new mPruebas("Futsal", "https://www.youtube.com/watch?v=7M9tTsxMDG0"));
                        mListPruebas.add(new mPruebas("Voley", "https://www.youtube.com/watch?v=HtGoIKCtkSo"));
                        mListPruebas.add(new mPruebas("Balonmano", "https://www.youtube.com/watch?v=KEEKW2CQKb8"));
                        mListPruebas.add(new mPruebas("Basquet", "https://www.youtube.com/watch?v=5F_HNvP0nZY"));
                        popupCustomDialog.customDialog(getContext(), "DEPORTES COLECTIVOS", mListPruebas);

                        break;


                    case 1:

                        mListPruebas.add(new mPruebas("Gimnasia Artística", "https://www.youtube.com/watch?v=Mum_42vNwcY"));
                        mListPruebas.add(new mPruebas("Levantamiento de Pesas", "https://www.youtube.com/watch?v=BHsbQ-In4DM"));
                        mListPruebas.add(new mPruebas("Saltos y Gimnasia", "https://www.youtube.com/watch?v=eDf_3a5HaeM"));
                        popupCustomDialog.customDialog(getContext(), "DEPORTES INDIVIDUALES", mListPruebas);

                        break;


                    case 2:

                        mListPruebas.add(new mPruebas("Higiene de la Actividad Física", "https://www.youtube.com/watch?v=n7L6JHG2f44"));
                        mListPruebas.add(new mPruebas("Habitos de Higiene Personal", "https://www.youtube.com/watch?v=oAVNp2wq2os"));
                        mListPruebas.add(new mPruebas("Importancia De La Higiene Personal", "https://www.youtube.com/watch?v=E7no7ToVnTI"));
                        popupCustomDialog.customDialog(getContext(), "HIGIENE Y SALUD", mListPruebas);

                        break;


                    case 3:

                        mListPruebas.add(new mPruebas("Alimentación Saludable", "https://www.youtube.com/watch?v=GU8WFy9io4Y"));
                        mListPruebas.add(new mPruebas("3 Cosas que debes saber de nutrición", "https://www.youtube.com/watch?v=NKF9jvxkkNg"));
                        mListPruebas.add(new mPruebas("¿Qué es la nutrición?", "https://www.youtube.com/watch?v=ETIwmxTAxB4"));
                        popupCustomDialog.customDialog(getContext(), "NUTRICIÓN", mListPruebas);

                        break;


                    case 4:

                        mListPruebas.add(new mPruebas("Historia de la Educación Física en el Mundo", "https://www.youtube.com/watch?v=_X4fsQHbF80"));
                        mListPruebas.add(new mPruebas("La Importancia de la Educación Física - 1 ", "https://www.youtube.com/watch?v=tg7OEWf3_jU"));
                        mListPruebas.add(new mPruebas("La Importancia de la Educación Física - 2", "https://www.youtube.com/watch?v=Bzs5EzgN1r0"));
                        popupCustomDialog.customDialog(getContext(), "LA EDUCACIÓN FÍSICA", mListPruebas);

                        break;

                }

            }
        });

        return rootview;
    }

}