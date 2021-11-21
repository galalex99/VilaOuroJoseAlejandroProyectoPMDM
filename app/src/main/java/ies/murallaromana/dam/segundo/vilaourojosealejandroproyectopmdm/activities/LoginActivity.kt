package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityLoginBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
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
            val intent = Intent(this, FilmsListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
        // Create preferences reference
        val preference = Preferences(this)

        val userEmail = preference.retrieveData("email")
        val userpasswd = preference.retrieveData("passwd")

        Log.i("emailuser","user email"+ userEmail)
        Log.i("passwduser","user passwd"+ userpasswd)

        // testing shared puttind the user mail
        binding.tietEmailLogin.setText(userEmail)
    }
}