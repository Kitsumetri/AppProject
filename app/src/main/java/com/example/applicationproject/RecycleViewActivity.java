package com.example.applicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

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
            finishAffinity();
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
        listener = (v, position) -> {
            AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
            animation.setDuration(100);
            v.setAlpha(1f);
            v.startAnimation(animation);

            Intent intent = new Intent(getApplicationContext(), InfoProductActivity.class);
            startActivity(intent);
        };
    }

}
