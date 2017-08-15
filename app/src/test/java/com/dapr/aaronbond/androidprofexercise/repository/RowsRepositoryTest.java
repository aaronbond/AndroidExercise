package com.dapr.aaronbond.androidprofexercise.repository;


import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.service.WebService;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import retrofit2.Call;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


//quick and incomplete unit test
public class RowsRepositoryTest {

  private RowsRepository rowsRepository;

  @Mock
  private WebService webService;

  @Mock
  private Call<Rows> callRows;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
    rowsRepository = new RowsRepository(webService);

    when(webService.getRows()).thenReturn(callRows);
  }

  @Test
  public void getRowsShouldMakeCallToWebService() {
    rowsRepository.getRows();
    verify(webService).getRows();
  }

  @Test
  public void refreshRowsShouldMakeCallToWebService() {
    rowsRepository.refreshRows();
    verify(webService).getRows();
  }
}