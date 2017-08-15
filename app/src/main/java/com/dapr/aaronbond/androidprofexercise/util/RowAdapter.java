package com.dapr.aaronbond.androidprofexercise.util;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.dapr.aaronbond.androidprofexercise.R;
import com.dapr.aaronbond.androidprofexercise.model.Row;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Objects;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.ViewHolder> {

  private List<Row> values;
  private RowClickCallBack callBack;
  private Context context;

  public RowAdapter(RowClickCallBack callBack, Context context) {
    this.callBack = callBack;
    this.context = context;
  }

  public void setRowList(final List<Row> rows) {
    if (values == null) {
      values = rows;
      notifyItemRangeInserted(0, rows.size());
    } else {

      DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
        @Override
        public int getOldListSize() {
          return values.size();
        }

        @Override
        public int getNewListSize() {
          return rows.size();
        }

        //todo add unique ids
        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
          return values.get(oldItemPosition).getTitle() ==
              rows.get(newItemPosition).getTitle();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
          Row row = values.get(newItemPosition);
          Row old = values.get(oldItemPosition);
          return row.getTitle() == old.getTitle()
              && Objects.equals(row.getDescription(), old.getDescription())
              && Objects.equals(row.getDescription(), old.getDescription())
              && row.getImageHref() == old.getImageHref();
        }
      });
      values = rows;
      result.dispatchUpdatesTo(this);
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
    holder.itemNumber = values.get(position);
    holder.titleText.setText(values.get(position).getTitle());
    holder.contentText.setText(values.get(position).getDescription());

    final String imageUrl = values.get(position).getImageHref();

//    if (null != imageUrl && !imageUrl.isEmpty()) {
//      Picasso.with(context).load(imageUrl).into(holder.imageView);
//    }

    final ImageView imageView = holder.imageView;
    ViewTreeObserver observer = imageView.getViewTreeObserver();

    //ensure that imageurl is not null or empty
    if (null != imageUrl && !imageUrl.isEmpty() ) {
      observer.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
        @Override
        public boolean onPreDraw() {
          Picasso.with(context).load(imageUrl).fit().centerCrop().into(imageView);
          return true;
        }
      });
    }

    holder.view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (null != callBack) {
          callBack.onClick(values.get(holder.getAdapterPosition()));
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    if (null == values) {
      return 0;
    }
    return values.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    public final View view;
    public final TextView titleText;
    public final TextView contentText;
    public final ImageView imageView;

    public Row itemNumber;

    public ViewHolder(View view) {
      super(view);
      this.view = view;
      titleText = (TextView) view.findViewById(R.id.title);
      contentText = (TextView) view.findViewById(R.id.content);
      imageView = (ImageView) view.findViewById(R.id.image);
    }

    @Override
    public String toString() {
      return super.toString() + " '" + contentText.getText() + "'";
    }
  }

  public interface RowClickCallBack {
    void onClick(Row row);
  }
}
