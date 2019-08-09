package pe.sacooliveros.apptablet.Secundaria.Model;

public class mTomosHelicoAsesoria {

    private int imageTomo;
    private String nombreTomo;

    public mTomosHelicoAsesoria(int imageTomo, String nombreTomo) {
        this.imageTomo = imageTomo;
        this.nombreTomo = nombreTomo;
    }

    public int getImageTomo() {
        return imageTomo;
    }

    public void setImageTomo(int imageTomo) {
        this.imageTomo = imageTomo;
    }

    public String getNombreTomo() {
        return nombreTomo;
    }

    public void setNombreTomo(String nombreTomo) {
        this.nombreTomo = nombreTomo;
    }
}
