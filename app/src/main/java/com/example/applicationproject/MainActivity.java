package com.example.applicationproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applicationproject.databinding.ActivityMainBinding;

import android.os.StrictMode;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        com.example.applicationproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        DataBaseFill db = new DataBaseFill(this);
        db.run();
    }
}
