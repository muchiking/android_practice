package com.example.practice_activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    Button btn3;
    EditText etName1;

    Button btncancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btn3=findViewById(R.id.btnclick3);
        etName1=findViewById(R.id.etName1);
        btncancel= findViewById(R.id.btncancel);
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName1.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity3.this, "enter input", Toast.LENGTH_SHORT).show();
                }
                else{
                    String surname = etName1.getText().toString().trim();
                    Intent intent =new Intent();
                    intent.putExtra("surname",surname);
                    setResult(RESULT_OK,intent);
                    MainActivity3.this.finish();

                }

            }
        });

    }
}