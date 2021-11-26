package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

interface FilmsDao {
    fun getAll(): ArrayList<Film>
}