package pe.sacooliveros.apptablet.Seleccion.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Seleccion.Model.MSemestralSM;

public class adapterSemestralSM extends BaseAdapter {

    Context context;
    ArrayList<MSemestralSM> arrayList;


    public adapterSemestralSM(Context context, ArrayList<MSemestralSM> arrayList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_examenanual,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.tomo_img);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());

        return convertView;
    }


}
