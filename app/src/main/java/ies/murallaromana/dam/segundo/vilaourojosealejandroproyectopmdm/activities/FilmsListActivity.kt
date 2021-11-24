package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.FilmsListAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.FilmsDaoMockImpl

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding
    // we create a lateinit var por the adapter
    companion object {
       private lateinit var adapter :FilmsListAdapter
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // I use binding to link the .kt file with the graphic interface
        binding = ActivityListFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        val peliculasDao = FilmsDaoMockImpl();
        val listaPeliculas = peliculasDao.getAll()
         adapter = FilmsListAdapter(listaPeliculas, this)
        adapter.notifyDataSetChanged()
        binding.rvFilmsList.adapter = adapter
        binding.rvFilmsList.layoutManager = layoutManager

    }

    override fun onResume() {
        super.onResume()
        // we use this method when we delete a film to reload the list of films
        adapter.notifyDataSetChanged()
    }


}