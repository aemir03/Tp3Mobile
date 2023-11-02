package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ConnexionActivity extends AppCompatActivity {

    private Button buttonCreationCompte;

    private void inscription(Intent intent){
        buttonCreationCompte = findViewById(R.id.buttonCreationCompte);
        buttonCreationCompte.setOnClickListener(v -> {
            startActivity(intent);
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        inscription(new Intent(this, InscriptionActivity.class));
    }
}