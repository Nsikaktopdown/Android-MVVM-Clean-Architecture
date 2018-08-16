package io.droidplate.data.cache

import io.droidplate.data.db.AppDatabase
import io.droidplate.data.model.MovieEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class AppCache @Inject constructor(private val database: AppDatabase) {
    fun insertMovie(entity: List<MovieEntity>): Completable{
       return Completable.fromAction {
            kotlin.run {
                database.movieDao().insertMovie(entity)

                getAllMovie()
            }
        }
    }


    fun getAllMovie(): Single<List<MovieEntity>>{
        return database.movieDao().getAllMovies()
    }
}