package pe.sacooliveros.apptablet.DownloadPDF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.R;

/**
 * Created by sistem03user on 13/11/2018.
 */

public class adapter extends BaseAdapter{

    private Context context;
    private ArrayList<mPdf> arrayList;


    public adapter(Context context, ArrayList<mPdf> arrayList) {
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

        mPdf Item= (mPdf) getItem(position);

        if(convertView==null)
        {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_pdflist,null);

        }

        ImageView imgfoto= convertView.findViewById(R.id.imageView2);
        final TextView descripcion= convertView.findViewById(R.id.txtdescripcion);
        final TextView estado=convertView.findViewById(R.id.txtestado);


//
//        imgfoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String desc= descripcion.getText().toString();
//                Toast.makeText(context, desc, Toast.LENGTH_SHORT).show();
//
//            }
//        });


        imgfoto.setImageResource(arrayList.get(position).getImagen_logo());
        descripcion.setText(arrayList.get(position).getDescripcion());
        estado.setText(arrayList.get(position).getEstado());



        return convertView;
    }
}
