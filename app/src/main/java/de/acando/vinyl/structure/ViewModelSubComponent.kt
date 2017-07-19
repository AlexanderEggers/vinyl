package de.acando.vinyl.structure

import de.acando.vinyl.ui.detail.DetailViewModel
import de.acando.vinyl.ui.overview.OverviewViewModel
import de.acando.vinyl.ui.shoppingcart.ShoppingCartViewModel
import dagger.Subcomponent

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }

    fun overviewViewModel(): OverviewViewModel
    fun detailViewModel(): DetailViewModel
    fun shoppingCartViewModel(): ShoppingCartViewModel
}