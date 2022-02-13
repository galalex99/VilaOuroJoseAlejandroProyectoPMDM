package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.retrofit

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Token
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.User
import retrofit2.Call
import retrofit2.http.*

interface Api {


    @POST("users/signup")
    fun signup(@Body user: User): Call<Unit>

    @POST("users/login")
    fun login(@Body user: User): Call<Token>

    @POST("movies")
    fun createFilm(@Header("Authorization") token: String,
                    @Body film:Film): Call<Unit>

    @DELETE("movies/{id}")
    fun delete(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Call<Film>

    @PUT("movies")
    fun editFilm(@Header("Authorization") token:String,
                 @Body film: Film): Call<Film>


    @GET("movies")
    fun getFilms(@Header("Authorization") token: String): Call<List<Film>>

    @GET("movies/{id}")
    fun getByID(
        @Header("Authorization") token: String,
        @Path("id") id: String,
    ): Call<Film>


}