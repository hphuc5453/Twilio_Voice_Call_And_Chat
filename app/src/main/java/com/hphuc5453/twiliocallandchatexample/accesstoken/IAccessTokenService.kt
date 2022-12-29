package com.hphuc5453.twiliocallandchatexample.accesstoken

import com.hphuc5453.twiliocallandchatexample.baseservice.IOnResponseCallBack
import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse
import com.hphuc5453.twiliocallandchatexample.baseservice.IBaseService

internal interface IAccessTokenService : IBaseService {
    fun getAccessToken(identity: String, callback: IOnResponseCallBack<AccessTokenResponse>)
}