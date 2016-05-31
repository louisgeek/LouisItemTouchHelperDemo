package com.louisgeek.louisitemtouchhelperdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by louisgeek on 2016/5/31.
 */
public class MyRecyclerList_Swipe_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public final static String[] STR_ARRAY = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGTH","NINE","TEN"};
    private final List<String> mItems = new ArrayList<>();

    public MyRecyclerList_Swipe_Adapter() {
        mItems.addAll((Arrays.asList(STR_ARRAY)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyle_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.id_tv_txt.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    class  MyViewHolder extends  RecyclerView.ViewHolder{
       public TextView id_tv_txt;
       public MyViewHolder(View itemView) {
           super(itemView);
           id_tv_txt = (TextView)itemView.findViewById(R.id.id_tv_txt);
       }
    }
}
