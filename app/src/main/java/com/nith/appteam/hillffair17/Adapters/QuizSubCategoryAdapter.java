package com.nith.appteam.hillffair17.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nith.appteam.hillffair17.Activities.HomeActivity;
import com.nith.appteam.hillffair17.Models.SubCategoryQuizSingleModel;
import com.nith.appteam.hillffair17.R;

import java.util.ArrayList;

/**
 * Created by jatin on 15/10/17.
 */

public class QuizSubCategoryAdapter extends RecyclerView.Adapter<QuizSubCategoryAdapter.SubCategoryViewHolder>{

    ArrayList<SubCategoryQuizSingleModel> subcategories;
    Context context;

    public QuizSubCategoryAdapter(ArrayList<SubCategoryQuizSingleModel> subcategories, Context context) {
        this.subcategories = subcategories;
        this.context = context;
    }

    @Override
    public SubCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_subcategories,parent,false);
        SubCategoryViewHolder subCategoryViewHolder = new SubCategoryViewHolder(view,context);

        return subCategoryViewHolder;
    }

    @Override
    public void onBindViewHolder(SubCategoryViewHolder holder, final int position) {
        SubCategoryQuizSingleModel subcat = subcategories.get(position);
        holder.categoryname.setText(subcat.getName());
        Glide.with(context).load(subcat.getPhoto()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.treasure_intro).into(holder.categoryphoto);

    }

    @Override
    public int getItemCount() {
        return subcategories.size();
    }


    public class SubCategoryViewHolder extends RecyclerView.ViewHolder{

        TextView categoryname;
        ImageView categoryphoto;
        Context context;
        CardView cardView;
        public SubCategoryViewHolder(View view,Context context) {
            super(view);
            categoryname = (TextView) view.findViewById(R.id.name_subcategory);
            categoryphoto = (ImageView) view.findViewById(R.id.img_subcategory);
            cardView = (CardView) view.findViewById(R.id.quiz_category_cardview);
            this.context = context;
        }


    }
}
