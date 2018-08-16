package io.droidplate.data.repository

import io.droidplate.data.cache.AppCache
import io.droidplate.data.db.AppDatabase
import io.droidplate.data.mapper.MovieMapper
import io.droidplate.data.model.MovieEntity
import io.droidplate.domain.model.Movie
import io.droidplate.domain.repository.AppRemote
import io.droidplate.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 *  This class implements the post repository logic from the domain layer
 *  @param appCache
 */
class MovieRepositoryImpl @Inject constructor(private val appCache: AppCache,
                                              private val remote: AppRemote,
                                              private val mapper: MovieMapper) : MovieRepository {

    /**
     *  Fetching from the local db source to the domain when refresh is false and from server when it's true
     *  @param refresh progress state
     */
    override fun getAllMovie(query: String, refresh: Boolean): Single<List<Movie>> = when(refresh) {
        true ->  fetchMovie(query)
        false -> appCache.getAllMovie().map { mapper.mapToDomain(it) }.onErrorResumeNext { getAllMovie(query, true) }

    }

    /**
     *  Fetching from the remote source to the domain
     *  @param query -> request query
     */
    override fun fetchMovie(query: String): Single<List<Movie>> =
            remote.fetchMovie(query).doOnSuccess { it ->
                kotlin.run {
                    appCache.insertMovie(mapper.mapToEntity(it)).subscribe()
                }

            }
}