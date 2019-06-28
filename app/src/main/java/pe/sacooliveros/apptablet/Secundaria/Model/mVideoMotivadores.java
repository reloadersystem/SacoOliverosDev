package pe.sacooliveros.apptablet.Secundaria.Model;

public class mVideoMotivadores {

    private int imagen_logo;
    private String descripcion;

    public mVideoMotivadores(int imagen_logo, String descripcion) {
        this.imagen_logo = imagen_logo;
        this.descripcion = descripcion;
    }


    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
