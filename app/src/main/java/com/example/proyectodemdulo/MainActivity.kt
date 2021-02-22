package com.example.proyectodemdulo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("PROYECTO", Context.MODE_PRIVATE)
        var nombre_guardado = sharedPreferences.getString("NOMBRE", "")
        var edad_guardada : Int = sharedPreferences.getInt("EDAD", 0)

        if (nombre_guardado != "") {
            findViewById<TextView>(R.id.input_nombre).text = nombre_guardado
            findViewById<TextView>(R.id.input_edad).text = edad_guardada.toString()
        }

        var guardar : Button = findViewById(R.id.guardar)

        guardar.setOnClickListener {
            var nombre : TextView = findViewById(R.id.input_nombre)
            var edad: TextView = findViewById(R.id.input_edad)

            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NOMBRE", nombre.text.toString())
            editor.putInt("EDAD", edad.text.toString().toInt())
            editor.apply()

            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT)
            startActivity(Intent(this@MainActivity, controlesBasicos::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Agrega los elementos del menu si el action bar esta presente
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Manejamos el evento de dar clic en el action bar
        val id = when(item.itemId) {
            R.id.primer_accion -> {
                startActivity(Intent(this@MainActivity,
                    MainActivity::class.java))
                return true
            }
            R.id.segunda_accion -> {
                startActivity(Intent(this@MainActivity,
                    controlesBasicos::class.java))
                return true
            }
            R.id.tercer_accion -> {
                startActivity(Intent(this@MainActivity,
                    RecyclerViewActivity::class.java))
                return true
            }
            R.id.cuarta_accion -> {
                startActivity(Intent(this@MainActivity,
                    EnviaBundle::class.java))
                return true
            }
            else -> {
                startActivity(Intent(this@MainActivity,
                    RecibeBundle::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}