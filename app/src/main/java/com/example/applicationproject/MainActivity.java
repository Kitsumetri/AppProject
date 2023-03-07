package com.example.applicationproject;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
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
            RecyclerView recyclerView = findViewById(R.id.rvProduct);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            ProductAdapter adapter = new ProductAdapter(this, value);
            recyclerView.setAdapter(adapter);
        });
    }
}
