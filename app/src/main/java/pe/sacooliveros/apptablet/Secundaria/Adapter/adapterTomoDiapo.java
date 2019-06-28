package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Secundaria.Model.mNumTomoDiapo;
import pe.sacooliveros.apptablet.R;

public class adapterTomoDiapo extends BaseAdapter {

    private Context context;
    private ArrayList<mNumTomoDiapo> arrayList;


    public adapterTomoDiapo(Context context, ArrayList<mNumTomoDiapo> arrayList) {
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

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_tomodiapo,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.img_tomoDiap);
        final TextView descripcion= convertView.findViewById(R.id.txt_tomoDiapo);
        final TextView estado=convertView.findViewById(R.id.txt_detatomoDiapo);
        ImageView imgdownload= convertView.findViewById(R.id.cir_downloadDiapo);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        descripcion.setText(arrayList.get(position).getDescripcion());
        estado.setText(arrayList.get(position).getDetalle());
        imgdownload.setImageResource(arrayList.get(position).getImgdownload());



        return convertView;
    }
}
