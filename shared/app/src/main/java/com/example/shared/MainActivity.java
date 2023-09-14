package com.example.shared;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnOpen;
    TextView title;
    EditText etname;

    public static String pack = "com.example.shared.name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences(pack,MODE_PRIVATE);
        String user = pref.getString("name", " ");
        btnOpen = findViewById(R.id.btnOpen);
        title = findViewById(R.id.tvtitle);
        etname = findViewById(R.id.edtext);
        title.setText("My name is "+ user);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString().trim();
                title.setText("Name is "+name);

                SharedPreferences.Editor editor = getSharedPreferences(pack,MODE_PRIVATE).edit();
                editor.putString("name",name);
                editor.commit();
            }
        });
    }
}