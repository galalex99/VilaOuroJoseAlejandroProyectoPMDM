package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.RetrofitClient
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityDetailBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity() {

    companion object {
        lateinit var menuItemSave: MenuItem
        lateinit var menuItemDelete: MenuItem
        lateinit var menuItemEdit: MenuItem
        lateinit var infoFilm: Film

    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        val id = intent.extras?.get("id") as String
        val token = Preferences(this).retrieveData("token")
            val apiCall: Call<Film> = RetrofitClient.apiRetrofit.getByID("Bearer $token",id)
            apiCall.enqueue(object : Callback<Film> {
                override fun onResponse(call: Call<Film>, response: Response<Film>) {
                    if (response.code() in 200..299 && response.body() != null) {
                        infoFilm  = response.body() as Film
                        title = infoFilm.title
                        Picasso.get().load(infoFilm.url).into(binding.ivFilmImage)
                        binding.tvDetailFilmDirector.text = infoFilm.director
                        binding.tvDetailFilmAge.text = infoFilm.ageRating.toString()
                        binding.tvDetailFilmLanguage.text = infoFilm.language
                        binding.tvDetailFilmMoviePremiere.text = infoFilm.moviePremiere
                        binding.ratingBarDetail.rating = (infoFilm.score / 2).toFloat()
                    }
                }

                override fun onFailure(call: Call<Film>, t: Throwable) {
                    Log.d("Fail getting film", t.message.toString())
                }
            })


    }

    // Initialize menu buttons
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.films_detail_menu, menu)
        if (menu != null) {
            menuItemSave = menu.findItem(R.id.save_action)
            menuItemDelete = menu.findItem(R.id.delete_action)
            menuItemEdit = menu.findItem(R.id.edit_action)
        }
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuItemEdit.isVisible = true
        menuItemDelete.isVisible = true
        menuItemSave.isVisible = false
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_action -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.film_delete_title))
                    .setMessage(
                        getString(R.string.film_delete_question) + "\n" + infoFilm.title + "\n" + getString(
                            R.string.film_delete_question2
                        )
                    )
                    .setPositiveButton(
                        android.R.string.ok
                    ) // After clicking the accept button we remove the film
                    { _, _ ->


                        finish()
                    }.setNegativeButton(getString(R.string.cancel_button), null).create()
                    .show()

                return true
            }
            R.id.edit_action -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.film_edit_title))
                    .setMessage(getString(R.string.film_edit_message) + "\n" + infoFilm.title)
                    .setPositiveButton(
                        android.R.string.ok
                    ) // After clicking the accept button we edit the film
                    { _, _ ->
                        val intent = Intent(this, AddEditActivity::class.java)
                        intent.putExtra("film", infoFilm)
                        startActivity(intent)
                        Toast.makeText(
                            this,
                            getString(R.string.film_edit_confirmation),
                            Toast.LENGTH_SHORT
                        ).show()
                    }.setNegativeButton(getString(R.string.cancel_button), null).create()
                    .show()

                return true
            }


            else -> super.onOptionsItemSelected(item)
        }
    }

}