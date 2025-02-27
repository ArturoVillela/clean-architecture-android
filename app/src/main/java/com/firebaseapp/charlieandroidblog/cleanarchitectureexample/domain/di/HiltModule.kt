package com.firebaseapp.charlieandroidblog.cleanarchitectureexample.domain.di

import com.firebaseapp.charlieandroidblog.cleanarchitectureexample.data.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(FragmentComponent::class) // one of those things that i have no idea why.. but it most be there
object HiltModule {

    @Provides
    @Named("repository")
    fun providesUserRepository():UserRepository{
        return UserRepository()
    }
}