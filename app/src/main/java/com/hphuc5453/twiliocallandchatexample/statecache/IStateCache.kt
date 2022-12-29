package com.hphuc5453.twiliocallandchatexample.statecache

interface IStateCache {
    fun save(key: String, value: String)
    fun load(key: String, defaultValue: String): String
    fun save(key: String, value: Boolean)
    fun load(key: String, defaultValue: Boolean): Boolean
    fun save(key: String, value: Long)
    fun load(key: String, defaultValue: Long): Long
    fun save(key: String, value: Float)
    fun load(key: String, defaultValue: Float): Float
    fun save(key: String, value: Int)
    fun load(key: String, defaultValue: Int): Int
    fun <T> save(key: String, value: T)
    fun <T> load(key: String, classOfT: Class<T>): T?
    fun remove(key: String)
}