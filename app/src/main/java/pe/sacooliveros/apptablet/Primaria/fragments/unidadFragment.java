package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Adapter.adapterPlan;
import pe.sacooliveros.apptablet.Primaria.Dialog.LecturasDialog;
import pe.sacooliveros.apptablet.Primaria.Model.mPlan;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;
import pe.sacooliveros.apptablet.YouTube.YouTubeViewer;

/**
 * A simple {@link Fragment} subclass.
 */
public class unidadFragment extends Fragment {

    View rootview;

    private GridView gridView;

    ArrayList<mPlan> Lista;

    String tema;

    TextView tx_plan;

    String nivel;

    ConnectionDetector cd;


    public unidadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_unidad, container, false);

        gridView = rootview.findViewById(R.id.ma_plan);

        tx_plan = rootview.findViewById(R.id.tx_plan);

        cd = new ConnectionDetector(getContext());


        Bundle bundle = this.getArguments();
        if (bundle != null) {

            tema = bundle.getString("Temario");

        }

        tx_plan.setText(tema);

        nivel = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");


        Lista = new ArrayList<mPlan>();

        if (tema.equalsIgnoreCase("PLAN LECTOR")) {
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_1, "UNIDAD 1"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_2, "UNIDAD 2"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_3, "UNIDAD 3"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_4, "UNIDAD 4"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_5, "UNIDAD 5"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_6, "UNIDAD 6"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_7, "UNIDAD 7"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad_8, "UNIDAD 8"));

        } else if (tema.equalsIgnoreCase("DIVERTI APRENDO")) {
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad1, "UNIDAD 1"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad2, "UNIDAD 2"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad3, "UNIDAD 3"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad4, "UNIDAD 4"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad5, "UNIDAD 5"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad6, "UNIDAD 6"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad7, "UNIDAD 7"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.unidad8, "UNIDAD 8"));
        } else if (tema.equalsIgnoreCase("VIDEO SEMINARIO")) {
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion1, "UNIDAD 1"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion2, "UNIDAD 2"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion3, "UNIDAD 3"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion4, "UNIDAD 4"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion5, "UNIDAD 5"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion6, "UNIDAD 6"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion7, "UNIDAD 7"));
            Lista.add(new mPlan("VER DETALLE", R.drawable.motivacion8, "UNIDAD 8"));
        }

        final adapterPlan adapter = new adapterPlan(getContext(), Lista);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                int countList = adapterView.getCount();

                if (tema.equalsIgnoreCase("PLAN LECTOR")) {
                    LecturasDialog lecturasDialog = new LecturasDialog();

//                    for (int a = 0; a < countList; a++) {
                    for (int a = 0; a < 5; a++) {

                        if (position == a) {
                            int inicio = a + 1;

                            if (cd.isConnected()) {
                                lecturasDialog.customDialog(getContext(), "UNIDAD " + inicio);
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                } else if (tema.equalsIgnoreCase("DIVERTI APRENDO")) {

                    switch (position) {

                        case 0:

                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCLurI-WW5zlQ1ggT6H2oVxm");

                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {

                                    listCanal("PLcWdL9UMc9NpeQEoeKKEcY5DFm4SNeFmM");

                                }

                                break;

                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;


                        case 1:

                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCJPMcdRHHdxSTzsGywGsSIO");

                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {

                                    listCanal("PLcWdL9UMc9Nr7rnS6I9S29ZY9JJdyreyi");

                                }

                                break;

                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }
                            break;


                        case 2:

                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCK9r2EWmJcLRAhbqmRJy4Ac");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NoiZ_K_z4Etdv3LFxq_DAhh");
                                }

                                break;

                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;


                        case 3:
                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCL7a8laLqIK5C3D3PuWR2PS");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9No6kGWJ8a0XOm2XEKFU2fQD");
                                }

                                break;

                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case 4:
                            if (cd.isConnected()) {
                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCILWsKEZ4OXoxcrhdqtjL6y");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NouJSOuK6Q83IXv7MSW94um");
                                }
                                break;

                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;

                    }

                } else if (tema.equalsIgnoreCase("VIDEO SEMINARIO")) {

                    switch (position) {

                        case 0:

                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCJTNboB02IkghOHQjnH1Tpp");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {

                                    listCanal("PLcWdL9UMc9NpgOm37sZmu4eds7LgI_K44");

                                }

                                break;
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;


                        case 1:

                            if (cd.isConnected()) {

                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCLfv6IgDJ7Pq_I11GljGf4t");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NqZ9IuARSTLlSBJPuo3FXVS");

                                }

                                break;
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;


                        case 2:

                            if (cd.isConnected()) {
                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCLXFUd80aDmtuDLuh5XOWYn");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NqX0Km_Hnmxq8omnJfF6ksl");
                                }

                                break;
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;


                        case 3:

                            if (cd.isConnected()) {
                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCJs2IkQPajpT87leb0EG0LO");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NqzPL3v-LZamZ1FgnOjzHkP");
                                }
                                break;
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;

                        case 4:
                            if (cd.isConnected()) {
                                if (nivel.equalsIgnoreCase("5 Primaria")) {
                                    listCanal("PLLnivJhjddCL-HA0HX__t12E1Eu-Nyzy8");
                                } else if (nivel.equalsIgnoreCase("6 Primaria")) {
                                    listCanal("PLcWdL9UMc9NrrCZMmzMQsgZ37u0VCqK48");
                                }

                                break;
                            } else {
                                Toast.makeText(getContext(), "Estas sin Conexión", Toast.LENGTH_SHORT).show();
                            }

                            break;
                    }
                }//
            }
        });

        return rootview;
    }


    private void listCanal(String listayoutube) {
        Intent intent = new Intent(getContext(), YouTubeViewer.class);
        intent.putExtra("lista_canal", listayoutube);
        getContext().startActivity(intent);
    }
}
