package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.retrofit

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("movies")
    fun getFilms(): Call<List<Film>>

    // TODO: declara todos los métodos del API siguiendo la documentacion
}