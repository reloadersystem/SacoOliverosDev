package pe.sacooliveros.apptablet.DownloadPDF;

/**
 * Created by sistem03user on 13/11/2018.
 */

public class mPdf {


    private String descripcion;
    private int imagen_logo;
    private String estado;

    public mPdf(String descripcion, int imagen_logo, String estado) {
        this.descripcion = descripcion;
        this.imagen_logo = imagen_logo;
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
