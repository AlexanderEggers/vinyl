package com.acando.vinyl.structure

import android.app.Application
import com.acando.vinyl.MainActivity
import com.acando.vinyl.ui.detail.DetailFragment
import com.acando.vinyl.ui.overview.OverviewFragment
import com.acando.vinyl.ui.shoppingcart.ShoppingCartFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: OverviewFragment)
    fun inject(fragment: DetailFragment)
    fun inject(fragment: ShoppingCartFragment)
}