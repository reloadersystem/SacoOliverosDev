package pe.sacooliveros.apptablet.Secundaria.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

import pe.sacooliveros.apptablet.R;
import pe.sacooliveros.apptablet.Secundaria.UtilPDFView;
import pe.sacooliveros.apptablet.Utils.ConnectionDetector;
import pe.sacooliveros.apptablet.Utils.GeneralFileManager;
import pe.sacooliveros.apptablet.Utils.ShareDataRead;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsesoriaCap1_Fragment extends Fragment {

    View rootview;
    PDFView pdfView;
    ConnectionDetector cd;
    static String tomolistener;
    String capitulo;
    String tomo;

    public AsesoriaCap1_Fragment() {
        // Required empty public constructor
    }

    public static void tomolistener(String tomoinfo) {
        tomolistener = tomoinfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootview = inflater.inflate(R.layout.fragment_asesoria_cap1, container, false);

        pdfView = rootview.findViewById(R.id.pdfViewAsesoria);

        cd = new ConnectionDetector(getContext());

        if (tomolistener.equalsIgnoreCase("TOMO1")) {
            tomo = "1";
            capitulo = "1";
        } else if (tomolistener.equalsIgnoreCase("TOMO2")) {
            tomo = "2";
            capitulo = "4";
        } else if (tomolistener.equalsIgnoreCase("TOMO3")) {
            tomo = "3";
            capitulo = "7";
        } else if (tomolistener.equalsIgnoreCase("TOMO4")) {
            tomo = "4";
            capitulo = "10";
        } else if (tomolistener.equalsIgnoreCase("TOMO5")) {
            tomo = "5";
            capitulo = "13";
        } else if (tomolistener.equalsIgnoreCase("TOMO6")) {
            tomo = "6";
            capitulo = "16";
        } else if (tomolistener.equalsIgnoreCase("TOMO7")) {
            tomo = "7";
            capitulo = "19";
        } else if (tomolistener.equalsIgnoreCase("TOMO8")) {
            tomo = "8";
            capitulo = "22";
        }

        String ruta_servidor = getString(R.string.servidor_ruta);
        final String grado = ShareDataRead.obtenerValor(getContext(), "ServerGradoNivel").substring(0, 1);
        final String urlADescargar = ruta_servidor + "/APP/2/" + grado + "/HELICO_ASESORIAS/" + tomolistener + "/ASESORIAT" + tomo + "C" + capitulo + ".pdf";

        if (cd.isConnected()) {
            // pdfVisorInternet(url);
            UtilPDFView utilPdfView = new UtilPDFView(getContext(), urlADescargar, pdfView);
            utilPdfView.pdfVisorInternet();
        }

        final FloatingActionsMenu floatingActionsMenu = rootview.findViewById(R.id.menu_fab);

        final FloatingActionButton fab = rootview.findViewById(R.id.floatingActionAsesoria);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String file_route = "/APP/2/" + grado + "/HELICO_ASESORIAS/" + tomolistener + "/ASESORIAT" + tomo + "C" + capitulo + ".pdf";
                String pdfusername = "ASESORIAT" + tomo + "C" + capitulo + ".pdf";

                GeneralFileManager generalFileManager = new GeneralFileManager(getContext());
                generalFileManager.downloadFileView(file_route, pdfusername);
                floatingActionsMenu.collapse();

                // fab.setVisibility(fab.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);// desaparece el item

            }
        });

        FloatingActionButton floatingRecargar = rootview.findViewById(R.id.floatingRecargar);
        floatingRecargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                File filecache = new File("/data/user/0/pe.sacooliveros.apptablet/cache/PDFiles");
                deleteRecursive(filecache);

                UtilPDFView utilPdfView = new UtilPDFView(getContext(), urlADescargar, pdfView);
                utilPdfView.pdfVisorInternet();
                floatingActionsMenu.collapse();
            }
        });

        return rootview;
    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }
}
