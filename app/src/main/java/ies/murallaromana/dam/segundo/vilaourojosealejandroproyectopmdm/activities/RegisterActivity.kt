package ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.R
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.RetrofitClient
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.databinding.ActivityRegisterBinding
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.model.entities.User
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.Preferences
import ies.murallaromana.dam.segundo.vilaourojosealejandroproyectopmdm.utils.ValidationUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Crate binding find de data and know when the button is pressed
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // use binding to get the button and add an onclickListener
        binding.btnRegister.setOnClickListener {
            val pass = binding.tietRegisterPasswd.text.toString()
            val repeatPass = binding.tietRepeteatPassword.text.toString()
            val email = binding.tietRegisterEmail.text.toString()

            when (val error = ValidationUtils.validateRegister(this, pass, email, repeatPass)) {
                getString(R.string.email_format_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterEmail.setText("")
                }
                getString(R.string.pass_longitude_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterPasswd.setText("")
                }
                getString(R.string.pass_coincidence_error) -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    binding.tietRegisterPasswd.setText("")
                    binding.tietRepeteatPassword.setText("")
                }
                else -> {
                    // Create User object to save the data and register on the api
                    val u = User(binding.tietRegisterEmail.text.toString().trim(),
                        binding.tietRegisterPasswd.text.toString().trim())
                    val RegisterContext=this
                    val registerCall = RetrofitClient.apiRetrofit.signup(u)

                    registerCall.enqueue(object : Callback<Unit> {
                        override fun onFailure(call: Call<Unit>, t: Throwable) {
                            Log.d("Register OnFailure",t.toString())
                        }

                        override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                            Log.d("Register OnResponse ",response.toString())

                            if(response.code() in 200..299){
                                Toast.makeText(RegisterContext,"Registro correcto",Toast.LENGTH_SHORT).show()
                            }else{
                                Log.d("Erro no registro: ",response.toString())
                            }
                        }
                    }
                    )
                    super.onBackPressed()
                }
            }

        }

    }
}