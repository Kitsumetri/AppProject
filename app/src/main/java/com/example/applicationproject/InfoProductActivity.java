package com.example.applicationproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class InfoProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_frame);
        Intent intent = getIntent();

        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(intent.getStringExtra("imageUrl")).fit().into(imageView,
                new Callback() {
                    @Override
                    public void onSuccess() {
                        Bitmap originalBitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                        Bitmap newBitmap = Bitmap.createBitmap(originalBitmap.getWidth(),
                                originalBitmap.getHeight(),
                                Bitmap.Config.ARGB_8888);

                        Canvas canvas = new Canvas(newBitmap);
                        canvas.drawBitmap(originalBitmap, 0, 0, null);

                        for (int x = 0; x < newBitmap.getWidth(); x++)
                            for (int y = 0; y < newBitmap.getHeight(); y++) {
                                int pixel = newBitmap.getPixel(x, y);

                                if (Color.red(pixel) >= 245 &&
                                        Color.green(pixel) >= 245 &&
                                        Color.blue(pixel) >= 245)
                                    newBitmap.setPixel(x, y, Color.TRANSPARENT);
                            }
                        imageView.setImageBitmap(newBitmap);
                    }
                    @Override
                    public void onError(Exception e) {}
                });

        TextView textViewText = findViewById(R.id.object_name);
        textViewText.setText(intent.getStringExtra("productName"));

        TextView textViewDescription = findViewById(R.id.object_description);
        textViewDescription.setText( intent.getStringExtra("productDescription"));
        textViewDescription.setSelected(true);

        TextView textViewPrice = findViewById(R.id.object_cost);
        textViewPrice.setText(intent.getStringExtra("productPrice"));

        RatingBar ratingBar = findViewById(R.id.object_rating);
        ratingBar.setRating(getIntent().getExtras().getFloat("Rating"));

        ImageButton img_back = findViewById(R.id.back_button);

        img_back.setOnClickListener(v -> {
            Intent intent_back = new Intent(getApplicationContext(), RecycleViewActivity.class);
            startActivity(intent_back);
        });

    }
}

