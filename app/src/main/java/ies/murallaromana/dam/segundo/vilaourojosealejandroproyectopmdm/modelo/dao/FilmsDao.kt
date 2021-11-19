package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities.Film

interface FilmsDao {
    fun getAll(): List<Film>
}