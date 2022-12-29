package com.hphuc5453.twiliocallandchatexample.backend

import android.content.Context
import com.hphuc5453.twiliocallandchatexample.accesstoken.IAccessTokenService
import com.hphuc5453.twiliocallandchatexample.baseservice.IOnResponseCallBack
import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackendService @Inject constructor(
    @ApplicationContext private val context: Context
) : IBackendService {

    @Inject internal lateinit var accessTokenService: dagger.Lazy<IAccessTokenService>

    override fun getAccessToken(
        identity: String,
        callBack: IOnResponseCallBack<AccessTokenResponse>
    ) {
        accessTokenService.get().getAccessToken(identity, callBack)
    }
}