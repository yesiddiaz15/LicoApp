package com.example.licoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val error: MutableLiveData<ERROR> = MutableLiveData(null)
    val success: MutableLiveData<SUCCESS> = MutableLiveData(null)
    val navigation: MutableLiveData<NAVIGATION> = MutableLiveData(null)
}

enum class ERROR {
    EMPTY_FIELDS,
    WRONG_CREDENTIALS
}

enum class SUCCESS {

}

enum class NAVIGATION {
    GO_MAIN_VIEW
}