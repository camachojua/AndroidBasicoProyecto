package com.example.proyectodemdulo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectodemdulo.Adapter.ItemAdapter

class RecyclerViewActivity : AppCompatActivity() {
    private val itemsList : ArrayList<String> = ArrayList<String>()
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        title = "Proyecto - Recycler View"

        val recyclerView : RecyclerView = findViewById(R.id.recycler_view)
        itemAdapter = ItemAdapter(itemsList)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = itemAdapter

        llenaLista()
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

    private fun llenaLista() {
        itemsList.add("Elemento 1")
        itemsList.add("Elemento 2")
        itemsList.add("Elemento 3")
        itemsList.add("Elemento 4")
        itemsList.add("Elemento 5")
        itemAdapter.notifyDataSetChanged()
    }
}