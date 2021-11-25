package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.util.Patterns
import java.util.regex.Pattern

class ValidationUtils {
    companion object {
         private fun validateEmail(email: String): Boolean {
            // this method uses a predetermined pattern for email given by android
            val pattern: Pattern = Patterns.EMAIL_ADDRESS
            // we validate if the email matches with the pattern
            return pattern.matcher(email).matches()
        }


         fun validateRegister(passwd:String, email: String, repeatPass: String): String {
            if (!validateEmail(email)) {
                return "El email con formato incorrecto"
            } else if (passwd.length < 8 || passwd.length > 16) {
                return "La contraseña con longitud incorrecta"
            }else if(passwd != repeatPass){
                return  "Los campos de contraseña y repite contraseña son distintos"
            }
            return ""
        }
    }
}