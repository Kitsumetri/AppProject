package com.example.applicationproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrieveData retrieveData = new RetrieveData();

        ArrayList<ProductData> productData = new ArrayList<>();
        retrieveData.Start(value -> {
            for (ProductData p : value) {
                productData.add(new ProductData(p));
                Log.i("firebase", String.valueOf(productData));
            };
        });

        Log.i("firebase", String.valueOf(productData.size()));

        RecyclerView recyclerView = findViewById(R.id.rvProduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductAdapter(this, productData);
        recyclerView.setAdapter(adapter);
    }
}
