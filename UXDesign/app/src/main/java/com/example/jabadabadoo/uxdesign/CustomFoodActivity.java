package com.example.jabadabadoo.uxdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CustomFoodActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    public static final int SWIPE_THRESHOLD = 100;
    public static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private GestureDetector gestureDetector;

    Button btdec1;     Button btinc1;
    Button btdec2;     Button btinc2;
    Button btdec3;     Button btinc3;
    Button btdec4;     Button btinc4;

    TextView tv01;
    TextView tv02;
    TextView tv03;
    TextView tv04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_food);

        gestureDetector = new GestureDetector(this);

        btdec1 = findViewById(R.id.minus1);
        btdec2 = findViewById(R.id.minus2);
        btdec3 = findViewById(R.id.minus3);
        btdec4 = findViewById(R.id.minus4);

        btinc1 = findViewById(R.id.plus1);
        btinc2 = findViewById(R.id.plus2);
        btinc3 = findViewById(R.id.plus3);
        btinc4 = findViewById(R.id.plus4);

        tv01 = findViewById(R.id.textView13);
        tv02 = findViewById(R.id.textView11);
        tv03 = findViewById(R.id.textView12);
        tv04 = findViewById(R.id.textView14);

        btinc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count++;
                tv01.setText(String.valueOf(count));
            }
        });

        btinc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count++;
                tv02.setText(String.valueOf(count));
            }
        });

        btinc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count++;
                tv03.setText(String.valueOf(count));
            }
        });

        btinc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count++;
                tv04.setText(String.valueOf(count));
            }
        });

        btdec1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count--;
                tv01.setText(String.valueOf(count));
            }
        });

        btdec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count--;
                tv02.setText(String.valueOf(count));
            }
        });

        btdec3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count--;
                tv03.setText(String.valueOf(count));
            }
        });

        btdec4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 1;
                count--;
                tv04.setText(String.valueOf(count));
            }
        });


    }



    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
        boolean result = false;
        float diffY = moveEvent.getY() - downEvent.getY();
        float diffX = moveEvent.getX() - downEvent.getX();

        //which was greater, movement across X or Y?
        if (Math.abs(diffX) > Math.abs(diffY)) {
            //left or right swipe
            if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffX > 0) {
                    onSwipeRight();
                } else {
                    onSwipeLeft();
                }
                result = true;
            }
        } else {
            //up or down swipe
            if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    onSwipeBottom();
                } else {
                    onSwipeTop();
                }
                result = true;
            }
        }
        return result;
    }

    private void onSwipeTop() {
    }

    private void onSwipeBottom() {
        finish();
    }

    private void onSwipeLeft() {
    }

    private void onSwipeRight()
    {

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public void paynow(View view) {
        startActivity(new Intent(this, PayActivity.class));
    }
}
