package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.App.Companion.films
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters.FilmsListAdapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityDetailBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film


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
        infoFilm = intent.extras?.get("film") as Film
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        infoFilm = intent.extras?.get("film") as Film
        title = infoFilm.title
        Picasso.get().load(infoFilm.url).into(binding.ivFilmImage)
        binding.tvDetailFilmDirector.text = infoFilm.director
        binding.tvDetailFilmAge.text = infoFilm.ageRating.toString()
        binding.tvDetailFilmLanguage.text = infoFilm.language
        binding.tvDetailFilmMoviePremiere.text = infoFilm.moviePremiere
        binding.ratingBarDetail.rating = (infoFilm.score / 2).toFloat()
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
        if (intent.extras?.get("film") != null) {
            menuItemEdit.isVisible = true
            menuItemDelete.isVisible = true
            menuItemSave.isVisible = false
        }
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
                        films.remove(infoFilm)
                        Toast.makeText(
                            this,
                            getString(R.string.film_delete_confirmation),
                            Toast.LENGTH_SHORT
                        ).show()
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