package com.example.wellnessapp.model;

import java.util.ArrayList;

public class Person {
    String firstName;
    String lastName;
    long cellphone;
    byte age;
    float height;
    float weight;
    Gender gender;
    ArrayList<PersonIMC> imcs;

    public Person() {
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

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<PersonIMC> getImcs() {
        return imcs;
    }

    public void setImcs(ArrayList<PersonIMC> imcs) {
        this.imcs = imcs;
    }

    public float imc() {
        float imc = (float) (this.weight / Math.pow(this.height, 2));
        return imc;
    }

    public float mb() {
        float mb = 0;
        if(gender == Gender.male) {
            mb = (float) ((10 * this.weight) + (6.25 * this.height*100) - (5*this.age) + 5);
        }
        if(gender == Gender.female) {
            mb = (float) ((10 * this.weight) + (6.25 * this.height*100) - (5*this.age) - 161);
        }
        return mb;
    }

}

