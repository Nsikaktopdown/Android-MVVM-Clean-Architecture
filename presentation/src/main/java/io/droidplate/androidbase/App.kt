package io.droidplate.androidbase

import android.app.Application
import io.droidplate.androidbase.di.AppModule
import io.droidplate.androidbase.di.DaggerInjector
import io.droidplate.androidbase.di.Injector

class App : Application() {

    lateinit var injector: Injector private set

    override fun onCreate() {
        super.onCreate()

       initDagger()

    }

    /**
     * Initial Dagger Instance in the application class
     * Making this available anywhere in the app
     */
    private fun initDagger() {
        injector = DaggerInjector
                .builder()
                .appModule(AppModule(this))
                .build()
    }
}