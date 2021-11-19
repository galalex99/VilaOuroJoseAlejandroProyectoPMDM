package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.FilmsListAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao.FilmsDaoMockImpl

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Usamos binding para linkear o .kt coa interfaz gráfica
        binding = ActivityListFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        val peliculasDao = FilmsDaoMockImpl();
        val listaPeliculas = peliculasDao.getAll()
        val adapter = FilmsListAdapter(listaPeliculas, this)
        binding.rvFilmsList.adapter = adapter
        binding.rvFilmsList.layoutManager = layoutManager

    }

}