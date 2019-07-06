package de.conntac.com.hackernewsstoryoverviewapp.application;

import android.app.Application;

import de.conntac.com.hackernewsstoryoverviewapp.injection.component.AppComponent;
import de.conntac.com.hackernewsstoryoverviewapp.injection.component.DaggerAppComponent;
import de.conntac.com.hackernewsstoryoverviewapp.injection.module.AppModule;

public class HackerNewsApplication extends Application {

    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initDependencyInjectionLibrary();
    }

    private void initDependencyInjectionLibrary() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }

    public AppComponent getApplicationComponent() {
        return appComponent;
    }

}
