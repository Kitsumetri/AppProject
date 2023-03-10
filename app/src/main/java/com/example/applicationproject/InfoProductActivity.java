package com.example.applicationproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class InfoProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_frame);
        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(intent.getStringExtra("imageUrl")).fit().into(imageView);

        TextView textViewText = findViewById(R.id.object_name);
        textViewText.setText(intent.getStringExtra("productName"));

        TextView textViewDescription = findViewById(R.id.object_description);
        textViewDescription.setText( intent.getStringExtra("productDescription"));
        textViewDescription.setMovementMethod(new ScrollingMovementMethod());
        textViewDescription.setSelected(true);

        TextView textViewInStore = findViewById(R.id.object_in_store);
        textViewInStore.setText(intent.getStringExtra("inStore"));

        TextView textViewPrice = findViewById(R.id.object_cost);
        textViewPrice.setText(intent.getStringExtra("productPrice"));

        RatingBar ratingBar = findViewById(R.id.object_rating);
        ratingBar.setRating(getIntent().getExtras().getFloat("Rating"));

        ImageButton img = findViewById(R.id.back_button);

        img.setOnClickListener(v -> {
            Intent intent_back = new Intent(getApplicationContext(), RecycleViewActivity.class);
            startActivity(intent_back);
        });

    }
}

