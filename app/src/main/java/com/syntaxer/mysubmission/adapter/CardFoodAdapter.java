package com.syntaxer.mysubmission.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.syntaxer.mysubmission.R;
import com.syntaxer.mysubmission.custom.CustomOnItemClickListener;
import com.syntaxer.mysubmission.domain.Food;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: FERREL JOHN FERNANDO
 * Date: 12/06/2019.
 * Time: 15:48.
 * To change this template use File | Settings | File and Code Templates.
 */
public class CardFoodAdapter extends RecyclerView.Adapter<CardFoodAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<Food> list;

    public CardFoodAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_food, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Food food = getList().get(position);

        Glide.with(context)
                .load(food.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);
        holder.tvName.setText(food.getName());
        holder.tvDesc.setText(food.getDesc());
        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, (view, i) -> {
            Toast.makeText(context, "Favorite " + getList().get(i).getName(), Toast.LENGTH_SHORT).show();
        }));
        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, (view, i) -> {
            Toast.makeText(context, "Share " + getList().get(i).getName(), Toast.LENGTH_SHORT).show();
        }));
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

    public class CardViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.food_photo) ImageView photo;
        @BindView(R.id.food_name) TextView tvName;
        @BindView(R.id.food_desc) TextView tvDesc;
        @BindView(R.id.btn_favorite) Button btnFavorite;
        @BindView(R.id.btn_share) Button btnShare;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
