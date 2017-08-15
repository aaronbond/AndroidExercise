package com.dapr.aaronbond.androidprofexercise.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dapr.aaronbond.androidprofexercise.R;
import com.dapr.aaronbond.androidprofexercise.model.Row;

import java.util.List;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder> {

  private List<Row> values;
  private RowClickCallBack callBack;

  public RowAdapter(RowClickCallBack callBack ) {
    this.callBack = callBack;
  }

  public void setRowList(final List<Row> rows) {
    if (values == null) {
      values = rows;
      notifyItemRangeInserted(0, rows.size());
    } else {

    }
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.fragment_row_item, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
//    holder.mItem = mValues.get(position);
//    holder.mIdView.setText(mValues.get(position).id);
//    holder.mContentView.setText(mValues.get(position).content);
//
//    holder.mView.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        if (null != mListener) {
//          // Notify the active callbacks interface (the activity, if the
//          // fragment is attached to one) that an item has been selected.
//          mListener.onListFragmentInteraction(holder.mItem);
//        }
//      }
//    });
  }

  @Override
  public int getItemCount() {
    return values.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mIdView;
    public final TextView mContentView;
    public Row mItem;

    public ViewHolder(View view) {
      super(view);
      mView = view;
      mIdView = (TextView) view.findViewById(R.id.id);
      mContentView = (TextView) view.findViewById(R.id.content);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + mContentView.getText() + "'";
    }
  }

  public interface RowClickCallBack {
    void onClick(Row row);
  }
}
