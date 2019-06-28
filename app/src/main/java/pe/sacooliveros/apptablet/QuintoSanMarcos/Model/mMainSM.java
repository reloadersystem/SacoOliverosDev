package pe.sacooliveros.apptablet.QuintoSanMarcos.Model;

public class mMainSM {

    private int imagen_logo;


    public mMainSM(int imagen_logo) {
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
        return "mMainSM{" +
                "imagen_logo=" + imagen_logo +
                '}';
    }
}
