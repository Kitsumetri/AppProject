package com.example.applicationproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_menu);
        Intent intent = getIntent();

        ListView listView = findViewById(R.id.settings_list);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.options, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        ImageButton img_back = findViewById(R.id.back_button);
        img_back.setOnClickListener(v -> {
            Intent intent_back = new Intent(getApplicationContext(), RecycleViewActivity.class);
            startActivity(intent_back);
        });

    }
}

