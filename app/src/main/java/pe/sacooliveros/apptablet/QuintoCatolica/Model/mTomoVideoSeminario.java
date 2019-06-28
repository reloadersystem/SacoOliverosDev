package pe.sacooliveros.apptablet.QuintoCatolica.Model;

public class mTomoVideoSeminario {

    private int imagen_logo;
    private String descripcion;


    public mTomoVideoSeminario(int imagen_logo, String descripcion) {
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

    @Override
    public String toString() {
        return "mTomoVSeminario{" +
                "imagen_logo=" + imagen_logo +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
