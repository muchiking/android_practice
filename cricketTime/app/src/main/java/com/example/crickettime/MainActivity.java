package com.example.crickettime;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText etResults;
    TextView tvVeiw;
    TextView tvResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSubmit=findViewById(R.id.btnSubmit);
        etResults=findViewById(R.id.editTextText);
        tvResults =findViewById(R.id.tvResults);
        tvVeiw =findViewById(R.id.tvView);
        tvResults.setVisibility(View.GONE);
        tvVeiw.setVisibility(View.GONE);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etResults.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"enter text ",Toast.LENGTH_LONG).show();

                }
                else {
                    String num_of_clicks = etResults.getText().toString().trim();
                    Log.d("bazu", "onClick: runs");
                    int answer = temp(num_of_clicks);
                    tvResults.setText(Integer.toString(answer));
                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public int temp(String cricks){
        int temperature=((Integer.parseInt((cricks)))/15 + 37);
        Log.d("bazu","temp: calculates "+temperature);
        return temperature;

    }
}