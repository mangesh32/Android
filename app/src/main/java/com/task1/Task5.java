package com.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Task5 extends AppCompatActivity {
   private String selectedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task5);
        RadioGroup radioGroup=findViewById(R.id.radio_grp);
        final int[] radioBtns={
                R.id.radioButton,
                R.id.radioButton2,
                R.id.radioButton3,
                R.id.radioButton4
        };
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                selectedText=((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            }
        });

        Button button=findViewById(R.id.buttonGo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedText.isEmpty() || selectedText==null){
                    Toast.makeText(Task5.this, "Please Select atleast one RadioButton", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent=new Intent(Task5.this,Task5_view.class);
                    intent.putExtra("SelectedRadio",selectedText );
                    startActivity(intent);
                }

            }
        });

    }
}
