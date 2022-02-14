package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.RetrofitClient
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.FilmsListAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.ValidationUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding
    private lateinit var menuItemCall: MenuItem


    @SuppressLint("NotifyDataSetChanged")
    override fun onResume() {
        super.onResume()
        // I use binding to link the .kt file with the graphic interface
        binding = ActivityListFilmsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Get the preferences to retrieve the token and get the token and the context to make petitions
        val preferences = Preferences(this)
        val token: String? = preferences.retrieveData("token")
        val context = this

        // Retrofit retrieve data
        val apiCall: Call<List<Film>> = RetrofitClient.apiRetrofit.getFilms("Bearer $token")
        apiCall.enqueue(object : Callback<List<Film>> {
            override fun onResponse(call: Call<List<Film>>, response: Response<List<Film>>) {
                // If the petition has a correct code and the response has data we create put the data in  the adapter
                if (response.code() in 200..299 && response.body() != null) {
                    val listFilms = response.body()
                    val adapter = listFilms?.let { FilmsListAdapter(it, context) }
                    binding.rvFilmsList.adapter = adapter
                    val layoutManager = LinearLayoutManager(context)
                    binding.rvFilmsList.layoutManager = layoutManager

                    // Divider between each item
                    val divider = DividerItemDecoration(binding.rvFilmsList.context,
                        layoutManager.orientation)
                    binding.rvFilmsList.addItemDecoration(divider)

                    binding.floatButtonAddFilm.setOnClickListener {
                        // When we click the button we open the
                        val intent = Intent(context, AddEditActivity::class.java)
                        startActivity(intent)
                    }
                } else if (response.code() == 401 || response.code() == 500) {
                    ValidationUtils.closeSession(context)
                } else {
                    Toast.makeText(context,"No ha sido posible recuperar la lista de películas",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Film>>, t: Throwable) {
                Log.d("Error Getting list", t.message.toString())
            }
        })
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
                    ) // After clicking we call support
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
}