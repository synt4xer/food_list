package com.syntaxer.mysubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
    public static final String photo = "extra_photo";
    public static final String name = "extra_name";
    public static final String desc = "extra_desc";
    public static final String remarks = "extra_remarks";
    public static final String sourceName = "extra_source";
    @BindView(R.id.food_name) TextView tvName;
    @BindView(R.id.food_desc) TextView tvDesc;
    @BindView(R.id.food_remarks) TextView tvRemarks;
    @BindView(R.id.food_sourceName) TextView tvSourceName;
    @BindView(R.id.food_photo) ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //showing back button
        getSupportActionBar().setTitle(getIntent().getStringExtra(name));

        Glide.with(this)
                .load(getIntent().getStringExtra(photo))
                .apply(new RequestOptions().override(150, 150))
                .into(imgPhoto);

        tvName.setText(getIntent().getStringExtra(name));
        tvDesc.setText(getIntent().getStringExtra(desc));
        tvRemarks.setText(getIntent().getStringExtra(remarks));
        tvSourceName.setText(getIntent().getStringExtra(sourceName));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
