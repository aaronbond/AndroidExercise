package com.dapr.aaronbond.androidprofexercise.service;

import com.dapr.aaronbond.androidprofexercise.model.Rows;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WebService {

  @GET("m47pd")
  Call<Rows> getRows();
}
