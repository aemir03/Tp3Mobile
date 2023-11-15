package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tp3p1.adapters.CustumPaysAdpter;
import com.example.tp3p1.database.DatabaseManager;
import com.example.tp3p1.model.User;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;


public class InscriptionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editTextPrenom;
    private EditText editTextNom;
    private EditText editTextCourriel;
    private EditText passwordText;
    private Spinner paysSpinner;
    private ConnexionActivity connexionActivity;

    private String[] paysNom = (String[]) Arrays.stream(Pays.values()).map(Enum::name).toArray(String[]::new);

    private DatabaseManager databaseManager;
    private String paysActuel;

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
        passwordText = findViewById(R.id.editTextMotDePasse);
        connexionActivity = new ConnexionActivity();

        CustumPaysAdpter custumPaysAdpter = new CustumPaysAdpter(getApplicationContext(), flags, paysNom);
        paysSpinner.setAdapter(custumPaysAdpter);
        paysSpinner.setOnItemSelectedListener(this);
        paysSpinner.setSelection(0);

        databaseManager = new DatabaseManager( this );
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
        paysActuel = paysNom[pos];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void incription(View view) {
        String prenom = editTextPrenom.getText().toString();
        String nom = editTextNom.getText().toString();
        String courriel = editTextCourriel.getText().toString();
        String password = passwordText.getText().toString();

        if(prenom.isEmpty() || nom.isEmpty() || courriel.isEmpty() || paysActuel.isEmpty() || password.isEmpty() && !connexionActivity.validatePwd(password) && !connexionActivity.validateEmail(courriel)){
            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
        }else{

            User user = new User(prenom, nom, courriel, password, paysActuel);

            // Inscription du user
            try {
                databaseManager.insertUser(user);
                Intent connexionIntent = new Intent(this, ConnexionActivity.class);
                startActivity(connexionIntent);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Erreur lors de l'inscription", Toast.LENGTH_LONG).show();
            }
        }
    }
}