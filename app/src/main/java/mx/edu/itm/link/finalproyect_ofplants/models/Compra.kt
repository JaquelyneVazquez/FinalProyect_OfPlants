package mx.edu.itm.link.finalproyect_ofplants.models

import com.google.gson.annotations.SerializedName

data class Compra(
    @SerializedName("nomre")
    val nombre: String,
    @SerializedName("precio")
    val precio: String,
    @SerializedName("precioT")
    val precioT: String,
)
