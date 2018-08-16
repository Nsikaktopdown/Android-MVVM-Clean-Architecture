package io.droidplate.androidbase.model

import io.droidplate.domain.model.Movie
import java.io.Serializable
import javax.inject.Inject

data class MovieItem(val movie_id: String,
                         val movie_title: String,
                         val movie_overview: String,
                         val movie_count: String,
                     val movie_poster: String) : Serializable

/**
 * Presentation layer should be responsible of mapping the domain model to an appropriate presentation model and the presentation model to a domain model if needed.
 *
 * This is because domain should contain only business logic and shouldn't know at all about presentation or data layers.
 */
class PostItemMapper @Inject constructor() {

    fun mapToPresentation(movie: Movie): MovieItem = MovieItem(movie.movie_id, movie.movie_title, movie.movie_overview, movie.movie_count, movie.movie_poster)


    fun mapToPresentation(movieList: List<Movie>): List<MovieItem> = movieList.map { mapToPresentation(it) }

}