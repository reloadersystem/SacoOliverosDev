package pe.sacooliveros.apptablet.QuintoUniversidades.Model;

public class mMainU {


    private int imagen_logo;

    public mMainU(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }


    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }


    @Override
    public String toString() {
        return "mMainU{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
