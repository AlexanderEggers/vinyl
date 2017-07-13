package com.acando.vinyl

import android.app.Application
import com.acando.vinyl.structure.AppComponent
import com.acando.vinyl.structure.AppInjector

class VinylApp : Application() {

    private var appComponent : AppComponent = null!!

    override fun onCreate() {
        super.onCreate()
        //appComponent = DaggerAppComponent.builder().application(this).build()
        AppInjector.init(this)
    }

    fun getAppComponent() : AppComponent {
        return appComponent
    }
}