package com.example.basic_banking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.basic_banking_app.ui.DBHelper;

import java.util.ArrayList;

public class Viewall extends AppCompatActivity {

    DBHelper db = new DBHelper(this);
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);

        listView = findViewById(R.id.list);
        ArrayList<String> data = new ArrayList<>();

        final ArrayList<String> list1 = new ArrayList<String>();



        data = db.getAllCustomer();

        list1.clear();
        for(int i=0;i<data.size();i++)
        {
            list1.add(data.get(i));
        }

        final ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.textlist,list1);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}