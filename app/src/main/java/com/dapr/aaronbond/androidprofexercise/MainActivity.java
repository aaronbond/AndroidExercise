package com.dapr.aaronbond.androidprofexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Add product list fragment if this is first creation
    if (savedInstanceState == null) {
      RowFragment fragment = new RowFragment();

      getSupportFragmentManager().beginTransaction()
          .add(R.id.fragment_container, fragment, RowFragment.TAG).commit();
    }
  }
}
