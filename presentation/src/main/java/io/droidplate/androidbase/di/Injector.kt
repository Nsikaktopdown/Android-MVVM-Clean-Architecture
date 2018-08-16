package io.droidplate.androidbase.di

import dagger.Component
import io.droidplate.androidbase.ui.movie.MovieActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, NetworkModule::class, RepositoryModule::class])
interface Injector {

    fun inject(activity: MovieActivity)
}