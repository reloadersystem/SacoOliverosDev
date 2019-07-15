package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_TVSeminario;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.AdminSQLiteOpenHelper;
import pe.sacooliveros.apptablet.Secundaria.DataBaseHelper.Utilidades;
import pe.sacooliveros.apptablet.Secundaria.InitialFragment;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoVSeminario;
import pe.sacooliveros.apptablet.Secundaria.ServiceWSeminario.SConsultSeminario;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentTVSeminario extends Fragment {

    View rootview;
    ImageView img_temas;
    ImageView img_backvhs;
    private GridView gridView;
    ArrayList<mTomoVSeminario> Lista;
    RelativeLayout relativeVideoSeminario;
    ConnectionDetector conn;
    String rutaserver;


    public fragmentTVSeminario() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_tvseminario, container, false);

        img_temas = rootview.findViewById(R.id.img_backvhs);
        gridView = rootview.findViewById(R.id.grid_vhseminario);
        relativeVideoSeminario = rootview.findViewById(R.id.relativeVideoSeminario);
        img_backvhs = rootview.findViewById(R.id.img_backvhs);

        conn = new ConnectionDetector(getContext());

        rutaserver = getContext().getString(R.string.servidor_ruta);


        Lista = new ArrayList<mTomoVSeminario>();

        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_1, "Tomo 1"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_2, "Tomo 2"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_3, "Tomo 3"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_4, "Tomo 4"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_5, "Tomo 5"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_6, "Tomo 6"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_7, "Tomo 7"));
        Lista.add(new mTomoVSeminario(R.drawable.secundariatomovm_8, "Tomo 8"));

        final adapter_TVSeminario adapter = new adapter_TVSeminario(getContext(), Lista);

        gridView.setAdapter(adapter);


        img_backvhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String backscreen = ShareDataRead.obtenerValor(getContext(), "TipoGradoAsiste");
