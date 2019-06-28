package pe.sacooliveros.apptablet.FragmentNavigator.TomosMateriales.Materias;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import pe.sacooliveros.apptablet.Secundaria.Adapter.adapter_materiales;
import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.Model.mMateriasOne;

public class MateriasOneActivity extends AppCompatActivity {


    private GridView gridView;
    ArrayList<mMateriasOne> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materias_one);

        gridView= findViewById(R.id.ma_materiasOne);

        Lista= new ArrayList<mMateriasOne>();


        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));
        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));
        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));
        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));
        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));
        Lista.add(new mMateriasOne(R.drawable.habitos_estudio_2,R.drawable.download_circle));

        final adapter_materiales adapter= new adapter_materiales(getApplicationContext(), Lista);

        gridView.setAdapter(adapter);


    }
}
