package com.louisgeek.louisitemtouchhelperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button idbtn = (Button) findViewById(R.id.id_btn);
        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView idrv = (RecyclerView) findViewById(R.id.id_rv);

        MyRecyclerListAdapter myRecyclerListAdapter=new MyRecyclerListAdapter();

        idrv.setHasFixedSize(true);
        idrv.setLayoutManager(new LinearLayoutManager(this));
        idrv.setAdapter(myRecyclerListAdapter);

        ItemTouchHelper.Callback callback =
                new MyItemTouchHelperCallback(myRecyclerListAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(idrv);




    }
}
