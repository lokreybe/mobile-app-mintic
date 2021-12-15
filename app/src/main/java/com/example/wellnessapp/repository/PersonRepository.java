package com.example.wellnessapp.repository;

import com.example.wellnessapp.model.Person;

import com.example.wellnessapp.interfaces.Callback;

public interface PersonRepository {
    public void create (Person person, Callback callback);
    public void createWithoutId (Person person, Callback callback);
    public void update (Person person, Callback callback);
    public void delete (Person person, Callback callback);
    public void findAll (Callback callback);
    public void findById (String id, Callback callback);
    public void findByEmail (String email, Callback callback);
}
