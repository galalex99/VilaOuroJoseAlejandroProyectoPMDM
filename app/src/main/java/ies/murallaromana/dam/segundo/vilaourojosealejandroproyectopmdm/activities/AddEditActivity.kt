package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.App.Companion.films
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityAddEditBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Film

private lateinit var binding: ActivityAddEditBinding
var film: Film? = null

class AddEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.extras?.get("film") == null) {
            title = getString(R.string.film_edit_title)
        } else {
            film = (intent.extras?.get("film") as Film?)!!
            title = getString(R.string.film_edit_title) + film!!.title
            binding.tietEditAddId.setText(film?.id.toString())
            binding.tietEditAddTitle.setText(film?.title)
            binding.tietEditAddDirector.setText(film?.director)
            binding.tietEditAddLanguage.setText(film?.language)
            binding.tietEditAddMoviePremiere.setText(film?.moviePremiere)
            binding.tietEditAddScore.setText(film?.score.toString())
            binding.tietEditAddAgeRating.setText(film?.ageRating.toString())
            binding.tietEditAddUrl.setText(film?.url.toString())

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save_action -> {
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.film_save_title))
                    .setMessage(getString(R.string.film_save_message))
                    .setPositiveButton(
                        android.R.string.ok
                    )
                    { _, _ ->
                        var correctData = true
                        val id = binding.tietEditAddId.text?.trim().toString()
                        val title = binding.tietEditAddTitle.text?.trim().toString()
                        val director = binding.tietEditAddDirector.text?.trim().toString()
                        val language = binding.tietEditAddLanguage.text?.trim().toString()
                        val premiere = binding.tietEditAddMoviePremiere.text?.trim().toString()
                        val score = binding.tietEditAddScore.text?.trim().toString()
                        val age = binding.tietEditAddAgeRating.text?.trim().toString()
                        val url = binding.tietEditAddUrl.text?.trim().toString()


                        if (TextUtils.isEmpty(id)) {
                            correctData = false
                            binding.tietEditAddId.error = getString(R.string.generic_data_error)
                        }
                        if (TextUtils.isEmpty(title)) {
                            correctData = false
                            binding.tietEditAddTitle.error = getString(R.string.generic_data_error)
                        }
                        if (TextUtils.isEmpty(director)) {
                            correctData = false
                            binding.tietEditAddDirector.error =
                                getString(R.string.generic_data_error)
                        }
                        if (TextUtils.isEmpty(language)) {
                            correctData = false
                            binding.tietEditAddLanguage.error =
                                getString(R.string.generic_data_error)
                        }
                        if (TextUtils.isEmpty(premiere)) {
                            correctData = false
                            binding.tietEditAddMoviePremiere.error =
                                getString(R.string.generic_data_error)
                        }

                        if (TextUtils.isEmpty(score)) {
                            correctData = false
                            binding.tietEditAddScore.error = getString(R.string.generic_data_error)
                        } else if ((score).toDouble() > 10) {
                            correctData = false
                            binding.tietEditAddScore.error =
                                getString(R.string.score_data_error)
                        }

                        if (TextUtils.isEmpty(age)) {
                            correctData = false
                            binding.tietEditAddAgeRating.error =
                                getString(R.string.generic_data_error)
                        }
                        if (TextUtils.isEmpty(url)) {
                            correctData = false
                            binding.tietEditAddUrl.error = getString(R.string.generic_data_error)
                        }

                        if (!correctData) {
                            Toast.makeText(
                                this,
                                getString(R.string.generic_data_check),
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (film == null) {
                                films.add(
                                    Film(
                                        id.toLong(),
                                        title,
                                        director,
                                        language,
                                        premiere,
                                        score.toDouble(),
                                        age.toShort(),
                                        url,
                                        10

                                    )
                                )
                            } else {
                                val index = films.indexOf(film)
                                val editedFilm = Film(
                                    id.toLong(),
                                    title,
                                    director,
                                    language,
                                    premiere,
                                    score.toDouble(),
                                    age.toShort(),
                                    url,
                                    10
                                )
                                films[index] = editedFilm

                            }
                            Toast.makeText(
                                this,
                                getString(R.string.film_save_confirmation),
                                Toast.LENGTH_SHORT
                            ).show()
                            // We use the intent with flags so that we return to the list without being able to return to the detail activity
                            val intent =
                                Intent(this, FilmsListActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                            startActivity(intent)
                        }
                    }.setNegativeButton(getString(R.string.cancel_button), null).create()
                    .show()

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}