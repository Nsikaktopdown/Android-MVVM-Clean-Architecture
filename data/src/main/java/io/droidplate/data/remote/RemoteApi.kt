package io.droidplate.data.remote

import io.droidplate.data.model.MovieEntity
import io.droidplate.data.model.MovieReponseEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * All Api endpoint for this projects should be places here
 */

interface RemoteApi {

    @GET("discover/movie?")
    @Headers("Accept: application/json",
            "Content-type:application/json")
    fun getMovies( @Query("api_key") api_key: String,
                   @Query("language") language:String,
                   @Query("sort_by") sort_by: String,
                   @Query("page") page: Int): Single<MovieReponseEntity>
}