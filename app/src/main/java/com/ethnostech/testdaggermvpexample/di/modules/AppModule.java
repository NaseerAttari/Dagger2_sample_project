package com.ethnostech.testdaggermvpexample.di.modules;

import android.app.Application;
import android.content.Context;

import com.ethnostech.testdaggermvpexample.App;
import com.ethnostech.testdaggermvpexample.di.scope.ViewScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application app;

    public AppModule(Application app) {
        this.app = app;
    }

    @Provides
    public Application getApplication() {
        return app;
    }

    @Provides
    public Context context() {
        return app.getApplicationContext();
    }
}
