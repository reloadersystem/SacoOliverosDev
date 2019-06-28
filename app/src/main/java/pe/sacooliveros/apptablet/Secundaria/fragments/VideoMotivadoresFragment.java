package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_VideoMotivadores;
import pe.sacooliveros.apptablet.Secundaria.Model.mPopupVideoMotivadores;
import pe.sacooliveros.apptablet.Secundaria.Model.mVideoMotivadores;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapter_PopupMotivadores;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.PopupCustomDialog;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoMotivadoresFragment extends Fragment {


    private static final String TAG = "VideoMotivadoresFragmen";
    View rootview;
    private GridView gridView;
    ArrayList<mVideoMotivadores> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String acceso;

    String gradoasiste;

    String sharedata;

    String tipogradoasiste;


    public VideoMotivadoresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview = inflater.inflate(R.layout.fragment_videomotivadores, container, false);

        img_temas = rootview.findViewById(R.id.img_backmotivadores);
        gridView = rootview.findViewById(R.id.grid_motivadores);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            descrip = bundle.getString("description");
            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");
            gradoasiste = bundle.getString("TipoGradoAsiste");
        }

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().popBackStack();

                /*tipogradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
                String gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");


                if (tipogradoasiste.equalsIgnoreCase("REGULAR") || gradonombre.equalsIgnoreCase("Cuarto Año") && tipogradoasiste.equalsIgnoreCase("PRE")) {
                    Fragment fragment2 = new InitialFragment();
                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                    if (fmanager2 != null) {


                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("UNI")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("SAN MARCOS")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("CATOLICA")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {

                    Fragment fragment3 = new mainFragmentUni();
                    FragmentManager fmanager3 = getActivity().getSupportFragmentManager();
                    if (fmanager3 != null) {


                        FragmentTransaction ftransaction = fmanager3.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment3);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (tipogradoasiste.equalsIgnoreCase("CIRCULO")) {

                    Fragment fragment2 = new InitialFragment();
                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                    if (fmanager2 != null) {


                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                }*/


            }

        });


        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel"); //5 Secundaria


        Lista = new ArrayList<mVideoMotivadores>();

        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_1, "Tomo 1"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_2, "Tomo 2"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_3, "Tomo 3"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_4, "Tomo 4"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_5, "Tomo 5"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_6, "Tomo 6"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_7, "Tomo 7"));
        Lista.add(new mVideoMotivadores(R.drawable.secundariatomovm_8, "Tomo 8"));

        final adapter_VideoMotivadores adapter = new adapter_VideoMotivadores(getContext(), Lista);

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {

                    case 0:

                    {
                        final AlertDialog alertDialog;
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View view2 = inflater.inflate(R.layout.popupmotivadores, null);

                        GridView lvView = view2.findViewById(R.id.grid_motivacion);
                        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
                        TextView txmotivadores = view2.findViewById(R.id.txt_motivadores);

                        builder.setView(view2);
                        alertDialog = builder.create();
                        alertDialog.show();

                        txmotivadores.setText("VIDEOS MOTIVACIONALES - TOMO I");

                        final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                        mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                        String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                        if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("REFLEXIÓN COMPAÑERISMO", "https://www.youtube.com/watch?v=6LIZGItzIIE"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LENGUAJE DE SEÑAS", "https://www.youtube.com/watch?v=WXkzF7kMC9I"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("HOLA AMIGO", "https://www.youtube.com/watch?v=-cDhHl6kvXU"));
                        }

                        if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CONCIENCIA DE TRABAJO EN EQUIPO", "https://www.youtube.com/watch?v=tV9in2lhpmc"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("AMABILIDAD", "https://www.youtube.com/watch?v=QXiwZtnQq88"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("EL REFRIGERADOR CHILLIE", "https://www.youtube.com/watch?v=R-ufluPWBuM"));
                        }


                        if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("VALORAR LO QUE TENEMOS", "https://www.youtube.com/watch?v=WPnDAUmMS-8"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LOS COLORES DE DE LAS FLORES", "https://www.youtube.com/watch?v=BhheUpOB640"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("A JOY STORY", "https://www.youtube.com/watch?v=t07s6K94c7E"));
                        }

                        if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CARROT CRAZY", "https://www.youtube.com/watch?v=7V7MOk0FZrg"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LE PETIT CORDONNIER", "https://www.youtube.com/watch?v=XjXlFlGn8DQ"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("QUE CAMBIARÍAS", "https://www.youtube.com/watch?v=2IKlpD37CPI"));
                        }


                        if (sharedata.equalsIgnoreCase("5 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("ESFUERZO - VIDEO DE MOTIVACIÓN", "https://www.youtube.com/watch?v=HXXOrTL2i7E&t=54s"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("ACTITUD POSITIVA", "https://www.youtube.com/watch?v=EcUdD9TAsQM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("GENEROSIDAD - COMPAÑERISMO EN EL TRABAJO", "https://www.youtube.com/watch?v=VADR6RNTJMk"));
                        }

                        final adapter_PopupMotivadores adapter2 = new adapter_PopupMotivadores(getContext(), mpopupvideoMotivadores);
                        lvView.setAdapter(adapter2);

                        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                                int motivadorcount = adapterView.getCount();

                                mPopupVideoMotivadores mPopupVideoMotivadores = (mPopupVideoMotivadores) adapter2.getItem(position);

                                for (int a = 0; a < motivadorcount; a++) {

                                    if (position == a) {
                                        String URLMotivador = mPopupVideoMotivadores.getUrldata();
                                        Uri uri = Uri.parse(URLMotivador);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);
                                    }
                                }
                            }
                        });


                        btn_cerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });


                        break;
                    }


                    case 1: {

                        final AlertDialog alertDialog;
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View view2 = inflater.inflate(R.layout.popupmotivadores, null);

                        GridView lvView = view2.findViewById(R.id.grid_motivacion);
                        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
                        TextView txmotivadores = view2.findViewById(R.id.txt_motivadores);

                        builder.setView(view2);
                        alertDialog = builder.create();
                        alertDialog.show();

                        txmotivadores.setText("VIDEOS MOTIVACIONALES - TOMO 2");

                        final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                        mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                        String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                        if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("El Latido de mi Corazón", "https://www.youtube.com/watch?v=SCUzzxUxLW0"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("La amistad", "https://www.youtube.com/watch?v=s7TF9rgytUM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("En búsqueda de la gloria", "https://www.youtube.com/watch?v=lTKAM1B8H48"));


                        }

                        if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Hechizado", "https://www.youtube.com/watch?v=W_B2UZ_ZoxU"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Supera tus miedos", "https://www.youtube.com/watch?v=DnTL6fUDl-I"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Ninguna idea es imposible de realizar", "https://www.youtube.com/watch?v=Kuf-up4frr4"));
                        }


                        if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("los buenos samaritanos en nuestras vidas", "https://www.youtube.com/watch?v=ovj5dzMxzmc"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Diseño de sonido", "https://www.youtube.com/watch?v=s7ylQ2Yzajo"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Lucha por tus sueños", "https://www.youtube.com/watch?v=Ch9fOS5SPvQ"));
                        }

                        if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("No esperes máquinas que solucionen problemas", "https://www.youtube.com/watch?v=Z3r73jc1AOE"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Supera tus debilidades", "https://www.youtube.com/watch?v=OuJ4BBQ0nhc"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("La vida es cuestión de actitud", "https://www.youtube.com/watch?v=KzQwyXg6CV0"));
                        }


                        if (sharedata.equalsIgnoreCase("5 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Reflexión", "https://www.youtube.com/watch?v=g7dUyKpugeA"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("El árbol", "https://www.youtube.com/watch?v=GPeeZ6viNgY"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Es posible", "https://www.youtube.com/watch?v=K_Xtje9Fh4w"));

                        }

                        final adapter_PopupMotivadores adapter2 = new adapter_PopupMotivadores(getContext(), mpopupvideoMotivadores);
                        lvView.setAdapter(adapter2);

                        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                                int motivadorcount = adapterView.getCount();

                                mPopupVideoMotivadores mPopupVideoMotivadores = (mPopupVideoMotivadores) adapter2.getItem(position);

                                for (int a = 0; a < motivadorcount; a++) {

                                    if (position == a) {
                                        String URLMotivador = mPopupVideoMotivadores.getUrldata();
                                        Uri uri = Uri.parse(URLMotivador);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);
                                    }
                                }
                            }
                        });


                        btn_cerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });


                        break;
                    }

                    case 2: {

                        final AlertDialog alertDialog;
                        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                        LayoutInflater inflater = LayoutInflater.from(getContext());

                        View view2 = inflater.inflate(R.layout.popupmotivadores, null);

                        GridView lvView = view2.findViewById(R.id.grid_motivacion);
                        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
                        TextView txmotivadores = view2.findViewById(R.id.txt_motivadores);

                        builder.setView(view2);
                        alertDialog = builder.create();
                        alertDialog.show();

                        txmotivadores.setText("VIDEOS MOTIVACIONALES - TOMO 3");

                        final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                        mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                        String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                        if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Contra el acoso escolar", "https://www.youtube.com/watch?v=l-OIl2i6YH8"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Cree en ti", "https://www.youtube.com/watch?v=N3XdlnCknYM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Inclusión", "https://www.youtube.com/watch?v=jizyi83ph20"));
                        }

                        if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Cuestión de actitud", "https://www.youtube.com/watch?v=MzimNEikhWM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("El puente", "https://www.youtube.com/watch?v=LAOICItn3MM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Inclusión", "https://www.youtube.com/watch?v=9Hq9rf0XgrI"));
                        }


                        if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Tolerancia", "https://www.youtube.com/watch?v=IjjEGu2pBtY"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Empatía ", "https://www.youtube.com/watch?v=nfYPktsd9bs"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Esfuerzo y disciplina", "https://www.youtube.com/watch?v=UHaJPVtS2SI"));
                        }

                        if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Empatía", "https://www.youtube.com/watch?v=GJ89dk9chnk"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Identidad", "https://www.youtube.com/watch?v=ikGVWEvUzNM"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Importancia de las emociones", "https://www.youtube.com/watch?v=Kf1dVM0lVq4"));
                        }


                        if (sharedata.equalsIgnoreCase("5 Secundaria")) {
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Reflexión", "https://www.youtube.com/watch?v=stDeBT6MhrU"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("El árbol", "https://www.youtube.com/watch?v=nwAYpLVyeFU"));
                            mpopupvideoMotivadores.add(new mPopupVideoMotivadores("Es posible", "https://www.youtube.com/watch?v=UB3nKCNUBB4"));

                        }

                        final adapter_PopupMotivadores adapter2 = new adapter_PopupMotivadores(getContext(), mpopupvideoMotivadores);
                        lvView.setAdapter(adapter2);

                        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                                int motivadorcount = adapterView.getCount();

                                mPopupVideoMotivadores mPopupVideoMotivadores = (mPopupVideoMotivadores) adapter2.getItem(position);

                                for (int a = 0; a < motivadorcount; a++) {

                                    if (position == a) {
                                        String URLMotivador = mPopupVideoMotivadores.getUrldata();
                                        Uri uri = Uri.parse(URLMotivador);
                                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                        getContext().startActivity(intent);
                                    }
                                }
                            }
                        });


                        btn_cerrar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });

                    }

                    break;

                    case 3: {

                        ArrayList<mPruebas> mListPruebas;
                        mListPruebas = new ArrayList<mPruebas>();
                        PopupCustomDialog popupCustomDialog = new PopupCustomDialog();

                        if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                            mListPruebas.add(new mPruebas("No pierdas la fe", "https://www.youtube.com/watch?v=OL5PVmeQApM"));
                            mListPruebas.add(new mPruebas("Prioridades", "https://www.youtube.com/watch?v=aPweMYVdwe4"));
                            mListPruebas.add(new mPruebas("No a la violencia contra la mujer", "https://www.youtube.com/watch?v=QOokC_Vo3eA"));
                        }

                        if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                            mListPruebas.add(new mPruebas("No pierdas de vista el objetivo", "https://www.youtube.com/watch?v=Fj2FMkyqHDk"));
                            mListPruebas.add(new mPruebas("Respeto", "https://www.youtube.com/watch?v=3dXl28y7BIA"));
                            mListPruebas.add(new mPruebas("No a la violencia contra la mujer", "https://www.youtube.com/watch?v=QOokC_Vo3eA"));
                        }


                        if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                            mListPruebas.add(new mPruebas("Tolerancia y Respeto", "https://www.youtube.com/watch?v=38y_1EWIE9I"));
                            mListPruebas.add(new mPruebas("Responsabilidad", "https://www.youtube.com/watch?v=r2RMuHrD7to"));
                            mListPruebas.add(new mPruebas("No a la violencia contra la mujer", "https://www.youtube.com/watch?v=QOokC_Vo3eA"));
                        }

                        if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                            mListPruebas.add(new mPruebas("Oportunidades", "https://www.youtube.com/watch?v=U-e19ohY0Zo"));
                            mListPruebas.add(new mPruebas("Perseverancia", "https://www.youtube.com/watch?v=Veh0vJc6H9c&t=8s"));
                            mListPruebas.add(new mPruebas("No a la violencia contra la mujer", "https://www.youtube.com/watch?v=QOokC_Vo3eA"));
                        }

                        if (sharedata.equalsIgnoreCase("5 Secundaria")) {
                            mListPruebas.add(new mPruebas("Identificación", "https://www.youtube.com/watch?v=UB3nKCNUBB4&t=77s"));
                            mListPruebas.add(new mPruebas("Liderazgo", "https://www.youtube.com/watch?v=Pr-0Rz6Ga0M"));
                            mListPruebas.add(new mPruebas("No a la violencia contra la mujer", "https://www.youtube.com/watch?v=QOokC_Vo3eA"));
                        }

                        popupCustomDialog.customDialog(getContext(), "VIDEO MOTIVACIONALES - TOMO 4", mListPruebas);

                    }
                    break;

                    case 4: {
                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
                    }
                    break;


                    case 5: {
                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
                    }
                    break;

                    case 6: {
                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
                    }
                    break;

                    case 7: {
                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }

            }
        });


        return rootview;
    }

    private void urldata(String dataurl) {

        Uri uri = Uri.parse(dataurl);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        getContext().startActivity(intent);
    }

}
