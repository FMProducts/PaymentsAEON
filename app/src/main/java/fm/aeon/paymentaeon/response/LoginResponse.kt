package fm.aeon.paymentaeon.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

open class LoginResponse(
    @SerializedName("success")
    @Expose
    var success: Boolean,
    @SerializedName("response")
    @Expose
    var response: TokenResponse
)