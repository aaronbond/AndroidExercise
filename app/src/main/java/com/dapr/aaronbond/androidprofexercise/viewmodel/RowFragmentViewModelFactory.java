package com.dapr.aaronbond.androidprofexercise.viewmodel;


import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RowFragmentViewModelFactory implements ViewModelProvider.Factory {

  private RowFragmentViewModel viewModel;

  @Inject
  public RowFragmentViewModelFactory(RowFragmentViewModel viewModel) {
    this.viewModel = viewModel;
  }

  @Override
  public <T extends ViewModel> T create(Class<T> modelClass) {
    if (modelClass.isAssignableFrom(RowFragmentViewModel.class)) {
      return (T) viewModel;
    }
    throw new IllegalArgumentException("Unknown class name");
  }
}
