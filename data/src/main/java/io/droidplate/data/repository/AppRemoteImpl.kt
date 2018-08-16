package io.droidplate.data.repository


import io.droidplate.data.mapper.MovieMapper
import io.droidplate.data.remote.RemoteApi
import io.droidplate.domain.model.Movie
import io.droidplate.domain.repository.AppRemote
import io.reactivex.Single
import retrofit2.http.Query
import javax.inject.Inject

/**
 * Here implements all the api interface
 * Binding this it to the domain
 * @param api retrofitr inteface
 * @param mapper data passer
 */
class AppRemoteImpl @Inject constructor(private val api: RemoteApi,
                                        private val mapper: MovieMapper): AppRemote {

    override fun fetchMovie(query: String): Single<List<Movie>> {
       return api.getMovies( "5ecbadc34e688b014eca3b23d34a2723", query,"popularity.desc",1).map {it -> mapper.mapToDomain(mapper.mapToMovieEntity(it)) }
    }
}