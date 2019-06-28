package pe.sacooliveros.apptablet.Secundaria.Model;

public class Model

{
    private String codigo;
    private String asignatura;
    private boolean habilitar;
    private String capitulo;
    private String urlpdf;
    private String ssdpdf;
    private String tomopdf;
    private String gradopdf;
    private String listyoutube;

    private int imgphoto;
    private int imagepdf;
    private int imagevideo;
    private int imagedownload;



    public Model(String codigo, String asignatura, boolean habilitar, String capitulo, String urlpdf, String ssdpdf, String tomopdf, String gradopdf, String listyoutube, int imgphoto, int imagepdf, int imagevideo, int imagedownload) {
        this.codigo = codigo;
        this.asignatura = asignatura;
        this.habilitar = habilitar;
        this.capitulo = capitulo;
        this.urlpdf = urlpdf;
        this.ssdpdf = ssdpdf;
        this.tomopdf = tomopdf;
        this.gradopdf = gradopdf;
        this.listyoutube = listyoutube;
        this.imgphoto = imgphoto;
        this.imagepdf = imagepdf;
        this.imagevideo = imagevideo;
        this.imagedownload= imagedownload;
    }

    public Model() {

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public boolean isHabilitar() {
        return habilitar;
    }

    public void setHabilitar(boolean habilitar) {
        this.habilitar = habilitar;
    }

    public String getCapitulo() {
        return capitulo;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public String getUrlpdf() {
        return urlpdf;
    }

    public void setUrlpdf(String urlpdf) {
        this.urlpdf = urlpdf;
    }

    public String getSsdpdf() {
        return ssdpdf;
    }

    public void setSsdpdf(String ssdpdf) {
        this.ssdpdf = ssdpdf;
    }

    public String getTomopdf() {
        return tomopdf;
    }

    public void setTomopdf(String tomopdf) {
        this.tomopdf = tomopdf;
    }

    public String getGradopdf() {
        return gradopdf;
    }

    public void setGradopdf(String gradopdf) {
        this.gradopdf = gradopdf;
    }

    public String getListyoutube() {
        return listyoutube;
    }

    public void setListyoutube(String listyoutube) {
        this.listyoutube = listyoutube;
    }

    public int getImgphoto() {
        return imgphoto;
    }

    public void setImgphoto(int imgphoto) {
        this.imgphoto = imgphoto;
    }

    public int getImagepdf() {
        return imagepdf;
    }

    public void setImagepdf(int imagepdf) {
        this.imagepdf = imagepdf;
    }

    public int getImagevideo() {
        return imagevideo;
    }

    public void setImagevideo(int imagevideo) {
        this.imagevideo = imagevideo;
    }

    public int getImagedownload() {
        return imagedownload;
    }

    public void setImagedownload(int imagedownload) {
        this.imagedownload = imagedownload;
    }
}