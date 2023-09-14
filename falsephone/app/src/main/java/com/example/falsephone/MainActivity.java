package com.example.falsephone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvjoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvjoke=findViewById(R.id.tvjoke);
        if (getIntent().getData() != null) {
            tvjoke.setText(getIntent().getData().toString());
        } else {
            tvjoke.setText("not funny");
        }
    }
}