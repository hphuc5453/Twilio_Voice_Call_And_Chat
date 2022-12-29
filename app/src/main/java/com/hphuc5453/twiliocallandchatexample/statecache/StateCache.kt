package com.hphuc5453.twiliocallandchatexample.statecache

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StateCache @Inject constructor(@ApplicationContext context: Context) : IStateCache {

    companion object{
        private const val LOCAL_STATE_CACHE_SETTINGS = "StateCacheSettings"
        const val KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN"
    }

    private val preferences: SharedPreferences = context.getSharedPreferences(LOCAL_STATE_CACHE_SETTINGS, Context.MODE_PRIVATE)

    override fun save(key: String, value: String) {
        saveInternal(key, value, SharedPreferences.Editor::putString)
    }

    override fun save(key: String, value: Boolean) {
        saveInternal(key, value, SharedPreferences.Editor::putBoolean)
    }

    override fun save(key: String, value: Long) {
        saveInternal(key, value, SharedPreferences.Editor::putLong)
    }

    override fun save(key: String, value: Float) {
        saveInternal(key, value, SharedPreferences.Editor::putFloat)
    }

    override fun save(key: String, value: Int) {
        saveInternal(key, value, SharedPreferences.Editor::putInt)
    }

    override fun <T> save(key: String, value: T) {
        save(key, Gson().toJson(value))
    }

    override fun load(key: String, defaultValue: String): String {
        return loadInternal(key, defaultValue, SharedPreferences::getString)!!
    }

    override fun load(key: String, defaultValue: Boolean): Boolean {
        return loadInternal(key, defaultValue, SharedPreferences::getBoolean)
    }

    override fun load(key: String, defaultValue: Long): Long {
        return loadInternal(key, defaultValue, SharedPreferences::getLong)
    }

    override fun load(key: String, defaultValue: Float): Float {
        return loadInternal(key, defaultValue, SharedPreferences::getFloat)
    }

    override fun load(key: String, defaultValue: Int): Int {
        return loadInternal(key, defaultValue, SharedPreferences::getInt)
    }

    override fun <T> load(key: String, classOfT: Class<T>): T? {
        val jsonString = load(key, "")
        try {
            if (jsonString.isNotEmpty()) {
                return Gson().fromJson(jsonString, classOfT)
            }
        } catch (ex: Exception) {
            // parsing failed, just return null as if there's no saved data
        }
        return null
    }

    override fun remove(key: String) {
        preferences
            .edit()
            .remove(getPreferenceKey(key))
            .apply()
    }

    private fun <T> saveInternal(
        key: String,
        value: T,
        putMethod: SharedPreferences.Editor.(String, T) -> Unit
    ) {
        preferences
            .edit()
            .apply {
                putMethod(getPreferenceKey(key), value)
            }
            .apply()
    }

    private fun <T> loadInternal(
        key: String,
        defaultValue: T,
        getMethod: SharedPreferences.(String, T) -> T
    ): T {
        return preferences.run {
            getMethod(getPreferenceKey(key), defaultValue)
        }
    }

    private fun getPreferenceKey(key: String): String {
        return key
    }
}