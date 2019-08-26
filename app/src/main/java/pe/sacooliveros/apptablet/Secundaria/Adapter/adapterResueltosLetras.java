package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoLetrasResueltos;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.DownloadsSave;
import pe.sacooliveros.apptablet.Utils.GeneralFileManager;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

public class adapterResueltosLetras extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoLetrasResueltos> arrayList;

    ConnectionDetector cd;
    String urlADescargar;
    String materiadownload;
    String ruta_storage;
    String ruta;
    static String mes;
    static String mesnumero;
    static String nivel;
    String servidor_ruta;
    DownloadsSave downloadsSave;

    String gradousuario;


    public adapterResueltosLetras(Context context, ArrayList<mTomoLetrasResueltos> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void instantiate(String servernivel) {
        nivel = servernivel; //2 "primaria
    }


    public static void mesletrasresueltos(String meswrite) {
        mes = meswrite;
        mesnumero = String.valueOf(mes.charAt(4));
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_resueltosletras, null);

        }

        final GeneralFileManager fileManager = new GeneralFileManager(context);

        downloadsSave = new DownloadsSave();

        ImageView imgresueltos = convertView.findViewById(R.id.img_letrasresueltos);
        ImageView imgdownload = convertView.findViewById(R.id.img_downletrasresueltos);

        imgresueltos.setImageResource(arrayList.get(position).getImagen_logo());
        imgdownload.setImageResource(arrayList.get(position).getImagen_logo2());

        servidor_ruta = context.getString(R.string.servidor_ruta);

        gradousuario = ShareDataRead.obtenerValor(context, "ServerGradoNivel");

        cd = new ConnectionDetector(context);

        if (nivel == null) {

            nivel = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);
        }

        imgresueltos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position) {
                    case 0:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PRM" + mesnumero + ".pdf", "LENGUAJE");
                        break;

                    case 1:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PRM" + mesnumero + ".pdf", "LITERATURA");
                        break;

                    case 2:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PRM" + mesnumero + ".pdf", "RAZONAMIENTO VERBAL");
                        break;

                    case 3:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PRM" + mesnumero + ".pdf", "HISTORIA DEL PERÚ");
                        break;

                    case 4:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PRM" + mesnumero + ".pdf", "GEOGRAFIA");
                        break;

                    case 5:

                        if (gradousuario.equalsIgnoreCase("1 Secundaria") || gradousuario.equalsIgnoreCase("2 Secundaria") || gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PRM" + mesnumero + ".pdf", "INGLES");
                        } else {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PRM" + mesnumero + ".pdf", "HISTORIA UNIVERSAL");
                        }
                        break;

                    case 6:
                        if (gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PRM" + mesnumero + ".pdf", "HISTORIA UNIVERSAL");
                        } else {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PRM" + mesnumero + ".pdf", "ECONOMIA");
                        }

                        break;

                    case 7:
                        if (gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PRM" + mesnumero + ".pdf", "ECONOMIA");
                        } else {
                            fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf", "PSICOLOGIA");
                        }

                        break;

                    case 8:
                        fileManager.manageFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf", "PSICOLOGIA");
                        break;
                }
            }
        });

        imgdownload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (nivel == null) {
                    nivel = ShareDataRead.obtenerValor(context, "ServerGradoNivel").substring(0, 1);
                }

                switch (position) {

                    case 0:
                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/LENGUAJE/LENGUAJE2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - LENGUAJE");
                        break;

                    case 1:
                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/LITERATURA/LITERATURA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - LITERATURA");
                        break;

                    case 2:
                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - RAZONAMIENTO VERBAL");
                        break;

                    case 3:
                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_DEL_PERU/HISTORIA_DEL_PERU2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - HISTORIA DEL PERU");
                        break;

                    case 4:
                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/GEOGRAFIA/GEOGRAFIA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - GEOGRAFIA");
                        break;


                    case 5:

                        if (gradousuario.equalsIgnoreCase("1 Secundaria") || gradousuario.equalsIgnoreCase("2 Secundaria") || gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {
                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/INGLES/INGLES2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - INGLES");
                        } else {
                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - HISTORIA UNIVERSAL");
                        }
                        break;

                    case 6:
                        if (gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {

                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/HISTORIA_UNIVERSAL/HISTORIA_UNIVERSAL2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - HISTORIA UNIVERSAL");
                        } else {
                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - ECONOMIA");
                        }
                        break;


                    case 7:
                        if (gradousuario.equalsIgnoreCase("3 Secundaria") || gradousuario.equalsIgnoreCase("4 Secundaria")) {
                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/ECONOMIA/ECONOMIA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - ECONOMIA");
                        } else {
                            fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - PSICOLOGIA");
                        }
                        break;

                    case 8:

                        fileManager.downloadFileView("/APP/2/" + nivel + "/PROBLEMAS_RESUELTOS/MES" + mesnumero + "/PSICOLOGIA/PSICOLOGIA2" + nivel + "_PRM" + mesnumero + ".pdf", "Problemas Resueltos - MES " + mesnumero + " - PSICOLOGIA");

                        break;
                }
            }
        });

        return convertView;
    }
}
