package com.example.sijack.provacontest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.nhaarman.supertooltips.ToolTip;
import com.nhaarman.supertooltips.ToolTipRelativeLayout;

/**
 * Created by Sijack on 30/01/2018.
 */

public class MarkerListener implements View.OnClickListener {
    private boolean focused = false;
    private RelativeLayout frameContainer;
    private Context context;
    private ToolTipRelativeLayout toolTipRelativeLayout;

    public MarkerListener(Context context, RelativeLayout fc, ToolTipRelativeLayout trl) {
        frameContainer = fc;
        this.context = context;
        toolTipRelativeLayout = trl;
    }

    @Override
    public void onClick(View view) {
        MarkerImageView thisIv = (MarkerImageView) view;

        if (thisIv.isFocused()) {
            thisIv.setFocused(false);
            toolTipRelativeLayout.removeAllViews();

        } else {

            for (int i = 2; i < frameContainer.getChildCount(); i++) {
                MarkerImageView v = (MarkerImageView) frameContainer.getChildAt(i);
                if (v.isFocused())
                    v.setFocused(false);
                toolTipRelativeLayout.removeAllViews();
            }

            thisIv.setFocused(true);
            Log.d("LAYOUT", toolTipRelativeLayout.getWidth() + " " + toolTipRelativeLayout.getHeight());
            ToolTip toolTip = new ToolTip()
                    .withContentView(LayoutInflater.from(context).inflate(R.layout.custom_other_tooltip, null));
            toolTipRelativeLayout.showToolTipForView(toolTip, view);
        }

    }

}
