package com.example.licoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.licoapp.data.model.LoginActivityModel

class LoginActivityViewModel : BaseViewModel() {

    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")

    fun login() {
        val emailLogin = email.value ?: ""
        val passwordLogin = password.value ?: ""
        try {
            if (emailLogin.isEmpty() || passwordLogin.isEmpty()) {
                error.value = ERROR.EMPTY_FIELDS
            } else {
                val model = LoginActivityModel(emailLogin, passwordLogin)
                model.auth({
                    navigation.value = NAVIGATION.GO_MAIN_VIEW
                }, {
                    error.value = ERROR.WRONG_CREDENTIALS
                })
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}