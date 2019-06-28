package pe.sacooliveros.apptablet.Secundaria.Model;

public class mPResueltos {

    private int imagen_logo;

    public mPResueltos(int imagen_logo) {
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
        return "mPResueltos{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
