package com.example.TicTacToe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    /**
     * Called when the activity is first created.
     * Written by David Lewis on 3/7/2016
     */

    int counter = 0;
    GridView ticTacoeBoard;
    MyAdapter imageAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ticTacoeBoard = (GridView)findViewById(R.id.gridView);
        imageAdapter = new MyAdapter(this);
        ticTacoeBoard.setAdapter(imageAdapter);
        ticTacoeBoard.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> adapterView, View view,int position, long l)
    {
       ViewHolder image = (ViewHolder)view.getTag();
        image.changeImage(counter);
        counter++;
    }

}
