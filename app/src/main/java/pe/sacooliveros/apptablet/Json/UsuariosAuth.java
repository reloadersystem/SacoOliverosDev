package pe.sacooliveros.apptablet.Json;

public class UsuariosAuth {

    private Integer id;
    private String name;
    private String username;
    private String email;

    public UsuariosAuth(Integer id, String name, String username, String email) {
        this.setId(id);
        this.setName(name);
        this.setUsername(username);
        this.setEmail(email);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
