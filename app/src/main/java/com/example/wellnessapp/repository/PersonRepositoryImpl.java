package com.example.wellnessapp.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.wellnessapp.model.Person;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.example.wellnessapp.interfaces.Callback;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


public class PersonRepositoryImpl implements  PersonRepository{
    private static final String TAG = "Tag";
    FirebaseFirestore dbInst = FirebaseFirestore.getInstance();
    final String COLLECTION = "persons";

    @Override
    public void create (Person person, Callback callback) {
        // Add a new document with a provided generated ID
        dbInst.collection(COLLECTION)
                .document(person.getId()+"")
                .set(person)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + person.getId());
                        callback.onSuccess(person);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void createWithoutId (Person person, Callback callback) {
        // Add a new document with a generated ID
        dbInst.collection(COLLECTION)
                .add(person)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                        callback.onSuccess(documentReference);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }


    @Override
    public void update(Person person, Callback callback) {
        // Add a new document with a generated ID
        dbInst.collection(COLLECTION)
                .document(person.getId()+"")
                .update(person.getMap())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + person.getId());
                        callback.onSuccess(person);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void delete(Person person, Callback callback) {
        // Add a new document with a generated ID
        dbInst.collection(COLLECTION)
                .document(person.getId()+"")
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "DocumentSnapshot deleted with ID: " + person.getId());
                        callback.onSuccess(null);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void findAll(Callback callback) {

    }

    @Override
    public void findById(String id, Callback callback) {
        dbInst.collection(COLLECTION)
                .whereEqualTo("id", id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                callback.onSuccess(document);
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            callback.onFailure(task.getException());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }

    @Override
    public void findByEmail(String email, Callback callback) {
        dbInst.collection(COLLECTION)
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                callback.onSuccess(document.toObject((Person.class)));
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                            callback.onFailure(task.getException());
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        callback.onFailure(e);
                    }
                });
    }

}
