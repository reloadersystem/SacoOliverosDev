package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import pe.sacooliveros.apptablet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentVHSecundaria extends Fragment {

    View rootview;
    private GridView gridViewCiencias;
    TextView tx_temavhseminario;
    String tomodescripcion;


    public fragmentVHSecundaria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_vhsecundaria, container, false);

        tx_temavhseminario = rootview.findViewById(R.id.tx_temavhseminario);
        gridViewCiencias = rootview.findViewById(R.id.grid_tomocienciasvhs);

        //ma_vhstomociencias

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tomodescripcion = bundle.getString("tomoseleccionado");//"Regular"
        }

        tx_temavhseminario.setText("Tomo " + tomodescripcion);


        return rootview;
    }

}
