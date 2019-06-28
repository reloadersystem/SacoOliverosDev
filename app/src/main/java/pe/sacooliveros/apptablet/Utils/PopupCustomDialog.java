package pe.sacooliveros.apptablet.Utils;

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

public class PopupCustomDialog {

    public Context dataContext;

    public void customDialog(final Context context, String title, ArrayList arrayList) {
        dataContext = context;

        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popup_customdialog, null);

        GridView lvView = view2.findViewById(R.id.grid_pruebas);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        TextView txt_titulo = view2.findViewById(R.id.txt_titulo);

        txt_titulo.setText(title);

        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        final adapterPruebas adapter2 = new adapterPruebas(context, arrayList);
        lvView.setAdapter(adapter2);

        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int motivadorcount = adapterView.getCount();

                mPruebas mPruebas = (mPruebas) adapter2.getItem(position);

                for (int a = 0; a < motivadorcount; a++) {

                    if (position == a) {

                        Uri uri = Uri.parse(mPruebas.getUrldata());
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
