package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm

import android.app.Application
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao.FilmsDaoMockImpl
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

// I Created a class application with a method on create to instantiate a list of films 1 time
class App : Application() {

    companion object {
        var films: List<Film> = ArrayList()
    }

    override fun onCreate() {
        // Change night mode to no
        super.onCreate()

        val dao = FilmsDaoMockImpl()

        films = dao.getAll()
    }
}