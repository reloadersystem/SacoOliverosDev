package pe.sacooliveros.apptablet.Json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL= "https://jsonplaceholder.typicode.com";

    @GET("/photos")
    Call<List<LinksListas>> getUrlsphotos();
}
