package com.example.applicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<ProductData> productList;
    private RecyclerView recyclerView;
    private ProductAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(v -> {
            finish();
            System.exit(0);
        });

        ImageButton settings_button = findViewById(R.id.settings_button);
        settings_button.setOnClickListener(v -> setContentView(R.layout.settings_menu));

        RetrieveData retrieveData = new RetrieveData();

        retrieveData.Start(value -> {
            recyclerView = findViewById(R.id.rvProduct);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            productList = value;
            setAdapter(productList);
        });
    }

    private void setAdapter(ArrayList<ProductData> value) {
        setOnClickListener();
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), value, listener);
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new ProductAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Log.i("checkClick", "check");
                Intent intent = new Intent(getApplicationContext(), InfoProductActivity.class);
                startActivity(intent);
            }
        };
    }

}
