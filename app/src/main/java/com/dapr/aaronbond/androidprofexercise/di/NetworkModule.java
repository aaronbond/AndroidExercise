package com.dapr.aaronbond.androidprofexercise.di;


import android.content.Context;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

  @Provides
  @Singleton
  public Picasso providePicasso(Context context) {
    return Picasso.with(context);
  }

  @Provides
  @Singleton
  public Gson providesGson() {
    return new Gson();
  }

}
