package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mEfisica;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoLetrasDiap;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;

public class adapterEFisica extends BaseAdapter {

    private Context context;
    private ArrayList<mEfisica> arrayList;

    ConnectionDetector cd;
    String urlADescargar;
    String ruta_storage;
    String ruta;



    public adapterEFisica(Context context, ArrayList<mEfisica> arrayList) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_efisica, null);

        }

        ImageView imgfoto = convertView.findViewById(R.id.img_efisica);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());



        return convertView;
    }

}
