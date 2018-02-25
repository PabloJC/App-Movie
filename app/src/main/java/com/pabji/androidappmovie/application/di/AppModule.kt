package com.pabji.androidappmovie.application.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.pabji.androidappmovie.data.persistence.room.MovieRoomDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}