package pe.sacooliveros.apptablet.Secundaria.Model;

/**
 * Created by sistem03user on 14/11/2018.
 */

public class mMateriasOne {


    private int imagen_logo;
    private int imagen_logo2;

    public mMateriasOne(int imagen_logo, int imagen_logo2) {
        this.imagen_logo = imagen_logo;
        this.imagen_logo2 = imagen_logo2;
    }


    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public int getImagen_logo2() {
        return imagen_logo2;
    }

    public void setImagen_logo2(int imagen_logo2) {
        this.imagen_logo2 = imagen_logo2;
    }

    @Override
    public String toString() {
        return "mMateriasOne{" +
                "imagen_logo=" + imagen_logo +
                ", imagen_logo2=" + imagen_logo2 +
                '}';
    }
}
