package pe.sacooliveros.apptablet.Seleccion.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mPopupVideoMotivadores;

public class adapter_PopupMotivadores extends BaseAdapter {

    Context context;
    ArrayList<mPopupVideoMotivadores> arrayList;

    public adapter_PopupMotivadores(Context context, ArrayList<mPopupVideoMotivadores> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_seleccionpruebas, null);
        }

        TextView txtitulo = convertView.findViewById(R.id.tx_titulo);
        TextView txt_urldescripcion = convertView.findViewById(R.id.tv_descripcion);

        txtitulo.setText(arrayList.get(position).getTitulo());
        txt_urldescripcion.setText(arrayList.get(position).getUrldata());

        return convertView;
    }

}