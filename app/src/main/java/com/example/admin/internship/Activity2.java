package com.example.admin.internship;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        Intent intent=getIntent();

        String text=intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String gender=intent.getStringExtra(MainActivity.EXTRA_Gender);
        int number=intent.getIntExtra(MainActivity.EXTRA_NUM,0);
        double weight=intent.getDoubleExtra(MainActivity.EXTRA_Weight,0.0);
        double height=intent.getDoubleExtra(MainActivity.EXTRA_Height,0.0);
        double bmi=intent.getDoubleExtra(MainActivity.EXTRA_Bmi,0.0);



        TextView textView= findViewById(R.id.edit_name);
        TextView textView1=findViewById(R.id.gender);
        TextView textView2=findViewById(R.id.edit_age);
        TextView textView3=findViewById(R.id.edit_weight);
        TextView textView4=findViewById(R.id.edit_height);
        TextView textView5=findViewById(R.id.bmi2);

        textView.setText(text);
        textView1.setText(gender);
        textView2.setText(""+number);
        textView3.setText((int) weight);
        textView4.setText((int) height);
        textView5.setText((int) bmi);


    }
}
