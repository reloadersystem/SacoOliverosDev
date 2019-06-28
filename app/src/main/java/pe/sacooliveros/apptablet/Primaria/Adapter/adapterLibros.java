package pe.sacooliveros.apptablet.Primaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Model.mLibros;
import pe.sacooliveros.apptablet.R;

public class adapterLibros extends BaseAdapter {

    private Context context;
    private ArrayList<mLibros> arrayList;

    public adapterLibros(Context context, ArrayList<mLibros> arrayList) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_libros, null);

        }


        FrameLayout fr_tomoprim = convertView.findViewById(R.id.fr_tomoprim);

        // fr_tomoprim.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));


        ImageView imgfoto = convertView.findViewById(R.id.img_libros);

        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());


        return convertView;
    }
}
