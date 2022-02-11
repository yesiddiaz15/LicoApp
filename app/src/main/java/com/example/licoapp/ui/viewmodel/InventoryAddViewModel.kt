package com.example.licoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.licoapp.data.model.InventoryAddModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class InventoryAddViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel

    val name: MutableLiveData<String> = MutableLiveData("")
    val info: MutableLiveData<String> = MutableLiveData("")
    val brand: MutableLiveData<String> = MutableLiveData("")
    val type: MutableLiveData<String> = MutableLiveData("")
    val units: MutableLiveData<String> = MutableLiveData("")
    val costPerUnit: MutableLiveData<String> = MutableLiveData("")
    val date: MutableLiveData<String> = MutableLiveData("")

    fun cancel() {
        success.value = SUCCESS.CLOSE_SUCCESS
    }

    fun save() {

        var attributesEmpty = false

        val nameLiquor = name.value ?: ""
        val infoLiquor = info.value ?: ""
        val brandLiquor = brand.value ?: ""
        val typeLiquor = type.value ?: ""
        val unitsLiquor = units.value ?: ""
        val costPerUnitLiquor = costPerUnit.value ?: ""
        val dateLiquor = date.value ?: ""

        val attributes: List<String> = listOf(nameLiquor,
            infoLiquor,
            brandLiquor,
            typeLiquor,
            unitsLiquor,
            costPerUnitLiquor,
            dateLiquor)

        attributes.forEach {
            if (it.isEmpty()) attributesEmpty = true
        }

        if (!attributesEmpty) {
            val inventoryLiquor = InventoryAddModel(
                Firebase.auth.currentUser?.email.toString(),
                nameLiquor,
                infoLiquor,
                brandLiquor,
                typeLiquor,
                unitsLiquor,
                costPerUnitLiquor,
                dateLiquor
            )
            try {
                viewModelScope.launch {
                    inventoryLiquor.addRegisterLiquor({
                        navigation.value = NAVIGATION.GO_MAIN_VIEW
                        success.value = SUCCESS.ADD_SUCCESS
                    }, {
                        error.value = ERROR.ERROR_LIQUOR_INVENTORY
                    })
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else error.value = ERROR.EMPTY_FIELDS
    }

}
