package com.example.applicationproject;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu);
        // Button button = findViewById(R.id.button_back);
        // button.setOnClickListener(v -> finish());

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

//        DataBaseFill db = new DataBaseFill(this);
//        db.run();

        // RetrieveData rd = new RetrieveData();
        // rd.Start();

//          setInitialData();
//          RecyclerView recyclerView = findViewById(R.id.list);
//          StateAdapter adapter = new StateAdapter(this, states);
//         recyclerView.setAdapter(adapter);
    }
    private void setInitialData() {

        states.add(new State ("Бразилия", 100, R.drawable.icon_back));
        states.add(new State ("Аргентина", 10, R.drawable.icon_back));
    }
}
