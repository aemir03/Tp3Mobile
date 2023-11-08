package com.example.tp3p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConnexionActivity extends AppCompatActivity {

    private Button buttonCreationCompte;
    private TextInputEditText pwdInput;
    private TextInputEditText emailInput;
    private Pattern emailPattern;

    private void inscription(Intent intent){
        buttonCreationCompte = findViewById(R.id.buttonCreationCompte);
        buttonCreationCompte.setOnClickListener(v -> {
            startActivity(intent);
        });
    }


    private boolean validatePwd(String pwd){
        return pwd.length() > 5;
    }
    private boolean validateEmail(String email){
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(getResources().getString(R.string.regexForMail), Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
    private void watcherTxt(TextInputEditText input){
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!validateEmail(editable.toString())){
                    emailInput.setError(getResources().getString(R.string.noValideMail));
                }
                if(!validatePwd(editable.toString())){
                    pwdInput.setError(getResources().getString(R.string.noValidePwd));
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        inscription(new Intent(this, InscriptionActivity.class));
        emailPattern  = Pattern.compile(getResources().getString(R.string.regexForMail));
        emailInput = findViewById(R.id.courrielInput);
        pwdInput = findViewById(R.id.pwdInput);

        watcherTxt(emailInput);
        watcherTxt(pwdInput);

    }
}