package io.droidplate.androidbase.di

import dagger.Binds
import dagger.Module
import io.droidplate.data.repository.MovieRepositoryImpl
import io.droidplate.domain.repository.MovieRepository

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(repository: MovieRepositoryImpl): MovieRepository

}