package com.example.vectorassets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivpic ,ivpic3,ivpic4,ivpic5;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivpic= findViewById(R.id.ivpic1);
        ivpic3= findViewById(R.id.ivpic3);
        ivpic4= findViewById(R.id.ivpic4);
        ivpic5= findViewById(R.id.ivpic5);
        btnChange= findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivpic.setImageResource(R.drawable.build);
            }
        });
        ivpic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivpic.setImageResource(R.drawable.beach);

            }
        });

        ivpic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivpic.setImageResource(R.drawable.cake);

            }
        });
        ivpic5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivpic.setImageResource(R.drawable.build);

            }
        });


    }
}