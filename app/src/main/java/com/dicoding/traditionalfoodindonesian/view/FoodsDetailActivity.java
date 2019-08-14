package com.dicoding.traditionalfoodindonesian.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.traditionalfoodindonesian.R;
import com.dicoding.traditionalfoodindonesian.adapter.MenuAdapter;
import com.dicoding.traditionalfoodindonesian.data.FoodData;
import com.dicoding.traditionalfoodindonesian.model.Food;

import java.util.ArrayList;

public class FoodsDetailActivity extends AppCompatActivity {
    private Context context = this;
    private RecyclerView rvMenuList;
    private ArrayList<Food> listFood = new ArrayList<>();

    String idFoods, mPhoto, mBahan, mBumbu, mPelengkap, mDetails, mNama;
    TextView txtBahan, txtBumbu, txtPelengkap, txtDetails, txtNamaMakanan;
    TextView txtSeparator, txtSeparator2, txtSeparator3, txtSeparator6;
    TextView labelBahan, labelBumbu, labelPelengkap, labelDetailsMakanan;
    ImageView imgDetailsMakanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_detail);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setElevation(0);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgDetailsMakanan = findViewById(R.id.img_details_makanan);
        txtNamaMakanan = findViewById(R.id.txtNamaMakanan);
        txtBahan = findViewById(R.id.txtBahanMakanan);
        txtBumbu = findViewById(R.id.txtBumbu);
        txtPelengkap = findViewById(R.id.txtPelengkap);
        txtDetails = findViewById(R.id.txt_details_makanan);

        labelBahan = findViewById(R.id.label_bahanMakanan);
        labelBumbu = findViewById(R.id.label_bumbu);
        labelPelengkap = findViewById(R.id.label_pelengkap);
        labelDetailsMakanan = findViewById(R.id.label_details);

        txtSeparator = findViewById(R.id.txt_separator);
        txtSeparator2 = findViewById(R.id.txt_separator_2);
        txtSeparator3 = findViewById(R.id.txt_separator_3);
        txtSeparator6 = findViewById(R.id.txt_separator_6);

        Intent intent = getIntent();
        idFoods = intent.getStringExtra("id");
        mPhoto = intent.getStringExtra("photo");
        mNama = intent.getStringExtra("namaMakanan");
        mBahan = intent.getStringExtra("bahanMakanan");
        mBumbu = intent.getStringExtra("bumbuMakanan");
        mPelengkap = intent.getStringExtra("pelengkapMakanan");
        mDetails = intent.getStringExtra("details");

        if (idFoods.equals("NULL")){
            imgDetailsMakanan.setVisibility(View.GONE);
            txtSeparator6.setVisibility(View.GONE);
        } else {
            imgDetailsMakanan.setVisibility(View.VISIBLE);
            Glide.with(context)
                    .load(mPhoto)
                    .apply(RequestOptions.fitCenterTransform().fitCenter())
                    .into(imgDetailsMakanan);
        }

        if (mNama.length() > 0){
            txtNamaMakanan.setVisibility(View.VISIBLE);
            txtNamaMakanan.setText(mNama);
        } else {
            txtNamaMakanan.setVisibility(View.GONE);
        }

        if (mBahan.equals("NULL")) {
            labelBahan.setVisibility(View.GONE);
            txtBahan.setVisibility(View.GONE);
            txtSeparator.setVisibility(View.GONE);
        } else {
            labelBahan.setVisibility(View.VISIBLE);
            txtBahan.setVisibility(View.VISIBLE);
            txtSeparator.setVisibility(View.VISIBLE);
            txtBahan.setText(mBahan);
        }

        if (mBumbu.equals("NULL")) {
            labelBumbu.setVisibility(View.GONE);
            txtBumbu.setVisibility(View.GONE);
            txtSeparator2.setVisibility(View.GONE);
        } else {
            labelBumbu.setVisibility(View.VISIBLE);
            txtBumbu.setVisibility(View.VISIBLE);
            txtSeparator2.setVisibility(View.VISIBLE);
            txtBumbu.setText(mBumbu);
        }

        if (mPelengkap.equals("NULL")) {
            labelPelengkap.setVisibility(View.GONE);
            txtPelengkap.setVisibility(View.GONE);
            txtSeparator3.setVisibility(View.GONE);
        } else {
            labelPelengkap.setVisibility(View.VISIBLE);
            txtPelengkap.setVisibility(View.VISIBLE);
            txtSeparator3.setVisibility(View.VISIBLE);
            txtPelengkap.setText(mPelengkap);
        }

        if (mDetails.equals("NULL")) {
            labelDetailsMakanan.setVisibility(View.GONE);
            txtDetails.setVisibility(View.GONE);
        } else {
            labelDetailsMakanan.setVisibility(View.VISIBLE);
            txtDetails.setVisibility(View.VISIBLE);
            txtDetails.setText(mDetails);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
