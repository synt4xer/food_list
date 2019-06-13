package com.syntaxer.mysubmission.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syntaxer.mysubmission.R;
import com.syntaxer.mysubmission.domain.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 14:31.
 * To change this template use File | Settings | File and Code Templates.
 */
public class GridFoodAdapter extends RecyclerView.Adapter<GridFoodAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Food> list;

    public GridFoodAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_food, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getList().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return getList().size();
    }

    public ArrayList<Food> getList() {
        return list;
    }

    public void setList(ArrayList<Food> list) {
        this.list = list;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.food_photo) ImageView photo;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
