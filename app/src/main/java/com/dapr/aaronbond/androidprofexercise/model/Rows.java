package com.dapr.aaronbond.androidprofexercise.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rows {
  @SerializedName("rows")
  @Expose
  private List<Row> rows = null;

  public List<Row> getRows() {
    return rows;
  }

  public void setRows(List<Row> rows) {
    this.rows = rows;
  }
}
