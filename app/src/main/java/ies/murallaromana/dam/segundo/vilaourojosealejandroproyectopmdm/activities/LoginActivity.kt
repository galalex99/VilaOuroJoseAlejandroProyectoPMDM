package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityListFilmsBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var tvClickRegistro: TextView
    private lateinit var btClickLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val preferenciasApp = getSharedPreferences("Preferencias", MODE_PRIVATE)

        tvClickRegistro = findViewById(R.id.tvClickRegistro)
        tvClickRegistro.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        btClickLogin = findViewById(R.id.btLogin)
        btClickLogin.setOnClickListener() {
            val intent = Intent(this, FilmsListActivity::class.java)
            startActivity(intent)
        }

    }
}