package pe.sacooliveros.apptablet.Primaria.Model;

public class mMatematica {

    private String descripcion;
    private String detalle;

    private int imagen_logo;
    private int imgdownload;

    public mMatematica(String descripcion, String detalle, int imagen_logo, int imgdownload) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.imagen_logo = imagen_logo;
        this.imgdownload = imgdownload;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public int getImgdownload() {
        return imgdownload;
    }

    public void setImgdownload(int imgdownload) {
        this.imgdownload = imgdownload;
    }
}
