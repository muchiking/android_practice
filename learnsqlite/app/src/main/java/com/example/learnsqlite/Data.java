package com.example.learnsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class Data extends AppCompatActivity {
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        tvData=findViewById(R.id.tvData);

        try {

                ContacsDb db = new ContacsDb(this);
                db.open();
                tvData.setText(db.getData());
            Log.d("", "[+] "+ db.getData());
                db.close();
        }
        catch (SQLException e ){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}