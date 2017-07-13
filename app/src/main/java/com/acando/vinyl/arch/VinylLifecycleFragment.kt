package com.acando.vinyl.arch

import android.arch.lifecycle.Lifecycle
import android.os.Bundle
import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.support.v4.app.Fragment

abstract class VinylLifecycleFragment : Fragment(), LifecycleRegistryOwner {

    private var lifecycle: LifecycleRegistry = null!!

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycle
    }

    fun VinylLifecycleFragment() {
        lifecycle = LifecycleRegistry(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)
    }

    override fun onStart() {
        super.onStart()
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    override fun onResume() {
        super.onResume()
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
    }

    override fun onPause() {
        super.onPause()
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    }

    override fun onStop() {
        super.onStop()
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    }
}