package com.example.ankit.jolly.mobitar;

import android.app.Activity;
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
    public EditText playstrum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        playstrum = (EditText) findViewById(R.id.playstrum);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        playstrum = (EditText) findViewById(R.id.playstrum);
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
                        playstrum.setText("You swiped right");
                    }
                    else if(deltaX < -MIN_DISTANCE)
                    {
                        playstrum.setText("You swiped left");
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
