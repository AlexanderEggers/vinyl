package com.acando.vinyl.viewmodel

import android.arch.lifecycle.ViewModel
import com.acando.vinyl.structure.ViewModelSubComponent
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProvider
import android.util.ArrayMap
import com.acando.vinyl.ui.detail.DetailViewModel
import com.acando.vinyl.ui.overview.OverviewViewModel
import com.acando.vinyl.ui.shoppingcart.ShoppingCartViewModel
import java.util.concurrent.Callable
import javax.inject.Singleton

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
        creators.put(ShoppingCartViewModel::class.java, Callable<ViewModel> { viewModelSubComponent.shoppingCartViewModel() })
    }
}


