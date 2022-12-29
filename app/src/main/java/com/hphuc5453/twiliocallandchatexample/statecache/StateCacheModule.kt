package com.hphuc5453.twiliocallandchatexample.statecache

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class, ActivityComponent::class, FragmentComponent::class, ServiceComponent::class)
abstract class StateCacheModule {
    @Binds
    internal abstract fun bindStateCache(stateCache: StateCache): IStateCache
}