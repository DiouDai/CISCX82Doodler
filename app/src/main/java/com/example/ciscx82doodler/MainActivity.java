package com.example.ciscx82doodler;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.ciscx82doodler.DoodleView.colorList;
import static com.example.ciscx82doodler.DoodleView.current_brush;
import static com.example.ciscx82doodler.DoodleView.pathList;


public class MainActivity extends AppCompatActivity {
    public static Paint mPaint = new Paint();
    public static Path mPath = new Path();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void pencil(View view){
        mPaint.setColor(Color.BLACK);
        currentColor(mPaint.getColor());
    }

    public void eraser(View view){
        mPath.reset();
        pathList.clear();
        colorList.clear();
    }

    public void redColor(View view){
        mPaint.setColor(Color.RED);
        currentColor(mPaint.getColor());

    }

    public void yellowColor(View view){
        mPaint.setColor(Color.YELLOW);
        currentColor(mPaint.getColor());
    }

    public void currentColor(int color){
        current_brush = color;
        mPath = new Path();
    }
}
