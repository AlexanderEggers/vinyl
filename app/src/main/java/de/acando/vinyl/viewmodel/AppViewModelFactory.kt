package de.acando.vinyl.viewmodel

import android.arch.lifecycle.ViewModel
import de.acando.vinyl.structure.ViewModelSubComponent
import android.arch.lifecycle.ViewModelProvider
import android.util.ArrayMap
import de.acando.vinyl.ui.detail.DetailViewModel
import de.acando.vinyl.ui.genre.GenreViewModel
import de.acando.vinyl.ui.overview.OverviewViewModel
import de.acando.vinyl.ui.shoppingcart.ShoppingCartViewModel
import java.util.concurrent.Callable

class AppViewModelFactory(viewModelSubComponent: ViewModelSubComponent) : ViewModelProvider.Factory {

    private val creators = ArrayMap<Class<*>, Callable<ViewModel>>()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass]
        try {
            return creator!!.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    init {
        creators.put(OverviewViewModel::class.java, Callable<ViewModel> { viewModelSubComponent.overviewViewModel() })
        creators.put(DetailViewModel::class.java, Callable<ViewModel> { viewModelSubComponent.detailViewModel() })
        creators.put(GenreViewModel::class.java, Callable<ViewModel> { viewModelSubComponent.genreViewModel() })
        creators.put(ShoppingCartViewModel::class.java, Callable<ViewModel> { viewModelSubComponent.shoppingCartViewModel() })
    }
}


