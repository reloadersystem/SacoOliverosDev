package pe.sacooliveros.apptablet.QuintoUniversidades.Model;

public class mExamenCapitulos {

    private int imagen_logo;


    public mExamenCapitulos(int imagen_logo) {
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
        return "mExamenCapitulos{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
