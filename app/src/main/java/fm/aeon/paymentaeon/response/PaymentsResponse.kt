package fm.aeon.paymentaeon.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fm.aeon.paymentaeon.models.Payment

open class PaymentsResponse(
    @SerializedName("success")
    @Expose
    var success: Boolean = false,
    @SerializedName("response")
    @Expose
    var response: List<Payment> = emptyList()
)