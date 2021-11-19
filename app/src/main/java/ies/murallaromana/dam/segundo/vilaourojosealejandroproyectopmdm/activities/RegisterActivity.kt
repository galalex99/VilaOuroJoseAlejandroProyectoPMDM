package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var btnRegistro : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegistro= findViewById(R.id.btnRegister)
        btnRegistro.setOnClickListener(){
            super.onBackPressed()
        }

    }
}