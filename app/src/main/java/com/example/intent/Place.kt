package com.example.intent

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Place : AppCompatActivity() {
    var received:String?="places name"
    lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.prefrece_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.activity_places)
        received=sharedPreferences.getString("Title","PLaces")
        title=received
    }
}