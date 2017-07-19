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

    private val containerId: Int = R.id.content_area
    private var fragmentManager: FragmentManager? = null
    private var activity: MainActivity? = null

    fun initController(activity: MainActivity) {
        this.activity = activity
        this.fragmentManager = activity.supportFragmentManager
    }

    fun navigateToOverview() {
        val appStartFragment = OverviewFragment()
        showFragment(appStartFragment, OVERVIEW_FRAGMENT, OVERVIEW_FRAGMENT)
    }

    fun navigateToDetail(id : Int) {
        val appStartFragment = DetailFragment().forItem(id)
        showFragment(appStartFragment, DETAIL_FRAGMENT, DETAIL_FRAGMENT)
    }

    fun navigateToShoppingCart() {
        val appStartFragment = OverviewFragment()
        showFragment(appStartFragment, SHOPPING_CART_FRAGMENT, SHOPPING_CART_FRAGMENT)
    }

    fun showFragment(fragment : Fragment, tag : String?, backStackTag : String?) {
        val ft = fragmentManager?.beginTransaction()!!

        if (backStackTag != null) {
            ft.addToBackStack(backStackTag)
        }

        ft.replace(containerId, fragment, tag)
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        ft.commit();
    }
}