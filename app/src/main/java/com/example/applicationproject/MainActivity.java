package com.example.applicationproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applicationproject.databinding.ActivityMainBinding;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        com.example.applicationproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ExecutorService executor = Executors.newFixedThreadPool(30);
        Runnable db = new DataBaseFill(this);
        executor.execute(db);
    }
}
