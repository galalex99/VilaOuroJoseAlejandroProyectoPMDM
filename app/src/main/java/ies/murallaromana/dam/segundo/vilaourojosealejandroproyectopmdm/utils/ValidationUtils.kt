package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils

import android.content.Context
import android.util.Patterns
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import java.util.regex.Pattern

class ValidationUtils {
    companion object {
         private fun validateEmail(email: String): Boolean {
            // this method uses a predetermined pattern for email given by android
            val pattern: Pattern = Patterns.EMAIL_ADDRESS
            // we validate if the email matches with the pattern
            return pattern.matcher(email).matches()
        }


         fun validateRegister(contexto: Context, passwd:String, email: String, repeatPass: String): String {
            if (!this.validateEmail(email)) {
                return contexto.getString(R.string.email_format_error)
            } else if (passwd.length < 8 || passwd.length > 16) {
                return contexto.getString(R.string.pass_longitude_error)
            }else if(passwd != repeatPass){
                return  contexto.getString(R.string.pass_coincidence_error)
            }
            return ""
        }
    }
}