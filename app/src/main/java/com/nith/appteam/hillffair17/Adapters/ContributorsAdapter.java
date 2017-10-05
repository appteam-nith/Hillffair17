package com.nith.appteam.hillffair17.Adapters;

/**
 * Created by jatin on 26/8/17.
 */
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.nith.appteam.hillffair17.R;
import com.nith.appteam.hillffair17.Models.contributorsItem;

import java.util.ArrayList;


public class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ViewHolder>{
    ArrayList<contributorsItem> contributorsItemArrayList;
    Context context;

    public ContributorsAdapter(ArrayList<contributorsItem> contributorsItemArrayList, Context context)
    {
        this.contributorsItemArrayList= contributorsItemArrayList;
        this.context = context;
    }


    @Override
    public ContributorsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contributor,parent,false);
        ViewHolder view_holder = new ViewHolder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(final ContributorsAdapter.ViewHolder holder, int position) {
        if(!(contributorsItemArrayList.get(position).name.isEmpty())){
            holder.contributorname.setText(contributorsItemArrayList.get(position).name);
        }
        if(!(contributorsItemArrayList.get(position).github_url.isEmpty())){
            final String url=(contributorsItemArrayList.get(position).github_url);
            holder.githublink.setText(url);
            holder.githublink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
            });
        }

        if(!(contributorsItemArrayList.get(position).img_url==null)){
            Glide.with(context).load(contributorsItemArrayList.get(position).img_url).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.news_intro).into(new ImageViewTarget<Bitmap>(holder.image_url) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable= RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                    drawable.setCircular(true);
                    holder.image_url.setImageDrawable(drawable);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return contributorsItemArrayList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public final TextView contributorname;
        public final TextView githublink;
        ImageView image_url;
        public ViewHolder(View v){
            super(v);
            this.image_url = (ImageView)v.findViewById(R.id.imgContributor);
            this.contributorname = (TextView)v.findViewById(R.id.contributorName);
            this.githublink = (TextView)v.findViewById(R.id.profileLink);
        }
    }
}
