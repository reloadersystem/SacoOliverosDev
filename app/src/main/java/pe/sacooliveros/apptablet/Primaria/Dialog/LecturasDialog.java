package pe.sacooliveros.apptablet.Primaria.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

public class LecturasDialog {


    public Context dataContext;
    public String unidadselect;


    public void customDialog(Context context, String unidad) {
        dataContext = context;
        unidadselect = unidad;

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popup_planlector, null);

        GridView lvView = view2.findViewById(R.id.grid_pruebas);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        TextView txt_titulo = view2.findViewById(R.id.txt_titulo);


        txt_titulo.setText(unidadselect);


        String gradousuario = ShareDataRead.obtenerValor(dataContext, "GradoNombre");


        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        final ArrayList<mPruebas> mListPruebas;

        mListPruebas = new ArrayList<mPruebas>();

//        JSONArray jsonArrayTitulo = new JSONArray();
//        JSONArray jsonArrayURL = new JSONArray();
//        try {
//
//            if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 1")) {
//                jsonArrayTitulo
//                        .put("1. El dueño de la luz")
//                        .put("1. El dueño de la luz")
//                        .put("1. El dueño de la luz")
//                        .put("1. El dueño de la luz");
//                jsonArrayURL
//                        .put("https://www.youtube.com/watch?v=rzebcLAA654")
//                        .put("https://www.youtube.com/watch?v=rzebcLAA654")
//                        .put("https://www.youtube.com/watch?v=rzebcLAA654")
//                        .put("https://www.youtube.com/watch?v=rzebcLAA654");
//
//
//            }
//
//            for (int i = 0; i < jsonArrayTitulo.length(); i++) {
//                mListPruebas.add(new mPruebas(jsonArrayTitulo.getString(i), jsonArrayURL.getString(i)));
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("ERROR -> " + e.getMessage());
//        }

        //Quinto Grado


        if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 1")) {

