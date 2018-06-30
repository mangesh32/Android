package com.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class Task6 extends AppCompatActivity  {

    List<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task6);
        CheckBox checkBox1=findViewById(R.id.checkBox);
        CheckBox checkBox2=findViewById(R.id.checkBox1);
        CheckBox checkBox3=findViewById(R.id.checkBox2);
        CheckBox checkBox4=findViewById(R.id.checkBox3);
        Button button=findViewById(R.id.buttonGoCheck);

        checkBox1.setOnCheckedChangeListener(listener);
        checkBox2.setOnCheckedChangeListener(listener);
        checkBox3.setOnCheckedChangeListener(listener);
        checkBox4.setOnCheckedChangeListener(listener);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(list.isEmpty()){
                    Toast.makeText(Task6.this, "Select atleast one", Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent=new Intent(Task6.this,Task6_view.class);
                    intent.putExtra("CheckedBoxes",new ArrayList<String>(list));
                    startActivity(intent);
                }

            }
        });









    }
    CheckBox.OnCheckedChangeListener listener= new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                list.add(compoundButton.getText().toString());
            } else {
                list.remove(compoundButton.getText().toString());
            }
        }
    };
}
