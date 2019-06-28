package pe.sacooliveros.apptablet.QuintoUniversidades.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;
import pe.sacooliveros.apptablet.QuintoUniversidades.Model.mExamenCapitulos;
import pe.sacooliveros.apptablet.R;

public class adapterExamenCap extends BaseAdapter {

    private Context context;
    private ArrayList<mExamenCapitulos> arrayList;

    public adapterExamenCap(Context context, ArrayList<mExamenCapitulos> arrayList) {
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
        return position ;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_examencap,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.img_capexam);


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());

        return convertView;
    }
}
