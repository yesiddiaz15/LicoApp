package com.example.licoapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.licoapp.data.utils.toast
import com.example.licoapp.databinding.ActivityLoginBinding
import com.example.licoapp.ui.viewmodel.ERROR
import com.example.licoapp.ui.viewmodel.LoginActivityViewModel
import com.example.licoapp.ui.viewmodel.NAVIGATION

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginActivityViewModel: LoginActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.loginViewModel = loginActivityViewModel

        loginActivityViewModel.error.observe(this, {
            when (it) {
                ERROR.EMPTY_FIELDS -> {
                    toast("Empty Fields")
                }
                ERROR.WRONG_CREDENTIALS -> {
                    toast("Wrong Credentials")
                }
            }
        })

        loginActivityViewModel.navigation.observe(this, {
            when (it) {
                NAVIGATION.GO_MAIN_VIEW -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        })
    }
}