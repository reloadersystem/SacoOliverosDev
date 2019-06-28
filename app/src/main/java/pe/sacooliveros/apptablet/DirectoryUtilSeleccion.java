package pe.sacooliveros.apptablet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class DirectoryUtilSeleccion extends AppCompatActivity implements EnviarGrado {

    String ruta_storage;
    String gradoalumno="";
    String grado;

    public void verResourceString(Context context)
    {
        ruta_storage= context.getString(R.string.ruta_raiz);

        Log.d("DATA_STRING", ruta_storage);

    }

    public void verGradoSec(String gradoencurso) {

        grado= gradoencurso;
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
            

            File AccesoTipo3 = new File(ruta_storage+"/APP/", "4") ;
            AccesoTipo3.mkdir();

            File secundariaGrado6= new File(ruta_storage+"/APP/4/", "5");
            secundariaGrado6.mkdir();
            

            File AccesoTipo4 = new File(ruta_storage+"/APP/", "5") ;

            AccesoTipo4.mkdir();

            File secundariaGrado7= new File(ruta_storage+"/APP/5/", "5");
            secundariaGrado7.mkdir();


            Secundaria_Storage();

        }
        return file;
    }

    private void Secundaria_Storage() {


        File mMenuPrincipal14= new File(ruta_storage+"/APP/3/"+grado+"/", "EXADM_ANUAL");
        File mMenuPrincipal15= new File(ruta_storage+"/APP/3/"+grado+"/", "PEADM_CAP");
        File mMenuPrincipal16= new File(ruta_storage+"/APP/3/"+grado+"/", "SIMULACRO_EXADM");

        File mExamenAnual1= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE1");
        File mExamenAnual2= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE2");
        File mExamenAnual3= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE3");
        File mExamenAnual4= new File(ruta_storage+"/APP/3/"+grado+"/EXADM_ANUAL/", "BIMESTRE4");

        File mSimulacroExam1= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE1");
        File mSimulacroExam2= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE2");
        File mSimulacroExam3= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE3");
        File mSimulacroExam4= new File(ruta_storage+"/APP/3/"+grado+"/SIMULACRO_EXADM/", "BIMESTRE4");

        File mPregExamCap1_1= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO1");
        File mPregExamCap1_2= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO2");
        File mPregExamCap1_3= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO3");
        File mPregExamCap1_4= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO4");
        File mPregExamCap1_5= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO5");
        File mPregExamCap1_6= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO6");
        File mPregExamCap1_7= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO7");
        File mPregExamCap1_8= new File(ruta_storage+"/APP/3/"+grado+"/PEADM_CAP/", "TOMO8");

        
        // ____________________________________________________________________________________________________________


        File mMenuPrincipal14SM= new File(ruta_storage+"/APP/4/5", "EXADM_ANUAL");
        File mMenuPrincipal15SM= new File(ruta_storage+"/APP/4/5/", "PEADM_CAP");
        File mMenuPrincipal16SM= new File(ruta_storage+"/APP/4/5/", "SIMULACRO_EXADM");

        File mExamenAnual1SM= new File(ruta_storage+"/APP/4/5/EXADM_ANUAL/", "BIMESTRE1");
        File mExamenAnual2SM= new File(ruta_storage+"/APP/4/5/EXADM_ANUAL/", "BIMESTRE2");
        File mExamenAnual3SM= new File(ruta_storage+"/APP/4/5/EXADM_ANUAL/", "BIMESTRE3");
        File mExamenAnual4SM= new File(ruta_storage+"/APP/4/5/EXADM_ANUAL/", "BIMESTRE4");

        File mSimulacroExam1SM= new File(ruta_storage+"/APP/4/5/SIMULACRO_EXADM/", "BIMESTRE1");
        File mSimulacroExam2SM= new File(ruta_storage+"/APP/4/5/SIMULACRO_EXADM/", "BIMESTRE2");
        File mSimulacroExam3SM= new File(ruta_storage+"/APP/4/5/SIMULACRO_EXADM/", "BIMESTRE3");
        File mSimulacroExam4SM= new File(ruta_storage+"/APP/4/5/SIMULACRO_EXADM/", "BIMESTRE4");

        File mPregExamCap1_1SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO1");
        File mPregExamCap1_2SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO2");
        File mPregExamCap1_3SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO3");
        File mPregExamCap1_4SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO4");
        File mPregExamCap1_5SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO5");
        File mPregExamCap1_6SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO6");
        File mPregExamCap1_7SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO7");
        File mPregExamCap1_8SM= new File(ruta_storage+"/APP/4/5/PEADM_CAP/", "TOMO8");

        //______________________________________________________________________________________________________________

        File mMenuPrincipal14CT= new File(ruta_storage+"/APP/5/5", "EXADM_ANUAL");
        File mMenuPrincipal15CT= new File(ruta_storage+"/APP/5/5/", "PEADM_CAP");
        File mMenuPrincipal16CT= new File(ruta_storage+"/APP/5/5/", "SIMULACRO_EXADM");

        File mExamenAnual1CT= new File(ruta_storage+"/APP/5/5/EXADM_ANUAL/", "BIMESTRE1");
        File mExamenAnual2CT= new File(ruta_storage+"/APP/5/5/EXADM_ANUAL/", "BIMESTRE2");
        File mExamenAnual3CT= new File(ruta_storage+"/APP/5/5/EXADM_ANUAL/", "BIMESTRE3");
        File mExamenAnual4CT= new File(ruta_storage+"/APP/5/5/EXADM_ANUAL/", "BIMESTRE4");

        File mSimulacroExam1CT= new File(ruta_storage+"/APP/5/5/SIMULACRO_EXADM/", "BIMESTRE1");
        File mSimulacroExam2CT= new File(ruta_storage+"/APP/5/5/SIMULACRO_EXADM/", "BIMESTRE2");
        File mSimulacroExam3CT= new File(ruta_storage+"/APP/5/5/SIMULACRO_EXADM/", "BIMESTRE3");
        File mSimulacroExam4CT= new File(ruta_storage+"/APP/5/5/SIMULACRO_EXADM/", "BIMESTRE4");

        File mPregExamCap1_1CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO1");
        File mPregExamCap1_2CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO2");
        File mPregExamCap1_3CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO3");
        File mPregExamCap1_4CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO4");
        File mPregExamCap1_5CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO5");
        File mPregExamCap1_6CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO6");
        File mPregExamCap1_7CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO7");
        File mPregExamCap1_8CT= new File(ruta_storage+"/APP/5/5/PEADM_CAP/", "TOMO8");


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
        
        
        //___________________________________________________________________________________________________________

        File mPregExamAdTomoCT1a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "ALGEBRA");
        File mPregExamAdTomoCT1b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "ARITMETICA");
        File mPregExamAdTomoCT1c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "ECONOMIA");
        File mPregExamAdTomoCT1d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "FISICA");
        File mPregExamAdTomoCT1e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "GEOGRAFIA");
        File mPregExamAdTomoCT1f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "GEOMETRIA");
        File mPregExamAdTomoCT1g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT1h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT1i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "LENGUAJE");
        File mPregExamAdTomoCT1j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "LITERATURA");
        File mPregExamAdTomoCT1k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "PSICOLOGIA");
        File mPregExamAdTomoCT1l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "QUIMICA");
        File mPregExamAdTomoCT1m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT1n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO1/", "TRIGONOMETRIA");


        File mPregExamAdTomoCT2a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "ALGEBRA");
        File mPregExamAdTomoCT2b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "ARITMETICA");
        File mPregExamAdTomoCT2c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "ECONOMIA");
        File mPregExamAdTomoCT2d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "FISICA");
        File mPregExamAdTomoCT2e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "GEOGRAFIA");
        File mPregExamAdTomoCT2f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "GEOMETRIA");
        File mPregExamAdTomoCT2g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT2h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT2i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "LENGUAJE");
        File mPregExamAdTomoCT2j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "LITERATURA");
        File mPregExamAdTomoCT2k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "PSICOLOGIA");
        File mPregExamAdTomoCT2l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "QUIMICA");
        File mPregExamAdTomoCT2m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT2n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO2/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoCT3a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "ALGEBRA");
        File mPregExamAdTomoCT3b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "ARITMETICA");
        File mPregExamAdTomoCT3c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "ECONOMIA");
        File mPregExamAdTomoCT3d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "FISICA");
        File mPregExamAdTomoCT3e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "GEOGRAFIA");
        File mPregExamAdTomoCT3f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "GEOMETRIA");
        File mPregExamAdTomoCT3g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT3h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT3i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "LENGUAJE");
        File mPregExamAdTomoCT3j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "LITERATURA");
        File mPregExamAdTomoCT3k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "PSICOLOGIA");
        File mPregExamAdTomoCT3l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "QUIMICA");
        File mPregExamAdTomoCT3m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT3n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO3/", "TRIGONOMETRIA");
        
        
        File mPregExamAdTomoCT4a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "ALGEBRA");
        File mPregExamAdTomoCT4b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "ARITMETICA");
        File mPregExamAdTomoCT4c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "ECONOMIA");
        File mPregExamAdTomoCT4d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "FISICA");
        File mPregExamAdTomoCT4e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "GEOGRAFIA");
        File mPregExamAdTomoCT4f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "GEOMETRIA");
        File mPregExamAdTomoCT4g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT4h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT4i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "LENGUAJE");
        File mPregExamAdTomoCT4j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "LITERATURA");
        File mPregExamAdTomoCT4k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "PSICOLOGIA");
        File mPregExamAdTomoCT4l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "QUIMICA");
        File mPregExamAdTomoCT4m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT4n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO4/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoCT5a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "ALGEBRA");
        File mPregExamAdTomoCT5b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "ARITMETICA");
        File mPregExamAdTomoCT5c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "ECONOMIA");
        File mPregExamAdTomoCT5d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "FISICA");
        File mPregExamAdTomoCT5e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "GEOGRAFIA");
        File mPregExamAdTomoCT5f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "GEOMETRIA");
        File mPregExamAdTomoCT5g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT5h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT5i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "LENGUAJE");
        File mPregExamAdTomoCT5j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "LITERATURA");
        File mPregExamAdTomoCT5k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "PSICOLOGIA");
        File mPregExamAdTomoCT5l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "QUIMICA");
        File mPregExamAdTomoCT5m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT5n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO5/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoCT6a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "ALGEBRA");
        File mPregExamAdTomoCT6b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "ARITMETICA");
        File mPregExamAdTomoCT6c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "ECONOMIA");
        File mPregExamAdTomoCT6d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "FISICA");
        File mPregExamAdTomoCT6e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "GEOGRAFIA");
        File mPregExamAdTomoCT6f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "GEOMETRIA");
        File mPregExamAdTomoCT6g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT6h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT6i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "LENGUAJE");
        File mPregExamAdTomoCT6j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "LITERATURA");
        File mPregExamAdTomoCT6k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "PSICOLOGIA");
        File mPregExamAdTomoCT6l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "QUIMICA");
        File mPregExamAdTomoCT6m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT6n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO6/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoCT7a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "ALGEBRA");
        File mPregExamAdTomoCT7b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "ARITMETICA");
        File mPregExamAdTomoCT7c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "ECONOMIA");
        File mPregExamAdTomoCT7d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "FISICA");
        File mPregExamAdTomoCT7e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "GEOGRAFIA");
        File mPregExamAdTomoCT7f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "GEOMETRIA");
        File mPregExamAdTomoCT7g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT7h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT7i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "LENGUAJE");
        File mPregExamAdTomoCT7j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "LITERATURA");
        File mPregExamAdTomoCT7k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "PSICOLOGIA");
        File mPregExamAdTomoCT7l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "QUIMICA");
        File mPregExamAdTomoCT7m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT7n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO7/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoCT8a= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "ALGEBRA");
        File mPregExamAdTomoCT8b= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "ARITMETICA");
        File mPregExamAdTomoCT8c= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "ECONOMIA");
        File mPregExamAdTomoCT8d= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "FISICA");
        File mPregExamAdTomoCT8e= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "GEOGRAFIA");
        File mPregExamAdTomoCT8f= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "GEOMETRIA");
        File mPregExamAdTomoCT8g= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoCT8h= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoCT8i= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "LENGUAJE");
        File mPregExamAdTomoCT8j= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "LITERATURA");
        File mPregExamAdTomoCT8k= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "PSICOLOGIA");
        File mPregExamAdTomoCT8l= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "QUIMICA");
        File mPregExamAdTomoCT8m= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoCT8n= new File(ruta_storage+"/APP/4/5/PEADM_CAP/TOMO8/", "TRIGONOMETRIA");

        //____________________________________________________________________________________________________________


        File mPregExamAdTomoSM1a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "ALGEBRA");
        File mPregExamAdTomoSM1b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "ARITMETICA");
        File mPregExamAdTomoSM1c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "ECONOMIA");
        File mPregExamAdTomoSM1d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "FISICA");
        File mPregExamAdTomoSM1e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "GEOGRAFIA");
        File mPregExamAdTomoSM1f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "GEOMETRIA");
        File mPregExamAdTomoSM1g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM1h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM1i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "LENGUAJE");
        File mPregExamAdTomoSM1j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "LITERATURA");
        File mPregExamAdTomoSM1k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "PSICOLOGIA");
        File mPregExamAdTomoSM1l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "QUIMICA");
        File mPregExamAdTomoSM1m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM1n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO1/", "TRIGONOMETRIA");


        File mPregExamAdTomoSM2a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "ALGEBRA");
        File mPregExamAdTomoSM2b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "ARITMETICA");
        File mPregExamAdTomoSM2c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "ECONOMIA");
        File mPregExamAdTomoSM2d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "FISICA");
        File mPregExamAdTomoSM2e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "GEOGRAFIA");
        File mPregExamAdTomoSM2f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "GEOMETRIA");
        File mPregExamAdTomoSM2g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM2h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM2i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "LENGUAJE");
        File mPregExamAdTomoSM2j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "LITERATURA");
        File mPregExamAdTomoSM2k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "PSICOLOGIA");
        File mPregExamAdTomoSM2l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "QUIMICA");
        File mPregExamAdTomoSM2m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM2n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO2/", "TRIGONOMETRIA");



        File mPregExamAdTomoSM3a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "ALGEBRA");
        File mPregExamAdTomoSM3b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "ARITMETICA");
        File mPregExamAdTomoSM3c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "ECONOMIA");
        File mPregExamAdTomoSM3d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "FISICA");
        File mPregExamAdTomoSM3e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "GEOGRAFIA");
        File mPregExamAdTomoSM3f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "GEOMETRIA");
        File mPregExamAdTomoSM3g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM3h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM3i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "LENGUAJE");
        File mPregExamAdTomoSM3j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "LITERATURA");
        File mPregExamAdTomoSM3k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "PSICOLOGIA");
        File mPregExamAdTomoSM3l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "QUIMICA");
        File mPregExamAdTomoSM3m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM3n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO3/", "TRIGONOMETRIA");


        File mPregExamAdTomoSM4a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "ALGEBRA");
        File mPregExamAdTomoSM4b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "ARITMETICA");
        File mPregExamAdTomoSM4c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "ECONOMIA");
        File mPregExamAdTomoSM4d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "FISICA");
        File mPregExamAdTomoSM4e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "GEOGRAFIA");
        File mPregExamAdTomoSM4f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "GEOMETRIA");
        File mPregExamAdTomoSM4g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM4h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM4i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "LENGUAJE");
        File mPregExamAdTomoSM4j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "LITERATURA");
        File mPregExamAdTomoSM4k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "PSICOLOGIA");
        File mPregExamAdTomoSM4l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "QUIMICA");
        File mPregExamAdTomoSM4m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM4n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO4/", "TRIGONOMETRIA"); 
        
        File mPregExamAdTomoSM5a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "ALGEBRA");
        File mPregExamAdTomoSM5b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "ARITMETICA");
        File mPregExamAdTomoSM5c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "ECONOMIA");
        File mPregExamAdTomoSM5d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "FISICA");
        File mPregExamAdTomoSM5e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "GEOGRAFIA");
        File mPregExamAdTomoSM5f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "GEOMETRIA");
        File mPregExamAdTomoSM5g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM5h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM5i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "LENGUAJE");
        File mPregExamAdTomoSM5j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "LITERATURA");
        File mPregExamAdTomoSM5k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "PSICOLOGIA");
        File mPregExamAdTomoSM5l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "QUIMICA");
        File mPregExamAdTomoSM5m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM5n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO5/", "TRIGONOMETRIA"); 
        
        File mPregExamAdTomoSM6a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "ALGEBRA");
        File mPregExamAdTomoSM6b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "ARITMETICA");
        File mPregExamAdTomoSM6c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "ECONOMIA");
        File mPregExamAdTomoSM6d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "FISICA");
        File mPregExamAdTomoSM6e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "GEOGRAFIA");
        File mPregExamAdTomoSM6f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "GEOMETRIA");
        File mPregExamAdTomoSM6g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM6h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM6i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "LENGUAJE");
        File mPregExamAdTomoSM6j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "LITERATURA");
        File mPregExamAdTomoSM6k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "PSICOLOGIA");
        File mPregExamAdTomoSM6l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "QUIMICA");
        File mPregExamAdTomoSM6m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM6n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO6/", "TRIGONOMETRIA");
        
        File mPregExamAdTomoSM7a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "ALGEBRA");
        File mPregExamAdTomoSM7b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "ARITMETICA");
        File mPregExamAdTomoSM7c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "ECONOMIA");
        File mPregExamAdTomoSM7d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "FISICA");
        File mPregExamAdTomoSM7e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "GEOGRAFIA");
        File mPregExamAdTomoSM7f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "GEOMETRIA");
        File mPregExamAdTomoSM7g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM7h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM7i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "LENGUAJE");
        File mPregExamAdTomoSM7j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "LITERATURA");
        File mPregExamAdTomoSM7k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "PSICOLOGIA");
        File mPregExamAdTomoSM7l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "QUIMICA");
        File mPregExamAdTomoSM7m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM7n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO7/", "TRIGONOMETRIA");
        
         File mPregExamAdTomoSM8a= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "ALGEBRA");
        File mPregExamAdTomoSM8b= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "ARITMETICA");
        File mPregExamAdTomoSM8c= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "ECONOMIA");
        File mPregExamAdTomoSM8d= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "FISICA");
        File mPregExamAdTomoSM8e= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "GEOGRAFIA");
        File mPregExamAdTomoSM8f= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "GEOMETRIA");
        File mPregExamAdTomoSM8g= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "HISTORIA_DEL_PERU");
        File mPregExamAdTomoSM8h= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "HISTORIA_UNIVERSAL");
        File mPregExamAdTomoSM8i= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "LENGUAJE");
        File mPregExamAdTomoSM8j= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "LITERATURA");
        File mPregExamAdTomoSM8k= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "PSICOLOGIA");
        File mPregExamAdTomoSM8l= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "QUIMICA");
        File mPregExamAdTomoSM8m= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mPregExamAdTomoSM8n= new File(ruta_storage+"/APP/5/5/PEADM_CAP/TOMO8/", "TRIGONOMETRIA");
        
        
        //____________________________________________________________________________________________________________

        mMenuPrincipal14.mkdir();
        mMenuPrincipal15.mkdir();
        mMenuPrincipal16.mkdir();

        mPregExamCap1_1.mkdir();
        mPregExamCap1_2.mkdir();
        mPregExamCap1_3.mkdir();
        mPregExamCap1_4.mkdir();
        mPregExamCap1_5.mkdir();
        mPregExamCap1_6.mkdir();
        mPregExamCap1_7.mkdir();
        mPregExamCap1_8.mkdir();
        mExamenAnual1.mkdir();
        mExamenAnual2.mkdir();
        mExamenAnual3.mkdir();
        mExamenAnual4.mkdir();

        mSimulacroExam1.mkdir();
        mSimulacroExam2.mkdir();
        mSimulacroExam3.mkdir();
        mSimulacroExam4.mkdir();


        mMenuPrincipal14SM.mkdir();
        mMenuPrincipal15SM.mkdir();
        mMenuPrincipal16SM.mkdir();

        mPregExamCap1_1SM.mkdir();
        mPregExamCap1_2SM.mkdir();
        mPregExamCap1_3SM.mkdir();
        mPregExamCap1_4SM.mkdir();
        mPregExamCap1_5SM.mkdir();
        mPregExamCap1_6SM.mkdir();
        mPregExamCap1_7SM.mkdir();
        mPregExamCap1_8SM.mkdir();
        mExamenAnual1SM.mkdir();
        mExamenAnual2SM.mkdir();
        mExamenAnual3SM.mkdir();
        mExamenAnual4SM.mkdir();

        mSimulacroExam1SM.mkdir();
        mSimulacroExam2SM.mkdir();
        mSimulacroExam3SM.mkdir();
        mSimulacroExam4SM.mkdir();



        mMenuPrincipal14CT.mkdir();
        mMenuPrincipal15CT.mkdir();
        mMenuPrincipal16CT.mkdir();

        mPregExamCap1_1CT.mkdir();
        mPregExamCap1_2CT.mkdir();
        mPregExamCap1_3CT.mkdir();
        mPregExamCap1_4CT.mkdir();
        mPregExamCap1_5CT.mkdir();
        mPregExamCap1_6CT.mkdir();
        mPregExamCap1_7CT.mkdir();
        mPregExamCap1_8CT.mkdir();
        mExamenAnual1CT.mkdir();
        mExamenAnual2CT.mkdir();
        mExamenAnual3CT.mkdir();
        mExamenAnual4CT.mkdir();

        mSimulacroExam1CT.mkdir();
        mSimulacroExam2CT.mkdir();
        mSimulacroExam3CT.mkdir();
        mSimulacroExam4CT.mkdir();



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
        
        //---


        mPregExamAdTomoSM1a.mkdir();
        mPregExamAdTomoSM1b.mkdir();
        mPregExamAdTomoSM1c.mkdir();
        mPregExamAdTomoSM1d.mkdir();
        mPregExamAdTomoSM1e.mkdir();
        mPregExamAdTomoSM1f.mkdir();
        mPregExamAdTomoSM1g.mkdir();
        mPregExamAdTomoSM1h.mkdir();
        mPregExamAdTomoSM1i.mkdir();
        mPregExamAdTomoSM1j.mkdir();
        mPregExamAdTomoSM1k.mkdir();
        mPregExamAdTomoSM1l.mkdir();
        mPregExamAdTomoSM1m.mkdir();
        mPregExamAdTomoSM1n.mkdir();

        mPregExamAdTomoSM2a.mkdir();
        mPregExamAdTomoSM2b.mkdir();
        mPregExamAdTomoSM2c.mkdir();
        mPregExamAdTomoSM2d.mkdir();
        mPregExamAdTomoSM2e.mkdir();
        mPregExamAdTomoSM2f.mkdir();
        mPregExamAdTomoSM2g.mkdir();
        mPregExamAdTomoSM2h.mkdir();
        mPregExamAdTomoSM2i.mkdir();
        mPregExamAdTomoSM2j.mkdir();
        mPregExamAdTomoSM2k.mkdir();
        mPregExamAdTomoSM2l.mkdir();
        mPregExamAdTomoSM2m.mkdir();
        mPregExamAdTomoSM2n.mkdir();

        mPregExamAdTomoSM3a.mkdir();
        mPregExamAdTomoSM3b.mkdir();
        mPregExamAdTomoSM3c.mkdir();
        mPregExamAdTomoSM3d.mkdir();
        mPregExamAdTomoSM3e.mkdir();
        mPregExamAdTomoSM3f.mkdir();
        mPregExamAdTomoSM3g.mkdir();
        mPregExamAdTomoSM3h.mkdir();
        mPregExamAdTomoSM3i.mkdir();
        mPregExamAdTomoSM3j.mkdir();
        mPregExamAdTomoSM3k.mkdir();
        mPregExamAdTomoSM3l.mkdir();
        mPregExamAdTomoSM3m.mkdir();
        mPregExamAdTomoSM3n.mkdir();

        mPregExamAdTomoSM4a.mkdir();
        mPregExamAdTomoSM4b.mkdir();
        mPregExamAdTomoSM4c.mkdir();
        mPregExamAdTomoSM4d.mkdir();
        mPregExamAdTomoSM4e.mkdir();
        mPregExamAdTomoSM4f.mkdir();
        mPregExamAdTomoSM4g.mkdir();
        mPregExamAdTomoSM4h.mkdir();
        mPregExamAdTomoSM4i.mkdir();
        mPregExamAdTomoSM4j.mkdir();
        mPregExamAdTomoSM4k.mkdir();
        mPregExamAdTomoSM4l.mkdir();
        mPregExamAdTomoSM4m.mkdir();
        mPregExamAdTomoSM4n.mkdir();

        mPregExamAdTomoSM5a.mkdir();
        mPregExamAdTomoSM5b.mkdir();
        mPregExamAdTomoSM5c.mkdir();
        mPregExamAdTomoSM5d.mkdir();
        mPregExamAdTomoSM5e.mkdir();
        mPregExamAdTomoSM5f.mkdir();
        mPregExamAdTomoSM5g.mkdir();
        mPregExamAdTomoSM5h.mkdir();
        mPregExamAdTomoSM5i.mkdir();
        mPregExamAdTomoSM5j.mkdir();
        mPregExamAdTomoSM5k.mkdir();
        mPregExamAdTomoSM5l.mkdir();
        mPregExamAdTomoSM5m.mkdir();
        mPregExamAdTomoSM5n.mkdir();

        mPregExamAdTomoSM6a.mkdir();
        mPregExamAdTomoSM6b.mkdir();
        mPregExamAdTomoSM6c.mkdir();
        mPregExamAdTomoSM6d.mkdir();
        mPregExamAdTomoSM6e.mkdir();
        mPregExamAdTomoSM6f.mkdir();
        mPregExamAdTomoSM6g.mkdir();
        mPregExamAdTomoSM6h.mkdir();
        mPregExamAdTomoSM6i.mkdir();
        mPregExamAdTomoSM6j.mkdir();
        mPregExamAdTomoSM6k.mkdir();
        mPregExamAdTomoSM6l.mkdir();
        mPregExamAdTomoSM6m.mkdir();
        mPregExamAdTomoSM6n.mkdir();

        mPregExamAdTomoSM7a.mkdir();
        mPregExamAdTomoSM7b.mkdir();
        mPregExamAdTomoSM7c.mkdir();
        mPregExamAdTomoSM7d.mkdir();
        mPregExamAdTomoSM7e.mkdir();
        mPregExamAdTomoSM7f.mkdir();
        mPregExamAdTomoSM7g.mkdir();
        mPregExamAdTomoSM7h.mkdir();
        mPregExamAdTomoSM7i.mkdir();
        mPregExamAdTomoSM7j.mkdir();
        mPregExamAdTomoSM7k.mkdir();
        mPregExamAdTomoSM7l.mkdir();
        mPregExamAdTomoSM7m.mkdir();
        mPregExamAdTomoSM7n.mkdir();

        mPregExamAdTomoSM8a.mkdir();
        mPregExamAdTomoSM8b.mkdir();
        mPregExamAdTomoSM8c.mkdir();
        mPregExamAdTomoSM8d.mkdir();
        mPregExamAdTomoSM8e.mkdir();
        mPregExamAdTomoSM8f.mkdir();
        mPregExamAdTomoSM8g.mkdir();
        mPregExamAdTomoSM8h.mkdir();
        mPregExamAdTomoSM8i.mkdir();
        mPregExamAdTomoSM8j.mkdir();
        mPregExamAdTomoSM8k.mkdir();
        mPregExamAdTomoSM8l.mkdir();
        mPregExamAdTomoSM8m.mkdir();
        mPregExamAdTomoSM8n.mkdir();
        
        
        //----

        mPregExamAdTomoCT1a.mkdir();
        mPregExamAdTomoCT1b.mkdir();
        mPregExamAdTomoCT1c.mkdir();
        mPregExamAdTomoCT1d.mkdir();
        mPregExamAdTomoCT1e.mkdir();
        mPregExamAdTomoCT1f.mkdir();
        mPregExamAdTomoCT1g.mkdir();
        mPregExamAdTomoCT1h.mkdir();
        mPregExamAdTomoCT1i.mkdir();
        mPregExamAdTomoCT1j.mkdir();
        mPregExamAdTomoCT1k.mkdir();
        mPregExamAdTomoCT1l.mkdir();
        mPregExamAdTomoCT1m.mkdir();
        mPregExamAdTomoCT1n.mkdir();

        mPregExamAdTomoCT2a.mkdir();
        mPregExamAdTomoCT2b.mkdir();
        mPregExamAdTomoCT2c.mkdir();
        mPregExamAdTomoCT2d.mkdir();
        mPregExamAdTomoCT2e.mkdir();
        mPregExamAdTomoCT2f.mkdir();
        mPregExamAdTomoCT2g.mkdir();
        mPregExamAdTomoCT2h.mkdir();
        mPregExamAdTomoCT2i.mkdir();
        mPregExamAdTomoCT2j.mkdir();
        mPregExamAdTomoCT2k.mkdir();
        mPregExamAdTomoCT2l.mkdir();
        mPregExamAdTomoCT2m.mkdir();
        mPregExamAdTomoCT2n.mkdir();

        mPregExamAdTomoCT3a.mkdir();
        mPregExamAdTomoCT3b.mkdir();
        mPregExamAdTomoCT3c.mkdir();
        mPregExamAdTomoCT3d.mkdir();
        mPregExamAdTomoCT3e.mkdir();
        mPregExamAdTomoCT3f.mkdir();
        mPregExamAdTomoCT3g.mkdir();
        mPregExamAdTomoCT3h.mkdir();
        mPregExamAdTomoCT3i.mkdir();
        mPregExamAdTomoCT3j.mkdir();
        mPregExamAdTomoCT3k.mkdir();
        mPregExamAdTomoCT3l.mkdir();
        mPregExamAdTomoCT3m.mkdir();
        mPregExamAdTomoCT3n.mkdir();

        mPregExamAdTomoCT4a.mkdir();
        mPregExamAdTomoCT4b.mkdir();
        mPregExamAdTomoCT4c.mkdir();
        mPregExamAdTomoCT4d.mkdir();
        mPregExamAdTomoCT4e.mkdir();
        mPregExamAdTomoCT4f.mkdir();
        mPregExamAdTomoCT4g.mkdir();
        mPregExamAdTomoCT4h.mkdir();
        mPregExamAdTomoCT4i.mkdir();
        mPregExamAdTomoCT4j.mkdir();
        mPregExamAdTomoCT4k.mkdir();
        mPregExamAdTomoCT4l.mkdir();
        mPregExamAdTomoCT4m.mkdir();
        mPregExamAdTomoCT4n.mkdir();

        mPregExamAdTomoCT5a.mkdir();
        mPregExamAdTomoCT5b.mkdir();
        mPregExamAdTomoCT5c.mkdir();
        mPregExamAdTomoCT5d.mkdir();
        mPregExamAdTomoCT5e.mkdir();
        mPregExamAdTomoCT5f.mkdir();
        mPregExamAdTomoCT5g.mkdir();
        mPregExamAdTomoCT5h.mkdir();
        mPregExamAdTomoCT5i.mkdir();
        mPregExamAdTomoCT5j.mkdir();
        mPregExamAdTomoCT5k.mkdir();
        mPregExamAdTomoCT5l.mkdir();
        mPregExamAdTomoCT5m.mkdir();
        mPregExamAdTomoCT5n.mkdir();

        mPregExamAdTomoCT6a.mkdir();
        mPregExamAdTomoCT6b.mkdir();
        mPregExamAdTomoCT6c.mkdir();
        mPregExamAdTomoCT6d.mkdir();
        mPregExamAdTomoCT6e.mkdir();
        mPregExamAdTomoCT6f.mkdir();
        mPregExamAdTomoCT6g.mkdir();
        mPregExamAdTomoCT6h.mkdir();
        mPregExamAdTomoCT6i.mkdir();
        mPregExamAdTomoCT6j.mkdir();
        mPregExamAdTomoCT6k.mkdir();
        mPregExamAdTomoCT6l.mkdir();
        mPregExamAdTomoCT6m.mkdir();
        mPregExamAdTomoCT6n.mkdir();

        mPregExamAdTomoCT7a.mkdir();
        mPregExamAdTomoCT7b.mkdir();
        mPregExamAdTomoCT7c.mkdir();
        mPregExamAdTomoCT7d.mkdir();
        mPregExamAdTomoCT7e.mkdir();
        mPregExamAdTomoCT7f.mkdir();
        mPregExamAdTomoCT7g.mkdir();
        mPregExamAdTomoCT7h.mkdir();
        mPregExamAdTomoCT7i.mkdir();
        mPregExamAdTomoCT7j.mkdir();
        mPregExamAdTomoCT7k.mkdir();
        mPregExamAdTomoCT7l.mkdir();
        mPregExamAdTomoCT7m.mkdir();
        mPregExamAdTomoCT7n.mkdir();

        mPregExamAdTomoCT8a.mkdir();
        mPregExamAdTomoCT8b.mkdir();
        mPregExamAdTomoCT8c.mkdir();
        mPregExamAdTomoCT8d.mkdir();
        mPregExamAdTomoCT8e.mkdir();
        mPregExamAdTomoCT8f.mkdir();
        mPregExamAdTomoCT8g.mkdir();
        mPregExamAdTomoCT8h.mkdir();
        mPregExamAdTomoCT8i.mkdir();
        mPregExamAdTomoCT8j.mkdir();
        mPregExamAdTomoCT8k.mkdir();
        mPregExamAdTomoCT8l.mkdir();
        mPregExamAdTomoCT8m.mkdir();
        mPregExamAdTomoCT8n.mkdir();

    }


    @Override
    public void enviargrado(String mensaje) {
        gradoalumno= mensaje;
    }


}

