package com.example.skeletondaggerapp.di.scope.application

import android.app.Application
import android.content.Context

import com.example.skeletondaggerapp.core.network.AppService
import com.example.skeletondaggerapp.core.repository.RemoteDataSourceRepository
import com.example.skeletondaggerapp.db.dao.DemoDAO

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class,SharedPreferenceModule::class,RoomModule::class])
internal class AppModule{

    @Provides
    @Singleton
    fun provideContext (application: Application) : Context {
        return application
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(appService: AppService, demoDAO: DemoDAO) : RemoteDataSourceRepository {
        return RemoteDataSourceRepository(appService,demoDAO)
    }
}