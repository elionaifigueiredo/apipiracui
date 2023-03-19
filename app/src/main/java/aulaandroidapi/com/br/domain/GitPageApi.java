package aulaandroidapi.com.br.domain;

import java.util.List;

import aulaandroidapi.com.br.modal.Restaurante;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitPageApi {

    @GET("piracuiapiupdate.json")
    Call<List<Restaurante>>getRestaurante();
}
