package io.droidplate.data.mapper

import io.droidplate.data.model.MovieEntity
import io.droidplate.data.model.MovieReponseEntity
import io.droidplate.domain.model.Movie
import javax.inject.Inject

/**
 * Entity mapper for data-flow between layers
 */
class MovieMapper @Inject constructor() {

    fun mapToDomain(entity: MovieEntity): Movie = Movie(entity.movie_id,
            entity.movie_title,
            entity.movie_overview,
            entity.movie_count, entity.movie_poster)

    fun mapToDomain(list: List<MovieEntity>): List<Movie> = list.map { mapToDomain(it) }

    fun mapToEntity(movie: Movie): MovieEntity = MovieEntity(movie.movie_id, movie.movie_title, movie.movie_overview, movie.movie_count, movie.movie_poster)

    fun mapToEntity(list: List<Movie>): List<MovieEntity> = list.map { mapToEntity(it) }

    fun mapToMovieEntity(entity: MovieReponseEntity): List<MovieEntity> {
        return entity.results
    }
}