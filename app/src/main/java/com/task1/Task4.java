package com.task1;

import android.content.Context;
import android.graphics.Matrix;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.chrono.MinguoChronology;

public class Task4 extends AppCompatActivity {
    ViewPager viewPager;
    Task4ViewPagerAdapter task4ViewPagerAdapter;
    ImageView imageView;
    Matrix matrix=new Matrix();
    Float scale=1f;
    ScaleGestureDetector SGD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        viewPager=findViewById(R.id.task4_viewPager);
        task4ViewPagerAdapter=new Task4ViewPagerAdapter(this);
        viewPager.setAdapter(task4ViewPagerAdapter);

        LayoutInflater layoutInflater=(LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=(View)layoutInflater.inflate(R.layout.task4_image_layout,null);

        imageView=view.findViewById(R.id.task4_imageView);
        SGD=new ScaleGestureDetector(this,new ScaleListner());


    }

    private class ScaleListner extends  ScaleGestureDetector.SimpleOnScaleGestureListener{
        @Override
        public boolean onScale(ScaleGestureDetector detector){
            Toast.makeText(Task4.this, "Scale Detected", Toast.LENGTH_SHORT).show();
            scale=scale* detector.getScaleFactor();
            scale=Math.max(0.1f, Math.min(scale,5f));
            matrix.setScale(scale,scale);
            imageView.setImageMatrix(matrix);
            return  true;
        }
    }
}
