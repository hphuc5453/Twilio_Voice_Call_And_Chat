package com.hphuc5453.twiliocallandchatexample.accesstoken

import com.hphuc5453.twiliocallandchatexample.App
import com.hphuc5453.twiliocallandchatexample.statecache.IStateCache
import com.hphuc5453.twiliocallandchatexample.statecache.StateCache
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@EntryPoint
private interface AccessTokenEntryPoint {
    val stateCache: IStateCache
}

object AccessTokenUtil {

    var token: String
        get() = stateCache.load(StateCache.KEY_ACCESS_TOKEN, "")
        set(value) {
            stateCache.save(StateCache.KEY_ACCESS_TOKEN, value)
        }
    private val stateCache = EntryPointAccessors.fromApplication(
        App.instance, AccessTokenEntryPoint::class.java
    ).stateCache

    fun generateAccessToken(identity: String) {
    }
}