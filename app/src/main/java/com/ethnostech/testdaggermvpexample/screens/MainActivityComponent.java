package com.ethnostech.testdaggermvpexample.screens;

import com.ethnostech.testdaggermvpexample.di.scope.ViewScope;

import javax.inject.Scope;

import dagger.Subcomponent;
@ViewScope
@Subcomponent (modules = MainActivityModule.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);
}
