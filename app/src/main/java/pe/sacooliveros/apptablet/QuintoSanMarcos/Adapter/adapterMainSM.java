package pe.sacooliveros.apptablet.QuintoSanMarcos.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.QuintoSanMarcos.Model.mMainSM;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mMainU;
import pe.sacooliveros.apptablet.R;

public class adapterMainSM  extends BaseAdapter {

    private Context context;
    private ArrayList<mMainSM> arrayList;


    public adapterMainSM(Context context, ArrayList<mMainSM> arrayList) {
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

        ImageView imgfoto= convertView.findViewById(R.id.img_mainSMlist);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());



        return convertView;
    }
}
