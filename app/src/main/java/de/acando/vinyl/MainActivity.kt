package de.acando.vinyl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.acando.vinyl.ui.common.FragmentController
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentController: FragmentController

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            super.onCreate(Bundle())
        } else {
            super.onCreate(savedInstanceState)
        }
        setContentView(R.layout.activity_main)

        fragmentController.initController(this)
        fragmentController.navigateToOverview()

        //val resourceId = resources.getIdentifier("basket", "drawable", packageName)
    }
}
