package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities.DetailActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities.Pelicula

// Pasamos tamén a activity a parte de lista das peliculas
class ListaPeliculasAdapter(val peliculas: List<Pelicula>,val context: Context) :
    RecyclerView.Adapter<ListaPeliculasAdapter.PeliculaHolder>() {
    // Creación de Peliculas Holder
    class PeliculaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        val ivPelicula = view.findViewById<ImageView>(R.id.ivPortadaPelicula)
        //  val tvTituloPelicula = view.findViewById<TextView>(R.id.tv)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        //val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        //val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        val layoutDetail = itemView.findViewById<CardView>(R.id.idItem_film)

    }

    // Este método se ocupa de INFLAR la vista (el item film)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return PeliculaHolder(inflater)
    }

    // Este método devuelve el número de elementos de la lista
    override fun getItemCount(): Int {
        return peliculas.size
    }

    // Este método se llama tantas veces como elementos hay en la lista
    override fun onBindViewHolder(holder: PeliculaHolder, position: Int) {
        val pelicula = peliculas.get(position)
        holder.tvTituloPelicula.text = pelicula.titulo
        Picasso.get().load(pelicula.url).into(holder.ivPelicula)
        holder.layoutDetail.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("pelicula",pelicula)
            context.startActivity(intent)



        }
    }


}
