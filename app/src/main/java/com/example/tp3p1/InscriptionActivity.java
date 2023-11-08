package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tp3p1.adapters.CustumPaysAdpter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editTextPrenom;
    private EditText editTextNom;
    private EditText editTextCourriel;
    private Spinner paysSpinner;

    private String[] paysNom = (String[]) Arrays.stream(Pays.values()).map(Enum::name).toArray(String[]::new);



    private int flags[] = {R.drawable.flag_of_algeria_svg, R.drawable.flag_of_canada_svg, R.drawable.flag_of_france};

    private void putEventIntoSpinner(){
        paysSpinner.setOnItemSelectedListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextNom = findViewById(R.id.editTextNom);
        editTextCourriel = findViewById(R.id.editTextCourriel);
        paysSpinner = findViewById(R.id.spinnerPays);

        CustumPaysAdpter custumPaysAdpter = new CustumPaysAdpter(getApplicationContext(), flags, paysNom);
        paysSpinner.setAdapter(custumPaysAdpter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        Toast.makeText(getApplicationContext(), paysNom[pos], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}