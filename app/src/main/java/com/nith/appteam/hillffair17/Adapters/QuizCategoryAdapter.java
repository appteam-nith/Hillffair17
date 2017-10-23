package com.nith.appteam.hillffair17.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.nith.appteam.hillffair17.Activities.QuizSubCategoryActivity;
import com.nith.appteam.hillffair17.Models.CategoryQuizSingleModel;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Utils.RecyclerItemClickListener;

import java.util.ArrayList;

/**
 * Created by jatin on 13/10/17.
 */

public class QuizCategoryAdapter extends RecyclerView.Adapter<QuizCategoryAdapter.CategoryQuizViewHolder> {

    ArrayList<CategoryQuizSingleModel> categories;
    Context context;

    public QuizCategoryAdapter(ArrayList<CategoryQuizSingleModel> categories,Context context)
    {
        this.categories = categories;
        this.context = context;
    }

    @Override
    public CategoryQuizViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_categoryquiz,parent,false);
        CategoryQuizViewHolder categoryQuizViewHolder = new CategoryQuizViewHolder(view,context);
        return categoryQuizViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryQuizViewHolder holder, final int position)
    {
        final CategoryQuizSingleModel categoryQuizSingleModel = categories.get(position);
        holder.categoryname.setText(categoryQuizSingleModel.getName().toString());
        Glide.with(context).load(categoryQuizSingleModel.getPhoto()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.treasure_intro).into(holder.categoryphoto);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(context,QuizSubCategoryActivity.class);
                i1.putExtra("Category_Name",categoryQuizSingleModel.getName());
                context.startActivity(i1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return categories.size();
    }


    public class CategoryQuizViewHolder  extends RecyclerView.ViewHolder
    {
        TextView categoryname;
        ImageView categoryphoto;
        Context context;
        CardView cardView;
        public CategoryQuizViewHolder(View view, Context context)
        {
            super(view);
           // view.setOnClickListener(this);
            categoryname = (TextView) view.findViewById(R.id.name_subcategory);
            categoryphoto = (ImageView) view.findViewById(R.id.img_subcategory);
            cardView = (CardView) view.findViewById(R.id.quiz_category_cardview);
            this.context = context;
        }


    }
}
