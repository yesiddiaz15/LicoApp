package com.example.licoapp.data.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Fragment.toast(text: String) {
    requireActivity().toast(text)
}