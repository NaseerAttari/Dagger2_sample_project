package com.ethnostech.testdaggermvpexample.di.modules;

import android.content.Context;

import com.ethnostech.testdaggermvpexample.App;
import com.ethnostech.testdaggermvpexample.di.scope.ViewScope;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class PicassoModule {

    @Provides
    public Picasso picasso( OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(App.getAppContext())
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
