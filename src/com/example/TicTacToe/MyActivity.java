package com.example.TicTacToe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    /**
     * Called when the activity is first created.
     * Written by David Lewis on 3/7/2016
     */

    char[] cellPV = new char[9];
    int turn = 0;
    GridView ticTacoeBoard;
    MyAdapter imageAdapter;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ticTacoeBoard = (GridView)findViewById(R.id.gridView);
        imageAdapter = new MyAdapter(this);
        ticTacoeBoard.setAdapter(imageAdapter);
        ticTacoeBoard.setOnItemClickListener(this);

        Button newGame = (Button)findViewById(R.id.button);
        newGame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
               ticTacoeBoard.setAdapter(imageAdapter);
                turn = 0;
                for(int i = 0; i < cellPV.length; i++)
                {
                    cellPV[i] = 'E'; // E for empty.. empty out the board.
                }
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view,int position, long l)
    {
       ViewHolder image = (ViewHolder)view.getTag();
        if(image.hasBeenTaken()) // IS THE SPOT TAKEN??
            Toast.makeText(MyActivity.this, "this is being ran", Toast.LENGTH_SHORT).show();
        else if(isWinner())
        {
            Toast.makeText(MyActivity.this, "The game is over",Toast.LENGTH_SHORT).show();
        }
        else
        {
            image.changeImage(turn);
            cellPV[position] = turn % 2 == 0 ? 'x' : 'o'; // cellPV = Cell position Value. this will be used to check if there is winner or not. Even is 'x' Odd is 'o'

            if(isWinner()) // check for winner after turn is made.
            {
                if(turn%2 == 0) // x won
                    Toast.makeText(MyActivity.this,"X wins!",Toast.LENGTH_LONG).show();
                else // o won
                    Toast.makeText(MyActivity.this, "O wins", Toast.LENGTH_SHORT).show();
            }
            turn++;
        }
    }
    public Boolean isWinner()
    {
        // Damn i wish there was a better way then this lol
        if((cellPV[0] == 'x' && cellPV[3] == 'x' && cellPV[6] == 'x')|| (cellPV[0] == 'o' && cellPV[3] == 'o' && cellPV[6] == 'o')) // column 1
            return true;
        else if((cellPV[1] == 'x' && cellPV[4] == 'x' && cellPV[7] == 'x') || (cellPV[1] == 'o' && cellPV[4] == 'o' && cellPV[7] == 'o')) // column 2
            return true;
        else if((cellPV[2] == 'x' && cellPV[5] == 'x' && cellPV[8] == 'x') || (cellPV[2] == 'o' && cellPV[5] == 'o' && cellPV[8] == 'o')) // column 3
            return true;
        else if((cellPV[0] == 'x' && cellPV[1] == 'x' && cellPV[2] == 'x') || (cellPV[0] == 'o' && cellPV[1] == 'o' && cellPV[2] == 'o')) // row 1
            return true;
        else if((cellPV[3] == 'x' && cellPV[4] == 'x' && cellPV[5] == 'x') || (cellPV[3] == 'o' && cellPV[4] == 'o' && cellPV[5] == 'o')) // row 2
            return true;
        else if((cellPV[6] == 'x' && cellPV[7] == 'x' && cellPV[8] == 'x') || (cellPV[6] == 'o' && cellPV[7] == 'o' && cellPV[8] == 'o') ) // row 3
            return true;
        else if((cellPV[0] == 'x' && cellPV[4] == 'x' && cellPV[8] == 'x') || (cellPV[0] == 'o' && cellPV[4] == 'o' && cellPV[8] == 'o')) // diagonal left to right
            return true;
        else if((cellPV[2] == 'x' && cellPV[4] == 'x' && cellPV[6] == 'x') || (cellPV[2] == 'o' && cellPV[4] == 'o' && cellPV[6] == 'o')) // diagonal right to left.
            return true;

        return false;

    }

}