package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import pe.sacooliveros.apptablet.FragmentNavigator.HelicoBalotariosActivity;
import pe.sacooliveros.apptablet.PptViewer;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoDiapo;
import pe.sacooliveros.apptablet.Secundaria.Model.mVSeminario;
import pe.sacooliveros.apptablet.Secundaria.fragments.DiapositivasTomosFrag;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentHelicoBalotarios;
import pe.sacooliveros.apptablet.Secundaria.fragments.fragmentVSeminario;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.ViewTomo3Activity;
import pe.sacooliveros.apptablet.YouTube.YouTubeViewer;

public class adapterVSeminario extends BaseAdapter {

    private Context context;
    private ArrayList<mVSeminario> arrayList;
    ConnectionDetector cd;

    static String numgrado;

    String servidor_ruta;

    static String cicloespecial;

    static String tomo;

    static String  tomonumero;

    public adapterVSeminario(Context context, ArrayList<mVSeminario> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    public static void gradoacceso(String grado)
    {
        numgrado = grado;

    }

    public static void gradoasiste(String gradonum)
    {
        cicloespecial = gradonum;

    }
    public static void tomoVSeminario(String tomowrite)
    {
        tomo= tomowrite;
        tomonumero= (String.valueOf(tomo.charAt(4)));

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
    public View getView(final int position, View convertView, ViewGroup viewGroup)
    {
        if(cicloespecial.equalsIgnoreCase("UNI"))
        {
            cicloespecial="3";
        }
        else if(cicloespecial.equalsIgnoreCase("Regular")|| cicloespecial.equalsIgnoreCase("CIRCULO"))
        {
            cicloespecial = "2";
        }

        else if(cicloespecial.equalsIgnoreCase("SAN MARCOS"))
        {
            cicloespecial = "4";
        }

        else if(cicloespecial.equalsIgnoreCase("CATOLICA"))
        {
            cicloespecial = "5";
        }

        else if(cicloespecial.equalsIgnoreCase("PRE"))
        {
            cicloespecial = "6";
        }

        if(convertView==null)
    {
        convertView= LayoutInflater.from(context).inflate(R.layout.item_vseminario,null);

    }

        ImageView imgfoto= convertView.findViewById(R.id.img_vseminario);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());


        servidor_ruta = context.getString(R.string.servidor_ruta);

        cd = new ConnectionDetector(context);

        imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (position)

                {
                    case 0:

                        if (cd.isConnected()) {

                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/NUMERO_OPERACIONES/NUMERO_OPERACIONE55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "NÚMERO Y OPERACIONES");
                                context.startActivity(intent);

                                break;

                            }


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/FISICA/FISICA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "FISICA");
                            context.startActivity(intent);

                        }


                        break;


                    case 1:


