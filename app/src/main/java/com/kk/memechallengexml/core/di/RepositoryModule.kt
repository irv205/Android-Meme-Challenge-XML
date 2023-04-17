package com.kk.memechallengexml.core.di

import com.kk.memechallengexml.data.repository.RepositoryImp
import com.kk.memechallengexml.domain.repository.IRepository
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
    abstract fun provideRepository(repositoryImp: RepositoryImp): IRepository
}