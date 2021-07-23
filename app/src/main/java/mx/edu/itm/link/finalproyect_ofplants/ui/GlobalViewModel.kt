package mx.edu.itm.link.finalproyect_ofplants.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.edu.itm.link.finalproyect_ofplants.models.Compra
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlantaItem
import mx.edu.itm.link.finalproyect_ofplants.models.Usuario

class GlobalViewModel : ViewModel() {

    // SE importo la clase ListaPlantaItem
    //Mutable Live Data
    private val plantaSelect = MutableLiveData<ListaPlantaItem>()

    //Getter del live Data
    val getPlantaSelect: LiveData<ListaPlantaItem> get() = plantaSelect

    //Setter del live data
    fun setPlantaSelect(plantaItem: ListaPlantaItem) {
        plantaSelect.value = plantaItem

    }

    //------------------------------Usuario---------------------------
    private val usuarioSelect = MutableLiveData<Usuario>()

    val getUsuarioSelect: LiveData<Usuario> get() = usuarioSelect

    fun setUsuarioSelect(usuario: Usuario){
        usuarioSelect.value = usuario
    }

    //------------------Compra-----------------------
    private val addcompra = MutableLiveData<ArrayList<Compra>>().apply { postValue(
        ArrayList()
    ) }
    val getcompra:LiveData<ArrayList<Compra>>get()= addcompra

    fun setcompra(compra: Compra){
        addcompra.value?.add(compra)
    }
}