package com.hphuc5453.twiliocallandchatexample.backend

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BackendServiceModule {
    @Singleton
    @Binds
    internal abstract fun bindBackendService(backendService: BackendService): IBackendService
}