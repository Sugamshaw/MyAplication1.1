package com.sugam.myapplication11

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.sugam.myapplication11.Adapter.ViewPagerAdapter
import com.sugam.myapplication11.databinding.ActivityHomeBinding
import com.sugam.myapplication11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.TRANSPARENT

        val arr = arrayListOf<Int>(R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4)
        val adapter = ViewPagerAdapter(this, arr)

        binding.viewPager.adapter = adapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.textView3.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        val sharedPreferences = getSharedPreferences(getString(R.string.details), MODE_PRIVATE)


//        sharedPreferences.edit().putBoolean("login", false).apply()
        if (sharedPreferences.getBoolean("login", false)) {
            startActivity(Intent(this, ActivityHomeBinding::class.java))
            finish()
        }

        binding.button.setOnClickListener {

            if (sharedPreferences.getString(
                    "Email",
                    "a"
                )
                    .toString() == binding.Email.editText?.text.toString() && sharedPreferences.getString(
                    "Password",
                    "12345"
                ).toString() == binding.Password.editText?.text.toString()
            ) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                sharedPreferences.edit().putBoolean("Login", true).apply()
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
