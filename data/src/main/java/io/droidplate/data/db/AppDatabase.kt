package io.droidplate.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.droidplate.data.model.MovieEntity

@Database(entities = arrayOf(MovieEntity::class), version = 1)
public abstract class AppDatabase: RoomDatabase() {

   public abstract fun movieDao(): MovieDao
}