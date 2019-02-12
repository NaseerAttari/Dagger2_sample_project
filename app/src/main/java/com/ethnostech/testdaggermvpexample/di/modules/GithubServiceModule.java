package com.ethnostech.testdaggermvpexample.di.modules;

import com.ethnostech.testdaggermvpexample.DateTimeConverter;
import com.ethnostech.testdaggermvpexample.GithubService;
import com.ethnostech.testdaggermvpexample.di.scope.ViewScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import org.joda.time.DateTime;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GithubServiceModule {

    @Provides
    public GithubService githubService(Retrofit gitHubRetrofit) {
        return gitHubRetrofit.create(GithubService.class);
    }

    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }

}
