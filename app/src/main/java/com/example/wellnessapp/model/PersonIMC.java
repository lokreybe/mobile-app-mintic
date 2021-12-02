package com.example.wellnessapp.model;


public class PersonIMC {
    String date;
    byte age;
    float height;
    float weight;

    public PersonIMC() {
    }

    public PersonIMC(String date, byte age, float height, float weight) {
        this.date = date;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public float imc() {
        float imc = (float) (this.weight / Math.pow(this.height, 2));
        return imc;
    }

    public float mb(Gender gender) {
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