//                String gradonombre = ShareDataRead.obtenerValor(getContext(), "GradoNombre");
//
//
//                if (backscreen.equalsIgnoreCase("REGULAR") || gradonombre.equalsIgnoreCase("Cuarto Año") && backscreen.equalsIgnoreCase("PRE") || backscreen.equalsIgnoreCase("CIRCULO")) {
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

                getActivity().getSupportFragmentManager().popBackStack();

            }
        });



        //todo BD VERSIONES && BDSEMINARIO

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Capitulo1_Fragment capitulo1_fragment = new Capitulo1_Fragment();
                Capitulo2_Fragment capitulo2_fragment = new Capitulo2_Fragment();
                Capitulo3_Fragment capitulo3_fragment = new Capitulo3_Fragment();

                String grado = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);
                String pingvalor= Boolean.toString(isOnlineNet());

                switch (position) {


                    case 0:

                    {
                        if (conn.isConnected()) {

                            if (pingvalor.equalsIgnoreCase("True")) {

                                String estadobd = checkEmpty();

                                if (estadobd.equalsIgnoreCase("Contiene Datos")) {

                                    eliminarTomo("Tomo1");

                                    SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO1/VHS2" + grado + "_TOMO1.json");
                                    consult.setCurrentContext(getContext());
                                    consult.setCurrentLayout(relativeVideoSeminario);    // sino cambio  solo  no  hace nada visualiza  la SSD
                                    consult.execute();
//
                                    capitulo1_fragment.tomolistener("Tomo1");
                                    capitulo2_fragment.tomolistener("Tomo1");
                                    capitulo3_fragment.tomolistener("Tomo1");

                                    Fragment fragment2 = new Content_SeminarioFragment();
                                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                    if (fmanager2 != null) {

                                        Bundle args = new Bundle();
                                        args.putString("Tomo", "Tomo 1");
                                        fragment2.setArguments(args);

                                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                        if (ftransaction != null) {
                                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                                            ftransaction.addToBackStack("");
                                            ftransaction.commit();
                                        }
                                    }

                                    break;


                                } else if (estadobd.equalsIgnoreCase("No Contiene Datos")) {

                                    //si esta  vacia
                                    SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO1/VHS2" + grado + "_TOMO1.json");
                                    consult.setCurrentContext(getContext());
                                    consult.setCurrentLayout(relativeVideoSeminario);
                                    consult.execute();


                                    capitulo1_fragment.tomolistener("Tomo1");
                                    capitulo2_fragment.tomolistener("Tomo1");
                                    capitulo3_fragment.tomolistener("Tomo1");

                                    Fragment fragment2 = new Content_SeminarioFragment();
                                    FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                    if (fmanager2 != null) {

                                        Bundle args = new Bundle();
                                        args.putString("Tomo", "Tomo 1");
                                        fragment2.setArguments(args);

                                        FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                        if (ftransaction != null) {
                                            ftransaction.replace(R.id.contenedorFragments, fragment2);
                                            ftransaction.addToBackStack("");
                                            ftransaction.commit();
                                        }
                                    }

                                    break;
                                }
                            } else {
                                Toast.makeText(getContext(), "Verifique su estado de Conexión", Toast.LENGTH_SHORT).show();
                                break;
                            }


                            //Boolean data= checkEmpty(); //BD esta vacia?

                        } else {
                            Toast.makeText(getContext(), "Material solo con Conexión a Internet", Toast.LENGTH_SHORT).show();
                        }
                    }


                    case 1:

                    {
                        if (conn.isConnected()) {

                            String estadobd = checkEmpty();

                            if (estadobd.equalsIgnoreCase("Contiene Datos")) {

                                eliminarTomo("Tomo2");

                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO2/VHS2" + grado + "_TOMO2.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);
                                consult.execute();

                                capitulo1_fragment.tomolistener("Tomo2");
                                capitulo2_fragment.tomolistener("Tomo2");
                                capitulo3_fragment.tomolistener("Tomo2");


                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 2");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }

                                break;
                            } else if (estadobd.equalsIgnoreCase("No Contiene Datos")) {

                                //si esta  vacia
                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO2/VHS2" + grado + "_TOMO2.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);
                                consult.execute();


                                capitulo1_fragment.tomolistener("Tomo2");
                                capitulo2_fragment.tomolistener("Tomo2");
                                capitulo3_fragment.tomolistener("Tomo2");

                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 2");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }
                                break;
                            }
                        } else {
                            Toast.makeText(getContext(), "Material solo con Conexión a Internet", Toast.LENGTH_SHORT).show();
                        }
                    }

                    case 2:

                    {

                        if (conn.isConnected()) {

                            //Boolean data= checkEmpty(); //BD esta vacia?
                            String estadobd = checkEmpty();

                            if (estadobd.equalsIgnoreCase("Contiene Datos")) {


                                //no esta  vacia

                                eliminarTomo("Tomo3");

                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO3/VHS2" + grado + "_TOMO3.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);    // sino cambio  solo  no  hace nada visualiza  la SSD
                                consult.execute();
//
                                capitulo1_fragment.tomolistener("Tomo3");
                                capitulo2_fragment.tomolistener("Tomo3");
                                capitulo3_fragment.tomolistener("Tomo3");

                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 3");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }

                                break;


                            } else if (estadobd.equalsIgnoreCase("No Contiene Datos")) {

                                //si esta  vacia
                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO3/VHS2" + grado + "_TOMO3.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);
                                consult.execute();


                                capitulo1_fragment.tomolistener("Tomo3");
                                capitulo2_fragment.tomolistener("Tomo3");
                                capitulo3_fragment.tomolistener("Tomo3");

                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 3");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }

                                break;
                            }
                        } else {
                            Toast.makeText(getContext(), "Material solo con Conexión a Internet", Toast.LENGTH_SHORT).show();
                        }
                    }

                    break;


                    case 3:


                    {

                        if (conn.isConnected()) {

                            //Boolean data= checkEmpty(); //BD esta vacia?
                            String estadobd = checkEmpty();

                            if (estadobd.equalsIgnoreCase("Contiene Datos")) {


                                //no esta  vacia

                                eliminarTomo("Tomo4");

                                //http://192.169.218.177/APP/2/1/VIDEO_HELICO_SEMINARIO/TOMO4/VHS21_TOMO4.json

                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO4/VHS2" + grado + "_TOMO4.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);    // sino cambio  solo  no  hace nada visualiza  la SSD
                                consult.execute();
//
                                capitulo1_fragment.tomolistener("Tomo4");
                                capitulo2_fragment.tomolistener("Tomo4");
                                capitulo3_fragment.tomolistener("Tomo4");

                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 4");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }

                                break;


                            } else if (estadobd.equalsIgnoreCase("No Contiene Datos")) {

                                //si esta  vacia

                                //http://192.169.218.177/APP/2/1/VIDEO_HELICO_SEMINARIO/TOMO4/VHS21_TOMO4.json

                                SConsultSeminario consult = new SConsultSeminario(rutaserver + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO4/VHS2" + grado + "_TOMO4.json");
                                consult.setCurrentContext(getContext());
                                consult.setCurrentLayout(relativeVideoSeminario);
                                consult.execute();


                                capitulo1_fragment.tomolistener("Tomo4");
                                capitulo2_fragment.tomolistener("Tomo4");
                                capitulo3_fragment.tomolistener("Tomo4");

                                Fragment fragment2 = new Content_SeminarioFragment();
                                FragmentManager fmanager2 = getActivity().getSupportFragmentManager();
                                if (fmanager2 != null) {

                                    Bundle args = new Bundle();
                                    args.putString("Tomo", "Tomo 4");
                                    fragment2.setArguments(args);

                                    FragmentTransaction ftransaction = fmanager2.beginTransaction();
                                    if (ftransaction != null) {
                                        ftransaction.replace(R.id.contenedorFragments, fragment2);
                                        ftransaction.addToBackStack("");
                                        ftransaction.commit();
                                    }
                                }

                                break;
                            }
                        } else {
                            Toast.makeText(getContext(), "Material solo con Conexión a Internet", Toast.LENGTH_SHORT).show();
                        }
                    }


                    break;


                    case 4:
                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

                        break;


                    case 5:

                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

                        break;


                    case 6:

                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

                        break;

                    case 7:

                        Toast.makeText(getContext(), "Material no Disponible", Toast.LENGTH_SHORT).show();

                        break;


                }
            }
        });

        return rootview;
    }


    public String checkEmpty() {


        int count = 0;

        AdminSQLiteOpenHelper mDbHelper = new AdminSQLiteOpenHelper(getContext(), "bdseminarios", null, 1);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT count(*) FROM " + Utilidades.TABLA_VIDEOSEMINARIO, null);


        try {
            if (cursor != null)
                if (cursor.getCount() > 0) {
                    cursor.moveToFirst();
                    count = cursor.getInt(0);

                }
        } finally {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        }

        if (count > 0)

            return "Contiene Datos";
        else
            return "No Contiene Datos";

    }


    private void eliminarTomo(String tomo) {

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getContext(), "bdseminarios", null, 1);

        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        //Delete from videoseminario where asignatura="Algebra"

        String[] params = new String[1];
        params[0] = tomo;

        //String tomoversion = "Tomo2";
        //Cursor cursor = BaseDeDatos.rawQuery("Delete from videoseminario where tomopdf='Tomo2' ",null);
        // Cursor cursor = BaseDeDatos.rawQuery("Delete from videoseminario where tomopdf= "+ datoseminario ,null);

        BaseDeDatos.execSQL("DELETE FROM " + Utilidades.TABLA_VIDEOSEMINARIO + " WHERE " + Utilidades.CAMPO_TOMOPDF + "='" + tomo + "'");

        //Cursor cursor = BaseDeDatos.rawQuery("Delete from videoseminario where tomopdf=? ", params);

        BaseDeDatos.close();

    }


    public Boolean isOnlineNet() {

        try {
            Process p = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.es");

            int val = p.waitFor();
            boolean reachable = (val == 0);
            return reachable;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }


}
