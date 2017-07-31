package de.acando.vinyl.structure

import android.app.Application
import de.acando.vinyl.ui.detail.DetailFragment
import de.acando.vinyl.ui.overview.OverviewFragment
import de.acando.vinyl.ui.shoppingcart.ShoppingCartFragment
import dagger.BindsInstance
import dagger.Component
import de.acando.vinyl.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        @BindsInstance
        fun activity(activity: MainActivity) : Builder

        fun build(): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: OverviewFragment)
    fun inject(fragment: DetailFragment)
    fun inject(fragment: ShoppingCartFragment)
}