package com.hphuc5453.twiliocallandchatexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hphuc5453.twiliocallandchatexample.backend.IBackendService
import com.hphuc5453.twiliocallandchatexample.baseservice.IOnResponseCallBack
import com.hphuc5453.twiliocallandchatexample.model.AccessTokenResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var backendService: IBackendService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        backendService.getAccessToken("peter-lee", object :
            IOnResponseCallBack<AccessTokenResponse> {
            override fun onSuccess(response: AccessTokenResponse) {
                Log.d(App.TAG, "getAccessToken success")
            }

            override fun onError(exception: Exception) {
                Log.d(App.TAG, "getAccessToken onError: ${exception.message}")
            }
        })
    }
}