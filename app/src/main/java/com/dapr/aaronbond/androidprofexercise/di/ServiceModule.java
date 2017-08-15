package com.dapr.aaronbond.androidprofexercise.di;

import com.dapr.aaronbond.androidprofexercise.service.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {

  @Provides
  @Singleton
  public WebService provideWebService() {
    return new Retrofit.Builder()
        .baseUrl("http://api.myjson.com/bins/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WebService.class);
  }
}
