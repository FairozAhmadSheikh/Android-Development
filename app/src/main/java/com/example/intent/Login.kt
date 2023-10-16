package com.example.intent

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var emailcontainer: EditText
    lateinit var passwordcontainer: EditText
    val validemail = "fairozahmadsheikh@gmail.com"
    val validpassword = arrayListOf("Gulmarg", "Pehlgaam", "Sonmarg", "Aharbal", "Admin")
    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.prefrece_file_name),Context.MODE_PRIVATE)
        val isLogged=sharedPreferences.getBoolean("isLogged",false)
        setContentView(R.layout.activity_login)
        if(isLogged)
        {
         val intent=Intent(this@Login,Place::class.java)
         startActivity(intent)
        }
        // Initialize UI components
        btn = findViewById(R.id.loginfbbtn)
        emailcontainer = findViewById(R.id.emailcontainer)
        passwordcontainer = findViewById(R.id.passwordcontainer)

        btn.setOnClickListener {
            val email = emailcontainer.text.toString()
            val password = passwordcontainer.text.toString()
            var places = "Place"
            if (email == validemail) {
                val intent = Intent(this, Place::class.java)
                when (password) {
                    validpassword[0] -> {
                        savePrefrences(places)
                        places = "Gulmarg"
                        startActivity(intent)
                    }
                    validpassword[1] -> {
                        savePrefrences(places)
                        places = "Pehlgaam"
                        startActivity(intent)
                    }
                    validpassword[2] -> {
                        savePrefrences(places)
                        places = "Sonmarg"
                        startActivity(intent)
                    }
                    validpassword[3] -> {
                        savePrefrences(places)
                        places = "Ahrbal"
                        startActivity(intent)
                    }
                    validpassword[4] -> {
                        savePrefrences(places)
                        places = "Admin"
                        startActivity(intent)
                    }
                    else -> {
                        Toast.makeText(this, "Wrong Credentials", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePrefrences(title:String){
        sharedPreferences.edit().putBoolean("isLogged",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }

}