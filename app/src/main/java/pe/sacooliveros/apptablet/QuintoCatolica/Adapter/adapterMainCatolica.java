package pe.sacooliveros.apptablet.QuintoCatolica.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoCatolica.Model.mMainCatolica;
import pe.sacooliveros.apptablet.QuintoSanMarcos.Model.mMainSM;
import pe.sacooliveros.apptablet.R;

public class adapterMainCatolica extends BaseAdapter {

    private Context context;
    private ArrayList<mMainCatolica> arrayList;


    public adapterMainCatolica(Context context, ArrayList<mMainCatolica> arrayList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_mainsm,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.img_mainCatolicalist);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());


        return convertView;
    }
}
