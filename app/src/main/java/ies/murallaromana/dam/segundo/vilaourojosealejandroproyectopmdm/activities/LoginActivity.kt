package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.R
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityLoginBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding


    // Initialize empty user and passwd
    private var userEmail = ""
    private var userPasswd = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        // Clear preferences
        super.onCreate(savedInstanceState)

        // Create binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // use binding to get the buttosn and add an onclickListeners
        binding.tvRegisterClick.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener() {
            // call a validation fun
            if (loginValidation()) {
                // if data is correct start list activity
                val intent = Intent(this, FilmsListActivity::class.java)
                startActivity(intent)
            } else {
                // Show error with AlertDialog
                AlertDialog.Builder(this)
                    .setTitle("Credenciales incorrectas")
                    .setMessage("Tu usuario o contraseña son incorrectos")
                    .setPositiveButton(R.string.yes
                    ) // After clicking the accept button we clean the password
                    { dialog, which ->
                        binding.tietEmailLogin.setText("")
                        binding.tietPasswdLogin.setText("")
                    }.show()


            }
        }
    }

    // Method called when it returns from the register to the login
    override fun onResume() {
        super.onResume()
        // Initialize preferences
        val preference = Preferences(this)
        userEmail = preference.retrieveData("email").toString()
        userPasswd = preference.retrieveData("passwd").toString()

        // testing shared putting the user mail
        binding.tietEmailLogin.setText(userEmail)
    }

    fun loginValidation():Boolean{
        return userEmail.equals(binding.tietEmailLogin.text.toString()) && userPasswd.equals(binding.tietPasswdLogin.text.toString())
    }
}