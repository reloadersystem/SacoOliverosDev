package pe.sacooliveros.apptablet.Primaria.Model;

public class mTomoLibro {


    private String estado;
    private int imagen_logo;
    private int download;

    public mTomoLibro(String estado, int imagen_logo, int download) {
        this.estado = estado;
        this.imagen_logo = imagen_logo;
        this.download = download;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }
}
