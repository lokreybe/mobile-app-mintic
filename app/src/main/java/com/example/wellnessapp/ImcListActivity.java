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
import com.example.wellnessapp.model.Role;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class ImcListActivity extends AppCompatActivity {

    private long cellphone;
    private DummyData dummyData;

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

        // Creamos el objeto con la data
        dummyData = new DummyData();

        // Leemos la información del usuario
        Person mySelf = dummyData.loadPerson();

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