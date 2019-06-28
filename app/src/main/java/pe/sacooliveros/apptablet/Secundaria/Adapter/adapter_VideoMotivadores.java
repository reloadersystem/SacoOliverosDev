package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mVideoMotivadores;

public class adapter_VideoMotivadores extends BaseAdapter {

    private Context context;
    private ArrayList<mVideoMotivadores> arrayList;


    public adapter_VideoMotivadores(Context context, ArrayList<mVideoMotivadores> arrayList) {
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
            convertView= LayoutInflater.from(context).inflate(R.layout.item_videomotivadores,null);
        }

        FrameLayout frameLayout= convertView.findViewById(R.id.fr_videomotivadores);
       // frameLayout.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_scale_animation));


        ImageView imgfoto= convertView.findViewById(R.id.img_videomotivadores);
        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());


        return convertView;
    }
}
