package com.example.toastspecial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();

                showTost("we did it");
            }
        });
    }

    public void showTost(String message)
    {
        View toastview = getLayoutInflater().inflate(R.layout.toast,(ViewGroup) findViewById(R.id.linlay) );

        TextView tvtoast =( TextView) toastview.findViewById(R.id.tvToast);
        tvtoast.setText(message);

        Toast toast = new Toast(MainActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(toastview);
        toast.setGravity(Gravity.BOTTOM| Gravity.FILL_HORIZONTAL,0,0);
        toast.show();

    }
}