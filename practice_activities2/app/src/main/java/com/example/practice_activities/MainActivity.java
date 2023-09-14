package com.example.practice_activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnact;
    Button btnact2;
    EditText etnName;
    TextView results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnact = findViewById(R.id.btnact);
        btnact2 = findViewById(R.id.btnact2);
        etnName = findViewById(R.id.etName);
        results = findViewById(R.id.results);
        btnact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etnName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "enter text", Toast.LENGTH_SHORT).show();
                }else {
                    String text= etnName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,com.example.practice_activities.MainActivity2.class);
                    intent.putExtra("name",text);
                    startActivity(intent);
                }
        }});
        btnact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,com.example.practice_activities.MainActivity3.class);
                startActivityForResult(intent,3);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("+result", "onActivityResult: "+resultCode);


            if (resultCode == RESULT_OK)
            {
                results.setText(data.getStringExtra("surname"));
            }
            if (resultCode == RESULT_CANCELED) {
                results.setText("no data returnd");
            }


    }
}