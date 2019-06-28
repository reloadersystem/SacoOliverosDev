package pe.sacooliveros.apptablet.Primaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Primaria.Model.mPlanLecturas;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mUnidadesBottom;

/**
 * A simple {@link Fragment} subclass.
 */
public class planLecturasFragment extends Fragment {

    View rootview;

    RecyclerView recyclerView;

    ArrayList<mPlanLecturas> mLecturas;


    public planLecturasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_plan_lecturas, container, false);

        recyclerView=  rootview.findViewById(R.id.recycler_plan);

        mLecturas = new ArrayList<>();

        mLecturas.add(new mPlanLecturas("https://www.youtube.com/watch?v=rzebcLAA654","1. El dueño de la luz "));
        mLecturas.add(new mPlanLecturas("https://www.youtube.com/watch?v=zk6n9Q27f0E","2. El sueño del jaguar"));
        mLecturas.add(new mPlanLecturas("https://www.youtube.com/watch?v=eCsI-6hcpms","3. El viento sordo de la música"));
        mLecturas.add(new mPlanLecturas("https://www.youtube.com/watch?v=2HCSYX27aqY","4.  Bucear por las diferencias"));

        return  rootview;
    }

}
