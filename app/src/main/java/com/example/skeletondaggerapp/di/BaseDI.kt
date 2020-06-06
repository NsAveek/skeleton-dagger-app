package com.example.skeletondaggerapp.di

import android.app.Application
import com.example.skeletondaggerapp.BaseApp
import com.example.skeletondaggerapp.di.scope.application.AppModule
import com.example.skeletondaggerapp.di.scope.main.MainActivityModule
import com.example.skeletondaggerapp.di.scope.main.MainActivityVMModule
import com.example.skeletondaggerapp.ui.home.MainActivity
import com.example.skeletondaggerapp.viewModel.ViewModelFactoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class, // This class is responsible for all of the @singleton dependencies like retrofit, db, sharedPrefs etc
        LocalDependencyBuilder::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance // Binds a particular instance of the object through the component of the time of construction
        fun application(application: Application): Builder // This makes the application available through all modules available
        fun build(): AppComponent
    }
    override fun inject(app: BaseApp)
}

@Module
internal abstract class LocalDependencyBuilder {
    @ContributesAndroidInjector(
        modules = [MainActivityModule::class,
            MainActivityVMModule::class,
            MainActivityFragmentsProvider::class]
    )
    abstract fun bindMainActivity(): MainActivity
}


@Module
internal abstract class MainActivityFragmentsProvider {
//    @ContributesAndroidInjector(modules = [Fragment1VMModule::class])
//    abstract fun bindFragment1(): Fragment1()
}