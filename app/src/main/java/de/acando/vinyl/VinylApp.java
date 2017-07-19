package de.acando.vinyl;

import android.app.Application;

import de.acando.vinyl.structure.AppComponent;
import de.acando.vinyl.structure.AppInjector;
import de.acando.vinyl.structure.DaggerAppComponent;

public class VinylApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        AppInjector.Companion.init(this);
    }

    private void initAppComponent(MainActivity activity) {
        appComponent = DaggerAppComponent.builder().application(this).activity(activity).build();
    }

    public AppComponent getAppComponent(MainActivity activity) {
        if(appComponent == null) {
            initAppComponent(activity);
        }
        return appComponent;
    }
}
