package de.acando.vinyl

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.acando.vinyl.db.ArticleDao
import de.acando.vinyl.ui.common.FragmentController
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentController: FragmentController

    @Inject
    lateinit var articleDao : ArticleDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("test : " + articleDao)

        fragmentController.initController(this)
        fragmentController.navigateToOverview()

        val resourceId = resources.getIdentifier("basket.png", "drawable", packageName)
        val image = resources.getDrawable(resourceId)
        println("image test: " + image)
    }
}
