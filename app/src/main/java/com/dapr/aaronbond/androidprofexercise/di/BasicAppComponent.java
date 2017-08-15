package com.dapr.aaronbond.androidprofexercise.di;


import com.dapr.aaronbond.androidprofexercise.BasicApp;
import com.dapr.aaronbond.androidprofexercise.RowFragment;
import com.dapr.aaronbond.androidprofexercise.service.WebService;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ServiceModule.class, NetworkModule.class, ContextModule.class, ViewModelModule.class, RepositoryModule.class})
@Singleton
public interface BasicAppComponent {

  Picasso getPicasso();

  WebService getWebService();

  void inject(BasicApp app);

  void inject(RowFragment fragment);
}
