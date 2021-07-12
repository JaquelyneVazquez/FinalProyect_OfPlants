package mx.edu.itm.link.finalproyect_ofplants.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mx.edu.itm.link.finalproyect_ofplants.R
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlantaItem

abstract class CompraAdapter(
    val context: Context,
    val res: Int,
    val list: ArrayList<ListaPlantaItem>

) : RecyclerView.Adapter<CompraAdapter.ComprasVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompraAdapter.ComprasVH {
        val vh = ComprasVH(LayoutInflater.from(context).inflate(res, null))
        return vh
    }

    override fun onBindViewHolder(holder: ComprasVH, position: Int) {
        val compra = list[position]
        holder.bind(compra)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ComprasVH(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(planta: ListaPlantaItem) {

            val btnAddToCart: Button = itemView.findViewById(R.id.BtnCardMoreInfoOnlyComprar)

            val imagen: ImageView = itemView.findViewById(R.id.imagCompraCardPlanta)
            val nombre: TextView = itemView.findViewById(R.id.compraCardNombre)
            val precio: TextView = itemView.findViewById(R.id.compraCardPrecio)

            nombre.text = planta.name
            precio.text = planta.price

            //Cargar una imagen desde la URL
            planta.images[0].src?.let {
                Picasso.get().load(it).into(imagen)
            }

            btnAddToCart.setOnClickListener{
                vercompra(planta)
            }

        }
    }

    abstract fun vercompra(planta: ListaPlantaItem)
}