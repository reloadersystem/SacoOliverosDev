package pe.sacooliveros.apptablet;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;

public class DirectoryCreateUtil extends AppCompatActivity implements EnviarGrado {

    String ruta_storage;
    String gradoalumno = "";
    String grado;


    public void verResourceString(Context context) {
        ruta_storage = context.getString(R.string.ruta_raiz);

        Log.d("DATA_STRING", ruta_storage);

    }


    public void verGradoSec(String gradoencurso) {

        grado = gradoencurso.substring(0, 1);
    }


    public File createCarpetas(String filename) {

        File file = new File(filename);


        if (!file.exists()) {


            file.mkdirs();


            File AccesoTipo2 = new File(ruta_storage + "/APP/", "2");


            AccesoTipo2.mkdir();

            File secundariaGrado1 = new File(ruta_storage + "/APP/2/", "1");
            File secundariaGrado2 = new File(ruta_storage + "/APP/2/", "2");
            File secundariaGrado3 = new File(ruta_storage + "/APP/2/", "3");
            File secundariaGrado4 = new File(ruta_storage + "/APP/2/", "4");
            File secundariaGrado5 = new File(ruta_storage + "/APP/2/", "5");


            secundariaGrado1.mkdir();
            secundariaGrado2.mkdir();
            secundariaGrado3.mkdir();
            secundariaGrado4.mkdir();
            secundariaGrado5.mkdir();

            if (grado.equals("1")) {
                Secundaria_Storage();
            }


            if (grado.equals("2")) {
                Secundaria_Storage();
            }

            if (grado.equals("3")) {
                Secundaria_Storage();
            }

            if (grado.equals("4")) {
                Secundaria_Storage();
            }

            if (grado.equals("5")) {
                Secundaria_Storage();
            }

        }
        return file;


    }

