package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import android.content.Intent
import android.util.Patterns
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities.LoginActivity
import java.util.regex.Pattern

class ValidationUtils {
    companion object {
        private fun validateEmail(email: String): Boolean {
            // this method uses a predetermined pattern for email given by android
            val pattern: Pattern = Patterns.EMAIL_ADDRESS
            // we validate if the email matches with the pattern
            return pattern.matcher(email).matches()
        }


        fun validateRegister(
            context: Context,
            passwd: String,
            email: String,
            repeatPass: String,
        ): String {
            if (!this.validateEmail(email)) {
                return context.getString(R.string.email_format_error)
            } else if (passwd.length < 8 || passwd.length > 16) {
                return context.getString(R.string.pass_longitude_error)
            } else if (passwd != repeatPass) {
                return context.getString(R.string.pass_coincidence_error)
            }
            return ""
        }

        fun closeSession (context: Context) {
            val preferences = Preferences(context)
            preferences.saveData("")
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }
    }
}