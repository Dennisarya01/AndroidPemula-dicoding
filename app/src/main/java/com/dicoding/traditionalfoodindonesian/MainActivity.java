package com.dicoding.traditionalfoodindonesian;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dicoding.traditionalfoodindonesian.adapter.MenuAdapter;
import com.dicoding.traditionalfoodindonesian.data.FoodData;
import com.dicoding.traditionalfoodindonesian.model.Food;
import com.dicoding.traditionalfoodindonesian.view.PersonalActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Context context = this;
    private RecyclerView rvMenuList;
    private ArrayList<Food> listFood = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView mTitle = toolbar.findViewById(R.id.toolbar_title);

        mTitle.setText("Resep Nusantara");
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setElevation(0);

        rvMenuList = findViewById(R.id.rvListMenu);
        rvMenuList.setHasFixedSize(true);

        listFood.addAll(FoodData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList(){
        rvMenuList.setLayoutManager(new LinearLayoutManager(this));
        MenuAdapter menuAdapter = new MenuAdapter(context, listFood);
        rvMenuList.setAdapter(menuAdapter);
    }

    public void onClickProfile(View view) {
        Intent intent = new Intent(context, PersonalActivity.class);
        startActivity(intent);
    }

}
