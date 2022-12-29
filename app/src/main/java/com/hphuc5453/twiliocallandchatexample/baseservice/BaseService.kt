package com.hphuc5453.twiliocallandchatexample.baseservice

import android.util.Log
import com.hphuc5453.twiliocallandchatexample.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

internal abstract class BaseService: IBaseService {
    protected fun <T> getBaseResponseCallbackHandler(callback: IOnResponseCallBack<T>): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (!response.isSuccessful) {
                    Log.d(App.TAG,"getBaseResponseCallbackHandler error: ${response.errorBody()}")
                    return
                }
                val responseData = response.body()!!
                callback.onSuccess(responseData)
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                callback.onError(Exception(t.message))
            }
        }
    }
}