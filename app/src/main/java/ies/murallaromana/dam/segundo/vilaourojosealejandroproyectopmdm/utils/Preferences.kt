package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import androidx.core.content.edit

class Preferences(context: Context) {

    private val fileNameSharedPreferences = "SharedPrefencesPMDM"

    //  Create shared preferences
    private val preferences = context.getSharedPreferences(fileNameSharedPreferences, Context.MODE_PRIVATE)

    // Function to save register data
    fun saveData(email: String, pass: String) {
        preferences.edit() {
            clear()
            putString("email", email)
            putString("passwd", pass)
            commit()
        }
    }

    // Fuction to clear preferences
    fun clearData(){
        preferences.edit() {
            clear()
            commit()
        }
    }

    // Fuction to retrieve data
    fun retrieveData(dataKey:String):String?{
        return preferences.getString(dataKey,null)
    }
}