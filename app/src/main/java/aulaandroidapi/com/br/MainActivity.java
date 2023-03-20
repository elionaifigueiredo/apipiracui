package aulaandroidapi.com.br;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import aulaandroidapi.com.br.adapter.RestauranteAdpater;
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
    private RecyclerView.Adapter RestauranteAdpater;

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
        //Tamanho fixo do recicleView
        binding.recicleviewId.setHasFixedSize(true);
        // adiciona um layout basico no caso neste mai activity
        binding.recicleviewId.setLayoutManager(new LinearLayoutManager(this));




        myapi.getRestaurante().enqueue(new Callback<List<Restaurante>>() {
            @Override
            public void onResponse(Call<List<Restaurante>> call, Response<List<Restaurante>> response) {
                if (response.isSuccessful()) {
                    List<Restaurante> lista = response.body();
                    Log.i("PIRACUI", "Deu tudo certo graças a Deus.." + lista.size());

                    // adiciona a lista do restaurante no adpater
                    RestauranteAdpater = new RestauranteAdpater(lista);
                    // Adiciona o adapater no recicle view da Main Activity
                    binding.recicleviewId.setAdapter(RestauranteAdpater);

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
