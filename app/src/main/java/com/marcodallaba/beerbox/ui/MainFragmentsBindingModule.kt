package com.marcodallaba.beerbox.ui

import com.marcodallaba.beerbox.di.qualifier.FragmentScope
import com.marcodallaba.beerbox.ui.beers.BeersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsBindingModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun beersFragment(): BeersFragment

}