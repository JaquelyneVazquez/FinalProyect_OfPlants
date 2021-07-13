package mx.edu.itm.link.finalproyect_ofplants.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("id")
    val id: Int,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("contrasena")
    val password: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("telefono")
    val telefono: String
): Serializable

