package aulaandroidapi.com.br.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aulaandroidapi.com.br.databinding.ItemBinding;
import aulaandroidapi.com.br.modal.Restaurante;

public class RestauranteAdpater extends RecyclerView.Adapter<RestauranteAdpater.ViewHolder> {
    private List<Restaurante> restauranteList;
    private ItemBinding binding;

    // recebe a lista como paramentro
    public RestauranteAdpater(List<Restaurante> restauranteList) {
        this.restauranteList = restauranteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = ItemBinding.inflate(layoutInflater, parent, false);
        // instancia do ViewHolder
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // a parti do viewHolder , qual o elemento que esta na lista e adiciona no layout para ser exibida
        Restaurante restaurante = restauranteList.get(position);

        // nome do restauratne sendo atribuido no text view do laytout Item
        holder.binding.textViewId.setText(restaurante.getNome());
    }

    @Override
    public int getItemCount() {
        // pega o tamanho da lista
        return restauranteList.size();
    }

    //paramentro generico
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        //deixar acessivel o elemento na classe
        private final ItemBinding binding;
        public ViewHolder(ItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
} // ---------------LINHA FINAL
