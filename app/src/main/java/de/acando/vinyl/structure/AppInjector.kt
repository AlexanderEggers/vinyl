package de.acando.vinyl.structure

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import de.acando.vinyl.MainActivity
import de.acando.vinyl.VinylApp
import de.acando.vinyl.ui.detail.DetailFragment
import de.acando.vinyl.ui.genre.GenreFragment
import de.acando.vinyl.ui.overview.OverviewFragment
import de.acando.vinyl.ui.shoppingcart.ShoppingCartFragment

class AppInjector {

    companion object {
        fun init(app: VinylApp) {
            app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {
                    if (activity is MainActivity) {
                        handleMainActivity(activity)
                    }
                }

                override fun onActivityStarted(activity: Activity) {

                }

                override fun onActivityResumed(activity: Activity) {

                }

                override fun onActivityPaused(activity: Activity) {

                }

                override fun onActivityStopped(activity: Activity) {

                }

                override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

                }

                override fun onActivityDestroyed(activity: Activity) {

                }
            })
        }

        private fun handleMainActivity(activity: MainActivity) {
            val appComponent = (activity.application as VinylApp).getAppComponent(activity)
            appComponent.inject(activity)

            activity.supportFragmentManager.registerFragmentLifecycleCallbacks(
                    object : FragmentManager.FragmentLifecycleCallbacks() {
                        override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, bundle: Bundle?) {
                            if (f is OverviewFragment) {
                                appComponent.inject(f)
                            } else if (f is DetailFragment) {
                                appComponent.inject(f)
                            } else if (f is GenreFragment) {
                                appComponent.inject(f)
                            } else if (f is ShoppingCartFragment) {
                                appComponent.inject(f)
                            }
                        }
                    }, true)
        }
    }
}