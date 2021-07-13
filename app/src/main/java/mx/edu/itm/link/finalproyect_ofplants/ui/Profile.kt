package mx.edu.itm.link.finalproyect_ofplants.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import mx.edu.itm.link.finalproyect_ofplants.IniciarSesion
import mx.edu.itm.link.finalproyect_ofplants.R
import mx.edu.itm.link.finalproyect_ofplants.Utils.MyUtils
import mx.edu.itm.link.finalproyect_ofplants.databinding.FragmentProfileBinding


class Profile : Fragment() {

    private  val viewModel: GlobalViewModel by activityViewModels()

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val usuario = IniciarSesion.usuarioLogueado

        binding.textViewProfileName.text = usuario.nombre
        binding.textViewProfileCorreo.text = usuario.usr
        binding.textViewProfileNTelefono.text = usuario.celphone
    }
}
