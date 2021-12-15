package com.example.wellnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wellnessapp.interfaces.Callback;
import com.example.wellnessapp.model.Person;
import com.example.wellnessapp.repository.PersonRepository;
import com.example.wellnessapp.repository.PersonRepositoryImpl;


public class RolActivity extends AppCompatActivity {

    private static final String TAG = "Tag";
    Button search;
    TextView emailTextView;
    TextView resultTextView;
    PersonRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rol);
        emailTextView = this.findViewById(R.id.email);
        resultTextView= this.findViewById(R.id.resultTextView);
        search = findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonSearchClicked();
            }
        });

    }

    private void onButtonSearchClicked() {

        String email = emailTextView.getText().toString();
        //repository = new PersonRepositoryImpl();
        try {
            repository = new PersonRepositoryImpl();
            repository.findByEmail(email, new Callback() {
                @Override
                public void onSuccess(Object object) {
                    resultTextView.setText(((Person) object).getRole().toString());
                    //resultTextView.setText("Encontrado");
                }
                @Override
                public void onFailure(Object object) {
                    resultTextView.setText("No encontrado");
                }
            });
        } catch (Exception e) {
            resultTextView.setText(e.getMessage());
            e.printStackTrace();
        }


    }
}