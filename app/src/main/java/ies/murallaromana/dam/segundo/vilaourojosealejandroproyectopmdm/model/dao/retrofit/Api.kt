package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.retrofit

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Token
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {
    @GET("movies")
    fun getFilms(@Header("Authorization")token: String): Call<List<Film>>

    @POST("users/signup")
    fun signup(@Body user: User) : Call<Unit>

    @POST("users/login")
    fun login(@Body user : User): Call<Token>



}