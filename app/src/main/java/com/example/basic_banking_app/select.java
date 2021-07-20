package com.example.basic_banking_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.basic_banking_app.ui.DBHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class select extends AppCompatActivity {

    Button ser, transfermoney;
    EditText nm;
    TextView textView16;
    String rollno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        ser = findViewById(R.id.ser);
        nm = findViewById(R.id.nm);
        textView16 = findViewById(R.id.textView16);
        transfermoney = findViewById(R.id.transfermoney);



        DBHelper db = new DBHelper(this);

        ser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 rollno = nm.getText().toString();
                textView16.setText(db.getSearchedCus(rollno));

            }
        });



        transfermoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), transfermoney.class);
                i.putExtra("value", "entry");
                startActivity(i);

            }
        });

    }
}

