package aulaandroidapi.com.br.modal

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class Restaurante(
    @SerializedName("nome")
    val nome: String,
    @SerializedName("imagem")
    val imagem: String
) : Parcelable