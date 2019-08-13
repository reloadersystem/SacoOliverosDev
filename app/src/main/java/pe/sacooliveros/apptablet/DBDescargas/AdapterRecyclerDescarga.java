package pe.sacooliveros.apptablet.DBDescargas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;

public class AdapterRecyclerDescarga extends RecyclerView.Adapter<AdapterRecyclerDescarga.DescargaViewHolder> implements View.OnClickListener {

    ArrayList<Descargas> listaDescargas;

    private View.OnClickListener listener;

    Context context;

//    public AdapterRecyclerDescarga(ArrayList<Descargas> listaDescargas) {
//        this.listaDescargas = listaDescargas;
//    }


    public AdapterRecyclerDescarga(ArrayList<Descargas> listaDescargas, Context context) {
        this.listaDescargas = listaDescargas;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterRecyclerDescarga.DescargaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_descarga, null);
        view.setOnClickListener(this);
        return new DescargaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerDescarga.DescargaViewHolder holder, int position) {

//        holder.imageView.setAnimation(AnimationUtils.loadAnimation(context , R.anim.fade_transition_animation));
//        holder.card_animdownload.setAnimation(AnimationUtils.loadAnimation(context , R.anim.fade_scale_animation));

        holder.fecha.setText(listaDescargas.get(position).getFecha());
        holder.nombre.setText(listaDescargas.get(position).getNombre());

        //holder.chk_eliminarItem
    }

    @Override
    public int getItemCount() {
        return listaDescargas.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener= listener;
    }

    @Override
    public void onClick(View view) {

        if(listener!=null)
        {
            listener.onClick(view);

        }

    }

    public class DescargaViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;

        public TextView ruta;

        public TextView fecha;

        public ImageView imageView;

        public CardView card_animdownload;



        public DescargaViewHolder(View itemView) {
            super(itemView);

            card_animdownload= itemView.findViewById(R.id.card_animdownload);

            fecha = itemView.findViewById(R.id.edt_itemfecha);
            nombre= itemView.findViewById(R.id.edt_itemfile);
            ruta= itemView.findViewById(R.id.edt_itemrutaurl);
            imageView=itemView.findViewById(R.id.img_item);
            imageView=itemView.findViewById(R.id.img_item);


        }
    }

    public  void eliminardescarga()
    {
       // listaDescargas = new ArrayList<>();
        listaDescargas.clear();
        notifyDataSetChanged();

    }

}
