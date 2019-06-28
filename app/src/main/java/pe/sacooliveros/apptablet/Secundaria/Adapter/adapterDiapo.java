package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomoDiapo;

public class adapterDiapo extends BaseAdapter {

    private Context context;
    private ArrayList<mTomoDiapo> arrayList;

    public adapterDiapo(Context context, ArrayList<mTomoDiapo> arrayList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_diapo,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.img_initlist);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());

        return convertView;
    }
}
