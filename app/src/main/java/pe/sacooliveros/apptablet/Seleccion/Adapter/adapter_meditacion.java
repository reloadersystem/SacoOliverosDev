package pe.sacooliveros.apptablet.Seleccion.Adapter;

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
import pe.sacooliveros.apptablet.Seleccion.Model.M_ListMeditacion;

public class adapter_meditacion extends ArrayAdapter {


    private ArrayList<M_ListMeditacion> m_listmeditacion;

    public adapter_meditacion(@NonNull Context context, int resource, ArrayList<M_ListMeditacion> m_listmeditacion) {
        super(context, resource);
        this.m_listmeditacion = m_listmeditacion;
    }

    @Nullable
    @Override
    public M_ListMeditacion getItem(int position) {
        return this.m_listmeditacion.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from((getContext()));

        final View view = inflater.inflate(R.layout.item_listmedita, null);

        M_ListMeditacion curItem = getItem(position);

        if (curItem != null) {
            TextView tvDesc = view.findViewById(R.id.tv_meditadesc);
            TextView tvPage = view.findViewById(R.id.tv_meditaurl);

            tvDesc.setText(curItem.getDescripcion());
            tvPage.setText(curItem.getUrl());
        }

        return view;
    }

    @Override
    public int getCount() {
        return m_listmeditacion.size();
    }
}
