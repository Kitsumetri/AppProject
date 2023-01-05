package com.example.applicationproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.applicationproject.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        com.example.applicationproject.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Parser p = new Parser();
        p.execute();

        DataBaseFill db = new DataBaseFill(this);
        db.execute();
    }
}
