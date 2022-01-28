package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import androidx.core.content.edit

class Preferences(context: Context) {

    private val fileNameSharedPreferences = "SharedPreferencesPMDM"

    //  Create shared preferences
    private val preferences =
        context.getSharedPreferences(fileNameSharedPreferences, Context.MODE_PRIVATE)

    // Function to save register data
    fun saveData(token: String) {
        preferences.edit {
            clear()
            putString("token", token)
            commit()
        }
    }

    // Function to retrieve data
    fun retrieveData(dataKey: String): String? {
        return preferences.getString(dataKey, null)
    }
}