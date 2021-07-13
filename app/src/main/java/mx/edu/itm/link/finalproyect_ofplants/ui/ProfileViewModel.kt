package mx.edu.itm.link.finalproyect_ofplants.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento de profile"
    }

    val tex: LiveData<String> = _text
}