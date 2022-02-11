package com.example.licoapp.data.network

import com.example.licoapp.data.model.InventoryAddModel
import com.example.licoapp.data.model.Liquor
import com.example.licoapp.data.model.LoginActivityModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FirebaseController {

    private val instance = FirebaseAuth.getInstance()

    private val db = Firebase.firestore
    private val collection = db.collection("LiquorInventory")


    fun auth(model: LoginActivityModel, success: () -> Unit, error: () -> Unit) {
        instance.signInWithEmailAndPassword(model.email, model.password).addOnCompleteListener {
            if (it.isSuccessful) {
                success.invoke()
            } else {
                error.invoke()
            }
        }
    }

    fun registerLiquor(
        inventoryAddModel: InventoryAddModel,
        success: () -> Unit,
        error: () -> Unit,
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val liquor = Liquor(
                admin = inventoryAddModel.admin,
                name = inventoryAddModel.name,
                info = inventoryAddModel.info,
                brand = inventoryAddModel.brand,
                type = inventoryAddModel.type,
                units = inventoryAddModel.units,
                costPerUnit = inventoryAddModel.costPerUnit,
                date = inventoryAddModel.date,
            )
            collection.add(liquor).addOnSuccessListener {
                success.invoke()
            }.addOnFailureListener { e ->
                e.printStackTrace()
                error.invoke()
            }

        }

    }


}