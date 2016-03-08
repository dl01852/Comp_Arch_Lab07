package com.example.TicTacToe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    /**
     * Called when the activity is first created.
     * Written by David Lewis on 3/7/2016
     */

    char[] cellPV = new char[9];
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
        if(image.hasBeenTaken())
            Toast.makeText(MyActivity.this, "That spot has been taken already", Toast.LENGTH_SHORT).show();
        else
        {
            image.changeImage(counter);
            cellPV[position] = counter % 2 == 0 ? 'x' : 'o'; // cellPV = Cell position Value. this will be used to check if there is winner or not.
            counter++;
        }

    }
    public Boolean isWinner()
    {
        // Damn i wish there was a better way then brute forcing this...
        if(cellPV[0] == 'x' && cellPV[1] == 'x' && cellPV[2] == 'x') // straight across
        {
            return true;
        }
        else if(cellPV[0] == 'x' && cellPV[3] == 'x' && cellPV[6] == 'x')
            return true;
        else if(cellPV[0] == 'x' && cellPV[4] == 'x' && cellPV[8] == 'x')
            return true;

        return false;
    }

}
