package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityRegisterBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.ValidationUtils

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
        binding.btnRegister.setOnClickListener() {
            val pass = binding.tietRegisterPasswd.text.toString()
            val repeatPass = binding.tietRepeteatPassword.text.toString()
            val email = binding.tietRegisterEmail.text.toString()
            val error = ValidationUtils.validateRegister(this, pass, email, repeatPass)

            when (error) {
                getString(R.string.email_format_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterEmail.setText("")
                }
                getString(R.string.pass_longitude_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterPasswd.setText("")
                }
                getString(R.string.pass_coincidence_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterPasswd.setText("")
                    binding.tietRepeteatPassword.setText("")
                }
                else -> {
                    // Save data in shared preferences when button clicked
                    preferences.saveData(
                        binding.tietRegisterEmail.text.toString(),
                        binding.tietRegisterPasswd.text.toString()
                    )
                    super.onBackPressed()
                }
            }

        }

    }
}