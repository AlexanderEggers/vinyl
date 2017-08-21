package de.acando.vinyl.ui.common

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import de.acando.vinyl.MainActivity
import de.acando.vinyl.R
import de.acando.vinyl.ui.detail.DetailFragment
import de.acando.vinyl.ui.overview.OverviewFragment
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FragmentController @Inject constructor() {

    private val OVERVIEW_FRAGMENT = "OverviewFragment"
    private val DETAIL_FRAGMENT = "DetailFragment"
    private val SHOPPING_CART_FRAGMENT = "ShoppingCartFragment"
    private val GENRE_FRAGMENT = "GenreFragment"

    private val containerId: Int = R.id.content_area
    private var fragmentManager: FragmentManager? = null
    private var activity: MainActivity? = null

    fun initController(activity: MainActivity) {
        this.activity = activity
        this.fragmentManager = activity.supportFragmentManager
    }

    fun navigateToOverview() {
        val appStartFragment = OverviewFragment()
        showFragment(appStartFragment, OVERVIEW_FRAGMENT, true)
    }

    fun navigateToDetail(id : Int) {
        val appStartFragment = DetailFragment().forItem(id)
        showFragment(appStartFragment, DETAIL_FRAGMENT, true)
    }

    fun navigateToGenre(id : Int) {
        val appStartFragment = DetailFragment().forItem(id)
        showFragment(appStartFragment, GENRE_FRAGMENT, true)
    }

    fun navigateToShoppingCart() {
        val appStartFragment = OverviewFragment()
        showFragment(appStartFragment, SHOPPING_CART_FRAGMENT, true)
    }

    fun showFragment(fragment : Fragment, tag : String?, addToBackstack : Boolean) {
        val ft = fragmentManager?.beginTransaction()

        if (addToBackstack) {
            ft!!.addToBackStack(tag)
        }

        ft!!.replace(containerId, fragment, tag)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.commit()
    }
}