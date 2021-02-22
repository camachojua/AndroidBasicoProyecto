package com.example.proyectodemdulo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class controlesBasicos : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controles_basicos)

        sharedPreferences = getSharedPreferences("PROYECTO", Context.MODE_PRIVATE)

        val nombre = sharedPreferences.getString("NOMBRE", "")
        val edad : Int = sharedPreferences.getInt("EDAD", 0)
        val logout: Button= findViewById(R.id.logout_button)

        if (nombre != "") {
            findViewById<TextView>(R.id.menu2_nombre).text = nombre
            findViewById<TextView>(R.id.menu2_edad).text = edad.toString()
        }

        logout.setOnClickListener {
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Agrega los elementos del menu si el action bar esta presente
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
}