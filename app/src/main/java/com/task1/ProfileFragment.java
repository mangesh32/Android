package com.task1;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    Intent intent;
    String []itemsrc={
      "Pager With Tabs",
      "Toolbar with Search",
      "Image Slider"
    };


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_profile, container, false);
        listView=v.findViewById(R.id.listview);
        arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,itemsrc);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent=new Intent(getActivity(),Task2.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getActivity(),Task3.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(getActivity(),Task4.class);
                        startActivity(intent);
                        break;
                }
            }
        });



        return v;
    }

}
