package com.example.licoapp.data.model

import com.example.licoapp.data.network.FirebaseController

data class LoginActivityModel(val email: String, val password: String) {
    private val firebaseController = FirebaseController()

    fun auth(success: () -> Unit, error: () -> Unit) {
        firebaseController.auth(this, success, error)
    }
}