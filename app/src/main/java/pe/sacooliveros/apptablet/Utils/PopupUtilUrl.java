package pe.sacooliveros.apptablet.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mPopupVideoMotivadores;
import pe.sacooliveros.apptablet.Seleccion.Adapter.adapter_PopupMotivadores;

public class PopupUtilUrl {

    public Context dataContext;


    public void customDialog(Context context, String title, ArrayList arrayList) {
        final AlertDialog alertDialog;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view2 = inflater.inflate(R.layout.popupmotivadores, null);

        GridView lvView = view2.findViewById(R.id.grid_motivacion);
        Button btn_cerrar = view2.findViewById(R.id.btn_cerrar);
        TextView txmotivadores = view2.findViewById(R.id.txt_motivadores);

        builder.setView(view2);
        alertDialog = builder.create();
        alertDialog.show();

        txmotivadores.setText(title);

        ArrayList <mPopupVideoMotivadores>dataarray= arrayList;

        dataarray= new ArrayList<mPopupVideoMotivadores>();

        final adapter_PopupMotivadores adapter2 = new adapter_PopupMotivadores(context, dataarray);
        lvView.setAdapter(adapter2);

        lvView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int motivadorcount = adapterView.getCount();

                //mPopupVideoMotivadores mPopupVideoMotivadores= (mPopupVideoMotivadores) adapterView.getItem(position);

//                                for(int data=0; data<= motivadorcount; data++)
//
//                                {
                if (position == 1) {
                    //Toast.makeText(getContext(),adapterView.getSelectedItem, Toast.LENGTH_SHORT).show();
                }
                //}


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
