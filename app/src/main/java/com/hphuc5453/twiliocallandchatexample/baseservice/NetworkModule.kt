package com.hphuc5453.twiliocallandchatexample.baseservice

import com.hphuc5453.twiliocallandchatexample.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Provides
    internal fun provideOkHttpClient(
    ): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC)
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
}