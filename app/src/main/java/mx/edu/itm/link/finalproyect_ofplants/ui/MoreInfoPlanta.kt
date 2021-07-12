package mx.edu.itm.link.finalproyect_ofplants.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.squareup.picasso.Picasso
import mx.edu.itm.link.finalproyect_ofplants.R
import mx.edu.itm.link.finalproyect_ofplants.databinding.FragmentMoreInfoPlantaBinding


class MoreInfoPlanta : Fragment() {

    private val viewModel: GlobalViewModel by activityViewModels()
    private var _binding: FragmentMoreInfoPlantaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoreInfoPlantaBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getPlantaSelect.observe(viewLifecycleOwner, {
            //Cargar la imagen desde la URL
            it.images[0].src.let{
                Picasso.get().load(it).into(binding.ImgenOnlyPlantas)
            }

            binding.textViewCardMoreInfoOnlyNombre.setText(it.name)
            binding.textViewCardMoreInfoOnlyPrecio.setText(it.price)

            var dimensiones = ""
            for (i in it.dimensions.height){
                dimensiones += "${i}"
            }
            binding.textViewCardMoreInfoOnlyAltura.setText(dimensiones)
            binding.textViewCardMoreInfoOnlydescripcion.setText(it.description)
            // des.text= Html.fromHtml(lista[position].shortDescription)

            var categoria = ""
            for(i in it.categories){
                categoria += "${i.name}"
            }
            binding.textViewCardMoreInfoOnlyCategoria.setText(categoria)


        })
    }
}