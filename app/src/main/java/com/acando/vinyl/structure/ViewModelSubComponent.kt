package com.acando.vinyl.structure

import com.acando.vinyl.ui.detail.DetailViewModel
import com.acando.vinyl.ui.overview.OverviewViewModel
import com.acando.vinyl.ui.shoppingcart.ShoppingCartViewModel
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