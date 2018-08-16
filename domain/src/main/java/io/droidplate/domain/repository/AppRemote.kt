package io.droidplate.domain.repository

import io.droidplate.domain.model.Movie
import io.reactivex.Single

interface AppRemote {

    fun fetchMovie(query: String): Single<List<Movie>>
}