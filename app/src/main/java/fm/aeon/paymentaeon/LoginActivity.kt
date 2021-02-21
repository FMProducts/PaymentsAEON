package fm.aeon.paymentaeon

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fm.aeon.paymentaeon.databinding.ActivityLoginBinding
import fm.aeon.paymentaeon.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        sharedPreferenceInit()
        if (getData(KEY_TOKEN) != null) nextActivity()
        else init()
    }

    private fun init() {
        viewBinding.loginSubmitButton.setOnClickListener {
            if (viewBinding.loginPassword.isValid() && viewBinding.loginUsername.isValid())
                login()
            else
                toast(R.string.incorrect_data)
        }

        val username = getData(KEY_USERNAME)
        username?.let {
            viewBinding.loginUsername.setText(it)
        }
    }

    private fun login() {
        val username = viewBinding.loginUsername.text.toString()
        val password = viewBinding.loginPassword.text.toString()
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val response = serverApi().login(username = username, password = password)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.success) {
                            setData(KEY_TOKEN, it.response.token)
                            setData(KEY_USERNAME, username)
                            nextActivity()
                        } else toast(R.string.incorrect_username_or_password)
                    }
                } else {
                    toast(R.string.network_error)
                }
            } catch (e: Exception) {
                toast(R.string.network_error)
                log(e.message.toString())
            }
        }
    }


    private fun nextActivity() {
        val intent = Intent(this, PaymentsActivity::class.java)
        startActivity(intent)
        finish()
    }


}