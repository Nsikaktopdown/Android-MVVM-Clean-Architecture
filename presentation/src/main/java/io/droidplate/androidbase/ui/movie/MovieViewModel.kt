package io.droidplate.androidbase.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.droidplate.androidbase.Data
import io.droidplate.androidbase.DataState
import io.droidplate.androidbase.model.MovieItem
import io.droidplate.androidbase.model.PostItemMapper
import io.droidplate.data.cache.helper.IPreferenceHelper
import io.droidplate.domain.usecase.MovieBundleUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val useCase: MovieBundleUseCase,
                                        private val mapper: PostItemMapper) : ViewModel(){

    val movies = MutableLiveData<Data<List<MovieItem>>>()
    private val compositeDisposable = CompositeDisposable()

    init {

    }

    fun getMovie(refresh: Boolean = false, query: String) =
            compositeDisposable.add(useCase.getMovies(query,refresh)
                    .doOnSubscribe { movies.postValue(Data(dataState = DataState.LOADING, data = movies.value?.data, message = null)) }
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .map { mapper.mapToPresentation(it) }
                    .subscribe({
                        movies.postValue(Data(dataState = DataState.SUCCESS, data = it, message = null))
                    }, { movies.postValue(Data(dataState = DataState.ERROR, data = movies.value?.data, message = it.message)) }))



    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}