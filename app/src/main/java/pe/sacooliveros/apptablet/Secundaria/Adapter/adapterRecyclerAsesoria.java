package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mTomosHelicoAsesoria;

public class adapterRecyclerAsesoria extends RecyclerView.Adapter<adapterRecyclerAsesoria.MyViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<mTomosHelicoAsesoria> mTomosHelicoAsesoriasList;

    private View.OnClickListener listener;

    public adapterRecyclerAsesoria(Context mContext, List<mTomosHelicoAsesoria> mTomosHelicoAsesoriasList) {
        this.mContext = mContext;
        this.mTomosHelicoAsesoriasList = mTomosHelicoAsesoriasList;
    }

    @NonNull
    @Override
    public adapterRecyclerAsesoria.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_asesoria_tomos, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterRecyclerAsesoria.MyViewHolder holder, int position) {

        holder.img_tomoAsesoria.setImageResource(mTomosHelicoAsesoriasList.get(position).getImageTomo());
        holder.text_tomoAsesoria.setText(mTomosHelicoAsesoriasList.get(position).getNombreTomo());

    }

    @Override
    public int getItemCount() {
        return mTomosHelicoAsesoriasList.size();
    }

    public void setOnclickListener(View.OnClickListener listener)
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


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_tomoAsesoria;
        private TextView text_tomoAsesoria;

        public MyViewHolder(View itemView) {
            super(itemView);

            img_tomoAsesoria= itemView.findViewById(R.id.img_tomosAsesoria);
            text_tomoAsesoria= itemView.findViewById(R.id.txt_titleAsesoria);

        }
    }
}
