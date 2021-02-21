package fm.aeon.paymentaeon.utils

import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.gson.GsonBuilder
import fm.aeon.paymentaeon.ServerApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://82.202.204.94/api/"
const val TAG = "Payment/AEON"

fun EditText.isValid(): Boolean = length() > 2

fun Context.toast(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun log(message: String) {
    Log.e(TAG, message)
}

fun serverApi(): ServerApi {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
            )
        )
        .build()

    return retrofit.create(ServerApi::class.java)
}
