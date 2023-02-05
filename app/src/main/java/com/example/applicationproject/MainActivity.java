package com.example.applicationproject;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);
        Button button = findViewById(R.id.button_back);
        button.setOnClickListener(v -> finish());

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

//        DataBaseFill db = new DataBaseFill(this);
//        db.run();

        RetrieveData rd = new RetrieveData();
        rd.Start();
    }
}
