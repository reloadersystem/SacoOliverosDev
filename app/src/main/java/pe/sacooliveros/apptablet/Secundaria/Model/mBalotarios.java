package pe.sacooliveros.apptablet.Secundaria.Model;

public class mBalotarios {

    private int imagen_logo;
    private String materia;
    private int image_download;
    private String title;
    private String namedownload;
    private String urlcomplement;

    public mBalotarios(int imagen_logo, String materia, int image_download, String title, String namedownload, String urlcomplement) {
        this.imagen_logo = imagen_logo;
        this.materia = materia;
        this.image_download = image_download;
        this.title = title;
        this.namedownload = namedownload;
        this.urlcomplement = urlcomplement;
    }

    public int getImagen_logo() {
        return imagen_logo;
    }

    public void setImagen_logo(int imagen_logo) {
        this.imagen_logo = imagen_logo;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getImage_download() {
        return image_download;
    }

    public void setImage_download(int image_download) {
        this.image_download = image_download;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNamedownload() {
        return namedownload;
    }

    public void setNamedownload(String namedownload) {
        this.namedownload = namedownload;
    }

    public String getUrlcomplement() {
        return urlcomplement;
    }

    public void setUrlcomplement(String urlcomplement) {
        this.urlcomplement = urlcomplement;
    }
}
