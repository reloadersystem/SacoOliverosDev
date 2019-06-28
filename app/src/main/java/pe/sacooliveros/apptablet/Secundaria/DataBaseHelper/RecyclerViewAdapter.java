package pe.sacooliveros.apptablet.Secundaria.DataBaseHelper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.Model;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.GeneralFileManager;
import pe.sacooliveros.apptablet.ViewTomo3Activity;
import pe.sacooliveros.apptablet.YouTube.YouTubeViewer;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Model> mModelList;

    ConnectionDetector conn;

    public RecyclerViewAdapter(Context mContext, List<Model> mModelList) {
        this.mContext = mContext;
        this.mModelList = mModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {


        conn = new ConnectionDetector(mContext);

        final Model model = mModelList.get(position);

        holder.txtcodigo.setText(model.getCodigo());
        holder.txtasignatura.setText(model.getAsignatura());
        holder.txtcapitulo.setText(model.getCapitulo());
        holder.txturlpdf.setText(model.getUrlpdf());
        holder.txtssdpdf.setText(model.getSsdpdf());
        holder.imagendb.setImageResource(R.drawable.ciencias_1);
        holder.listyoutube.setText(model.getListyoutube());
        holder.imagedownload.setImageResource(R.drawable.ic_file_download_red);

        boolean habilita = model.isHabilitar();

        holder.txt_deshabilitardb.setText(String.valueOf(habilita));

        final String materia = model.getAsignatura();

//        if (habilita) {
//            holder.txtcodigo.setEnabled(false);
//            holder.cardview_id.setBackgroundColor(Color.GRAY);
//            holder.txtcodigo.setTextColor(Color.WHITE);
//            }
//        else {
//            holder.cardview_id.setEnabled(true);
//            }

        if (materia.equalsIgnoreCase("Fisica") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_1);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

//            holder.txtcodigo.setEnabled(false);
//            holder.txtasignatura.setEnabled(false);
//            holder.txtcapitulo.setEnabled(false);
//            holder.txturlpdf.setEnabled(false);
//            holder.txtssdpdf.setEnabled(false);
//            holder.txt_deshabilitardb.setEnabled(false);
            // holder.cardview_id.setBackgroundColor(Color.GRAY);
            // holder.txtcodigo.setTextColor(Color.GRAY);

        } else if (materia.equalsIgnoreCase("Quimica") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_2);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Biologia") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_3);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Aritmetica") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_4);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Algebra") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_5);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);


        } else if (materia.equalsIgnoreCase("Geometria") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_6);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Trigonometria") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_7);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Razonamiento Matematico") && habilita) {
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagendb.setImageResource(R.drawable.ciencias_8);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);


        } else if (materia.equalsIgnoreCase("Lenguaje") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_1);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Literatura") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_2);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Razonamiento Verbal") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_3);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Historia del Peru") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_4);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Geografia") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_5);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Historia Universal") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_6);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Economia") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_7);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);

        } else if (materia.equalsIgnoreCase("Psicologia") && habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_8);
            holder.imagepdf.setImageResource(R.drawable.adobegris);
            holder.imagepdf.setEnabled(false);
            holder.imagedownload.setImageResource(R.drawable.ic_file_download_gray);
            holder.imagedownload.setEnabled(false);
        }


        if (materia.equalsIgnoreCase("Fisica") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_1);
        } else if (materia.equalsIgnoreCase("Quimica") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_2);
        } else if (materia.equalsIgnoreCase("Biologia") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_3);
        } else if (materia.equalsIgnoreCase("Aritmetica") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_4);
        } else if (materia.equalsIgnoreCase("Algebra") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_5);
        } else if (materia.equalsIgnoreCase("Geometria") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_6);
        } else if (materia.equalsIgnoreCase("Trigonometria") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_7);
        } else if (materia.equalsIgnoreCase("Razonamiento Matematico") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.ciencias_8);
        } else if (materia.equalsIgnoreCase("Lenguaje") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_1);
        } else if (materia.equalsIgnoreCase("Literatura") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_2);
        } else if (materia.equalsIgnoreCase("Razonamiento Verbal") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_3);
        } else if (materia.equalsIgnoreCase("Historia del Peru") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_4);
        } else if (materia.equalsIgnoreCase("Geografia") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_5);
        } else if (materia.equalsIgnoreCase("Historia Universal") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_6);
        } else if (materia.equalsIgnoreCase("Economia") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_7);
        } else if (materia.equalsIgnoreCase("Psicologia") && !habilita) {
            holder.imagendb.setImageResource(R.drawable.letras_8);
        }

        holder.imagepdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (conn.isConnected()) {
                    String materiacurso = model.getAsignatura();
//                String capitulo = model.getCapitulo();
                    String urlpdf = model.getUrlpdf();

                    Intent intent = new Intent(mContext, ViewTomo3Activity.class);
                    intent.putExtra("ViewType", "internet");
                    intent.putExtra("URL", urlpdf);
                    intent.putExtra("Materia", materiacurso);
                    mContext.startActivity(intent);
                } else {
                    Toast.makeText(mContext, "Estas  Sin Conexión", Toast.LENGTH_SHORT).show();
                }


                //  Toast.makeText(mContext, materiacurso + " Capítulo " + capitulo, Toast.LENGTH_SHORT).show();
            }
        });


        holder.imagedownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final GeneralFileManager fileManager = new GeneralFileManager(mContext);


                String urlpdf = model.getUrlpdf();

                String materiacurso = model.getAsignatura();

                String ssdpdf = model.getSsdpdf();

                String capitulo = model.getCapitulo();

                fileManager.downloadFileView(ssdpdf, "Video Seminario Capítulo - " + capitulo + "  - " + materiacurso);

            }
        });

        holder.imagevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (conn.isConnected()) {
                    String listyoutube = model.getListyoutube();
                    String capitulo = model.getCapitulo();

                    if (listyoutube.equalsIgnoreCase("")) {

                        Toast.makeText(mContext, "Contenido no Disponible", Toast.LENGTH_SHORT).show();

                    } else {
                        String listChanel = listyoutube;
                        Intent intent = new Intent(mContext, YouTubeViewer.class);
                        intent.putExtra("lista_canal", listChanel);
                        mContext.startActivity(intent);

                    }
                } else {
                    Toast.makeText(mContext, "Estás Sin Conexion", Toast.LENGTH_SHORT).show();
                }


            }
        });

        holder.imagendb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {

        return mModelList == null ? 0 : mModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View view;
        private TextView txtcodigo;
        private TextView txtasignatura;
        private TextView txtcapitulo;
        private TextView txturlpdf;
        private TextView txtssdpdf;
        private TextView txt_deshabilitardb;
        private CardView cardview_id;
        private ImageView imagendb;
        private ImageView imagepdf;
        private ImageView imagevideo;
        private TextView listyoutube;
        private ImageView imagedownload;


        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txtcodigo = itemView.findViewById(R.id.txt_codigodb);
            txt_deshabilitardb = itemView.findViewById(R.id.txt_deshabilitardb);
            txtasignatura = itemView.findViewById(R.id.txt_asiganturadb);
            txtcapitulo = itemView.findViewById(R.id.txt_capitulodb);
            txturlpdf = itemView.findViewById(R.id.txt_urlpdfdb);
            txtssdpdf = itemView.findViewById(R.id.txt_ssdpdfdb);
            cardview_id = itemView.findViewById(R.id.cardview_id);
            imagendb = itemView.findViewById(R.id.imagendb);
            imagepdf = itemView.findViewById(R.id.imagepdf);
            imagevideo = itemView.findViewById(R.id.imagevideo);
            imagedownload = itemView.findViewById(R.id.downloadpdf);
            listyoutube = itemView.findViewById(R.id.txt_listyoutube);
        }
    }
}
