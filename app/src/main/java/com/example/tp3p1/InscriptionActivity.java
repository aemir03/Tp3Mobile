package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;



public class InscriptionActivity extends AppCompatActivity {
    private EditText editTextPrenom;
    private EditText editTextNom;
    private EditText editTextCourriel;
    private Spinner paysSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextNom = findViewById(R.id.editTextNom);
        editTextCourriel = findViewById(R.id.editTextCourriel);
        paysSpinner = findViewById(R.id.spinnerPays);

    }
}