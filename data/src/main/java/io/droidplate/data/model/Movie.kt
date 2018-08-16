package io.droidplate.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json


@Entity(tableName = "movie")
data class MovieEntity(@PrimaryKey(autoGenerate = false)
                       @Json(name = "id") val movie_id: String,
                       @Json(name = "original_title") val movie_title: String,
                       @Json(name = "overview") val movie_overview: String,
                       @Json(name = "vote_count") val movie_count: String,
                       @Json(name = "backdrop_path") val movie_poster: String)



data class MovieReponseEntity(
        @Json(name ="results") val results: List<MovieEntity>
)