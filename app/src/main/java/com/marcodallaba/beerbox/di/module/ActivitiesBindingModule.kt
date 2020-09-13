package com.marcodallaba.beerbox.di.module

import com.marcodallaba.beerbox.di.qualifier.ActivityScoped
import com.marcodallaba.beerbox.ui.MainActivity
import com.marcodallaba.beerbox.ui.MainFragmentsBindingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainFragmentsBindingModule::class])
    abstract fun mainActivity(): MainActivity
}