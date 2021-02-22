package com.example.proyectodemdulo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EnviaBundle : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_envia_bundle)
        title = "Proyecto - Bundle Sender"

        var textoView : TextView = findViewById(R.id.texto_bundle)
        val envia : Button = findViewById(R.id.envia_bundle)

        envia.setOnClickListener {
            var texto = textoView.text
            sendBundle(texto.toString())
        }
    }

    private fun sendBundle(texto: String) {
        val intent = Intent(this,RecibeBundle::class.java)
        val bundle: Bundle = Bundle()
        bundle.putSerializable("serializable", texto)
        intent.putExtras(bundle)
        startActivity(intent)
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
                startActivity(
                    Intent(this,
                    MainActivity::class.java)
                )
                return true
            }
            R.id.segunda_accion -> {
                startActivity(Intent(this,
                    controlesBasicos::class.java))
                return true
            }
            R.id.tercer_accion -> {
                startActivity(Intent(this,
                    RecyclerViewActivity::class.java))
                return true
            }
            R.id.cuarta_accion -> {
                startActivity(Intent(this,
                    EnviaBundle::class.java))
                return true
            }
            else -> {
                startActivity(Intent(this,
                    RecibeBundle::class.java))
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}