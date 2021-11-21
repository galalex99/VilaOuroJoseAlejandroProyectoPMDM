package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities

import java.io.Serializable

class Film (
        var id: Long,
        var title: String,
        var director: String,
        var language: String,
        var moviePremiere: String,
        var score: Double,
        var ageRating: Short,
        var url: String
) : Serializable


