package com.example.basic_banking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.basic_banking_app.ui.DBHelper;

public class transfermoney extends AppCompatActivity {
    Button ser1, done;
    EditText nm1,rs;
    TextView textView17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfermoney);

        ser1 = findViewById(R.id.ser1);
        nm1 = findViewById(R.id.nm1);
        textView17 = findViewById(R.id.textView17);
        done = findViewById(R.id.done);
        rs=findViewById(R.id.rs);
        DBHelper db = new DBHelper(this);

        ser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String rollno = nm1.getText().toString();
                String rupeeno=rs.getText().toString();
                textView17.setText(db.getSearchedCus(rollno));
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), finalactivity.class);

                i.putExtra("value", "entry");
                startActivity(i);
            }
        });

    }
}