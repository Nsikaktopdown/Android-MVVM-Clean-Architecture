package io.droidplate.androidbase.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.droidplate.androidbase.ViewModelFactory
import io.droidplate.androidbase.ViewModelKey
import io.droidplate.androidbase.ui.movie.MovieViewModel



@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun movieViewModel(viewModel: MovieViewModel): ViewModel
}