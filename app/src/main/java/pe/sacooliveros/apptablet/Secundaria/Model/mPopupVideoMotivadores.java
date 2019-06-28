package pe.sacooliveros.apptablet.Secundaria.Model;

public class mPopupVideoMotivadores {

    private  String titulo;
    private String urldata;

    public mPopupVideoMotivadores(String titulo, String urldata) {
        this.titulo = titulo;
        this.urldata = urldata;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrldata() {
        return urldata;
    }

    public void setUrldata(String urldata) {
        this.urldata = urldata;
    }
}
