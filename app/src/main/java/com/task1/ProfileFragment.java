package com.task1;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.Toolbar;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    ListView listView;
    ArrayAdapter arrayAdapter;
    Intent intent;
    AlertDialog alertDialog1;
    AlertDialog alertDialog2;
    AlertDialog alertDialog3;
    String []itemsrc={
            "Pager With Tabs",
            "Toolbar with Search",
            "Image Slider",
            "List With Radio Buttons",
            "List With Check Boxes",
            "Alert Dialog",
            "Process Dialog",
            "DatePicker",
            "Time Picker"
    };


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
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
                    case 3:
                        intent=new Intent(getActivity(),Task5.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent=new Intent(getActivity(),Task6.class);
                        startActivity(intent);
                        break;
                    case 5:
                        //Alert Dialog
                        android.support.v7.app.AlertDialog.Builder builder=new android.support.v7.app.AlertDialog.Builder(getActivity());
                        builder.setMessage("Sample Alert Box");
                        builder.setIcon(R.drawable.ic_error_black_24dp);
                        builder.setCancelable(true);
                        builder.setTitle("AlertBox");
                        android.support.v7.app.AlertDialog alertDialog=builder.create();
                        alertDialog.show();
                        break;
                    case 6:
                        //Progress Dialog
                        View v=inflater.inflate(R.layout.process_dialog,null);
                        final ProgressBar progressBar=v.findViewById(R.id.progressBar2);
                        Button btn=v.findViewById(R.id.btnTap);

                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int p=progressBar.getProgress();
                                progressBar.setProgress(p+25);
                                if(progressBar.getProgress()>=100){
                                    alertDialog1.cancel();
                                }
                            }
                        });

                       AlertDialog.Builder builder1=new AlertDialog.Builder(getActivity());
                       builder1.setView(v);
                       alertDialog1=builder1.create();
                       alertDialog1.show();
                       break;
                    case 7:
                        //Date Picker
                        View v2=inflater.inflate(R.layout.date_picker,null);
                        final DatePicker datePicker=v2.findViewById(R.id.pick_date);
                        Button dateBtn=v2.findViewById(R.id.button_datepick);
                        dateBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String date=datePicker.getDayOfMonth()+"/"+((int)datePicker.getMonth()+1)+"/"+datePicker.getYear();
                                Toast.makeText(getActivity(), "Selected Date: "+date, Toast.LENGTH_SHORT).show();
                                alertDialog2.cancel();
                            }
                        });


                        AlertDialog.Builder builder2=new AlertDialog.Builder(getActivity());
                        builder2.setView(v2);
                        alertDialog2=builder2.create();
                        alertDialog2.show();

                        break;
                    case 8:
                        //Time Picker
                        View v3=inflater.inflate(R.layout.time_picker,null);
                        final TimePicker timePicker=v3.findViewById(R.id.pick_time);
                        Button timeBtn=v3.findViewById(R.id.button_timepick);
                        timeBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String time=timePicker.getHour()+":"+timePicker.getMinute();
                                Toast.makeText(getActivity(), "Selected Time: "+time, Toast.LENGTH_SHORT).show();
                                alertDialog3.cancel();
                            }
                        });


                        AlertDialog.Builder builder3=new AlertDialog.Builder(getActivity());
                        builder3.setView(v3);
                        alertDialog3=builder3.create();
                        alertDialog3.show();


                        break;
                }
            }
        });



        return v;
    }

}
