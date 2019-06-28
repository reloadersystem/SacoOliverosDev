package pe.sacooliveros.apptablet.Seleccion.Model;

public class mPruebas {

   private  String titulo;
    private String urldata;

    public mPruebas(String titulo, String urldata) {
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
