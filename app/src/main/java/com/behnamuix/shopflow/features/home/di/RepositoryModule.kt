package com.behnamuix.shopflow.features.home.di

import com.behnamuix.shopflow.features.home.data.repository.HomeRepositoryImpl
import com.behnamuix.shopflow.features.home.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        productRepositoryImpl: HomeRepositoryImpl,
    ): HomeRepository
}
