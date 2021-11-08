package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities

import java.io.Serializable

class Pelicula (
        var id: Long,
        var titulo: String,
        var director: String,
        var idioma: String,
        var fechaLanzamiento: String,
        var puntuacion: Double,
        var clasificacionEdad: Short,
        var url: String
) : Serializable


