package com.nith.appteam.hillffair17.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nith.appteam.hillffair17.Activities.PlotActivity;
import com.nith.appteam.hillffair17.Activities.PollActivity;
import com.nith.appteam.hillffair17.Models.PollListModel;
import com.nith.appteam.hillffair17.Models.PollModel;
import com.nith.appteam.hillffair17.R;

import java.util.ArrayList;

/**
 * Created by LENOVO on 24-10-2017.
 */

public class PollAdapter extends RecyclerView.Adapter<PollAdapter.PollViewHolder> {

    private ArrayList<PollListModel.Question> list;
    private Context context;
    public PollAdapter(ArrayList<PollListModel.Question> list, Context context) {
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

        PollListModel.Question pollModel = list.get(position);
        if(pollModel!=null){
            String question = pollModel.getQuestion();
            if(!question.isEmpty() && question.length()>0){
                holder.questionView.setText(question);
            }

        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PollViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView questionView;
        ArrayList<PollListModel.Question>list;
        Context context;
        public PollViewHolder(View itemView, ArrayList<PollListModel.Question> list, Context context) {
            super(itemView);
            questionView = itemView.findViewById(R.id.questionView);
            this.list=list;
            this.context=context;
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            //get the current poll
           Log.e("position",""+getAdapterPosition());
            PollListModel.Question model=list.get(getAdapterPosition());
            String qid=model.getId();
            Intent intent=new Intent(this.context,PlotActivity.class);
            intent.putExtra("qid",qid);
            intent.putExtra("question",model.getQuestion());
            context.startActivity(intent);
        }
    }
}