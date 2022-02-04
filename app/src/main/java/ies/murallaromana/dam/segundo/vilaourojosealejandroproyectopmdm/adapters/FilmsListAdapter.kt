package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities.DetailActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities.FilmsListActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ItemFilmBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

class FilmsListAdapter(private val films: List<Film>, context: FilmsListActivity) :
    RecyclerView.Adapter<FilmsListAdapter.FilmHolder>() {
    class FilmHolder(private val itemBinding: ItemFilmBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun binder(film: Film) {
            itemBinding.tvFilmTitle.text = film.title
            itemBinding.ratingFilm.rating = (film.score/2).toFloat()
            Picasso.get().load(film.url).into(itemBinding.ivMovieCover)

            itemBinding.idItemFilm.setOnClickListener {
                val intent = Intent(itemBinding.root.context,DetailActivity::class.java)
                intent.putExtra("film",film)
                itemBinding.root.context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilmHolder(ItemFilmBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {
        val film = films[position]
        holder.binder(film)
    }

    override fun getItemCount(): Int {
        return films.size
    }

}
