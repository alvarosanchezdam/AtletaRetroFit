import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by dam on 15/12/16.
 */
public class AtletaSynchronous {
    private static Retrofit retrofit;

    public static void main(String[] args) throws IOException {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AtletaService atletaService = retrofit.create(AtletaService.class);

        //Borrar el Atleta con id 2

        Call<Void> callDelete =atletaService.deleteAtleta(2L);
        Response<Void> responseDelete = callDelete.execute();
        System.out.println(responseDelete.code());
        if(responseDelete.isSuccessful()){
            System.out.println("Status code: " + responseDelete.code() + System.lineSeparator() +
                    "Atleta con id 2 borrado!");
        }else{
            System.out.println("Status code: " + responseDelete.code() +
                    "Message error: " + responseDelete.errorBody());
        }
        //Crear un atleta

        Atleta atleta = new Atleta("Gabi", "Perez", "España");
        Call<Atleta> callCreate = atletaService.createAtleta(atleta);
        Response<Atleta> responseCreate = callCreate.execute();
        if(responseCreate.isSuccessful()){
            System.out.println("Status code: " + responseCreate.code() + System.lineSeparator() +
                    "Atleta creado!"+atleta);
        }else{
            System.out.println("Status code: " + responseCreate.code() +
                    "Message error: " + responseCreate.errorBody());
        }
        //Actualizar atleta

        Atleta atleta2;
        Call<Atleta> callSelect=atletaService.selectAtleta(1L);
        Response<Atleta> responseSelect = callSelect.execute();
        if(responseSelect.isSuccessful()){
            atleta2 = responseSelect.body();
            System.out.println("Status code: " + responseSelect.code() + System.lineSeparator() +
                    "Atleta sin modificar: " + atleta2);
            atleta2.setApellidos("Duran");
            Call<Atleta> callUpdate=atletaService.updateAtleta(atleta2);
            Response<Atleta> responseUpdate=callUpdate.execute();
            if(responseSelect.isSuccessful()){
                System.out.println("Status code: " + responseUpdate.code() + System.lineSeparator() +
                        "Atleta actualizado!");
            }else{
                System.out.println("Status code: " + responseUpdate.code() +
                        "Message error: " + responseUpdate.errorBody());
            }
        }else{
            System.out.println("Status code: " + responseSelect.code() +
                    "Message error: " + responseSelect.errorBody());
        }

        //Get all atletas

        Call<List<Atleta>> call = atletaService.getAllAtletas();
        Response<List<Atleta>> response = call.execute();
        if(response.isSuccessful()){
            List<Atleta> athleteList = response.body();
            System.out.println("Status code: " + response.code() + System.lineSeparator() +
                    "GET all athletes: " + athleteList);
        }else{
            System.out.println("Status code: " + response.code() +
                    "Message error: " + response.errorBody());
        }
    }

}