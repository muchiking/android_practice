 package com.example.idcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {
    EditText etId;
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = findViewById(R.id.etID);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResults = findViewById(R.id.tvResults);
        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNumber = etId.getText().toString().trim();
                String dob =idNumber.substring(0,6);
                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if (gender < 5){
                    sGender = getString(R.string.males);
                } else{
                    sGender = "males";
                }
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if (nationality == 0){
                    sNationality = getString(R.string.citizen);
                }
                else {
                    sNationality = getString(R.string.permarnet_resident);
                }
                String res="Date of Birth " +  dob +"\n"+
                        "Gender: "+ sGender +"\n"+
                        "Nationlity: " + sNationality;
                tvResults.setText(res);
                tvResults.setVisibility(View.VISIBLE);
            }
        });
    }
}