package com.example.sijack.provacontest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by Sijack on 30/01/2018.
 */

public class MarkerImageView extends ImageView {

    private boolean focused = false;
    private Bitmap marker, red_marker;

    public MarkerImageView(Context context) {
        super(context);
        marker = BitmapFactory.decodeResource(context.getResources(), R.drawable.marker);
        red_marker = BitmapFactory.decodeResource(context.getResources(), R.drawable.red_marker);
        this.setImageBitmap(marker);
    }

    @Override
    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {

        if (focused) {
            this.setImageBitmap(red_marker);
        } else {
            this.setImageBitmap(marker);
        }

        this.focused = focused;
    }
}
