package com.dapr.aaronbond.androidprofexercise;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dapr.aaronbond.androidprofexercise.databinding.FragmentRowListBinding;
import com.dapr.aaronbond.androidprofexercise.model.Row;
import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.util.RowAdapter;
import com.dapr.aaronbond.androidprofexercise.viewmodel.RowFragmentViewModel;

public class RowFragment extends LifecycleFragment {

  public static final String TAG = "RowFragment";

  private FragmentRowListBinding binding;

  private RowAdapter adapter;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_row_list, container, false);

    adapter = new RowAdapter(new RowAdapter.RowClickCallBack() {
      @Override
      public void onClick(Row row) {
        //no op
      }
    });
//    mBinding.productsList.setAdapter(mProductAdapter);

    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    final RowFragmentViewModel viewModel =
        ViewModelProviders.of(this).get(RowFragmentViewModel.class);

    subscribeUi(viewModel);
  }

  private void subscribeUi(RowFragmentViewModel viewModel) {
    // Update the list when the data changes
    viewModel.getRows().observe(this, new Observer<Rows>() {
      @Override
      public void onChanged(@Nullable Rows rows) {
        if (rows != null) {
          binding.setIsLoading(false);
          adapter.setRowList(rows.getRows());
        } else {
          binding.setIsLoading(true);
        }
      }
    });
  }
}
