package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityDetailBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val infoFilm = intent.extras?.get("film") as Film
        if (infoFilm!=null){
            title = infoFilm.title
            Picasso.get().load(infoFilm.url).into(binding.ivFilmImage)

            binding.tvDetailFilmTitle.text = infoFilm.title
        }else{
            binding.tvDetailFilmDirector.editableText
            title = "New Film"
        }


    }
}