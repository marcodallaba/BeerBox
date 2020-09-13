package com.marcodallaba.beerbox.di

import com.marcodallaba.beerbox.BeersBoxApplication
import com.marcodallaba.beerbox.data.source.BeersDataSourceBindingModule
import com.marcodallaba.beerbox.data.source.local.BeersRoomModule
import com.marcodallaba.beerbox.di.module.ActivitiesBindingModule
import com.marcodallaba.beerbox.di.module.AppModule
import com.marcodallaba.beerbox.di.module.NetModule
import com.marcodallaba.beerbox.ui.beers.BeersViewModelBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        NetModule::class,
        BeersDataSourceBindingModule::class,
        BeersRoomModule::class,
        BeersDataSourceBindingModule::class,
        BeersViewModelBindingModule::class,
        ActivitiesBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<BeersBoxApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: BeersBoxApplication): Builder

        fun build(): AppComponent
    }

}