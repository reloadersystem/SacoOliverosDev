package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.UtilPDFView;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.GeneralFileManager;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsesoriaCap2_Fragment extends Fragment {

    View rootview;
    PDFView pdfView;
    ConnectionDetector cd;

    static String tomolistener;

    String capitulo;
    String tomo;

    public AsesoriaCap2_Fragment() {
        // Required empty public constructor
    }
    public static void tomolistener(String tomoinfo) {
        tomolistener = tomoinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview= inflater.inflate(R.layout.fragment_asesoria_cap2, container, false);

        //pdfViewAsesoria2

        pdfView= rootview.findViewById(R.id.pdfViewAsesoria2);

        cd = new ConnectionDetector(getContext());

        if (tomolistener.equalsIgnoreCase("TOMO1")) {
            tomo = "1";
            capitulo = "2";
        } else if (tomolistener.equalsIgnoreCase("TOMO2")) {
            tomo = "2";
            capitulo = "5";
        } else if (tomolistener.equalsIgnoreCase("TOMO3")) {
            tomo = "3";
            capitulo = "8";
        } else if (tomolistener.equalsIgnoreCase("TOMO4")) {
            tomo = "4";
            capitulo = "11";
        } else if (tomolistener.equalsIgnoreCase("TOMO5")) {
            tomo = "5";
            capitulo = "14";
        } else if (tomolistener.equalsIgnoreCase("TOMO6")) {
            tomo = "6";
            capitulo = "17";
        } else if (tomolistener.equalsIgnoreCase("TOMO7")) {
            tomo = "7";
            capitulo = "20";
        } else if (tomolistener.equalsIgnoreCase("TOMO8")) {
            tomo = "8";
            capitulo = "23";
        }

        String ruta_servidor = getString(R.string.servidor_ruta);
        final String grado = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);

        final String urlADescargar = ruta_servidor + "/APP/2/" + grado + "/HELICO_ASESORIAS/" + tomolistener + "/ASESORIAT" + tomo + "C" + capitulo + ".pdf";

        if (cd.isConnected()) {
            // pdfVisorInternet(url);
            UtilPDFView utilPdfView = new UtilPDFView(getContext(), urlADescargar, pdfView);
            utilPdfView.pdfVisorInternet();
        }

        FloatingActionButton fab = (FloatingActionButton) rootview.findViewById(R.id.floatingActionAsesoria2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String file_route = "/APP/2/" + grado + "/HELICO_ASESORIAS/" + tomolistener + "/ASESORIAT" + tomo + "C" + capitulo + ".pdf";
                String pdfusername = "ASESORIAT" + tomo + "C" + capitulo + ".pdf";

                GeneralFileManager generalFileManager = new GeneralFileManager(getContext());
                generalFileManager.downloadFileView(file_route, pdfusername);
            }
        });

        return rootview;
    }

}
