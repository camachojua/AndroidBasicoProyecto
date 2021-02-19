package com.example.proyectodemdulo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
                Toast.makeText(this, "Menú 1", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.segunda_accion -> {
                Toast.makeText(this, "Menú 2", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.tercer_accion -> {
                Toast.makeText(this, "Menú 3", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.cuarta_accion -> {
                Toast.makeText(this, "Menú 4", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                Toast.makeText(this, "Menú 5", Toast.LENGTH_LONG)
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}