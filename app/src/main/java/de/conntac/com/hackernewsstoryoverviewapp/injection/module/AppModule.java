package de.conntac.com.hackernewsstoryoverviewapp.injection.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import de.conntac.com.hackernewsstoryoverviewapp.injection.context.AppContext;

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @AppContext
    Context providesApplicationContext() {
        return application;
    }

}
