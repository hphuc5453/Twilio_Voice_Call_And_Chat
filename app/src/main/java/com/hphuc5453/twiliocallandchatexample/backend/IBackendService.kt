package com.hphuc5453.twiliocallandchatexample.backend

import com.hphuc5453.twiliocallandchatexample.baseservice.IOnResponseCallBack
import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse

interface IBackendService {
    fun getAccessToken(identity: String, callBack: IOnResponseCallBack<AccessTokenResponse>)
}