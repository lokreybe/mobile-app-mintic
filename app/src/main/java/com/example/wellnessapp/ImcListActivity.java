package com.example.wellnessapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wellnessapp.adapters.PersonIMCAdapterRecycler;
import com.example.wellnessapp.model.Gender;
import com.example.wellnessapp.model.Person;
import com.example.wellnessapp.model.PersonIMC;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ImcListActivity extends AppCompatActivity {

    private long cellphone;

    private final ActivityResultLauncher<String> requestPermissionCall =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    callContact();
                } else {
                    Toast.makeText(ImcListActivity.this, "No se pudo realizar la llamada", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_list);

        // Leemos la información del usuario
        Person mySelf = loadPerson();

        // Seteamos los datos básicos de la persona en la vista
        TextView firstNameTextView = this.findViewById(R.id.firstNameTextView);
        firstNameTextView.setText(mySelf.getFirstName());

        TextView lastNameTextView = this.findViewById(R.id.lastNameTextView);
        lastNameTextView.setText(mySelf.getLastName());

        TextView cellphoneTextView = this.findViewById(R.id.cellphoneTextView);
        cellphoneTextView.setText(Long.toString(mySelf.getCellphone()));


        // Llenamos el RecyclerView de los registros de IMC que tiene el usuario
        PersonIMCAdapterRecycler personIMCListAdapter = new PersonIMCAdapterRecycler( this,
                R.layout.person_imc_card_view_item, mySelf,
                cellphone -> {
                    ImcListActivity.this.cellphone = cellphone;
                    callContact();
                }
        );

        RecyclerView imcList = findViewById(R.id.recyclerViewNames);
        imcList.setAdapter(personIMCListAdapter);
        imcList.setLayoutManager(new LinearLayoutManager(this));
        imcList.setHasFixedSize(true);
    }

    private Person loadPerson() {
        return new Person("Joan", "Mosquera", 3162785797L, Gender.male, loadImcs());
    }

    private ArrayList<Person> loadContacts() {

        return new ArrayList<>(Arrays.asList(
                new Person("Joan", "Mosquera", 3162785797L, Gender.male, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, loadImcs()),
                new Person("Cristian", "Zapata", 3155967502L, Gender.male, loadImcs()),
                new Person("Joan", "Mosquera", 3162785797L, Gender.male, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, loadImcs()),
                new Person("Andrea", "Grajales", 3145559661L, Gender.female, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, loadImcs()),
                new Person("Julieta", "Zapata", 3155967502L, Gender.female, loadImcs()),
                new Person("Antonia", "Mosquera", 3162785797L, Gender.female, loadImcs()),
                new Person("Pedro", "Jimenez", 3205137502L, Gender.male, loadImcs()),
                new Person("Lucrecia", "Montilla", 3195759860L, Gender.female, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, loadImcs()),
                new Person("Andres", "Monterrosa", 3121234561L, Gender.male, loadImcs()),
                new Person("Cristian", "Zapata", 3155967502L, Gender.male, loadImcs()),
                new Person("Carlos", "Grajales", 3145559661L, Gender.male, loadImcs()),
                new Person("Carolina", "Monterrosa", 3121234561L, Gender.female, loadImcs()),
                new Person("David", "Zapata", 3155967502L, Gender.male, loadImcs()),
                new Person("Abelardo", "Mosquera", 3162785797L, Gender.male, loadImcs()),
                new Person("Betty", "Jimenez", 3205137502L, Gender.female, loadImcs()),
                new Person("Jose", "Montilla", 3195759860L, Gender.male, loadImcs()),
                new Person("Leonardo", "Grajales", 3145559661L, Gender.male, loadImcs()),
                new Person("Lucia", "Monterrosa", 3121234561L, Gender.female, loadImcs()),
                new Person("Antonio", "Zapata", 3155967502L, Gender.male, loadImcs()),
                new Person("Valentina", "Mosquera", 3162785797L, Gender.female, loadImcs()),
                new Person("Josefina", "Jimenez", 3205137502L, Gender.female, loadImcs()),
                new Person("Julian", "Montilla", 3195759860L, Gender.male, loadImcs()),
                new Person("Laura", "Grajales", 3145559661L, Gender.female, loadImcs()),
                new Person("Diana", "Monterrosa", 3121234561L, Gender.female, loadImcs()),
                new Person("Maria", "Zapata", 3155967502L, Gender.female, loadImcs())
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

    private boolean checkCallingPermission () {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) ==
                PackageManager.PERMISSION_GRANTED;
    }

    private void callContact() {
        if (!checkCallingPermission()) {
            //Toast.makeText(this, "No se puede realizar la llamada", Toast.LENGTH_SHORT).show();
            requestPermissionCall.launch(Manifest.permission.CALL_PHONE);
            //return;
        } else {
            Uri cellphoneUri = Uri.parse("tel:"+cellphone);
            //Intent intent = new Intent(Intent.ACTION_DIAL, cellphoneUri);
            Intent intent = new Intent(Intent.ACTION_CALL, cellphoneUri);
            startActivity(intent);
        }
    }
}