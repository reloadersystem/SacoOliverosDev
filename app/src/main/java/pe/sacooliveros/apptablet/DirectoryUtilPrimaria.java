package pe.sacooliveros.apptablet;

import android.content.Context;
import android.util.Log;

import java.io.File;

public class DirectoryUtilPrimaria {

    String ruta_storage;

    String grado;


    public void verResourceString(Context context) {

        ruta_storage = context.getString(R.string.ruta_raiz);

        Log.d("DATA_STRING", ruta_storage);

    }


    public void verGrado(String gradoencurso) {

        grado= gradoencurso.substring(0, 1);
    }


    public File createCarpetas(String filename) {

        File file = new File(filename);


        if (!file.exists()) {


            file.mkdirs();

            File AccesoTipo1 = new File(ruta_storage + "/APP/", "1");



            AccesoTipo1.mkdir();

            if  (grado.equals("6"))
            {

                File gradoTipo2 = new File(ruta_storage + "/APP/1/", grado);

                gradoTipo2.mkdir();

                File AjedrezTipo6 = new File(ruta_storage + "/APP/1/6/", "AJEDREZ");
                File AsesoriasVirtualesTipo6 = new File(ruta_storage + "/APP/1/6/", "ASESORIAS_VIRTUALES");
                File CalculoMentalTipo6 = new File(ruta_storage + "/APP/1/6/", "CALCULO_MENTAL");
                File ClasesMultimedaTipo6 = new File(ruta_storage + "/APP/1/6/", "CLASES_MULTIMEDIA");
                File DiccionarioTipo6 = new File(ruta_storage + "/APP/1/6/", "DICCIONARIO");
                File exploradorTipo6 = new File(ruta_storage + "/APP/1/6/", "EXPLORADOR_CREATIVO_MISCELANEA");
                File motivacionTipo6 = new File(ruta_storage + "/APP/1/6/", "HELICO_MOTIVACION");
                File libroTipo6 = new File(ruta_storage + "/APP/1/6/", "LIBROS");
                File planlector6 = new File(ruta_storage + "/APP/1/6/", "PLAN_LECTOR");

                AjedrezTipo6.mkdir();
                AsesoriasVirtualesTipo6.mkdir();
                CalculoMentalTipo6.mkdir();
                ClasesMultimedaTipo6.mkdir();
                DiccionarioTipo6.mkdir();
                exploradorTipo6.mkdir();
                motivacionTipo6.mkdir();
                libroTipo6.mkdir();
                planlector6.mkdir();

                S6toGrado_Storage();
            }


            if(grado.equals("5"))
            {

                File gradoTipo1 = new File(ruta_storage + "/APP/1/", "5");

                File AjedrezTipo5 = new File(ruta_storage + "/APP/1/5/", "AJEDREZ");
                File AsesoriasVirtualesTipo5 = new File(ruta_storage + "/APP/1/5/", "ASESORIAS_VIRTUALES");
                File CalculoMentalTipo5 = new File(ruta_storage + "/APP/1/5/", "CALCULO_MENTAL");
                File ClasesMultimedaTipo5 = new File(ruta_storage + "/APP/1/5/", "CLASES_MULTIMEDIA");
                File DiccionarioTipo5 = new File(ruta_storage + "/APP/1/5/", "DICCIONARIO");
                File exploradorTipo5 = new File(ruta_storage + "/APP/1/5/", "EXPLORADOR_CREATIVO_MISCELANEA");
                File motivacionTipo5 = new File(ruta_storage + "/APP/1/5/", "HELICO_MOTIVACION");
                File libroTipo5 = new File(ruta_storage + "/APP/1/5/", "LIBROS");
                File planlector5 = new File(ruta_storage + "/APP/1/5/", "PLAN_LECTOR");

                gradoTipo1.mkdir();



                AjedrezTipo5.mkdir();
                AsesoriasVirtualesTipo5.mkdir();
                CalculoMentalTipo5.mkdir();
                ClasesMultimedaTipo5.mkdir();
                DiccionarioTipo5.mkdir();
                exploradorTipo5.mkdir();
                motivacionTipo5.mkdir();
                libroTipo5.mkdir();
                planlector5.mkdir();
                S5toGrado_Storage();


            }


        }

        return file;

    }

