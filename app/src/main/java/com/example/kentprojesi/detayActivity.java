package com.example.kentprojesi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);


        ImageView imageView=findViewById(R.id.imageView);
        TextView landmarkNameText=findViewById(R.id.landmarkNameText);
        TextView countryNameText=findViewById(R.id.countryNameText);

        Intent intent=getIntent();
       String lanmarkName= intent.getStringExtra("name");
        landmarkNameText.setText(lanmarkName);
        String countryName=intent.getStringExtra("country");
        countryNameText.setText(countryName);

        Singleton singleton = Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

    }
}
