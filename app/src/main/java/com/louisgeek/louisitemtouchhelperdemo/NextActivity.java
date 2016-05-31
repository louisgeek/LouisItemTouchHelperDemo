package com.louisgeek.louisitemtouchhelperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        RecyclerView idrv = (RecyclerView) findViewById(R.id.id_rv);

        MyRecyclerList_Swipe_Adapter myRecyclerList_Swipe_Adapter=new MyRecyclerList_Swipe_Adapter();

        idrv.setHasFixedSize(true);
        idrv.setLayoutManager(new LinearLayoutManager(this));
        idrv.setAdapter(myRecyclerList_Swipe_Adapter);



       /* SwipeLayout swipeLayout_id_sl =  (SwipeLayout)findViewById(R.id.id_sl);

        //set show mode.  PullOut  LayDown
        swipeLayout_id_sl.setShowMode(SwipeLayout.ShowMode.LayDown);

        //add drag edge.(If the BottomView has 'layout_gravity' attribute, this line is unnecessary)
       // swipeLayout_id_sl.addDrag(SwipeLayout.DragEdge.Left, findViewById(R.id.bottom_wrapper));


        swipeLayout_id_sl.addSwipeListener(new SwipeLayout.SwipeListener() {
            @Override
            public void onClose(SwipeLayout layout) {
                //when the SurfaceView totally cover the BottomView.
            }

            @Override
            public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                //you are swiping.
            }

            @Override
            public void onStartOpen(SwipeLayout layout) {

            }

            @Override
            public void onOpen(SwipeLayout layout) {
                //when the BottomView totally show.
            }

            @Override
            public void onStartClose(SwipeLayout layout) {

            }

            @Override
            public void onHandRelease(SwipeLayout layout, float xvel, float yvel) {
                //when user's hand released.
            }
        });*/
    }
}
