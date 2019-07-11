package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoCatolica.Fragment.fragment_TCatolica_Seminario;
import pe.sacooliveros.apptablet.QuintoUniversidades.mainFragmentUni;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapterVSeminario;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mVSeminario;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.YouTube.YouTubeViewer;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentVSeminario extends Fragment {

    View rootview;
    private GridView gridView;
    ArrayList<mVSeminario> Lista;
    TextView tx_temas;
    ImageView img_temas, img_videoseminario;

    String descrip, grado;

    String gradoasiste;

    String acceso;

    ConnectionDetector cd;

    String sharedata;

    Button btn_VideoSeminario;

    Button btn_tomoseminario;

    String tomodescripcion;

    String gradonombre;


    public fragmentVSeminario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        rootview = inflater.inflate(R.layout.fragment_fragment_vseminario, container, false);

        tx_temas = rootview.findViewById(R.id.tx_temaVSeminario);
        img_temas = rootview.findViewById(R.id.img_Seminario);
        gridView = rootview.findViewById(R.id.ma_tomoSeminario);
        btn_VideoSeminario = rootview.findViewById(R.id.btn_VideoSeminario);
        btn_tomoseminario = rootview.findViewById(R.id.btn_tomoseminario);

        img_videoseminario = rootview.findViewById(R.id.img_VideoSeminario);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            grado = bundle.getString("grado");
            acceso = bundle.getString("ACCESO");//1
            gradoasiste = bundle.getString("TipoGradoAsiste");//"Regular"
            tomodescripcion = bundle.getString("tomodesc");//"Regular"
        }


        if (tomodescripcion == null) {
            btn_tomoseminario.setText("");
        }

        btn_tomoseminario.setText(" " + tomodescripcion + " ");

        if (gradoasiste == null) {
            gradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
        }


        if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("PRE")) {
            btn_tomoseminario.setText("");
        }

        adapterVSeminario.gradoacceso(acceso);
        adapterVSeminario.gradoasiste(gradoasiste);

        gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");

        Lista = new ArrayList<mVSeminario>();

        if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && gradoasiste.equalsIgnoreCase("PRE")) {
            Lista.add(new mVSeminario(R.drawable.ciencias_1));
            Lista.add(new mVSeminario(R.drawable.ciencias_2));
            Lista.add(new mVSeminario(R.drawable.ciencias_4));
            Lista.add(new mVSeminario(R.drawable.ciencias_6));
            Lista.add(new mVSeminario(R.drawable.ciencias_5));
            Lista.add(new mVSeminario(R.drawable.ciencias_7));
            Lista.add(new mVSeminario(R.drawable.ciencias_8));

        } else if (gradoasiste.equalsIgnoreCase("UNI") || gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {
            Lista.add(new mVSeminario(R.drawable.ciencias_1));
            Lista.add(new mVSeminario(R.drawable.ciencias_2));
            Lista.add(new mVSeminario(R.drawable.ciencias_4));
            Lista.add(new mVSeminario(R.drawable.ciencias_6));
            Lista.add(new mVSeminario(R.drawable.ciencias_5));
            Lista.add(new mVSeminario(R.drawable.ciencias_7));
            Lista.add(new mVSeminario(R.drawable.ciencias_8));
            Lista.add(new mVSeminario(R.drawable.letras_1));
            Lista.add(new mVSeminario(R.drawable.letras_2));
            Lista.add(new mVSeminario(R.drawable.letras_3));
            Lista.add(new mVSeminario(R.drawable.letras_4));
            Lista.add(new mVSeminario(R.drawable.letras_6));
            Lista.add(new mVSeminario(R.drawable.letras_5));
            Lista.add(new mVSeminario(R.drawable.letras_7));
            Lista.add(new mVSeminario(R.drawable.letras_8));

        } else if (gradoasiste.equalsIgnoreCase("SAN MARCOS")) {
            Lista.add(new mVSeminario(R.drawable.ciencias_1));
            Lista.add(new mVSeminario(R.drawable.ciencias_2));
            Lista.add(new mVSeminario(R.drawable.ciencias_4));
            Lista.add(new mVSeminario(R.drawable.ciencias_6));
            Lista.add(new mVSeminario(R.drawable.ciencias_5));
            Lista.add(new mVSeminario(R.drawable.ciencias_7));
            Lista.add(new mVSeminario(R.drawable.ciencias_8));
            Lista.add(new mVSeminario(R.drawable.letras_1));
            Lista.add(new mVSeminario(R.drawable.letras_2));
            Lista.add(new mVSeminario(R.drawable.letras_3));
            Lista.add(new mVSeminario(R.drawable.letras_4));
            Lista.add(new mVSeminario(R.drawable.letras_6));
            Lista.add(new mVSeminario(R.drawable.letras_5));
            Lista.add(new mVSeminario(R.drawable.letras_7));
            Lista.add(new mVSeminario(R.drawable.letras_8));
        } else if (gradoasiste.equalsIgnoreCase("CATOLICA")) {
            Lista.add(new mVSeminario(R.drawable.catolicatomo_1));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_2));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_3));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_4));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_5));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_6));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_7));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_8));
            Lista.add(new mVSeminario(R.drawable.catolicatomo_9));
        }


        final adapterVSeminario adapter = new adapterVSeminario(getContext(), Lista);

        gridView.setAdapter(adapter);


        img_temas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String backscreen = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");


                if (gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("CIRCULO") || gradonombre.equalsIgnoreCase("Cuarto Año") && backscreen.equalsIgnoreCase("PRE")) {
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

                } else if (gradoasiste.equalsIgnoreCase("Uni") || gradoasiste.equalsIgnoreCase("SAN MARCOS") || gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {

                    Fragment fragment2 = new mainFragmentUni();
                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                    if (fmanager2 != null) {
                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                        if (ftransaction != null) {
                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                            ftransaction.addToBackStack("");
                            ftransaction.commit();
                        }
                    }
                } else if (gradoasiste.equalsIgnoreCase("CATOLICA")) {

                    Fragment fragment2 = new fragment_TCatolica_Seminario();
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
            }
        });


        img_videoseminario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // visualizarvideo();

            }


        });

        btn_VideoSeminario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                visualizarvideo();

            }
        });


        return rootview;
    }

    private void visualizarvideo() {

        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");
        String tipogradoasiste = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");


        cd = new ConnectionDetector(getContext());

        if (cd.isConnected()) {

            if (sharedata.equalsIgnoreCase("1 Secundaria")) {

                String listChanel = "PLCZAzHVOdMwMIdHOm9Nexb51vVxHEWvdo";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

            if (sharedata.equalsIgnoreCase("2 Secundaria")) {
                String listChanel = "PL4YWiyv2i50HXwIB7Pypj7AKQZKUBmo2n";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }


            if (sharedata.equalsIgnoreCase("3 Secundaria")) {
                String listChanel = "PL8yeC8ZAplx_mOwo1PFQbITjSnEsGWyYW";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }


            if (sharedata.equalsIgnoreCase("4 Secundaria")) {
                String listChanel = "PLiGHAMzKf1DyI6OirJkcwPPMq5OH89PHX";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

//            if (sharedata.equalsIgnoreCase("5 Secundaria")
            if (sharedata.equalsIgnoreCase("5 Secundaria") && gradoasiste.equalsIgnoreCase("Regular") || gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Cuarto Año")) {
                String listChanel = "PLUHaewpMUV7sIwJMJaGcVP06XAEGcIosB";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

            if (sharedata.equalsIgnoreCase("5 Secundaria") && gradoasiste.equalsIgnoreCase("CIRCULO")) {
                String listChanel = "PLUHaewpMUV7sIwJMJaGcVP06XAEGcIosB";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

            if (gradoasiste.equalsIgnoreCase("PRE") && gradonombre.equalsIgnoreCase("Quinto Año")) {
                String listChanel = "PLwPcGQ63hUrCz4PTIKmMQ0CHxl1FkZV_N";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }


            if (sharedata.equalsIgnoreCase("5 Secundaria") && gradoasiste.equalsIgnoreCase("UNI")) {
                String listChanel = "PL7NFWmNkur4zIRIjr0cqsdhWUw8L2lh5J";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }


            if (sharedata.equalsIgnoreCase("5 Secundaria") && gradoasiste.equalsIgnoreCase("SAN MARCOS")) {
                String listChanel = "PL8WyfNYEITfwQlXzuAkqAkh0jim_AuLHa";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }
//
//
            if (gradoasiste.equalsIgnoreCase("CATOLICA") && tomodescripcion.equalsIgnoreCase("BIMESTRE 1")) {
                String listChanel = "PLdCIBUZp0Cu6Rw-U215o_wDLp0BUHSyid";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

            if (gradoasiste.equalsIgnoreCase("CATOLICA") && tomodescripcion.equalsIgnoreCase("BIMESTRE 2")) {
                String listChanel = "PLdCIBUZp0Cu4lT6B5Drh3sPeBFHKEGVzD";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }


            if (gradoasiste.equalsIgnoreCase("CATOLICA") && tomodescripcion.equalsIgnoreCase("BIMESTRE 3")) {
                String listChanel = "";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);
            }

            if (gradoasiste.equalsIgnoreCase("CATOLICA") && tomodescripcion.equalsIgnoreCase("BIMESTRE 4")) {
                String listChanel = "";
                Intent intent = new Intent(getContext(), YouTubeViewer.class);
                intent.putExtra("lista_canal", listChanel);
                getContext().startActivity(intent);

            }

        } else {
            Toast.makeText(getContext(), "No tienes Conexión a Internet", Toast.LENGTH_SHORT).show();
        }

    }


}
