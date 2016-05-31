package com.louisgeek.louisitemtouchhelperdemo;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by louisgeek on 2016/5/31.
 */
public class MyRecyclerListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements MyItemTouchHelperCallback.MyItemTouchHelpListener{
    public final static String[] STR_ARRAY = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGTH","NINE","TEN"};
    private final List<String> mItems = new ArrayList<>();

    public MyRecyclerListAdapter() {
        mItems.addAll((Arrays.asList(STR_ARRAY)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.id_tv.setText(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onMyItemTouchHelp_ItemMove(int fromPosition, int toPosition) {
       /*
       //方法1
       String prev = mItems.remove(fromPosition);
        mItems.add(toPosition > fromPosition ? toPosition - 1 : toPosition, prev);*/
        /*
       方法2*/
        Collections.swap(mItems, fromPosition, toPosition);

        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onMyItemTouchHelp_ItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder implements MyItemTouchHelperCallback.MyItemStatusListener{
       public TextView id_tv;
       public MyViewHolder(View itemView) {
           super(itemView);
           id_tv = (TextView)itemView.findViewById(R.id.id_tv);
       }

        @Override
        public void onMyItemStatus_ItemSelected() {
            itemView.setBackgroundColor(Color.WHITE);
        }

        @Override
        public void onMyItemStatus_ItemClear() {
            itemView.setBackgroundColor(Color.WHITE);
        }
    }
}
