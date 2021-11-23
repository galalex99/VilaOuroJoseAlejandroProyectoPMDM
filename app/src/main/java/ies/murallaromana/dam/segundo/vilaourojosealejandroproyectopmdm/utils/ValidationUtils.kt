package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import android.util.Patterns
import android.widget.Toast
import java.util.regex.Pattern

class ValidationUtils {
    companion object{
        private  fun validateEmail(email: String): Boolean {
            // this method uses a predetermined pattern for email given by android
            val pattern: Pattern = Patterns.EMAIL_ADDRESS
            // we validate if the email matches with the pattern
            return pattern.matcher(email).matches()
        }

    }


    private fun validateRegister(context: Context, passwd:String, email: String): Boolean {
        if (validateEmail(email) == false) {
            Toast.makeText(context, "El email con formato incorrecto", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (passwd.length < 8 || passwd.length > 16) {
            Toast.makeText(context, "La contraseña con longitud incorrecta", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }
}