package com.hphuc5453.twiliocallandchatexample.baseservice

import com.hphuc5453.twiliocallandchatexample.accesstoken.AccessTokenService
import com.hphuc5453.twiliocallandchatexample.accesstoken.IAccessTokenService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ServicesModule {

    @Binds
    internal abstract fun bindAccessTokenService(service: AccessTokenService): IAccessTokenService
}