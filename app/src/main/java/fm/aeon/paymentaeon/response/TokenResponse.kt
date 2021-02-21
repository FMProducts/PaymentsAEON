package fm.aeon.paymentaeon.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TokenResponse(
    @SerializedName("token")
    @Expose
    var token: String
)