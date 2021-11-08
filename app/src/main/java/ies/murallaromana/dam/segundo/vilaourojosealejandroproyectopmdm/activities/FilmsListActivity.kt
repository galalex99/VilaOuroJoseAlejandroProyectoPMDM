package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View.inflate
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R

class FilmsListActivity : AppCompatActivity() {

    private lateinit var binding:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_list_film)
        binding = FilmsListActivityBin()
    }



}