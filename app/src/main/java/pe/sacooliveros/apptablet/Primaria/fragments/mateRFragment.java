package pe.sacooliveros.apptablet.Primaria.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pe.sacooliveros.apptablet.Primaria.Adapter.CustomAdapter;
import pe.sacooliveros.apptablet.Primaria.Model.MyList;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Utils.GridSpacingItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class mateRFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<MyList> list;

    private Context context;

    TextView txm_titulo;

    View rootview;

    String tomoMateria, tomoNum;

    String nivelacceso;

    private IEnviarMensaje implementacion;


    public mateRFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootview= inflater.inflate(R.layout.fragment_mate_r, container, false);

        txm_titulo= rootview.findViewById(R.id.txm_titulo);

        //tomodesc

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            nivelacceso = bundle.getString("ACCESO");
            tomoMateria = bundle.getString("tomodesc");
            tomoNum = bundle.getString("tomodato");
        }

        txm_titulo.setText(tomoNum + " "+ tomoMateria);

        CustomAdapter.accesofinal(nivelacceso);




        int spanCount = 2; // 3 columns
        int spacing = 30; // 50px
        boolean includeEdge = false;

        GridLayoutManager manager= new GridLayoutManager(getContext(),2);

        recyclerView=rootview.findViewById(R.id.recyclerView);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount,spacing,includeEdge));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list= new ArrayList<>();

        loadRecyclerViewItem();

        return rootview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context  instanceof IEnviarMensaje)
        {
            this.implementacion= (IEnviarMensaje) context;

        }


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        implementacion.enviarMensaje(tomoNum);


    }

    private void loadRecyclerViewItem() {

        list.add(new MyList(R.drawable.primarialibro_1,  R.drawable.ic_file_download_black_24dp));
        list.add(new MyList(R.drawable.primarialibro_2,  R.drawable.ic_file_download_black_24dp));
        list.add(new MyList(R.drawable.primarialibro_3,  R.drawable.ic_file_download_black_24dp));
        list.add(new MyList(R.drawable.primarialibro_4,  R.drawable.ic_file_download_black_24dp));
        list.add(new MyList(R.drawable.primarialibro_5,  R.drawable.ic_file_download_black_24dp));



        adapter = new CustomAdapter(list, getContext());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        recyclerView.setAdapter(adapter);
    }

    public interface IEnviarMensaje
    {
        void enviarMensaje(String mensaje);
    }

}
