package com.example.wellnessapp;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wellnessapp.model.Gender;
import com.example.wellnessapp.model.Person;
import com.example.wellnessapp.model.PersonIMC;

public class ImcActivity extends AppCompatActivity {

    Person person;
    PersonIMC imc;
    EditText firstName;
    EditText lastName;
    EditText age;
    EditText height;
    EditText weight ;
    Button calculate;
    TextView resultImc;
    TextView resultMb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        person = new Person();
        imc = new PersonIMC();

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        age = findViewById(R.id.age);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);

        calculate = findViewById(R.id.buttonCalculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonCalculateClicked();
            }
        });

        resultImc = findViewById(R.id.resultImc);
        resultImc.setVisibility(GONE);

        resultMb = findViewById(R.id.resultMb);
        resultMb.setVisibility(GONE);

    }

    boolean isEmpty(EditText editText) {
        CharSequence str = editText.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public void onRadioButtonGenreClicked(View view) {
        //Check if the button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check wich radio button was clicked
        switch (view.getId()) {
            case R.id.male:
                if (checked)
                    person.setGender(Gender.male);
                break;
            case R.id.female:
                if (checked)
                    person.setGender(Gender.female);
                break;
        }
    }

    public void onButtonCalculateClicked() {
        byte errors = 0;
        if (isEmpty(firstName)) {
            firstName.setError("First name is required");
            errors++;
        }
        if (isEmpty(lastName)) {
            lastName.setError("Last name is required");
            errors++;
        }
        if (isEmpty(age)) {
            age.setError("Age is required");
            errors++;
        }
        if (isEmpty(height)) {
            height.setError("Height is required");
            errors++;
        }
        if (isEmpty(weight)) {
            weight.setError("Weight is required");
            errors++;
        }
        if(errors > 0) {
            Toast t = Toast.makeText(this, "You have some invalid fields", Toast.LENGTH_SHORT);
            t.show();
            return;
        }

        person.setFirstName(firstName.getText().toString());
        person.setLastName(lastName.getText().toString());

        imc.setAge(Byte.parseByte(age.getText().toString()));
        imc.setHeight(Float.parseFloat(height.getText().toString()));
        imc.setWeight(Float.parseFloat(weight.getText().toString()));

        person.addImc(imc);

        //person.setGender(lastName.getText().toString());

        Toast t = Toast.makeText(this, "The imc is: "+imc.imc(), Toast.LENGTH_SHORT);
        t.show();

        resultImc.setText("The imc is : "+imc.imc());
        resultMb.setText("The mb is : "+imc.mb(person.getGender()));
        resultImc.setVisibility(VISIBLE);
        resultMb.setVisibility(VISIBLE);
    }
}