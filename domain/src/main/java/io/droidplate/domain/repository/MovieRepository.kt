package io.droidplate.domain.repository

import io.droidplate.domain.model.Movie
import io.reactivex.Flowable
import io.reactivex.Single

interface MovieRepository {
    fun fetchMovie(query: String): Single<List<Movie>>
    fun getAllMovie(query: String, refresh: Boolean): Single<List<Movie>>
}