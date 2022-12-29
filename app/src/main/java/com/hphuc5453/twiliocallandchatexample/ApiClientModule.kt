package com.hphuc5453.twiliocallandchatexample

import com.hphuc5453.twiliocallandchatexample.accesstoken.IAccessTokenApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient

@Module
@InstallIn(SingletonComponent::class)
internal object ApiClientModule {
    @Provides
    internal fun provideIAccessTokenApiClient(okHttpClient: OkHttpClient): IAccessTokenApiClient {
        val apiClientBuilder = TwilioService.getClient(okHttpClient)
        return apiClientBuilder.create(IAccessTokenApiClient::class.java)
    }
}