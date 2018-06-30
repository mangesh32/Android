package com.task1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class Task3 extends AppCompatActivity {
    private  android.support.v7.widget.Toolbar toolbar;
    String[] items={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
    ArrayAdapter arrayAdapter;
    ListView listView;
    android.support.v7.widget.SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task3);

       toolbar=findViewById(R.id.toolbar2);
       listView=findViewById(R.id.task3listview);

       arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,items);
       listView.setAdapter(arrayAdapter);


       searchView=findViewById(R.id.search_view);

       searchView.setOnCloseListener(new android.support.v7.widget.SearchView.OnCloseListener() {
           @Override
           public boolean onClose() {
               arrayAdapter=new ArrayAdapter(Task3.this,android.R.layout.simple_list_item_1,items);
               listView.setAdapter(arrayAdapter);
               return false;
           }
       });



       searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener(){
           @Override
           public boolean onQueryTextSubmit(String s) {
               return false;
           }

           @Override
           public boolean onQueryTextChange(String s) {
               if(s!=null && !s.isEmpty()){
                   List<String> found=new ArrayList<String>();
                   for (String i : items)
                       if(i.contains(s))
                           found.add(i);
                   arrayAdapter=new ArrayAdapter(Task3.this,android.R.layout.simple_list_item_1,found);
                   listView.setAdapter(arrayAdapter);
               }
               else{
                   arrayAdapter=new ArrayAdapter(Task3.this,android.R.layout.simple_list_item_1,items);
                   listView.setAdapter(arrayAdapter);
               }


               return true;
           }
       });






    }
}
