package com.example.applicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class InfoProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_frame);

        ImageButton button_back_to_recycle = findViewById(R.id.back_button);
        button_back_to_recycle.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RecycleViewActivity.class);
            startActivity(intent);
        });
    }
}
