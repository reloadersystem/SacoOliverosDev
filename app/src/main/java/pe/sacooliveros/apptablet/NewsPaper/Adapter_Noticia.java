package pe.sacooliveros.apptablet.NewsPaper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Model.M_ListNoticia;
import pe.sacooliveros.apptablet.R;

public class Adapter_Noticia extends ArrayAdapter {

    ArrayList<M_ListNoticia> m_noticia = new ArrayList<>();

    public Adapter_Noticia(@NonNull Context context, int resource, ArrayList<M_ListNoticia> m_noticia) {
        super(context, resource, m_noticia);
        this.m_noticia = m_noticia;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.item_noticia, null);


        M_ListNoticia curItem = (M_ListNoticia) getItem(position);

        if (curItem != null) {
            //Llamar a los TV
            TextView txTitulo = view.findViewById(R.id.tx_notTitulo);
            TextView txDesc = view.findViewById(R.id.tx_notDescripcion);
            TextView txUrl = view.findViewById(R.id.tx_notUrl);

            txTitulo.setText(curItem.getTitulo());
            txDesc.setText(curItem.getDescripcion());
            txUrl.setText(curItem.getUrl());


        }
        return view;
    }
}