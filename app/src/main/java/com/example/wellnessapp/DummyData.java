package com.example.wellnessapp;

import com.example.wellnessapp.model.Gender;
import com.example.wellnessapp.model.Person;
import com.example.wellnessapp.model.PersonIMC;
import com.example.wellnessapp.model.Role;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class DummyData {

    public Person loadPerson() {
        return new Person("Joan", "Mosquera", 3162785797L, Gender.male, loadImcs());
    }

    public ArrayList<Person> loadContacts() {

        return new ArrayList<>(Arrays.asList(
                new Person("Joan", "Mosquera", 3162785797L, Gender.male, "test1@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, "test2@wellnessapp.com", Role.wellness, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, "test3@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, "test4@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, "test5@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Cristian", "Zapata", 3155967502L, Gender.male, "test6@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Joan", "Mosquera", 3162785797L, Gender.male, "test7@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, "test8@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, "test9@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Andrea", "Grajales", 3145559661L, Gender.female, "test10@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, "test11@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Julieta", "Zapata", 3155967502L, Gender.female, "test12@wellnessapp.com", Role.wellness, loadImcs()),
                new Person("Antonia", "Mosquera", 3162785797L, Gender.female, "test13@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, "test14@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Lucrecia", "Montilla", 3195759860L, Gender.female, "test15@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, "test16@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, "test17@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Cristian", "Zapata", 3155967502L, Gender.male, "test18@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, "test19@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Carolina", "Monterrosa", 3121234561L, Gender.female, "test20@wellnessapp.com", Role.wellness, loadImcs()),
                new Person("David", "Zapata", 3155967502L, Gender.male, "test21@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Abelardo", "Mosquera", 3162785797L, Gender.male, "test22@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Betty", "Jimenez", 3205137502L, Gender.female, "test23@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, "test24@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Leonardo", "Grajales", 3145559661L, Gender.male, "test25@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Lucia", "Monterrosa", 3121234561L, Gender.female, "test26@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Antonio", "Zapata", 3155967502L, Gender.male, "test27@wellnessapp.com", Role.wellness, loadImcs()),
                new Person("Valentina", "Mosquera", 3162785797L, Gender.female, "test28@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Josefina", "Jimenez", 3205137502L, Gender.female, "test29@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Julian", "Montilla", 3195759860L, Gender.male, "test30@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Laura", "Grajales", 3145559661L, Gender.female, "test31@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Diana", "Monterrosa", 3121234561L, Gender.female, "test32@wellnessapp.com", Role.universityCommunity, loadImcs()),
                new Person("Maria", "Zapata", 3155967502L, Gender.female, "test33@wellnessapp.com", Role.universityCommunity, loadImcs())
        ));
    }

    private Date getDate(String dateString) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private ArrayList<PersonIMC> loadImcs() {
        // DateFormat cal = DateFormat.getInstance();
        // SimpleDateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new ArrayList<>(Arrays.asList(
                new PersonIMC("30/11/2005", (byte) 16, (float) 1.60, 50),
                new PersonIMC("30/11/2006", (byte) 17, (float) 1.62, 52),
                new PersonIMC("30/11/2007", (byte) 18, (float) 1.64, 54),
                new PersonIMC("30/11/2008", (byte) 19, (float) 1.66, 56),
                new PersonIMC("30/11/2009", (byte) 20, (float) 1.68, 58),
                new PersonIMC("30/11/2010", (byte) 21, (float) 1.70, 60),
                new PersonIMC("30/11/2011", (byte) 22, (float) 1.72, 62),
                new PersonIMC("30/11/2012", (byte) 23, (float) 1.74, 64),
                new PersonIMC("30/11/2013", (byte) 24, (float) 1.76, 66),
                new PersonIMC("30/11/2014", (byte) 25, (float) 1.78, 68),
                new PersonIMC("30/11/2015", (byte) 26, (float) 1.80, 70),
                new PersonIMC("30/11/2016", (byte) 27, (float) 1.82, 72),
                new PersonIMC("30/11/2017", (byte) 28, (float) 1.84, 74),
                new PersonIMC("30/11/2018", (byte) 29, (float) 1.85, 76),
                new PersonIMC("30/11/2019", (byte) 30, (float) 1.85, 78)
        ));
    }


}
