package aulaandroidapi.com.br;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import aulaandroidapi.com.br.databinding.ActivityMainBinding;
import aulaandroidapi.com.br.domain.GitPageApi;
import aulaandroidapi.com.br.modal.Restaurante;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private GitPageApi myapi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        conectaApi();
        listaDadosDaApi();
    }


    private void conectaApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://elionaifigueiredo.github.io/apipiracui/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myapi = retrofit.create(GitPageApi.class);
    }

    private void listaDadosDaApi() {

        myapi.getRestaurante().enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response.isSuccessful()) {
                    List<Restaurante> lista = response.body();
                    Log.i("PIRACUI", "Deu tudo certo graças a Deus.." + lista.size());
                    Snackbar.make(binding.txtViewId,"Tudo certo",Snackbar.LENGTH_LONG).show();
                } else {
                    erroNaApi();
                }
            }

            @Override
            public void onFailure(Call<List<Restaurante>> call, Throwable t) {

                erroNaApi();

            }
        });

    }

    private void erroNaApi() {
        Snackbar.make(binding.getRoot(), "erro", Snackbar.LENGTH_LONG).show();
    }


} //----------------End
