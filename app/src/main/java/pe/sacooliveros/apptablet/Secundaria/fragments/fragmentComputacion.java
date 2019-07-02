package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterComputacion;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mPopupVideoMotivadores;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoComputacion;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapter_PopupMotivadores;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentComputacion extends Fragment {

    View rootview;

    private GridView gridView;
    ArrayList<mTomoComputacion> Lista;
    TextView tx_temas;
    ImageView img_temas;
    String descrip, grado;
    String datofragment;
    Button btn_computacion;
    String acceso;


    public fragmentComputacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_fragment_computacion, container, false);

        tx_temas = rootview.findViewById(R.id.tx_temas);
        img_temas = rootview.findViewById(R.id.img_backexamcap);
        gridView = rootview.findViewById(R.id.ma_tomocomputacion);
        btn_computacion = rootview.findViewById(R.id.btn_computacion);


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");

        }

        // tx_temas.setText(descrip);

        adapterComputacion.instantiate(acceso);

        Lista = new ArrayList<mTomoComputacion>();

        Lista.add(new mTomoComputacion(R.drawable.diapcatolica_1, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mTomoComputacion(R.drawable.diapcatolica_2, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mTomoComputacion(R.drawable.diapcatolica_3, R.drawable.ic_file_download_black_24dp));
        Lista.add(new mTomoComputacion(R.drawable.diapcatolica_4, R.drawable.ic_file_download_black_24dp));



        final adapterComputacion adapter = new adapterComputacion(getContext(), Lista);

        gridView.setAdapter(adapter);

        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                getActivity().getSupportFragmentManager().popBackStack();

//                Fragment fragment2 = new InitialFragment();
//                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
//                if (fmanager2 != null) {
//
//
//                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
//                    if (ftransaction != null) {
//                        ftransaction.replace(R.id.contenedorFragments, fragment2);
//                        ftransaction.addToBackStack("");
//                        ftransaction.commit();
//                    }
//                }
            }
        });

        btn_computacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog alertDialog;
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                LayoutInflater inflater = LayoutInflater.from(getContext());

                View view2 = inflater.inflate(R.layout.popupcomputacion, null);

                GridView lvView = view2.findViewById(R.id.grid_motivacion);
                Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
                TextView txmotivadores = view2.findViewById(R.id.txt_motivadores);

                builder.setView(view2);
                alertDialog = builder.create();
                alertDialog.show();


                txmotivadores.setText("MATERIALES DE INTERES CIENTÍFICO \nY TECNOLÓGICO");

                final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                // String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LA HORA DEL CÓDIGO", "https://code.org/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CURSOS EN AULA CLIC", "https://www.aulaclic.es/index.htm"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("PROGRAMACIÓN YA ", "https://www.tutorialesprogramacionya.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("JUEGOS PARA EL CEREBRO", "https://www.gamesforthebrain.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("INDIGO TUTORIALES", "https://indigotutoriales.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("WIKI FREECAD TEMPORADA 1", "http://www.iearobotics.com/wiki/index.php?title=Dise%C3%B1o_de_piezas_con_Freecad"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("VIDEO TUTORIAL FREECAD TEMPORADA 1", "https://www.youtube.com/watch?v=2_DbFzFV9D4&list=PLmnz0JqIMEzWQV-3ce9tVB_LFH9a91YHf"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("WIKI FREECAD TUTORIAL 2", "http://www.iearobotics.com/wiki/index.php?title=Tutorial_Freecad._Temporada_2"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("VIDEO TUTORIAL FREECAD TEMPORADA 2", "https://www.youtube.com/watch?v=tvevj-esu_E&index=1&list=PLmnz0JqIMEzUqEM-nxqhZoDaqszVXijOb"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("PERU-EDUCA", "http://www.perueduca.pe/estudiantes"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("UNIVERSIA", "http://www.universia.edu.pe/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("JUGANDO Y APRENDIENDO", "https://luisamariaarias.wordpress.com/secundaria/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("ÁREA TECNOOLOGÍA", "http://www.areatecnologia.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("SOPA LETRAS", "http://www.sopasletras.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CODE MONKEY", "https://www.playcodemonkey.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("KODABLE", "https://www.kodable.com/"));
                mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CODESPARK ACADEMIA Y FOOS", "https://play.google.com/store/apps/details?id=org.codespark.thefoos&hl=es"));

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
        });


        /*btn_computacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popup = new PopupMenu(getContext(),btn_computacion,Gravity.DISPLAY_CLIP_VERTICAL|Gravity.RIGHT);
                //inflating menu from xml resource
                popup.inflate(R.menu.menu_computacion);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:

                            {
                                Uri uri = Uri.parse("https://code.org/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }


                            break;

                            case R.id.menu2:

                            {
                                Uri uri = Uri.parse("https://www.aulaclic.es/index.htm");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }

                            break;

                            case R.id.menu3:
                            {
                                Uri uri = Uri.parse("https://www.tutorialesprogramacionya.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu4:
                            {
                                Uri uri = Uri.parse("https://www.gamesforthebrain.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }

                            break;


                            case R.id.menu5:
                            {
                                Uri uri = Uri.parse("https://indigotutoriales.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }

                            break;



                            case R.id.menu6:
                            {
                                Uri uri = Uri.parse("http://www.iearobotics.com/wiki/index.php?title=Dise%C3%B1o_de_piezas_con_Freecad");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;

                            case R.id.menu7:
                            {
                                Uri uri = Uri.parse("https://www.youtube.com/watch?v=2_DbFzFV9D4&list=PLmnz0JqIMEzWQV-3ce9tVB_LFH9a91YHf");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu8:
                            {
                                Uri uri = Uri.parse("http://www.iearobotics.com/wiki/index.php?title=Tutorial_Freecad._Temporada_2");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu9:
                            {
                                Uri uri = Uri.parse("https://www.youtube.com/watch?v=tvevj-esu_E&index=1&list=PLmnz0JqIMEzUqEM-nxqhZoDaqszVXijOb");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu10:
                            {
                                Uri uri = Uri.parse("http://www.perueduca.pe/estudiantes");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;

                            case R.id.menu11:
                            {
                                Uri uri = Uri.parse("http://www.universia.edu.pe/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;

                            case R.id.menu12:
                            {
                                Uri uri = Uri.parse("https://luisamariaarias.wordpress.com/secundaria/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu13:
                            {
                                Uri uri = Uri.parse("http://www.areatecnologia.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu14:
                            {
                                Uri uri = Uri.parse("http://www.sopasletras.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu15:
                            {
                                Uri uri = Uri.parse("https://www.playcodemonkey.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu16:
                            {
                                Uri uri = Uri.parse("https://www.kodable.com/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu17:
                            {
                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.washawasha");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }
                            break;


                            case R.id.menu18:
                            {
                                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=org.codespark.thefoos&hl=es");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                getContext().startActivity(intent);
                            }

                            break;
                        }
                        return false;
                    }
                });

                popup.show();
            }
        });*/


//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                mTomo mtomo = (mTomo) adapter.getItem(position);
//
//
//                switch (position) {
//
//                    case 0:
//
//
//                        break;
//                }
//
//            }
//        });


        return rootview;
    }

}
