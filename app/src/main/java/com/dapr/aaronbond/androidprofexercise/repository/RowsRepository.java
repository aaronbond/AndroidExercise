package com.dapr.aaronbond.androidprofexercise.repository;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.service.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RowsRepository {

  private WebService webService;

  public RowsRepository(WebService webService) {
    this.webService = webService;
  }

  public LiveData<Rows> getRows() {
    final MutableLiveData<Rows> data = new MutableLiveData<>();

    webService.getRows().enqueue(new Callback<Rows>() {
      @Override
      public void onResponse(Call<Rows> call, Response<Rows> response) {
        data.setValue(response.body());
      }

      @Override
      public void onFailure(Call<Rows> call, Throwable t) {
        //this is where you would handle the error case
      }
    });
    return data;
  }

}
