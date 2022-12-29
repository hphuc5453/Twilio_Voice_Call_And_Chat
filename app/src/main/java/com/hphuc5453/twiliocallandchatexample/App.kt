package com.hphuc5453.twiliocallandchatexample

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var instance: App
        const val TAG = "[DEBUG]"
    }

    init {
        instance = this
    }
}