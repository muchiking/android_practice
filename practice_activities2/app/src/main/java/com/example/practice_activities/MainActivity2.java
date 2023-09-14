package com.example.practice_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView3= findViewById(R.id.textView3);

        String name =getIntent().getStringExtra("name");

        textView3.setText(name+ " welcome to activity 2");
    }
}