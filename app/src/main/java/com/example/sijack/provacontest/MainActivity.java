package com.example.sijack.provacontest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.sijack.provacontest.database.AppDatabase;
import com.example.sijack.provacontest.database.Room;
import com.nhaarman.supertooltips.ToolTipRelativeLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ArrayList<Room> rooms = new ArrayList<>();
    ImageView plant;
    int density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase db = AppDatabase.getInstance(getApplicationContext());
        Thread t = new Thread() {
            @Override
            public void run() {
                Log.d("DEBUG", "" + db.roomDao().getAll().size());
            }
        };
        t.start();

        Display display = getWindowManager().getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        density = (int) metrics.density;

        ToolTipRelativeLayout toolTipRelativeLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipRelativeLayout);
        final RelativeLayout container = findViewById(R.id.container);
        final RelativeLayout frameContainer = findViewById(R.id.frameContainer);

       // plant = findViewById(R.id.imgPlant);

        rooms.add(new Room(11, 5, 62, 127));
        rooms.add(new Room(11, 132, 146, 94));

        MarkerImageView iv;

        final Bitmap marker = BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        int markerd = marker.getWidth();

        for (Room r : rooms) {
            int x = r.getX()*density;
            int y = r.getY()*density;
            int w = r.getWidth()*density;
            int h = r.getHeight()*density;
            int posx = x+(w/2)-(markerd/2);
            int posy = y+(h/2)-(markerd/2);

            Log.d("DEBUG",  posx + " " + posy + " " + x + " " + y + " " + w + " " + h);

            iv = new MarkerImageView(this);
            iv.setX(x+(w/2)-(markerd/2));
            iv.setY(y+(h/2)-(markerd/2));
            iv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));

            iv.setOnClickListener(new MarkerListener(this, frameContainer, toolTipRelativeLayout));

            frameContainer.addView(iv);

        }

        /*
        frameContainer.setOnTouchListener(new View.OnTouchListener() {
            private RoomDrawable roomBorders;
            private int x, y;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = (int) motionEvent.getX();
                        y = (int) motionEvent.getY();

                        Log.d("DEBUG", "ACION DOWN");



                        if ((x >= 2550 && x <= 1500 * density) && (y >= 4 && y <= 133 * density)) {
                            if (roomBorders != null) {
                                frameContainer.removeView(roomBorders);

                                roomBorders = null;
                            } else {
                                roomBorders = new RoomDrawable(getApplicationContext(), 2550, 4, 74 * density, 129 * density, frameContainer.getWidth(), frameContainer.getHeight());
                                frameContainer.addView(roomBorders);
                                Log.d("DEBUG", "added view " + frameContainer.getWidth() + " " + frameContainer.getHeight());

                            }
                        }

                        break;

                    case MotionEvent.ACTION_UP:


                        x = (int) motionEvent.getX();
                        y = (int) motionEvent.getY();

                        Log.d("DEBUG", "x: " + x + " y: " + y);

                        if ((x >= 9 && x <= 83 * density) && (y >= 4 && y <= 133 * density)) {
                            Toast.makeText(getApplicationContext(), "yee", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getApplicationContext(), "yee2", Toast.LENGTH_SHORT).show();
                        break;

                    case MotionEvent.ACTION_SCROLL:
/*
                        if (roomBorders != null) {
                            container.removeView(roomBorders);
                            roomBorders = null;
                        }

                        break;
                }

                return true;
            }

        });
 */

    }


}
