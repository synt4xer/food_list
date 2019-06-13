package com.syntaxer.mysubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.syntaxer.mysubmission.adapter.CardFoodAdapter;
import com.syntaxer.mysubmission.adapter.GridFoodAdapter;
import com.syntaxer.mysubmission.adapter.ListFoodAdapter;
import com.syntaxer.mysubmission.custom.CustomItemClicker;
import com.syntaxer.mysubmission.domain.Food;
import com.syntaxer.mysubmission.domain.InjectData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_list) RecyclerView rvList;
    private ArrayList<Food> list;
    final String STATE_TITLE = "state_title";
    final String STATE_DATA = "state_data";
    final String STATE_MODE = "state_mode";
    int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvList.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState != null) {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Food> stateList = savedInstanceState.getParcelableArrayList(STATE_DATA);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            this.setActionBarTitle(stateTitle);
            list.addAll(stateList);
            this.setMode(stateMode);
        } else {
            this.setActionBarTitle("Mode List");
            list.addAll(InjectData.getData());
            showModeList();
            mode = R.id.menu_list;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_DATA, list);
        outState.putInt(STATE_MODE, mode);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        this.setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;

        switch (selectedMode) {
            case R.id.menu_list:
                title = "Mode List";
                showModeList();
                break;

            case R.id.menu_grid:
                title = "Mode Grid";
                showModeGrid();
                break;

            case R.id.menu_card:
                title = "Mode CardView";
                showModeCard();
                break;
        }
        mode = selectedMode;
        this.setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    private void showModeList() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
        ListFoodAdapter listFoodAdapter = new ListFoodAdapter(this);
        listFoodAdapter.setList(list);
        rvList.setAdapter(listFoodAdapter);
        customIntentClicker();
    }

    private void showModeGrid() {
        rvList.setLayoutManager(new GridLayoutManager(this, 2));
        GridFoodAdapter gridFoodAdapter = new GridFoodAdapter(this);
        gridFoodAdapter.setList(list);
        rvList.setAdapter(gridFoodAdapter);
        customIntentClicker();
    }

    private void showModeCard() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
        CardFoodAdapter cardFoodAdapter = new CardFoodAdapter(this);
        cardFoodAdapter.setList(list);
        rvList.setAdapter(cardFoodAdapter);
        customIntentClicker();
    }

    private void customIntentClicker() {
        CustomItemClicker.bindTo(rvList).setOnItemClickListener((recyclerView, position, v) -> {
            Intent moveDataIntent = new Intent(this, DetailActivity.class);
            moveDataIntent.putExtra(DetailActivity.name, list.get(position).getName());
            moveDataIntent.putExtra(DetailActivity.desc, list.get(position).getDesc());
            moveDataIntent.putExtra(DetailActivity.photo, list.get(position).getPhoto());
            moveDataIntent.putExtra(DetailActivity.remarks, list.get(position).getRemarks());
            moveDataIntent.putExtra(DetailActivity.sourceName, list.get(position).getSourceName());
            startActivity(moveDataIntent);
        });
    }
}
