package de.acando.vinyl

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.acando.vinyl.db.ArticleDao
import de.acando.vinyl.ui.common.FragmentController
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentController: FragmentController

    @Inject
    lateinit var articleDao : ArticleDao

    override fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            super.onCreate(Bundle())
        } else {
            super.onCreate(savedInstanceState)
        }
        setContentView(R.layout.activity_main)

        println("test : " + articleDao)

        fragmentController.initController(this)
        fragmentController.navigateToOverview()

        val resourceId = resources.getIdentifier("basket", "drawable", packageName)
        imageView.setImageResource(resourceId)
    }
}
