package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities.DetailActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ItemFilmBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

class FilmsListAdapter(val films: List<Film>, val context: Context) :
    RecyclerView.Adapter<FilmsListAdapter.FilmHolder>() {
    class FilmHolder(val itemBinding: ItemFilmBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun binder(film: Film) {
            itemBinding.tvPunctuation.setText(film.score.toString())
            itemBinding.tvFilmTitle.setText(film.title)


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
        val film = films.get(position)
        holder.binder(film)
    }

    override fun getItemCount(): Int {
        return films.size
    }

}
