package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities.Pelicula

// Pasamos tamén a activity a parte de lista das peliculas
class ListaPeliculasAdapter(val peliculas: List<Pelicula>, val activity: Activity) : RecyclerView.Adapter<ListaPeliculasAdapter.PeliculaHolder>() {
    // Creación de Peliculas Holder
    class PeliculaHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        //  val tvTituloPelicula = view.findViewById<TextView>(R.id.tv)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        // val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        //val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)
        //val tvTituloPelicula = view.findViewById<TextView>(R.id.tvTituloPelicula)

        val layoutItem = view.findViewById<ConstraintLayout>(R.id.idDetalle)
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

        holder.layoutItem.setOnClickListener {
            //val intent = Intent(this, DetallePeliculaActivity::class.java)
            //startActivity(intent
            //intent.putExtra("nombre",personaje.nombre)
            //intent.putExtra("apellido",personaje.apellido)
            //intent.putExtra("personaje",personaje)

        }
    }


}
