package com.syntaxer.mysubmission.custom;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.syntaxer.mysubmission.R;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 16:17.
 * To change this template use File | Settings | File and Code Templates.
 */
public class CustomItemClicker {
    private final RecyclerView mRecyclerView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mOnItemClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
                mOnItemClickListener.onItemClicked(mRecyclerView, holder.getAdapterPosition(),view);
            }
        }
    };

    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            if (mOnItemLongClickListener != null) {
                RecyclerView.ViewHolder holder = mRecyclerView.getChildViewHolder(view);
                return mOnItemLongClickListener.onItemLongClicked(mRecyclerView, holder.getAdapterPosition(), view);
            }
            return false;
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener mOnChildAttachStateChangeListener = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if (mOnItemClickListener != null) {
                view.setOnClickListener(mOnClickListener);
            }

            if (mOnItemLongClickListener != null) {
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };

    public CustomItemClicker(RecyclerView mRecyclerView) {
        this.mRecyclerView = mRecyclerView;
        mRecyclerView.setTag(R.id.item_click_support, this);
        mRecyclerView.addOnChildAttachStateChangeListener(mOnChildAttachStateChangeListener);
    }

    public static CustomItemClicker bindTo(RecyclerView recyclerView) {
        CustomItemClicker customItemClicker = (CustomItemClicker) recyclerView.getTag(R.id.item_click_support);
        if (customItemClicker == null) {
            customItemClicker = new CustomItemClicker(recyclerView);
        }
        return customItemClicker;
    }

    public static CustomItemClicker unbindTo(RecyclerView recyclerView) {
        CustomItemClicker customItemClicker = (CustomItemClicker) recyclerView.getTag(R.id.item_click_support);
        if (customItemClicker != null) {
            customItemClicker.detach(recyclerView);
        }

        return customItemClicker;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener =  listener;
    }

    private void detach(RecyclerView recyclerView) {
        recyclerView.removeOnChildAttachStateChangeListener(mOnChildAttachStateChangeListener);
        recyclerView.setTag(R.id.item_click_support, null);
    }

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View v);
    }
}
