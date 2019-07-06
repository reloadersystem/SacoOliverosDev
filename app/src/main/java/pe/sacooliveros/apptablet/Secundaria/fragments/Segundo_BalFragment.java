package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Adapter.RecyclerBalotariosAdapter;
import pe.sacooliveros.apptablet.Secundaria.Model.mBalotarios;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class Segundo_BalFragment extends Fragment {

    View rootview;
    ArrayList<mBalotarios> listaBalotarioss;
    public RecyclerView recyclerViewCursos;
    static String balotariotipo;
    static String tipoperiodo;
    String numperiodo;
    String sharedata;

    public Segundo_BalFragment() {
        // Required empty public constructor
    }

    public static void instantiate(String tipobalotario, String periodo) {
        balotariotipo = tipobalotario; //1erMensual
        tipoperiodo = periodo;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_segundo_bal, container, false);

        recyclerViewCursos = rootview.findViewById(R.id.recycler_viewsolucionarios);

        sharedata = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel");

        listaBalotarioss = new ArrayList<>();

        String urlcomplement = balotariotipo.substring(0, 3);

        if (urlcomplement.equalsIgnoreCase("1er")) {
            numperiodo = "PRIMERO";

        } else if (urlcomplement.equalsIgnoreCase("2do")) {
            numperiodo = "SEGUNDO";
        } else if (urlcomplement.equalsIgnoreCase("3er")) {
            numperiodo = "TERCERO";
        } else if (urlcomplement.equalsIgnoreCase("4to")) {
            numperiodo = "CUARTO";
        }

        //http://192.169.218.177/APP/2/5/BALOTARIOS/PRIMERO/BALOTARIO_MENSUAL/Psicologia1erMensual.pdf
//
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_1, "FISICA", R.drawable.downloadbal, "Física - " + balotariotipo, "Fisica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_2, "QUIMICA", R.drawable.downloadbal, "Química - " + balotariotipo, "Quimica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_3, "BIOLOGIA", R.drawable.downloadbal, "Biología - " + balotariotipo, "Biologia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_4, "ARITMETICA", R.drawable.downloadbal, "Aritmética - " + balotariotipo, "Aritmetica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_5, "ALGEBRA", R.drawable.downloadbal, "Algebra - " + balotariotipo, "Algebra" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_6, "GEOMETRIA", R.drawable.downloadbal, "Geometría - " + balotariotipo, "Geometria" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_7, "TRIGONOMETRIA", R.drawable.downloadbal, "Trigonometría - " + balotariotipo, "Trigonometria" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.ciencias_8, "RAZONAMIENTO_MATEMATICO", R.drawable.downloadbal, "Razonamiento Matemático - " + balotariotipo, "RM" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_1, "LENGUAJE", R.drawable.downloadbal, "Lenguaje - " + balotariotipo, "Lenguaje" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_2, "LITERATURA", R.drawable.downloadbal, "Literatura - " + balotariotipo, "Literatura" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_3, "RAZONAMIENTO_VERBAL", R.drawable.downloadbal, "Razonamiento Verbal - " + balotariotipo, "RV" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_4, "HISTORIA_DEL_PERU", R.drawable.downloadbal, "Historia del Perú - " + balotariotipo, "HP" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_5, "GEOGRAFIA", R.drawable.downloadbal, "Geografía - " + balotariotipo, "Geografia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        listaBalotarioss.add(new mBalotarios(R.drawable.letras_9, "INGLES", R.drawable.downloadbal, "Inglés - " + balotariotipo, "Ingles" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//
//        if (sharedata.equalsIgnoreCase("3 Secundaria") || sharedata.equalsIgnoreCase("4 Secundaria") || sharedata.equalsIgnoreCase("5 Secundaria")) {
//
//            listaBalotarioss.add(new mBalotarios(R.drawable.letras_7, "ECONOMIA", R.drawable.downloadbal, "Economía - " + balotariotipo, "Economia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//            listaBalotarioss.add(new mBalotarios(R.drawable.letras_6, "HISTORIA_UNIVERSAL", R.drawable.downloadbal, "Historia Universal - " + balotariotipo, "HU" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//            listaBalotarioss.add(new mBalotarios(R.drawable.letras_8, "PSICOLOGIA", R.drawable.downloadbal, "Psicología - " + balotariotipo, "Psicologia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
//        }


        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones1, "Física", R.drawable.downloadpublic, "Física - " + balotariotipo, "Fisica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones2, "Química", R.drawable.downloadpublic, "Química - " + balotariotipo, "Quimica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones3, "Biología", R.drawable.downloadpublic, "Biología - " + balotariotipo, "Biologia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones4, "Aritmética", R.drawable.downloadpublic, "Aritmética - " + balotariotipo, "Aritmetica" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones5, "Álgebra", R.drawable.downloadpublic, "Álgebra - " + balotariotipo, "Algebra" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones6, "Geometría", R.drawable.downloadpublic, "Geometría - " + balotariotipo, "Geometria" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones7, "Trigonometría", R.drawable.downloadpublic, "Trigonometría - " + balotariotipo, "Trigonometria" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones8, "Razonamiento\n Matemático", R.drawable.downloadpublic, "Razonamiento Matemático - " + balotariotipo, "RM" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones9, "Lenguaje", R.drawable.downloadpublic, "Lenguaje - " + balotariotipo, "Lenguaje" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones10, "Literatura", R.drawable.downloadpublic, "Literatura - " + balotariotipo, "Literatura" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones11, "Razonamiento\n Verbal", R.drawable.downloadpublic, "Razonamiento Verbal - " + balotariotipo, "RV" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones12, "Historia del\n Perú", R.drawable.downloadpublic, "Historia del Perú - " + balotariotipo, "HP" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones13, "Geografía", R.drawable.downloadpublic, "Geografía - " + balotariotipo, "Geografia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones14, "Inglés", R.drawable.downloadpublic, "Inglés - " + balotariotipo, "Ingles" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));

        if (sharedata.equalsIgnoreCase("3 Secundaria") || sharedata.equalsIgnoreCase("4 Secundaria") || sharedata.equalsIgnoreCase("5 Secundaria")) {

            listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones15, "Economía", R.drawable.downloadpublic, "Economía - " + balotariotipo, "Economia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
            listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones16, "Historia\n Universal", R.drawable.downloadpublic, "Historia Universal - " + balotariotipo, "HU" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
            listaBalotarioss.add(new mBalotarios(R.drawable.publicaciones17, "Psicología", R.drawable.downloadpublic, "Psicología - " + balotariotipo, "Psicologia" + balotariotipo, numperiodo + "/SOLUCIONARIO_" + tipoperiodo + "/"));
        }

        RecyclerBalotariosAdapter adapter = new RecyclerBalotariosAdapter(rootview.getContext(), listaBalotarioss);

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getContext(), 4));
        } else {
            recyclerViewCursos.setLayoutManager(new GridLayoutManager(getContext(), 5));
        }
        recyclerViewCursos.setHasFixedSize(true);
        recyclerViewCursos.setAdapter(adapter);

        return rootview;
    }
}
