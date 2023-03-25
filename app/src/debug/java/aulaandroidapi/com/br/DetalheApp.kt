package aulaandroidapi.com.br

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import aulaandroidapi.com.br.adapter.LojaAdpater
import aulaandroidapi.com.br.databinding.ActivityDetalheAppBinding
import aulaandroidapi.com.br.modal.Loja
import com.bumptech.glide.Glide

class DetalheApp : AppCompatActivity() {


   object Extras{
       const val LOJA = "LOJA_EXTRA"
   }

    private lateinit var binding: ActivityDetalheAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityDetalheAppBinding.inflate(layoutInflater)

        setContentView(binding.root)


        leituraExtra()

    }

    private fun leituraExtra() {
        intent?.extras?.getParcelable<Loja>(Extras.LOJA)?.let {
            Glide.with(this).load(it.perfume.imagem).into(binding.imagemIdDetalhe)
            binding.txtDetalheIdDescricao.text = it.perfume.nome
        }
    }
}