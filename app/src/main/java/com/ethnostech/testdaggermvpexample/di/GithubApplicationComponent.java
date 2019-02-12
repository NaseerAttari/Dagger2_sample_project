package com.ethnostech.testdaggermvpexample.di;

import com.ethnostech.testdaggermvpexample.App;
import com.ethnostech.testdaggermvpexample.di.modules.AppModule;
import com.ethnostech.testdaggermvpexample.di.modules.GithubServiceModule;
import com.ethnostech.testdaggermvpexample.di.modules.NetworkModule;
import com.ethnostech.testdaggermvpexample.di.modules.PicassoModule;
import com.ethnostech.testdaggermvpexample.screens.MainActivityComponent;
import com.ethnostech.testdaggermvpexample.screens.MainActivityModule;

import dagger.Component;

@Component(modules = {GithubServiceModule.class, PicassoModule.class, NetworkModule.class, AppModule.class})
public interface GithubApplicationComponent {

    App inject(App app);
    MainActivityComponent plus(MainActivityModule mainActivityModule);

}
