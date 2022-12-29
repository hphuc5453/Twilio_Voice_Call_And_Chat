package com.hphuc5453.twiliocallandchatexample.baseservice

interface IOnResponseCallBack<T> {
    /**
     * Called once upon getting a response.
     */
    fun onSuccess(response: T)

    /**
     * Called once upon getting an error.
     */
    fun onError(exception: Exception)
}