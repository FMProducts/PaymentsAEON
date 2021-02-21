package fm.aeon.paymentaeon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import fm.aeon.paymentaeon.databinding.PaymentsActivityBinding
import fm.aeon.paymentaeon.ui.main.MainFragment
import fm.aeon.paymentaeon.utils.KEY_TOKEN
import fm.aeon.paymentaeon.utils.removeData
import fm.aeon.paymentaeon.utils.sharedPreferenceInit

class PaymentsActivity : AppCompatActivity() {

    private lateinit var viewBinding: PaymentsActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = PaymentsActivityBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        sharedPreferenceInit()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_fragment_menu , menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_logout){
            removeData(KEY_TOKEN)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
        return true
    }
}