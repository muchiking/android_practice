package com.example.testapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btn;
    EditText edname,edphone,edmap,edweb;
    String name,phone,map,web;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edname = findViewById(R.id.edname);
        edphone = findViewById(R.id.edphone);
        edmap = findViewById(R.id.edmap);
        btn = findViewById(R.id.btn1);
        edweb = findViewById(R.id.ed4);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edname.getText().toString().isEmpty() ||edphone.getText().toString().isEmpty() || edmap.getText().toString().isEmpty() || edweb.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please enter all inputs", Toast.LENGTH_SHORT).show();
                }
                else{
                    name = edname.getText().toString();
                    phone = edphone.getText().toString();
                    map = edmap.getText().toString();
                    web = edweb.getText().toString().trim();

                    Intent intent = new Intent();
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);
                    intent.putExtra("map",map);
                    intent.putExtra("web",web);
                    setResult(RESULT_OK,intent);
                    MainActivity2.this.finish();

                }
            }
        });

    }
}