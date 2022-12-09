package com.example.ciscx82doodler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import static com.example.ciscx82doodler.MainActivity.mPaint;
import static com.example.ciscx82doodler.MainActivity.mPath;

import java.util.ArrayList;


public class DoodleView extends View {
   public static ArrayList<Path>  pathList = new ArrayList<>();
   public static ArrayList<Integer> colorList = new ArrayList<>();
   public ViewGroup.LayoutParams params;
   public static int current_brush = Color.BLACK;

   public DoodleView(Context context){
       super(context);
       init(context);
   }


    public DoodleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public DoodleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
       super(context, attrs, defStyleAttr);
    }

   private void init(Context context){

        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(10f);

        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
   }

   @Override
    public boolean onTouchEvent(MotionEvent event){
       float x = event.getX();
       float y = event.getY();
       switch (event.getAction()){
           case MotionEvent.ACTION_DOWN:
               mPath.moveTo(x,y);
               invalidate();
               return true;
           case MotionEvent.ACTION_MOVE:
               mPath.lineTo(x,y);
               pathList.add(mPath);
               colorList.add(current_brush);
               invalidate();
               return true;
           default:
               return false;

       }
   }

   @Override
    protected void onDraw(Canvas canvas){
       for(int i=0; i<pathList.size(); i++){
           mPaint.setColor(colorList.get(i));
           canvas.drawPath(pathList.get(i),mPaint);
           invalidate();
       }
   }



}
