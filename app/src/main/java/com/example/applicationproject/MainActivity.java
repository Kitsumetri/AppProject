package com.example.applicationproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AdapterExample adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ProductData> productData = new ArrayList<>();

        for (int i = 0; i < 11; ++i) {
            ProductData p = new ProductData();
            p.setName("AMOGUS");
            productData.add(p);
            Log.i("CHECK", productData.get(i).getName());
        }

        Log.i("CHECK", String.valueOf(productData.size()));

        RecyclerView recyclerView = findViewById(R.id.rvProduct);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AdapterExample(this, productData);
        recyclerView.setAdapter(adapter);

    }
}
