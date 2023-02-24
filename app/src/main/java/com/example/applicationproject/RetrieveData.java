package com.example.applicationproject;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetrieveData {

    ArrayList<ProductData> productData = new ArrayList<>();
    private DatabaseReference mDatabase;
    public void Start() {
        mDatabase = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference();
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.child("maxidom-laminat").getChildren()) {
                    ProductData value = childSnapshot.getValue(ProductData.class);
                    productData.add(value);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("firebase", "Failed to read value.", error.toException());
            }
        });
    }
}