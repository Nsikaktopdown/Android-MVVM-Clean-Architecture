package io.droidplate.androidbase.di

import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import io.droidplate.androidbase.App
import io.droidplate.data.cache.AppCache
import io.droidplate.data.cache.helper.IPreferenceHelper
import io.droidplate.data.cache.helper.IPreferenceHelperImpl
import io.droidplate.data.db.AppDatabase
import javax.inject.Singleton


@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    /**
     * Room Database instance
     * @param app application context
     */
    @Provides
    @Singleton
    fun provideAppDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, "base.db").build()
    }


    @Provides
    @Singleton
    fun providePreferenceHelper(ipreference: IPreferenceHelperImpl): IPreferenceHelper = ipreference

}