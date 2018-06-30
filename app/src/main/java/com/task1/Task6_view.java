package com.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Task6_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5_view);

        Intent intent=getIntent();
        TextView textView=findViewById(R.id.textView_task5);
        textView.setText("You have Selected : "+intent.getStringArrayListExtra("CheckedBoxes"));

    }
}
