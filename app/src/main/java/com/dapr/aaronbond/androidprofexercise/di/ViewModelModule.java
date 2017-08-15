package com.dapr.aaronbond.androidprofexercise.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.dapr.aaronbond.androidprofexercise.viewmodel.RowFragmentViewModel;
import com.dapr.aaronbond.androidprofexercise.viewmodel.RowFragmentViewModelFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {

  @Provides
  @Singleton
  ViewModel provideRowFragmentViewModel(RowFragmentViewModel viewModel) {
    return viewModel;
  }

  @Provides
  @Singleton
  ViewModelProvider.Factory provideRowFragmentViewModelFactory(
      RowFragmentViewModelFactory factory
  ) {
    return factory;
  }
}
