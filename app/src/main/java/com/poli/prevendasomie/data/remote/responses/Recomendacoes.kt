package com.poli.prevendasomie.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Recomendacoes(
    @SerializedName("gerar_boletos")
    val gerarBoletos: String
)
