package com.ethnostech.testdaggermvpexample;

import android.app.Application;
import android.content.Context;


import com.ethnostech.testdaggermvpexample.di.DaggerGithubApplicationComponent;
import com.ethnostech.testdaggermvpexample.di.modules.AppModule;
import com.ethnostech.testdaggermvpexample.di.GithubApplicationComponent;

import timber.log.Timber;

public class App extends Application {
    private static GithubApplicationComponent component;
    private static Context appContext;

    public static Context getAppContext() {
        return appContext;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        component = DaggerGithubApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appContext=this;

        component.inject(this);
    }

    public static GithubApplicationComponent getAppComponent() {
        return component;
    }
}
