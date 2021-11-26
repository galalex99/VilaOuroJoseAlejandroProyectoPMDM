package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

class AddEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)
        if (intent.extras?.get("film") == null) {

        } else {
            val pelicula = intent.extras?.get("film") as Film
            title = "Editar ${pelicula.title}"
        }
    }

    // Initialize menu buttons
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.films_detail_menu, menu)
        if (menu != null) {
            DetailActivity.menuItemSave = menu.findItem(R.id.save_action)
            DetailActivity.menuItemDelete = menu.findItem(R.id.delete_action)
            DetailActivity.menuItemEdit = menu.findItem(R.id.edit_action)
        }
        return true
    }


    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (intent.extras?.get("film") != null) {
            DetailActivity.menuItemEdit.isVisible = false
            DetailActivity.menuItemSave.isVisible = true
            DetailActivity.menuItemDelete.isVisible = true

        }else{
            DetailActivity.menuItemEdit.isVisible = false
            DetailActivity.menuItemSave.isVisible = true
            DetailActivity.menuItemDelete.isVisible = false
        }


        return super.onPrepareOptionsMenu(menu)
    }
}