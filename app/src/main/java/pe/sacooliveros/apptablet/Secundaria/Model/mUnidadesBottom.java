package pe.sacooliveros.apptablet.Secundaria.Model;

public class mUnidadesBottom {

    private String descripcion;
    private int photoimg;

    public mUnidadesBottom(String descripcion, int photoimg) {
        this.descripcion = descripcion;
        this.photoimg = photoimg;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPhotoimg() {
        return photoimg;
    }

    public void setPhotoimg(int photoimg) {
        this.photoimg = photoimg;
    }
}
