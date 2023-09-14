package com.example.testapp2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnOpen;
    String name,phone,web,map;
    TextView tvname,tvphone,tvlocation,tvweb;
    ImageView im1,im2,im3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpen = findViewById(R.id.btnopen);
        tvname = findViewById(R.id.tvname);
        tvphone=findViewById(R.id.tvphone);
        tvlocation = findViewById(R.id.tvlocation);
        tvweb =findViewById(R.id.tvweb);
        im1=findViewById(R.id.iv1);
        im2=findViewById(R.id.iv2);
        im3=findViewById(R.id.iv3);
        int[] viewIds = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.tvname,R.id.tvphone,R.id.tvweb,R.id.tvlocation};
        for(int viewId : viewIds) {
            View view = findViewById(viewId);
            if (view != null) {
                view.setVisibility(View.INVISIBLE);
            }}


        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+web));
                startActivity(intent);

            }
        });
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude = 37.7749;
                double longitude = -122.4194;

                String uri = "geo:" + latitude + "," + longitude;
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

//                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+map));
//                startActivity(intent);

            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                startActivity(intent);

            }
        });


        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,com.example.testapp2.MainActivity2.class);
//                startActivity(intent);
                startActivityForResult(intent,3); // need an explanation for the 3

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("+result", "onActivityResult: "+resultCode);
        if (resultCode == RESULT_OK){
            //Toast.makeText( MainActivity.this, "success", Toast.LENGTH_SHORT).show();
            name=data.getStringExtra("name");
            phone=data.getStringExtra("phone");
            map =data.getStringExtra("map");
            web= data.getStringExtra("web");

            Toast.makeText(this, name, Toast.LENGTH_LONG);
            tvname.setText(name);
            tvlocation.setText(map);
            tvphone.setText(phone);
            tvweb.setText(web);

            int[] viewIds = {R.id.iv1,R.id.iv2,R.id.iv3,R.id.tvname,R.id.tvphone,R.id.tvweb};
            for(int viewId : viewIds) {
                View view = findViewById(viewId);
                if (view != null) {
                    view.setVisibility(View.VISIBLE);
                }}

            Log.d("succ", "name is "+ name);
        }
        if(resultCode == RESULT_CANCELED){
            Toast.makeText(this, "failed succesfully", Toast.LENGTH_SHORT).show();
        }

    }
}