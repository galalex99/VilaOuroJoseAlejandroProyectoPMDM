package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.inflate
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.ListaPeliculasAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao.PeliculasDao
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao.PeliculasDaoMockImpl

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Usamos binding para linkear o .kt coa interfaz gráfica
        binding = ActivityListFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        val peliculasDao = PeliculasDaoMockImpl();
        val listaPeliculas = peliculasDao.getAll()
        val adapter = ListaPeliculasAdapter(listaPeliculas, this)
        binding.rvListaPeliculas.adapter = adapter
        binding.rvListaPeliculas.layoutManager = layoutManager

    }

}