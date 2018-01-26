package com.example.ankit.jolly.mobitar;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    private float x1,x2;
    static final int MIN_DISTANCE = 150;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch(event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    x1 = event.getX();
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = event.getX();
                    float deltaX = x2 - x1;
                    if (deltaX > MIN_DISTANCE)
                    {
                        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.music);
                        mediaPlayer.start();
                      //  Toast.makeText(getApplicationContext(),"RIGHT",Toast.LENGTH_SHORT).show();
                    }
                    else if(deltaX < -MIN_DISTANCE)
                    {
                        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.left);
                        mediaPlayer.start();
                      //  Toast.makeText(getApplicationContext(),"LEFT",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        // consider as something else - a screen tap for example
                    }
                    break;
            }
        return super.onTouchEvent(event);
    }
}
