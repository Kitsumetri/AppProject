package com.example.applicationproject;


import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RetrieveData {

    private DatabaseReference mDatabase;
    public void Start() {
        // Get a reference to our posts
//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("server/saving-data/fireblog/posts");
//
//        ref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                ProductData post = dataSnapshot.getValue(ProductData.class);
//                System.out.println(post);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                System.out.println("The read failed: " + databaseError.getCode());
//            }

        mDatabase = FirebaseDatabase.getInstance("https://hse-project-ee9a9-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        mDatabase.child("maxidom-dveri").get();

//        for (DataSnapshot child : ds.getChildren()) {
//            String key_id = child.getKey();
////            mDatabase.child("maxidom-dveri").child(key_id).child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
////                @Override
////                public void onComplete(@NonNull Task<DataSnapshot> task) {
////                    if (!task.isSuccessful()) {
////                        Log.e("firebase", "Error getting data", task.getException());
////                    }
////                    else {
////                        Log.d("firebase", String.valueOf(task.getResult().getValue()));
////                    }
////                }
////            });
//            Log.i("fireabase", key_id);
//        }


//        mDatabase.child("maxidom-dveri").child("-NNWIYUmftjlzyIh0jnW").child("name").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DataSnapshot> task) {
//                if (!task.isSuccessful()) {
//                    Log.e("firebase", "Error getting data", task.getException());
//                }
//                else {
//                    Log.d("firebase", String.valueOf(task.getResult().getValue()));
//                }
//            }
//        });
    }
}