                        if (cd.isConnected()) {



                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/ANALISIS_ABSTRACCION/ANALISIS_ABSTRACCION55_VHS.pdf";
                                //String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/FISICA/FISICA"+cicloespecial+numgrado+"_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "ANÁLISIS Y ABSTRACCIÓN");
                                context.startActivity(intent);
                                break;


                            }

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/QUIMICA/QUIMICA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "QUIMICA");
                            context.startActivity(intent);

                        }


                        break;


                    case 2:

                        if (cd.isConnected()) {


                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/PLANIMETRIA/PLANIMETRIA55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "PLANIMETRIA");
                                context.startActivity(intent);
                                break;


                            }


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/ARITMETICA/ARITMETICA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ARITMETICA");
                            context.startActivity(intent);

                        }


                        break;


                    case 3:

                        if (cd.isConnected()) {


                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/ESTADISTICA/ESTADISTICA55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "ESTADISTICA");
                                context.startActivity(intent);
                                break;


                            }


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/GEOMETRIA/GEOMETRIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOMETRIA");
                            context.startActivity(intent);

                        }

                        break;



                    case 4:

                        if(cicloespecial=="5")

                        {
                            String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/PROGRAMACION_LINEAL/PROGRAMACION_LINEAL55_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PROGRAMACION LINEAL");
                            context.startActivity(intent);
                            break;


                        }




                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/ALGEBRA/ALGEBRA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ALGEBRA");
                            context.startActivity(intent);


                        }

                        break;



                    case 5:

                        if (cd.isConnected()) {

                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/REDACCION_DELENGUAJE/REDACCION_DELENGUAJE55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "REDACCIÓN USOS DEL LENGUAJE");
                                context.startActivity(intent);
                                break;


                            }


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/TRIGONOMETRIA/TRIGONOMETRIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "TRIGONOMETRIA");
                            context.startActivity(intent);

                        }

                        break;

                    case 6:
                        if(cicloespecial=="4" ||cicloespecial=="3" )
                        {
                            Toast.makeText(context, "Material No Disponible", Toast.LENGTH_SHORT).show();


                        }else

                        {

                            if (cd.isConnected()) {

                                if(cicloespecial=="5")

                                {
                                    String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/LECTURA_CRITICA/LECTURA_CRITICA55_VHS.pdf";

                                    Intent intent = new Intent(context, ViewTomo3Activity.class);

                                    intent.putExtra("ViewType", "internet");
                                    intent.putExtra("URL", URL);
                                    intent.putExtra("Materia", "LECTURA CRÍTICA");
                                    context.startActivity(intent);
                                    break;


                                }

                                String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/RAZONAMIENTO_MATEMATICO/RAZONAMIENTO_MATEMATICO"+cicloespecial+numgrado+"_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "RAZONAMIENTO_MATEMATICO");
                                context.startActivity(intent);

                            }
                        }
                        break;



                    case 7:


                        if (cd.isConnected()) {


                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/COMPRENSION_LECTORA/COMPRENSION_LECTORA55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "COMPRENSIÓN LECTORA");
                                context.startActivity(intent);
                                break;


                            }


                            //http://192.169.218.177/APP/3/5/VIDEO_HELICO_SEMINARIO/LENGUAJE/LENGUAJE35_VHS.pdf

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/LENGUAJE/LENGUAJE"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LENGUAJE");
                            context.startActivity(intent);

                        }

                        break;



                    case 8:


                        if (cd.isConnected()) {


                            if(cicloespecial=="5")

                            {
                                String  URL= servidor_ruta+"/APP/5/5/VIDEO_HELICO_SEMINARIO/"+tomo+"/ILATIVOS_DELENGUAJE/ILATIVOS_DELENGUAJE55_VHS.pdf";

                                Intent intent = new Intent(context, ViewTomo3Activity.class);

                                intent.putExtra("ViewType", "internet");
                                intent.putExtra("URL", URL);
                                intent.putExtra("Materia", "ILATIVOS USOS DEL LENGUAGE");
                                context.startActivity(intent);
                                break;


                            }


                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/LITERATURA/LITERATURA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "LITERATURA");
                            context.startActivity(intent);

                        }

                        break;



                    case 9:


                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/RAZONAMIENTO_VERBAL/RAZONAMIENTO_VERBAL"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "RAZONAMIENTO VERBAL");
                            context.startActivity(intent);

                        }

                        break;


                    case 10:


                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/HP/HP"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA DEL PERÚ");
                            context.startActivity(intent);

                        }

                        break;


                    case 11:


                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/HU/HU"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "HISTORIA UNIVERSAL");
                            context.startActivity(intent);

                        }

                        break;


                    case 12:

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/GEOGRAFIA/GEOGRAFIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "GEOGRAFIA");
                            context.startActivity(intent);

                        }


                        break;


                    case 13:

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/ECONOMIA/ECONOMIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "ECONOMÍA");
                            context.startActivity(intent);

                        }



                        break;



                    case 14:

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/PSICOLOGIA/PSICOLOGIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "PSICOLOGIA");
                            context.startActivity(intent);

                        }

                        break;


                    case 15:

                        if (cd.isConnected()) {

                            String URL = servidor_ruta+"/APP/"+cicloespecial+"/"+numgrado+"/VIDEO_HELICO_SEMINARIO/BIOLOGIA/BIOLOGIA"+cicloespecial+numgrado+"_VHS.pdf";

                            Intent intent = new Intent(context, ViewTomo3Activity.class);

                            intent.putExtra("ViewType", "internet");
                            intent.putExtra("URL", URL);
                            intent.putExtra("Materia", "BIOLOGIA");
                            context.startActivity(intent);

                        }


                }
            }

        });


        return convertView;
    }


}
