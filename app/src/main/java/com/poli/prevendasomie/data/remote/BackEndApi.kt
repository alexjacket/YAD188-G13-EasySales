package com.poli.prevendasomie.data.remote

import com.poli.prevendasomie.data.Result
import com.poli.prevendasomie.login.domain.model.Credentials
import com.poli.prevendasomie.login.domain.model.LoginResponse
import com.poli.prevendasomie.signup.domain.model.SignUpResponse
import com.poli.prevendasomie.signup.domain.model.UserData
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface BackEndApi {

    @POST("login")
    @Headers("Content-Type: application/json")
    suspend fun executeLogin(@Body credentials: Credentials): Result<LoginResponse>

    @POST("users/registrations")
    @Headers("Content-Type: application/json")
    suspend fun userRegistration(@Body userData: UserData): Result<SignUpResponse>
}
