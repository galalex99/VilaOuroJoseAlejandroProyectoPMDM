package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.R.string
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.RetrofitClient
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityLoginBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.Token
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.User
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // Change the title to login since it was the app name to see the name on the launcher
        title = getString(R.string.login_line)
        // Clear preferences
        super.onCreate(savedInstanceState)
        val LoginContext = this
        // Create binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // use binding to get the buttosn and add an onclickListeners
        binding.tvRegisterClick.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        var loginCorrecto:Boolean = false
        binding.btLogin.setOnClickListener {
            // call a validation fun
            //if (loginValidation()) {
                // Create a user var and login on api with
                var user = User(binding.tietEmailLogin.text.toString(), binding.tietPasswdLogin.text.toString())
                val loginCall = RetrofitClient.apiRetrofit.login(user)
                loginCall.enqueue(object : Callback<Token> {
                    override fun onFailure(call: Call<Token>, t: Throwable) {
                     Log.d("Login OnFailure",t.toString())
                        loginCorrecto=false
                    }

                    override fun onResponse(call: Call<Token>, response: Response<Token>) {
                        Log.d("Login OnResponse ",response.toString())

                        if(response.code() in 200..299){
                            val token = response.body()?.tokenstr
                            Log.d("respuesta: token:", token.orEmpty())
                                loginCorrecto=true
                        }else{
                            Toast.makeText(LoginContext,"Error na autenticacion, intenta mais tarde",Toast.LENGTH_SHORT).show()
                            loginCorrecto=false
                        }

                    }


                })
                // if data is correct start list activity
                if(loginCorrecto){
                val intent = Intent(this, FilmsListActivity::class.java)
                startActivity(intent)}
           /* } else {
                // Show error with AlertDialog
                AlertDialog.Builder(this)
                    .setTitle(getString(R.string.incorrect_credentials_title))
                    .setMessage(getString(R.string.incorrect_credentials_message))
                    .setPositiveButton(
                        string.ok
                    ) // After clicking the accept button we clean the password
                    { _, _ ->
                        binding.tietEmailLogin.setText("")
                        binding.tietPasswdLogin.setText("")
                    }.show()


            }*/
        }
    }

    // Method called when it returns from the register to the login
    override fun onResume() {
        super.onResume()
    }
}