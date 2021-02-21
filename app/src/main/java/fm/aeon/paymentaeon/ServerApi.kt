package fm.aeon.paymentaeon

import fm.aeon.paymentaeon.response.LoginResponse
import fm.aeon.paymentaeon.response.PaymentsResponse
import retrofit2.Response
import retrofit2.http.*

interface ServerApi {

    @GET("payments")
    suspend fun payments(
        @Header("v") version: Int = 1,
        @Header("app-key") key: Int = 12345,
        @Query("token") token: String
    ): Response<PaymentsResponse>

    @POST("login")
    @FormUrlEncoded
    suspend fun login(
        @Header("v") version: Int = 1,
        @Header("app-key") key: Int = 12345,
        @Field("login") username: String,
        @Field("password") password: String
    ): Response<LoginResponse>
}