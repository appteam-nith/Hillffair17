package com.nith.appteam.hillffair17.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nith.appteam.hillffair17.Activities.PlotActivity;
import com.nith.appteam.hillffair17.Activities.PollActivity;
import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.R;

import java.util.ArrayList;

/**
 * Created by LENOVO on 24-10-2017.
 */

public class PollAdapter extends RecyclerView.Adapter<PollAdapter.PollViewHolder> {

    private ArrayList<PollModel> list;
    private Context context;
    public PollAdapter(ArrayList<PollModel> list, Context context) {
        this.list = list;
        this.context=context;
    }


    @Override
    public PollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_poll,parent,false);
        PollAdapter.PollViewHolder view_holder = new PollAdapter.PollViewHolder(view,list,context);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(PollViewHolder holder, int position) {

        PollModel pollModel = list.get(position);
        if(pollModel!=null){
            String question = pollModel.getQuestion();
            if(!question.isEmpty() && question.length()>0){
                holder.questionView.setText(question);
            }

            if(pollModel.isDone()) holder.checkImageView.setImageResource(R.drawable.about);
            else holder.checkImageView.setImageResource(R.drawable.clubs);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PollViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView checkImageView;
        TextView questionView;
        ArrayList<PollModel>list;
        Context context;
        public PollViewHolder(View itemView, ArrayList<PollModel> list,Context context) {
            super(itemView);
            checkImageView = itemView.findViewById(R.id.checkImage);
            questionView = itemView.findViewById(R.id.questionView);
            this.list=list;
            this.context=context;
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            //get the current poll
            PollModel model=list.get(v.getId());
            String qid=model.getQid();
            Intent intent=new Intent(this.context,PlotActivity.class);
            intent.putExtra("qid",qid);
            context.startActivity(intent);
        }
    }
}