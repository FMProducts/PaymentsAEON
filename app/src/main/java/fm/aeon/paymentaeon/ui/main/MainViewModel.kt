package fm.aeon.paymentaeon.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fm.aeon.paymentaeon.models.Payment
import fm.aeon.paymentaeon.utils.KEY_TOKEN
import fm.aeon.paymentaeon.utils.getData
import fm.aeon.paymentaeon.utils.serverApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _payments = MutableLiveData<List<Payment>>().apply {
        value = emptyList()
    }

    var payments: LiveData<List<Payment>> = _payments

    fun loadPayments() {
        CoroutineScope(Dispatchers.Main).launch {
            val token = getData(KEY_TOKEN)
            val response = serverApi().payments(token = token ?: " ")
            if (response.isSuccessful){
                response.body()?.let {
                    _payments.value = it.response
                }
            }
        }
    }
}