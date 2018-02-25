package com.pabji.androidappmovie.application.di

import android.app.Application
import com.pabji.androidappmovie.application.App
import com.pabji.androidappmovie.data.persistence.PersistenceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        PersistenceModule::class,
        ActivityBuilder::class,
        AndroidSupportInjectionModule::class))

interface AppComponent : AndroidInjector<DaggerApplication> {


    fun inject(app: App)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}