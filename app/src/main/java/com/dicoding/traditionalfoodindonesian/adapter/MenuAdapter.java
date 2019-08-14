package com.dicoding.traditionalfoodindonesian.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.traditionalfoodindonesian.R;
import com.dicoding.traditionalfoodindonesian.model.Food;
import com.dicoding.traditionalfoodindonesian.view.FoodsDetailActivity;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuListViewHolder> {

    private Context context;
    private List<Food> menuList;


    public MenuAdapter(Context context, List<Food> menuList) {
        this.context = context;
        this.menuList = menuList;

    }

    @NonNull
    @Override
    public MenuListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View customView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_listmenu,
                        viewGroup,
                        false);
        return new MenuListViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuListViewHolder viewHolder, int i) {
        final Food food = menuList.get(i);

        if (i == 0){
            viewHolder.cardHeadline.setVisibility(View.VISIBLE);
            viewHolder.cardNews.setVisibility(View.GONE);

            Glide.with(context)
                    .load(food.getPhotoFood())
                    .apply(RequestOptions.fitCenterTransform().fitCenter())
                    .into(viewHolder.imgHeadline);

            viewHolder.txtHeadlineTitle.setText(food.getNameFood());
            viewHolder.txtHeadlineAuthor.setText("Sumber : " +food.getAuthor());
            viewHolder.layoutHeadline.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, FoodsDetailActivity.class);
                    i.putExtra("id", food.getId());
                    i.putExtra("photo", food.getPhotoFood());
                    i.putExtra("namaMakanan", food.getNameFood());
                    i.putExtra("bahanMakanan", food.getBahanMakanan());
                    i.putExtra("bumbuMakanan", food.getBumbuMakanan());
                    i.putExtra("pelengkapMakanan", food.getPelengkap());
                    i.putExtra("details", food.getDetail());
                    context.startActivity(i);
                }
            });
        } else {
            viewHolder.cardHeadline.setVisibility(View.GONE);
            viewHolder.cardNews.setVisibility(View.VISIBLE);

            Glide.with(context)
                    .load(food.getPhotoFood())
                    .apply(RequestOptions.fitCenterTransform().fitCenter())
                    .into(viewHolder.imgNews);

            viewHolder.txtNewsTitle.setText(food.getNameFood());
            viewHolder.txtNewsAuthor.setText("Sumber : " +food.getAuthor());
            viewHolder.layoutNews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, FoodsDetailActivity.class);
                    i.putExtra("id", food.getId());
                    i.putExtra("photo", food.getPhotoFood());
                    i.putExtra("namaMakanan", food.getNameFood());
                    i.putExtra("bahanMakanan", food.getBahanMakanan());
                    i.putExtra("bumbuMakanan", food.getBumbuMakanan());
                    i.putExtra("pelengkapMakanan", food.getPelengkap());
                    i.putExtra("details", food.getDetail());
                    context.startActivity(i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public static class MenuListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHeadline;
        TextView txtHeadlineTitle;
        TextView txtHeadlineAuthor;
        CardView cardHeadline;
        RelativeLayout layoutHeadline;

        ImageView imgNews;
        TextView txtNewsTitle;
        TextView txtNewsAuthor;
        CardView cardNews;
        RelativeLayout layoutNews;

        public MenuListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHeadline = itemView.findViewById(R.id.img_headline);
            txtHeadlineTitle = itemView.findViewById(R.id.txt_headline_title);
            txtHeadlineAuthor = itemView.findViewById(R.id.txt_headline_author);
            cardHeadline = itemView.findViewById(R.id.card_headline);
            layoutHeadline = itemView.findViewById(R.id.layout_headline);

            imgNews = itemView.findViewById(R.id.img_news);
            txtNewsTitle = itemView.findViewById(R.id.txt_news_title);
            txtNewsAuthor = itemView.findViewById(R.id.txt_news_author);
            cardNews = itemView.findViewById(R.id.card_news);
            layoutNews = itemView.findViewById(R.id.layout_news);
        }
    }
}
