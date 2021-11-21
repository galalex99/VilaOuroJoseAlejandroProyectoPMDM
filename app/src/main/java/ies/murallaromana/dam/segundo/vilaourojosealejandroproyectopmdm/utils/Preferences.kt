package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import androidx.core.content.edit

class Preferences(context: Context) {
    private val fileNameSharedPreferences = "SharedPrefencesPMDM"

    //  Create shared preferences
    private val preferences = context.getSharedPreferences(fileNameSharedPreferences, 0)

    // Function to save register data
    fun saveData(email: String, pass: String) {
        preferences.edit() {
            putString("email", email)
            putString("passwd", pass)
            commit()
        }
    }

    // Fuction to retrieve data
    fun retrieveData(dataKey:String):String?{
        return preferences.getString(dataKey,null)
    }
}