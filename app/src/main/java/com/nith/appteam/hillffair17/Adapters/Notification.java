package com.nith.appteam.hillffair17.Adapters        ;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.nith.appteam.hillffair17.Notification.Notification2;
import com.nith.appteam.hillffair17.Notification.notification_model;
import com.nith.appteam.hillffair17.R;

import java.util.List;


/**
 * Created by root on 19/10/16.
 */


public class Notification extends RecyclerView.Adapter<Notification.viewHolder> {

    private List<notification_model> arrayList;
    private Context context;

    public Notification(List<notification_model> arrayList, Context context) {
        this.arrayList=arrayList;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_model_card,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(final viewHolder holder, int position) {

        final notification_model home_post = arrayList.get(position);

        holder.title.setText(home_post.getTitle().getTitle());
        holder.notification_id.setText(home_post.getNotification_id());
        String ab="android.R.drawable."+home_post.getSmall_icon();
        Log.v("ab:",""+home_post.getTitle()+"small_icon"+position);
        final Context context=holder.title.getContext();
        if (home_post.getSmall_icon() == null || home_post.getSmall_icon().isEmpty() || home_post.getSmall_icon().length() == 0) {
            Glide.with(context).load(R.drawable.hillffair_org).into(holder.small_icon);
        } else {
            Glide.with(context).load(R.drawable.hillffair_org).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.hillffair_org).into(new ImageViewTarget<Bitmap>(holder.small_icon) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                    drawable.setCircular(true);
                    holder.small_icon.setImageDrawable(drawable);
                }
            });

        }
        holder.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Notification2.class);
                Bundle assign = new Bundle();
                assign.putString("title",home_post.getTitle().getTitle().toString());
                assign.putString("body",home_post.getBody().getTitle().toString());
                assign.putString("bigpicture",home_post.getImg());
                assign.putString("launchurl",home_post.getLaunchurl());
                i.putExtra("assign",assign);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public  void  refresh(List<notification_model> list){
        this.arrayList=list;
        notifyDataSetChanged();
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        ImageView small_icon;
        TextView title,notification_id;
        LinearLayout lay;
        public viewHolder(View itemView) {
            super(itemView);
            small_icon=(ImageView) itemView.findViewById(R.id.small_icon);

            title=(TextView)itemView.findViewById(R.id.not_title);
            lay=(LinearLayout)itemView.findViewById(R.id.not_click_lay);
            notification_id=(TextView)itemView.findViewById(R.id.not_id);
        }
    }
}