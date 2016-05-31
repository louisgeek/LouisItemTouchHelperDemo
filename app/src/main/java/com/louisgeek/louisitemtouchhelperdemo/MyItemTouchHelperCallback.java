package com.louisgeek.louisitemtouchhelperdemo;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by louisgeek on 2016/5/31.
 */
public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {


    public MyItemTouchHelperCallback(MyItemTouchHelpListener myItemTouchHelpListener) {
        mMyItemTouchHelpListener = myItemTouchHelpListener;
    }

    private MyItemTouchHelpListener mMyItemTouchHelpListener;
    /**
     * 指定拖动和滑动支持的方向
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
       // return 0;

        //List部分功能  上下为拖动（drag），左右为滑动（swipe）
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;//拖动支持向下和向上
        int swipeFlag = ItemTouchHelper.START | ItemTouchHelper.END;//滑动支持向左和向右
     /*   //Grid部分功能
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN |ItemTouchHelper.START | ItemTouchHelper.END;
        int swipeFlag = 0;*/
        return makeMovementFlags(dragFlag,swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        //return false;
     mMyItemTouchHelpListener.onMyItemTouchHelp_ItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mMyItemTouchHelpListener.onMyItemTouchHelp_ItemDismiss(viewHolder.getAdapterPosition());
    }
    /**
     * 是否支持长按进入拖动
     * 要支持长按RecyclerView item进入拖动操作，你必须在isLongPressDragEnabled()方法中返回true。或者，也可以调用ItemTouchHelper.startDrag(RecyclerView.ViewHolder) 方法来开始一个拖动
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
       // return super.isLongPressDragEnabled();
        return true;
    }
    /**
     * 是否支持滑动
     * 而要在view任意位置触摸事件发生时启用滑动操作，则直接在sItemViewSwipeEnabled()中返回true就可以了。或者，你也主动调用ItemTouchHelper.startSwipe(RecyclerView.ViewHolder) 来开始滑动操作。
     *
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
       // return super.isItemViewSwipeEnabled();
        return true;
    }
    /**
     * 在每次View Holder的状态变成拖拽 (ACTION_STATE_DRAG) 或者 滑动 (ACTION_STATE_SWIPE)的时候被调用。
     * @param viewHolder
     * @param actionState
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        //可选
        if(actionState != ItemTouchHelper.ACTION_STATE_IDLE){
            if (viewHolder instanceof MyItemStatusListener) {
                MyItemStatusListener listener = (MyItemStatusListener) viewHolder;
                listener.onMyItemStatus_ItemSelected();
            }

        }

    }
    /**
     * 在一个view被拖拽然后被放开的时候被调用，
     * @param recyclerView
     * @param viewHolder
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        if (viewHolder instanceof MyItemStatusListener) {
            MyItemStatusListener listener = (MyItemStatusListener) viewHolder;
            listener.onMyItemStatus_ItemClear();
        }
    }

    /**
     * onMove()和onSwiped()，用于通知底层数据的更新。创建一个可以将这些回调方法传递出去的接口。
     */
   public interface  MyItemTouchHelpListener{
        void onMyItemTouchHelp_ItemMove(int fromPosition, int toPosition);
        void onMyItemTouchHelp_ItemDismiss(int position);
    }

    /**
     * 自定义接口将这些回调方法传递给 ViewHolder
     */
    public interface  MyItemStatusListener{
        void onMyItemStatus_ItemSelected();
        void onMyItemStatus_ItemClear();
    }


}
