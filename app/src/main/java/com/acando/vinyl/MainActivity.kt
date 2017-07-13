package com.acando.vinyl

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import com.acando.vinyl.ui.common.FragmentController
import javax.inject.Inject

class MainActivity : LifecycleActivity() {

    @Inject
    lateinit var fragmentController: FragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentController.initController(this)
        fragmentController.navigateToOverview()


        val resourceId = resources.getIdentifier("basket.png", "drawable", packageName)
        val image = resources.getDrawable(resourceId)
        println("image test: " + image)
    }
}
