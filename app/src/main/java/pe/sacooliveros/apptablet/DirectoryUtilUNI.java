package pe.sacooliveros.apptablet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class DirectoryUtilUNI extends AppCompatActivity implements EnviarGrado {
    
    String ruta_storage;
    String gradoalumno="";
    String grado;

    public void verResourceString(Context context)
    {
        ruta_storage= context.getString(R.string.ruta_raiz);

        Log.d("DATA_STRING", ruta_storage);

    }

    public void verGradoSec(String gradoencurso) {

        grado= gradoencurso.substring(0, 1);
        //grado= "5";
    }


    public File createCarpetas(String filename) {

        File file = new File(filename) ;


        if(!file.exists()) {


          file.mkdirs();

            File AccesoTipo2 = new File(ruta_storage+"/APP/", "3") ;

            AccesoTipo2.mkdir();

            File secundariaGrado5= new File(ruta_storage+"/APP/3/", "5");

            secundariaGrado5.mkdir();

            Secundaria_Storage();          

        }
        return file;
    }

       private void Secundaria_Storage() {


        //APP/3/5/EXADM_ANUAL/BIMESTRE4/
        //http://app8.sacooliveros.edu.pe/APP/3/5/PEADM_CAP/

        File mMenuPrincipal1= new File(ruta_storage+"/APP/3/"+grado+"/", "AJEDREZ");
        File mMenuPrincipal2= new File(ruta_storage+"/APP/3/"+grado+"/", "COMPENDIOS");
        //File mMenuPrincipal3= new File(ruta_storage+"/APP/3/"+grado+"/", "COMPUTACION"); //
        File mMenuPrincipal4= new File(ruta_storage+"/APP/3/"+grado+"/", "EDUCACION_FISICA");
        File mMenuPrincipal5= new File(ruta_storage+"/APP/3/"+grado+"/", "HELICO_BALOTARIO");
        File mMenuPrincipal6= new File(ruta_storage+"/APP/3/"+grado+"/", "HELICO_DIAPOSITIVAS");
        File mMenuPrincipal7= new File(ruta_storage+"/APP/3/"+grado+"/", "HELICO_ENGLISH");
        File mMenuPrincipal8= new File(ruta_storage+"/APP/3/"+grado+"/", "MEDITACION");
        //File mMenuPrincipal9= new File(ruta_storage+"/APP/3/"+grado+"/", "PLAN_LECTOR");
        File mMenuPrincipal10= new File(ruta_storage+"/APP/3/"+grado+"/", "PRINCIPIOS_FMATEMATICA");
        //File mMenuPrincipal11= new File(ruta_storage+"/APP/3/"+grado+"/", "PROBLEMAS_PROPUESTOS"); //
        //File mMenuPrincipal12= new File(ruta_storage+"/APP/3/"+grado+"/", "PROBLEMAS_RESUELTOS"); //
        File mMenuPrincipal13= new File(ruta_storage+"/APP/3/"+grado+"/", "COMPENDIOS");


        File mMenuPrincipal14= new File(ruta_storage+"/APP/3/"+grado+"/", "EXADM_ANUAL");
        File mMenuPrincipal15= new File(ruta_storage+"/APP/3/"+grado+"/", "PEADM_CAP");
        File mMenuPrincipal16= new File(ruta_storage+"/APP/3/"+grado+"/", "SIMULACRO_EXADM");
        File mMenuPrincipal17= new File(ruta_storage+"/APP/3/"+grado+"/", "LECTURAS_MOTIVADORAS");


        File mPrincMatematico1= new File(ruta_storage+"/APP/3/"+grado+"/PRINCIPIOS_FMATEMATICA/", "BIMESTRE1");
        File mPrincMatematico2= new File(ruta_storage+"/APP/3/"+grado+"/PRINCIPIOS_FMATEMATICA/", "BIMESTRE2");
        File mPrincMatematico3= new File(ruta_storage+"/APP/3/"+grado+"/PRINCIPIOS_FMATEMATICA/", "BIMESTRE3");
        File mPrincMatematico4= new File(ruta_storage+"/APP/3/"+grado+"/PRINCIPIOS_FMATEMATICA/", "BIMESTRE4");




        File mExamenAnual1= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE1");
        File mExamenAnual2= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE2");
        File mExamenAnual3= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE3");
        File mExamenAnual4= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE4");


        File mSimulacroExam1= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE1");
        File mSimulacroExam2= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE2");
        File mSimulacroExam3= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE3");
        File mSimulacroExam4= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE4");



        File mHDiapositivas1_1= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO1");
        File mHDiapositivas1_2= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO2");
        File mHDiapositivas1_3= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO3");
        File mHDiapositivas1_4= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO4");
        File mHDiapositivas1_5= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO5");
        File mHDiapositivas1_6= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO6");
        File mHDiapositivas1_7= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO7");
        File mHDiapositivas1_8= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/", "TOMO8");



        File mPregExamCap1_1= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO1");
        File mPregExamCap1_2= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO2");
        File mPregExamCap1_3= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO3");
        File mPregExamCap1_4= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO4");
        File mPregExamCap1_5= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO5");
        File mPregExamCap1_6= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO6");
        File mPregExamCap1_7= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO7");
        File mPregExamCap1_8= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO8");





        // ___________________________________________________________________________________________________________

        File mPregExamAdTomo1a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "ALGEBRA");
        File mPregExamAdTomo1b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "ARITMETICA");
        File mPregExamAdTomo1c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "ECONOMIA");
        File mPregExamAdTomo1d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "FISICA");
        File mPregExamAdTomo1e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "GEOGRAFIA");
        File mPregExamAdTomo1f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "GEOMETRIA");
        File mPregExamAdTomo1g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo1h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo1i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "LENGUAJE");
        File mPregExamAdTomo1j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "LITERATURA");
        File mPregExamAdTomo1k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "PSICOLOGIA");
        File mPregExamAdTomo1l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "QUIMICA");
        File mPregExamAdTomo1m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo1n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO1/", "TRIGONOMETRIA");


        File mPregExamAdTomo2a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "ALGEBRA");
        File mPregExamAdTomo2b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "ARITMETICA");
        File mPregExamAdTomo2c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "ECONOMIA");
        File mPregExamAdTomo2d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "FISICA");
        File mPregExamAdTomo2e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "GEOGRAFIA");
        File mPregExamAdTomo2f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "GEOMETRIA");
        File mPregExamAdTomo2g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo2h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo2i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "LENGUAJE");
        File mPregExamAdTomo2j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "LITERATURA");
        File mPregExamAdTomo2k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "PSICOLOGIA");
        File mPregExamAdTomo2l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "QUIMICA");
        File mPregExamAdTomo2m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo2n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO2/", "TRIGONOMETRIA");


        File mPregExamAdTomo3a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "ALGEBRA");
        File mPregExamAdTomo3b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "ARITMETICA");
        File mPregExamAdTomo3c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "ECONOMIA");
        File mPregExamAdTomo3d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "FISICA");
        File mPregExamAdTomo3e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "GEOGRAFIA");
        File mPregExamAdTomo3f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "GEOMETRIA");
        File mPregExamAdTomo3g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo3h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo3i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "LENGUAJE");
        File mPregExamAdTomo3j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "LITERATURA");
        File mPregExamAdTomo3k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "PSICOLOGIA");
        File mPregExamAdTomo3l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "QUIMICA");
        File mPregExamAdTomo3m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo3n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO3/", "TRIGONOMETRIA");


        File mPregExamAdTomo4a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "ALGEBRA");
        File mPregExamAdTomo4b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "ARITMETICA");
        File mPregExamAdTomo4c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "ECONOMIA");
        File mPregExamAdTomo4d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "FISICA");
        File mPregExamAdTomo4e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "GEOGRAFIA");
        File mPregExamAdTomo4f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "GEOMETRIA");
        File mPregExamAdTomo4g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo4h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo4i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "LENGUAJE");
        File mPregExamAdTomo4j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "LITERATURA");
        File mPregExamAdTomo4k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "PSICOLOGIA");
        File mPregExamAdTomo4l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "QUIMICA");
        File mPregExamAdTomo4m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo4n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO4/", "TRIGONOMETRIA");

        File mPregExamAdTomo5a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "ALGEBRA");
        File mPregExamAdTomo5b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "ARITMETICA");
        File mPregExamAdTomo5c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "ECONOMIA");
        File mPregExamAdTomo5d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "FISICA");
        File mPregExamAdTomo5e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "GEOGRAFIA");
        File mPregExamAdTomo5f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "GEOMETRIA");
        File mPregExamAdTomo5g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo5h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo5i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "LENGUAJE");
        File mPregExamAdTomo5j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "LITERATURA");
        File mPregExamAdTomo5k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "PSICOLOGIA");
        File mPregExamAdTomo5l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "QUIMICA");
        File mPregExamAdTomo5m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo5n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO5/", "TRIGONOMETRIA");

        File mPregExamAdTomo6a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "ALGEBRA");
        File mPregExamAdTomo6b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "ARITMETICA");
        File mPregExamAdTomo6c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "ECONOMIA");
        File mPregExamAdTomo6d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "FISICA");
        File mPregExamAdTomo6e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "GEOGRAFIA");
        File mPregExamAdTomo6f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "GEOMETRIA");
        File mPregExamAdTomo6g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo6h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo6i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "LENGUAJE");
        File mPregExamAdTomo6j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "LITERATURA");
        File mPregExamAdTomo6k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "PSICOLOGIA");
        File mPregExamAdTomo6l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "QUIMICA");
        File mPregExamAdTomo6m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo6n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO6/", "TRIGONOMETRIA");


        File mPregExamAdTomo7a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "ALGEBRA");
        File mPregExamAdTomo7b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "ARITMETICA");
        File mPregExamAdTomo7c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "ECONOMIA");
        File mPregExamAdTomo7d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "FISICA");
        File mPregExamAdTomo7e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "GEOGRAFIA");
        File mPregExamAdTomo7f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "GEOMETRIA");
        File mPregExamAdTomo7g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo7h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo7i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "LENGUAJE");
        File mPregExamAdTomo7j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "LITERATURA");
        File mPregExamAdTomo7k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "PSICOLOGIA");
        File mPregExamAdTomo7l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "QUIMICA");
        File mPregExamAdTomo7m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo7n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO7/", "TRIGONOMETRIA");


        File mPregExamAdTomo8a= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "ALGEBRA");
        File mPregExamAdTomo8b= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "ARITMETICA");
        File mPregExamAdTomo8c= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "ECONOMIA");
        File mPregExamAdTomo8d= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "FISICA");
        File mPregExamAdTomo8e= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "GEOGRAFIA");
        File mPregExamAdTomo8f= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "GEOMETRIA");
        File mPregExamAdTomo8g= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomo8h= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomo8i= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "LENGUAJE");
        File mPregExamAdTomo8j= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "LITERATURA");
        File mPregExamAdTomo8k= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "PSICOLOGIA");
        File mPregExamAdTomo8l= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "QUIMICA");
        File mPregExamAdTomo8m= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomo8n= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/TOMO8/", "TRIGONOMETRIA");




        //____________________________________________________________________________________________________________



        File mCompendio1_1= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO1");
        File mCompendio1_2= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO2");
        File mCompendio1_3= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO3");
        File mCompendio1_4= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO4");
        File mCompendio1_5= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO5");
        File mCompendio1_6= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO6");
        File mCompendio1_7= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO7");
        File mCompendio1_8= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/", "TOMO8");


        File mCompendioTomo1a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "ALGEBRA");
        File mCompendioTomo1b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "ARITMETICA");
        File mCompendioTomo1c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "BIOLOGIA");
        File mCompendioTomo1d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "ECONOMIA");
        File mCompendioTomo1e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "FISICA");
        File mCompendioTomo1f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "GEOGRAFIA");
        File mCompendioTomo1g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "GEOMETRIA");
        File mCompendioTomo1h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "HISTORIA_DEL_PERU");
        File mCompendioTomo1i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo1j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "LENGUAJE");
        File mCompendioTomo1k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "LITERATURA");
        File mCompendioTomo1l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "PSICOLOGIA");
        File mCompendioTomo1m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "QUIMICA");
        File mCompendioTomo1n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo1o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo1p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO1/", "TRIGONOMETRIA");



        File mCompendioTomo2a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "ALGEBRA");
        File mCompendioTomo2b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "ARITMETICA");
        File mCompendioTomo2c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "BIOLOGIA");
        File mCompendioTomo2d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "ECONOMIA");
        File mCompendioTomo2e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "FISICA");
        File mCompendioTomo2f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "GEOGRAFIA");
        File mCompendioTomo2g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "GEOMETRIA");
        File mCompendioTomo2h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "HISTORIA_DEL_PERU");
        File mCompendioTomo2i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo2j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "LENGUAJE");
        File mCompendioTomo2k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "LITERATURA");
        File mCompendioTomo2l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "PSICOLOGIA");
        File mCompendioTomo2m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "QUIMICA");
        File mCompendioTomo2n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo2o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo2p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO2/", "TRIGONOMETRIA");

        File mCompendioTomo3a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "ALGEBRA");
        File mCompendioTomo3b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "ARITMETICA");
        File mCompendioTomo3c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "BIOLOGIA");
        File mCompendioTomo3d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "ECONOMIA");
        File mCompendioTomo3e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "FISICA");
        File mCompendioTomo3f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "GEOGRAFIA");
        File mCompendioTomo3g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "GEOMETRIA");
        File mCompendioTomo3h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "HISTORIA_DEL_PERU");
        File mCompendioTomo3i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo3j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "LENGUAJE");
        File mCompendioTomo3k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "LITERATURA");
        File mCompendioTomo3l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "PSICOLOGIA");
        File mCompendioTomo3m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo3p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo3q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO3/", "TRIGONOMETRIA");

        File mCompendioTomo4a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "ALGEBRA");
        File mCompendioTomo4b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "ARITMETICA");
        File mCompendioTomo4c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "BIOLOGIA");
        File mCompendioTomo4d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "ECONOMIA");
        File mCompendioTomo4e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "FISICA");
        File mCompendioTomo4f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "GEOGRAFIA");
        File mCompendioTomo4g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "GEOMETRIA");
        File mCompendioTomo4h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "HISTORIA_DEL_PERU");
        File mCompendioTomo4i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo4j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "LENGUAJE");
        File mCompendioTomo4k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "LITERATURA");
        File mCompendioTomo4l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "PSICOLOGIA");
        File mCompendioTomo4m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo4p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo4q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO4/", "TRIGONOMETRIA");

        File mCompendioTomo5a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "ALGEBRA");
        File mCompendioTomo5b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "ARITMETICA");
        File mCompendioTomo5c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "BIOLOGIA");
        File mCompendioTomo5d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "ECONOMIA");
        File mCompendioTomo5e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "FISICA");
        File mCompendioTomo5f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "GEOGRAFIA");
        File mCompendioTomo5g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "GEOMETRIA");
        File mCompendioTomo5h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "HISTORIA_DEL_PERU");
        File mCompendioTomo5i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo5j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "LENGUAJE");
        File mCompendioTomo5k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "LITERATURA");
        File mCompendioTomo5l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "PSICOLOGIA");
        File mCompendioTomo5m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo5p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo5q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO5/", "TRIGONOMETRIA");



        File mCompendioTomo6a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "ALGEBRA");
        File mCompendioTomo6b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "ARITMETICA");
        File mCompendioTomo6c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "BIOLOGIA");
        File mCompendioTomo6d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "ECONOMIA");
        File mCompendioTomo6e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "FISICA");
        File mCompendioTomo6f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "GEOGRAFIA");
        File mCompendioTomo6g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "GEOMETRIA");
        File mCompendioTomo6h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "HISTORIA_DEL_PERU");
        File mCompendioTomo6i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo6j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "LENGUAJE");
        File mCompendioTomo6k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "LITERATURA");
        File mCompendioTomo6l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "PSICOLOGIA");
        File mCompendioTomo6m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo6p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo6q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO6/", "TRIGONOMETRIA");

        File mCompendioTomo7a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "ALGEBRA");
        File mCompendioTomo7b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "ARITMETICA");
        File mCompendioTomo7c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "BIOLOGIA");
        File mCompendioTomo7d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "ECONOMIA");
        File mCompendioTomo7e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "FISICA");
        File mCompendioTomo7f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "GEOGRAFIA");
        File mCompendioTomo7g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "GEOMETRIA");
        File mCompendioTomo7h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "HISTORIA_DEL_PERU");
        File mCompendioTomo7i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo7j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "LENGUAJE");
        File mCompendioTomo7k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "LITERATURA");
        File mCompendioTomo7l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "PSICOLOGIA");
        File mCompendioTomo7m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo7p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo7q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO7/", "TRIGONOMETRIA");

        File mCompendioTomo8a= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "ALGEBRA");
        File mCompendioTomo8b= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "ARITMETICA");
        File mCompendioTomo8c= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "BIOLOGIA");
        File mCompendioTomo8d= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "ECONOMIA");
        File mCompendioTomo8e= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "FISICA");
        File mCompendioTomo8f= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "GEOGRAFIA");
        File mCompendioTomo8g= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "GEOMETRIA");
        File mCompendioTomo8h= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "HISTORIA_DEL_PERU");
        File mCompendioTomo8i= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo8j= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "LENGUAJE");
        File mCompendioTomo8k= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "LITERATURA");
        File mCompendioTomo8l= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "PSICOLOGIA");
        File mCompendioTomo8m= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8n= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8o= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo8p= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo8q= new File(ruta_storage+"/APP/3/"+grado+"/COMPENDIOS/TOMO8/", "TRIGONOMETRIA");



        //----------------------------------------------------------------------------------------------------


        File mDiapositivasTomo1a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "ALGEBRA");
        File mDiapositivasTomo1b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "ARITMETICA");
        File mDiapositivasTomo1c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "BIOLOGIA");
        File mDiapositivasTomo1d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "ECONOMIA");
        File mDiapositivasTomo1e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "FISICA");
        File mDiapositivasTomo1f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "GEOGRAFIA");
        File mDiapositivasTomo1g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "GEOMETRIA");
        File mDiapositivasTomo1h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo1i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo1j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "LENGUAJE");
        File mDiapositivasTomo1k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "LITERATURA");
        File mDiapositivasTomo1l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "PSICOLOGIA");
        File mDiapositivasTomo1m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "QUIMICA");
        File mDiapositivasTomo1n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "QUIMICA");
        File mDiapositivasTomo1o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo1p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo1q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO1/", "TRIGONOMETRIA");


        File mDiapositivasTomo2a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "ALGEBRA");
        File mDiapositivasTomo2b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "ARITMETICA");
        File mDiapositivasTomo2c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "BIOLOGIA");
        File mDiapositivasTomo2d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "ECONOMIA");
        File mDiapositivasTomo2e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "FISICA");
        File mDiapositivasTomo2f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "GEOGRAFIA");
        File mDiapositivasTomo2g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "GEOMETRIA");
        File mDiapositivasTomo2h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo2i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo2j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "LENGUAJE");
        File mDiapositivasTomo2k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "LITERATURA");
        File mDiapositivasTomo2l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "PSICOLOGIA");
        File mDiapositivasTomo2m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "QUIMICA");
        File mDiapositivasTomo2n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "QUIMICA");
        File mDiapositivasTomo2o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo2p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo2q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO2/", "TRIGONOMETRIA");

        File mDiapositivasTomo3a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "ALGEBRA");
        File mDiapositivasTomo3b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "ARITMETICA");
        File mDiapositivasTomo3c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "BIOLOGIA");
        File mDiapositivasTomo3d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "ECONOMIA");
        File mDiapositivasTomo3e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "FISICA");
        File mDiapositivasTomo3f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "GEOGRAFIA");
        File mDiapositivasTomo3g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "GEOMETRIA");
        File mDiapositivasTomo3h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo3i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo3j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "LENGUAJE");
        File mDiapositivasTomo3k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "LITERATURA");
        File mDiapositivasTomo3l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "PSICOLOGIA");
        File mDiapositivasTomo3m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "QUIMICA");
        File mDiapositivasTomo3n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "QUIMICA");
        File mDiapositivasTomo3o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo3p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo3q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO3/", "TRIGONOMETRIA");



        File mDiapositivasTomo4a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "ALGEBRA");
        File mDiapositivasTomo4b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "ARITMETICA");
        File mDiapositivasTomo4c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "BIOLOGIA");
        File mDiapositivasTomo4d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "ECONOMIA");
        File mDiapositivasTomo4e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "FISICA");
        File mDiapositivasTomo4f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "GEOGRAFIA");
        File mDiapositivasTomo4g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "GEOMETRIA");
        File mDiapositivasTomo4h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo4i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo4j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "LENGUAJE");
        File mDiapositivasTomo4k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "LITERATURA");
        File mDiapositivasTomo4l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "PSICOLOGIA");
        File mDiapositivasTomo4m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "QUIMICA");
        File mDiapositivasTomo4n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "QUIMICA");
        File mDiapositivasTomo4o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo4p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo4q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO4/", "TRIGONOMETRIA");


        File mDiapositivasTomo5a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "ALGEBRA");
        File mDiapositivasTomo5b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "ARITMETICA");
        File mDiapositivasTomo5c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "BIOLOGIA");
        File mDiapositivasTomo5d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "ECONOMIA");
        File mDiapositivasTomo5e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "FISICA");
        File mDiapositivasTomo5f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "GEOGRAFIA");
        File mDiapositivasTomo5g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "GEOMETRIA");
        File mDiapositivasTomo5h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo5i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo5j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "LENGUAJE");
        File mDiapositivasTomo5k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "LITERATURA");
        File mDiapositivasTomo5l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "PSICOLOGIA");
        File mDiapositivasTomo5m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "QUIMICA");
        File mDiapositivasTomo5n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "QUIMICA");
        File mDiapositivasTomo5o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo5p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo5q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO5/", "TRIGONOMETRIA");

        File mDiapositivasTomo6a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "ALGEBRA");
        File mDiapositivasTomo6b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "ARITMETICA");
        File mDiapositivasTomo6c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "BIOLOGIA");
        File mDiapositivasTomo6d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "ECONOMIA");
        File mDiapositivasTomo6e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "FISICA");
        File mDiapositivasTomo6f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "GEOGRAFIA");
        File mDiapositivasTomo6g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "GEOMETRIA");
        File mDiapositivasTomo6h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo6i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo6j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "LENGUAJE");
        File mDiapositivasTomo6k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "LITERATURA");
        File mDiapositivasTomo6l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "PSICOLOGIA");
        File mDiapositivasTomo6m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "QUIMICA");
        File mDiapositivasTomo6n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "QUIMICA");
        File mDiapositivasTomo6o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo6p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo6q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO6/", "TRIGONOMETRIA");


        File mDiapositivasTomo7a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "ALGEBRA");
        File mDiapositivasTomo7b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "ARITMETICA");
        File mDiapositivasTomo7c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "BIOLOGIA");
        File mDiapositivasTomo7d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "ECONOMIA");
        File mDiapositivasTomo7e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "FISICA");
        File mDiapositivasTomo7f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "GEOGRAFIA");
        File mDiapositivasTomo7g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "GEOMETRIA");
        File mDiapositivasTomo7h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo7i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo7j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "LENGUAJE");
        File mDiapositivasTomo7k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "LITERATURA");
        File mDiapositivasTomo7l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "PSICOLOGIA");
        File mDiapositivasTomo7m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "QUIMICA");
        File mDiapositivasTomo7n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "QUIMICA");
        File mDiapositivasTomo7o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo7p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo7q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO7/", "TRIGONOMETRIA");


        File mDiapositivasTomo8a= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "ALGEBRA");
        File mDiapositivasTomo8b= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "ARITMETICA");
        File mDiapositivasTomo8c= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "BIOLOGIA");
        File mDiapositivasTomo8d= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "ECONOMIA");
        File mDiapositivasTomo8e= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "FISICA");
        File mDiapositivasTomo8f= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "GEOGRAFIA");
        File mDiapositivasTomo8g= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "GEOMETRIA");
        File mDiapositivasTomo8h= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo8i= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo8j= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "LENGUAJE");
        File mDiapositivasTomo8k= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "LITERATURA");
        File mDiapositivasTomo8l= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "PSICOLOGIA");
        File mDiapositivasTomo8m= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "QUIMICA");
        File mDiapositivasTomo8n= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "QUIMICA");
        File mDiapositivasTomo8o= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo8p= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo8q= new File(ruta_storage+"/APP/3/"+grado+"/HELICO_DIAPOSITIVAS/TOMO8/", "TRIGONOMETRIA");




        mMenuPrincipal1.mkdir();
        mMenuPrincipal2.mkdir();
        mMenuPrincipal4.mkdir();
        mMenuPrincipal5.mkdir();
        mMenuPrincipal6.mkdir();
        mMenuPrincipal7.mkdir();
        mMenuPrincipal8.mkdir();
        //mMenuPrincipal9.mkdir();
        mMenuPrincipal10.mkdir();
        mMenuPrincipal13.mkdir();
        mMenuPrincipal14.mkdir();
        mMenuPrincipal15.mkdir();
        mMenuPrincipal16.mkdir();
        mMenuPrincipal17.mkdir();



        mHDiapositivas1_1.mkdir();
        mHDiapositivas1_2.mkdir();
        mHDiapositivas1_3.mkdir();
        mHDiapositivas1_4.mkdir();
        mHDiapositivas1_5.mkdir();
        mHDiapositivas1_6.mkdir();
        mHDiapositivas1_7.mkdir();
        mHDiapositivas1_8.mkdir();


        mPregExamCap1_1.mkdir();
        mPregExamCap1_2.mkdir();
        mPregExamCap1_3.mkdir();
        mPregExamCap1_4.mkdir();
        mPregExamCap1_5.mkdir();
        mPregExamCap1_6.mkdir();
        mPregExamCap1_7.mkdir();
        mPregExamCap1_8.mkdir();


        mPrincMatematico1.mkdir();
        mPrincMatematico2.mkdir();
        mPrincMatematico3.mkdir();
        mPrincMatematico4.mkdir();

        mExamenAnual1.mkdir();
        mExamenAnual2.mkdir();
        mExamenAnual3.mkdir();
        mExamenAnual4.mkdir();

        mSimulacroExam1.mkdir();
        mSimulacroExam2.mkdir();
        mSimulacroExam3.mkdir();
        mSimulacroExam4.mkdir();


        mCompendio1_1.mkdir();
        mCompendio1_2.mkdir();
        mCompendio1_3.mkdir();
        mCompendio1_4.mkdir();
        mCompendio1_5.mkdir();
        mCompendio1_6.mkdir();
        mCompendio1_7.mkdir();
        mCompendio1_8.mkdir();



        mPregExamAdTomo1a.mkdir();
        mPregExamAdTomo1b.mkdir();
        mPregExamAdTomo1c.mkdir();
        mPregExamAdTomo1d.mkdir();
        mPregExamAdTomo1e.mkdir();
        mPregExamAdTomo1f.mkdir();
        mPregExamAdTomo1g.mkdir();
        mPregExamAdTomo1h.mkdir();
        mPregExamAdTomo1i.mkdir();
        mPregExamAdTomo1j.mkdir();
        mPregExamAdTomo1k.mkdir();
        mPregExamAdTomo1l.mkdir();
        mPregExamAdTomo1m.mkdir();
        mPregExamAdTomo1n.mkdir();


        mPregExamAdTomo2a.mkdir();
        mPregExamAdTomo2b.mkdir();
        mPregExamAdTomo2c.mkdir();
        mPregExamAdTomo2d.mkdir();
        mPregExamAdTomo2e.mkdir();
        mPregExamAdTomo2f.mkdir();
        mPregExamAdTomo2g.mkdir();
        mPregExamAdTomo2h.mkdir();
        mPregExamAdTomo2i.mkdir();
        mPregExamAdTomo2j.mkdir();
        mPregExamAdTomo2k.mkdir();
        mPregExamAdTomo2l.mkdir();
        mPregExamAdTomo2m.mkdir();
        mPregExamAdTomo2n.mkdir();


        mPregExamAdTomo3a.mkdir();
        mPregExamAdTomo3b.mkdir();
        mPregExamAdTomo3c.mkdir();
        mPregExamAdTomo3d.mkdir();
        mPregExamAdTomo3e.mkdir();
        mPregExamAdTomo3f.mkdir();
        mPregExamAdTomo3g.mkdir();
        mPregExamAdTomo3h.mkdir();
        mPregExamAdTomo3i.mkdir();
        mPregExamAdTomo3j.mkdir();
        mPregExamAdTomo3k.mkdir();
        mPregExamAdTomo3l.mkdir();
        mPregExamAdTomo3m.mkdir();
        mPregExamAdTomo3n.mkdir();

        mPregExamAdTomo4a.mkdir();
        mPregExamAdTomo4b.mkdir();
        mPregExamAdTomo4c.mkdir();
        mPregExamAdTomo4d.mkdir();
        mPregExamAdTomo4e.mkdir();
        mPregExamAdTomo4f.mkdir();
        mPregExamAdTomo4g.mkdir();
        mPregExamAdTomo4h.mkdir();
        mPregExamAdTomo4i.mkdir();
        mPregExamAdTomo4j.mkdir();
        mPregExamAdTomo4k.mkdir();
        mPregExamAdTomo4l.mkdir();
        mPregExamAdTomo4m.mkdir();
        mPregExamAdTomo4n.mkdir();


        mPregExamAdTomo5a.mkdir();
        mPregExamAdTomo5b.mkdir();
        mPregExamAdTomo5c.mkdir();
        mPregExamAdTomo5d.mkdir();
        mPregExamAdTomo5e.mkdir();
        mPregExamAdTomo5f.mkdir();
        mPregExamAdTomo5g.mkdir();
        mPregExamAdTomo5h.mkdir();
        mPregExamAdTomo5i.mkdir();
        mPregExamAdTomo5j.mkdir();
        mPregExamAdTomo5k.mkdir();
        mPregExamAdTomo5l.mkdir();
        mPregExamAdTomo5m.mkdir();
        mPregExamAdTomo5n.mkdir();


        mPregExamAdTomo6a.mkdir();
        mPregExamAdTomo6b.mkdir();
        mPregExamAdTomo6c.mkdir();
        mPregExamAdTomo6d.mkdir();
        mPregExamAdTomo6e.mkdir();
        mPregExamAdTomo6f.mkdir();
        mPregExamAdTomo6g.mkdir();
        mPregExamAdTomo6h.mkdir();
        mPregExamAdTomo6i.mkdir();
        mPregExamAdTomo6j.mkdir();
        mPregExamAdTomo6k.mkdir();
        mPregExamAdTomo6l.mkdir();
        mPregExamAdTomo6m.mkdir();
        mPregExamAdTomo6n.mkdir();


        mPregExamAdTomo7a.mkdir();
        mPregExamAdTomo7b.mkdir();
        mPregExamAdTomo7c.mkdir();
        mPregExamAdTomo7d.mkdir();
        mPregExamAdTomo7e.mkdir();
        mPregExamAdTomo7f.mkdir();
        mPregExamAdTomo7g.mkdir();
        mPregExamAdTomo7h.mkdir();
        mPregExamAdTomo7i.mkdir();
        mPregExamAdTomo7j.mkdir();
        mPregExamAdTomo7k.mkdir();
        mPregExamAdTomo7l.mkdir();
        mPregExamAdTomo7m.mkdir();
        mPregExamAdTomo7n.mkdir();


        mPregExamAdTomo8a.mkdir();
        mPregExamAdTomo8b.mkdir();
        mPregExamAdTomo8c.mkdir();
        mPregExamAdTomo8d.mkdir();
        mPregExamAdTomo8e.mkdir();
        mPregExamAdTomo8f.mkdir();
        mPregExamAdTomo8g.mkdir();
        mPregExamAdTomo8h.mkdir();
        mPregExamAdTomo8i.mkdir();
        mPregExamAdTomo8j.mkdir();
        mPregExamAdTomo8k.mkdir();
        mPregExamAdTomo8l.mkdir();
        mPregExamAdTomo8m.mkdir();
        mPregExamAdTomo8n.mkdir();





        mCompendioTomo1a.mkdir();
        mCompendioTomo1b.mkdir();
        mCompendioTomo1c.mkdir();
        mCompendioTomo1d.mkdir();
        mCompendioTomo1e.mkdir();
        mCompendioTomo1f.mkdir();
        mCompendioTomo1g.mkdir();
        mCompendioTomo1h.mkdir();
        mCompendioTomo1i.mkdir();
        mCompendioTomo1j.mkdir();
        mCompendioTomo1k.mkdir();
        mCompendioTomo1l.mkdir();
        mCompendioTomo1m.mkdir();
        mCompendioTomo1n.mkdir();
        mCompendioTomo1o.mkdir();
        mCompendioTomo1p.mkdir();


        mCompendioTomo2a.mkdir();
        mCompendioTomo2b.mkdir();
        mCompendioTomo2c.mkdir();
        mCompendioTomo2d.mkdir();
        mCompendioTomo2e.mkdir();
        mCompendioTomo2f.mkdir();
        mCompendioTomo2g.mkdir();
        mCompendioTomo2h.mkdir();
        mCompendioTomo2i.mkdir();
        mCompendioTomo2j.mkdir();
        mCompendioTomo2k.mkdir();
        mCompendioTomo2l.mkdir();
        mCompendioTomo2m.mkdir();
        mCompendioTomo2n.mkdir();
        mCompendioTomo2o.mkdir();
        mCompendioTomo2p.mkdir();


        mCompendioTomo3a.mkdir();
        mCompendioTomo3b.mkdir();
        mCompendioTomo3c.mkdir();
        mCompendioTomo3d.mkdir();
        mCompendioTomo3e.mkdir();
        mCompendioTomo3f.mkdir();
        mCompendioTomo3g.mkdir();
        mCompendioTomo3h.mkdir();
        mCompendioTomo3i.mkdir();
        mCompendioTomo3j.mkdir();
        mCompendioTomo3k.mkdir();
        mCompendioTomo3l.mkdir();
        mCompendioTomo3m.mkdir();
        mCompendioTomo3n.mkdir();
        mCompendioTomo3o.mkdir();
        mCompendioTomo3p.mkdir();
        mCompendioTomo3q.mkdir();

        mCompendioTomo4a.mkdir();
        mCompendioTomo4b.mkdir();
        mCompendioTomo4c.mkdir();
        mCompendioTomo4d.mkdir();
        mCompendioTomo4e.mkdir();
        mCompendioTomo4f.mkdir();
        mCompendioTomo4g.mkdir();
        mCompendioTomo4h.mkdir();
        mCompendioTomo4i.mkdir();
        mCompendioTomo4j.mkdir();
        mCompendioTomo4k.mkdir();
        mCompendioTomo4l.mkdir();
        mCompendioTomo4m.mkdir();
        mCompendioTomo4n.mkdir();
        mCompendioTomo4o.mkdir();
        mCompendioTomo4p.mkdir();
        mCompendioTomo4q.mkdir();

        mCompendioTomo5a.mkdir();
        mCompendioTomo5b.mkdir();
        mCompendioTomo5c.mkdir();
        mCompendioTomo5d.mkdir();
        mCompendioTomo5e.mkdir();
        mCompendioTomo5f.mkdir();
        mCompendioTomo5g.mkdir();
        mCompendioTomo5h.mkdir();
        mCompendioTomo5i.mkdir();
        mCompendioTomo5j.mkdir();
        mCompendioTomo5k.mkdir();
        mCompendioTomo5l.mkdir();
        mCompendioTomo5m.mkdir();
        mCompendioTomo5n.mkdir();
        mCompendioTomo5o.mkdir();
        mCompendioTomo5p.mkdir();
        mCompendioTomo5q.mkdir();


        mCompendioTomo6a.mkdir();
        mCompendioTomo6b.mkdir();
        mCompendioTomo6c.mkdir();
        mCompendioTomo6d.mkdir();
        mCompendioTomo6e.mkdir();
        mCompendioTomo6f.mkdir();
        mCompendioTomo6g.mkdir();
        mCompendioTomo6h.mkdir();
        mCompendioTomo6i.mkdir();
        mCompendioTomo6j.mkdir();
        mCompendioTomo6k.mkdir();
        mCompendioTomo6l.mkdir();
        mCompendioTomo6m.mkdir();
        mCompendioTomo6n.mkdir();
        mCompendioTomo6o.mkdir();
        mCompendioTomo6p.mkdir();
        mCompendioTomo6q.mkdir();


        mCompendioTomo7a.mkdir();
        mCompendioTomo7b.mkdir();
        mCompendioTomo7c.mkdir();
        mCompendioTomo7d.mkdir();
        mCompendioTomo7e.mkdir();
        mCompendioTomo7f.mkdir();
        mCompendioTomo7g.mkdir();
        mCompendioTomo7h.mkdir();
        mCompendioTomo7i.mkdir();
        mCompendioTomo7j.mkdir();
        mCompendioTomo7k.mkdir();
        mCompendioTomo7l.mkdir();
        mCompendioTomo7m.mkdir();
        mCompendioTomo7n.mkdir();
        mCompendioTomo7o.mkdir();
        mCompendioTomo7p.mkdir();
        mCompendioTomo7q.mkdir();


        mCompendioTomo8a.mkdir();
        mCompendioTomo8b.mkdir();
        mCompendioTomo8c.mkdir();
        mCompendioTomo8d.mkdir();
        mCompendioTomo8e.mkdir();
        mCompendioTomo8f.mkdir();
        mCompendioTomo8g.mkdir();
        mCompendioTomo8h.mkdir();
        mCompendioTomo8i.mkdir();
        mCompendioTomo8j.mkdir();
        mCompendioTomo8k.mkdir();
        mCompendioTomo8l.mkdir();
        mCompendioTomo8m.mkdir();
        mCompendioTomo8n.mkdir();
        mCompendioTomo8o.mkdir();
        mCompendioTomo8p.mkdir();
        mCompendioTomo8q.mkdir();






        mDiapositivasTomo1a.mkdir();
        mDiapositivasTomo1b.mkdir();
        mDiapositivasTomo1c.mkdir();
        mDiapositivasTomo1d.mkdir();
        mDiapositivasTomo1e.mkdir();
        mDiapositivasTomo1f.mkdir();
        mDiapositivasTomo1g.mkdir();
        mDiapositivasTomo1h.mkdir();
        mDiapositivasTomo1i.mkdir();
        mDiapositivasTomo1j.mkdir();
        mDiapositivasTomo1k.mkdir();
        mDiapositivasTomo1l.mkdir();
        mDiapositivasTomo1m.mkdir();
        mDiapositivasTomo1n.mkdir();
        mDiapositivasTomo1o.mkdir();
        mDiapositivasTomo1p.mkdir();
        mDiapositivasTomo1q.mkdir();


        mDiapositivasTomo2a.mkdir();
        mDiapositivasTomo2b.mkdir();
        mDiapositivasTomo2c.mkdir();
        mDiapositivasTomo2d.mkdir();
        mDiapositivasTomo2e.mkdir();
        mDiapositivasTomo2f.mkdir();
        mDiapositivasTomo2g.mkdir();
        mDiapositivasTomo2h.mkdir();
        mDiapositivasTomo2i.mkdir();
        mDiapositivasTomo2j.mkdir();
        mDiapositivasTomo2k.mkdir();
        mDiapositivasTomo2l.mkdir();
        mDiapositivasTomo2m.mkdir();
        mDiapositivasTomo2n.mkdir();
        mDiapositivasTomo2o.mkdir();
        mDiapositivasTomo2p.mkdir();
        mDiapositivasTomo2q.mkdir();


        mDiapositivasTomo3a.mkdir();
        mDiapositivasTomo3b.mkdir();
        mDiapositivasTomo3c.mkdir();
        mDiapositivasTomo3d.mkdir();
        mDiapositivasTomo3e.mkdir();
        mDiapositivasTomo3f.mkdir();
        mDiapositivasTomo3g.mkdir();
        mDiapositivasTomo3h.mkdir();
        mDiapositivasTomo3i.mkdir();
        mDiapositivasTomo3j.mkdir();
        mDiapositivasTomo3k.mkdir();
        mDiapositivasTomo3l.mkdir();
        mDiapositivasTomo3m.mkdir();
        mDiapositivasTomo3n.mkdir();
        mDiapositivasTomo3o.mkdir();
        mDiapositivasTomo3p.mkdir();
        mDiapositivasTomo3q.mkdir();



        mDiapositivasTomo4a.mkdir();
        mDiapositivasTomo4b.mkdir();
        mDiapositivasTomo4c.mkdir();
        mDiapositivasTomo4d.mkdir();
        mDiapositivasTomo4e.mkdir();
        mDiapositivasTomo4f.mkdir();
        mDiapositivasTomo4g.mkdir();
        mDiapositivasTomo4h.mkdir();
        mDiapositivasTomo4i.mkdir();
        mDiapositivasTomo4j.mkdir();
        mDiapositivasTomo4k.mkdir();
        mDiapositivasTomo4l.mkdir();
        mDiapositivasTomo4m.mkdir();
        mDiapositivasTomo4n.mkdir();
        mDiapositivasTomo4o.mkdir();
        mDiapositivasTomo4p.mkdir();
        mDiapositivasTomo4q.mkdir();


        mDiapositivasTomo5a.mkdir();
        mDiapositivasTomo5b.mkdir();
        mDiapositivasTomo5c.mkdir();
        mDiapositivasTomo5d.mkdir();
        mDiapositivasTomo5e.mkdir();
        mDiapositivasTomo5f.mkdir();
        mDiapositivasTomo5g.mkdir();
        mDiapositivasTomo5h.mkdir();
        mDiapositivasTomo5i.mkdir();
        mDiapositivasTomo5j.mkdir();
        mDiapositivasTomo5k.mkdir();
        mDiapositivasTomo5l.mkdir();
        mDiapositivasTomo5m.mkdir();
        mDiapositivasTomo5n.mkdir();
        mDiapositivasTomo5o.mkdir();
        mDiapositivasTomo5p.mkdir();
        mDiapositivasTomo5q.mkdir();


        mDiapositivasTomo6a.mkdir();
        mDiapositivasTomo6b.mkdir();
        mDiapositivasTomo6c.mkdir();
        mDiapositivasTomo6d.mkdir();
        mDiapositivasTomo6e.mkdir();
        mDiapositivasTomo6f.mkdir();
        mDiapositivasTomo6g.mkdir();
        mDiapositivasTomo6h.mkdir();
        mDiapositivasTomo6i.mkdir();
        mDiapositivasTomo6j.mkdir();
        mDiapositivasTomo6k.mkdir();
        mDiapositivasTomo6l.mkdir();
        mDiapositivasTomo6m.mkdir();
        mDiapositivasTomo6n.mkdir();
        mDiapositivasTomo6o.mkdir();
        mDiapositivasTomo6p.mkdir();
        mDiapositivasTomo6q.mkdir();


        mDiapositivasTomo7a.mkdir();
        mDiapositivasTomo7b.mkdir();
        mDiapositivasTomo7c.mkdir();
        mDiapositivasTomo7d.mkdir();
        mDiapositivasTomo7e.mkdir();
        mDiapositivasTomo7f.mkdir();
        mDiapositivasTomo7g.mkdir();
        mDiapositivasTomo7h.mkdir();
        mDiapositivasTomo7i.mkdir();
        mDiapositivasTomo7j.mkdir();
        mDiapositivasTomo7k.mkdir();
        mDiapositivasTomo7l.mkdir();
        mDiapositivasTomo7m.mkdir();
        mDiapositivasTomo7n.mkdir();
        mDiapositivasTomo7o.mkdir();
        mDiapositivasTomo7p.mkdir();
        mDiapositivasTomo7q.mkdir();


        mDiapositivasTomo8a.mkdir();
        mDiapositivasTomo8b.mkdir();
        mDiapositivasTomo8c.mkdir();
        mDiapositivasTomo8d.mkdir();
        mDiapositivasTomo8e.mkdir();
        mDiapositivasTomo8f.mkdir();
        mDiapositivasTomo8g.mkdir();
        mDiapositivasTomo8h.mkdir();
        mDiapositivasTomo8i.mkdir();
        mDiapositivasTomo8j.mkdir();
        mDiapositivasTomo8k.mkdir();
        mDiapositivasTomo8l.mkdir();
        mDiapositivasTomo8m.mkdir();
        mDiapositivasTomo8n.mkdir();
        mDiapositivasTomo8o.mkdir();
        mDiapositivasTomo8p.mkdir();
        mDiapositivasTomo8q.mkdir();


    }


    @Override
    public void enviargrado(String mensaje) {
        gradoalumno= mensaje;
    }


}
