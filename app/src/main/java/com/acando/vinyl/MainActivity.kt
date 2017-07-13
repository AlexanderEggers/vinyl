package com.acando.vinyl

import android.os.Bundle
import com.acando.vinyl.arch.VinylLifecycleActivity
import com.acando.vinyl.ui.common.FragmentController
import javax.inject.Inject

class MainActivity : VinylLifecycleActivity() {

    @Inject
    lateinit var fragmentController : FragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentController.initController(this)
        fragmentController.navigateToOverview()
    }
}
