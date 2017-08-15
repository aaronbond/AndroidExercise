package com.dapr.aaronbond.androidprofexercise.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.repository.RowsRepository;

import javax.inject.Inject;

public class RowFragmentViewModel extends ViewModel {

  private LiveData<Rows> rowsLiveData;

  private RowsRepository rowRepo;

  @Inject
  public RowFragmentViewModel(RowsRepository rowRepo) {
    this.rowRepo = rowRepo;
    init();
  }

  //todo dagger injection
  public void init() {
//    rowRepo = new RowsRepository(new Retrofit.Builder()
//        .baseUrl("http://api.myjson.com/bins/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(WebService.class));

    rowsLiveData = rowRepo.getRows();
  }

  public void refreshItems() {
    rowRepo.refreshRows();
  }

  public LiveData<Rows> getRows() {
    return rowsLiveData;
  }
}
