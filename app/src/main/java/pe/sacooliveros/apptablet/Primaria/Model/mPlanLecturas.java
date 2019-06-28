package pe.sacooliveros.apptablet.Primaria.Model;

public class mPlanLecturas {

    private String urlimage;
    private String titulo;

    public mPlanLecturas(String urlimage, String titulo) {
        this.urlimage = urlimage;
        this.titulo = titulo;
    }

    public String getUrlimage() {
        return urlimage;
    }

    public void setUrlimage(String urlimage) {
        this.urlimage = urlimage;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

