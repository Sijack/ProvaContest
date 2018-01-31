package com.example.sijack.provacontest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Sijack on 30/01/2018.
 */

public class MarkerListener implements View.OnClickListener {
    private boolean focused = false;
    private RelativeLayout frameContainer;

    public MarkerListener(Context context, RelativeLayout fc) {
        frameContainer = fc;
    }

    @Override
    public void onClick(View view) {
        MarkerImageView thisIv = (MarkerImageView) view;

        if (thisIv.isFocused()) {
            thisIv.setFocused(false);

        } else {

            for (int i = 1; i < frameContainer.getChildCount(); i++) {
                MarkerImageView v = (MarkerImageView) frameContainer.getChildAt(i);
                if (v.isFocused())
                    v.setFocused(false);
            }

            thisIv.setFocused(true);
        }

    }

}
