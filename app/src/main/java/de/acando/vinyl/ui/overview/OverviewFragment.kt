package de.acando.vinyl.ui.overview

import android.arch.lifecycle.ViewModelProvider
import android.support.v4.app.Fragment
import javax.inject.Inject

class OverviewFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var viewModel: OverviewViewModel? = null
}