package fm.aeon.paymentaeon.utils

import android.app.Activity
import android.content.SharedPreferences


private lateinit var sharedPreferences: SharedPreferences
private const val NAME = "payments_aeon"

const val KEY_TOKEN = "token"
const val KEY_USERNAME = "username"

fun Activity.sharedPreferenceInit() {
    sharedPreferences =
        applicationContext.getSharedPreferences(NAME, android.content.Context.MODE_PRIVATE)
}

fun Activity.getData(key: String, default: String? = null): String? {
    return sharedPreferences.getString(key, default)
}

fun Activity.removeData(key: String){
    val editor = sharedPreferences.edit()
    editor.remove(key)
    editor.apply()
}

fun Activity.setData(key: String, newData: String){
    val editor = sharedPreferences.edit()
    editor.putString(key, newData)
    editor.apply()
}

