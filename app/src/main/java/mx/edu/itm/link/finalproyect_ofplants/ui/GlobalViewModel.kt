package mx.edu.itm.link.finalproyect_ofplants.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mx.edu.itm.link.finalproyect_ofplants.models.ListaPlantaItem

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
}