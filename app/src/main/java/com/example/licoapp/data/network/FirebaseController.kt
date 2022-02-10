package com.example.licoapp.data.network

import com.example.licoapp.data.model.LoginActivityModel
import com.google.firebase.auth.FirebaseAuth

class FirebaseController {

    private val instance = FirebaseAuth.getInstance()

    fun auth(model: LoginActivityModel, success: () -> Unit, error: () -> Unit) {
        instance.signInWithEmailAndPassword(model.email, model.password).addOnCompleteListener {
            if (it.isSuccessful) {
                success.invoke()
            } else {
                error.invoke()
            }
        }
    }
}