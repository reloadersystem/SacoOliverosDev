package pe.sacooliveros.apptablet.Json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiAuth {

    String BASE_URL ="http://jsonplaceholder.typicode.com";

    @GET("/users")
    Call<List<UsuariosAuth>> getUsuarios();

}
