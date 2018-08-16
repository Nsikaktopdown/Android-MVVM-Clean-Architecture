package io.droidplate.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.droidplate.data.model.MovieEntity
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
interface MovieDao {

    /**
     * Get all saved movie using this dao interface method
     */
    @Query("SELECT * FROM movie")
    fun  getAllMovies(): Single<List<MovieEntity>>


    /**
     * Save movie into db
     */
    @Insert(onConflict = REPLACE)
    fun insertMovie(movieEntity: List<MovieEntity>)
}