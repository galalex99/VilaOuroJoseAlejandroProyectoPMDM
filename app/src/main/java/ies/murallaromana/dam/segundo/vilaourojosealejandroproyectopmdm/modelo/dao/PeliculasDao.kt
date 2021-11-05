package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities.Pelicula

interface PeliculasDao {
    fun getAll(): List<Pelicula>
}