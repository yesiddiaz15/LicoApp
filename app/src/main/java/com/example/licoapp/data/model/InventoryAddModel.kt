package com.example.licoapp.data.model

import com.example.licoapp.data.network.FirebaseController

data class InventoryAddModel(
    val admin: String = "",
    val name: String = "",
    val info: String = "",
    val brand: String = "",
    val type: String = "",
    val units: String = "",
    val costPerUnit: String = "",
    val date: String = "",
){
    private val firebaseController = FirebaseController()

    suspend fun addRegisterLiquor(success: ()-> Unit, error: () -> Unit){
        firebaseController.registerLiquor(this,success,error)
    }


}