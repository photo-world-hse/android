package com.photoworld.di

import com.photoworld.data.retrofit.ClientAPI
import com.photoworld.data.retrofit.RetrofitController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ClientAPIModule {

    private val clientAPI: ClientAPI = RetrofitController().getClient()

    @Provides
    @Singleton
    fun provideClientAPI(): ClientAPI {
        return clientAPI
    }

}