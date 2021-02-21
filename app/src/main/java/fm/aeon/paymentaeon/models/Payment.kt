package fm.aeon.paymentaeon.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Payment(
    @SerializedName("desc")
    @Expose
    val desc: String = "",
    @SerializedName("amount")
    @Expose
    val amount: String = "",
    @SerializedName("currency")
    @Expose
    val currency: String? = null,
    @SerializedName("created")
    @Expose
    val created: Int,
)