package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Film (
        var id: Long,
        var title: String,
        var director: String,
        var language: String,
        var moviePremiere: String,
        @SerializedName("rating") var score: Double,
        var ageRating: Short,
        var url: String
) : Serializable


