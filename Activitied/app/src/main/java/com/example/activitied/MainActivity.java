package com.example.activitied;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button2);
        Button button2 = findViewById(R.id.button4);
        Button button3 = findViewById(R.id.button5);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open SecondActivity
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open SecondActivity
                Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to open SecondActivity

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                //onButtonClick(View v);

            }
        }
//        public void onButtonClick(View ) {
//            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
//            // Perform action when the button is clicked
//            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show();
//        }
        );
    }

}