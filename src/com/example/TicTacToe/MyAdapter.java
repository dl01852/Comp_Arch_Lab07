package com.example.TicTacToe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import com.example.TicTacToe.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 3/7/2016.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    List<Integer> ImageIds;
    public MyAdapter(Context context)
    {
        this.context = context;
        ImageIds = new ArrayList<>();
        for(int i = 0; i < 9; i++)
        {
            // add 9 blank squares to ImageIds... 9 squares on a TicTacToe board..
            ImageIds.add(R.drawable.blank);
        }
    }
    public int getCount() {
        return ImageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return ImageIds.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup gridView) {
        View layout = convertView;
        ViewHolder imageHolder;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // creates a new Layout for each cell.
            layout = inflater.inflate(R.layout.single_image, gridView, false); // this is the layout to create AKA inflate.
            imageHolder = new ViewHolder(layout); // give it to the imageHolder so we can recyle it as well as change the source outside of this getViewMethod.
            layout.setTag(imageHolder); // this is how i can access the image outside of the getView, since i'm going to return this layout. i call the getTag to get the image object.
        }
        else
        {
            imageHolder = (ViewHolder)layout.getTag();
        }

        imageHolder.TicTacToeImage.setImageResource(ImageIds.get(position));
        imageHolder.TicTacToeImage.setTag(ImageIds.get(position));
        return layout;
    }

}


class ViewHolder
{
    ImageView TicTacToeImage;
    int xView = R.drawable.x;
    int circleView = R.drawable.circle;
    boolean taken = false;
    ViewHolder(View v)
    {
        TicTacToeImage = (ImageView)v.findViewById(R.id.TicTacToeImage); // this is defined in teh single_image.xml file.

    }

    public void setImage(ImageView image){TicTacToeImage = image;}
    public void changeImage(int counter)
    {
        if(counter % 2 == 0)
            TicTacToeImage.setImageResource(xView);
        else
            TicTacToeImage.setImageResource(circleView);

    taken = true;
    }
    public boolean hasBeenTaken() // quick check to see if the cell has been taken.
    {
        return taken;
    }

}
