package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegisterActivity : AppCompatActivity() {
    private lateinit var btnRegistro : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnRegistro= findViewById( R.id.btnRegistro)
        btnRegistro.setOnClickListener(){
            super.onBackPressed()
        }

    }
}