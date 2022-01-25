package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.App
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.RetrofitClient
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.FilmsListAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.FilmsDaoMockImpl
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding
    private lateinit var menuItemCall: MenuItem

    // we create a lateinit var por the adapter
    companion object {
        @SuppressLint("StaticFieldLeak")
        public lateinit var adapter: FilmsListAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // I use binding to link the .kt file with the graphic interface
        binding = ActivityListFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // context of the film list activity
        val context = this

        // Retrofilt retrieve data
        val apiCall: Call<List<Film>> = RetrofitClient.apiRetrofit.getFilms()
        apiCall.enqueue(object : Callback<List<Film>> {
            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                Toast.makeText(context,response.body().toString(),Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
               Log.d("Test",t.message.toString())
            }
        })


        val layoutManager = LinearLayoutManager(this)
        val listaPeliculas = App.films
        adapter = FilmsListAdapter(listaPeliculas)
        adapter.notifyDataSetChanged()
        binding.rvFilmsList.adapter = adapter
        binding.rvFilmsList.layoutManager = layoutManager


        // add films
        binding.floatButtonAddFilm.setOnClickListener() {
            // When we click the button we open the
            val intent = Intent(this, AddEditActivity::class.java)
            startActivity(intent)
        }
    }

    // Initialize menu buttons
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.films_detail_menu, menu)
        if (menu != null) {
            DetailActivity.menuItemSave = menu.findItem(R.id.save_action)
            DetailActivity.menuItemDelete = menu.findItem(R.id.delete_action)
            DetailActivity.menuItemEdit = menu.findItem(R.id.edit_action)
            menuItemCall = menu.findItem(R.id.call_action)
        }
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        DetailActivity.menuItemEdit.isVisible = false
        DetailActivity.menuItemDelete.isVisible = false
        DetailActivity.menuItemSave.isVisible = false
        menuItemCall.isVisible = true
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.call_action -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.call_support_title))
                    .setMessage(getString(R.string.call_support_message))
                    .setPositiveButton(
                        android.R.string.ok
                    ) // After clicking we call suport
                    { _, _ ->
                        val dial = "tel:634926707"
                        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(dial)))
                    }.setNegativeButton(getString(R.string.cancel_button), null).create()
                    .show()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        // we use this method when we delete a film to reload the list of films
        adapter.notifyDataSetChanged()
    }

}