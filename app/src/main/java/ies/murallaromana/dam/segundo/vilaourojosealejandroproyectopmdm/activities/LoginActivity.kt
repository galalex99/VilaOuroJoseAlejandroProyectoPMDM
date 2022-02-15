package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.isVisible
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
        val loginContext = this

        // Get shared preferences check the token or save it
        val preferences = Preferences(this)
        if (!preferences.retrieveData("token").isNullOrEmpty()) {
            val intent = Intent(this, FilmsListActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }
        // Create binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // use binding to get the button and add an onclickListeners
        binding.tvRegisterClick.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        binding.btLogin.setOnClickListener {
            // Create a user var and login on api with
            val user = User(binding.tietEmailLogin.text.toString(),
                binding.tietPasswdLogin.text.toString())
            binding.btLogin.isEnabled=false
            binding.progressBar.visibility= View.VISIBLE
            val loginCall = RetrofitClient.apiRetrofit.login(user)
            loginCall.enqueue(object : Callback<Token> {
                override fun onFailure(call: Call<Token>, t: Throwable) {
                    Log.d("Login OnFailure", t.toString())
                    binding.btLogin.isEnabled=true
                    binding.progressBar.visibility= View.INVISIBLE
                }

                override fun onResponse(call: Call<Token>, response: Response<Token>) {
                    Log.d("Login OnResponse ", response.toString())

                    if (response.code() in 200..299) {
                        val token = response.body()?.tokenstr
                        if (token.isNullOrEmpty()) {
                            Toast.makeText(loginContext,
                                "Error gardando o token",
                                Toast.LENGTH_SHORT).show()
                            binding.btLogin.isEnabled=true
                            binding.progressBar.visibility= View.INVISIBLE
                        } else {
                            preferences.saveData(token)
                            Log.d("LoginC", "Login correcto")

                            val intent = Intent(loginContext, FilmsListActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)

                        }
                    } else {
                        Toast.makeText(loginContext,
                            "Error na autenticacion, intenta mais tarde",
                            Toast.LENGTH_SHORT).show()
                        binding.btLogin.isEnabled=true
                    }

                }
            })
        }
    }
}