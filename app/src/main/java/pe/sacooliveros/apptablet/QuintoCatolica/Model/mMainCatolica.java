package pe.sacooliveros.apptablet.QuintoCatolica.Model;

public class mMainCatolica {

    private int imagen_logo;


    public mMainCatolica(int imagen_logo) {
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
        return "mMainCatolica{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
