package com.example.skeletondaggerapp.di.scope.main

import com.example.skeletondaggerapp.network.NetworkHandler
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class  MainActivityModule @Inject constructor(){

    @Provides
    fun provideNetworkHandler() : NetworkHandler {
        return NetworkHandler()
    }
}