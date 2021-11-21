package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityRegisterBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crate binding find de data and know when the button is pressed
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create reference to class preferences
        val preferences = Preferences(this)

        // use binding to get the button and add an onclickListener
        binding.btnRegister.setOnClickListener(){
            // Save data in shared preferences when button clicked
            preferences.saveData(binding.tietRegisterEmail.text.toString(),binding.tietRegisterPasswd.toString())
            super.onBackPressed()
        }

    }
}