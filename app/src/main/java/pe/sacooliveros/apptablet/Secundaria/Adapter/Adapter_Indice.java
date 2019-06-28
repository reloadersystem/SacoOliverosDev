package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Indice;

public class Adapter_Indice extends ArrayAdapter {
    ArrayList<M_Indice> elements = new ArrayList<>();


    public Adapter_Indice(@NonNull Context context, int resource,  ArrayList<M_Indice> elements) {
        super(context, resource, elements);
        this.elements = elements;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.item_indice, null);

        M_Indice curItem = (M_Indice) getItem(position);
        if (curItem != null) {
            //Llamar a los TV
            TextView tvDesc = view.findViewById(R.id.tvDescription);
            tvDesc.setText(curItem.getDescripcion());

            TextView tvPage = view.findViewById(R.id.tvPage);
            //tvPage.setText(curItem.getPagina());
            tvPage.setText(curItem.getPagina_doc());
        }
        return view;
    }
}
