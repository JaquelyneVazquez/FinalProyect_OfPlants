package mx.edu.itm.link.finalproyect_ofplants.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.edu.itm.link.finalproyect_ofplants.R
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlantaItem

abstract class PlantaAdapter(
    val context: Context,
    val res: Int,
    val list: ArrayList<ListaPlantaItem>

    ) : RecyclerView.Adapter<PlantaAdapter.PlantasVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantaAdapter.PlantasVH {
        val vh = PlantasVH(LayoutInflater.from(context).inflate(res, null))
        return vh
    }

    override fun onBindViewHolder(holder: PlantasVH, position: Int) {
        val planta = list[position]
        holder.bind(planta)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class PlantasVH(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(planta: ListaPlantaItem) {



            val btnMoreInfo: Button = itemView.findViewById(R.id.BtnCarMoreInfo)
            val imagen: ImageView = itemView.findViewById(R.id.ImgCardPlantas)
            val nombre: TextView = itemView.findViewById(R.id.textViewCard_Nombre)
            val precio: TextView = itemView.findViewById(R.id.textViewCard_Precio)

            nombre.text = planta.name
            precio.text = planta.price

            //Cargar una imagen desde la URL
            planta.images[0].src?.let {
                Picasso.get().load(it).into(imagen)
            }

            btnMoreInfo.setOnClickListener{
                verplanta(planta)
            }


        }
    }
    abstract fun verplanta(planta: ListaPlantaItem)
}