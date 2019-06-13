package com.syntaxer.mysubmission.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
 * Time: 11:14.
 * To change this template use File | Settings | File and Code Templates.
 */
public class ListFoodAdapter extends RecyclerView.Adapter<ListFoodAdapter.ListViewHolder>  {
    private Context context;
    private ArrayList<Food> list;

    public ListFoodAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_food, parent, false);
        return new ListViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.tvName.setText(getList().get(position).getName());
        holder.tvDesc.setText(getList().get(position).getDesc());
        Glide.with(context)
                .load(getList().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
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

    public class ListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.food_name) TextView tvName;
        @BindView(R.id.food_desc) TextView tvDesc;
        @BindView(R.id.food_photo) ImageView photo;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
