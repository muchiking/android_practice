package com.example.learn_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edNumberofrolls;
    Button btnRoll;
    TextView tvresults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRoll= findViewById(R.id.btnRollDice);
        edNumberofrolls= findViewById(R.id.etNrTimes);
        tvresults=findViewById(R.id.tvResults);
        tvresults.setVisibility(View.GONE);


        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nooftimes = Integer.parseInt(edNumberofrolls.getText().toString().trim() );
                new processDiceInBackground().execute(nooftimes);



            }
        });
    }
    public class processDiceInBackground extends AsyncTask<Integer,Integer,String>{
        ProgressDialog dialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(Integer.parseInt(edNumberofrolls.getText().toString().trim() ));
            dialog.show();
        }

        @Override
        protected String doInBackground(Integer... integers) {

            int one =0,two = 0,three = 0,four = 0,five= 0, six = 0, randomNumber;

            Random random = new Random();
            String result;
            double currentprogres =0;
            double previoussprogres =0;

            for (int i =0; i< integers[0];i++){
                currentprogres = (double) i/integers[0];
                if(currentprogres - previoussprogres >= 0.02){
                    publishProgress(i);
                    previoussprogres=currentprogres;
                }
                randomNumber=random.nextInt(6) + 1;
                switch (randomNumber){
                    case 1: one++;
                        break;
                    case 2: two++;
                        break;
                    case 3: three++;
                        break;
                    case 4: four++;
                        break;
                    case 5: five++;
                        break;
                    case 6: six++;
                        break;

                }
            }
            result = "Results: \n1: "+ one + "\n2: " + two + "\n3: " +three+ "\n4: " +four+ "\n:5 " +five+ "\n6: " + six;
            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            dialog.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dialog.dismiss();
            tvresults.setText(s);
            tvresults.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, "Completed", Toast.LENGTH_SHORT).show();
        }
    }
}