package aulaandroidapi.com.br.adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import aulaandroidapi.com.br.Detalhe;
import aulaandroidapi.com.br.DetalheApp;
import aulaandroidapi.com.br.databinding.ItemBinding;
import aulaandroidapi.com.br.modal.Loja;

public class LojaAdpater extends RecyclerView.Adapter<LojaAdpater.ViewHolder> {
    private List<Loja> lojaList;
    private ItemBinding binding;

    // recebe a lista como paramentro
    public LojaAdpater(List<Loja> lojaList) {
        this.lojaList = lojaList;
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
        Loja loja = lojaList.get(position);

        // necessita de um contexto ou seja contexto da aplicação para o glide
        Context context = holder.itemView.getContext();


        // nome da Loja sendo atribuido no text view do laytout Item
        holder.binding.textViewId.setText(loja.getPerfume().getNome());
        // necessita de um contexto ou seja contexto da aplicação
        // load tem que ser uma url
        // into() carrega a imagem aonde
        Glide.with(context).load(loja.getPerfume().getImagem()).into(holder.binding.imageViewId);

        // CHAMA A TELA ACTIVITY
        holder.itemView.setOnClickListener(view ->{
            Intent intent = new Intent(context, DetalheApp.class);
            intent.putExtra(DetalheApp.Extras.LOJA, loja);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        // pega o tamanho da lista
        return lojaList.size();
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
