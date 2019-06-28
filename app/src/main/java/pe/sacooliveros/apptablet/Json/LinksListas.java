package pe.sacooliveros.apptablet.Json;


public class LinksListas {

    private Integer albumID;
    private Integer id;
    private String  title;
    private String  url;
    private String thumbnaiUrl;

    public LinksListas(Integer albumID, Integer id, String title, String url, String thumbnaiUrl) {
        this.setAlbumID(albumID);
        this.setId(id);
        this.setTitle(title);
        this.setUrl(url);
        this.setThumbnaiUrl(thumbnaiUrl);
    }


    public Integer getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Integer albumID) {
        this.albumID = albumID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnaiUrl() {
        return thumbnaiUrl;
    }

    public void setThumbnaiUrl(String thumbnaiUrl) {
        this.thumbnaiUrl = thumbnaiUrl;
    }
}