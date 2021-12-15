package com.example.wellnessapp.model;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;

@IgnoreExtraProperties
public class Person {
    Long id;
    String firstName;
    String lastName;
    String email;
    Role role;
    Gender gender;
    long cellphone;

    ArrayList<PersonIMC> imcs;

    public Person() {
        // Default constructor required for calls to DataSnapshot.getValue(Person.class)
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, long cellphone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
    }

    public Person(String firstName, String lastName, long cellphone, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.gender = gender;
    }

    public Person(String firstName, String lastName, long cellphone, Gender gender, ArrayList<PersonIMC> imcs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellphone = cellphone;
        this.gender = gender;
        this.imcs = imcs;
    }

    public Person(String firstName, String lastName, String email, long cellphone, Gender gender, ArrayList<PersonIMC> imcs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.gender = gender;
        this.imcs = imcs;
    }

    public Person(String firstName, String lastName,  long cellphone, Gender gender, String email, Role role, ArrayList<PersonIMC> imcs) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.gender = gender;
        this.cellphone = cellphone;
        this.imcs = imcs;
    }

    @Exclude
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getCellphone() {
        return cellphone;
    }

    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Exclude
    public ArrayList<PersonIMC> getImcs() {
        return imcs;
    }

    @Exclude
    public void setImcs(ArrayList<PersonIMC> imcs) {
        this.imcs = imcs;
    }

    @Exclude
    public void addImc(PersonIMC imc) {
        this.imcs.add(imc);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public HashMap<String, Object> getMap() {
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("firstName", getFirstName());
        resultMap.put("lastName", getLastName());
        resultMap.put("gender", getGender());
        resultMap.put("cellphone", getCellphone());
        resultMap.put("email", getMap());
        resultMap.put("role", getRole());

        return resultMap;
    }
}

