package com.marcodallaba.beerbox.di.module

import android.content.Context
import com.marcodallaba.beerbox.BeersBoxApplication
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindsContext(application: BeersBoxApplication): Context
}