package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityDetailBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film


class DetailActivity : AppCompatActivity() {

    companion object {
        lateinit var menuItemSave: MenuItem
        lateinit var menuItemDelete: MenuItem
        lateinit var menuItemEdit: MenuItem

    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val infoFilm = intent.extras?.get("film") as Film
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
            menuItemSave= menu.findItem(R.id.save_action)
            menuItemDelete= menu.findItem(R.id.delete_action)
            menuItemEdit= menu.findItem(R.id.edit_action)
        }
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(intent.extras?.get("film")!=null){
            menuItemEdit.isEnabled=true
            menuItemEdit.isEnabled=true
            menuItemEdit.isEnabled=true

        }


        return super.onPrepareOptionsMenu(menu)
    }


}