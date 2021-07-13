package mx.edu.itm.link.finalproyect_ofplants.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("id")
    val id: Int,
    @SerializedName("usuario")
    val usr: String,
    @SerializedName("contrasenia")
    val pass: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("telefono")
    val celphone: String
): Serializable

