package com.example.applicationproject;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RetrieveData {

    public interface ProductListCallback { void onCallback(ArrayList<ProductData> value); }

    public void Start(final ProductListCallback Callback) {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference();
        ArrayList<ProductData> productData = new ArrayList<>();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot childSnapshot: dataSnapshot.child("maxidom-laminat").getChildren()) {
                    ProductData value = childSnapshot.getValue(ProductData.class);
                    productData.add(value);
                }
                Callback.onCallback(productData);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) { throw error.toException(); }
        });
    }
}