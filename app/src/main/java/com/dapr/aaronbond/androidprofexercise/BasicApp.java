package com.dapr.aaronbond.androidprofexercise;


import android.app.Application;

import com.dapr.aaronbond.androidprofexercise.di.BasicAppComponent;
import com.dapr.aaronbond.androidprofexercise.di.ContextModule;
import com.dapr.aaronbond.androidprofexercise.di.DaggerBasicAppComponent;

public class BasicApp extends Application {

  private BasicAppComponent component;

  @Override
  public void onCreate() {
    super.onCreate();

//    BasicAppComponent appComponent =
//        DaggerBasicAppComponent.builder()
//        .contextModule(new ContextModule(this))
//        .build();

    component = DaggerBasicAppComponent.builder().contextModule(new ContextModule(this)).build();
  }

  public BasicAppComponent getBasicAppComponent() {
    return component;
  }
}
