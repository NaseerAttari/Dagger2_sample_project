package com.ethnostech.testdaggermvpexample.screens;

import com.ethnostech.testdaggermvpexample.di.scope.ViewScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    public MainActivity mainActivity()
    {
        return mainActivity;
    }
}
