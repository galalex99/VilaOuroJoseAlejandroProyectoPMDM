package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityAddEditBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityDetailBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

private lateinit var binding: ActivityAddEditBinding
private lateinit var film: Film

class AddEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        film = intent.extras?.get("film") as Film
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.extras?.get("film") == null) {

        } else {

            title = "Editar ${film.title}"
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
        DetailActivity.menuItemEdit.isVisible = false
        DetailActivity.menuItemSave.isVisible = true
        DetailActivity.menuItemDelete.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
}