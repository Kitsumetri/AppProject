package com.example.applicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {


    private ArrayList<ProductData> productList;

    private SearchView searchView;
    private RecyclerView recyclerView;
    private ProductAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);

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
            int numberOfColumns = 2;
            recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
//            new GridLayoutManager(this, numberOfColumns)
//            new LinearLayoutManager(this)
            productList = value;
            setAdapter(productList);
        });
    }

    private void setAdapter(ArrayList<ProductData> value) {
        setOnClickListener();
        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), value, listener);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return false; }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = (v, productData) -> {
            AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
            animation.setDuration(100);
            v.setAlpha(1f);
            v.startAnimation(animation);

            Intent intent = new Intent(getApplicationContext(), InfoProductActivity.class);

            intent.putExtra("imageUrl", productData.getItemSourceLink());
            intent.putExtra("productName", productData.getName());
            intent.putExtra("productDescription", productData.getDescription());
            intent.putExtra("inStore", productData.isInStore());
            intent.putExtra("productPrice", productData.getPrice());
            intent.putExtra("Rating", productData.getRating());

            startActivity(intent);
        };
    }
}