package pe.sacooliveros.apptablet.Secundaria.Model;

/**
 * Created by sistem03user on 19/11/2018.
 */

public class mInit {


    private int imagen_logo;

    public mInit(int imagen_logo) {
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
        return "mInit{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
