package com.dapr.aaronbond.androidprofexercise;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dapr.aaronbond.androidprofexercise.databinding.FragmentRowListBinding;
import com.dapr.aaronbond.androidprofexercise.model.Row;
import com.dapr.aaronbond.androidprofexercise.model.Rows;
import com.dapr.aaronbond.androidprofexercise.util.RowAdapter;
import com.dapr.aaronbond.androidprofexercise.viewmodel.RowFragmentViewModel;

import javax.inject.Inject;

public class RowFragment extends LifecycleFragment {

  public static final String TAG = "RowFragment";

  private FragmentRowListBinding binding;

  private RowAdapter adapter;

  private RowFragmentViewModel viewModel;

  private SwipeRefreshLayout swipe;

  @Inject
  ViewModelProvider.Factory viewModelFactory;

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_row_list, container, false);

    adapter = new RowAdapter(new RowAdapter.RowClickCallBack() {
      @Override
      public void onClick(Row row) {
        //no op not specified in document
      }
    }, this.getContext());
    binding.list.setAdapter(adapter);

    return binding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    ((BasicApp)getActivity().getApplication()).getBasicAppComponent().inject(this);

    viewModel =
        ViewModelProviders.of(this, viewModelFactory).get(RowFragmentViewModel.class);

    subscribeUi(viewModel);

    swipe = getView().findViewById(R.id.swipeRefreshLayout);

    swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        //quick and dirty
        viewModel.refreshItems();
      }
    });
  }

  private void subscribeUi(RowFragmentViewModel viewModel) {
    // Update the list when the data changes
    viewModel.getRows().observe(this, new Observer<Rows>() {
      @Override
      public void onChanged(@Nullable Rows rows) {

        if (null != swipe) {
          swipe.setRefreshing(false);
        }
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
