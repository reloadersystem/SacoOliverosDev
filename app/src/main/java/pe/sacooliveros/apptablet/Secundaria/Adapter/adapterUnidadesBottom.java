package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mUnidadesBottom;

public class adapterUnidadesBottom extends RecyclerView.Adapter<adapterUnidadesBottom.UnidadesViewHolder> implements View.OnClickListener {

    Context context;
    ArrayList<mUnidadesBottom> mUnidades;

    private View.OnClickListener listener;

    public adapterUnidadesBottom(Context context, ArrayList<mUnidadesBottom> mUnidades) {
        this.context = context;
        this.mUnidades = mUnidades;
    }

    @NonNull
    @Override
    public adapterUnidadesBottom.UnidadesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listbottom, null);
        view.setOnClickListener(this);
        return new UnidadesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterUnidadesBottom.UnidadesViewHolder holder, int position) {

        holder.descripcion.setText(mUnidades.get(position).getDescripcion());

        holder.imageView.setImageResource(mUnidades.get(position).getPhotoimg());

    }

    @Override
    public int getItemCount() {
        return mUnidades.size();
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


    public class UnidadesViewHolder extends RecyclerView.ViewHolder {

        public TextView descripcion;

        public ImageView imageView;

        public UnidadesViewHolder(View itemView) {
            super(itemView);

            descripcion= itemView.findViewById(R.id.textDescription);
            imageView=itemView.findViewById(R.id.img_bottomsheet);
        }
    }

}
