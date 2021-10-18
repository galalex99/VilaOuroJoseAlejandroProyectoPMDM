package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var tvClickRegistro : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val preferenciasApp = getSharedPreferences("Preferencias",MODE_PRIVATE)
        tvClickRegistro= findViewById( R.id.tvClickRegistro)
        tvClickRegistro.setOnClickListener(){
        val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}