package com.task1;

import android.content.Context;
import android.graphics.Matrix;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.time.chrono.MinguoChronology;

public class Task4 extends AppCompatActivity {
    ViewPager viewPager;
    Task4ViewPagerAdapter task4ViewPagerAdapter;
    Matrix matrix=new Matrix();
    Float scale=1f;
    ScaleGestureDetector SGD;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task4);

        viewPager = findViewById(R.id.task4_viewPager);
        task4ViewPagerAdapter = new Task4ViewPagerAdapter(this);
        viewPager.setAdapter(task4ViewPagerAdapter);

    }
}
