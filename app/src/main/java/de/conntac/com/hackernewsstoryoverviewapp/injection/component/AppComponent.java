package de.conntac.com.hackernewsstoryoverviewapp.injection.component;

import android.app.Application;
import android.content.Context;


import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import de.conntac.com.hackernewsstoryoverviewapp.application.HackerNewsApplication;
import de.conntac.com.hackernewsstoryoverviewapp.injection.context.AppContext;
import de.conntac.com.hackernewsstoryoverviewapp.injection.module.AppModule;
import de.conntac.com.hackernewsstoryoverviewapp.injection.module.NetworkModule;
import de.conntac.com.hackernewsstoryoverviewapp.network.NetworkManager;

@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class
})
public interface AppComponent {

    void inject(HackerNewsApplication app);

    @AppContext
    Context context();

    Application application();

    NetworkManager networkManager();

    Gson gson();

}
