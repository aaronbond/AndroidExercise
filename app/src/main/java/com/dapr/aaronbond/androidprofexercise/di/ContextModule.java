package com.dapr.aaronbond.androidprofexercise.di;


import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

  private final Context context;

  public ContextModule(Context context) {
    this.context = context;
  }

  @Provides
  public Context providesContext() {
    return context;
  }
}
