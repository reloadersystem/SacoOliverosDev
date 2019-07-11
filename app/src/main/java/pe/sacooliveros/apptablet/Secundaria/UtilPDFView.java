package pe.sacooliveros.apptablet.Secundaria;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

public class UtilPDFView {

    Context context;
    String  urlruta;
    PDFView pdfView;
    Integer pageNumber = 0;
    Integer pagecontador = 0;

    public UtilPDFView(Context context, String urlroot, PDFView pdfview) {
        this.context= context;
        this.urlruta=urlroot;
        this.pdfView= pdfview;
    }

    public void pdfVisorInternet() {

//        progresbar.setVisibility(View.VISIBLE);


        FileLoader.with(context)
              //.fromDirectory("PDFiles", FileLoader.DIR_EXTERNAL_PUBLIC)
              .fromDirectory("PDFiles", FileLoader.DIR_CACHE)
                .load(urlruta)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest fileLoadRequest, FileResponse<File> fileResponse) {
                        // progresbar.setVisibility(View.GONE);
                        File pdfFile = fileResponse.getBody();
                        pdfView.fromFile(pdfFile)
                                //.password(password)
                                .defaultPage(pageNumber)
                                .enableDoubletap(true)
                                .swipeHorizontal(false)
                                .spacing(0)
                                .onRender(new OnRenderListener() {   // visualizar  3 , 4 paginas en miniatura landscape
                                    @Override
                                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                        pdfView.fitToWidth(pdfView.getCurrentPage());
                                    }
                                })
                                .onDraw(new OnDrawListener() {
                                    @Override
                                    public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    }
                                })
                                .onPageError(new OnPageErrorListener() {
                                    @Override
                                    public void onPageError(int page, Throwable t) {
                                        Toast.makeText(context, "error" + page, Toast.LENGTH_SHORT).show();
                                    }
                                })
                                .onPageChange(new OnPageChangeListener() {
                                    @Override
                                    public void onPageChanged(int page, int pageCount) {
                                        pageNumber = page;
                                        pagecontador = pageCount;
                                        //  setTitle(tema);
                                    }
                                })
                                .onTap(new OnTapListener() {
                                    @Override
                                    public boolean onTap(MotionEvent e) {
                                        return true;
                                    }
                                })
                                .onRender(new OnRenderListener() {
                                    @Override
                                    public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                        pdfView.fitToWidth();
                                    }
                                })
                                .enableAntialiasing(true)
                                .invalidPageColor(Color.WHITE)
                                .load();
                    }

                    @Override
                    public void onError(FileLoadRequest fileLoadRequest, Throwable throwable) {
                        //Toast.makeText(ViewTomo3Activity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "Error de Conexión, vuelva a intentar", Toast.LENGTH_SHORT).show();
                        //progresbar.setVisibility(View.GONE);
                    }
                });
    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }
}
