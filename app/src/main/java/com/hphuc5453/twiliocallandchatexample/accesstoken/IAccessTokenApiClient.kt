package com.hphuc5453.twiliocallandchatexample.accesstoken

import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface IAccessTokenApiClient {
    @GET("accesstoken")
    fun getAccessToken(@Query("identity") identity: String): Call<AccessTokenResponse>
}