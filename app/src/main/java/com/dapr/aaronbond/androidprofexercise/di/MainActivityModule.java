package com.dapr.aaronbond.androidprofexercise.di;


import com.dapr.aaronbond.androidprofexercise.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {

  private MainActivity mainActivity;

  public MainActivityModule(MainActivity mainActivity){

    this.mainActivity = mainActivity;
  }

  @Provides
  MainActivity provideMainActivity(){
    return mainActivity;
  }
}