            mListPruebas.add(new mPruebas("1. La música y la campanada del silencio", "https://www.youtube.com/watch?v=45k2b19EELU"));
            mListPruebas.add(new mPruebas("2. El niño que veía lo invisible", "https://www.youtube.com/watch?v=pi0nThhss-k"));
            mListPruebas.add(new mPruebas("3. El ingeniero imaginante", "https://www.youtube.com/watch?v=NFwSTt1QoOk"));
            mListPruebas.add(new mPruebas("4. Imaginarnos sin miedo", "https://www.youtube.com/watch?v=VZTjwE0jGYQ"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 2")) {
            mListPruebas.add(new mPruebas("1.Lectura nocturna", "https://www.youtube.com/watch?v=opwL6He3K_I"));
            mListPruebas.add(new mPruebas("2.El caballero de la imaginación", "https://www.youtube.com/watch?v=sorS_Ly8k5I"));
            mListPruebas.add(new mPruebas("3.Un juego en la Red del destino", "https://www.youtube.com/watch?v=DERnIEicLlc"));
            mListPruebas.add(new mPruebas("4.Por falta de palabras", "https://www.youtube.com/watch?v=ILcq9eKHiLo"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 3")) {
            mListPruebas.add(new mPruebas("1.Ojos bien abiertos", "https://www.youtube.com/watch?v=opwL6He3K_I"));
            mListPruebas.add(new mPruebas("2.La serpiente cabalista", "https://www.youtube.com/watch?v=sorS_Ly8k5I"));
            mListPruebas.add(new mPruebas("3.Cómo nace un cuento", "https://www.youtube.com/watch?v=DERnIEicLlc"));
            mListPruebas.add(new mPruebas("4.Encuentro con el azar", "https://www.youtube.com/watch?v=ILcq9eKHiLo"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 4")) {
            mListPruebas.add(new mPruebas("1.El psicoanálisis del futuro", "https://www.youtube.com/watch?v=VrmjGnkmkDY"));
            mListPruebas.add(new mPruebas("2.El mago sin imaginación", "https://www.youtube.com/watch?v=VUMv_54xxnw"));
            mListPruebas.add(new mPruebas("3.El hombre ilustrado", "https://www.youtube.com/watch?v=6yG_VSZAIak"));
            mListPruebas.add(new mPruebas("4.El efecto mariposa", "https://www.youtube.com/watch?v=f4a_GymZS1Q"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 5")) {
            mListPruebas.add(new mPruebas("1.Crónica de un drama anunciado", "https://www.youtube.com/watch?v=ncOSHY-bPWQ"));
            mListPruebas.add(new mPruebas("2.La memoria infinita", "https://www.youtube.com/watch?v=ggC2kgK7O1A"));
            mListPruebas.add(new mPruebas("3.Dos mitos de la luna", "https://www.youtube.com/watch?v=p44TBoDEC84"));
            mListPruebas.add(new mPruebas("4.El escarabajo dorado", "https://www.youtube.com/watch?v=bjqOQEC7Q38"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 6")) {
            mListPruebas.add(new mPruebas("1.El horóscopo secular", "https://www.youtube.com/watch?v=QqojxBbFvhI"));
            mListPruebas.add(new mPruebas("2.El pescador de ideas", "https://www.youtube.com/watch?v=SAfgPMiwRps"));
            mListPruebas.add(new mPruebas("3.El vendedor de sueños", "https://www.youtube.com/watch?v=A-TSq2jo0Ug"));
            mListPruebas.add(new mPruebas("4.Excursión a la luna", "https://www.youtube.com/watch?v=fYDMB39sjlw"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 7")) {
            mListPruebas.add(new mPruebas("1.Gotas contra la soledad", "https://www.youtube.com/watch?v=Y8HNlbvX3sc"));
            mListPruebas.add(new mPruebas("2.	De la canción a la realidad", "https://www.youtube.com/watch?v=y0rKz6M8jls"));
            mListPruebas.add(new mPruebas("3.De naranjas y poesía", "https://www.youtube.com/watch?v=i8C3Ro7nh_A"));
            mListPruebas.add(new mPruebas("4.Píldora imaginación", "https://www.youtube.com/watch?v=WHkpN7GeO0o"));

        } else if (gradousuario.equalsIgnoreCase("Sexto grado") & unidadselect.equalsIgnoreCase("UNIDAD 8")) {
            mListPruebas.add(new mPruebas("1.Retrato de una mujer imaginada", "https://www.youtube.com/watch?v=Zbezkj3QNkQ"));
            mListPruebas.add(new mPruebas("2.Una canción cósmica", "https://www.youtube.com/watch?v=g790SAi39m0"));
            mListPruebas.add(new mPruebas("3.El dueño de la luz", "https://www.youtube.com/watch?v=rzebcLAA654"));
            mListPruebas.add(new mPruebas("4.El sueño del jaguar", "https://www.youtube.com/watch?v=zk6n9Q27f0E"));
        }


        if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 1")) {

            mListPruebas.add(new mPruebas("1.El dueño de la luz", "https://www.youtube.com/watch?v=rzebcLAA654"));
            mListPruebas.add(new mPruebas("2.El sueño del jaguar", "https://www.youtube.com/watch?v=zk6n9Q27f0E"));
            mListPruebas.add(new mPruebas("3.El viento sordo de la música", "https://www.youtube.com/watch?v=eCsI-6hcpms"));
            mListPruebas.add(new mPruebas("4.Bucear por las diferencias", "https://www.youtube.com/watch?v=2HCSYX27aqY"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 2")) {
            mListPruebas.add(new mPruebas("1.El contagio de la imaginación", "https://www.youtube.com/watch?v=sFf8_kT-CrI"));
            mListPruebas.add(new mPruebas("2.El vuelo del profesor", "https://www.youtube.com/watch?v=9EmGqT1rubk"));
            mListPruebas.add(new mPruebas("3.El niño que veía lo invisible", "https://www.youtube.com/watch?v=pi0nThhss-k"));
            mListPruebas.add(new mPruebas("4.El ingeniero imaginante:", "https://www.youtube.com/watch?v=NFwSTt1QoOk"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 3")) {
            mListPruebas.add(new mPruebas("1.Imaginarnos sin miedo", "https://www.youtube.com/watch?v=YfePf1XxrSs"));
            mListPruebas.add(new mPruebas("2.Lectura nocturna", "https://www.youtube.com/watch?v=opwL6He3K_I"));
            mListPruebas.add(new mPruebas("3.El caballero de la imaginación", "https://www.youtube.com/watch?v=sorS_Ly8k5I"));
            mListPruebas.add(new mPruebas("4.Una canción cósmica", "https://www.youtube.com/watch?v=g790SAi39m0"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 4")) {
            mListPruebas.add(new mPruebas("1.Retrato de una mujer imaginada", "https://www.youtube.com/watch?v=Zbezkj3QNkQ"));
            mListPruebas.add(new mPruebas("2.Píldora imaginación", "https://www.youtube.com/watch?v=WHkpN7GeO0o"));
            mListPruebas.add(new mPruebas("3.De naranjas y poesías", "https://www.youtube.com/watch?v=i8C3Ro7nh_A"));
            mListPruebas.add(new mPruebas("4.Joan Manuel Serrat. De la canción a la realidad", "https://www.youtube.com/watch?v=y0rKz6M8jls&t=24s"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 5")) {
            mListPruebas.add(new mPruebas("1.Excursión a la luna", "https://www.youtube.com/watch?v=fYDMB39sjlw"));
            mListPruebas.add(new mPruebas("2.El vendedor de sueños", "https://www.youtube.com/watch?v=A-TSq2jo0Ug"));
            mListPruebas.add(new mPruebas("3.El pescador de ideas", "https://www.youtube.com/watch?v=PsEw-KEjF2E"));
            mListPruebas.add(new mPruebas("4.El horóscopo secular", "https://www.youtube.com/watch?v=QqojxBbFvhI"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 6")) {
            mListPruebas.add(new mPruebas("1.El escarabajo dorado", "https://www.youtube.com/watch?v=bjqOQEC7Q38"));
            mListPruebas.add(new mPruebas("2.Dos mitos de la luna", "https://www.youtube.com/watch?v=p44TBoDEC84"));
            mListPruebas.add(new mPruebas("3.La memoria infinita", "https://www.youtube.com/watch?v=ggC2kgK7O1A"));
            mListPruebas.add(new mPruebas("4.Crónica de un drama anunciado", " https://www.youtube.com/watch?v=ncOSHY-bPWQ"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 7")) {
            mListPruebas.add(new mPruebas("1.El efecto mariposa", "https://www.youtube.com/watch?v=f4a_GymZS1Q"));
            mListPruebas.add(new mPruebas("2.El mago sin imaginación", "https://www.youtube.com/watch?v=VUMv_54xxnw"));
            mListPruebas.add(new mPruebas("3.El psicoanálisis del futuro", "https://www.youtube.com/watch?v=VrmjGnkmkDY"));
            mListPruebas.add(new mPruebas("4.Encuentro con el azar", "https://www.youtube.com/watch?v=sAR-zeON5vA"));

        } else if (gradousuario.equalsIgnoreCase("Quinto grado") & unidadselect.equalsIgnoreCase("UNIDAD 8")) {
            mListPruebas.add(new mPruebas("1.Cómo nace un cuento", "https://www.youtube.com/watch?v=eXLM5j5sokM"));
            mListPruebas.add(new mPruebas("2.La serpiente cabalista", "https://www.youtube.com/watch?v=0Etm8SwiceI"));
            mListPruebas.add(new mPruebas("3.Ojos bien abiertos", "https://www.youtube.com/watch?v=T3OQjF5z3FU"));
            mListPruebas.add(new mPruebas("4.Por falta de palabras", "https://www.youtube.com/watch?v=ILcq9eKHiLo"));
        }


        final adapterPruebas adapter2 = new adapterPruebas(context, mListPruebas);
        lvView.setAdapter(adapter2);


        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int countList = adapterView.getCount();


                for (int ax = 0; ax <= countList; ax++) {

                    if (position == ax) {
                        String urldata = mListPruebas.get(ax).getUrldata();

                        Uri uri = Uri.parse(urldata);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);
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
}
