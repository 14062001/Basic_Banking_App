package com.example.basic_banking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

        Button viewallcus,selectcus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewallcus=findViewById(R.id.viewallcus);
        selectcus=findViewById(R.id.selectcus);


        viewallcus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Viewall.class);
                i.putExtra("Value", "entry");
                startActivity(i);
            }
        });

        selectcus.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),select.class);
                i.putExtra("Value", "entry");
                startActivity(i);
            }
        }));




    }
}