package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.retrofit

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Token
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.User
import retrofit2.Call
import retrofit2.http.*

interface Api {
    @GET("movies")
    fun getFilms(@Header("Authorization")token: String): Call<List<Film>>

    @POST("users/signup")
    fun signup(@Body user: User) : Call<Unit>

    @POST("users/login")
    fun login(@Body user : User): Call<Token>

    @POST("movies/{id}")
    fun delete(@Header("Authorization")token: String,
                @Path("id") id:String ): Call<Film>

    @GET("movies/{id}")
    fun getByID(@Header("Authorization")token: String,
                @Path("id") id:String ): Call<Film>


}