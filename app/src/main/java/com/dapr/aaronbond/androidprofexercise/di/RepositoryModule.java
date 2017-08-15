package com.dapr.aaronbond.androidprofexercise.di;

import com.dapr.aaronbond.androidprofexercise.repository.RowsRepository;
import com.dapr.aaronbond.androidprofexercise.service.WebService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

  @Provides
  @Singleton
  public RowsRepository providesRowRepo(WebService webService) {
    return new RowsRepository(webService);
  }
}
