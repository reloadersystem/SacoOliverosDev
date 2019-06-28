package pe.sacooliveros.apptablet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class DirectoryUtilCatolica extends AppCompatActivity implements EnviarGrado {

    String ruta_storage;
    String gradoalumno = "";
    String grado;

    public void verResourceString(Context context) {
        ruta_storage = context.getString(R.string.ruta_raiz);
    }

    public void verGradoSec(String gradoencurso) {

        grado = gradoencurso.substring(0, 1);
        //grado= "5";
    }


    public File createCarpetas(String filename) {

        File file = new File(filename);


        if (!file.exists()) {


            file.mkdirs();

            File AccesoTipo2 = new File(ruta_storage + "/APP/", "5");

            AccesoTipo2.mkdir();

            File secundariaGrado5 = new File(ruta_storage + "/APP/5/", "5");

            secundariaGrado5.mkdir();

            Secundaria_Storage();

        }
        return file;
    }

    private void Secundaria_Storage() {


        //APP/5/5/EXADM_ANUAL/BIMESTRE4/
        //http://app8.sacooliveros.edu.pe/APP/5/5/PEADM_CAP/

        File mMenuPrincipal1 = new File(ruta_storage + "/APP/5/" + grado + "/", "AJEDREZ");
        File mMenuPrincipal2 = new File(ruta_storage + "/APP/5/" + grado + "/", "COMPENDIOS");
        File mMenuPrincipal4 = new File(ruta_storage + "/APP/5/" + grado + "/", "EDUCACION_FISICA");
        File mMenuPrincipal5 = new File(ruta_storage + "/APP/5/" + grado + "/", "HELICO_BALOTARIO");
        File mMenuPrincipal6 = new File(ruta_storage + "/APP/5/" + grado + "/", "HELICO_DIAPOSITIVAS");
        File mMenuPrincipal7 = new File(ruta_storage + "/APP/5/" + grado + "/", "HELICO_ENGLISH");
        File mMenuPrincipal8 = new File(ruta_storage + "/APP/5/" + grado + "/", "MEDITACION");
        File mMenuPrincipal10 = new File(ruta_storage + "/APP/5/" + grado + "/", "PRINCIPIOS_FMATEMATICA");
        File mMenuPrincipal13 = new File(ruta_storage + "/APP/5/" + grado + "/", "COMPENDIOS");
        File mMenuPrincipal18 = new File(ruta_storage + "/APP/5/" + grado + "/", "VIDEO_HELICO_MOTIVADORES");

        File mMenuPrincipal14 = new File(ruta_storage + "/APP/5/" + grado + "/", "EXADM_ANUAL");
        File mMenuPrincipal15 = new File(ruta_storage + "/APP/5/" + grado + "/", "PEADM_CAP");

        File mMenuPrincipal16 = new File(ruta_storage + "/APP/5/" + grado + "/", "SIMULACRO_EXADM");
        File mMenuPrincipal17 = new File(ruta_storage + "/APP/5/" + grado + "/", "LECTURAS_MOTIVADORAS");




        File mPrincMatematico1 = new File(ruta_storage + "/APP/5/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE1");
        File mPrincMatematico2 = new File(ruta_storage + "/APP/5/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE2");
        File mPrincMatematico3 = new File(ruta_storage + "/APP/5/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE3");
        File mPrincMatematico4 = new File(ruta_storage + "/APP/5/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE4");


        //http://192.169.218.177/APP/5/5/LECTURAS_MOTIVADORAS/BIMESTRE1/LECTURA_CRITICA/LECTURA_CRITICA_B1.pdf

        File mLecturasMotivadoras1 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/", "BIMESTRE1");
        File mLecturasMotivadoras2 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/", "BIMESTRE2");
        File mLecturasMotivadoras3 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/", "BIMESTRE3");
        File mLecturasMotivadoras4 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/", "BIMESTRE4");




        File mLecturasBimestre1M1 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE1", "REDACCION_DELENGUAJE");
        File mLecturasBimestre1M2 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE1", "LECTURA_CRITICA");
        File mLecturasBimestre1M3 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE1", "COMPRENSION_LECTORA");
        File mLecturasBimestre1M4 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE1", "ILATIVOS_DELENGUAJE");







        File mLecturasBimestre2M1 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE2", "REDACCION_DELENGUAJE");
        File mLecturasBimestre2M2 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE2", "LECTURA_CRITICA");
        File mLecturasBimestre2M3 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE2", "COMPRENSION_LECTORA");
        File mLecturasBimestre2M4 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE2", "ILATIVOS_DELENGUAJE");


        File mLecturasBimestre3M1 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE3", "REDACCION_DELENGUAJE");
        File mLecturasBimestre3M2 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE3", "LECTURA_CRITICA");
        File mLecturasBimestre3M3 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE3", "COMPRENSION_LECTORA");
        File mLecturasBimestre3M4 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE3", "ILATIVOS_DELENGUAJE");

        File mLecturasBimestre4M1 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE4", "REDACCION_DELENGUAJE");
        File mLecturasBimestre4M2 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE4", "LECTURA_CRITICA");
        File mLecturasBimestre4M3 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE4", "COMPRENSION_LECTORA");
        File mLecturasBimestre4M4 = new File(ruta_storage + "/APP/5/" + grado + "/LECTURAS_MOTIVADORAS/BIMESTRE4", "ILATIVOS_DELENGUAJE");








        File mExamenAnual1 = new File(ruta_storage + "/APP/5/" + grado + "/EXADM_ANUAL/", "BIMESTRE1");
        File mExamenAnual2 = new File(ruta_storage + "/APP/5/" + grado + "/EXADM_ANUAL/", "BIMESTRE2");
        File mExamenAnual3 = new File(ruta_storage + "/APP/5/" + grado + "/EXADM_ANUAL/", "BIMESTRE3");
        File mExamenAnual4 = new File(ruta_storage + "/APP/5/" + grado + "/EXADM_ANUAL/", "BIMESTRE4");


        File mSimulacroExam1 = new File(ruta_storage + "/APP/5/" + grado + "/SIMULACRO_EXADM/", "BIMESTRE1");
        File mSimulacroExam2 = new File(ruta_storage + "/APP/5/" + grado + "/SIMULACRO_EXADM/", "BIMESTRE2");
        File mSimulacroExam3 = new File(ruta_storage + "/APP/5/" + grado + "/SIMULACRO_EXADM/", "BIMESTRE3");
        File mSimulacroExam4 = new File(ruta_storage + "/APP/5/" + grado + "/SIMULACRO_EXADM/", "BIMESTRE4");

        File mHDiapositivas1_1 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO1");
        File mHDiapositivas1_2 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO2");
        File mHDiapositivas1_3 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO3");
        File mHDiapositivas1_4 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO4");
        File mHDiapositivas1_5 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO5");
        File mHDiapositivas1_6 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO6");
        File mHDiapositivas1_7 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO7");
        File mHDiapositivas1_8 = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO8");


        File mPregExamCap1_1 = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/", "BIMESTRE1");
        File mPregExamCap1_2 = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/", "BIMESTRE2");
        File mPregExamCap1_3 = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/", "BIMESTRE3");
        File mPregExamCap1_4 = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/", "BIMESTRE4");


        // ___________________________________________________________________________________________________________

        File mPregExamAdTomo1a = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "COMPRENSION_LECTORA");
        File mPregExamAdTomo1b = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "ESTADISTICA");
        File mPregExamAdTomo1c = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "ILATIVOS_DELENGUAJE");
        File mPregExamAdTomo1d = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "LECTURA_CRITICA");
        File mPregExamAdTomo1e = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "NUMERO_OPERACIONES");
        File mPregExamAdTomo1f = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "PLANIMETRIA");
        File mPregExamAdTomo1g = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "PROGRAMACION_LINEAL");
        File mPregExamAdTomo1h = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "REDACCION_DELENGUAJE");
        File mPregExamAdTomo1i = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE1/", "ANALISIS_ABSTRACCION");


        File mPregExamAdTomo2a = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "COMPRENSION_LECTORA");
        File mPregExamAdTomo2b = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "ESTADISTICA");
        File mPregExamAdTomo2c = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "ILATIVOS_DELENGUAJE");
        File mPregExamAdTomo2d = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "LECTURA_CRITICA");
        File mPregExamAdTomo2e = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "NUMERO_OPERACIONES");
        File mPregExamAdTomo2f = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "PLANIMETRIA");
        File mPregExamAdTomo2g = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "PROGRAMACION_LINEAL");
        File mPregExamAdTomo2h = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "REDACCION_DELENGUAJE");
        File mPregExamAdTomo2i = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "ANALISIS_ABSTRACCION");


        File mPregExamAdTomo3a = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE2/", "COMPRENSION_LECTORA");
        File mPregExamAdTomo3b = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "ESTADISTICA");
        File mPregExamAdTomo3c = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "ILATIVOS_DELENGUAJE");
        File mPregExamAdTomo3d = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "LECTURA_CRITICA");
        File mPregExamAdTomo3e = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "NUMERO_OPERACIONES");
        File mPregExamAdTomo3f = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "PLANIMETRIA");
        File mPregExamAdTomo3g = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "PROGRAMACION_LINEAL");
        File mPregExamAdTomo3h = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "REDACCION_DELENGUAJE");
        File mPregExamAdTomo3i = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE3/", "ANALISIS_ABSTRACCION");


        File mPregExamAdTomo4a = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "COMPRENSION_LECTORA");
        File mPregExamAdTomo4b = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "ESTADISTICA");
        File mPregExamAdTomo4c = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "ILATIVOS_DELENGUAJE");
        File mPregExamAdTomo4d = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "LECTURA_CRITICA");
        File mPregExamAdTomo4e = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "NUMERO_OPERACIONES");
        File mPregExamAdTomo4f = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "PLANIMETRIA");
        File mPregExamAdTomo4g = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "PROGRAMACION_LINEAL");
        File mPregExamAdTomo4h = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "REDACCION_DELENGUAJE");
        File mPregExamAdTomo4i = new File(ruta_storage + "/APP/5/" + grado + "/PEADM_CAP/BIMESTRE4/", "ANALISIS_ABSTRACCION");


        //____________________________________________________________________________________________________________


        File mCompendio1_1 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO1");
        File mCompendio1_2 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO2");
        File mCompendio1_3 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO3");
        File mCompendio1_4 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO4");
        File mCompendio1_5 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO5");
        File mCompendio1_6 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO6");
        File mCompendio1_7 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO7");
        File mCompendio1_8 = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/", "TOMO8");


        File mVideoMotivador1_1 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO1");
        File mVideoMotivador1_2 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO2");
        File mVideoMotivador1_3 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO3");
        File mVideoMotivador1_4 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO4");
        File mVideoMotivador1_5 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO5");
        File mVideoMotivador1_6 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO6");
        File mVideoMotivador1_7 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO7");
        File mVideoMotivador1_8 = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/", "TOMO8");


        File mCompendioTomo1a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "ALGEBRA");
        File mCompendioTomo1b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "ARITMETICA");
        File mCompendioTomo1c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "BIOLOGIA");
        File mCompendioTomo1d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "ECONOMIA");
        File mCompendioTomo1e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "FISICA");
        File mCompendioTomo1f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "GEOGRAFIA");
        File mCompendioTomo1g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "GEOMETRIA");
        File mCompendioTomo1h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "HISTORIA_DEL_PERU");
        File mCompendioTomo1i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo1j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "LENGUAJE");
        File mCompendioTomo1k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "LITERATURA");
        File mCompendioTomo1l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "PSICOLOGIA");
        File mCompendioTomo1m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "QUIMICA");
        File mCompendioTomo1n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo1o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo1p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO1/", "TRIGONOMETRIA");


        File mCompendioTomo2a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "ALGEBRA");
        File mCompendioTomo2b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "ARITMETICA");
        File mCompendioTomo2c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "BIOLOGIA");
        File mCompendioTomo2d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "ECONOMIA");
        File mCompendioTomo2e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "FISICA");
        File mCompendioTomo2f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "GEOGRAFIA");
        File mCompendioTomo2g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "GEOMETRIA");
        File mCompendioTomo2h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "HISTORIA_DEL_PERU");
        File mCompendioTomo2i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo2j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "LENGUAJE");
        File mCompendioTomo2k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "LITERATURA");
        File mCompendioTomo2l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "PSICOLOGIA");
        File mCompendioTomo2m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "QUIMICA");
        File mCompendioTomo2n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo2o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo2p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO2/", "TRIGONOMETRIA");

        File mCompendioTomo3a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "ALGEBRA");
        File mCompendioTomo3b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "ARITMETICA");
        File mCompendioTomo3c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "BIOLOGIA");
        File mCompendioTomo3d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "ECONOMIA");
        File mCompendioTomo3e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "FISICA");
        File mCompendioTomo3f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "GEOGRAFIA");
        File mCompendioTomo3g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "GEOMETRIA");
        File mCompendioTomo3h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "HISTORIA_DEL_PERU");
        File mCompendioTomo3i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo3j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "LENGUAJE");
        File mCompendioTomo3k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "LITERATURA");
        File mCompendioTomo3l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "PSICOLOGIA");
        File mCompendioTomo3m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo3p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo3q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO3/", "TRIGONOMETRIA");

        File mCompendioTomo4a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "ALGEBRA");
        File mCompendioTomo4b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "ARITMETICA");
        File mCompendioTomo4c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "BIOLOGIA");
        File mCompendioTomo4d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "ECONOMIA");
        File mCompendioTomo4e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "FISICA");
        File mCompendioTomo4f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "GEOGRAFIA");
        File mCompendioTomo4g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "GEOMETRIA");
        File mCompendioTomo4h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "HISTORIA_DEL_PERU");
        File mCompendioTomo4i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo4j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "LENGUAJE");
        File mCompendioTomo4k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "LITERATURA");
        File mCompendioTomo4l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "PSICOLOGIA");
        File mCompendioTomo4m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo4p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo4q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO4/", "TRIGONOMETRIA");

        File mCompendioTomo5a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "ALGEBRA");
        File mCompendioTomo5b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "ARITMETICA");
        File mCompendioTomo5c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "BIOLOGIA");
        File mCompendioTomo5d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "ECONOMIA");
        File mCompendioTomo5e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "FISICA");
        File mCompendioTomo5f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "GEOGRAFIA");
        File mCompendioTomo5g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "GEOMETRIA");
        File mCompendioTomo5h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "HISTORIA_DEL_PERU");
        File mCompendioTomo5i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo5j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "LENGUAJE");
        File mCompendioTomo5k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "LITERATURA");
        File mCompendioTomo5l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "PSICOLOGIA");
        File mCompendioTomo5m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo5p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo5q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO5/", "TRIGONOMETRIA");


        File mCompendioTomo6a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "ALGEBRA");
        File mCompendioTomo6b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "ARITMETICA");
        File mCompendioTomo6c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "BIOLOGIA");
        File mCompendioTomo6d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "ECONOMIA");
        File mCompendioTomo6e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "FISICA");
        File mCompendioTomo6f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "GEOGRAFIA");
        File mCompendioTomo6g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "GEOMETRIA");
        File mCompendioTomo6h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "HISTORIA_DEL_PERU");
        File mCompendioTomo6i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo6j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "LENGUAJE");
        File mCompendioTomo6k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "LITERATURA");
        File mCompendioTomo6l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "PSICOLOGIA");
        File mCompendioTomo6m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo6p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo6q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO6/", "TRIGONOMETRIA");

        File mCompendioTomo7a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "ALGEBRA");
        File mCompendioTomo7b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "ARITMETICA");
        File mCompendioTomo7c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "BIOLOGIA");
        File mCompendioTomo7d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "ECONOMIA");
        File mCompendioTomo7e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "FISICA");
        File mCompendioTomo7f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "GEOGRAFIA");
        File mCompendioTomo7g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "GEOMETRIA");
        File mCompendioTomo7h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "HISTORIA_DEL_PERU");
        File mCompendioTomo7i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo7j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "LENGUAJE");
        File mCompendioTomo7k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "LITERATURA");
        File mCompendioTomo7l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "PSICOLOGIA");
        File mCompendioTomo7m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo7p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo7q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO7/", "TRIGONOMETRIA");

        File mCompendioTomo8a = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "ALGEBRA");
        File mCompendioTomo8b = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "ARITMETICA");
        File mCompendioTomo8c = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "BIOLOGIA");
        File mCompendioTomo8d = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "ECONOMIA");
        File mCompendioTomo8e = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "FISICA");
        File mCompendioTomo8f = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "GEOGRAFIA");
        File mCompendioTomo8g = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "GEOMETRIA");
        File mCompendioTomo8h = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "HISTORIA_DEL_PERU");
        File mCompendioTomo8i = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo8j = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "LENGUAJE");
        File mCompendioTomo8k = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "LITERATURA");
        File mCompendioTomo8l = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "PSICOLOGIA");
        File mCompendioTomo8m = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8n = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8o = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo8p = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo8q = new File(ruta_storage + "/APP/5/" + grado + "/COMPENDIOS/TOMO8/", "TRIGONOMETRIA");


        //----------------------------------------------------------------------------------------------------

        File mVideosMotivadores1a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "COMPRENSION_LECTORA");
        File mVideosMotivadores1b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "ESTADISTICA");
        File mVideosMotivadores1c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores1d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "LECTURA_CRITICA");
        File mVideosMotivadores1e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "NUMERO_OPERACIONES");
        File mVideosMotivadores1f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "PLANIMETRIA");
        File mVideosMotivadores1g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores1h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores1i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO1/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores2a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "COMPRENSION_LECTORA");
        File mVideosMotivadores2b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "ESTADISTICA");
        File mVideosMotivadores2c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores2d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "LECTURA_CRITICA");
        File mVideosMotivadores2e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "NUMERO_OPERACIONES");
        File mVideosMotivadores2f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "PLANIMETRIA");
        File mVideosMotivadores2g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores2h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores2i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO2/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores3a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "COMPRENSION_LECTORA");
        File mVideosMotivadores3b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "ESTADISTICA");
        File mVideosMotivadores3c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores3d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "LECTURA_CRITICA");
        File mVideosMotivadores3e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "NUMERO_OPERACIONES");
        File mVideosMotivadores3f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "PLANIMETRIA");
        File mVideosMotivadores3g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores3h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores3i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO3/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores4a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "COMPRENSION_LECTORA");
        File mVideosMotivadores4b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "ESTADISTICA");
        File mVideosMotivadores4c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores4d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "LECTURA_CRITICA");
        File mVideosMotivadores4e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "NUMERO_OPERACIONES");
        File mVideosMotivadores4f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "PLANIMETRIA");
        File mVideosMotivadores4g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores4h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores4i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO4/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores5a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "COMPRENSION_LECTORA");
        File mVideosMotivadores5b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "ESTADISTICA");
        File mVideosMotivadores5c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores5d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "LECTURA_CRITICA");
        File mVideosMotivadores5e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "NUMERO_OPERACIONES");
        File mVideosMotivadores5f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "PLANIMETRIA");
        File mVideosMotivadores5g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores5h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores5i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO5/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores6a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "COMPRENSION_LECTORA");
        File mVideosMotivadores6b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "ESTADISTICA");
        File mVideosMotivadores6c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores6d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "LECTURA_CRITICA");
        File mVideosMotivadores6e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "NUMERO_OPERACIONES");
        File mVideosMotivadores6f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "PLANIMETRIA");
        File mVideosMotivadores6g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores6h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores6i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO6/", "ANALISIS_ABSTRACCION");

        File mVideosMotivadores7a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "COMPRENSION_LECTORA");
        File mVideosMotivadores7b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "ESTADISTICA");
        File mVideosMotivadores7c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores7d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "LECTURA_CRITICA");
        File mVideosMotivadores7e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "NUMERO_OPERACIONES");
        File mVideosMotivadores7f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "PLANIMETRIA");
        File mVideosMotivadores7g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores7h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores7i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO7/", "ANALISIS_ABSTRACCION");


        File mVideosMotivadores8a = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "COMPRENSION_LECTORA");
        File mVideosMotivadores8b = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "ESTADISTICA");
        File mVideosMotivadores8c = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "ILATIVOS_DELENGUAJE");
        File mVideosMotivadores8d = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "LECTURA_CRITICA");
        File mVideosMotivadores8e = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "NUMERO_OPERACIONES");
        File mVideosMotivadores8f = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "PLANIMETRIA");
        File mVideosMotivadores8g = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "PROGRAMACION_LINEAL");
        File mVideosMotivadores8h = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "REDACCION_DELENGUAJE");
        File mVideosMotivadores8i = new File(ruta_storage + "/APP/5/" + grado + "/VIDEO_HELICO_MOTIVADORES/TOMO8/", "ANALISIS_ABSTRACCION");


        //-----------------------------------------------------------------------------------

        //ANALISIS_ABSTRACCION

        File mDiapositivasTomo1a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo1b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ESTADISTICA");
        File mDiapositivasTomo1c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo1d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "LECTURA_CRITICA");
        File mDiapositivasTomo1e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo1f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "PLANIMETRIA");
        File mDiapositivasTomo1g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo1h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo1i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ANALISIS_ABSTRACCION");


        File mDiapositivasTomo2a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo2b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ESTADISTICA");
        File mDiapositivasTomo2c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo2d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "LECTURA_CRITICA");
        File mDiapositivasTomo2e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo2f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "PLANIMETRIA");
        File mDiapositivasTomo2g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo2h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo2i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ANALISIS_ABSTRACCION");

        File mDiapositivasTomo3a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo3b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ESTADISTICA");
        File mDiapositivasTomo3c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo3d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "LECTURA_CRITICA");
        File mDiapositivasTomo3e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo3f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "PLANIMETRIA");
        File mDiapositivasTomo3g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo3h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo3i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ANALISIS_ABSTRACCION");

        File mDiapositivasTomo4a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo4b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ESTADISTICA");
        File mDiapositivasTomo4c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo4d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "LECTURA_CRITICA");
        File mDiapositivasTomo4e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo4f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "PLANIMETRIA");
        File mDiapositivasTomo4g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo4h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo4i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ANALISIS_ABSTRACCION");

        File mDiapositivasTomo5a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo5b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ESTADISTICA");
        File mDiapositivasTomo5c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo5d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "LECTURA_CRITICA");
        File mDiapositivasTomo5e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo5f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "PLANIMETRIA");
        File mDiapositivasTomo5g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo5h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo5i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ANALISIS_ABSTRACCION");

        File mDiapositivasTomo6a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo6b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ESTADISTICA");
        File mDiapositivasTomo6c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo6d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "LECTURA_CRITICA");
        File mDiapositivasTomo6e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo6f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "PLANIMETRIA");
        File mDiapositivasTomo6g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo6h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo6i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ANALISIS_ABSTRACCION");


        File mDiapositivasTomo7a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo7b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ESTADISTICA");
        File mDiapositivasTomo7c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo7d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "LECTURA_CRITICA");
        File mDiapositivasTomo7e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo7f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "PLANIMETRIA");
        File mDiapositivasTomo7g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo7h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo7i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ANALISIS_ABSTRACCION");


        File mDiapositivasTomo8a = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "COMPRENSION_LECTORA");
        File mDiapositivasTomo8b = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ESTADISTICA");
        File mDiapositivasTomo8c = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ILATIVOS_DELENGUAJE");
        File mDiapositivasTomo8d = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "LECTURA_CRITICA");
        File mDiapositivasTomo8e = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "NUMERO_OPERACIONES");
        File mDiapositivasTomo8f = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "PLANIMETRIA");
        File mDiapositivasTomo8g = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "PROGRAMACION_LINEAL");
        File mDiapositivasTomo8h = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "REDACCION_DELENGUAJE");
        File mDiapositivasTomo8i = new File(ruta_storage + "/APP/5/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ANALISIS_ABSTRACCION");


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
        mMenuPrincipal18.mkdir();


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


        mPrincMatematico1.mkdir();
        mPrincMatematico2.mkdir();
        mPrincMatematico3.mkdir();
        mPrincMatematico4.mkdir();


        mLecturasMotivadoras1.mkdir();
        mLecturasMotivadoras2.mkdir();
        mLecturasMotivadoras3.mkdir();
        mLecturasMotivadoras4.mkdir();

        mLecturasBimestre1M1.mkdir();
        mLecturasBimestre1M2.mkdir();
        mLecturasBimestre1M3.mkdir();
        mLecturasBimestre1M4.mkdir();

        mLecturasBimestre2M1.mkdir();
        mLecturasBimestre2M2.mkdir();
        mLecturasBimestre2M3.mkdir();
        mLecturasBimestre2M4.mkdir();

        mLecturasBimestre3M1.mkdir();
        mLecturasBimestre3M2.mkdir();
        mLecturasBimestre3M3.mkdir();
        mLecturasBimestre3M4.mkdir();

        mLecturasBimestre4M1.mkdir();
        mLecturasBimestre4M2.mkdir();
        mLecturasBimestre4M3.mkdir();
        mLecturasBimestre4M4.mkdir();


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

        mVideoMotivador1_1.mkdir();
        mVideoMotivador1_2.mkdir();
        mVideoMotivador1_3.mkdir();
        mVideoMotivador1_4.mkdir();
        mVideoMotivador1_5.mkdir();
        mVideoMotivador1_6.mkdir();
        mVideoMotivador1_7.mkdir();
        mVideoMotivador1_8.mkdir();


        mPregExamAdTomo1a.mkdir();
        mPregExamAdTomo1b.mkdir();
        mPregExamAdTomo1c.mkdir();
        mPregExamAdTomo1d.mkdir();
        mPregExamAdTomo1e.mkdir();
        mPregExamAdTomo1f.mkdir();
        mPregExamAdTomo1g.mkdir();
        mPregExamAdTomo1h.mkdir();
        mPregExamAdTomo1i.mkdir();


        mPregExamAdTomo2a.mkdir();
        mPregExamAdTomo2b.mkdir();
        mPregExamAdTomo2c.mkdir();
        mPregExamAdTomo2d.mkdir();
        mPregExamAdTomo2e.mkdir();
        mPregExamAdTomo2f.mkdir();
        mPregExamAdTomo2g.mkdir();
        mPregExamAdTomo2h.mkdir();
        mPregExamAdTomo2i.mkdir();


        mPregExamAdTomo3a.mkdir();
        mPregExamAdTomo3b.mkdir();
        mPregExamAdTomo3c.mkdir();
        mPregExamAdTomo3d.mkdir();
        mPregExamAdTomo3e.mkdir();
        mPregExamAdTomo3f.mkdir();
        mPregExamAdTomo3g.mkdir();
        mPregExamAdTomo3h.mkdir();
        mPregExamAdTomo3i.mkdir();


        mPregExamAdTomo4a.mkdir();
        mPregExamAdTomo4b.mkdir();
        mPregExamAdTomo4c.mkdir();
        mPregExamAdTomo4d.mkdir();
        mPregExamAdTomo4e.mkdir();
        mPregExamAdTomo4f.mkdir();
        mPregExamAdTomo4g.mkdir();
        mPregExamAdTomo4h.mkdir();
        mPregExamAdTomo4i.mkdir();


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


        mVideosMotivadores1a.mkdir();
        mVideosMotivadores1b.mkdir();
        mVideosMotivadores1c.mkdir();
        mVideosMotivadores1d.mkdir();
        mVideosMotivadores1e.mkdir();
        mVideosMotivadores1f.mkdir();
        mVideosMotivadores1g.mkdir();
        mVideosMotivadores1h.mkdir();
        mVideosMotivadores1i.mkdir();


        mVideosMotivadores2a.mkdir();
        mVideosMotivadores2b.mkdir();
        mVideosMotivadores2c.mkdir();
        mVideosMotivadores2d.mkdir();
        mVideosMotivadores2e.mkdir();
        mVideosMotivadores2f.mkdir();
        mVideosMotivadores2g.mkdir();
        mVideosMotivadores2h.mkdir();
        mVideosMotivadores2i.mkdir();

        mVideosMotivadores3a.mkdir();
        mVideosMotivadores3b.mkdir();
        mVideosMotivadores3c.mkdir();
        mVideosMotivadores3d.mkdir();
        mVideosMotivadores3e.mkdir();
        mVideosMotivadores3f.mkdir();
        mVideosMotivadores3g.mkdir();
        mVideosMotivadores3h.mkdir();
        mVideosMotivadores3i.mkdir();


        mVideosMotivadores4a.mkdir();
        mVideosMotivadores4b.mkdir();
        mVideosMotivadores4c.mkdir();
        mVideosMotivadores4d.mkdir();
        mVideosMotivadores4e.mkdir();
        mVideosMotivadores4f.mkdir();
        mVideosMotivadores4g.mkdir();
        mVideosMotivadores4h.mkdir();
        mVideosMotivadores4i.mkdir();


        mVideosMotivadores5a.mkdir();
        mVideosMotivadores5b.mkdir();
        mVideosMotivadores5c.mkdir();
        mVideosMotivadores5d.mkdir();
        mVideosMotivadores5e.mkdir();
        mVideosMotivadores5f.mkdir();
        mVideosMotivadores5g.mkdir();
        mVideosMotivadores5h.mkdir();
        mVideosMotivadores5i.mkdir();


        mVideosMotivadores6a.mkdir();
        mVideosMotivadores6b.mkdir();
        mVideosMotivadores6c.mkdir();
        mVideosMotivadores6d.mkdir();
        mVideosMotivadores6e.mkdir();
        mVideosMotivadores6f.mkdir();
        mVideosMotivadores6g.mkdir();
        mVideosMotivadores6h.mkdir();
        mVideosMotivadores6i.mkdir();


        mVideosMotivadores7a.mkdir();
        mVideosMotivadores7b.mkdir();
        mVideosMotivadores7c.mkdir();
        mVideosMotivadores7d.mkdir();
        mVideosMotivadores7e.mkdir();
        mVideosMotivadores7f.mkdir();
        mVideosMotivadores7g.mkdir();
        mVideosMotivadores7h.mkdir();
        mVideosMotivadores7i.mkdir();


        mVideosMotivadores8a.mkdir();
        mVideosMotivadores8b.mkdir();
        mVideosMotivadores8c.mkdir();
        mVideosMotivadores8d.mkdir();
        mVideosMotivadores8e.mkdir();
        mVideosMotivadores8f.mkdir();
        mVideosMotivadores8g.mkdir();
        mVideosMotivadores8h.mkdir();
        mVideosMotivadores8i.mkdir();


        mDiapositivasTomo1a.mkdir();
        mDiapositivasTomo1b.mkdir();
        mDiapositivasTomo1c.mkdir();
        mDiapositivasTomo1d.mkdir();
        mDiapositivasTomo1e.mkdir();
        mDiapositivasTomo1f.mkdir();
        mDiapositivasTomo1g.mkdir();
        mDiapositivasTomo1h.mkdir();
        mDiapositivasTomo1i.mkdir();


        mDiapositivasTomo2a.mkdir();
        mDiapositivasTomo2b.mkdir();
        mDiapositivasTomo2c.mkdir();
        mDiapositivasTomo2d.mkdir();
        mDiapositivasTomo2e.mkdir();
        mDiapositivasTomo2f.mkdir();
        mDiapositivasTomo2g.mkdir();
        mDiapositivasTomo2h.mkdir();
        mDiapositivasTomo2i.mkdir();


        mDiapositivasTomo3a.mkdir();
        mDiapositivasTomo3b.mkdir();
        mDiapositivasTomo3c.mkdir();
        mDiapositivasTomo3d.mkdir();
        mDiapositivasTomo3e.mkdir();
        mDiapositivasTomo3f.mkdir();
        mDiapositivasTomo3g.mkdir();
        mDiapositivasTomo3h.mkdir();
        mDiapositivasTomo3i.mkdir();


        mDiapositivasTomo4a.mkdir();
        mDiapositivasTomo4b.mkdir();
        mDiapositivasTomo4c.mkdir();
        mDiapositivasTomo4d.mkdir();
        mDiapositivasTomo4e.mkdir();
        mDiapositivasTomo4f.mkdir();
        mDiapositivasTomo4g.mkdir();
        mDiapositivasTomo4h.mkdir();
        mDiapositivasTomo4i.mkdir();


        mDiapositivasTomo5a.mkdir();
        mDiapositivasTomo5b.mkdir();
        mDiapositivasTomo5c.mkdir();
        mDiapositivasTomo5d.mkdir();
        mDiapositivasTomo5e.mkdir();
        mDiapositivasTomo5f.mkdir();
        mDiapositivasTomo5g.mkdir();
        mDiapositivasTomo5h.mkdir();
        mDiapositivasTomo5i.mkdir();


        mDiapositivasTomo6a.mkdir();
        mDiapositivasTomo6b.mkdir();
        mDiapositivasTomo6c.mkdir();
        mDiapositivasTomo6d.mkdir();
        mDiapositivasTomo6e.mkdir();
        mDiapositivasTomo6f.mkdir();
        mDiapositivasTomo6g.mkdir();
        mDiapositivasTomo6h.mkdir();
        mDiapositivasTomo6i.mkdir();


        mDiapositivasTomo7a.mkdir();
        mDiapositivasTomo7b.mkdir();
        mDiapositivasTomo7c.mkdir();
        mDiapositivasTomo7d.mkdir();
        mDiapositivasTomo7e.mkdir();
        mDiapositivasTomo7f.mkdir();
        mDiapositivasTomo7g.mkdir();
        mDiapositivasTomo7h.mkdir();
        mDiapositivasTomo7i.mkdir();


        mDiapositivasTomo8a.mkdir();
        mDiapositivasTomo8b.mkdir();
        mDiapositivasTomo8c.mkdir();
        mDiapositivasTomo8d.mkdir();
        mDiapositivasTomo8e.mkdir();
        mDiapositivasTomo8f.mkdir();
        mDiapositivasTomo8g.mkdir();
        mDiapositivasTomo8h.mkdir();
        mDiapositivasTomo8i.mkdir();


    }


    @Override
    public void enviargrado(String mensaje) {
        gradoalumno = mensaje;
    }


}
