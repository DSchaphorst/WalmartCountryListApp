package com.interview.countryapp

import android.app.Application
import com.interview.countryapp.di.AppModule
import com.interview.countryapp.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CountryApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CountryApp)
            modules(listOf(AppModule, NetworkModule))
        }
    }
}