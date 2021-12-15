package com.example.wellnessapp;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.wellnessapp.model.Person;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class PopulateDatabase {
    private DummyData dummyData;
    ArrayList<Person> personList;
    private static final String TAG = "Tag";
    private static final String TAG_SUCCESS = "Success";
    private static final String TAG_ERROR = "Error";

    public PopulateDatabase() {
        dummyData = new DummyData();
    }

    public void populate() {
        //DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
        FirebaseFirestore dbInst = FirebaseFirestore.getInstance();

        for ( Person person : dummyData.loadContacts()) {
            //dbRef.child("persons").setValue(person);

            // Add a new document with a generated ID
            dbInst.collection("persons")
                    .add(person)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d(TAG_SUCCESS, "DocumentSnapshot added with ID: " + documentReference.getId());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.w(TAG_ERROR, "Error adding document", e);
                        }
                    });

        }
    }
}
