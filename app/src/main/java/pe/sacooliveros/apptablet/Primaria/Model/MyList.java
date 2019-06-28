package pe.sacooliveros.apptablet.Primaria.Model;

public class MyList {


    private int imgfondo;

    private int imgmenu;

    public MyList(int imgfondo, int imgmenu) {
        this.imgfondo = imgfondo;
        this.imgmenu = imgmenu;
    }

    public int getImgfondo() {
        return imgfondo;
    }

    public void setImgfondo(int imgfondo) {
        this.imgfondo = imgfondo;
    }

    public int getImgmenu() {
        return imgmenu;
    }

    public void setImgmenu(int imgmenu) {
        this.imgmenu = imgmenu;
    }

    @Override
    public String toString() {
        return "MyList{" +
                "imgfondo=" + imgfondo +
                ", imgmenu=" + imgmenu +
                '}';
    }
}
