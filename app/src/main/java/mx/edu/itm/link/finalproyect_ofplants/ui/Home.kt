package mx.edu.itm.link.finalproyect_ofplants.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import mx.edu.itm.link.finalproyect_ofplants.R
import mx.edu.itm.link.finalproyect_ofplants.Utils.MyUtils
import mx.edu.itm.link.finalproyect_ofplants.adapters.PlantaAdapter
import mx.edu.itm.link.finalproyect_ofplants.databinding.FragmentHomeBinding
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlanta
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlantaItem

class Home : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val url = "${resources.getString(R.string.api)}products"
        object : MyUtils() {
            override fun formatResponse(response: String) {
                //Pasando una respuesta del server a un JSONObject
                val respuesta = Gson().fromJson(response, ListaPlanta::class.java)
                Log.d("RESPUESTASERVIDOR", respuesta.toString())
                binding.listViewHomePlantas.adapter = object :PlantaAdapter(view.context,R.layout.cardplantas, respuesta){
                    override fun verplanta(planta: ListaPlantaItem) {
                        viewModel.setPlantaSelect(planta)
                        findNavController().navigate(R.id.action_navigation_home_to_moreInfoPlanta)
                    }


                }
                binding.listViewHomePlantas.layoutManager = GridLayoutManager(view.context, 1)

            }

        }.consumeGet(view.context, url)


    }
}