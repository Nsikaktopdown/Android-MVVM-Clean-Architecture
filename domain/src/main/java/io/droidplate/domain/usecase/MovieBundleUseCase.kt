package io.droidplate.domain.usecase

import io.droidplate.domain.model.Movie
import io.droidplate.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieBundleUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    /**
     * This use case to gets the user's post from the Repository in the domain
     */
    fun getMovies(query: String, refresh: Boolean): Single<List<Movie>> =  movieRepository.getAllMovie(query,refresh)

}