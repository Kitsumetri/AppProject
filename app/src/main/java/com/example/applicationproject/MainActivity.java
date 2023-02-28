package com.example.applicationproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrieveData retrieveData = new RetrieveData();

        retrieveData.Start(value -> {
            RecyclerView recyclerView = findViewById(R.id.rvProduct);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            ProductAdapter adapter = new ProductAdapter(this, value);
            recyclerView.setAdapter(adapter);
        });
    }
}
