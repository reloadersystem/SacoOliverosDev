package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mPopupVideoMotivadores;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapter_PopupMotivadores;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentPlanLector extends Fragment {

    Context context;

    View rootview;

    Button btn_tecnicalectura, btn_lecturainspiradoras, btn_materialesliterarios;

    ImageView img_temas;


    public fragmentPlanLector() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootview = inflater.inflate(R.layout.fragment_fragment_plan_lector, container, false);

        btn_tecnicalectura = rootview.findViewById(R.id.btn_computacion);
        btn_lecturainspiradoras = rootview.findViewById(R.id.btn_lecturainspiradoras);
        btn_materialesliterarios = rootview.findViewById(R.id.btn_materialesliterarios);
        img_temas = rootview.findViewById(R.id.img_backexamcap);


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

        btn_materialesliterarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                txmotivadores.setText("MATERIALES LITERARIOS AUDIOVISUALES");

                final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("EL HIPOCAMPO DE ORO", "http://docs.google.com/gview?embedded=true&url=https://idiomasuniminutocrzblog.files.wordpress.com/2017/03/el-hipocampo-de-oro.pdf"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LA AJORCA DE  ORO ", "http://docs.google.com/gview?embedded=true&url=http://cdigital.dgb.uanl.mx/la/1020027225_C/1020027225_T1/1020027225_010.pdf"));

                }

                if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("VIAJE AL CENTRO DE LA TIERRA", "http://docs.google.com/gview?embedded=true&url=http://cms.univalle.edu.co/todosaaprender/anexos/placeres/VerneJulioViajealCentrodelaTierra.pdf"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("SHERLOCK HOLMES - EL VAMPIRO DE SUSSEX", "http://10millibrosparadescargar.com/bibliotecavirtual/libros/LETRA%20C/Conan%20Doyle,%20Arthur%20-%20El%20archivo%20de%20Sherlock%20Holmes.pdf"));
                }


                if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LOS CRIMENES DE LA CALLE  MORGUE", "http://bibliotecadigital.ilce.edu.mx/Colecciones/ObrasClasicas/_docs/CrimenesCalleMorgue.pdf"));
                }

                if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LA VERDAD SOBRE EL CASO DEL SEÑOR VALDEMAR", "http://docs.google.com/gview?embedded=true&url=http://190.186.233.212/filebiblioteca/Ciencia%20Ficcion%20-%20Fantasia%20-%20Terror%20-%20Policiales/-%20Edgar%20Allan%20Poe/Edgar%20Allan%20Poe%20-%20La%20Verdad%20sobre%20el%20caso%20del%20Senor%20Valdemar%20(1845).pdf"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LA LIGA DE LOS  PELIROJOS", "http://docs.google.com/gview?embedded=true&url=https://www.buenosaires.gob.ar/sites/gcaba/files/libro_la_liga_de_los_pelirrojos.pdf"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("MI NOVELA FAVORITA - DON QUIJOTE DE LA MANCHA", "https://www.youtube.com/watch?v=hl3NkSr4kkA "));
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
        });

        btn_lecturainspiradoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

                txmotivadores.setText("LECTURAS MOTIVACIONALES E INSPIRADORAS");

                final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("EL BAGRECICO", "http://es.diarioinca.com/2009/08/el-bagrecico-francisco-izquierdo-rios.html"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("PERSÉPOLIS", "https://www.izicomics.com/ver-comic-persepolis-1/"));
                }

                if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("WARMA KULLAY", "http://haravicus.blogspot.com/2009/12/warma-kuyay-amor-de-nino-texto-completo.html"));
                }

                if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
                }

                if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));
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
        });

        btn_tecnicalectura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                txmotivadores.setText("TÉCNICAS DE LECTURA");

                final ArrayList<mPopupVideoMotivadores> mpopupvideoMotivadores;

                mpopupvideoMotivadores = new ArrayList<mPopupVideoMotivadores>();

                String sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

                if (sharedata.equalsIgnoreCase("1 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("SUBRAYADO DE PALABRAS DESCONOCIDAS", "http://docs.google.com/gview?embedded=true&url=https://www2.uned.es/ca-sevilla/pdf/EL_SUBRAYADO.pdf"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("SUMILLADO", "https://www.youtube.com/watch?v=FbimuVIR3yE"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("RESÚMEN A PARTIR DEL SUMILLADO(DESDE EL MINUTO 4:53 HASTA EL MINUTO 6:36)", "https://www.youtube.com/watch?v=HdjhOOgCxH0"));
                }


                if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("MAPAS SEMÁNTICOS", "https://docplayer.es/19157775-Mapa-semantico-debora-de-sa.html"));
                }

                if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("PARAFRASEO(Hasta el minuto 3:08)", "https://www.youtube.com/watch?v=HdjhOOgCxH0"));
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("LECTURA VIVENCIAL – ESCENIFICACIÓN", "https://prezi.com/fhcnp6sq6ief/la-escenificacion-del-cuento/"));

                }

                if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                    mpopupvideoMotivadores.add(new mPopupVideoMotivadores("PARAFRASEO", "https://media.utp.edu.co/referencias-bibliograficas/uploads/referencias/ponencia/parafrasispdf-kxhMD-articulo.pdf"));
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
        });

        return rootview;
    }

    static String PREFS_KEY = "autenticacionOff";

    public static String obtenerValor(Context context, String keyPref) {

        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        android.util.Log.e("resultadologeo", preferences.getString(keyPref, ""));
        return preferences.getString(keyPref, "");

    }

}
