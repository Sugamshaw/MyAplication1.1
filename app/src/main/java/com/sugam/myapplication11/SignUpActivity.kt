package com.sugam.myapplication11

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sugam.myapplication11.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor= Color.TRANSPARENT
        val sharedPreferences=getSharedPreferences(getString(R.string.details), MODE_PRIVATE)

        binding.buttonback.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.Login.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.appCompatButton.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            sharedPreferences.edit().putString("Full Name",binding.FullName.editText?.text.toString()).apply()
            sharedPreferences.edit().putString("Email",binding.EmailAddress.editText?.text.toString()).apply()
            sharedPreferences.edit().putString("Password",binding.Password.editText?.text.toString()).apply()

            sharedPreferences.edit().putString("ConfirmPassword",binding.ConfirmPassword.editText?.text.toString()).apply()
            startActivity(Intent(this,MainActivity::class.java))
        }




    }
}