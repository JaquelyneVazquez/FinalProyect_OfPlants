package mx.edu.itm.link.finalproyect_ofplants.models


import com.google.gson.annotations.SerializedName

data class Dimensions(
    @SerializedName("height")
    val height: String,
    @SerializedName("length")
    val length: String,
    @SerializedName("width")
    val width: String
)