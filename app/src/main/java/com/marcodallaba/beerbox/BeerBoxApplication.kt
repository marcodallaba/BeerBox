package com.marcodallaba.beerbox

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin

class BeerBoxApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        // start Koin DI module
        startKoin {
            androidLogger()
            androidContext(this@BeerBoxApplication)
            modules(appModule)
        }
    }


}