    private void S6toGrado_Storage() {


        File tomolibros1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/", "TOMO1") ;
        File tomolibros2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/", "TOMO2") ;
        File tomolibros3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/", "TOMO3") ;
        File tomolibros4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/", "TOMO4") ;

        File ajedrezT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "AJEDREZ");
        File ciencia_y_ambienteT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "COMUNICACION");
        File matematicaT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "MATEMATICA");
        File personal_socialT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT1_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/", "VALORES_LIDERAZGO");


        File comunicacionT1_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/COMUNICACION/", "GRAMATICA");
        File comunicacionT1_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/COMUNICACION/", "NORMATIVA");
        File comunicacionT1_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT1_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT1_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT1_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "QUIMICA");



        File ajedrezT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "AJEDREZ");
        File ciencia_y_ambienteT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "COMUNICACION");
        File matematicaT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "MATEMATICA");
        File personal_socialT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT2_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/", "VALORES_LIDERAZGO");

        File comunicacionT2_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/COMUNICACION/", "GRAMATICA");
        File comunicacionT2_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/COMUNICACION/", "NORMATIVA");
        File comunicacionT2_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT2_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT2_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT2_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "QUIMICA");


        File ajedrezT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "AJEDREZ");
        File ciencia_y_ambienteT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "COMUNICACION");
        File matematicaT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "MATEMATICA");
        File personal_socialT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT3_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/", "VALORES_LIDERAZGO");


        File comunicacionT3_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/COMUNICACION/", "GRAMATICA");
        File comunicacionT3_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/COMUNICACION/", "NORMATIVA");
        File comunicacionT3_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT3_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT3_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT3_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "QUIMICA");


        File ajedrezT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "AJEDREZ");
        File ciencia_y_ambienteT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "COMUNICACION");
        File matematicaT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "MATEMATICA");
        File personal_socialT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT4_5 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/", "VALORES_LIDERAZGO");


        File comunicacionT4_51 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/COMUNICACION/", "GRAMATICA");
        File comunicacionT4_52 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/COMUNICACION/", "NORMATIVA");
        File comunicacionT4_53 = new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/COMUNICACION/", "LITERATURA");


        File matematicaLT1AR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "ARITMETICA");
        File matematicaLT1AL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "ALGEBRA");
        File matematicaLT1GM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "GEOMETRIA");
        File matematicaLT1ARM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "ARITMETICA");
        File matematicaLT1TR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT1CL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO1/MATEMATICA/", "CALCULO_MENTAL");


        File matematicaLT2AR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "ARITMETICA");
        File matematicaLT2AL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "ALGEBRA");
        File matematicaLT2GM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "GEOMETRIA");
        File matematicaLT2ARM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "ARITMETICA");
        File matematicaLT2TR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT2CL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO2/MATEMATICA/", "CALCULO_MENTAL");


        File matematicaLT3AR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "ARITMETICA");
        File matematicaLT3AL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "ALGEBRA");
        File matematicaLT3GM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "GEOMETRIA");
        File matematicaLT3ARM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "ARITMETICA");
        File matematicaLT3TR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT3CL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO3/MATEMATICA/", "CALCULO_MENTAL");



        File matematicaLT4AR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "ARITMETICA");
        File matematicaLT4AL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "ALGEBRA");
        File matematicaLT4GM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "GEOMETRIA");
        File matematicaLT4ARM_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "ARITMETICA");
        File matematicaLT4TR_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "TRIGONOMETRIA");
        File matematicaLT4CL_5= new File(ruta_storage+"/APP/1/"+grado+"/LIBROS/TOMO4/MATEMATICA", "CALCULO_MENTAL");

        //CLASES_MULTIMEDIA

        File multimediaunidad5_1 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_1");
        File multimediaunidad5_2 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_2");
        File multimediaunidad5_3 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_3");
        File multimediaunidad5_4 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_4");
        File multimediaunidad5_5 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_5");
        File multimediaunidad5_6 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_6");
        File multimediaunidad5_7 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_7");
        File multimediaunidad5_8 = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/", "UNIDAD_8");


        File mUnidad5M1a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "ALGEBRA");
        File mUnidad5M1b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "ARITMETICA");
        File mUnidad5M1c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "BIOLOGIA");
        File mUnidad5M1d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "FISICA");
        File mUnidad5M1e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "GEOMETRIA");
        File mUnidad5M1f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "GRAMATICA");
        File mUnidad5M1g=  new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "INGLES");
        File mUnidad5M1h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "LITERATURA");
        File mUnidad5M1i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "PERSONAL_SOCIAL");
        File mUnidad5M1j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "QUIMICA");
        File mUnidad5M1k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M1l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M1m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_1/", "TRIGONOMETRIA");



        File mUnidad5M2a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "ALGEBRA");
        File mUnidad5M2b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "ARITMETICA");
        File mUnidad5M2c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "BIOLOGIA");
        File mUnidad5M2d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "FISICA");
        File mUnidad5M2e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "GEOMETRIA");
        File mUnidad5M2f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "GRAMATICA");
        File mUnidad5M2g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "INGLES");
        File mUnidad5M2h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "LITERATURA");
        File mUnidad5M2i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "PERSONAL_SOCIAL");
        File mUnidad5M2j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "QUIMICA");
        File mUnidad5M2k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M2l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M2m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_2/", "TRIGONOMETRIA");


        File mUnidad5M3a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "ALGEBRA");
        File mUnidad5M3b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "ARITMETICA");
        File mUnidad5M3c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "BIOLOGIA");
        File mUnidad5M3d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "FISICA");
        File mUnidad5M3e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "GEOMETRIA");
        File mUnidad5M3f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "GRAMATICA");
        File mUnidad5M3g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "INGLES");
        File mUnidad5M3h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "LITERATURA");
        File mUnidad5M3i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "PERSONAL_SOCIAL");
        File mUnidad5M3j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "QUIMICA");
        File mUnidad5M3k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M3l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M3m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_3/", "TRIGONOMETRIA");


        File mUnidad5M4a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "ALGEBRA");
        File mUnidad5M4b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "ARITMETICA");
        File mUnidad5M4c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "BIOLOGIA");
        File mUnidad5M4d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "FISICA");
        File mUnidad5M4e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "GEOMETRIA");
        File mUnidad5M4f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "GRAMATICA");
        File mUnidad5M4g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "INGLES");
        File mUnidad5M4h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "LITERATURA");
        File mUnidad5M4i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "PERSONAL_SOCIAL");
        File mUnidad5M4j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "QUIMICA");
        File mUnidad5M4k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M4l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M4m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_4/", "TRIGONOMETRIA");



        File mUnidad5M5a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "ALGEBRA");
        File mUnidad5M5b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "ARITMETICA");
        File mUnidad5M5c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "BIOLOGIA");
        File mUnidad5M5d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "FISICA");
        File mUnidad5M5e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "GEOMETRIA");
        File mUnidad5M5f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "GRAMATICA");
        File mUnidad5M5g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "INGLES");
        File mUnidad5M5h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "LITERATURA");
        File mUnidad5M5i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "PERSONAL_SOCIAL");
        File mUnidad5M5j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "QUIMICA");
        File mUnidad5M5k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M5l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M5m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_5/", "TRIGONOMETRIA");


        File mUnidad5M6a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "ALGEBRA");
        File mUnidad5M6b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "ARITMETICA");
        File mUnidad5M6c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "BIOLOGIA");
        File mUnidad5M6d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "FISICA");
        File mUnidad5M6e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "GEOMETRIA");
        File mUnidad5M6f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "GRAMATICA");
        File mUnidad5M6g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "INGLES");
        File mUnidad5M6h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "LITERATURA");
        File mUnidad5M6i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "PERSONAL_SOCIAL");
        File mUnidad5M6j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "QUIMICA");
        File mUnidad5M6k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M6l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M6m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_6/", "TRIGONOMETRIA");



        File mUnidad5M7a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "ALGEBRA");
        File mUnidad5M7b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "ARITMETICA");
        File mUnidad5M7c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "BIOLOGIA");
        File mUnidad5M7d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "FISICA");
        File mUnidad5M7e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "GEOMETRIA");
        File mUnidad5M7f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "GRAMATICA");
        File mUnidad5M7g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "INGLES");
        File mUnidad5M7h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "LITERATURA");
        File mUnidad5M7i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "PERSONAL_SOCIAL");
        File mUnidad5M7j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "QUIMICA");
        File mUnidad5M7k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M7l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M7m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_7/", "TRIGONOMETRIA");


        File mUnidad5M8a = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "ALGEBRA");
        File mUnidad5M8b = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "ARITMETICA");
        File mUnidad5M8c = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "BIOLOGIA");
        File mUnidad5M8d = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "FISICA");
        File mUnidad5M8e = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "GEOMETRIA");
        File mUnidad5M8f = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "GRAMATICA");
        File mUnidad5M8g= new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "INGLES");
        File mUnidad5M8h = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "LITERATURA");
        File mUnidad5M8i = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "PERSONAL_SOCIAL");
        File mUnidad5M8j = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "QUIMICA");
        File mUnidad5M8k = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M8l = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M8m = new File(ruta_storage+"/APP/1/"+grado+"/CLASES_MULTIMEDIA/UNIDAD_8/", "TRIGONOMETRIA");


        File asesorias5_1= new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_1");
        File asesorias5_2 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_2");
        File asesorias5_3 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_3");
        File asesorias5_4 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_4");
        File asesorias5_5 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_5");
        File asesorias5_6 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_6");
        File asesorias5_7 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_7");
        File asesorias5_8 = new File(ruta_storage+"/APP/1/"+grado+"/ASESORIAS_VIRTUALES/", "UNIDAD_8");


        File helicomotivacion5_1 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_1");
        File helicomotivacion5_2 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_2");
        File helicomotivacion5_3 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_3");
        File helicomotivacion5_4 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_4");
        File helicomotivacion5_5 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_5");
        File helicomotivacion5_6 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_6");
        File helicomotivacion5_7 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_7");
        File helicomotivacion5_8 = new File(ruta_storage+"/APP/1/"+grado+"/HELICO_MOTIVACION/", "UNIDAD_8");

        File planlector5_1 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_1");
        File planlector5_2 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_2");
        File planlector5_3 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_3");
        File planlector5_4 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_4");
        File planlector5_5 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_5");
        File planlector5_6 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_6");
        File planlector5_7 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_7");
        File planlector5_8 = new File(ruta_storage+"/APP/1/"+grado+"/PLAN_LECTOR/", "UNIDAD_8");



        tomolibros1_5.mkdir();
        tomolibros2_5.mkdir();
        tomolibros3_5.mkdir();
        tomolibros4_5.mkdir();

        ajedrezT1_5.mkdir();
        ciencia_y_ambienteT1_5.mkdir();
        comunicacionT1_5.mkdir();
        matematicaT1_5.mkdir();
        personal_socialT1_5.mkdir();
        razonamiento_matematicoT1_5.mkdir();
        razonamiento_matematicoT1_5.mkdir();
        razonamiento_verbalT1_5.mkdir();
        valores_liderazgoT1_5.mkdir();

        comunicacionT1_51.mkdir();
        comunicacionT1_52.mkdir();
        comunicacionT1_53.mkdir();

        ciencia_y_ambienteT1_51.mkdir();
        ciencia_y_ambienteT1_52.mkdir();
        ciencia_y_ambienteT1_53.mkdir();



        ajedrezT2_5.mkdir();
        ciencia_y_ambienteT2_5.mkdir();
        comunicacionT2_5.mkdir();
        matematicaT2_5.mkdir();
        personal_socialT2_5.mkdir();
        razonamiento_matematicoT2_5.mkdir();
        razonamiento_matematicoT2_5.mkdir();
        razonamiento_verbalT2_5.mkdir();
        valores_liderazgoT2_5.mkdir();

        comunicacionT2_51.mkdir();
        comunicacionT2_52.mkdir();
        comunicacionT2_53.mkdir();

        ciencia_y_ambienteT2_51.mkdir();
        ciencia_y_ambienteT2_52.mkdir();
        ciencia_y_ambienteT2_53.mkdir();


        ajedrezT3_5.mkdir();
        ciencia_y_ambienteT3_5.mkdir();
        comunicacionT3_5.mkdir();
        matematicaT3_5.mkdir();
        personal_socialT3_5.mkdir();
        razonamiento_matematicoT3_5.mkdir();
        razonamiento_matematicoT3_5.mkdir();
        razonamiento_verbalT3_5.mkdir();
        valores_liderazgoT3_5.mkdir();


        comunicacionT3_51.mkdir();
        comunicacionT3_52.mkdir();
        comunicacionT3_53.mkdir();

        ciencia_y_ambienteT3_51.mkdir();
        ciencia_y_ambienteT3_52.mkdir();
        ciencia_y_ambienteT3_53.mkdir();




        ajedrezT4_5.mkdir();
        ciencia_y_ambienteT4_5.mkdir();
        comunicacionT4_5.mkdir();
        matematicaT4_5.mkdir();
        personal_socialT4_5.mkdir();
        razonamiento_matematicoT4_5.mkdir();
        razonamiento_matematicoT4_5.mkdir();
        razonamiento_verbalT4_5.mkdir();
        valores_liderazgoT4_5.mkdir();


        comunicacionT4_51.mkdir();
        comunicacionT4_52.mkdir();
        comunicacionT4_53.mkdir();


        matematicaLT1AR_5.mkdir();
        matematicaLT1AL_5.mkdir();
        matematicaLT1GM_5.mkdir();
        matematicaLT1ARM_5.mkdir();
        matematicaLT1TR_5.mkdir();
        matematicaLT1CL_5.mkdir();

        matematicaLT2AR_5.mkdir();
        matematicaLT2AL_5.mkdir();
        matematicaLT2GM_5.mkdir();
        matematicaLT2ARM_5.mkdir();
        matematicaLT2TR_5.mkdir();
        matematicaLT2CL_5.mkdir();


        matematicaLT3AR_5.mkdir();
        matematicaLT3AL_5.mkdir();
        matematicaLT3GM_5.mkdir();
        matematicaLT3ARM_5.mkdir();
        matematicaLT3TR_5.mkdir();
        matematicaLT3CL_5.mkdir();


        matematicaLT4AR_5.mkdir();
        matematicaLT4AL_5.mkdir();
        matematicaLT4GM_5.mkdir();
        matematicaLT4ARM_5.mkdir();
        matematicaLT4TR_5.mkdir();
        matematicaLT4CL_5.mkdir();





        multimediaunidad5_1.mkdir();
        multimediaunidad5_2.mkdir();
        multimediaunidad5_3.mkdir();
        multimediaunidad5_4.mkdir();
        multimediaunidad5_5.mkdir();
        multimediaunidad5_6.mkdir();
        multimediaunidad5_7.mkdir();
        multimediaunidad5_8.mkdir();


        mUnidad5M1a.mkdir();
        mUnidad5M1b.mkdir();
        mUnidad5M1c.mkdir();
        mUnidad5M1d.mkdir();
        mUnidad5M1e.mkdir();
        mUnidad5M1f.mkdir();
        mUnidad5M1g.mkdir();
        mUnidad5M1h.mkdir();
        mUnidad5M1i.mkdir();
        mUnidad5M1j.mkdir();
        mUnidad5M1k.mkdir();
        mUnidad5M1l.mkdir();
        mUnidad5M1m.mkdir();


        mUnidad5M2a.mkdir();
        mUnidad5M2b.mkdir();
        mUnidad5M2c.mkdir();
        mUnidad5M2d.mkdir();
        mUnidad5M2e.mkdir();
        mUnidad5M2f.mkdir();
        mUnidad5M2g.mkdir();
        mUnidad5M2h.mkdir();
        mUnidad5M2i.mkdir();
        mUnidad5M2j.mkdir();
        mUnidad5M2k.mkdir();
        mUnidad5M2l.mkdir();
        mUnidad5M2m.mkdir();


        mUnidad5M3a.mkdir();
        mUnidad5M3b.mkdir();
        mUnidad5M3c.mkdir();
        mUnidad5M3d.mkdir();
        mUnidad5M3e.mkdir();
        mUnidad5M3f.mkdir();
        mUnidad5M3g.mkdir();
        mUnidad5M3h.mkdir();
        mUnidad5M3i.mkdir();
        mUnidad5M3j.mkdir();
        mUnidad5M3k.mkdir();
        mUnidad5M3l.mkdir();
        mUnidad5M3m.mkdir();

        mUnidad5M4a.mkdir();
        mUnidad5M4b.mkdir();
        mUnidad5M4c.mkdir();
        mUnidad5M4d.mkdir();
        mUnidad5M4e.mkdir();
        mUnidad5M4f.mkdir();
        mUnidad5M4g.mkdir();
        mUnidad5M4h.mkdir();
        mUnidad5M4i.mkdir();
        mUnidad5M4j.mkdir();
        mUnidad5M4k.mkdir();
        mUnidad5M4l.mkdir();
        mUnidad5M4m.mkdir();


        mUnidad5M5a.mkdir();
        mUnidad5M5b.mkdir();
        mUnidad5M5c.mkdir();
        mUnidad5M5d.mkdir();
        mUnidad5M5e.mkdir();
        mUnidad5M5f.mkdir();
        mUnidad5M5g.mkdir();
        mUnidad5M5h.mkdir();
        mUnidad5M5i.mkdir();
        mUnidad5M5j.mkdir();
        mUnidad5M5k.mkdir();
        mUnidad5M5l.mkdir();
        mUnidad5M5m.mkdir();

        mUnidad5M6a.mkdir();
        mUnidad5M6b.mkdir();
        mUnidad5M6c.mkdir();
        mUnidad5M6d.mkdir();
        mUnidad5M6e.mkdir();
        mUnidad5M6f.mkdir();
        mUnidad5M6g.mkdir();
        mUnidad5M6h.mkdir();
        mUnidad5M6i.mkdir();
        mUnidad5M6j.mkdir();
        mUnidad5M6k.mkdir();
        mUnidad5M6l.mkdir();
        mUnidad5M6m.mkdir();


        mUnidad5M7a.mkdir();
        mUnidad5M7b.mkdir();
        mUnidad5M7c.mkdir();
        mUnidad5M7d.mkdir();
        mUnidad5M7e.mkdir();
        mUnidad5M7f.mkdir();
        mUnidad5M7g.mkdir();
        mUnidad5M7h.mkdir();
        mUnidad5M7i.mkdir();
        mUnidad5M7j.mkdir();
        mUnidad5M7k.mkdir();
        mUnidad5M7l.mkdir();
        mUnidad5M7m.mkdir();

        mUnidad5M8a.mkdir();
        mUnidad5M8b.mkdir();
        mUnidad5M8c.mkdir();
        mUnidad5M8d.mkdir();
        mUnidad5M8e.mkdir();
        mUnidad5M8f.mkdir();
        mUnidad5M8g.mkdir();
        mUnidad5M8h.mkdir();
        mUnidad5M8i.mkdir();
        mUnidad5M8j.mkdir();
        mUnidad5M8k.mkdir();
        mUnidad5M8l.mkdir();
        mUnidad5M8m.mkdir();

        asesorias5_1.mkdir();
        asesorias5_2.mkdir();
        asesorias5_3.mkdir();
        asesorias5_4.mkdir();
        asesorias5_5.mkdir();
        asesorias5_6.mkdir();
        asesorias5_7.mkdir();
        asesorias5_8.mkdir();

        helicomotivacion5_1.mkdir();
        helicomotivacion5_2.mkdir();
        helicomotivacion5_3.mkdir();
        helicomotivacion5_4.mkdir();
        helicomotivacion5_5.mkdir();
        helicomotivacion5_6.mkdir();
        helicomotivacion5_7.mkdir();
        helicomotivacion5_8.mkdir();

        planlector5_1.mkdir();
        planlector5_2.mkdir();
        planlector5_3.mkdir();
        planlector5_4.mkdir();
        planlector5_5.mkdir();
        planlector5_6.mkdir();
        planlector5_7.mkdir();
        planlector5_8.mkdir();






    }

    private void S5toGrado_Storage() {



        File tomolibros1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/", "TOMO1") ;
        File tomolibros2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/", "TOMO2") ;
        File tomolibros3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/", "TOMO3") ;
        File tomolibros4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/", "TOMO4") ;

        File ajedrezT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "AJEDREZ");
        File ciencia_y_ambienteT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "COMUNICACION");
        File matematicaT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "MATEMATICA");
        File personal_socialT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT1_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/", "VALORES_LIDERAZGO");


        File comunicacionT1_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/COMUNICACION/", "GRAMATICA");
        File comunicacionT1_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/COMUNICACION/", "NORMATIVA");
        File comunicacionT1_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT1_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT1_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT1_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/CIENCIA_Y_AMBIENTE/", "QUIMICA");



        File ajedrezT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "AJEDREZ");
        File ciencia_y_ambienteT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "COMUNICACION");
        File matematicaT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "MATEMATICA");
        File personal_socialT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT2_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/", "VALORES_LIDERAZGO");

        File comunicacionT2_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/COMUNICACION/", "GRAMATICA");
        File comunicacionT2_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/COMUNICACION/", "NORMATIVA");
        File comunicacionT2_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT2_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT2_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT2_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/CIENCIA_Y_AMBIENTE/", "QUIMICA");








        File ajedrezT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "AJEDREZ");
        File ciencia_y_ambienteT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "COMUNICACION");
        File matematicaT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "MATEMATICA");
        File personal_socialT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT3_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/", "VALORES_LIDERAZGO");


        File comunicacionT3_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/COMUNICACION/", "GRAMATICA");
        File comunicacionT3_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/COMUNICACION/", "NORMATIVA");
        File comunicacionT3_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/COMUNICACION/", "LITERATURA");

        File ciencia_y_ambienteT3_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "BIOLOGIA");
        File ciencia_y_ambienteT3_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "FISICA");
        File ciencia_y_ambienteT3_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/CIENCIA_Y_AMBIENTE/", "QUIMICA");





        File ajedrezT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "AJEDREZ");
        File ciencia_y_ambienteT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "CIENCIA_Y_AMBIENTE");
        File comunicacionT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "COMUNICACION");
        File matematicaT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "MATEMATICA");
        File personal_socialT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "PERSONAL_SOCIAL");
        File razonamiento_matematicoT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File razonamiento_verbalT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File valores_liderazgoT4_5 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/", "VALORES_LIDERAZGO");


        File comunicacionT4_51 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/COMUNICACION/", "GRAMATICA");
        File comunicacionT4_52 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/COMUNICACION/", "NORMATIVA");
        File comunicacionT4_53 = new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/COMUNICACION/", "LITERATURA");


        File matematicaLT1AR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "ARITMETICA");
        File matematicaLT1AL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "ALGEBRA");
        File matematicaLT1GM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "GEOMETRIA");
        File matematicaLT1ARM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "ARITMETICA");
        File matematicaLT1TR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT1CL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO1/MATEMATICA/", "CALCULO_MENTAL");


        File matematicaLT2AR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "ARITMETICA");
        File matematicaLT2AL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "ALGEBRA");
        File matematicaLT2GM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "GEOMETRIA");
        File matematicaLT2ARM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "ARITMETICA");
        File matematicaLT2TR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT2CL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO2/MATEMATICA/", "CALCULO_MENTAL");


        File matematicaLT3AR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "ARITMETICA");
        File matematicaLT3AL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "ALGEBRA");
        File matematicaLT3GM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "GEOMETRIA");
        File matematicaLT3ARM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "ARITMETICA");
        File matematicaLT3TR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "TRIGONOMETRIA");
        File matematicaLT3CL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO3/MATEMATICA/", "CALCULO_MENTAL");



        File matematicaLT4AR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "ARITMETICA");
        File matematicaLT4AL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "ALGEBRA");
        File matematicaLT4GM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "GEOMETRIA");
        File matematicaLT4ARM_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "ARITMETICA");
        File matematicaLT4TR_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "TRIGONOMETRIA");
        File matematicaLT4CL_5= new File(ruta_storage+"/APP/1/5/LIBROS/TOMO4/MATEMATICA", "CALCULO_MENTAL");

        //CLASES_MULTIMEDIA

        File multimediaunidad5_1 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_1");
        File multimediaunidad5_2 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_2");
        File multimediaunidad5_3 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_3");
        File multimediaunidad5_4 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_4");
        File multimediaunidad5_5 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_5");
        File multimediaunidad5_6 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_6");
        File multimediaunidad5_7 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_7");
        File multimediaunidad5_8 = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/", "UNIDAD_8");


        File mUnidad5M1a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "ALGEBRA");
        File mUnidad5M1b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "ARITMETICA");
        File mUnidad5M1c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "BIOLOGIA");
        File mUnidad5M1d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "FISICA");
        File mUnidad5M1e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "GEOMETRIA");
        File mUnidad5M1f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "GRAMATICA");
        File mUnidad5M1g=  new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "INGLES");
        File mUnidad5M1h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "LITERATURA");
        File mUnidad5M1i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "PERSONAL_SOCIAL");
        File mUnidad5M1j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "QUIMICA");
        File mUnidad5M1k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M1l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M1m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_1/", "TRIGONOMETRIA");



        File mUnidad5M2a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "ALGEBRA");
        File mUnidad5M2b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "ARITMETICA");
        File mUnidad5M2c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "BIOLOGIA");
        File mUnidad5M2d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "FISICA");
        File mUnidad5M2e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "GEOMETRIA");
        File mUnidad5M2f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "GRAMATICA");
        File mUnidad5M2g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "INGLES");
        File mUnidad5M2h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "LITERATURA");
        File mUnidad5M2i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "PERSONAL_SOCIAL");
        File mUnidad5M2j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "QUIMICA");
        File mUnidad5M2k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M2l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M2m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_2/", "TRIGONOMETRIA");


        File mUnidad5M3a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "ALGEBRA");
        File mUnidad5M3b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "ARITMETICA");
        File mUnidad5M3c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "BIOLOGIA");
        File mUnidad5M3d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "FISICA");
        File mUnidad5M3e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "GEOMETRIA");
        File mUnidad5M3f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "GRAMATICA");
        File mUnidad5M3g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "INGLES");
        File mUnidad5M3h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "LITERATURA");
        File mUnidad5M3i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "PERSONAL_SOCIAL");
        File mUnidad5M3j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "QUIMICA");
        File mUnidad5M3k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M3l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M3m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_3/", "TRIGONOMETRIA");


        File mUnidad5M4a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "ALGEBRA");
        File mUnidad5M4b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "ARITMETICA");
        File mUnidad5M4c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "BIOLOGIA");
        File mUnidad5M4d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "FISICA");
        File mUnidad5M4e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "GEOMETRIA");
        File mUnidad5M4f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "GRAMATICA");
        File mUnidad5M4g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "INGLES");
        File mUnidad5M4h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "LITERATURA");
        File mUnidad5M4i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "PERSONAL_SOCIAL");
        File mUnidad5M4j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "QUIMICA");
        File mUnidad5M4k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M4l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M4m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_4/", "TRIGONOMETRIA");



        File mUnidad5M5a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "ALGEBRA");
        File mUnidad5M5b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "ARITMETICA");
        File mUnidad5M5c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "BIOLOGIA");
        File mUnidad5M5d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "FISICA");
        File mUnidad5M5e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "GEOMETRIA");
        File mUnidad5M5f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "GRAMATICA");
        File mUnidad5M5g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "INGLES");
        File mUnidad5M5h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "LITERATURA");
        File mUnidad5M5i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "PERSONAL_SOCIAL");
        File mUnidad5M5j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "QUIMICA");
        File mUnidad5M5k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M5l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M5m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_5/", "TRIGONOMETRIA");


        File mUnidad5M6a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "ALGEBRA");
        File mUnidad5M6b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "ARITMETICA");
        File mUnidad5M6c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "BIOLOGIA");
        File mUnidad5M6d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "FISICA");
        File mUnidad5M6e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "GEOMETRIA");
        File mUnidad5M6f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "GRAMATICA");
        File mUnidad5M6g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "INGLES");
        File mUnidad5M6h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "LITERATURA");
        File mUnidad5M6i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "PERSONAL_SOCIAL");
        File mUnidad5M6j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "QUIMICA");
        File mUnidad5M6k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M6l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M6m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_6/", "TRIGONOMETRIA");



        File mUnidad5M7a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "ALGEBRA");
        File mUnidad5M7b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "ARITMETICA");
        File mUnidad5M7c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "BIOLOGIA");
        File mUnidad5M7d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "FISICA");
        File mUnidad5M7e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "GEOMETRIA");
        File mUnidad5M7f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "GRAMATICA");
        File mUnidad5M7g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "INGLES");
        File mUnidad5M7h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "LITERATURA");
        File mUnidad5M7i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "PERSONAL_SOCIAL");
        File mUnidad5M7j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "QUIMICA");
        File mUnidad5M7k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M7l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M7m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_7/", "TRIGONOMETRIA");


        File mUnidad5M8a = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "ALGEBRA");
        File mUnidad5M8b = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "ARITMETICA");
        File mUnidad5M8c = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "BIOLOGIA");
        File mUnidad5M8d = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "FISICA");
        File mUnidad5M8e = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "GEOMETRIA");
        File mUnidad5M8f = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "GRAMATICA");
        File mUnidad5M8g= new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "INGLES");
        File mUnidad5M8h = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "LITERATURA");
        File mUnidad5M8i = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "PERSONAL_SOCIAL");
        File mUnidad5M8j = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "QUIMICA");
        File mUnidad5M8k = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "RAZONAMIENTO_MATEMATICO");
        File mUnidad5M8l = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "RAZONAMIENTO_VERBAL");
        File mUnidad5M8m = new File(ruta_storage+"/APP/1/5/CLASES_MULTIMEDIA/UNIDAD_8/", "TRIGONOMETRIA");


        File asesorias5_1= new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_1");
        File asesorias5_2 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_2");
        File asesorias5_3 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_3");
        File asesorias5_4 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_4");
        File asesorias5_5 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_5");
        File asesorias5_6 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_6");
        File asesorias5_7 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_7");
        File asesorias5_8 = new File(ruta_storage+"/APP/1/5/ASESORIAS_VIRTUALES/", "UNIDAD_8");


        File helicomotivacion5_1 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_1");
        File helicomotivacion5_2 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_2");
        File helicomotivacion5_3 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_3");
        File helicomotivacion5_4 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_4");
        File helicomotivacion5_5 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_5");
        File helicomotivacion5_6 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_6");
        File helicomotivacion5_7 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_7");
        File helicomotivacion5_8 = new File(ruta_storage+"/APP/1/5/HELICO_MOTIVACION/", "UNIDAD_8");

        File planlector5_1 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_1");
        File planlector5_2 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_2");
        File planlector5_3 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_3");
        File planlector5_4 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_4");
        File planlector5_5 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_5");
        File planlector5_6 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_6");
        File planlector5_7 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_7");
        File planlector5_8 = new File(ruta_storage+"/APP/1/5/PLAN_LECTOR/", "UNIDAD_8");








        tomolibros1_5.mkdir();
        tomolibros2_5.mkdir();
        tomolibros3_5.mkdir();
        tomolibros4_5.mkdir();

        ajedrezT1_5.mkdir();
        ciencia_y_ambienteT1_5.mkdir();
        comunicacionT1_5.mkdir();
        matematicaT1_5.mkdir();
        personal_socialT1_5.mkdir();
        razonamiento_matematicoT1_5.mkdir();
        razonamiento_matematicoT1_5.mkdir();
        razonamiento_verbalT1_5.mkdir();
        valores_liderazgoT1_5.mkdir();

        comunicacionT1_51.mkdir();
        comunicacionT1_52.mkdir();
        comunicacionT1_53.mkdir();

        ciencia_y_ambienteT1_51.mkdir();
        ciencia_y_ambienteT1_52.mkdir();
        ciencia_y_ambienteT1_53.mkdir();



        ajedrezT2_5.mkdir();
        ciencia_y_ambienteT2_5.mkdir();
        comunicacionT2_5.mkdir();
        matematicaT2_5.mkdir();
        personal_socialT2_5.mkdir();
        razonamiento_matematicoT2_5.mkdir();
        razonamiento_matematicoT2_5.mkdir();
        razonamiento_verbalT2_5.mkdir();
        valores_liderazgoT2_5.mkdir();

        comunicacionT2_51.mkdir();
        comunicacionT2_52.mkdir();
        comunicacionT2_53.mkdir();

        ciencia_y_ambienteT2_51.mkdir();
        ciencia_y_ambienteT2_52.mkdir();
        ciencia_y_ambienteT2_53.mkdir();


        ajedrezT3_5.mkdir();
        ciencia_y_ambienteT3_5.mkdir();
        comunicacionT3_5.mkdir();
        matematicaT3_5.mkdir();
        personal_socialT3_5.mkdir();
        razonamiento_matematicoT3_5.mkdir();
        razonamiento_matematicoT3_5.mkdir();
        razonamiento_verbalT3_5.mkdir();
        valores_liderazgoT3_5.mkdir();


        comunicacionT3_51.mkdir();
        comunicacionT3_52.mkdir();
        comunicacionT3_53.mkdir();

        ciencia_y_ambienteT3_51.mkdir();
        ciencia_y_ambienteT3_52.mkdir();
        ciencia_y_ambienteT3_53.mkdir();




        ajedrezT4_5.mkdir();
        ciencia_y_ambienteT4_5.mkdir();
        comunicacionT4_5.mkdir();
        matematicaT4_5.mkdir();
        personal_socialT4_5.mkdir();
        razonamiento_matematicoT4_5.mkdir();
        razonamiento_matematicoT4_5.mkdir();
        razonamiento_verbalT4_5.mkdir();
        valores_liderazgoT4_5.mkdir();


        comunicacionT4_51.mkdir();
        comunicacionT4_52.mkdir();
        comunicacionT4_53.mkdir();


        matematicaLT1AR_5.mkdir();
        matematicaLT1AL_5.mkdir();
        matematicaLT1GM_5.mkdir();
        matematicaLT1ARM_5.mkdir();
        matematicaLT1TR_5.mkdir();
        matematicaLT1CL_5.mkdir();

        matematicaLT2AR_5.mkdir();
        matematicaLT2AL_5.mkdir();
        matematicaLT2GM_5.mkdir();
        matematicaLT2ARM_5.mkdir();
        matematicaLT2TR_5.mkdir();
        matematicaLT2CL_5.mkdir();


        matematicaLT3AR_5.mkdir();
        matematicaLT3AL_5.mkdir();
        matematicaLT3GM_5.mkdir();
        matematicaLT3ARM_5.mkdir();
        matematicaLT3TR_5.mkdir();
        matematicaLT3CL_5.mkdir();


        matematicaLT4AR_5.mkdir();
        matematicaLT4AL_5.mkdir();
        matematicaLT4GM_5.mkdir();
        matematicaLT4ARM_5.mkdir();
        matematicaLT4TR_5.mkdir();
        matematicaLT4CL_5.mkdir();





        multimediaunidad5_1.mkdir();
        multimediaunidad5_2.mkdir();
        multimediaunidad5_3.mkdir();
        multimediaunidad5_4.mkdir();
        multimediaunidad5_5.mkdir();
        multimediaunidad5_6.mkdir();
        multimediaunidad5_7.mkdir();
        multimediaunidad5_8.mkdir();


        mUnidad5M1a.mkdir();
        mUnidad5M1b.mkdir();
        mUnidad5M1c.mkdir();
        mUnidad5M1d.mkdir();
        mUnidad5M1e.mkdir();
        mUnidad5M1f.mkdir();
        mUnidad5M1g.mkdir();
        mUnidad5M1h.mkdir();
        mUnidad5M1i.mkdir();
        mUnidad5M1j.mkdir();
        mUnidad5M1k.mkdir();
        mUnidad5M1l.mkdir();
        mUnidad5M1m.mkdir();


        mUnidad5M2a.mkdir();
        mUnidad5M2b.mkdir();
        mUnidad5M2c.mkdir();
        mUnidad5M2d.mkdir();
        mUnidad5M2e.mkdir();
        mUnidad5M2f.mkdir();
        mUnidad5M2g.mkdir();
        mUnidad5M2h.mkdir();
        mUnidad5M2i.mkdir();
        mUnidad5M2j.mkdir();
        mUnidad5M2k.mkdir();
        mUnidad5M2l.mkdir();
        mUnidad5M2m.mkdir();


        mUnidad5M3a.mkdir();
        mUnidad5M3b.mkdir();
        mUnidad5M3c.mkdir();
        mUnidad5M3d.mkdir();
        mUnidad5M3e.mkdir();
        mUnidad5M3f.mkdir();
        mUnidad5M3g.mkdir();
        mUnidad5M3h.mkdir();
        mUnidad5M3i.mkdir();
        mUnidad5M3j.mkdir();
        mUnidad5M3k.mkdir();
        mUnidad5M3l.mkdir();
        mUnidad5M3m.mkdir();

        mUnidad5M4a.mkdir();
        mUnidad5M4b.mkdir();
        mUnidad5M4c.mkdir();
        mUnidad5M4d.mkdir();
        mUnidad5M4e.mkdir();
        mUnidad5M4f.mkdir();
        mUnidad5M4g.mkdir();
        mUnidad5M4h.mkdir();
        mUnidad5M4i.mkdir();
        mUnidad5M4j.mkdir();
        mUnidad5M4k.mkdir();
        mUnidad5M4l.mkdir();
        mUnidad5M4m.mkdir();


        mUnidad5M5a.mkdir();
        mUnidad5M5b.mkdir();
        mUnidad5M5c.mkdir();
        mUnidad5M5d.mkdir();
        mUnidad5M5e.mkdir();
        mUnidad5M5f.mkdir();
        mUnidad5M5g.mkdir();
        mUnidad5M5h.mkdir();
        mUnidad5M5i.mkdir();
        mUnidad5M5j.mkdir();
        mUnidad5M5k.mkdir();
        mUnidad5M5l.mkdir();
        mUnidad5M5m.mkdir();

        mUnidad5M6a.mkdir();
        mUnidad5M6b.mkdir();
        mUnidad5M6c.mkdir();
        mUnidad5M6d.mkdir();
        mUnidad5M6e.mkdir();
        mUnidad5M6f.mkdir();
        mUnidad5M6g.mkdir();
        mUnidad5M6h.mkdir();
        mUnidad5M6i.mkdir();
        mUnidad5M6j.mkdir();
        mUnidad5M6k.mkdir();
        mUnidad5M6l.mkdir();
        mUnidad5M6m.mkdir();


        mUnidad5M7a.mkdir();
        mUnidad5M7b.mkdir();
        mUnidad5M7c.mkdir();
        mUnidad5M7d.mkdir();
        mUnidad5M7e.mkdir();
        mUnidad5M7f.mkdir();
        mUnidad5M7g.mkdir();
        mUnidad5M7h.mkdir();
        mUnidad5M7i.mkdir();
        mUnidad5M7j.mkdir();
        mUnidad5M7k.mkdir();
        mUnidad5M7l.mkdir();
        mUnidad5M7m.mkdir();

        mUnidad5M8a.mkdir();
        mUnidad5M8b.mkdir();
        mUnidad5M8c.mkdir();
        mUnidad5M8d.mkdir();
        mUnidad5M8e.mkdir();
        mUnidad5M8f.mkdir();
        mUnidad5M8g.mkdir();
        mUnidad5M8h.mkdir();
        mUnidad5M8i.mkdir();
        mUnidad5M8j.mkdir();
        mUnidad5M8k.mkdir();
        mUnidad5M8l.mkdir();
        mUnidad5M8m.mkdir();

        asesorias5_1.mkdir();
        asesorias5_2.mkdir();
        asesorias5_3.mkdir();
        asesorias5_4.mkdir();
        asesorias5_5.mkdir();
        asesorias5_6.mkdir();
        asesorias5_7.mkdir();
        asesorias5_8.mkdir();

        helicomotivacion5_1.mkdir();
        helicomotivacion5_2.mkdir();
        helicomotivacion5_3.mkdir();
        helicomotivacion5_4.mkdir();
        helicomotivacion5_5.mkdir();
        helicomotivacion5_6.mkdir();
        helicomotivacion5_7.mkdir();
        helicomotivacion5_8.mkdir();

        planlector5_1.mkdir();
        planlector5_2.mkdir();
        planlector5_3.mkdir();
        planlector5_4.mkdir();
        planlector5_5.mkdir();
        planlector5_6.mkdir();
        planlector5_7.mkdir();
        planlector5_8.mkdir();

    }
}

