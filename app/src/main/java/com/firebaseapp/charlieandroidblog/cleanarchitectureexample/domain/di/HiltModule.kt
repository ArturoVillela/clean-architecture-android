package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.di

import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.network.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(FragmentComponent::class) // one of those things that i have no idea why.. but it most be there
object HiltModule {

    @Provides
    @Singleton
    @Named("repository")
    fun providesUserRepository(): UserRepository {
        return UserRepository()
    }
}