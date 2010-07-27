package com.viggy.SillyCardTrick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
    private int pos;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public ImageAdapter(Context c, int row) {
        mContext = c;
        pos =row;
    }
    
    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(40, 40));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    public static Integer[] mThumbIds = {
    		R.drawable.card_1, R.drawable.card_2,
            R.drawable.card_3, R.drawable.card_4,
            R.drawable.card_5, R.drawable.card_6,
            R.drawable.card_7, R.drawable.card_8,
            R.drawable.card_9, R.drawable.card_10,
            R.drawable.card_11,R.drawable.card_12,
            R.drawable.card_13,R.drawable.card_14,
            R.drawable.card_15,R.drawable.card_16,
            R.drawable.card_17,R.drawable.card_18,
            R.drawable.card_19,R.drawable.card_20,
            R.drawable.card_21
    };
}
