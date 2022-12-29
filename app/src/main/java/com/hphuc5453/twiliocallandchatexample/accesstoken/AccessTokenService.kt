package com.hphuc5453.twiliocallandchatexample.accesstoken

import com.hphuc5453.twiliocallandchatexample.baseservice.IOnResponseCallBack
import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse
import com.hphuc5453.twiliocallandchatexample.baseservice.BaseService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class AccessTokenService @Inject constructor(
    private val apiClient: IAccessTokenApiClient
) : BaseService(), IAccessTokenService {

    override fun getAccessToken(
        identity: String,
        callback: IOnResponseCallBack<AccessTokenResponse>
    ) {
        apiClient.getAccessToken(identity).enqueue(getBaseResponseCallbackHandler(callback))
    }
}