package pe.sacooliveros.apptablet.Primaria.Model;

public class mMainPri {

    private String estado;
    private int imagen_logo;
    private String descripcion;


    public mMainPri(String estado, int imagen_logo, String descripcion) {
        this.estado = estado;
        this.imagen_logo = imagen_logo;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
