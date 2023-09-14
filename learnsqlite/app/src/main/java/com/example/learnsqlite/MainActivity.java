package com.example.learnsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etname,etcell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname= (EditText) findViewById(R.id.etName);
        etcell=findViewById(R.id.etCell);

    }
    public void btnSubmit(View v){
        String name =etname.getText().toString().trim();
        String cell = etcell.getText().toString().trim();

        try{
            ContacsDb db = new ContacsDb(this);
            db.open();
            db.createEntry(name,cell);
            db.close();
            Toast.makeText(this, "Sucesfuly saved ", Toast.LENGTH_SHORT).show();
            etname.setText("");
            etcell.setText("");

        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }
    public void btnEditdata(View v){
        try{
            ContacsDb db = new ContacsDb(this);
            db.open();
            db.updateentry("1","John j","278456734655");
            db.close();
        }
        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    public void btnShowData(View v){
        Intent show_data = new Intent(this,Data.class);
        startActivity(show_data);

    }
    public void btnDeleteData(View v){
        try {
            ContacsDb db = new ContacsDb(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(this, "sucessfully deleted ", Toast.LENGTH_SHORT).show();

        }

        catch (SQLException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}