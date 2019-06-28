package pe.sacooliveros.apptablet.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoUniversidades.fragments.ContentLecturasFragment;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapterPruebas;
import pe.sacooliveros.apptablet.Seleccion.Model.mPruebas;

public class LecturasMotivadoras {

    public Context dataContext;

    private ContentLecturasFragment contentLecturasFragment;

    // Llamada Super Clase
    //LecturasMotivadoras lecturasMotivadoras = new LecturasMotivadoras();
    //                    lecturasMotivadoras.customDialog(getContext());

    public void customDialog(final Context context) {
        dataContext = context;

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popuplecturas, null);

        GridView lvView = view2.findViewById(R.id.grid_pruebas);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        ImageButton imageView = view2.findViewById(R.id.img_meditapp);




        contentLecturasFragment = new ContentLecturasFragment();

        String tipogrado = ShareDataRead.obtenerValor(dataContext, "TipoGradoAsiste");


        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        ArrayList<mPruebas> mListPruebas;

        mListPruebas = new ArrayList<mPruebas>();

        mListPruebas.add(new mPruebas("CON JIMMY EN PARACAS", "http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf"));
        mListPruebas.add(new mPruebas("BATMAN ONE YEAR", "https://vercomics.com/batman-ano-uno-1/"));
        mListPruebas.add(new mPruebas("SOLO PARA FUMADORES", "https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/"));
        mListPruebas.add(new mPruebas("BATMAN THE KILLING JOKE", "https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf"));

        final adapterPruebas adapter2 = new adapterPruebas(context, mListPruebas);
        lvView.setAdapter(adapter2);

        if (tipogrado.equalsIgnoreCase("CATOLICA")) {

            Button btn_materiales = view2.findViewById(R.id.btn_materiales);

            btn_materiales.setVisibility(View.VISIBLE);


            btn_materiales.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    GeneralFragmentManager.setFragmentWithReplace((Activity) context, R.id.contenedorFragments, contentLecturasFragment);
                    alertDialog.dismiss();

                }
            });
        }


        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                switch (position) {
                    case 0:

                    {
                        Uri uri = Uri.parse("http://docs.google.com/gview?embedded=true&url=http://red.ilce.edu.mx/sitios/el_otono_2014/entrale/entrale_2000/pdf/jimmy.pdf");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);

                    }
                    break;


                    case 1:

                    {
                        Uri uri = Uri.parse("https://vercomics.com/batman-ano-uno-1/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);

                    }
                    break;


                    case 2:

                    {
                        Uri uri = Uri.parse("https://klimtbalan.wordpress.com/solo-para-fumadores-julio-ramon-ribeyro/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);

                    }
                    break;


                    case 3:

                    {
                        Uri uri = Uri.parse("https://www.dropbox.com/s/y1pweeopm90qidk/Batman-La-broma-asesina_.pdf?dl=0#Batman-La-broma-asesina_.pdf");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        dataContext.startActivity(intent);
                    }
                    break;
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
