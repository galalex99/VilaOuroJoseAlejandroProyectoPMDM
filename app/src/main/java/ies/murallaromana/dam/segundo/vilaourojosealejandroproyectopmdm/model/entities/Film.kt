package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Film (
        var id: String?,
        var title: String,
        @SerializedName("directorFirstname")var director: String,
        @SerializedName("country") var language: String,
        @SerializedName("releaseYear")var moviePremiere: String,
        @SerializedName("rating") var score: Double,
        var ageRating: Short,
        @SerializedName("imageUrl")var url: String,
        @SerializedName("runtimeMinutes")var duration:Int
) : Serializable


