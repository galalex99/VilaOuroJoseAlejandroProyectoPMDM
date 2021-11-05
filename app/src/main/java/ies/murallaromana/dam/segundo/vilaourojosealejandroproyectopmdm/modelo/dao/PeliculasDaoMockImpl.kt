package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.dao

import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.modelo.entities.Pelicula

class PeliculasDaoMockImpl: PeliculasDao {
    override fun getAll() =
        listOf(
            Pelicula(1,"Venom: Habrá Matanza","Andy Serkis","ES","15/10/2021",6.8,13),
            Pelicula(2,"Dune","Denis Villeneuve","ES","17/09/2021",8.0,1),
            Pelicula(3,"Free Guy","Shawn Levy","ES","18/08/2021",7.8,12),
            Pelicula(4,"Halloween Kills","David Gordon Green","ES","22/10/2021",7.0,18),
            Pelicula(5,"Coco","Lee Unkrich","ES","01/10/2017",8.2,0)
        )

}