    private void Secundaria_Storage() {


        File mMenuPrincipal1 = new File(ruta_storage + "/APP/2/" + grado + "/", "AJEDREZ");
        File mMenuPrincipal2 = new File(ruta_storage + "/APP/2/" + grado + "/", "COMPENDIOS");
        File mMenuPrincipal3 = new File(ruta_storage + "/APP/2/" + grado + "/", "COMPUTACION");
        File mMenuPrincipal4 = new File(ruta_storage + "/APP/2/" + grado + "/", "EDUCACION_FISICA");
        File mMenuPrincipal5 = new File(ruta_storage + "/APP/2/" + grado + "/", "HELICO_BALOTARIO");
        File mMenuPrincipal6 = new File(ruta_storage + "/APP/2/" + grado + "/", "HELICO_DIAPOSITIVAS");
        File mMenuPrincipal7 = new File(ruta_storage + "/APP/2/" + grado + "/", "HELICO_ENGLISH");
        File mMenuPrincipal8 = new File(ruta_storage + "/APP/2/" + grado + "/", "MEDITACION");
        File mMenuPrincipal9 = new File(ruta_storage + "/APP/2/" + grado + "/", "PLAN_LECTOR");
        File mMenuPrincipal10 = new File(ruta_storage + "/APP/2/" + grado + "/", "PRINCIPIOS_FMATEMATICA");
        File mMenuPrincipal11 = new File(ruta_storage + "/APP/2/" + grado + "/", "PROBLEMAS_PROPUESTOS");
        File mMenuPrincipal12 = new File(ruta_storage + "/APP/2/" + grado + "/", "PROBLEMAS_RESUELTOS");
        File mMenuPrincipal13 = new File(ruta_storage + "/APP/2/" + grado + "/", "COMPENDIOS");
        File mMenuPrincipal14 = new File(ruta_storage + "/APP/2/" + grado + "/", "VIDEO_HELICO_SEMINARIO");
        File mMenuPrincipal15 = new File(ruta_storage + "/APP/2/" + grado + "/", "HELICO_ASESORIAS");


        File mPrincMatematico1 = new File(ruta_storage + "/APP/2/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE1");
        File mPrincMatematico2 = new File(ruta_storage + "/APP/2/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE2");
        File mPrincMatematico3 = new File(ruta_storage + "/APP/2/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE3");
        File mPrincMatematico4 = new File(ruta_storage + "/APP/2/" + grado + "/PRINCIPIOS_FMATEMATICA/", "BIMESTRE4");

        File mHelicoAsesoria1 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO1");
        File mHelicoAsesoria2 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO2");
        File mHelicoAsesoria3 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO3");
        File mHelicoAsesoria4 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO4");
        File mHelicoAsesoria5 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO5");
        File mHelicoAsesoria6 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO6");
        File mHelicoAsesoria7 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO7");
        File mHelicoAsesoria8 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_ASESORIAS/", "TOMO8");

        File mVideoSeminario1 = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/", "TOMO1");
        File mVideoSeminario2 = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/", "TOMO2");
        File mVideoSeminario3 = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/", "TOMO3");
        File mVideoSeminario4 = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/", "TOMO4");
        File mVideoSeminario5 = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/", "TOMO5");

        File mVideoSeminarioTomo1a = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO1/", "CAPITULO1");
        File mVideoSeminarioTomo1b = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO1/", "CAPITULO2");
        File mVideoSeminarioTomo1c = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO1/", "CAPITULO3");

        File mVideoSeminarioTomo2a = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO2/", "CAPITULO4");
        File mVideoSeminarioTomo2b = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO2/", "CAPITULO5");
        File mVideoSeminarioTomo2c = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO2/", "CAPITULO6");

        File mVideoSeminarioTomo3a = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO3/", "CAPITULO7");
        File mVideoSeminarioTomo3b = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO3/", "CAPITULO8");
        File mVideoSeminarioTomo3c = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO3/", "CAPITULO9");

        File mVideoSeminarioTomo4a = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO4/", "CAPITULO10");
        File mVideoSeminarioTomo4b = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO4/", "CAPITULO11");
        File mVideoSeminarioTomo4c = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO4/", "CAPITULO12");

        File mVideoSeminarioTomo5a = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO5/", "CAPITULO13");
        File mVideoSeminarioTomo5b = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO5/", "CAPITULO14");
        File mVideoSeminarioTomo5c = new File(ruta_storage + "/APP/2/" + grado + "/VIDEO_HELICO_SEMINARIO/TOMO5/", "CAPITULO15");

        File mProPropuestos1 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES1");
        File mProPropuestos2 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES2");
        File mProPropuestos3 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES3");
        File mProPropuestos4 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES4");
        File mProPropuestos5 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES5");
        File mProPropuestos6 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES6");
        File mProPropuestos7 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES7");
        File mProPropuestos8 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES8");
        File mProPropuestos9 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES9");
        File mProPropuestos10 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/", "MES10");

        File mHDiapositivas1_1 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO1");
        File mHDiapositivas1_2 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO2");
        File mHDiapositivas1_3 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO3");
        File mHDiapositivas1_4 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO4");
        File mHDiapositivas1_5 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO5");
        File mHDiapositivas1_6 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO6");
        File mHDiapositivas1_7 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO7");
        File mHDiapositivas1_8 = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/", "TOMO8");

        File mComputacion1_1 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO1");
        File mComputacion1_2 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO2");
        File mComputacion1_3 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO3");
        File mComputacion1_4 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO4");
        File mComputacion1_5 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO5");
        File mComputacion1_6 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO6");
        File mComputacion1_7 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO7");
        File mComputacion1_8 = new File(ruta_storage + "/APP/2/" + grado + "/COMPUTACION/", "TOMO8");


        File mMesPropuestos1a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "ALGEBRA");
        File mMesPropuestos1b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "ARITMETICA");
        File mMesPropuestos1c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "BIOLOGIA");
        File mMesPropuestos1d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "ECONOMIA");
        File mMesPropuestos1e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "FISICA");
        File mMesPropuestos1f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "GEOGRAFIA");
        File mMesPropuestos1g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "GEOMETRIA");
        File mMesPropuestos1h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "HISTORIA_DEL_PERU");
        File mMesPropuestos1i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos1j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "LENGUAJE");
        File mMesPropuestos1k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "LITERATURA");
        File mMesPropuestos1l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "PSICOLOGIA");
        File mMesPropuestos1m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "QUIMICA");
        File mMesPropuestos1n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos1o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos1p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES1/", "TRIGONOMETRIA");

        File mMesPropuestos2a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "ALGEBRA");
        File mMesPropuestos2b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "ARITMETICA");
        File mMesPropuestos2c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "BIOLOGIA");
        File mMesPropuestos2d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "ECONOMIA");
        File mMesPropuestos2e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "FISICA");
        File mMesPropuestos2f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "GEOGRAFIA");
        File mMesPropuestos2g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "GEOMETRIA");
        File mMesPropuestos2h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "HISTORIA_DEL_PERU");
        File mMesPropuestos2i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos2j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "LENGUAJE");
        File mMesPropuestos2k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "LITERATURA");
        File mMesPropuestos2l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "PSICOLOGIA");
        File mMesPropuestos2m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "QUIMICA");
        File mMesPropuestos2n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos2o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos2p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES2/", "TRIGONOMETRIA");

        File mMesPropuestos3a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "ALGEBRA");
        File mMesPropuestos3b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "ARITMETICA");
        File mMesPropuestos3c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "BIOLOGIA");
        File mMesPropuestos3d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "ECONOMIA");
        File mMesPropuestos3e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "FISICA");
        File mMesPropuestos3f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "GEOGRAFIA");
        File mMesPropuestos3g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "GEOMETRIA");
        File mMesPropuestos3h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "HISTORIA_DEL_PERU");
        File mMesPropuestos3i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos3j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "LENGUAJE");
        File mMesPropuestos3k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "LITERATURA");
        File mMesPropuestos3l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "PSICOLOGIA");
        File mMesPropuestos3m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "QUIMICA");
        File mMesPropuestos3n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos3o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos3p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES3/", "TRIGONOMETRIA");

        File mMesPropuestos4a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "ALGEBRA");
        File mMesPropuestos4b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "ARITMETICA");
        File mMesPropuestos4c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "BIOLOGIA");
        File mMesPropuestos4d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "ECONOMIA");
        File mMesPropuestos4e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "FISICA");
        File mMesPropuestos4f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "GEOGRAFIA");
        File mMesPropuestos4g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "GEOMETRIA");
        File mMesPropuestos4h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "HISTORIA_DEL_PERU");
        File mMesPropuestos4i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos4j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "LENGUAJE");
        File mMesPropuestos4k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "LITERATURA");
        File mMesPropuestos4l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "PSICOLOGIA");
        File mMesPropuestos4m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "QUIMICA");
        File mMesPropuestos4n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos4o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos4p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES4/", "TRIGONOMETRIA");

        File mMesPropuestos5a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "ALGEBRA");
        File mMesPropuestos5b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "ARITMETICA");
        File mMesPropuestos5c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "BIOLOGIA");
        File mMesPropuestos5d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "ECONOMIA");
        File mMesPropuestos5e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "FISICA");
        File mMesPropuestos5f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "GEOGRAFIA");
        File mMesPropuestos5g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "GEOMETRIA");
        File mMesPropuestos5h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "HISTORIA_DEL_PERU");
        File mMesPropuestos5i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos5j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "LENGUAJE");
        File mMesPropuestos5k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "LITERATURA");
        File mMesPropuestos5l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "PSICOLOGIA");
        File mMesPropuestos5m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "QUIMICA");
        File mMesPropuestos5n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos5o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos5p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES5/", "TRIGONOMETRIA");

        File mMesPropuestos6a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "ALGEBRA");
        File mMesPropuestos6b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "ARITMETICA");
        File mMesPropuestos6c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "BIOLOGIA");
        File mMesPropuestos6d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "ECONOMIA");
        File mMesPropuestos6e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "FISICA");
        File mMesPropuestos6f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "GEOGRAFIA");
        File mMesPropuestos6g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "GEOMETRIA");
        File mMesPropuestos6h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "HISTORIA_DEL_PERU");
        File mMesPropuestos6i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos6j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "LENGUAJE");
        File mMesPropuestos6k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "LITERATURA");
        File mMesPropuestos6l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "PSICOLOGIA");
        File mMesPropuestos6m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "QUIMICA");
        File mMesPropuestos6n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos6o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos6p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES6/", "TRIGONOMETRIA");


        File mMesPropuestos7a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "ALGEBRA");
        File mMesPropuestos7b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "ARITMETICA");
        File mMesPropuestos7c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "BIOLOGIA");
        File mMesPropuestos7d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "ECONOMIA");
        File mMesPropuestos7e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "FISICA");
        File mMesPropuestos7f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "GEOGRAFIA");
        File mMesPropuestos7g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "GEOMETRIA");
        File mMesPropuestos7h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "HISTORIA_DEL_PERU");
        File mMesPropuestos7i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos7j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "LENGUAJE");
        File mMesPropuestos7k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "LITERATURA");
        File mMesPropuestos7l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "PSICOLOGIA");
        File mMesPropuestos7m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "QUIMICA");
        File mMesPropuestos7n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos7o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos7p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES7/", "TRIGONOMETRIA");


        File mMesPropuestos8a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "ALGEBRA");
        File mMesPropuestos8b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "ARITMETICA");
        File mMesPropuestos8c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "BIOLOGIA");
        File mMesPropuestos8d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "ECONOMIA");
        File mMesPropuestos8e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "FISICA");
        File mMesPropuestos8f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "GEOGRAFIA");
        File mMesPropuestos8g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "GEOMETRIA");
        File mMesPropuestos8h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "HISTORIA_DEL_PERU");
        File mMesPropuestos8i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos8j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "LENGUAJE");
        File mMesPropuestos8k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "LITERATURA");
        File mMesPropuestos8l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "PSICOLOGIA");
        File mMesPropuestos8m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "QUIMICA");
        File mMesPropuestos8n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos8o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos8p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES8/", "TRIGONOMETRIA");

        File mMesPropuestos9a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "ALGEBRA");
        File mMesPropuestos9b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "ARITMETICA");
        File mMesPropuestos9c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "BIOLOGIA");
        File mMesPropuestos9d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "ECONOMIA");
        File mMesPropuestos9e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "FISICA");
        File mMesPropuestos9f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "GEOGRAFIA");
        File mMesPropuestos9g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "GEOMETRIA");
        File mMesPropuestos9h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "HISTORIA_DEL_PERU");
        File mMesPropuestos9i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos9j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "LENGUAJE");
        File mMesPropuestos9k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "LITERATURA");
        File mMesPropuestos9l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "PSICOLOGIA");
        File mMesPropuestos9m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "QUIMICA");
        File mMesPropuestos9n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos9o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos9p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES9/", "TRIGONOMETRIA");


        File mMesPropuestos10a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "ALGEBRA");
        File mMesPropuestos10b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "ARITMETICA");
        File mMesPropuestos10c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "BIOLOGIA");
        File mMesPropuestos10d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "ECONOMIA");
        File mMesPropuestos10e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "FISICA");
        File mMesPropuestos10f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "GEOGRAFIA");
        File mMesPropuestos10g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "GEOMETRIA");
        File mMesPropuestos10h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "HISTORIA_DEL_PERU");
        File mMesPropuestos10i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "HISTORIA_UNIVERSAL");
        File mMesPropuestos10j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "LENGUAJE");
        File mMesPropuestos10k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "LITERATURA");
        File mMesPropuestos10l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "PSICOLOGIA");
        File mMesPropuestos10m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "QUIMICA");
        File mMesPropuestos10n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "RAZONAMIENTO_MATEMATICO");
        File mMesPropuestos10o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "RAZONAMIENTO_VERBAL");
        File mMesPropuestos10p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_PROPUESTOS/MES10/", "TRIGONOMETRIA");


        // ___________________________________________________________________________________________________________


        File mCompendio1_1 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO1");
        File mCompendio1_2 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO2");
        File mCompendio1_3 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO3");
        File mCompendio1_4 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO4");
        File mCompendio1_5 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO5");
        File mCompendio1_6 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO6");
        File mCompendio1_7 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO7");
        File mCompendio1_8 = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/", "TOMO8");

        File mCompendioTomo1a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "ALGEBRA");
        File mCompendioTomo1b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "ARITMETICA");
        File mCompendioTomo1c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "BIOLOGIA");
        File mCompendioTomo1d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "ECONOMIA");
        File mCompendioTomo1e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "FISICA");
        File mCompendioTomo1f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "GEOGRAFIA");
        File mCompendioTomo1g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "GEOMETRIA");
        File mCompendioTomo1h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "HISTORIA_DEL_PERU");
        File mCompendioTomo1i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo1j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "LENGUAJE");
        File mCompendioTomo1k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "LITERATURA");
        File mCompendioTomo1l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "PSICOLOGIA");
        File mCompendioTomo1m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "QUIMICA");
        File mCompendioTomo1n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "QUIMICA");
        File mCompendioTomo1o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo1p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo1q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO1/", "TRIGONOMETRIA");

        File mCompendioTomo2a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "ALGEBRA");
        File mCompendioTomo2b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "ARITMETICA");
        File mCompendioTomo2c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "BIOLOGIA");
        File mCompendioTomo2d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "ECONOMIA");
        File mCompendioTomo2e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "FISICA");
        File mCompendioTomo2f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "GEOGRAFIA");
        File mCompendioTomo2g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "GEOMETRIA");
        File mCompendioTomo2h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "HISTORIA_DEL_PERU");
        File mCompendioTomo2i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo2j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "LENGUAJE");
        File mCompendioTomo2k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "LITERATURA");
        File mCompendioTomo2l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "PSICOLOGIA");
        File mCompendioTomo2m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "QUIMICA");
        File mCompendioTomo2n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "QUIMICA");
        File mCompendioTomo2o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo2p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo2q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO2/", "TRIGONOMETRIA");

        File mCompendioTomo3a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "ALGEBRA");
        File mCompendioTomo3b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "ARITMETICA");
        File mCompendioTomo3c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "BIOLOGIA");
        File mCompendioTomo3d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "ECONOMIA");
        File mCompendioTomo3e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "FISICA");
        File mCompendioTomo3f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "GEOGRAFIA");
        File mCompendioTomo3g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "GEOMETRIA");
        File mCompendioTomo3h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "HISTORIA_DEL_PERU");
        File mCompendioTomo3i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo3j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "LENGUAJE");
        File mCompendioTomo3k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "LITERATURA");
        File mCompendioTomo3l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "PSICOLOGIA");
        File mCompendioTomo3m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "QUIMICA");
        File mCompendioTomo3o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo3p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo3q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO3/", "TRIGONOMETRIA");

        File mCompendioTomo4a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "ALGEBRA");
        File mCompendioTomo4b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "ARITMETICA");
        File mCompendioTomo4c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "BIOLOGIA");
        File mCompendioTomo4d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "ECONOMIA");
        File mCompendioTomo4e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "FISICA");
        File mCompendioTomo4f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "GEOGRAFIA");
        File mCompendioTomo4g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "GEOMETRIA");
        File mCompendioTomo4h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "HISTORIA_DEL_PERU");
        File mCompendioTomo4i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo4j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "LENGUAJE");
        File mCompendioTomo4k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "LITERATURA");
        File mCompendioTomo4l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "PSICOLOGIA");
        File mCompendioTomo4m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "QUIMICA");
        File mCompendioTomo4o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo4p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo4q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO4/", "TRIGONOMETRIA");

        File mCompendioTomo5a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "ALGEBRA");
        File mCompendioTomo5b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "ARITMETICA");
        File mCompendioTomo5c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "BIOLOGIA");
        File mCompendioTomo5d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "ECONOMIA");
        File mCompendioTomo5e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "FISICA");
        File mCompendioTomo5f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "GEOGRAFIA");
        File mCompendioTomo5g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "GEOMETRIA");
        File mCompendioTomo5h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "HISTORIA_DEL_PERU");
        File mCompendioTomo5i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo5j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "LENGUAJE");
        File mCompendioTomo5k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "LITERATURA");
        File mCompendioTomo5l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "PSICOLOGIA");
        File mCompendioTomo5m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "QUIMICA");
        File mCompendioTomo5o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo5p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo5q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO5/", "TRIGONOMETRIA");

        File mCompendioTomo6a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "ALGEBRA");
        File mCompendioTomo6b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "ARITMETICA");
        File mCompendioTomo6c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "BIOLOGIA");
        File mCompendioTomo6d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "ECONOMIA");
        File mCompendioTomo6e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "FISICA");
        File mCompendioTomo6f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "GEOGRAFIA");
        File mCompendioTomo6g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "GEOMETRIA");
        File mCompendioTomo6h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "HISTORIA_DEL_PERU");
        File mCompendioTomo6i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo6j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "LENGUAJE");
        File mCompendioTomo6k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "LITERATURA");
        File mCompendioTomo6l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "PSICOLOGIA");
        File mCompendioTomo6m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "QUIMICA");
        File mCompendioTomo6o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo6p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo6q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO6/", "TRIGONOMETRIA");

        File mCompendioTomo7a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "ALGEBRA");
        File mCompendioTomo7b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "ARITMETICA");
        File mCompendioTomo7c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "BIOLOGIA");
        File mCompendioTomo7d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "ECONOMIA");
        File mCompendioTomo7e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "FISICA");
        File mCompendioTomo7f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "GEOGRAFIA");
        File mCompendioTomo7g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "GEOMETRIA");
        File mCompendioTomo7h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "HISTORIA_DEL_PERU");
        File mCompendioTomo7i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo7j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "LENGUAJE");
        File mCompendioTomo7k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "LITERATURA");
        File mCompendioTomo7l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "PSICOLOGIA");
        File mCompendioTomo7m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "QUIMICA");
        File mCompendioTomo7o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo7p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo7q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO7/", "TRIGONOMETRIA");

        File mCompendioTomo8a = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "ALGEBRA");
        File mCompendioTomo8b = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "ARITMETICA");
        File mCompendioTomo8c = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "BIOLOGIA");
        File mCompendioTomo8d = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "ECONOMIA");
        File mCompendioTomo8e = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "FISICA");
        File mCompendioTomo8f = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "GEOGRAFIA");
        File mCompendioTomo8g = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "GEOMETRIA");
        File mCompendioTomo8h = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "HISTORIA_DEL_PERU");
        File mCompendioTomo8i = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "HISTORIA_UNIVERSAL");
        File mCompendioTomo8j = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "LENGUAJE");
        File mCompendioTomo8k = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "LITERATURA");
        File mCompendioTomo8l = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "PSICOLOGIA");
        File mCompendioTomo8m = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8n = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "QUIMICA");
        File mCompendioTomo8o = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "RAZONAMIENTO_MATEMATICO");
        File mCompendioTomo8p = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mCompendioTomo8q = new File(ruta_storage + "/APP/2/" + grado + "/COMPENDIOS/TOMO8/", "TRIGONOMETRIA");


        //----------------------------------------------------------------------------------------------------


        File mDiapositivasTomo1a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ALGEBRA");
        File mDiapositivasTomo1b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ARITMETICA");
        File mDiapositivasTomo1c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "BIOLOGIA");
        File mDiapositivasTomo1d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "ECONOMIA");
        File mDiapositivasTomo1e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "FISICA");
        File mDiapositivasTomo1f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "GEOGRAFIA");
        File mDiapositivasTomo1g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "GEOMETRIA");
        File mDiapositivasTomo1h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo1i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo1j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "LENGUAJE");
        File mDiapositivasTomo1k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "LITERATURA");
        File mDiapositivasTomo1l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "PSICOLOGIA");
        File mDiapositivasTomo1m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "QUIMICA");
        File mDiapositivasTomo1n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "QUIMICA");
        File mDiapositivasTomo1o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo1p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo1q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "TRIGONOMETRIA");
        File mDiapositivasTomo1r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "INGLES");
        File mDiapositivasTomo1s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "TEATRO");
        File mDiapositivasTomo1t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO1/", "VALORES");


        File mDiapositivasTomo2a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ALGEBRA");
        File mDiapositivasTomo2b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ARITMETICA");
        File mDiapositivasTomo2c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "BIOLOGIA");
        File mDiapositivasTomo2d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "ECONOMIA");
        File mDiapositivasTomo2e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "FISICA");
        File mDiapositivasTomo2f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "GEOGRAFIA");
        File mDiapositivasTomo2g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "GEOMETRIA");
        File mDiapositivasTomo2h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo2i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo2j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "LENGUAJE");
        File mDiapositivasTomo2k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "LITERATURA");
        File mDiapositivasTomo2l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "PSICOLOGIA");
        File mDiapositivasTomo2m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "QUIMICA");
        File mDiapositivasTomo2n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "QUIMICA");
        File mDiapositivasTomo2o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo2p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo2q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "TRIGONOMETRIA");
        File mDiapositivasTomo2r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "INGLES");
        File mDiapositivasTomo2s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "TEATRO");
        File mDiapositivasTomo2t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO2/", "VALORES");

        File mDiapositivasTomo3a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ALGEBRA");
        File mDiapositivasTomo3b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ARITMETICA");
        File mDiapositivasTomo3c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "BIOLOGIA");
        File mDiapositivasTomo3d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "ECONOMIA");
        File mDiapositivasTomo3e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "FISICA");
        File mDiapositivasTomo3f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "GEOGRAFIA");
        File mDiapositivasTomo3g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "GEOMETRIA");
        File mDiapositivasTomo3h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo3i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo3j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "LENGUAJE");
        File mDiapositivasTomo3k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "LITERATURA");
        File mDiapositivasTomo3l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "PSICOLOGIA");
        File mDiapositivasTomo3m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "QUIMICA");
        File mDiapositivasTomo3n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "QUIMICA");
        File mDiapositivasTomo3o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo3p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo3q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "TRIGONOMETRIA");
        File mDiapositivasTomo3r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "INGLES");
        File mDiapositivasTomo3s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "TEATRO");
        File mDiapositivasTomo3t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO3/", "VALORES");

        File mDiapositivasTomo4a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ALGEBRA");
        File mDiapositivasTomo4b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ARITMETICA");
        File mDiapositivasTomo4c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "BIOLOGIA");
        File mDiapositivasTomo4d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "ECONOMIA");
        File mDiapositivasTomo4e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "FISICA");
        File mDiapositivasTomo4f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "GEOGRAFIA");
        File mDiapositivasTomo4g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "GEOMETRIA");
        File mDiapositivasTomo4h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo4i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo4j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "LENGUAJE");
        File mDiapositivasTomo4k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "LITERATURA");
        File mDiapositivasTomo4l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "PSICOLOGIA");
        File mDiapositivasTomo4m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "QUIMICA");
        File mDiapositivasTomo4n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "QUIMICA");
        File mDiapositivasTomo4o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo4p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo4q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "TRIGONOMETRIA");
        File mDiapositivasTomo4r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "INGLES");
        File mDiapositivasTomo4s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "TEATRO");
        File mDiapositivasTomo4t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO4/", "VALORES");


        File mDiapositivasTomo5a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ALGEBRA");
        File mDiapositivasTomo5b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ARITMETICA");
        File mDiapositivasTomo5c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "BIOLOGIA");
        File mDiapositivasTomo5d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "ECONOMIA");
        File mDiapositivasTomo5e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "FISICA");
        File mDiapositivasTomo5f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "GEOGRAFIA");
        File mDiapositivasTomo5g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "GEOMETRIA");
        File mDiapositivasTomo5h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo5i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo5j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "LENGUAJE");
        File mDiapositivasTomo5k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "LITERATURA");
        File mDiapositivasTomo5l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "PSICOLOGIA");
        File mDiapositivasTomo5m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "QUIMICA");
        File mDiapositivasTomo5n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "QUIMICA");
        File mDiapositivasTomo5o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo5p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo5q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "TRIGONOMETRIA");
        File mDiapositivasTomo5r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "INGLES");
        File mDiapositivasTomo5s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "TEATRO");
        File mDiapositivasTomo5t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO5/", "VALORES");


        File mDiapositivasTomo6a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ALGEBRA");
        File mDiapositivasTomo6b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ARITMETICA");
        File mDiapositivasTomo6c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "BIOLOGIA");
        File mDiapositivasTomo6d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "ECONOMIA");
        File mDiapositivasTomo6e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "FISICA");
        File mDiapositivasTomo6f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "GEOGRAFIA");
        File mDiapositivasTomo6g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "GEOMETRIA");
        File mDiapositivasTomo6h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo6i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo6j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "LENGUAJE");
        File mDiapositivasTomo6k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "LITERATURA");
        File mDiapositivasTomo6l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "PSICOLOGIA");
        File mDiapositivasTomo6m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "QUIMICA");
        File mDiapositivasTomo6n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "QUIMICA");
        File mDiapositivasTomo6o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo6p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo6q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "TRIGONOMETRIA");
        File mDiapositivasTomo6r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "INGLES");
        File mDiapositivasTomo6s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "TEATRO");
        File mDiapositivasTomo6t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO6/", "VALORES");


        File mDiapositivasTomo7a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ALGEBRA");
        File mDiapositivasTomo7b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ARITMETICA");
        File mDiapositivasTomo7c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "BIOLOGIA");
        File mDiapositivasTomo7d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "ECONOMIA");
        File mDiapositivasTomo7e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "FISICA");
        File mDiapositivasTomo7f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "GEOGRAFIA");
        File mDiapositivasTomo7g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "GEOMETRIA");
        File mDiapositivasTomo7h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo7i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo7j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "LENGUAJE");
        File mDiapositivasTomo7k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "LITERATURA");
        File mDiapositivasTomo7l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "PSICOLOGIA");
        File mDiapositivasTomo7m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "QUIMICA");
        File mDiapositivasTomo7n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "QUIMICA");
        File mDiapositivasTomo7o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo7p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo7q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "TRIGONOMETRIA");
        File mDiapositivasTomo7r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "INGLES");
        File mDiapositivasTomo7s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "TEATRO");
        File mDiapositivasTomo7t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO7/", "VALORES");


        File mDiapositivasTomo8a = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ALGEBRA");
        File mDiapositivasTomo8b = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ARITMETICA");
        File mDiapositivasTomo8c = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "BIOLOGIA");
        File mDiapositivasTomo8d = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "ECONOMIA");
        File mDiapositivasTomo8e = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "FISICA");
        File mDiapositivasTomo8f = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "GEOGRAFIA");
        File mDiapositivasTomo8g = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "GEOMETRIA");
        File mDiapositivasTomo8h = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "HISTORIA_DEL_PERU");
        File mDiapositivasTomo8i = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "HISTORIA_UNIVERSAL");
        File mDiapositivasTomo8j = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "LENGUAJE");
        File mDiapositivasTomo8k = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "LITERATURA");
        File mDiapositivasTomo8l = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "PSICOLOGIA");
        File mDiapositivasTomo8m = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "QUIMICA");
        File mDiapositivasTomo8n = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "QUIMICA");
        File mDiapositivasTomo8o = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "RAZONAMIENTO_MATEMATICO");
        File mDiapositivasTomo8p = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "RAZONAMIENTO_VERBAL");
        File mDiapositivasTomo8q = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "TRIGONOMETRIA");
        File mDiapositivasTomo8r = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "INGLES");
        File mDiapositivasTomo8s = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "TEATRO");
        File mDiapositivasTomo8t = new File(ruta_storage + "/APP/2/" + grado + "/HELICO_DIAPOSITIVAS/TOMO8/", "VALORES");


        //--------------------------------------------------------------------------------------------- problemas resueltos

        File mProResueltos1 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES1");
        File mProResueltos2 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES2");
        File mProResueltos3 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES3");
        File mProResueltos4 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES4");
        File mProResueltos5 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES5");
        File mProResueltos6 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES6");
        File mProResueltos7 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES7");
        File mProResueltos8 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES8");
        File mProResueltos9 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES9");
        File mProResueltos10 = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/", "MES10");

        File mMesResueltos1a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "ALGEBRA");
        File mMesResueltos1b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "ARITMETICA");
        File mMesResueltos1c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "BIOLOGIA");
        File mMesResueltos1d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "ECONOMIA");
        File mMesResueltos1e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "FISICA");
        File mMesResueltos1f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "GEOGRAFIA");
        File mMesResueltos1g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "GEOMETRIA");
        File mMesResueltos1h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "HISTORIA_DEL_PERU");
        File mMesResueltos1i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "HISTORIA_UNIVERSAL");
        File mMesResueltos1j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "LENGUAJE");
        File mMesResueltos1k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "LITERATURA");
        File mMesResueltos1l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "PSICOLOGIA");
        File mMesResueltos1m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "QUIMICA");
        File mMesResueltos1n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos1o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos1p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES1/", "TRIGONOMETRIA");


        File mMesResueltos2a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "ALGEBRA");
        File mMesResueltos2b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "ARITMETICA");
        File mMesResueltos2c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "BIOLOGIA");
        File mMesResueltos2d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "ECONOMIA");
        File mMesResueltos2e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "FISICA");
        File mMesResueltos2f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "GEOGRAFIA");
        File mMesResueltos2g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "GEOMETRIA");
        File mMesResueltos2h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "HISTORIA_DEL_PERU");
        File mMesResueltos2i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "HISTORIA_UNIVERSAL");
        File mMesResueltos2j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "LENGUAJE");
        File mMesResueltos2k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "LITERATURA");
        File mMesResueltos2l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "PSICOLOGIA");
        File mMesResueltos2m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "QUIMICA");
        File mMesResueltos2n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos2o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos2p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES2/", "TRIGONOMETRIA");


        File mMesResueltos3a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "ALGEBRA");
        File mMesResueltos3b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "ARITMETICA");
        File mMesResueltos3c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "BIOLOGIA");
        File mMesResueltos3d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "ECONOMIA");
        File mMesResueltos3e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "FISICA");
        File mMesResueltos3f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "GEOGRAFIA");
        File mMesResueltos3g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "GEOMETRIA");
        File mMesResueltos3h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "HISTORIA_DEL_PERU");
        File mMesResueltos3i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "HISTORIA_UNIVERSAL");
        File mMesResueltos3j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "LENGUAJE");
        File mMesResueltos3k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "LITERATURA");
        File mMesResueltos3l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "PSICOLOGIA");
        File mMesResueltos3m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "QUIMICA");
        File mMesResueltos3n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos3o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos3p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES3/", "TRIGONOMETRIA");


        File mMesResueltos4a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "ALGEBRA");
        File mMesResueltos4b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "ARITMETICA");
        File mMesResueltos4c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "BIOLOGIA");
        File mMesResueltos4d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "ECONOMIA");
        File mMesResueltos4e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "FISICA");
        File mMesResueltos4f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "GEOGRAFIA");
        File mMesResueltos4g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "GEOMETRIA");
        File mMesResueltos4h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "HISTORIA_DEL_PERU");
        File mMesResueltos4i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "HISTORIA_UNIVERSAL");
        File mMesResueltos4j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "LENGUAJE");
        File mMesResueltos4k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "LITERATURA");
        File mMesResueltos4l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "PSICOLOGIA");
        File mMesResueltos4m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "QUIMICA");
        File mMesResueltos4n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos4o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos4p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES4/", "TRIGONOMETRIA");


        File mMesResueltos5a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "ALGEBRA");
        File mMesResueltos5b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "ARITMETICA");
        File mMesResueltos5c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "BIOLOGIA");
        File mMesResueltos5d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "ECONOMIA");
        File mMesResueltos5e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "FISICA");
        File mMesResueltos5f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "GEOGRAFIA");
        File mMesResueltos5g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "GEOMETRIA");
        File mMesResueltos5h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "HISTORIA_DEL_PERU");
        File mMesResueltos5i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "HISTORIA_UNIVERSAL");
        File mMesResueltos5j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "LENGUAJE");
        File mMesResueltos5k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "LITERATURA");
        File mMesResueltos5l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "PSICOLOGIA");
        File mMesResueltos5m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "QUIMICA");
        File mMesResueltos5n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos5o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos5p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES5/", "TRIGONOMETRIA");


        File mMesResueltos6a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "ALGEBRA");
        File mMesResueltos6b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "ARITMETICA");
        File mMesResueltos6c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "BIOLOGIA");
        File mMesResueltos6d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "ECONOMIA");
        File mMesResueltos6e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "FISICA");
        File mMesResueltos6f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "GEOGRAFIA");
        File mMesResueltos6g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "GEOMETRIA");
        File mMesResueltos6h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "HISTORIA_DEL_PERU");
        File mMesResueltos6i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "HISTORIA_UNIVERSAL");
        File mMesResueltos6j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "LENGUAJE");
        File mMesResueltos6k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "LITERATURA");
        File mMesResueltos6l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "PSICOLOGIA");
        File mMesResueltos6m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "QUIMICA");
        File mMesResueltos6n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos6o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos6p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES6/", "TRIGONOMETRIA");


        File mMesResueltos7a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "ALGEBRA");
        File mMesResueltos7b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "ARITMETICA");
        File mMesResueltos7c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "BIOLOGIA");
        File mMesResueltos7d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "ECONOMIA");
        File mMesResueltos7e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "FISICA");
        File mMesResueltos7f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "GEOGRAFIA");
        File mMesResueltos7g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "GEOMETRIA");
        File mMesResueltos7h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "HISTORIA_DEL_PERU");
        File mMesResueltos7i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "HISTORIA_UNIVERSAL");
        File mMesResueltos7j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "LENGUAJE");
        File mMesResueltos7k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "LITERATURA");
        File mMesResueltos7l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "PSICOLOGIA");
        File mMesResueltos7m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "QUIMICA");
        File mMesResueltos7n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos7o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos7p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES7/", "TRIGONOMETRIA");


        File mMesResueltos8a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "ALGEBRA");
        File mMesResueltos8b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "ARITMETICA");
        File mMesResueltos8c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "BIOLOGIA");
        File mMesResueltos8d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "ECONOMIA");
        File mMesResueltos8e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "FISICA");
        File mMesResueltos8f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "GEOGRAFIA");
        File mMesResueltos8g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "GEOMETRIA");
        File mMesResueltos8h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "HISTORIA_DEL_PERU");
        File mMesResueltos8i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "HISTORIA_UNIVERSAL");
        File mMesResueltos8j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "LENGUAJE");
        File mMesResueltos8k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "LITERATURA");
        File mMesResueltos8l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "PSICOLOGIA");
        File mMesResueltos8m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "QUIMICA");
        File mMesResueltos8n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos8o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos8p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES8/", "TRIGONOMETRIA");

        File mMesResueltos9a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "ALGEBRA");
        File mMesResueltos9b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "ARITMETICA");
        File mMesResueltos9c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "BIOLOGIA");
        File mMesResueltos9d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "ECONOMIA");
        File mMesResueltos9e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "FISICA");
        File mMesResueltos9f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "GEOGRAFIA");
        File mMesResueltos9g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "GEOMETRIA");
        File mMesResueltos9h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "HISTORIA_DEL_PERU");
        File mMesResueltos9i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "HISTORIA_UNIVERSAL");
        File mMesResueltos9j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "LENGUAJE");
        File mMesResueltos9k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "LITERATURA");
        File mMesResueltos9l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "PSICOLOGIA");
        File mMesResueltos9m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "QUIMICA");
        File mMesResueltos9n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos9o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos9p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES9/", "TRIGONOMETRIA");


        File mMesResueltos10a = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "ALGEBRA");
        File mMesResueltos10b = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "ARITMETICA");
        File mMesResueltos10c = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "BIOLOGIA");
        File mMesResueltos10d = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "ECONOMIA");
        File mMesResueltos10e = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "FISICA");
        File mMesResueltos10f = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "GEOGRAFIA");
        File mMesResueltos10g = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "GEOMETRIA");
        File mMesResueltos10h = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "HISTORIA_DEL_PERU");
        File mMesResueltos10i = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "HISTORIA_UNIVERSAL");
        File mMesResueltos10j = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "LENGUAJE");
        File mMesResueltos10k = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "LITERATURA");
        File mMesResueltos10l = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "PSICOLOGIA");
        File mMesResueltos10m = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "QUIMICA");
        File mMesResueltos10n = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "RAZONAMIENTO_MATEMATICO");
        File mMesResueltos10o = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "RAZONAMIENTO_VERBAL");
        File mMesResueltos10p = new File(ruta_storage + "/APP/2/" + grado + "/PROBLEMAS_RESUELTOS/MES10/", "TRIGONOMETRIA");

        mMenuPrincipal1.mkdir();
        mMenuPrincipal2.mkdir();
        mMenuPrincipal3.mkdir();
        mMenuPrincipal4.mkdir();
        mMenuPrincipal5.mkdir();
        mMenuPrincipal6.mkdir();
        mMenuPrincipal7.mkdir();
        mMenuPrincipal8.mkdir();
        mMenuPrincipal9.mkdir();
        mMenuPrincipal10.mkdir();
        mMenuPrincipal11.mkdir();
        mMenuPrincipal12.mkdir();
        mMenuPrincipal13.mkdir();
        mMenuPrincipal14.mkdir();
        mMenuPrincipal15.mkdir();

        mProPropuestos1.mkdir();
        mProPropuestos2.mkdir();
        mProPropuestos3.mkdir();
        mProPropuestos4.mkdir();
        mProPropuestos5.mkdir();
        mProPropuestos6.mkdir();
        mProPropuestos7.mkdir();
        mProPropuestos8.mkdir();
        mProPropuestos9.mkdir();
        mProPropuestos10.mkdir();

        mHDiapositivas1_1.mkdir();
        mHDiapositivas1_2.mkdir();
        mHDiapositivas1_3.mkdir();
        mHDiapositivas1_4.mkdir();
        mHDiapositivas1_5.mkdir();
        mHDiapositivas1_6.mkdir();
        mHDiapositivas1_7.mkdir();
        mHDiapositivas1_8.mkdir();

        mComputacion1_1.mkdir();
        mComputacion1_2.mkdir();
        mComputacion1_3.mkdir();
        mComputacion1_4.mkdir();
        mComputacion1_5.mkdir();
        mComputacion1_6.mkdir();
        mComputacion1_7.mkdir();
        mComputacion1_8.mkdir();

        mPrincMatematico1.mkdir();
        mPrincMatematico2.mkdir();
        mPrincMatematico3.mkdir();
        mPrincMatematico4.mkdir();


        mHelicoAsesoria1.mkdir();
        mHelicoAsesoria2.mkdir();
        mHelicoAsesoria3.mkdir();
        mHelicoAsesoria4.mkdir();
        mHelicoAsesoria5.mkdir();
        mHelicoAsesoria6.mkdir();
        mHelicoAsesoria7.mkdir();
        mHelicoAsesoria8.mkdir();


        mVideoSeminario1.mkdir();
        mVideoSeminario2.mkdir();
        mVideoSeminario3.mkdir();
        mVideoSeminario4.mkdir();
        mVideoSeminario5.mkdir();


        mVideoSeminarioTomo1a.mkdir();
        mVideoSeminarioTomo1b.mkdir();
        mVideoSeminarioTomo1c.mkdir();

        mVideoSeminarioTomo2a.mkdir();
        mVideoSeminarioTomo2b.mkdir();
        mVideoSeminarioTomo2c.mkdir();

        mVideoSeminarioTomo3a.mkdir();
        mVideoSeminarioTomo3b.mkdir();
        mVideoSeminarioTomo3c.mkdir();

        mVideoSeminarioTomo4a.mkdir();
        mVideoSeminarioTomo4b.mkdir();
        mVideoSeminarioTomo4c.mkdir();

        mVideoSeminarioTomo5a.mkdir();
        mVideoSeminarioTomo5b.mkdir();
        mVideoSeminarioTomo5c.mkdir();


        mProResueltos1.mkdir();
        mProResueltos2.mkdir();
        mProResueltos3.mkdir();
        mProResueltos4.mkdir();
        mProResueltos5.mkdir();
        mProResueltos6.mkdir();
        mProResueltos7.mkdir();
        mProResueltos8.mkdir();
        mProResueltos9.mkdir();
        mProResueltos10.mkdir();


        mCompendio1_1.mkdir();
        mCompendio1_2.mkdir();
        mCompendio1_3.mkdir();
        mCompendio1_4.mkdir();
        mCompendio1_5.mkdir();
        mCompendio1_6.mkdir();
        mCompendio1_7.mkdir();
        mCompendio1_8.mkdir();


        mMesPropuestos1a.mkdir();
        mMesPropuestos1b.mkdir();
        mMesPropuestos1c.mkdir();
        mMesPropuestos1d.mkdir();
        mMesPropuestos1e.mkdir();
        mMesPropuestos1f.mkdir();
        mMesPropuestos1g.mkdir();
        mMesPropuestos1h.mkdir();
        mMesPropuestos1i.mkdir();
        mMesPropuestos1j.mkdir();
        mMesPropuestos1k.mkdir();
        mMesPropuestos1l.mkdir();
        mMesPropuestos1m.mkdir();
        mMesPropuestos1n.mkdir();
        mMesPropuestos1o.mkdir();
        mMesPropuestos1p.mkdir();


        mMesPropuestos2a.mkdir();
        mMesPropuestos2b.mkdir();
        mMesPropuestos2c.mkdir();
        mMesPropuestos2d.mkdir();
        mMesPropuestos2e.mkdir();
        mMesPropuestos2f.mkdir();
        mMesPropuestos2g.mkdir();
        mMesPropuestos2h.mkdir();
        mMesPropuestos2i.mkdir();
        mMesPropuestos2j.mkdir();
        mMesPropuestos2k.mkdir();
        mMesPropuestos2l.mkdir();
        mMesPropuestos2m.mkdir();
        mMesPropuestos2n.mkdir();
        mMesPropuestos2o.mkdir();
        mMesPropuestos2p.mkdir();


        mMesPropuestos3a.mkdir();
        mMesPropuestos3b.mkdir();
        mMesPropuestos3c.mkdir();
        mMesPropuestos3d.mkdir();
        mMesPropuestos3e.mkdir();
        mMesPropuestos3f.mkdir();
        mMesPropuestos3g.mkdir();
        mMesPropuestos3h.mkdir();
        mMesPropuestos3i.mkdir();
        mMesPropuestos3j.mkdir();
        mMesPropuestos3k.mkdir();
        mMesPropuestos3l.mkdir();
        mMesPropuestos3m.mkdir();
        mMesPropuestos3n.mkdir();
        mMesPropuestos3o.mkdir();
        mMesPropuestos3p.mkdir();


        mMesPropuestos4a.mkdir();
        mMesPropuestos4b.mkdir();
        mMesPropuestos4c.mkdir();
        mMesPropuestos4d.mkdir();
        mMesPropuestos4e.mkdir();
        mMesPropuestos4f.mkdir();
        mMesPropuestos4g.mkdir();
        mMesPropuestos4h.mkdir();
        mMesPropuestos4i.mkdir();
        mMesPropuestos4j.mkdir();
        mMesPropuestos4k.mkdir();
        mMesPropuestos4l.mkdir();
        mMesPropuestos4m.mkdir();
        mMesPropuestos4n.mkdir();
        mMesPropuestos4o.mkdir();
        mMesPropuestos4p.mkdir();

        mMesPropuestos5a.mkdir();
        mMesPropuestos5b.mkdir();
        mMesPropuestos5c.mkdir();
        mMesPropuestos5d.mkdir();
        mMesPropuestos5e.mkdir();
        mMesPropuestos5f.mkdir();
        mMesPropuestos5g.mkdir();
        mMesPropuestos5h.mkdir();
        mMesPropuestos5i.mkdir();
        mMesPropuestos5j.mkdir();
        mMesPropuestos5k.mkdir();
        mMesPropuestos5l.mkdir();
        mMesPropuestos5m.mkdir();
        mMesPropuestos5n.mkdir();
        mMesPropuestos5o.mkdir();
        mMesPropuestos5p.mkdir();


        mMesPropuestos6a.mkdir();
        mMesPropuestos6b.mkdir();
        mMesPropuestos6c.mkdir();
        mMesPropuestos6d.mkdir();
        mMesPropuestos6e.mkdir();
        mMesPropuestos6f.mkdir();
        mMesPropuestos6g.mkdir();
        mMesPropuestos6h.mkdir();
        mMesPropuestos6i.mkdir();
        mMesPropuestos6j.mkdir();
        mMesPropuestos6k.mkdir();
        mMesPropuestos6l.mkdir();
        mMesPropuestos6m.mkdir();
        mMesPropuestos6n.mkdir();
        mMesPropuestos6o.mkdir();
        mMesPropuestos6p.mkdir();


        mMesPropuestos7a.mkdir();
        mMesPropuestos7b.mkdir();
        mMesPropuestos7c.mkdir();
        mMesPropuestos7d.mkdir();
        mMesPropuestos7e.mkdir();
        mMesPropuestos7f.mkdir();
        mMesPropuestos7g.mkdir();
        mMesPropuestos7h.mkdir();
        mMesPropuestos7i.mkdir();
        mMesPropuestos7j.mkdir();
        mMesPropuestos7k.mkdir();
        mMesPropuestos7l.mkdir();
        mMesPropuestos7m.mkdir();
        mMesPropuestos7n.mkdir();
        mMesPropuestos7o.mkdir();
        mMesPropuestos7p.mkdir();


        mMesPropuestos8a.mkdir();
        mMesPropuestos8b.mkdir();
        mMesPropuestos8c.mkdir();
        mMesPropuestos8d.mkdir();
        mMesPropuestos8e.mkdir();
        mMesPropuestos8f.mkdir();
        mMesPropuestos8g.mkdir();
        mMesPropuestos8h.mkdir();
        mMesPropuestos8i.mkdir();
        mMesPropuestos8j.mkdir();
        mMesPropuestos8k.mkdir();
        mMesPropuestos8l.mkdir();
        mMesPropuestos8m.mkdir();
        mMesPropuestos8n.mkdir();
        mMesPropuestos8o.mkdir();
        mMesPropuestos8p.mkdir();


        mMesPropuestos9a.mkdir();
        mMesPropuestos9b.mkdir();
        mMesPropuestos9c.mkdir();
        mMesPropuestos9d.mkdir();
        mMesPropuestos9e.mkdir();
        mMesPropuestos9f.mkdir();
        mMesPropuestos9g.mkdir();
        mMesPropuestos9h.mkdir();
        mMesPropuestos9i.mkdir();
        mMesPropuestos9j.mkdir();
        mMesPropuestos9k.mkdir();
        mMesPropuestos9l.mkdir();
        mMesPropuestos9m.mkdir();
        mMesPropuestos9n.mkdir();
        mMesPropuestos9o.mkdir();
        mMesPropuestos9p.mkdir();


        mMesPropuestos10a.mkdir();
        mMesPropuestos10b.mkdir();
        mMesPropuestos10c.mkdir();
        mMesPropuestos10d.mkdir();
        mMesPropuestos10e.mkdir();
        mMesPropuestos10f.mkdir();
        mMesPropuestos10g.mkdir();
        mMesPropuestos10h.mkdir();
        mMesPropuestos10i.mkdir();
        mMesPropuestos10j.mkdir();
        mMesPropuestos10k.mkdir();
        mMesPropuestos10l.mkdir();
        mMesPropuestos10m.mkdir();
        mMesPropuestos10n.mkdir();
        mMesPropuestos10o.mkdir();
        mMesPropuestos10p.mkdir();


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
        mCompendioTomo1q.mkdir();


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
        mCompendioTomo2q.mkdir();


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


        mMesResueltos1a.mkdir();
        mMesResueltos1b.mkdir();
        mMesResueltos1c.mkdir();
        mMesResueltos1d.mkdir();
        mMesResueltos1e.mkdir();
        mMesResueltos1f.mkdir();
        mMesResueltos1g.mkdir();
        mMesResueltos1h.mkdir();
        mMesResueltos1i.mkdir();
        mMesResueltos1j.mkdir();
        mMesResueltos1k.mkdir();
        mMesResueltos1l.mkdir();
        mMesResueltos1m.mkdir();
        mMesResueltos1n.mkdir();
        mMesResueltos1o.mkdir();
        mMesResueltos1p.mkdir();


        mMesResueltos2a.mkdir();
        mMesResueltos2b.mkdir();
        mMesResueltos2c.mkdir();
        mMesResueltos2d.mkdir();
        mMesResueltos2e.mkdir();
        mMesResueltos2f.mkdir();
        mMesResueltos2g.mkdir();
        mMesResueltos2h.mkdir();
        mMesResueltos2i.mkdir();
        mMesResueltos2j.mkdir();
        mMesResueltos2k.mkdir();
        mMesResueltos2l.mkdir();
        mMesResueltos2m.mkdir();
        mMesResueltos2n.mkdir();
        mMesResueltos2o.mkdir();
        mMesResueltos2p.mkdir();


        mMesResueltos3a.mkdir();
        mMesResueltos3b.mkdir();
        mMesResueltos3c.mkdir();
        mMesResueltos3d.mkdir();
        mMesResueltos3e.mkdir();
        mMesResueltos3f.mkdir();
        mMesResueltos3g.mkdir();
        mMesResueltos3h.mkdir();
        mMesResueltos3i.mkdir();
        mMesResueltos3j.mkdir();
        mMesResueltos3k.mkdir();
        mMesResueltos3l.mkdir();
        mMesResueltos3m.mkdir();
        mMesResueltos3n.mkdir();
        mMesResueltos3o.mkdir();
        mMesResueltos3p.mkdir();


        mMesResueltos4a.mkdir();
        mMesResueltos4b.mkdir();
        mMesResueltos4c.mkdir();
        mMesResueltos4d.mkdir();
        mMesResueltos4e.mkdir();
        mMesResueltos4f.mkdir();
        mMesResueltos4g.mkdir();
        mMesResueltos4h.mkdir();
        mMesResueltos4i.mkdir();
        mMesResueltos4j.mkdir();
        mMesResueltos4k.mkdir();
        mMesResueltos4l.mkdir();
        mMesResueltos4m.mkdir();
        mMesResueltos4n.mkdir();
        mMesResueltos4o.mkdir();
        mMesResueltos4p.mkdir();

        mMesResueltos5a.mkdir();
        mMesResueltos5b.mkdir();
        mMesResueltos5c.mkdir();
        mMesResueltos5d.mkdir();
        mMesResueltos5e.mkdir();
        mMesResueltos5f.mkdir();
        mMesResueltos5g.mkdir();
        mMesResueltos5h.mkdir();
        mMesResueltos5i.mkdir();
        mMesResueltos5j.mkdir();
        mMesResueltos5k.mkdir();
        mMesResueltos5l.mkdir();
        mMesResueltos5m.mkdir();
        mMesResueltos5n.mkdir();
        mMesResueltos5o.mkdir();
        mMesResueltos5p.mkdir();


        mMesResueltos6a.mkdir();
        mMesResueltos6b.mkdir();
        mMesResueltos6c.mkdir();
        mMesResueltos6d.mkdir();
        mMesResueltos6e.mkdir();
        mMesResueltos6f.mkdir();
        mMesResueltos6g.mkdir();
        mMesResueltos6h.mkdir();
        mMesResueltos6i.mkdir();
        mMesResueltos6j.mkdir();
        mMesResueltos6k.mkdir();
        mMesResueltos6l.mkdir();
        mMesResueltos6m.mkdir();
        mMesResueltos6n.mkdir();
        mMesResueltos6o.mkdir();
        mMesResueltos6p.mkdir();


        mMesResueltos7a.mkdir();
        mMesResueltos7b.mkdir();
        mMesResueltos7c.mkdir();
        mMesResueltos7d.mkdir();
        mMesResueltos7e.mkdir();
        mMesResueltos7f.mkdir();
        mMesResueltos7g.mkdir();
        mMesResueltos7h.mkdir();
        mMesResueltos7i.mkdir();
        mMesResueltos7j.mkdir();
        mMesResueltos7k.mkdir();
        mMesResueltos7l.mkdir();
        mMesResueltos7m.mkdir();
        mMesResueltos7n.mkdir();
        mMesResueltos7o.mkdir();
        mMesResueltos7p.mkdir();


        mMesResueltos8a.mkdir();
        mMesResueltos8b.mkdir();
        mMesResueltos8c.mkdir();
        mMesResueltos8d.mkdir();
        mMesResueltos8e.mkdir();
        mMesResueltos8f.mkdir();
        mMesResueltos8g.mkdir();
        mMesResueltos8h.mkdir();
        mMesResueltos8i.mkdir();
        mMesResueltos8j.mkdir();
        mMesResueltos8k.mkdir();
        mMesResueltos8l.mkdir();
        mMesResueltos8m.mkdir();
        mMesResueltos8n.mkdir();
        mMesResueltos8o.mkdir();
        mMesResueltos8p.mkdir();


        mMesResueltos9a.mkdir();
        mMesResueltos9b.mkdir();
        mMesResueltos9c.mkdir();
        mMesResueltos9d.mkdir();
        mMesResueltos9e.mkdir();
        mMesResueltos9f.mkdir();
        mMesResueltos9g.mkdir();
        mMesResueltos9h.mkdir();
        mMesResueltos9i.mkdir();
        mMesResueltos9j.mkdir();
        mMesResueltos9k.mkdir();
        mMesResueltos9l.mkdir();
        mMesResueltos9m.mkdir();
        mMesResueltos9n.mkdir();
        mMesResueltos9o.mkdir();
        mMesResueltos9p.mkdir();


        mMesResueltos10a.mkdir();
        mMesResueltos10b.mkdir();
        mMesResueltos10c.mkdir();
        mMesResueltos10d.mkdir();
        mMesResueltos10e.mkdir();
        mMesResueltos10f.mkdir();
        mMesResueltos10g.mkdir();
        mMesResueltos10h.mkdir();
        mMesResueltos10i.mkdir();
        mMesResueltos10j.mkdir();
        mMesResueltos10k.mkdir();
        mMesResueltos10l.mkdir();
        mMesResueltos10m.mkdir();
        mMesResueltos10n.mkdir();
        mMesResueltos10o.mkdir();
        mMesResueltos10p.mkdir();


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
        mDiapositivasTomo1r.mkdir();
        mDiapositivasTomo1s.mkdir();
        mDiapositivasTomo1t.mkdir();


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
        mDiapositivasTomo2r.mkdir();
        mDiapositivasTomo2s.mkdir();
        mDiapositivasTomo2t.mkdir();


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
        mDiapositivasTomo3r.mkdir();
        mDiapositivasTomo3s.mkdir();
        mDiapositivasTomo3t.mkdir();


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
        mDiapositivasTomo4r.mkdir();
        mDiapositivasTomo4s.mkdir();
        mDiapositivasTomo4t.mkdir();


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
        mDiapositivasTomo5r.mkdir();
        mDiapositivasTomo5s.mkdir();
        mDiapositivasTomo5t.mkdir();


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
        mDiapositivasTomo6r.mkdir();
        mDiapositivasTomo6s.mkdir();
        mDiapositivasTomo6t.mkdir();


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
        mDiapositivasTomo7r.mkdir();
        mDiapositivasTomo7s.mkdir();
        mDiapositivasTomo7t.mkdir();


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
        mDiapositivasTomo8r.mkdir();
        mDiapositivasTomo8s.mkdir();
        mDiapositivasTomo8t.mkdir();


    }


    @Override
    public void enviargrado(String mensaje) {
        gradoalumno = mensaje;
    }


}

