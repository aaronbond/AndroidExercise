package com.dapr.aaronbond.androidprofexercise.viewmodel;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.repository.RowsRepository;
import com.dapr.aaronbond.androidprofexercise.service.WebService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RowFragmentViewModel extends AndroidViewModel {

  private LiveData<Rows> rowsLiveData;
  private RowsRepository rowRepo;

  public RowFragmentViewModel(Application application) {
    super(application);
    init();
  }

  //todo dagger injection
  public void init() {
    rowRepo = new RowsRepository(new Retrofit.Builder()
        .baseUrl("http://api.myjson.com/bins/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WebService.class));

    rowsLiveData = rowRepo.getRows();
  }

  public LiveData<Rows> getRows() {
    return rowsLiveData;
  }
}
