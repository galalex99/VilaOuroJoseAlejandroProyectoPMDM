package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.dao

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

class FilmsDaoMockImpl : FilmsDao {

    override fun getAll(): ArrayList<Film> {
        val lista: ArrayList<Film> = ArrayList()
        lista.addAll(
            listOf(
                Film(1,
                    "Venom: Habrá Matanza",
                    "Andy Serkis",
                    "ES",
                    "15/10/2021",
                    6.8,
                    13,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2jVVDtDaeMxmcvrz2SNyhMcYtWc.jpg"),
                Film(2,
                    "Dune",
                    "Denis Villeneuve",
                    "ES",
                    "17/09/2021",
                    8.0,
                    1,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/m6XWQpT0biTpe5wBGWd60RXmtEX.jpg"),
                Film(3,
                    "Free Guy",
                    "Shawn Levy",
                    "ES",
                    "18/08/2021",
                    7.8,
                    12,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/suaooqn1Mnv60V19MoGxneMupJs.jpg"),
                Film(4,
                    "Halloween Kills",
                    "David Gordon Green",
                    "ES",
                    "22/10/2021",
                    7.0,
                    18,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qmJGd5IfURq8iPQ9KF3les47vFS.jpg"),
                Film(5,
                    "Coco",
                    "Lee Unkrich",
                    "ES",
                    "01/10/2017",
                    8.2,
                    0,
                    "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/48mdKcYKIVfRtoSCqhkY8xMzJlA.jpg")
            ))
        return lista
    }
}