import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface AtletaService {
    @GET("/atletas")
    Call<List<Atleta>> getAllAtletas();

    @GET("/atletas/{id}")
    Call<Atleta> getAtleta(@Path("id") Long id);

    @POST("/atletas")
    Call<Atleta> createAtleta(@Body Atleta athlete);


    @PUT("/atletas")
    Call<Atleta> updateAtleta(@Body Atleta athlete);

    @DELETE("/atletas/{id}")
    Call<Void> deleteAtleta(@Path("id") Long id);

    @GET("/atletas/{id}")
    Call<Atleta> selectAtleta(@Path("id") Long id);
}