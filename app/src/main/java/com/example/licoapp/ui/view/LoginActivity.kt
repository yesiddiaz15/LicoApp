package com.example.licoapp.ui.view

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.licoapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.BuildConfig
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getVersion(this)

        auth = Firebase.auth

        binding.btnLogin.setOnClickListener {
            if (binding.etUser.text!!.isEmpty() || binding.etPassword.text!!.isEmpty()) {
                Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show()
            } else {

                auth.signInWithEmailAndPassword(
                    binding.etUser.text.toString(),
                    binding.etPassword.text.toString()
                )
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }

    private fun getVersion(context: Context) {
        var version = ""
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            version = pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        binding.version.text = version
    }
}