package com.example.write;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    EditText etname,etsurname;
    TextView tvResults;
    ArrayList<Person> persons;
    Button add;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.etName);
        etsurname = findViewById(R.id.etSurname);
        tvResults = findViewById(R.id.tvResults);
        persons = new ArrayList<Person>();
        add = findViewById(R.id.btnadd);
//        save = findViewById(R.id.btnsave);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etname.getText().toString().trim();
                String surname = etsurname.getText().toString().trim();
                Person person = new Person(name,surname);
                persons.add(person);
                setTextToView();

            }
        });
        loadData();
    }
    public void btnadddata(View v){
        String name = etname.getText().toString().trim();
        String surname = etsurname.getText().toString().trim();
        Person person = new Person(name,surname);

        setTextToView();
    }

    private void setTextToView() {
        String text = "";
        for (int i=0;i<persons.size();i++){
//            Toast.makeText(this, persons.get(0).getName(), Toast.LENGTH_SHORT).show();
            text = text+ persons.get(i).getName()+ " " + persons.get(i).getSurname()+"\n";
            Log.d("[+] xxx", text);
        }
        tvResults.setText(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

    }
    public void loadData(){
        persons.clear();
        File file = getApplicationContext().getFileStreamPath("Data.txt");
        String lineFromFile;

        if (file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(openFileInput("Data.txt")));
                while ((lineFromFile = reader.readLine()) != null){
                    Log.d("[+] xxx", "new line opened");
                    StringTokenizer tokens = new StringTokenizer(lineFromFile ,",");
                    Person person = new Person(tokens.nextToken(), tokens.nextToken());

                    persons.add(person);
                }
                reader.close();

            }
            catch (IOException e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }

    }

    public void btnsavedata(View v){
        try{
            FileOutputStream file =openFileOutput("Data.txt", MODE_PRIVATE);
            OutputStreamWriter outputfile = new OutputStreamWriter(file);
            for (int i=0;i<persons.size();i++){
                outputfile.write(persons.get(i).getName()+","+ persons.get(i).getSurname());
            }
            outputfile.flush();
            outputfile.close();

            Toast.makeText(this, "successfuly saved!", Toast.LENGTH_SHORT).show();
        }
        catch (IOException e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}