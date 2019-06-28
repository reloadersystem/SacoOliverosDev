package pe.sacooliveros.apptablet.Secundaria.Model;

public class mNumTomoDiapo {


    private String detalle;
    private String descripcion;
    private int imagen_logo;
    private int imgdownload;

    public mNumTomoDiapo(String detalle, String descripcion, int imagen_logo, int imgdownload) {
        this.detalle = detalle;
        this.descripcion = descripcion;
        this.imagen_logo = imagen_logo;
        this.imgdownload = imgdownload;
    }


    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
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

    public int getImgdownload() {
        return imgdownload;
    }

    public void setImgdownload(int imgdownload) {
        this.imgdownload = imgdownload;
    }
}
