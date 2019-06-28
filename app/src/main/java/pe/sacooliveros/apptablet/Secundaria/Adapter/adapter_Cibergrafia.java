package pe.sacooliveros.apptablet.Secundaria.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.M_Cybergrafia;

public class adapter_Cibergrafia extends BaseAdapter {


    private Context context;
    private ArrayList<M_Cybergrafia> arrayList;

    public adapter_Cibergrafia(Context context, ArrayList<M_Cybergrafia> arrayList) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cibergrafia, null);

        }

        TextView tvDesc = convertView.findViewById(R.id.tvDescription);
        TextView tvPage = convertView.findViewById(R.id.tvPage);

        tvDesc.setText(arrayList.get(position).getDescripcion());
        tvPage.setText(arrayList.get(position).getUrl());

        return convertView;
    }
}
